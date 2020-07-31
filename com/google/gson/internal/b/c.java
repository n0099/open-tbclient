package com.google.gson.internal.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
final class c extends b {
    private static Class nlI;
    private final Object nlJ = dLE();
    private final Field nlK = dLF();

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
        if (this.nlJ != null && this.nlK != null) {
            try {
                nlI.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.nlJ, accessibleObject, Long.valueOf(((Long) nlI.getMethod("objectFieldOffset", Field.class).invoke(this.nlJ, this.nlK)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object dLE() {
        try {
            nlI = Class.forName("sun.misc.Unsafe");
            Field declaredField = nlI.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field dLF() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
