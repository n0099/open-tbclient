package d.a.o0.p0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61820g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f61821e;

    /* renamed from: f  reason: collision with root package name */
    public String f61822f;

    public String b() {
        return this.f61822f;
    }

    public MemberGroupInfo c() {
        return this.f61821e;
    }

    public void e(String str) {
        this.f61822f = str;
    }

    public void g(String str) {
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f61820g;
    }

    public void h(MemberGroupInfo memberGroupInfo) {
        this.f61821e = memberGroupInfo;
    }

    public void i(boolean z) {
    }
}
