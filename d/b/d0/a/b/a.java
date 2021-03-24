package d.b.d0.a.b;
/* loaded from: classes.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f42708a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.d0.a.a<T> f42709b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.d0.a.a<T> f42710c;

    public static a b() {
        return new a();
    }

    @Override // d.b.d0.a.b.c
    public void a(d.b.d0.a.a<T> aVar) {
        this.f42709b = aVar;
        this.f42708a = null;
    }

    @Override // d.b.d0.a.b.c
    public T get() {
        T t = this.f42708a;
        if (t != null) {
            return t;
        }
        d.b.d0.a.a<T> aVar = this.f42709b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f42708a = t2;
            return t2;
        }
        d.b.d0.a.a<T> aVar2 = this.f42710c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
