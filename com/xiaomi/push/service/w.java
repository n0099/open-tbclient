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
/* loaded from: classes6.dex */
public final class w extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ib f40710a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f980a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f981a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40711b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(int i2, XMPushService xMPushService, ib ibVar, String str, String str2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), xMPushService, ibVar, str, str2};
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
        this.f980a = xMPushService;
        this.f40710a = ibVar;
        this.f981a = str;
        this.f40711b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send wrong message ack for message." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ib a2 = q.a((Context) this.f980a, this.f40710a);
                a2.f632a.a("error", this.f981a);
                a2.f632a.a("reason", this.f40711b);
                y.a(this.f980a, a2);
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                this.f980a.a(10, e2);
            }
        }
    }
}
