package d.a.n0.b3.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f55802e;

    /* renamed from: f  reason: collision with root package name */
    public String f55803f;

    /* renamed from: g  reason: collision with root package name */
    public String f55804g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55805h;

    /* renamed from: i  reason: collision with root package name */
    public int f55806i;
    public int j;
    public String k;

    public String c() {
        return this.f55804g;
    }

    public long g() {
        return this.f55802e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public String i() {
        return this.f55803f;
    }

    public int k() {
        return this.f55806i;
    }

    public String o() {
        return this.k;
    }

    public int p() {
        return this.j;
    }

    public boolean q() {
        return this.f55805h;
    }

    public void t(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f55802e = recommendForumInfo.forum_id.longValue();
        this.f55803f = recommendForumInfo.forum_name;
        this.f55804g = recommendForumInfo.avatar;
        this.f55806i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f55805h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f55805h = z;
    }
}
