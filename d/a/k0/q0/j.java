package d.a.k0.q0;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static UserData f58617a;

    public static UserData a() {
        return f58617a;
    }

    public static UserData b(FrsViewData frsViewData) {
        UserData userData = frsViewData != null ? frsViewData.getUserData() : null;
        f58617a = userData;
        return userData;
    }

    public static boolean c(UserData userData) {
        if (userData == null) {
            return false;
        }
        int is_manager = userData.getIs_manager();
        return is_manager == 1 || is_manager == 2 || is_manager == 3 || is_manager == 4;
    }

    public static boolean d() {
        UserData a2 = a();
        return a2 != null && a2.getIs_manager() == 1;
    }

    public static boolean e() {
        UserData a2 = a();
        return a2 != null && a2.getIs_manager() == 3;
    }

    public static boolean f() {
        List<ForumToolPerm> forumToolAuth;
        UserData a2 = a();
        if (a2 != null && (forumToolAuth = a2.getForumToolAuth()) != null) {
            for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
                ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
                if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void g(d.a.i.a aVar, FrsViewData frsViewData) {
        if (aVar == null) {
            return;
        }
        if (frsViewData != null && (c(b(frsViewData)) || f())) {
            aVar.b(4);
        } else {
            aVar.c(4);
        }
    }

    public static void h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        if (threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        if (frsViewData != null && c(b(frsViewData))) {
            threadCommentAndPraiseInfoLayout.setManageVisible(true);
        } else {
            threadCommentAndPraiseInfoLayout.setManageVisible(false);
        }
    }
}
