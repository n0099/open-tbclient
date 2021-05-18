package d.a.k0.i0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55819a;

    /* renamed from: b  reason: collision with root package name */
    public long f55820b;

    /* renamed from: c  reason: collision with root package name */
    public String f55821c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55822d;

    /* renamed from: e  reason: collision with root package name */
    public int f55823e;

    /* renamed from: f  reason: collision with root package name */
    public int f55824f;

    /* renamed from: g  reason: collision with root package name */
    public String f55825g;

    /* renamed from: h  reason: collision with root package name */
    public int f55826h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f55819a = recommendForumInfo.avatar;
        this.f55820b = recommendForumInfo.forum_id.longValue();
        this.f55821c = recommendForumInfo.forum_name;
        this.f55822d = recommendForumInfo.is_like.intValue() == 1;
        this.f55823e = recommendForumInfo.member_count.intValue();
        this.f55824f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f55825g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f55826h = 1;
    }
}
