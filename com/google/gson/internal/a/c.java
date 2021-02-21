package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
final class c extends b {
    private static Class pVs;
    private final Object pVt = eBS();
    private final Field pVu = eBT();

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
        if (this.pVt != null && this.pVu != null) {
            try {
                pVs.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pVt, accessibleObject, Long.valueOf(((Long) pVs.getMethod("objectFieldOffset", Field.class).invoke(this.pVt, this.pVu)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object eBS() {
        try {
            pVs = Class.forName("sun.misc.Unsafe");
            Field declaredField = pVs.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field eBT() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
