package d.a.e0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f43385a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.e0.a.a<List<T>> f43386b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.e0.a.a<List<T>> f43387c;

    public static b b() {
        return new b();
    }

    @Override // d.a.e0.a.b.d
    public void a(d.a.e0.a.a<List<T>> aVar) {
        this.f43386b = aVar;
        this.f43385a = null;
    }

    @Override // d.a.e0.a.b.d
    public List<T> getList() {
        List<T> list = this.f43385a;
        if (list != null) {
            return list;
        }
        d.a.e0.a.a<List<T>> aVar = this.f43386b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f43385a = list2;
            return list2;
        }
        d.a.e0.a.a<List<T>> aVar2 = this.f43387c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
