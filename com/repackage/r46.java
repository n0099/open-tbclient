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
public class r46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, on4 on4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, view2, on4Var, str) == null) || on4Var == null || on4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = on4Var.getThreadData();
        if (threadData.isVideoThreadType()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view2.getId();
        if (view2.getId() == R.id.obfuscated_res_0x7f09202e || id == R.id.obfuscated_res_0x7f092042) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f09230e) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f09232f) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a39) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092042) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        }
    }

    public static void b(on4 on4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, on4Var, str) == null) || on4Var == null || on4Var.getThreadData() == null) {
            return;
        }
        if (on4Var.getThreadData().isVideoThreadType()) {
            cy5.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(on4Var.getThreadData(), str));
        } else {
            cy5.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(on4Var.getThreadData(), str));
        }
    }
}
