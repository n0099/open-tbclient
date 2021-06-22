package d.a.m0.a.z1.a.e.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f49809a;

    public a(List<T> list) {
        this.f49809a = list;
    }

    @Override // d.a.m0.a.z1.a.e.a.c
    public int a() {
        return this.f49809a.size();
    }

    @Override // d.a.m0.a.z1.a.e.a.c
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f49809a.size()) ? "" : this.f49809a.get(i2);
    }
}
