package d.a.i0.b1.o.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements d.a.i0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f48287a;

    public a(List<T> list) {
        this.f48287a = list;
    }

    @Override // d.a.i0.b1.o.b.a.a
    public int a() {
        return this.f48287a.size();
    }

    @Override // d.a.i0.b1.o.b.a.a
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f48287a.size()) ? "" : this.f48287a.get(i2);
    }
}
