package d.a.c0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f40446a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c0.a.a<List<T>> f40447b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.a.a<List<T>> f40448c;

    public static b b() {
        return new b();
    }

    @Override // d.a.c0.a.b.d
    public void a(d.a.c0.a.a<List<T>> aVar) {
        this.f40447b = aVar;
        this.f40446a = null;
    }

    @Override // d.a.c0.a.b.d
    public List<T> getList() {
        List<T> list = this.f40446a;
        if (list != null) {
            return list;
        }
        d.a.c0.a.a<List<T>> aVar = this.f40447b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f40446a = list2;
            return list2;
        }
        d.a.c0.a.a<List<T>> aVar2 = this.f40448c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
