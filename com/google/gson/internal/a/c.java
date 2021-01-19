package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
final class c extends b {
    private static Class pKN;
    private final Object pKO = ezs();
    private final Field pKP = ezt();

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
        if (this.pKO != null && this.pKP != null) {
            try {
                pKN.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pKO, accessibleObject, Long.valueOf(((Long) pKN.getMethod("objectFieldOffset", Field.class).invoke(this.pKO, this.pKP)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object ezs() {
        try {
            pKN = Class.forName("sun.misc.Unsafe");
            Field declaredField = pKN.getDeclaredField("theUnsafe");
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
