package com.heytap.openid.sdk;

import android.content.Context;
import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64616a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64617b;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext() : (Context) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f64616a && f64617b && Looper.myLooper() != Looper.getMainLooper() : invokeV.booleanValue;
    }
}
