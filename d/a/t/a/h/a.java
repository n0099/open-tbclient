package d.a.t.a.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68435b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68436a = true;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f68435b == null) {
                synchronized (a.class) {
                    f68435b = new a();
                }
            }
            aVar = f68435b;
        }
        return aVar;
    }

    public boolean b() {
        return this.f68436a;
    }

    public void c(boolean z) {
        this.f68436a = z;
    }
}
