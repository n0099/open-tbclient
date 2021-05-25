package d.a.m0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f50802h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f50803e;

    /* renamed from: f  reason: collision with root package name */
    public String f50804f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50805g = false;

    public String c() {
        return this.f50803e;
    }

    public String e() {
        return this.f50804f;
    }

    public boolean f() {
        return this.f50805g;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50802h;
    }

    public void h(String str) {
        this.f50803e = str;
    }

    public void i(boolean z) {
        this.f50805g = z;
    }

    public void k(String str) {
        this.f50804f = str;
    }
}
