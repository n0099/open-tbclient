package com.repackage;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, om4 om4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, view2, om4Var, str) == null) || om4Var == null || om4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = om4Var.getThreadData();
        if (threadData.isVideoThreadType()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view2.getId();
        if (view2.getId() == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092278) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092298) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a49) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f091f99) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        }
    }

    public static void b(om4 om4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, om4Var, str) == null) || om4Var == null || om4Var.getThreadData() == null) {
            return;
        }
        if (om4Var.getThreadData().isVideoThreadType()) {
            gw5.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(om4Var.getThreadData(), str));
        } else {
            gw5.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(om4Var.getThreadData(), str));
        }
    }
}
