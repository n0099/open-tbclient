package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a8c;
import com.baidu.tieba.c8c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public static d0 c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    public d0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static d0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                g();
            }
            return c;
        }
        return (d0) invokeV.objValue;
    }

    public static synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (d0.class) {
                if (c == null) {
                    c = new d0();
                }
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                this.a = c();
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (e() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String d = e() ? a8c.d("analytics_keystore", str) : "";
            if (TextUtils.isEmpty(d)) {
                y.c("hmsSdk", "deCrypt work key first");
                d = d.a(str, d());
                if (TextUtils.isEmpty(d)) {
                    d = c8c.d(16);
                    c(b(d));
                } else if (e()) {
                    c(b(d));
                    c0.d();
                }
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? e() ? a8c.g("analytics_keystore", str) : d.b(str, d()) : (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String d = c8c.d(16);
            if (c(b(d))) {
                this.a = d;
            }
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String a = g0.a(b.i(), "Privacy_MY", "PrivacyData", "");
            if (TextUtils.isEmpty(a)) {
                String d = c8c.d(16);
                c(b(d));
                return d;
            }
            return a(a);
        }
        return (String) invokeV.objValue;
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            y.c("hmsSdk", "refresh sp aes key");
            if (TextUtils.isEmpty(str)) {
                y.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
                return false;
            }
            g0.b(b.i(), "Privacy_MY", "PrivacyData", str);
            g0.b(b.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = new c0().a();
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }
}
