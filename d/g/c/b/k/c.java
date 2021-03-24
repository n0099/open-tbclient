package d.g.c.b.k;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public final class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public static Class f66113d;

    /* renamed from: b  reason: collision with root package name */
    public final Object f66114b = d();

    /* renamed from: c  reason: collision with root package name */
    public final Field f66115c = c();

    public static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f66113d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // d.g.c.b.k.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    public boolean e(AccessibleObject accessibleObject) {
        if (this.f66114b != null && this.f66115c != null) {
            try {
                f66113d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f66114b, accessibleObject, Long.valueOf(((Long) f66113d.getMethod("objectFieldOffset", Field.class).invoke(this.f66114b, this.f66115c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
