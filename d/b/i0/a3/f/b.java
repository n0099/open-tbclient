package d.b.i0.a3.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f53094e;

    /* renamed from: f  reason: collision with root package name */
    public String f53095f;

    /* renamed from: g  reason: collision with root package name */
    public String f53096g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53097h;
    public int i;
    public int j;
    public String k;

    public String g() {
        return this.f53096g;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public long j() {
        return this.f53094e;
    }

    public String n() {
        return this.f53095f;
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
        return this.f53097h;
    }

    public void v(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        this.f53094e = recommendForumInfo.forum_id.longValue();
        this.f53095f = recommendForumInfo.forum_name;
        this.f53096g = recommendForumInfo.avatar;
        this.i = recommendForumInfo.member_count.intValue();
        this.j = recommendForumInfo.thread_count.intValue();
        this.f53097h = recommendForumInfo.is_like.intValue() == 1;
        this.k = recommendForumInfo.recom_reason;
        String str = recommendForumInfo.extra;
    }

    public void w(boolean z) {
        this.f53097h = z;
    }
}
