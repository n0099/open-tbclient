package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.e.k;
/* loaded from: classes9.dex */
public class c implements b.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static c a;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public a c;
    public b d;
    public Context e;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        b();
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c(context);
                    }
                }
            }
            return a;
        }
        return (c) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String b = k.b("sdk_config_version", "");
            if (!TextUtils.isEmpty(b) && AuthnHelper.SDK_VERSION.equals(b)) {
                b a2 = b.a(false);
                this.d = a2;
                this.b = a2.b();
            } else {
                b a3 = b.a(true);
                this.d = a3;
                this.b = a3.a();
                if (!TextUtils.isEmpty(b)) {
                    c();
                }
            }
            this.d.a(this);
            this.c = this.d.a();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.cmic.sso.sdk.e.c.b("UmcConfigManager", "delete localConfig");
            this.d.c();
        }
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.b.clone();
            } catch (CloneNotSupportedException unused) {
                return this.c;
            }
        }
        return (a) invokeV.objValue;
    }

    @Override // com.cmic.sso.sdk.a.b.a
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.d.a(aVar);
        }
    }
}
