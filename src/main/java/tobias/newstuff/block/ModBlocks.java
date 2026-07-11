package tobias.newstuff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tobias.newstuff.NewStuff;

public class ModBlocks {
    public static void registerModBlocks(){
        NewStuff.LOGGER.info("Registering Mod Blocks for " + NewStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.STEEL_BLOCK);
        });
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NewStuff.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings()
                .registryKey(key)
                .useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, key, item);
    }

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NewStuff.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    public static final Block STEEL_BLOCK = registerBlock("steel_block", AbstractBlock.Settings.create()
            .strength(5f, 10f)
            .requiresTool()
            .sounds(BlockSoundGroup.IRON)
    );
}
