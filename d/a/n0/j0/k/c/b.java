package d.a.n0.j0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56003a;

    /* renamed from: b  reason: collision with root package name */
    public long f56004b;

    /* renamed from: c  reason: collision with root package name */
    public String f56005c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56006d;

    /* renamed from: e  reason: collision with root package name */
    public int f56007e;

    /* renamed from: f  reason: collision with root package name */
    public int f56008f;

    /* renamed from: g  reason: collision with root package name */
    public String f56009g;

    /* renamed from: h  reason: collision with root package name */
    public int f56010h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f56003a = recommendForumInfo.avatar;
        this.f56004b = recommendForumInfo.forum_id.longValue();
        this.f56005c = recommendForumInfo.forum_name;
        this.f56006d = recommendForumInfo.is_like.intValue() == 1;
        this.f56007e = recommendForumInfo.member_count.intValue();
        this.f56008f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f56009g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f56010h = 1;
    }
}
