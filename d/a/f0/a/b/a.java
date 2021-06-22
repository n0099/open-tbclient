package d.a.f0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f43520a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.a.a<T> f43521b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.f0.a.a<T> f43522c;

    public static a b() {
        return new a();
    }

    @Override // d.a.f0.a.b.c
    public void a(d.a.f0.a.a<T> aVar) {
        this.f43521b = aVar;
        this.f43520a = null;
    }

    @Override // d.a.f0.a.b.c
    public T get() {
        T t = this.f43520a;
        if (t != null) {
            return t;
        }
        d.a.f0.a.a<T> aVar = this.f43521b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f43520a = t2;
            return t2;
        }
        d.a.f0.a.a<T> aVar2 = this.f43522c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
