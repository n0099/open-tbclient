package d.b.b;
/* loaded from: classes5.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f65061a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f65061a == null) {
            synchronized (this) {
                if (this.f65061a == null) {
                    this.f65061a = a(objArr);
                }
            }
        }
        return this.f65061a;
    }
}
