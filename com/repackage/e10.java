package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;

    public e10() {
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
        c();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DeviceInfoManager.INSTANCE.getDeviceInfo(AppRuntime.getAppContext(), "pub_param", "", 304);
            String str = DeviceInfoManager.INSTANCE.getModel("pub_param", "").deviceId;
            this.a = str;
            if (TextUtils.isEmpty(str)) {
                this.a = "NUL";
            } else {
                this.a = this.a.replace("_", "-");
            }
            String str2 = DeviceInfoManager.INSTANCE.getManufacturer("param", "pub_param").deviceId;
            this.b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.b = "NUL";
            } else {
                this.b = this.b.replace("_", "-");
            }
            String str3 = DeviceInfoManager.INSTANCE.getOsVersion("param", "pub_param").deviceId;
            this.c = str3;
            if (TextUtils.isEmpty(str3)) {
                this.c = "0.0";
            } else {
                this.c = this.c.replace("_", "-");
            }
            this.e = String.valueOf(Build.VERSION.SDK_INT);
            this.d = d();
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.a;
            String str2 = this.c;
            String str3 = this.b;
            return str + "_" + str2 + "_" + this.e + "_" + str3;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f) {
                return false;
            }
            boolean f = f();
            this.f = f;
            if (!f) {
                c10.b().g(new j10(1));
            }
            return !this.f;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DeviceInfoManager.INSTANCE.getDeviceInfo(AppRuntime.getAppContext(), "pub_param", "", 304).isSync(304) : invokeV.booleanValue;
    }
}
