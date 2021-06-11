package d.a.n0.p0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61695g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f61696e;

    /* renamed from: f  reason: collision with root package name */
    public String f61697f;

    public String b() {
        return this.f61697f;
    }

    public MemberGroupInfo c() {
        return this.f61696e;
    }

    public void e(String str) {
        this.f61697f = str;
    }

    public void g(String str) {
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61695g;
    }

    public void h(MemberGroupInfo memberGroupInfo) {
        this.f61696e = memberGroupInfo;
    }

    public void i(boolean z) {
    }
}
