package d.b.i0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f60019h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60020e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f60021f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60022g;

    public boolean a() {
        return this.f60022g;
    }

    public List<PbContent> e() {
        return this.f60021f;
    }

    public String f() {
        return this.f60020e;
    }

    public void g(ForumRule forumRule) {
        if (forumRule != null) {
            this.f60020e = forumRule.title;
            this.f60021f = forumRule.content;
            this.f60022g = forumRule.status.intValue() == 1;
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60019h;
    }

    public void j(boolean z) {
        this.f60022g = z;
    }

    public void k(List<PbContent> list) {
        this.f60021f = list;
    }

    public void l(String str) {
        this.f60020e = str;
    }
}
