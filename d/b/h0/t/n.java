package d.b.h0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class n implements d.b.b.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51486h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51487e;

    /* renamed from: f  reason: collision with root package name */
    public String f51488f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51489g = false;

    public String a() {
        return this.f51487e;
    }

    public String e() {
        return this.f51488f;
    }

    public boolean f() {
        return this.f51489g;
    }

    public void g(String str) {
        this.f51487e = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f51486h;
    }

    public void j(boolean z) {
        this.f51489g = z;
    }

    public void k(String str) {
        this.f51488f = str;
    }
}
