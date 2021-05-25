package d.a.n0.b3.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52113e;

    /* renamed from: f  reason: collision with root package name */
    public String f52114f;

    /* renamed from: g  reason: collision with root package name */
    public String f52115g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52116h;

    /* renamed from: i  reason: collision with root package name */
    public int f52117i;
    public int j;
    public String k;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String h() {
        return this.f52115g;
    }

    public long l() {
        return this.f52113e;
    }

    public String m() {
        return this.f52114f;
    }

    public int p() {
        return this.f52117i;
    }

    public String s() {
        return this.k;
    }

    public int t() {
        return this.j;
    }

    public boolean u() {
        return this.f52116h;
    }

    public void v(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f52113e = recommendForumInfo.forum_id.longValue();
        this.f52114f = recommendForumInfo.forum_name;
        this.f52115g = recommendForumInfo.avatar;
        this.f52117i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f52116h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f52116h = z;
    }
}
