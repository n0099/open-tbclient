package d.b.i0.q0;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class n implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59603g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f59604e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f59605f = 0;

    public int a() {
        return this.f59605f;
    }

    public int e() {
        return this.f59604e;
    }

    public void f(int i) {
        this.f59605f = i;
    }

    public void g(int i) {
        this.f59604e = i;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f59603g;
    }
}
