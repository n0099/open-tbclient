package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Collection;
/* loaded from: classes4.dex */
public class o extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public String f971a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f972a;

    /* renamed from: b  reason: collision with root package name */
    public String f63867b;

    /* renamed from: c  reason: collision with root package name */
    public String f63868c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, str, str2, str3, bArr};
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
        this.a = xMPushService;
        this.f971a = str;
        this.f972a = bArr;
        this.f63867b = str2;
        this.f63868c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "register app" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        av.b next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l a = m.a((Context) this.a);
            if (a == null) {
                try {
                    a = m.a(this.a, this.f971a, this.f63867b, this.f63868c);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
                }
            }
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                p.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<av.b> m653a = av.a().m653a("5");
            if (m653a.isEmpty()) {
                next = a.a(this.a);
                y.a(this.a, next);
                av.a().a(next);
            } else {
                next = m653a.iterator().next();
            }
            if (!this.a.m619c()) {
                this.a.a(true);
                return;
            }
            try {
                if (next.f914a == av.c.f63833c) {
                    y.a(this.a, this.f971a, this.f972a);
                } else if (next.f914a == av.c.a) {
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(xMPushService2, next));
                }
            } catch (fw e3) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
                this.a.a(10, e3);
            }
        }
    }
}
