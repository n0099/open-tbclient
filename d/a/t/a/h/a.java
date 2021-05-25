package d.a.t.a.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f64635b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64636a = true;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f64635b == null) {
                synchronized (a.class) {
                    f64635b = new a();
                }
            }
            aVar = f64635b;
        }
        return aVar;
    }

    public boolean b() {
        return this.f64636a;
    }

    public void c(boolean z) {
        this.f64636a = z;
    }
}
