package d.a.j0.a3.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f51247e;

    /* renamed from: f  reason: collision with root package name */
    public String f51248f;

    /* renamed from: g  reason: collision with root package name */
    public String f51249g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51250h;

    /* renamed from: i  reason: collision with root package name */
    public int f51251i;
    public int j;
    public String k;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f51249g;
    }

    public long l() {
        return this.f51247e;
    }

    public String m() {
        return this.f51248f;
    }

    public int p() {
        return this.f51251i;
    }

    public String s() {
        return this.k;
    }

    public int t() {
        return this.j;
    }

    public boolean u() {
        return this.f51250h;
    }

    public void v(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f51247e = recommendForumInfo.forum_id.longValue();
        this.f51248f = recommendForumInfo.forum_name;
        this.f51249g = recommendForumInfo.avatar;
        this.f51251i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f51250h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f51250h = z;
    }
}
