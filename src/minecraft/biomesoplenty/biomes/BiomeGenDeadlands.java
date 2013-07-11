package biomesoplenty.biomes;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.Blocks;
import biomesoplenty.configuration.BOPConfiguration;
import biomesoplenty.worldgen.WorldGenDeadlands;

public class BiomeGenDeadlands extends BiomeGenBase
{
	private WorldGenerator theWorldGenerator;
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenDeadlands(int par1)
	{
		super(par1);
		topBlock = (byte)Blocks.ash.get().blockID;
		fillerBlock = (byte)Blocks.ash.get().blockID;
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = -999;
		customBiomeDecorator.grassPerChunk = 15;
		customBiomeDecorator.flowersPerChunk = -999;
		customBiomeDecorator.mushroomsPerChunk = -999;
		customBiomeDecorator.sandPerChunk = -999;
		customBiomeDecorator.sandPerChunk2 = -999;
		customBiomeDecorator.lavaLakesPerChunk = 25;
		customBiomeDecorator.smolderingGrassPerChunk = 5;
		customBiomeDecorator.generatePits = true;
		waterColorMultiplier = 16711680;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 30, 1, 7));
		spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
		theWorldGenerator = new WorldGenMinable(Block.silverfish.blockID, 8);
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return new WorldGenDeadlands();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 3 + par2Random.nextInt(6);
		int var6;
		int var7;
		int var8;

		for (var5 = 0; var5 < 7; ++var5)
		{
			var6 = par3 + par2Random.nextInt(16);
			var7 = par2Random.nextInt(64);
			var8 = par4 + par2Random.nextInt(16);
			theWorldGenerator.generate(par1World, par2Random, var6, var7, var8);
		}
	}

	/**
	 * takes temperature, returns color
	 */
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 if (BOPConfiguration.skyColors)
			 return 4464929;
		 else
		 {
			 par1 /= 3.0F;

			 if (par1 < -1.0F)
			 {
				 par1 = -1.0F;
			 }

			 if (par1 > 1.0F)
			 {
				 par1 = 1.0F;
			 }

			 return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
		 }
	 }
}
