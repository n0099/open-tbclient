package d.a.f0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f43523a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.a.a<List<T>> f43524b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.f0.a.a<List<T>> f43525c;

    public static b b() {
        return new b();
    }

    @Override // d.a.f0.a.b.d
    public void a(d.a.f0.a.a<List<T>> aVar) {
        this.f43524b = aVar;
        this.f43523a = null;
    }

    @Override // d.a.f0.a.b.d
    public List<T> getList() {
        List<T> list = this.f43523a;
        if (list != null) {
            return list;
        }
        d.a.f0.a.a<List<T>> aVar = this.f43524b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f43523a = list2;
            return list2;
        }
        d.a.f0.a.a<List<T>> aVar2 = this.f43525c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
