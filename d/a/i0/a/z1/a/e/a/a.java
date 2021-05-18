package d.a.i0.a.z1.a.e.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f45851a;

    public a(List<T> list) {
        this.f45851a = list;
    }

    @Override // d.a.i0.a.z1.a.e.a.c
    public int a() {
        return this.f45851a.size();
    }

    @Override // d.a.i0.a.z1.a.e.a.c
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.f45851a.size()) ? "" : this.f45851a.get(i2);
    }
}
