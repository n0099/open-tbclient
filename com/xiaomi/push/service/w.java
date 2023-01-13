package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;
/* loaded from: classes8.dex */
public class w extends XMPushService.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public String f1032a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1033a;
    public String b;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
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
        this.f1032a = str;
        this.f1033a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo673a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "register app" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo394a() {
        bg.b next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t m754a = u.m754a((Context) this.a);
            if (m754a == null) {
                try {
                    m754a = u.a(this.a, this.f1032a, this.b, this.c);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
                }
            }
            if (m754a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
                x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m103a("do registration now.");
            Collection<bg.b> m711a = bg.a().m711a("5");
            if (m711a.isEmpty()) {
                next = m754a.a(this.a);
                ah.a(this.a, next);
                bg.a().a(next);
            } else {
                next = m711a.iterator().next();
            }
            if (!this.a.m671c()) {
                x.a(this.f1032a, this.f1033a);
                this.a.a(true);
                return;
            }
            try {
                if (next.f955a == bg.c.c) {
                    ah.a(this.a, this.f1032a, this.f1033a);
                } else if (next.f955a == bg.c.a) {
                    x.a(this.f1032a, this.f1033a);
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.b(xMPushService2, next));
                }
            } catch (gh e2) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
            }
        }
    }
}
