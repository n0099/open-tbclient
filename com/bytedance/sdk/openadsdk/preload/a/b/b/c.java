package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public static Class f30604a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f30605b = b();

    /* renamed from: c  reason: collision with root package name */
    public final Field f30606c = c();

    public static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.b.b.b
    public void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    public boolean b(AccessibleObject accessibleObject) {
        if (this.f30605b != null && this.f30606c != null) {
            try {
                f30604a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f30605b, accessibleObject, Long.valueOf(((Long) f30604a.getMethod("objectFieldOffset", Field.class).invoke(this.f30605b, this.f30606c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f30604a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
