package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class bz extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f43649a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(XMPushService xMPushService, Handler handler) {
        super(handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43649a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m557g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.onChange(z);
            m557g = this.f43649a.m557g();
            com.xiaomi.channel.commonutils.logger.b.m70a("SuperPowerMode:" + m557g);
            this.f43649a.e();
            if (!m557g) {
                this.f43649a.a(true);
                return;
            }
            XMPushService xMPushService = this.f43649a;
            xMPushService.a(new XMPushService.f(xMPushService, 24, null));
        }
    }
}
