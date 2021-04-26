package d.a.j0;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class g {
    public static void a(String str, String str2) {
        StatisticItem statisticItem = new StatisticItem("c14076");
        statisticItem.param("obj_source", str);
        statisticItem.param("obj_type", str2);
        TiebaStatic.log(statisticItem);
    }

    public static void b(String str) {
        StatisticItem statisticItem = new StatisticItem("c14075");
        statisticItem.param("obj_type", str);
        TiebaStatic.log(statisticItem);
    }
}
