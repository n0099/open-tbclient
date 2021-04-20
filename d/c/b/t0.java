package d.c.b;
/* loaded from: classes5.dex */
public abstract class t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f65920a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f65920a == null) {
            synchronized (this) {
                if (this.f65920a == null) {
                    this.f65920a = a(objArr);
                }
            }
        }
        return this.f65920a;
    }
}
