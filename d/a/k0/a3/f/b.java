package d.a.k0.a3.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f51946e;

    /* renamed from: f  reason: collision with root package name */
    public String f51947f;

    /* renamed from: g  reason: collision with root package name */
    public String f51948g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51949h;

    /* renamed from: i  reason: collision with root package name */
    public int f51950i;
    public int j;
    public String k;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f51948g;
    }

    public long l() {
        return this.f51946e;
    }

    public String m() {
        return this.f51947f;
    }

    public int p() {
        return this.f51950i;
    }

    public String s() {
        return this.k;
    }

    public int t() {
        return this.j;
    }

    public boolean u() {
        return this.f51949h;
    }

    public void v(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f51946e = recommendForumInfo.forum_id.longValue();
        this.f51947f = recommendForumInfo.forum_name;
        this.f51948g = recommendForumInfo.avatar;
        this.f51950i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f51949h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f51949h = z;
    }
}
