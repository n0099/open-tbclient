package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.zq7;
/* loaded from: classes7.dex */
public class zs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ct7 a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, iBaseDialogData)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(zq7.a.a);
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
            return new at7(tbPageContext, (CustomDialogData) iBaseDialogData);
        }
        return (ct7) invokeLL.objValue;
    }
}
