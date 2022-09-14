package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class bn {
    public static /* synthetic */ Interceptable $ic;
    public static bn a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f944a;

    /* renamed from: a  reason: collision with other field name */
    public Context f945a;

    public bn(Context context) {
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
        this.f944a = 0;
        this.f945a = context.getApplicationContext();
    }

    public static bn a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                a = new bn(context);
            }
            return a;
        }
        return (bn) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.f944a;
            if (i != 0) {
                return i;
            }
            try {
                this.f944a = Settings.Global.getInt(this.f945a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f944a;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m645a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Settings.Global.getUriFor("device_provisioned") : (Uri) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m646a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.xiaomi.push.ae.f93a.contains("xmsf") || com.xiaomi.push.ae.f93a.contains(RomUtils.MANUFACTURER_XIAOMI) || com.xiaomi.push.ae.f93a.contains("miui") : invokeV.booleanValue;
    }
}
