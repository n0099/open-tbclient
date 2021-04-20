package d.b.h0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f51905h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51906e;

    /* renamed from: f  reason: collision with root package name */
    public String f51907f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51908g = false;

    public String a() {
        return this.f51906e;
    }

    public String e() {
        return this.f51907f;
    }

    public boolean f() {
        return this.f51908g;
    }

    public void g(String str) {
        this.f51906e = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f51905h;
    }

    public void j(boolean z) {
        this.f51908g = z;
    }

    public void k(String str) {
        this.f51907f = str;
    }
}
