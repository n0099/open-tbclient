package d.b.b0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f41938a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b0.a.a<T> f41939b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b0.a.a<T> f41940c;

    public static a b() {
        return new a();
    }

    @Override // d.b.b0.a.b.c
    public void a(d.b.b0.a.a<T> aVar) {
        this.f41939b = aVar;
        this.f41938a = null;
    }

    @Override // d.b.b0.a.b.c
    public T get() {
        T t = this.f41938a;
        if (t != null) {
            return t;
        }
        d.b.b0.a.a<T> aVar = this.f41939b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f41938a = t2;
            return t2;
        }
        d.b.b0.a.a<T> aVar2 = this.f41940c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
