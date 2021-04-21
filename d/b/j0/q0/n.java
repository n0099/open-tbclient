package d.b.j0.q0;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class n implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60024g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f60025e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f60026f = 0;

    public int a() {
        return this.f60026f;
    }

    public int e() {
        return this.f60025e;
    }

    public void f(int i) {
        this.f60026f = i;
    }

    public void g(int i) {
        this.f60025e = i;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60024g;
    }
}
