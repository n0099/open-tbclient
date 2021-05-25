package d.a.n0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f59418h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59419e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f59420f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59421g;

    public boolean c() {
        return this.f59421g;
    }

    public List<PbContent> e() {
        return this.f59420f;
    }

    public String f() {
        return this.f59419e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59418h;
    }

    public void h(ForumRule forumRule) {
        if (forumRule != null) {
            this.f59419e = forumRule.title;
            this.f59420f = forumRule.content;
            this.f59421g = forumRule.status.intValue() == 1;
        }
    }

    public void i(boolean z) {
        this.f59421g = z;
    }

    public void k(List<PbContent> list) {
        this.f59420f = list;
    }

    public void l(String str) {
        this.f59419e = str;
    }
}
