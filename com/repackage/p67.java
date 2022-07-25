package com.repackage;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.Anti;
/* loaded from: classes6.dex */
public class p67 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (c()) {
                if (hd5.a()) {
                    return true;
                }
                d(context);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z, Anti anti) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65537, null, z, anti) == null) && z && anti != null) {
            if (anti.user_chat_block.intValue() == 1) {
                e();
            } else {
                f();
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : invokeV.booleanValue;
    }

    public static void d(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && (context instanceof Activity)) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_MESSAGE_BLOCK_DIALOG_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder((Activity) context);
            tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f03a2);
            tBAlertBuilder.l(R.string.obfuscated_res_0x7f0f03a1);
            tBAlertBuilder.r(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03a0, TBAlertConfig.OperateBtnStyle.MAIN));
            tBAlertBuilder.i(false);
            tBAlertBuilder.g();
            tBAlertBuilder.w();
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || c()) {
            return;
        }
        a = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921720, Boolean.TRUE));
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && c()) {
            a = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921720, Boolean.FALSE));
        }
    }
}
