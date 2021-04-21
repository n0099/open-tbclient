package d.c.b;
/* loaded from: classes5.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f66015a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f66015a == null) {
            synchronized (this) {
                if (this.f66015a == null) {
                    this.f66015a = a(objArr);
                }
            }
        }
        return this.f66015a;
    }
}
