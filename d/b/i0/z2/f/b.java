package d.b.i0.z2.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f63475e;

    /* renamed from: f  reason: collision with root package name */
    public String f63476f;

    /* renamed from: g  reason: collision with root package name */
    public String f63477g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63478h;
    public int i;
    public int j;
    public String k;

    public String g() {
        return this.f63477g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public long j() {
        return this.f63475e;
    }

    public String n() {
        return this.f63476f;
    }

    public int o() {
        return this.i;
    }

    public String s() {
        return this.k;
    }

    public int t() {
        return this.j;
    }

    public boolean u() {
        return this.f63478h;
    }

    public void v(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f63475e = recommendForumInfo.forum_id.longValue();
        this.f63476f = recommendForumInfo.forum_name;
        this.f63477g = recommendForumInfo.avatar;
        this.i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f63478h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f63478h = z;
    }
}
