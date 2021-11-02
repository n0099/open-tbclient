package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fw;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hw;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
public final class x extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f71533a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ie f987a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f988a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i2, ie ieVar, ib ibVar, XMPushService xMPushService) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), ieVar, ibVar, xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f987a = ieVar;
        this.f71533a = ibVar;
        this.f988a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send ack message for clear push message." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                hw hwVar = new hw();
                hwVar.c(hp.D.f514a);
                hwVar.a(this.f987a.m468a());
                hwVar.a(this.f987a.a());
                hwVar.b(this.f987a.b());
                hwVar.e(this.f987a.c());
                hwVar.a(0L);
                hwVar.d("success clear push message.");
                y.a(this.f988a, y.b(this.f71533a.b(), this.f71533a.m454a(), hwVar, hf.f71079i));
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e2);
                this.f988a.a(10, e2);
            }
        }
    }
}
