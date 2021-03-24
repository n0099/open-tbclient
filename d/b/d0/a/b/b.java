package d.b.d0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f42711a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.d0.a.a<List<T>> f42712b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.d0.a.a<List<T>> f42713c;

    public static b c() {
        return new b();
    }

    @Override // d.b.d0.a.b.d
    public List<T> a() {
        List<T> list = this.f42711a;
        if (list != null) {
            return list;
        }
        d.b.d0.a.a<List<T>> aVar = this.f42712b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f42711a = list2;
            return list2;
        }
        d.b.d0.a.a<List<T>> aVar2 = this.f42713c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }

    @Override // d.b.d0.a.b.d
    public void b(d.b.d0.a.a<List<T>> aVar) {
        this.f42712b = aVar;
        this.f42711a = null;
    }
}
