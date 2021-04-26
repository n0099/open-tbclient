package d.a.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import d.a.j0.d3.w;
/* loaded from: classes4.dex */
public class h implements d.a.c.j.e.n {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f57183h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public w f57184e;

    /* renamed from: f  reason: collision with root package name */
    public String f57185f;

    /* renamed from: g  reason: collision with root package name */
    public String f57186g;

    public String c() {
        return this.f57185f;
    }

    public String e() {
        return this.f57186g;
    }

    public w f() {
        return this.f57184e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57183h;
    }

    public void h(String str) {
        this.f57185f = str;
    }

    public void i(String str) {
        this.f57186g = str;
    }

    public void k(w wVar) {
        this.f57184e = wVar;
    }
}
