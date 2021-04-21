package d.b.j0.d2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f54233g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54234e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f54235f;

    public BdUniqueId a() {
        return this.f54235f;
    }

    public String e() {
        return this.f54234e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f54235f = bdUniqueId;
    }

    public void g(String str) {
        this.f54234e = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54233g;
    }
}
