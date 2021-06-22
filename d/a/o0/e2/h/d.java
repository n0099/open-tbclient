package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class d implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56730g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56731e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f56732f;

    public BdUniqueId b() {
        return this.f56732f;
    }

    public String c() {
        return this.f56731e;
    }

    public void e(BdUniqueId bdUniqueId) {
        this.f56732f = bdUniqueId;
    }

    public void g(String str) {
        this.f56731e = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56730g;
    }
}
