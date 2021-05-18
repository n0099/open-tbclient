package d.a.k0.o0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57895g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f57896e;

    /* renamed from: f  reason: collision with root package name */
    public String f57897f;

    public String c() {
        return this.f57897f;
    }

    public MemberGroupInfo e() {
        return this.f57896e;
    }

    public void f(String str) {
        this.f57897f = str;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57895g;
    }

    public void h(String str) {
    }

    public void i(MemberGroupInfo memberGroupInfo) {
        this.f57896e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
