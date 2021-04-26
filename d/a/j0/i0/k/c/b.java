package d.a.j0.i0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55112a;

    /* renamed from: b  reason: collision with root package name */
    public long f55113b;

    /* renamed from: c  reason: collision with root package name */
    public String f55114c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55115d;

    /* renamed from: e  reason: collision with root package name */
    public int f55116e;

    /* renamed from: f  reason: collision with root package name */
    public int f55117f;

    /* renamed from: g  reason: collision with root package name */
    public String f55118g;

    /* renamed from: h  reason: collision with root package name */
    public int f55119h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f55112a = recommendForumInfo.avatar;
        this.f55113b = recommendForumInfo.forum_id.longValue();
        this.f55114c = recommendForumInfo.forum_name;
        this.f55115d = recommendForumInfo.is_like.intValue() == 1;
        this.f55116e = recommendForumInfo.member_count.intValue();
        this.f55117f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f55118g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f55119h = 1;
    }
}
