package d.b.i0.n0.c;

import com.baidu.adp.BdUniqueId;
import d.b.i0.c3.w;
/* loaded from: classes4.dex */
public class h implements d.b.b.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57036h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public w f57037e;

    /* renamed from: f  reason: collision with root package name */
    public String f57038f;

    /* renamed from: g  reason: collision with root package name */
    public String f57039g;

    public String a() {
        return this.f57038f;
    }

    public String e() {
        return this.f57039g;
    }

    public w f() {
        return this.f57037e;
    }

    public void g(String str) {
        this.f57038f = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f57036h;
    }

    public void j(String str) {
        this.f57039g = str;
    }

    public void k(w wVar) {
        this.f57037e = wVar;
    }
}
