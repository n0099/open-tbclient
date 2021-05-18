package d.a.k0.o0.c;

import com.baidu.adp.BdUniqueId;
import d.a.k0.d3.w;
/* loaded from: classes4.dex */
public class h implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57890h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public w f57891e;

    /* renamed from: f  reason: collision with root package name */
    public String f57892f;

    /* renamed from: g  reason: collision with root package name */
    public String f57893g;

    public String c() {
        return this.f57892f;
    }

    public String e() {
        return this.f57893g;
    }

    public w f() {
        return this.f57891e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57890h;
    }

    public void h(String str) {
        this.f57892f = str;
    }

    public void i(String str) {
        this.f57893g = str;
    }

    public void k(w wVar) {
        this.f57891e = wVar;
    }
}
