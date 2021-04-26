package d.a.j0.q0;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class n implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58103g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f58104e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f58105f = 0;

    public int c() {
        return this.f58105f;
    }

    public int e() {
        return this.f58104e;
    }

    public void f(int i2) {
        this.f58105f = i2;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58103g;
    }

    public void h(int i2) {
        this.f58104e = i2;
    }
}
