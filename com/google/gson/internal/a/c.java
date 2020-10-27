package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes17.dex */
final class c extends b {
    private static Class oWx;
    private final Object oWy = epy();
    private final Field oWz = epz();

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
        if (this.oWy != null && this.oWz != null) {
            try {
                oWx.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.oWy, accessibleObject, Long.valueOf(((Long) oWx.getMethod("objectFieldOffset", Field.class).invoke(this.oWy, this.oWz)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object epy() {
        try {
            oWx = Class.forName("sun.misc.Unsafe");
            Field declaredField = oWx.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field epz() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
