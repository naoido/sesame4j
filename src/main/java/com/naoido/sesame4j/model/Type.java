package com.naoido.sesame4j.model;

public enum Type {
    NONE("none"),
    BLE_LOCK("ble lock"),
    BLE_UNLOCK("ble unlock"),
    TIME_CHANGED("time changed"),
    AUTO_LOCK_UPDATED("auto lock updated"),
    MECH_SETTING_UPDATED("mech setting updated"),
    AUTO_LOCK("auto lock"),
    MANUAL_LOCKED("manual locked"),
    MANUAL_UNLOCKED("manual unlocked"),
    MANUAL_ELSE("manual else"),
    DRIVE_LOCKED("drive locked"),
    DRIVE_UNLOCKED("drive unlocked"),
    DRIVE_FAILED("drive failed"),
    BLE_ADV_PARAMETER_UPDATED("ble adv parameter updated");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }

    public static String getDescription(int typeId) {
        if (values().length < typeId) return null;
        return values()[typeId].type;
    }

    public static Type getType(int typeId) {
        return values()[typeId];
    }
}
