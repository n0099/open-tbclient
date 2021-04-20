package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes3.dex */
public class p implements d.b.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public ForumRuleStatus f55015e;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.f55015e = forumRuleStatus;
    }

    public ForumRuleStatus a() {
        return this.f55015e;
    }

    public void e(ForumRuleStatus forumRuleStatus) {
        this.f55015e = forumRuleStatus;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
