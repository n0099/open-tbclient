package d.a.n0.r.q;

import java.util.ArrayList;
import tbclient.ForumPresentInfo;
import tbclient.UserRankPresentInfo;
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f53785a;

    /* loaded from: classes3.dex */
    public class a {
        public a(e0 e0Var, UserRankPresentInfo userRankPresentInfo) {
            if (userRankPresentInfo == null) {
                return;
            }
            Integer num = userRankPresentInfo.user_id;
            String str = userRankPresentInfo.user_name;
            String str2 = userRankPresentInfo.portrait;
        }
    }

    public void a(ForumPresentInfo forumPresentInfo) {
        if (forumPresentInfo == null) {
            return;
        }
        String str = forumPresentInfo.content;
        this.f53785a = new ArrayList<>();
        for (int i2 = 0; i2 < forumPresentInfo.user_list.size(); i2++) {
            this.f53785a.add(new a(this, forumPresentInfo.user_list.get(i2)));
        }
    }
}
