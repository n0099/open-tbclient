package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
final class c extends b {
    private static Class pKM;
    private final Object pKN = ezs();
    private final Field pKO = ezt();

    @Override // com.google.gson.internal.a.b
    public void c(AccessibleObject accessibleObject) {
        if (!d(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    boolean d(AccessibleObject accessibleObject) {
        if (this.pKN != null && this.pKO != null) {
            try {
                pKM.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pKN, accessibleObject, Long.valueOf(((Long) pKM.getMethod("objectFieldOffset", Field.class).invoke(this.pKN, this.pKO)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object ezs() {
        try {
            pKM = Class.forName("sun.misc.Unsafe");
            Field declaredField = pKM.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field ezt() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
