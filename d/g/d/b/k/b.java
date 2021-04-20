package d.g.d.b.k;

import java.lang.reflect.AccessibleObject;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f67106a;

    static {
        f67106a = d.g.d.b.c.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f67106a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
