package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58004g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f58005e;

    /* renamed from: f  reason: collision with root package name */
    public String f58006f;

    public String c() {
        return this.f58006f;
    }

    public MemberGroupInfo e() {
        return this.f58005e;
    }

    public void f(String str) {
        this.f58006f = str;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58004g;
    }

    public void h(String str) {
    }

    public void i(MemberGroupInfo memberGroupInfo) {
        this.f58005e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
