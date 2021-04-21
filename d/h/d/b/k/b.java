package d.h.d.b.k;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f67253a;

    static {
        f67253a = d.h.d.b.c.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f67253a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
