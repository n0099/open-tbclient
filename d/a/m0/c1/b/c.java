package d.a.m0.c1.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    public static void a() {
        StatisticItem statisticItem = new StatisticItem("c14166");
        if (TbadkCoreApplication.isLogin()) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        }
        TiebaStatic.log(statisticItem);
    }

    public static void b(int i2) {
        StatisticItem statisticItem = new StatisticItem("c14165");
        if (TbadkCoreApplication.isLogin()) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        }
        statisticItem.param("obj_locate", i2 == 1 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        a();
    }
}
