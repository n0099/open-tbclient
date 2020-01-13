package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
final class c extends b {
    private static Class mMw;
    private final Object mMx = dAa();
    private final Field mMy = dAb();

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
        if (this.mMx != null && this.mMy != null) {
            try {
                mMw.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.mMx, accessibleObject, Long.valueOf(((Long) mMw.getMethod("objectFieldOffset", Field.class).invoke(this.mMx, this.mMy)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dAa() {
        try {
            mMw = Class.forName("sun.misc.Unsafe");
            Field declaredField = mMw.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dAb() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
