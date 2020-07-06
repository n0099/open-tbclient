package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
final class c extends b {
    private static Class ncY;
    private final Object ncZ = dIj();
    private final Field nda = dIk();

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
        if (this.ncZ != null && this.nda != null) {
            try {
                ncY.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.ncZ, accessibleObject, Long.valueOf(((Long) ncY.getMethod("objectFieldOffset", Field.class).invoke(this.ncZ, this.nda)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dIj() {
        try {
            ncY = Class.forName("sun.misc.Unsafe");
            Field declaredField = ncY.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dIk() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
