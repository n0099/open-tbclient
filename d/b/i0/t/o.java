package d.b.i0.t;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class o implements d.b.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f52241h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52242e;

    /* renamed from: f  reason: collision with root package name */
    public String f52243f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52244g = false;

    public String a() {
        return this.f52242e;
    }

    public String e() {
        return this.f52243f;
    }

    public boolean f() {
        return this.f52244g;
    }

    public void g(String str) {
        this.f52242e = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f52241h;
    }

    public void j(boolean z) {
        this.f52244g = z;
    }

    public void k(String str) {
        this.f52243f = str;
    }
}
