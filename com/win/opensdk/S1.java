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
/* loaded from: classes10.dex */
public class S1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static S1 f76892b;

    /* renamed from: c  reason: collision with root package name */
    public static String f76893c;

    /* renamed from: d  reason: collision with root package name */
    public static String f76894d;

    /* renamed from: e  reason: collision with root package name */
    public static String f76895e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76896a;

    public S1(Context context) {
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
        this.f76896a = context;
    }

    public static S1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f76892b == null) {
                synchronized (S1.class) {
                    if (f76892b == null) {
                        f76892b = new S1(context);
                    }
                }
            }
            return f76892b;
        }
        return (S1) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f76894d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(f76893c)) {
                try {
                    return U1.k(this.f76896a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return f76893c;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f76895e : (String) invokeV.objValue;
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
                    FunOpenIDSdk.getOaid(this.f76896a, new R1(this));
                } catch (Exception unused2) {
                }
            }
        }
    }
}
