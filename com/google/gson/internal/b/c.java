package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
final class c extends b {
    private static Class nFT;
    private final Object nFU = dXP();
    private final Field nFV = dXQ();

    @Override // com.google.gson.internal.b.b
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
        if (this.nFU != null && this.nFV != null) {
            try {
                nFT.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.nFU, accessibleObject, Long.valueOf(((Long) nFT.getMethod("objectFieldOffset", Field.class).invoke(this.nFU, this.nFV)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dXP() {
        try {
            nFT = Class.forName("sun.misc.Unsafe");
            Field declaredField = nFT.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dXQ() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
