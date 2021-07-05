package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class q1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static q1 f42630b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42631c;

    /* renamed from: d  reason: collision with root package name */
    public static String f42632d;

    /* renamed from: e  reason: collision with root package name */
    public static String f42633e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42634a;

    public q1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42634a = context;
    }

    public static q1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f42630b == null) {
                synchronized (q1.class) {
                    if (f42630b == null) {
                        f42630b = new q1(context);
                    }
                }
            }
            return f42630b;
        }
        return (q1) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f42632d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(f42631c)) {
                try {
                    return s1.j(this.f42634a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return f42631c;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f42633e : (String) invokeV.objValue;
    }

    public void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                Class.forName("com.fun.openid.sdk.OnGetOaidListener");
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                try {
                    FunOpenIDSdk.getOaid(this.f42634a, new p1(this));
                } catch (Exception unused2) {
                }
            }
        }
    }
}
