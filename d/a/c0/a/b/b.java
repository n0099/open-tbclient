package d.a.c0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f39691a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c0.a.a<List<T>> f39692b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.a.a<List<T>> f39693c;

    public static b b() {
        return new b();
    }

    @Override // d.a.c0.a.b.d
    public void a(d.a.c0.a.a<List<T>> aVar) {
        this.f39692b = aVar;
        this.f39691a = null;
    }

    @Override // d.a.c0.a.b.d
    public List<T> getList() {
        List<T> list = this.f39691a;
        if (list != null) {
            return list;
        }
        d.a.c0.a.a<List<T>> aVar = this.f39692b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f39691a = list2;
            return list2;
        }
        d.a.c0.a.a<List<T>> aVar2 = this.f39693c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
