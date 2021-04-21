package d.b.h0.a.q1.a.f.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f46247a;

    public a(List<T> list) {
        this.f46247a = list;
    }

    @Override // d.b.h0.a.q1.a.f.a.c
    public int a() {
        return this.f46247a.size();
    }

    @Override // d.b.h0.a.q1.a.f.a.c
    public Object getItem(int i) {
        return (i < 0 || i >= this.f46247a.size()) ? "" : this.f46247a.get(i);
    }
}
