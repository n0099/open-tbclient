package d.b.j0.i0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57182a;

    /* renamed from: b  reason: collision with root package name */
    public long f57183b;

    /* renamed from: c  reason: collision with root package name */
    public String f57184c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57185d;

    /* renamed from: e  reason: collision with root package name */
    public int f57186e;

    /* renamed from: f  reason: collision with root package name */
    public int f57187f;

    /* renamed from: g  reason: collision with root package name */
    public String f57188g;

    /* renamed from: h  reason: collision with root package name */
    public int f57189h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f57182a = recommendForumInfo.avatar;
        this.f57183b = recommendForumInfo.forum_id.longValue();
        this.f57184c = recommendForumInfo.forum_name;
        this.f57185d = recommendForumInfo.is_like.intValue() == 1;
        this.f57186e = recommendForumInfo.member_count.intValue();
        this.f57187f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f57188g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f57189h = 1;
    }
}
