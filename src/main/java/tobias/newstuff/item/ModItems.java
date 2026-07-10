package tobias.newstuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import tobias.newstuff.NewStuff;

public class ModItems {
    public static void registerModItems(){
        NewStuff.LOGGER.info("Registering Mod Items for " + NewStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(STEEL);
        });
    }

    private static Item registerItem(String name, Item.Settings settings){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NewStuff.MOD_ID, name));
        Item item = new Item(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }

    public static final Item STEEL = registerItem("steel", new Item.Settings());
}
