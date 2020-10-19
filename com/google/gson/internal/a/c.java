package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes17.dex */
final class c extends b {
    private static Class ofi;
    private final Object ofj = efy();
    private final Field ofk = efz();

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
        if (this.ofj != null && this.ofk != null) {
            try {
                ofi.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.ofj, accessibleObject, Long.valueOf(((Long) ofi.getMethod("objectFieldOffset", Field.class).invoke(this.ofj, this.ofk)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object efy() {
        try {
            ofi = Class.forName("sun.misc.Unsafe");
            Field declaredField = ofi.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field efz() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
