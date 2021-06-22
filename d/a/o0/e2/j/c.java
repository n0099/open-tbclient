package d.a.o0.e2.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import d.a.o0.e2.b;
/* loaded from: classes5.dex */
public class c {
    public static f a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(b.a.f56617a);
        int i2 = 0;
        int from = iBaseDialogData.getFrom();
        if (from == 0) {
            i2 = 2;
        } else if (from == 1) {
            i2 = 3;
        } else if (from == 2) {
            i2 = 4;
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        return new d(tbPageContext, (CustomDialogData) iBaseDialogData);
    }
}
