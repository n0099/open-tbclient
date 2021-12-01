package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bc {
    public static /* synthetic */ Interceptable $ic;
    public static bc a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f928a;

    /* renamed from: a  reason: collision with other field name */
    public Context f929a;

    public bc(Context context) {
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
        this.f928a = 0;
        this.f929a = context.getApplicationContext();
    }

    public static bc a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                a = new bc(context);
            }
            return a;
        }
        return (bc) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f928a;
            if (i2 != 0) {
                return i2;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    this.f928a = Settings.Global.getInt(this.f929a.getContentResolver(), "device_provisioned", 0);
                } catch (Exception unused) {
                }
                return this.f928a;
            }
            int i3 = Settings.Secure.getInt(this.f929a.getContentResolver(), "device_provisioned", 0);
            this.f928a = i3;
            return i3;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m660a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned") : (Uri) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m661a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.xiaomi.push.ab.f108a.contains("xmsf") || com.xiaomi.push.ab.f108a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ab.f108a.contains("miui") : invokeV.booleanValue;
    }
}
