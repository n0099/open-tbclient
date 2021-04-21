package d.b.j0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f60440h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60441e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f60442f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60443g;

    public boolean a() {
        return this.f60443g;
    }

    public List<PbContent> e() {
        return this.f60442f;
    }

    public String f() {
        return this.f60441e;
    }

    public void g(ForumRule forumRule) {
        if (forumRule != null) {
            this.f60441e = forumRule.title;
            this.f60442f = forumRule.content;
            this.f60443g = forumRule.status.intValue() == 1;
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60440h;
    }

    public void j(boolean z) {
        this.f60443g = z;
    }

    public void k(List<PbContent> list) {
        this.f60442f = list;
    }

    public void l(String str) {
        this.f60441e = str;
    }
}
