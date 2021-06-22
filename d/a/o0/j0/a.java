package d.a.o0.j0;

import android.view.View;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
import d.a.o0.z.t;
/* loaded from: classes4.dex */
public class a {
    public static void a(View view, d.a.n0.r.q.a aVar, String str) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        a2 i2 = aVar.i();
        if (i2.D2()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(i2, str));
            return;
        }
        int id = view.getId();
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(i2, str));
                return;
            } else if (id == R.id.user_name) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(i2, str));
                return;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(i2, str));
                return;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(i2, str));
                return;
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(i2, str));
                return;
            } else {
                return;
            }
        }
        TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(i2, str));
    }

    public static void b(d.a.n0.r.q.a aVar, String str) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        if (aVar.i().D2()) {
            t.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(aVar.i(), str));
        } else {
            t.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(aVar.i(), str));
        }
    }
}
