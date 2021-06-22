package d.a.n0.r.q;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53726a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f53727b = "";

    /* renamed from: c  reason: collision with root package name */
    public x f53728c;

    public String a() {
        return this.f53726a;
    }

    public void b(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.thread_id.longValue();
        forumHeadlineImgInfo.thread_user_id.longValue();
        String str = forumHeadlineImgInfo.thread_user_name;
        forumHeadlineImgInfo.img_user_id.longValue();
        String str2 = forumHeadlineImgInfo.img_user_name;
        this.f53726a = forumHeadlineImgInfo.img_url;
        this.f53727b = forumHeadlineImgInfo.headline_url;
        this.f53728c = new x();
        ArrayList<a0> arrayList = new ArrayList<>();
        String str3 = this.f53726a;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.f53727b;
        a0 a0Var = new a0(str3, str4 != null ? str4 : "", null);
        a0Var.n(true);
        arrayList.add(a0Var);
        this.f53728c.f(arrayList);
    }
}
