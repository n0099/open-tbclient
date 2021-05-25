package d.a.l0.a.z1.a.e.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f46027a;

    public a(List<T> list) {
        this.f46027a = list;
    }

    @Override // d.a.l0.a.z1.a.e.a.c
    public int a() {
        return this.f46027a.size();
    }

    @Override // d.a.l0.a.z1.a.e.a.c
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f46027a.size()) ? "" : this.f46027a.get(i2);
    }
}
