package com.funcsheep.egafixer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("egafixer")
public class egafixer {

    public static final String MOD_ID = "egafixer";
    public static final Logger LOGGER = LogManager.getLogger();

    public egafixer() {
        LOGGER.info("Enchanted Golden Apple Fixer mod loading!");
        MinecraftForge.EVENT_BUS.register(this);
    }
}
