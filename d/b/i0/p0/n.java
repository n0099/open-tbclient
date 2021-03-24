package d.b.i0.p0;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class n implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57931g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f57932e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f57933f = 0;

    public int a() {
        return this.f57933f;
    }

    public int e() {
        return this.f57932e;
    }

    public void f(int i) {
        this.f57933f = i;
    }

    public void g(int i) {
        this.f57932e = i;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f57931g;
    }
}
