package d.a.k0.d2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52711g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52712e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52713f;

    public BdUniqueId c() {
        return this.f52713f;
    }

    public String e() {
        return this.f52712e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f52713f = bdUniqueId;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52711g;
    }

    public void h(String str) {
        this.f52712e = str;
    }
}
