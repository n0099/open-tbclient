package d.a.k0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f59277h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59278e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f59279f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59280g;

    public boolean c() {
        return this.f59280g;
    }

    public List<PbContent> e() {
        return this.f59279f;
    }

    public String f() {
        return this.f59278e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59277h;
    }

    public void h(ForumRule forumRule) {
        if (forumRule != null) {
            this.f59278e = forumRule.title;
            this.f59279f = forumRule.content;
            this.f59280g = forumRule.status.intValue() == 1;
        }
    }

    public void i(boolean z) {
        this.f59280g = z;
    }

    public void k(List<PbContent> list) {
        this.f59279f = list;
    }

    public void l(String str) {
        this.f59278e = str;
    }
}
