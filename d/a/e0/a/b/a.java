package d.a.e0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f43382a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.e0.a.a<T> f43383b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.e0.a.a<T> f43384c;

    public static a b() {
        return new a();
    }

    @Override // d.a.e0.a.b.c
    public void a(d.a.e0.a.a<T> aVar) {
        this.f43383b = aVar;
        this.f43382a = null;
    }

    @Override // d.a.e0.a.b.c
    public T get() {
        T t = this.f43382a;
        if (t != null) {
            return t;
        }
        d.a.e0.a.a<T> aVar = this.f43383b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f43382a = t2;
            return t2;
        }
        d.a.e0.a.a<T> aVar2 = this.f43384c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
