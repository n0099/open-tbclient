package d.a.o0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f63234h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63235e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f63236f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63237g;

    public boolean b() {
        return this.f63237g;
    }

    public List<PbContent> c() {
        return this.f63236f;
    }

    public String e() {
        return this.f63235e;
    }

    public void g(ForumRule forumRule) {
        if (forumRule != null) {
            this.f63235e = forumRule.title;
            this.f63236f = forumRule.content;
            this.f63237g = forumRule.status.intValue() == 1;
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63234h;
    }

    public void h(boolean z) {
        this.f63237g = z;
    }

    public void i(List<PbContent> list) {
        this.f63236f = list;
    }

    public void k(String str) {
        this.f63235e = str;
    }
}
