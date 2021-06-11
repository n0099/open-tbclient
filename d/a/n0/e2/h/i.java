package d.a.n0.e2.h;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f56625a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f56626b = "";

    public String a() {
        return this.f56625a;
    }

    public String b() {
        return this.f56626b;
    }

    public void c(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.img_user_id.longValue();
        String str = forumHeadlineImgInfo.img_user_name;
        this.f56625a = forumHeadlineImgInfo.img_url;
        forumHeadlineImgInfo.rank_num.intValue();
        String str2 = forumHeadlineImgInfo.rank_up_info;
        this.f56626b = forumHeadlineImgInfo.rank_url;
    }
}
