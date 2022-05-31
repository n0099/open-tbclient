package com.repackage;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.i(false);
        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f0973));
        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
    }

    public static void b(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.i(false);
        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f0975));
        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
    }

    public static void c(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.i(true);
        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f097a));
        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
    }
}
