package d.a.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57188g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f57189e;

    /* renamed from: f  reason: collision with root package name */
    public String f57190f;

    public String c() {
        return this.f57190f;
    }

    public MemberGroupInfo e() {
        return this.f57189e;
    }

    public void f(String str) {
        this.f57190f = str;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f57188g;
    }

    public void h(String str) {
    }

    public void i(MemberGroupInfo memberGroupInfo) {
        this.f57189e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
