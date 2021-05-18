package d.a.c0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f39688a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c0.a.a<T> f39689b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.a.a<T> f39690c;

    public static a b() {
        return new a();
    }

    @Override // d.a.c0.a.b.c
    public void a(d.a.c0.a.a<T> aVar) {
        this.f39689b = aVar;
        this.f39688a = null;
    }

    @Override // d.a.c0.a.b.c
    public T get() {
        T t = this.f39688a;
        if (t != null) {
            return t;
        }
        d.a.c0.a.a<T> aVar = this.f39689b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f39688a = t2;
            return t2;
        }
        d.a.c0.a.a<T> aVar2 = this.f39690c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
