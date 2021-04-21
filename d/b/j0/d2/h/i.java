package d.b.j0.d2.h;

import tbclient.PbPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f54251a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f54252b = "";

    public String a() {
        return this.f54251a;
    }

    public String b() {
        return this.f54252b;
    }

    public void c(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.img_user_id.longValue();
        String str = forumHeadlineImgInfo.img_user_name;
        this.f54251a = forumHeadlineImgInfo.img_url;
        forumHeadlineImgInfo.rank_num.intValue();
        String str2 = forumHeadlineImgInfo.rank_up_info;
        this.f54252b = forumHeadlineImgInfo.rank_url;
    }
}
