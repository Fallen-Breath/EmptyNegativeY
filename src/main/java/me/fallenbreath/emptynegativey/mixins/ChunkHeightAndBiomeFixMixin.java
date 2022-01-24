package me.fallenbreath.emptynegativey.mixins;

import net.minecraft.datafixer.fix.ChunkHeightAndBiomeFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ChunkHeightAndBiomeFix.class)
public abstract class ChunkHeightAndBiomeFixMixin
{
	@ModifyArg(
			method = "fixLevel",
			slice = @Slice(
					from = @At(
							value = "INVOKE",
							target = "Lnet/minecraft/datafixer/fix/ProtoChunkTickListFix$class_6741;method_39265(III)Lcom/mojang/serialization/Dynamic;",
							ordinal = 0
					),
					to = @At(
							value = "INVOKE",
							target = "Ljava/util/BitSet;set(I)V",
							ordinal = 0
					)
			),
			at = @At(
					value = "INVOKE",
					target = "Ljava/lang/String;equals(Ljava/lang/Object;)Z"
			),
			allow = 2,
			require = 2,
			index = 0
	)
	private static Object ItIsAlwaysAirLikeASkyBlockSoNoNegativeYGenerationWillHappenHere(Object value)
	{
		return "minecraft:air";
	}
}
