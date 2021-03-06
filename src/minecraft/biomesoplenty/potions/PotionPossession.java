package biomesoplenty.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionPossession extends Potion
{
	public PotionPossession(int par1, boolean par2, int par3)
	{
		super(par1, par2, par3);
		this.setIconIndex(1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.func_110577_a(new ResourceLocation("biomesoplenty:textures/potions/BOPPotionFX.png"));
		return 2;
	}

	@Override
	public boolean isReady(int par1, int par2)
	{
		return par1 >= 1;
	}
}
