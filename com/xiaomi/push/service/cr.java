package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class cr extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m1524g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.onChange(z);
            m1524g = this.a.m1524g();
            com.xiaomi.channel.commonutils.logger.b.m1027a("SuperPowerMode:" + m1524g);
            this.a.e();
            if (!m1524g) {
                this.a.a(true);
                return;
            }
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.g(xMPushService, 24, null));
        }
    }
}
