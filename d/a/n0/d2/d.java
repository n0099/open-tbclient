package d.a.n0.d2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class d {
    public static void a(String str) {
        int i2 = TbadkCoreApplication.getCurrentMemberType() > 0 ? 1 : 0;
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
    }
}
