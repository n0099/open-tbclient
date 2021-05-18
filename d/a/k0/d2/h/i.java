package d.a.k0.d2.h;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52731a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f52732b = "";

    public String a() {
        return this.f52731a;
    }

    public String b() {
        return this.f52732b;
    }

    public void c(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.img_user_id.longValue();
        String str = forumHeadlineImgInfo.img_user_name;
        this.f52731a = forumHeadlineImgInfo.img_url;
        forumHeadlineImgInfo.rank_num.intValue();
        String str2 = forumHeadlineImgInfo.rank_up_info;
        this.f52732b = forumHeadlineImgInfo.rank_url;
    }
}
