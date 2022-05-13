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
/* loaded from: classes8.dex */
public class o extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public String f947a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f948a;
    public String b;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, str, str2, str3, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xMPushService;
        this.f947a = str;
        this.f948a = bArr;
        this.b = str2;
        this.c = str3;
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
                    a = m.a(this.a, this.f947a, this.b, this.c);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
                }
            }
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                p.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<av.b> m640a = av.a().m640a("5");
            if (m640a.isEmpty()) {
                next = a.a(this.a);
                y.a(this.a, next);
                av.a().a(next);
            } else {
                next = m640a.iterator().next();
            }
            if (!this.a.m606c()) {
                this.a.a(true);
                return;
            }
            try {
                if (next.f890a == av.c.c) {
                    y.a(this.a, this.f947a, this.f948a);
                } else if (next.f890a == av.c.a) {
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(xMPushService2, next));
                }
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
            }
        }
    }
}
