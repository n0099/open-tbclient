package d.b.i0.i0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55637a;

    /* renamed from: b  reason: collision with root package name */
    public long f55638b;

    /* renamed from: c  reason: collision with root package name */
    public String f55639c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55640d;

    /* renamed from: e  reason: collision with root package name */
    public int f55641e;

    /* renamed from: f  reason: collision with root package name */
    public int f55642f;

    /* renamed from: g  reason: collision with root package name */
    public String f55643g;

    /* renamed from: h  reason: collision with root package name */
    public int f55644h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f55637a = recommendForumInfo.avatar;
        this.f55638b = recommendForumInfo.forum_id.longValue();
        this.f55639c = recommendForumInfo.forum_name;
        this.f55640d = recommendForumInfo.is_like.intValue() == 1;
        this.f55641e = recommendForumInfo.member_count.intValue();
        this.f55642f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f55643g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f55644h = 1;
    }
}
