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
/* loaded from: classes8.dex */
public final class x extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ib a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ie f963a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f964a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i, ie ieVar, ib ibVar, XMPushService xMPushService) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), ieVar, ibVar, xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f963a = ieVar;
        this.a = ibVar;
        this.f964a = xMPushService;
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
                hwVar.c(hp.D.f490a);
                hwVar.a(this.f963a.m503a());
                hwVar.a(this.f963a.a());
                hwVar.b(this.f963a.b());
                hwVar.e(this.f963a.c());
                hwVar.a(0L);
                hwVar.d("success clear push message.");
                y.a(this.f964a, y.b(this.a.b(), this.a.m489a(), hwVar, hf.i));
            } catch (fw e) {
                com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
                this.f964a.a(10, e);
            }
        }
    }
}
