package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import d.a.n0.e3.w;
/* loaded from: classes4.dex */
public class h implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57999h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public w f58000e;

    /* renamed from: f  reason: collision with root package name */
    public String f58001f;

    /* renamed from: g  reason: collision with root package name */
    public String f58002g;

    public String c() {
        return this.f58001f;
    }

    public String e() {
        return this.f58002g;
    }

    public w f() {
        return this.f58000e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57999h;
    }

    public void h(String str) {
        this.f58001f = str;
    }

    public void i(String str) {
        this.f58002g = str;
    }

    public void k(w wVar) {
        this.f58000e = wVar;
    }
}
