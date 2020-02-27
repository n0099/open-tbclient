package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
final class c extends b {
    private static Class mNe;
    private final Object mNf = dBi();
    private final Field mNg = dBj();

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
        if (this.mNf != null && this.mNg != null) {
            try {
                mNe.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.mNf, accessibleObject, Long.valueOf(((Long) mNe.getMethod("objectFieldOffset", Field.class).invoke(this.mNf, this.mNg)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dBi() {
        try {
            mNe = Class.forName("sun.misc.Unsafe");
            Field declaredField = mNe.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dBj() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
