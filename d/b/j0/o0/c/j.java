package d.b.j0.o0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f59161g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f59162e;

    /* renamed from: f  reason: collision with root package name */
    public String f59163f;

    public String a() {
        return this.f59163f;
    }

    public MemberGroupInfo e() {
        return this.f59162e;
    }

    public void f(String str) {
        this.f59163f = str;
    }

    public void g(String str) {
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f59161g;
    }

    public void j(MemberGroupInfo memberGroupInfo) {
        this.f59162e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
