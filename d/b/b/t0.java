package d.b.b;
/* loaded from: classes6.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f65104a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f65104a == null) {
            synchronized (this) {
                if (this.f65104a == null) {
                    this.f65104a = a(objArr);
                }
            }
        }
        return this.f65104a;
    }
}
