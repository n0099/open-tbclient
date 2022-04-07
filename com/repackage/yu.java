package com.repackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yu {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                b = at.c.h().getAppContext().getPackageName();
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                try {
                    Context appContext = at.c.h().getAppContext();
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    a = packageInfo.versionName + "";
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return a;
        }
        return (String) invokeV.objValue;
    }
}
