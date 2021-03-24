package d.b.i0.n0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57040g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f57041e;

    /* renamed from: f  reason: collision with root package name */
    public String f57042f;

    public String a() {
        return this.f57042f;
    }

    public MemberGroupInfo e() {
        return this.f57041e;
    }

    public void f(String str) {
        this.f57042f = str;
    }

    public void g(String str) {
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f57040g;
    }

    public void j(MemberGroupInfo memberGroupInfo) {
        this.f57041e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
