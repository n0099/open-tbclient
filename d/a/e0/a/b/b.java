package d.a.e0.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f39704a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.e0.a.a<List<T>> f39705b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.e0.a.a<List<T>> f39706c;

    public static b b() {
        return new b();
    }

    @Override // d.a.e0.a.b.d
    public void a(d.a.e0.a.a<List<T>> aVar) {
        this.f39705b = aVar;
        this.f39704a = null;
    }

    @Override // d.a.e0.a.b.d
    public List<T> getList() {
        List<T> list = this.f39704a;
        if (list != null) {
            return list;
        }
        d.a.e0.a.a<List<T>> aVar = this.f39705b;
        if (aVar != null) {
            List<T> list2 = aVar.get();
            this.f39704a = list2;
            return list2;
        }
        d.a.e0.a.a<List<T>> aVar2 = this.f39706c;
        if (aVar2 != null) {
            return aVar2.get();
        }
        return null;
    }
}
