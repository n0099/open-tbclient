package d.b.i0.c2.h;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52434a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f52435b = "";

    public String a() {
        return this.f52434a;
    }

    public String b() {
        return this.f52435b;
    }

    public void c(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.img_user_id.longValue();
        String str = forumHeadlineImgInfo.img_user_name;
        this.f52434a = forumHeadlineImgInfo.img_url;
        forumHeadlineImgInfo.rank_num.intValue();
        String str2 = forumHeadlineImgInfo.rank_up_info;
        this.f52435b = forumHeadlineImgInfo.rank_url;
    }
}
