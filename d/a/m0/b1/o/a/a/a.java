package d.a.m0.b1.o.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements d.a.m0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f49140a;

    public a(List<T> list) {
        this.f49140a = list;
    }

    @Override // d.a.m0.b1.o.b.a.a
    public int a() {
        return this.f49140a.size();
    }

    @Override // d.a.m0.b1.o.b.a.a
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f49140a.size()) ? "" : this.f49140a.get(i2);
    }
}
