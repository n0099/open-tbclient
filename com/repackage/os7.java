package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.kq7;
/* loaded from: classes6.dex */
public class os7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rs7 a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, iBaseDialogData)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(kq7.a.a);
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
            return new ps7(tbPageContext, (CustomDialogData) iBaseDialogData);
        }
        return (rs7) invokeLL.objValue;
    }
}
