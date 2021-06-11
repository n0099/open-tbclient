package d.a.n0.j0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f59692a;

    /* renamed from: b  reason: collision with root package name */
    public long f59693b;

    /* renamed from: c  reason: collision with root package name */
    public String f59694c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59695d;

    /* renamed from: e  reason: collision with root package name */
    public int f59696e;

    /* renamed from: f  reason: collision with root package name */
    public int f59697f;

    /* renamed from: g  reason: collision with root package name */
    public String f59698g;

    /* renamed from: h  reason: collision with root package name */
    public int f59699h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f59692a = recommendForumInfo.avatar;
        this.f59693b = recommendForumInfo.forum_id.longValue();
        this.f59694c = recommendForumInfo.forum_name;
        this.f59695d = recommendForumInfo.is_like.intValue() == 1;
        this.f59696e = recommendForumInfo.member_count.intValue();
        this.f59697f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f59698g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f59699h = 1;
    }
}
