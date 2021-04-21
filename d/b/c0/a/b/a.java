package d.b.c0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f43208a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c0.a.a<T> f43209b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c0.a.a<T> f43210c;

    public static a b() {
        return new a();
    }

    @Override // d.b.c0.a.b.c
    public void a(d.b.c0.a.a<T> aVar) {
        this.f43209b = aVar;
        this.f43208a = null;
    }

    @Override // d.b.c0.a.b.c
    public T get() {
        T t = this.f43208a;
        if (t != null) {
            return t;
        }
        d.b.c0.a.a<T> aVar = this.f43209b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f43208a = t2;
            return t2;
        }
        d.b.c0.a.a<T> aVar2 = this.f43210c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
