package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"PackageManagerGetSignatures"})
    public static byte[] a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (context.getPackageName().equalsIgnoreCase(str)) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                    if (packageInfo.packageName.equals(str)) {
                        return packageInfo.signatures[0].toByteArray();
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }
}
