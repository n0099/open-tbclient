package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class p implements d.b.b.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public ForumRuleStatus f53570e;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.f53570e = forumRuleStatus;
    }

    public ForumRuleStatus a() {
        return this.f53570e;
    }

    public void e(ForumRuleStatus forumRuleStatus) {
        this.f53570e = forumRuleStatus;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
