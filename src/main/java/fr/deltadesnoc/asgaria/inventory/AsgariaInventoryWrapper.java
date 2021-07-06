package fr.deltadesnoc.asgaria.inventory;

import fr.deltadesnoc.asgaria.capabilities.IAsgariaItemHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class AsgariaInventoryWrapper implements IInventory {
    final IAsgariaItemHandler handler;

    final EntityPlayer player;

    public AsgariaInventoryWrapper(IAsgariaItemHandler handler) {
        this.handler = handler;
        this.player = null;
    }

    public AsgariaInventoryWrapper(IAsgariaItemHandler handler, EntityPlayer player) {
        this.handler = handler;
        this.player = player;
    }

    public String getName() {
        return "AsgariaInventory";
    }

    public boolean hasCustomName() {
        return false;
    }

    public ITextComponent getDisplayName() {
        return (ITextComponent)new TextComponentString(getName());
    }

    public int getSizeInventory() {
        return this.handler.getSlots();
    }

    public boolean isEmpty() {
        return false;
    }

    public ItemStack getStackInSlot(int index) {
        return this.handler.getStackInSlot(index);
    }

    public ItemStack decrStackSize(int index, int count) {
        return this.handler.extractItem(index, count, false);
    }

    public ItemStack removeStackFromSlot(int index) {
        ItemStack out = getStackInSlot(index);
        this.handler.setStackInSlot(index, ItemStack.EMPTY);
        return out;
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        this.handler.setStackInSlot(index, stack);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void markDirty() {}

    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    public void openInventory(EntityPlayer player) {}

    public void closeInventory(EntityPlayer player) {}

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return this.handler.isItemValidForSlot(index, stack, (EntityLivingBase)this.player);
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {}

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
        for (int i = 0; i < getSizeInventory(); i++)
            setInventorySlotContents(i, ItemStack.EMPTY);
    }
}
