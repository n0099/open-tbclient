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
    public String f1009a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1010a;
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
        this.f1009a = str;
        this.f1010a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "register app" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        bg.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t m680a = u.m680a((Context) this.a);
            if (m680a == null) {
                try {
                    m680a = u.a(this.a, this.f1009a, this.b, this.c);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
                }
            }
            if (m680a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
                x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("do registration now.");
            Collection m637a = bg.a().m637a("5");
            if (m637a.isEmpty()) {
                bVar = m680a.a(this.a);
                ah.a(this.a, bVar);
                bg.a().a(bVar);
            } else {
                bVar = (bg.b) m637a.iterator().next();
            }
            if (!this.a.m597c()) {
                x.a(this.f1009a, this.f1010a);
                this.a.a(true);
                return;
            }
            try {
                if (bVar.f932a == bg.c.c) {
                    ah.a(this.a, this.f1009a, this.f1010a);
                } else if (bVar.f932a == bg.c.a) {
                    x.a(this.f1009a, this.f1010a);
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.b(xMPushService2, bVar));
                }
            } catch (gh e2) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
                this.a.a(10, e2);
            }
        }
    }
}
