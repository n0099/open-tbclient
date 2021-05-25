package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class p implements d.a.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public ForumRuleStatus f54200e;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.f54200e = forumRuleStatus;
    }

    public ForumRuleStatus c() {
        return this.f54200e;
    }

    public void e(ForumRuleStatus forumRuleStatus) {
        this.f54200e = forumRuleStatus;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
