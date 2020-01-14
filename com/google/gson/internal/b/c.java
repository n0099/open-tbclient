package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
final class c extends b {
    private static Class mMB;
    private final Object mMC = dAc();
    private final Field mMD = dAd();

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
        if (this.mMC != null && this.mMD != null) {
            try {
                mMB.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.mMC, accessibleObject, Long.valueOf(((Long) mMB.getMethod("objectFieldOffset", Field.class).invoke(this.mMC, this.mMD)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dAc() {
        try {
            mMB = Class.forName("sun.misc.Unsafe");
            Field declaredField = mMB.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dAd() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
