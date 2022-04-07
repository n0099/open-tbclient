package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class pe0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public File g;
    public File h;

    public pe0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "5.1_v2";
        this.g = null;
    }

    public static pe0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            pe0 pe0Var = new pe0();
            pe0Var.d = "source";
            pe0Var.a = "5.1_v2";
            pe0Var.f = "resource_capture";
            String a = pe0Var.a("resource_capture");
            pe0Var.b = a;
            pe0Var.c = se0.b(a);
            pe0Var.g = pe0Var.k();
            pe0Var.h = pe0Var.d();
            return pe0Var;
        }
        return (pe0) invokeV.objValue;
    }

    public static pe0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            pe0 pe0Var = new pe0();
            pe0Var.d = "source";
            pe0Var.a = "5.1_v2";
            pe0Var.f = "resource_live";
            String a = pe0Var.a("resource_live");
            pe0Var.b = a;
            pe0Var.c = se0.b(a);
            pe0Var.g = pe0Var.k();
            pe0Var.h = pe0Var.d();
            return pe0Var;
        }
        return (pe0) invokeV.objValue;
    }

    public static pe0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            pe0 pe0Var = new pe0();
            pe0Var.d = "so";
            pe0Var.e = "so1";
            pe0Var.a = "5.1_v2";
            String j = pe0Var.j("so1");
            pe0Var.b = j;
            pe0Var.c = se0.b(j);
            pe0Var.g = pe0Var.k();
            if (fe0.m()) {
                if0.a("DuAr_", "so1 local file path = " + pe0Var.g.getAbsolutePath());
            }
            pe0Var.h = pe0Var.d();
            return pe0Var;
        }
        return (pe0) invokeV.objValue;
    }

    public static pe0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            pe0 pe0Var = new pe0();
            pe0Var.d = "so";
            pe0Var.e = "so2";
            pe0Var.a = "5.1_v2";
            String j = pe0Var.j("so2");
            pe0Var.b = j;
            pe0Var.c = se0.b(j);
            pe0Var.g = pe0Var.k();
            if (fe0.m()) {
                if0.a("DuAr_", "So2 local file path = " + pe0Var.g.getAbsolutePath());
            }
            pe0Var.h = pe0Var.d();
            return pe0Var;
        }
        return (pe0) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = TextUtils.equals("resource_live", str) ? "https://pic.rmb.bdstatic.com/baidu-ar-source-live-" : "https://pic.rmb.bdstatic.com/baidu-ar-source-";
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean a = jf0.a(fe0.getContext());
            if (TextUtils.equals(this.d, "so")) {
                if (TextUtils.equals(this.e, "so2")) {
                    return qe0.f().getAbsolutePath();
                }
                return qe0.b(a).getAbsolutePath();
            }
            return qe0.d().g().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k() : (File) invokeV.objValue;
    }

    public File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h == null) {
                File c = c();
                String absolutePath = c != null ? c.getAbsolutePath() : null;
                if (absolutePath == null) {
                    return null;
                }
                if (!absolutePath.endsWith(".zip")) {
                    absolutePath = absolutePath + ".zip";
                }
                if (!absolutePath.endsWith(".loading")) {
                    absolutePath = absolutePath + ".loading";
                }
                this.h = new File(absolutePath);
            }
            return this.h;
        }
        return (File) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a + "-" + this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.equals("so2", str)) {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            } else {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
                if (jf0.a(fe0.getContext())) {
                    str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-64bit-";
                }
            }
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g == null && !TextUtils.isEmpty(this.a)) {
                this.g = new File(b(), e());
            }
            return this.g;
        }
        return (File) invokeV.objValue;
    }
}
