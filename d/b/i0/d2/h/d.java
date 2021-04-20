package d.b.i0.d2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53812g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53813e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f53814f;

    public BdUniqueId a() {
        return this.f53814f;
    }

    public String e() {
        return this.f53813e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f53814f = bdUniqueId;
    }

    public void g(String str) {
        this.f53813e = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f53812g;
    }
}
