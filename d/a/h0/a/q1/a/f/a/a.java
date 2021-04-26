package d.a.h0.a.q1.a.f.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f43596a;

    public a(List<T> list) {
        this.f43596a = list;
    }

    @Override // d.a.h0.a.q1.a.f.a.c
    public int a() {
        return this.f43596a.size();
    }

    @Override // d.a.h0.a.q1.a.f.a.c
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f43596a.size()) ? "" : this.f43596a.get(i2);
    }
}
