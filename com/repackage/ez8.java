package com.repackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ez8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null || str == null) {
                return null;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
                if (bundle != null) {
                    return bundle.getString(str);
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
