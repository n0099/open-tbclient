package d.c.b;
/* loaded from: classes5.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f65074a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f65074a == null) {
            synchronized (this) {
                if (this.f65074a == null) {
                    this.f65074a = a(objArr);
                }
            }
        }
        return this.f65074a;
    }
}
