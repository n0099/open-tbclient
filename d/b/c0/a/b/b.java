package d.b.c0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f43211a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c0.a.a<List<T>> f43212b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c0.a.a<List<T>> f43213c;

    public static b c() {
        return new b();
    }

    @Override // d.b.c0.a.b.d
    public List<T> a() {
        List<T> list = this.f43211a;
        if (list != null) {
            return list;
        }
        d.b.c0.a.a<List<T>> aVar = this.f43212b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f43211a = list2;
            return list2;
        }
        d.b.c0.a.a<List<T>> aVar2 = this.f43213c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }

    @Override // d.b.c0.a.b.d
    public void b(d.b.c0.a.a<List<T>> aVar) {
        this.f43212b = aVar;
        this.f43211a = null;
    }
}
