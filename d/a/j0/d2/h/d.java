package d.a.j0.d2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52012g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52013e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52014f;

    public BdUniqueId c() {
        return this.f52014f;
    }

    public String e() {
        return this.f52013e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f52014f = bdUniqueId;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52012g;
    }

    public void h(String str) {
        this.f52013e = str;
    }
}
