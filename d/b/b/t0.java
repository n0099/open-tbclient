package d.b.b;
/* loaded from: classes6.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f68939a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f68939a == null) {
            synchronized (this) {
                if (this.f68939a == null) {
                    this.f68939a = a(objArr);
                }
            }
        }
        return this.f68939a;
    }
}
