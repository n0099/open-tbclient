package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
final class c extends b {
    private static Class mFJ;
    private final Object mFK = dDp();
    private final Field mFL = dDq();

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
        if (this.mFK != null && this.mFL != null) {
            try {
                mFJ.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.mFK, accessibleObject, Long.valueOf(((Long) mFJ.getMethod("objectFieldOffset", Field.class).invoke(this.mFK, this.mFL)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dDp() {
        try {
            mFJ = Class.forName("sun.misc.Unsafe");
            Field declaredField = mFJ.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dDq() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
