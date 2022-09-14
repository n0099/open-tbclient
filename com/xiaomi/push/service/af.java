package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ia;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public final class af extends XMPushService.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ii f885a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f886a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, ii iiVar, Cif cif, XMPushService xMPushService) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), iiVar, cif, xMPushService};
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
        this.f885a = iiVar;
        this.a = cif;
        this.f886a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send ack message for clear push message." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ia iaVar = new ia();
                iaVar.c(ht.D.f506a);
                iaVar.a(this.f885a.m481a());
                iaVar.a(this.f885a.a());
                iaVar.b(this.f885a.b());
                iaVar.e(this.f885a.c());
                iaVar.a(0L);
                iaVar.d("success clear push message.");
                ah.a(this.f886a, ah.b(this.a.b(), this.a.m467a(), iaVar, hj.i));
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e);
                this.f886a.a(10, e);
            }
        }
    }
}
