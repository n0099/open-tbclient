package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.util.PlatformVersion;
/* loaded from: classes7.dex */
public class InstantApps {
    public static /* synthetic */ Interceptable $ic;
    public static Context zza;
    public static Boolean zzb;
    public transient /* synthetic */ FieldHolder $fh;

    public InstantApps() {
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

    public static synchronized boolean isInstantApp(Context context) {
        InterceptResult invokeL;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (InstantApps.class) {
                Context applicationContext = context.getApplicationContext();
                Context context2 = zza;
                if (context2 != null && (bool = zzb) != null && context2 == applicationContext) {
                    return bool.booleanValue();
                }
                zzb = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzb = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        zzb = Boolean.FALSE;
                    }
                }
                zza = applicationContext;
                return zzb.booleanValue();
            }
        }
        return invokeL.booleanValue;
    }
}
