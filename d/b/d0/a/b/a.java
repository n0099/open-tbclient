package d.b.d0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f42709a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.d0.a.a<T> f42710b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.d0.a.a<T> f42711c;

    public static a b() {
        return new a();
    }

    @Override // d.b.d0.a.b.c
    public void a(d.b.d0.a.a<T> aVar) {
        this.f42710b = aVar;
        this.f42709a = null;
    }

    @Override // d.b.d0.a.b.c
    public T get() {
        T t = this.f42709a;
        if (t != null) {
            return t;
        }
        d.b.d0.a.a<T> aVar = this.f42710b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f42709a = t2;
            return t2;
        }
        d.b.d0.a.a<T> aVar2 = this.f42711c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
