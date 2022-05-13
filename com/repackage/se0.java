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
/* loaded from: classes7.dex */
public class se0 {
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

    public se0() {
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

    public static se0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            se0 se0Var = new se0();
            se0Var.d = "source";
            se0Var.a = "5.1_v2";
            se0Var.f = "resource_capture";
            String a = se0Var.a("resource_capture");
            se0Var.b = a;
            se0Var.c = ve0.b(a);
            se0Var.g = se0Var.k();
            se0Var.h = se0Var.d();
            return se0Var;
        }
        return (se0) invokeV.objValue;
    }

    public static se0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            se0 se0Var = new se0();
            se0Var.d = "source";
            se0Var.a = "5.1_v2";
            se0Var.f = "resource_live";
            String a = se0Var.a("resource_live");
            se0Var.b = a;
            se0Var.c = ve0.b(a);
            se0Var.g = se0Var.k();
            se0Var.h = se0Var.d();
            return se0Var;
        }
        return (se0) invokeV.objValue;
    }

    public static se0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            se0 se0Var = new se0();
            se0Var.d = "so";
            se0Var.e = "so1";
            se0Var.a = "5.1_v2";
            String j = se0Var.j("so1");
            se0Var.b = j;
            se0Var.c = ve0.b(j);
            se0Var.g = se0Var.k();
            if (ie0.m()) {
                lf0.a("DuAr_", "so1 local file path = " + se0Var.g.getAbsolutePath());
            }
            se0Var.h = se0Var.d();
            return se0Var;
        }
        return (se0) invokeV.objValue;
    }

    public static se0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            se0 se0Var = new se0();
            se0Var.d = "so";
            se0Var.e = "so2";
            se0Var.a = "5.1_v2";
            String j = se0Var.j("so2");
            se0Var.b = j;
            se0Var.c = ve0.b(j);
            se0Var.g = se0Var.k();
            if (ie0.m()) {
                lf0.a("DuAr_", "So2 local file path = " + se0Var.g.getAbsolutePath());
            }
            se0Var.h = se0Var.d();
            return se0Var;
        }
        return (se0) invokeV.objValue;
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
            boolean a = mf0.a(ie0.getContext());
            if (TextUtils.equals(this.d, "so")) {
                if (TextUtils.equals(this.e, "so2")) {
                    return te0.f().getAbsolutePath();
                }
                return te0.b(a).getAbsolutePath();
            }
            return te0.d().g().getAbsolutePath();
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
                if (mf0.a(ie0.getContext())) {
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
