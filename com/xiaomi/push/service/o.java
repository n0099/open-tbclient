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
/* loaded from: classes10.dex */
public class o extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f78226a;

    /* renamed from: a  reason: collision with other field name */
    public String f970a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f971a;

    /* renamed from: b  reason: collision with root package name */
    public String f78227b;

    /* renamed from: c  reason: collision with root package name */
    public String f78228c;

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
        this.f78226a = xMPushService;
        this.f970a = str;
        this.f971a = bArr;
        this.f78227b = str2;
        this.f78228c = str3;
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
            l a2 = m.a((Context) this.f78226a);
            if (a2 == null) {
                try {
                    a2 = m.a(this.f78226a, this.f970a, this.f78227b, this.f78228c);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
                }
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                p.a(this.f78226a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<av.b> m604a = av.a().m604a("5");
            if (m604a.isEmpty()) {
                next = a2.a(this.f78226a);
                y.a(this.f78226a, next);
                av.a().a(next);
            } else {
                next = m604a.iterator().next();
            }
            if (!this.f78226a.m570c()) {
                this.f78226a.a(true);
                return;
            }
            try {
                if (next.f913a == av.c.f78146c) {
                    y.a(this.f78226a, this.f970a, this.f971a);
                } else if (next.f913a == av.c.f78144a) {
                    XMPushService xMPushService = this.f78226a;
                    XMPushService xMPushService2 = this.f78226a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(xMPushService2, next));
                }
            } catch (fw e3) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
                this.f78226a.a(10, e3);
            }
        }
    }
}
