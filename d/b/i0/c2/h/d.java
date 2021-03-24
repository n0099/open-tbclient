package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52416g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52417e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f52418f;

    public BdUniqueId a() {
        return this.f52418f;
    }

    public String e() {
        return this.f52417e;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f52418f = bdUniqueId;
    }

    public void g(String str) {
        this.f52417e = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f52416g;
    }
}
