package d.a.o0.b1.j;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.l;
import d.a.n0.r.q.n1;
import d.a.o0.z.t;
/* loaded from: classes4.dex */
public class c {
    public static void a(String str, Object obj, int i2, String str2) {
        if (obj instanceof d.a.o0.b1.f.a.e.c) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("topic_id", ((d.a.o0.b1.f.a.e.c) obj).f55381a);
            statisticItem.param("obj_source", str2);
            statisticItem.eventStat();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            StatisticItem statisticItem2 = new StatisticItem(str);
            statisticItem2.param("obj_type", 2);
            statisticItem2.param("obj_locate", i2);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("tid", specialColumnItemData.threadId);
            statisticItem2.param("obj_id", specialColumnItemData.liveId);
            statisticItem2.eventStat();
        } else if (obj instanceof MetaData) {
            StatisticItem statisticItem3 = new StatisticItem(str);
            statisticItem3.param("obj_type", 2);
            statisticItem3.param("obj_locate", i2);
            statisticItem3.param("uid", ((MetaData) obj).getUserIdLong());
            statisticItem3.eventStat();
        } else if (obj instanceof n1) {
            StatisticItem statisticItem4 = new StatisticItem(str);
            statisticItem4.param("obj_type", 2);
            statisticItem4.param("obj_locate", i2);
            statisticItem4.param("fid", ((n1) obj).C());
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem4.eventStat();
        } else if (obj instanceof l) {
            StatisticItem statisticItem5 = new StatisticItem(str);
            statisticItem5.param("obj_type", 2);
            statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem5.param("obj_locate", i2);
            statisticItem5.param("obj_param1", ((l) obj).c());
            statisticItem5.param("obj_source", str2);
            statisticItem5.eventStat();
        } else if (obj instanceof Boolean) {
            StatisticItem statisticItem6 = new StatisticItem(str);
            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem6.param("obj_locate", i2);
            statisticItem6.eventStat();
        }
    }

    public static void b(String str, Object obj, int i2, String str2) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", specialColumnItemData.threadId);
            statisticItem.param("obj_id", specialColumnItemData.liveId);
            t.b().a(statisticItem);
        } else if (obj instanceof MetaData) {
            StatisticItem statisticItem2 = new StatisticItem(str);
            statisticItem2.param("obj_type", 1);
            statisticItem2.param("obj_locate", i2);
            statisticItem2.param("uid", ((MetaData) obj).getUserIdLong());
            t.b().a(statisticItem2);
        } else if (obj instanceof n1) {
            StatisticItem statisticItem3 = new StatisticItem(str);
            statisticItem3.param("obj_type", 1);
            statisticItem3.param("obj_locate", i2);
            statisticItem3.param("fid", ((n1) obj).C());
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem3);
        } else if (obj instanceof l) {
            StatisticItem statisticItem4 = new StatisticItem(str);
            statisticItem4.param("obj_type", 1);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem4.param("obj_locate", i2);
            statisticItem4.param("obj_param1", ((l) obj).c());
            statisticItem4.param("obj_source", str2);
            t.b().a(statisticItem4);
        }
    }

    public static void c(String str, String str2) {
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", 1);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_source", str2);
        t.b().a(statisticItem);
    }

    public static void d(View view, d.a.n0.r.q.a aVar, String str) {
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

    public static void e(d.a.n0.r.q.a aVar, String str) {
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
