package fr.deltadesnoc.asgaria.packets;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("runes".toLowerCase());

    public static void init(){
        INSTANCE.registerMessage(PacketOpenPlayerRuneInventory.class, PacketOpenPlayerRuneInventory.class, 0, Side.SERVER);
        INSTANCE.registerMessage(PacketOpenNormalInventory.class, PacketOpenNormalInventory.class, 1, Side.SERVER);
        INSTANCE.registerMessage(PacketSync.Handler.class, PacketSync.class, 2, Side.CLIENT);
    }

}
