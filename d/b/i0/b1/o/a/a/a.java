package d.b.i0.b1.o.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements d.b.i0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f50719a;

    public a(List<T> list) {
        this.f50719a = list;
    }

    @Override // d.b.i0.b1.o.b.a.a
    public int a() {
        return this.f50719a.size();
    }

    @Override // d.b.i0.b1.o.b.a.a
    public Object getItem(int i) {
        return (i < 0 || i >= this.f50719a.size()) ? "" : this.f50719a.get(i);
    }
}
