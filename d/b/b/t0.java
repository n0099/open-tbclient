package d.b.b;
/* loaded from: classes5.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f64375a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f64375a == null) {
            synchronized (this) {
                if (this.f64375a == null) {
                    this.f64375a = a(objArr);
                }
            }
        }
        return this.f64375a;
    }
}
