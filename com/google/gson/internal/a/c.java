package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
final class c extends b {
    private static Class pwG;
    private final Object pwH = eyU();
    private final Field pwI = eyV();

    @Override // com.google.gson.internal.a.b
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
        if (this.pwH != null && this.pwI != null) {
            try {
                pwG.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pwH, accessibleObject, Long.valueOf(((Long) pwG.getMethod("objectFieldOffset", Field.class).invoke(this.pwH, this.pwI)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object eyU() {
        try {
            pwG = Class.forName("sun.misc.Unsafe");
            Field declaredField = pwG.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field eyV() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
