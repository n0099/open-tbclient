package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class p implements d.a.c.k.e.n {

    /* renamed from: e  reason: collision with root package name */
    public ForumRuleStatus f58014e;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.f58014e = forumRuleStatus;
    }

    public ForumRuleStatus b() {
        return this.f58014e;
    }

    public void c(ForumRuleStatus forumRuleStatus) {
        this.f58014e = forumRuleStatus;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return null;
    }
}
