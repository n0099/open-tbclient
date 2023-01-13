package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class p implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ComponentName a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f844a;

    public p(Context context, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, componentName};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f844a = context;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                PackageManager packageManager = this.f844a.getPackageManager();
                if (packageManager.getComponentEnabledSetting(this.a) != 2) {
                    packageManager.setComponentEnabledSetting(this.a, 2, 1);
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m103a("close static register of network status receiver failed:" + th);
            }
        }
    }
}
