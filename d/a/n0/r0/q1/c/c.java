package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f63109h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63110e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f63111f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63112g;

    public boolean b() {
        return this.f63112g;
    }

    public List<PbContent> c() {
        return this.f63111f;
    }

    public String e() {
        return this.f63110e;
    }

    public void g(ForumRule forumRule) {
        if (forumRule != null) {
            this.f63110e = forumRule.title;
            this.f63111f = forumRule.content;
            this.f63112g = forumRule.status.intValue() == 1;
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63109h;
    }

    public void h(boolean z) {
        this.f63112g = z;
    }

    public void i(List<PbContent> list) {
        this.f63111f = list;
    }

    public void k(String str) {
        this.f63110e = str;
    }
}
