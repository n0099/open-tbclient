package d.a.o0.e2.h;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f56750a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f56751b = "";

    public String a() {
        return this.f56750a;
    }

    public String b() {
        return this.f56751b;
    }

    public void c(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.img_user_id.longValue();
        String str = forumHeadlineImgInfo.img_user_name;
        this.f56750a = forumHeadlineImgInfo.img_url;
        forumHeadlineImgInfo.rank_num.intValue();
        String str2 = forumHeadlineImgInfo.rank_up_info;
        this.f56751b = forumHeadlineImgInfo.rank_url;
    }
}
