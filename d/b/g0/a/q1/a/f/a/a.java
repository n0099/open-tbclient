package d.b.g0.a.q1.a.f.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f45918a;

    public a(List<T> list) {
        this.f45918a = list;
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public int a() {
        return this.f45918a.size();
    }

    @Override // d.b.g0.a.q1.a.f.a.c
    public Object getItem(int i) {
        return (i < 0 || i >= this.f45918a.size()) ? "" : this.f45918a.get(i);
    }
}
