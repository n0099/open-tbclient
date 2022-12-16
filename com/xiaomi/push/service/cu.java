package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class cu extends XMPushService.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f998a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f999a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, Integer.valueOf(i), Integer.valueOf(i2), str, bArr};
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
        this.a = xMPushService;
        this.b = i2;
        this.f998a = str;
        this.f999a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "clear account cache." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        fx fxVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u.m692a((Context) this.a);
            bg.a().m650a("5");
            com.xiaomi.push.ae.a(this.b);
            fxVar = this.a.f869a;
            fxVar.c(fx.a());
            com.xiaomi.channel.commonutils.logger.b.m99a("clear account and start registration. " + this.f998a);
            this.a.a(this.f999a, this.f998a);
        }
    }
}
