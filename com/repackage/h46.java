package com.repackage;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, zn4 zn4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, view2, zn4Var, str) == null) || zn4Var == null || zn4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = zn4Var.getThreadData();
        if (threadData.isVideoThreadType()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view2.getId();
        if (view2.getId() == R.id.obfuscated_res_0x7f091fe0 || id == R.id.obfuscated_res_0x7f091ff4) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f0922d3) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f0922f3) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a5f) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f091ff4) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        }
    }

    public static void b(zn4 zn4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, zn4Var, str) == null) || zn4Var == null || zn4Var.getThreadData() == null) {
            return;
        }
        if (zn4Var.getThreadData().isVideoThreadType()) {
            nx5.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(zn4Var.getThreadData(), str));
        } else {
            nx5.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(zn4Var.getThreadData(), str));
        }
    }
}
