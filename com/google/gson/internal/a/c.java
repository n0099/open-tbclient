package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes17.dex */
final class c extends b {
    private static Class pfS;
    private final Object pfT = etn();
    private final Field pfU = eto();

    @Override // com.google.gson.internal.a.b
    public void b(AccessibleObject accessibleObject) {
        if (!c(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    boolean c(AccessibleObject accessibleObject) {
        if (this.pfT != null && this.pfU != null) {
            try {
                pfS.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pfT, accessibleObject, Long.valueOf(((Long) pfS.getMethod("objectFieldOffset", Field.class).invoke(this.pfT, this.pfU)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object etn() {
        try {
            pfS = Class.forName("sun.misc.Unsafe");
            Field declaredField = pfS.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field eto() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
