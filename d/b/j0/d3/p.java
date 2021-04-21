package d.b.j0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class p implements d.b.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public ForumRuleStatus f55436e;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.f55436e = forumRuleStatus;
    }

    public ForumRuleStatus a() {
        return this.f55436e;
    }

    public void e(ForumRuleStatus forumRuleStatus) {
        this.f55436e = forumRuleStatus;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
