package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
final class c extends b {
    private static Class pNF;
    private final Object pNG = eCG();
    private final Field pNH = eCH();

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
        if (this.pNG != null && this.pNH != null) {
            try {
                pNF.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.pNG, accessibleObject, Long.valueOf(((Long) pNF.getMethod("objectFieldOffset", Field.class).invoke(this.pNG, this.pNH)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object eCG() {
        try {
            pNF = Class.forName("sun.misc.Unsafe");
            Field declaredField = pNF.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field eCH() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
