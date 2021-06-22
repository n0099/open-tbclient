package d.a.n0.b1.o.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements d.a.n0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f52921a;

    public a(List<T> list) {
        this.f52921a = list;
    }

    @Override // d.a.n0.b1.o.b.a.a
    public int a() {
        return this.f52921a.size();
    }

    @Override // d.a.n0.b1.o.b.a.a
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f52921a.size()) ? "" : this.f52921a.get(i2);
    }
}
