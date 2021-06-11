package d.a.t.a.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68353b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68354a = true;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f68353b == null) {
                synchronized (a.class) {
                    f68353b = new a();
                }
            }
            aVar = f68353b;
        }
        return aVar;
    }

    public boolean b() {
        return this.f68354a;
    }

    public void c(boolean z) {
        this.f68354a = z;
    }
}
