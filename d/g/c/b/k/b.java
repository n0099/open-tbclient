package d.g.c.b.k;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f66113a;

    static {
        f66113a = d.g.c.b.c.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f66113a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
