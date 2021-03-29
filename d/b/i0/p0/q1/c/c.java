package d.b.i0.p0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class c implements n {

    /* renamed from: h  reason: collision with root package name */
    public static BdUniqueId f58357h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58358e;

    /* renamed from: f  reason: collision with root package name */
    public List<PbContent> f58359f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58360g;

    public boolean a() {
        return this.f58360g;
    }

    public List<PbContent> e() {
        return this.f58359f;
    }

    public String f() {
        return this.f58358e;
    }

    public void g(ForumRule forumRule) {
        if (forumRule != null) {
            this.f58358e = forumRule.title;
            this.f58359f = forumRule.content;
            this.f58360g = forumRule.status.intValue() == 1;
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f58357h;
    }

    public void j(boolean z) {
        this.f58360g = z;
    }

    public void k(List<PbContent> list) {
        this.f58359f = list;
    }

    public void l(String str) {
        this.f58358e = str;
    }
}
