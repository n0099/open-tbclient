package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52916g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52917e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52918f;

    public BdUniqueId c() {
        return this.f52918f;
    }

    public String e() {
        return this.f52917e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f52918f = bdUniqueId;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52916g;
    }

    public void h(String str) {
        this.f52917e = str;
    }
}
