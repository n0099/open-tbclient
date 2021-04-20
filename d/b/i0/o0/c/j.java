package d.b.i0.o0.c;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class j implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f58740g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public MemberGroupInfo f58741e;

    /* renamed from: f  reason: collision with root package name */
    public String f58742f;

    public String a() {
        return this.f58742f;
    }

    public MemberGroupInfo e() {
        return this.f58741e;
    }

    public void f(String str) {
        this.f58742f = str;
    }

    public void g(String str) {
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f58740g;
    }

    public void j(MemberGroupInfo memberGroupInfo) {
        this.f58741e = memberGroupInfo;
    }

    public void k(boolean z) {
    }
}
