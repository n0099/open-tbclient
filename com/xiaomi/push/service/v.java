package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fw;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public final class v extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f78592a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f982a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f983a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i2, XMPushService xMPushService, ib ibVar, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), xMPushService, ibVar, str};
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
        this.f982a = xMPushService;
        this.f78592a = ibVar;
        this.f983a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send app absent ack message for message." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ib a2 = q.a((Context) this.f982a, this.f78592a);
                a2.m453a().a("absent_target_package", this.f983a);
                y.a(this.f982a, a2);
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                this.f982a.a(10, e2);
            }
        }
    }
}
