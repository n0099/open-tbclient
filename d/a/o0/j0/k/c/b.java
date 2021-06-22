package d.a.o0.j0.k.c;

import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f59817a;

    /* renamed from: b  reason: collision with root package name */
    public long f59818b;

    /* renamed from: c  reason: collision with root package name */
    public String f59819c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59820d;

    /* renamed from: e  reason: collision with root package name */
    public int f59821e;

    /* renamed from: f  reason: collision with root package name */
    public int f59822f;

    /* renamed from: g  reason: collision with root package name */
    public String f59823g;

    /* renamed from: h  reason: collision with root package name */
    public int f59824h;

    public void a(RecommendForumInfo recommendForumInfo) {
        this.f59817a = recommendForumInfo.avatar;
        this.f59818b = recommendForumInfo.forum_id.longValue();
        this.f59819c = recommendForumInfo.forum_name;
        this.f59820d = recommendForumInfo.is_like.intValue() == 1;
        this.f59821e = recommendForumInfo.member_count.intValue();
        this.f59822f = recommendForumInfo.thread_count.intValue();
        String str = recommendForumInfo.slogan;
        recommendForumInfo.forum_type.intValue();
        String str2 = recommendForumInfo.authen;
        this.f59823g = recommendForumInfo.recom_reason;
        recommendForumInfo.is_brand_forum.intValue();
        String str3 = recommendForumInfo.hot_text;
        String str4 = recommendForumInfo.abtest_tag;
        String str5 = recommendForumInfo.source;
        String str6 = recommendForumInfo.extra;
        this.f59824h = 1;
    }
}
