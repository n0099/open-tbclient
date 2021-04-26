package d.a.c0.a.b;
/* loaded from: classes2.dex */
public class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f40443a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c0.a.a<T> f40444b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.a.a<T> f40445c;

    public static a b() {
        return new a();
    }

    @Override // d.a.c0.a.b.c
    public void a(d.a.c0.a.a<T> aVar) {
        this.f40444b = aVar;
        this.f40443a = null;
    }

    @Override // d.a.c0.a.b.c
    public T get() {
        T t = this.f40443a;
        if (t != null) {
            return t;
        }
        d.a.c0.a.a<T> aVar = this.f40444b;
        if (aVar != null) {
            T t2 = aVar.get();
            this.f40443a = t2;
            return t2;
        }
        d.a.c0.a.a<T> aVar2 = this.f40445c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
