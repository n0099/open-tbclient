package com.heytap.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38726b;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext() : (Context) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!a) {
                str = "SDK Need Init First!";
            } else if (!f38726b) {
                str = "NOT Supported";
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            } else {
                str = "Get ID Cannot run on MainThread";
            }
            Log.e("OpenIDHelper", str);
            return false;
        }
        return invokeV.booleanValue;
    }
}
