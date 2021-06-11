package d.a.c.e.j.a;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f42255a;

    public static final a b() {
        return f42255a;
    }

    public static final void d(a aVar) {
        synchronized (a.class) {
            f42255a = aVar;
        }
    }

    public abstract String a(String str);

    public abstract void c(e eVar);
}
