package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class AutoInitHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AutoInitHelper() {
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

    public static void doAutoInit(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            try {
                if (isAutoInitEnabled(context)) {
                    HMSLog.i("AutoInit", "Push init start");
                    new Thread(new f(context)).start();
                }
            } catch (Exception e) {
                HMSLog.e("AutoInit", "Push init failed", e);
            }
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            i a = i.a(context);
            if (a.containsKey("push_kit_auto_init_enabled")) {
                return a.getBoolean("push_kit_auto_init_enabled");
            }
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void setAutoInitEnabled(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, context, z) == null) {
            i a = i.a(context);
            boolean z2 = a.getBoolean("push_kit_auto_init_enabled");
            a.saveBoolean("push_kit_auto_init_enabled", z);
            if (z && !z2) {
                doAutoInit(context);
            }
        }
    }
}
