package micdoodle8.mods.galacticraft.core;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCCoreContainerTankRefill extends Container
{
	public GCCoreContainerTankRefill(InventoryPlayer par1InventoryPlayer, GCCoreInventoryTankRefill inventorytankrefill) 
	{
        this.addSlotToContainer(new GCCoreSlotTankRefill(inventorytankrefill, 0, 44, 47));
		int var6;
        int var7;

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1)
	{
		return true;
	}

	@Override
    public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par1)
    {
        ItemStack stack = null;
        Slot slotObj = (Slot)this.inventorySlots.get(par1);

        if (slotObj != null && slotObj.getHasStack())
        {
        	ItemStack stackInSlot = slotObj.getStack();
        	stack = stackInSlot.copy();
            
            if (par1 == 0)
            {
            	if (!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true)) 
            	{
            		return null;
            	}
            }
            else if (!mergeItemStack(stackInSlot, 0, 1, false))
            {
            	return null;
            }
            
            if (stackInSlot.stackSize == 0)
            {
            	slotObj.putStack(null);
            }
            else
            {
            	slotObj.onSlotChanged();
            }
        }
        
    	return null;
    }
}