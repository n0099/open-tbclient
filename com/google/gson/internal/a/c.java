package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes23.dex */
final class c extends b {
    private static Class nPP;
    private final Object nPQ = ebN();
    private final Field nPR = ebO();

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
        if (this.nPQ != null && this.nPR != null) {
            try {
                nPP.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.nPQ, accessibleObject, Long.valueOf(((Long) nPP.getMethod("objectFieldOffset", Field.class).invoke(this.nPQ, this.nPR)).longValue()), true);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static Object ebN() {
        try {
            nPP = Class.forName("sun.misc.Unsafe");
            Field declaredField = nPP.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static Field ebO() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
