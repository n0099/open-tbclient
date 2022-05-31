package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes8.dex */
public class aa implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MiTinyDataClient.a.C0658a a;

    public aa(MiTinyDataClient.a.C0658a c0658a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0658a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0658a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.f35a.size() != 0) {
                this.a.b();
                return;
            }
            scheduledFuture = this.a.f36a;
            if (scheduledFuture != null) {
                scheduledFuture2 = this.a.f36a;
                scheduledFuture2.cancel(false);
                this.a.f36a = null;
            }
        }
    }
}
