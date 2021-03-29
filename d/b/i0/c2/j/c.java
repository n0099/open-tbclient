package d.b.i0.c2.j;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import d.b.i0.c2.b;
/* loaded from: classes4.dex */
public class c {
    public static f a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(b.a.f52309a);
        int i = 0;
        int from = iBaseDialogData.getFrom();
        if (from == 0) {
            i = 2;
        } else if (from == 1) {
            i = 3;
        } else if (from == 2) {
            i = 4;
        }
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
        return new d(tbPageContext, (CustomDialogData) iBaseDialogData);
    }
}
