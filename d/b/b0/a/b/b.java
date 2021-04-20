package d.b.b0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f41941a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b0.a.a<List<T>> f41942b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b0.a.a<List<T>> f41943c;

    public static b c() {
        return new b();
    }

    @Override // d.b.b0.a.b.d
    public List<T> a() {
        List<T> list = this.f41941a;
        if (list != null) {
            return list;
        }
        d.b.b0.a.a<List<T>> aVar = this.f41942b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f41941a = list2;
            return list2;
        }
        d.b.b0.a.a<List<T>> aVar2 = this.f41943c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }

    @Override // d.b.b0.a.b.d
    public void b(d.b.b0.a.a<List<T>> aVar) {
        this.f41942b = aVar;
        this.f41941a = null;
    }
}
