package d.b.h0.b1.o.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements d.b.h0.b1.o.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f49990a;

    public a(List<T> list) {
        this.f49990a = list;
    }

    @Override // d.b.h0.b1.o.b.a.a
    public int a() {
        return this.f49990a.size();
    }

    @Override // d.b.h0.b1.o.b.a.a
    public Object getItem(int i) {
        return (i < 0 || i >= this.f49990a.size()) ? "" : this.f49990a.get(i);
    }
}
