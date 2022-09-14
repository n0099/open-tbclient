package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hj;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
/* loaded from: classes8.dex */
public final class ch implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ii a;

    public ch(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iiVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] a = it.a(ah.a(this.a.c(), this.a.b(), this.a, hj.i));
            context = cg.a;
            if (!(context instanceof XMPushService)) {
                com.xiaomi.channel.commonutils.logger.b.m90a("UNDatas UploadNotificationDatas failed because not xmsf");
                return;
            }
            context2 = cg.a;
            ((XMPushService) context2).a(this.a.c(), a, true);
        }
    }
}
