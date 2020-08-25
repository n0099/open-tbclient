package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
final class c extends b {
    private static Class nFB;
    private final Object nFC = dXG();
    private final Field nFD = dXH();

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
        if (this.nFC != null && this.nFD != null) {
            try {
                nFB.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.nFC, accessibleObject, Long.valueOf(((Long) nFB.getMethod("objectFieldOffset", Field.class).invoke(this.nFC, this.nFD)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dXG() {
        try {
            nFB = Class.forName("sun.misc.Unsafe");
            Field declaredField = nFB.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dXH() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
