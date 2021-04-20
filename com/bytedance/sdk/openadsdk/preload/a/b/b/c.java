package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public static Class f29689a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f29690b = b();

    /* renamed from: c  reason: collision with root package name */
    public final Field f29691c = c();

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
        if (this.f29690b != null && this.f29691c != null) {
            try {
                f29689a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f29690b, accessibleObject, Long.valueOf(((Long) f29689a.getMethod("objectFieldOffset", Field.class).invoke(this.f29690b, this.f29691c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f29689a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
