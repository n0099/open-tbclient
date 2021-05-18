package d.a.k0.a1.f.h;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class a {
    public static void a(String str, String str2, String str3) {
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_name", str2);
        statisticItem.param("obj_type", str3);
        TiebaStatic.log(statisticItem);
    }
}
