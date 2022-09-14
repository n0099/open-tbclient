package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public final class ad extends XMPushService.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f881a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f882a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(int i, XMPushService xMPushService, Cif cif, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), xMPushService, cif, str};
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
        this.f881a = xMPushService;
        this.a = cif;
        this.f882a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send app absent ack message for message." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                Cif a = y.a((Context) this.f881a, this.a);
                a.m466a().a("absent_target_package", this.f882a);
                ah.a(this.f881a, a);
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                this.f881a.a(10, e);
            }
        }
    }
}
