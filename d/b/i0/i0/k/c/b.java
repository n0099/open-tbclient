package d.b.i0.i0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56761a;

    /* renamed from: b  reason: collision with root package name */
    public long f56762b;

    /* renamed from: c  reason: collision with root package name */
    public String f56763c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56764d;

    /* renamed from: e  reason: collision with root package name */
    public int f56765e;

    /* renamed from: f  reason: collision with root package name */
    public int f56766f;

    /* renamed from: g  reason: collision with root package name */
    public String f56767g;

    /* renamed from: h  reason: collision with root package name */
    public int f56768h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f56761a = recommendForumInfo.avatar;
        this.f56762b = recommendForumInfo.forum_id.longValue();
        this.f56763c = recommendForumInfo.forum_name;
        this.f56764d = recommendForumInfo.is_like.intValue() == 1;
        this.f56765e = recommendForumInfo.member_count.intValue();
        this.f56766f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f56767g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f56768h = 1;
    }
}
