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

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f43683a;

    /* renamed from: a  reason: collision with other field name */
    public String f966a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f967a;

    /* renamed from: b  reason: collision with root package name */
    public String f43684b;

    /* renamed from: c  reason: collision with root package name */
    public String f43685c;

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
        this.f43683a = xMPushService;
        this.f966a = str;
        this.f967a = bArr;
        this.f43684b = str2;
        this.f43685c = str3;
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
            l a2 = m.a((Context) this.f43683a);
            if (a2 == null) {
                try {
                    a2 = m.a(this.f43683a, this.f966a, this.f43684b, this.f43685c);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
                }
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("no account for mipush");
                p.a(this.f43683a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
                return;
            }
            Collection<av.b> m601a = av.a().m601a("5");
            if (m601a.isEmpty()) {
                next = a2.a(this.f43683a);
                y.a(this.f43683a, next);
                av.a().a(next);
            } else {
                next = m601a.iterator().next();
            }
            if (!this.f43683a.m567c()) {
                this.f43683a.a(true);
                return;
            }
            try {
                if (next.f909a == av.c.f43604c) {
                    y.a(this.f43683a, this.f966a, this.f967a);
                } else if (next.f909a == av.c.f43602a) {
                    XMPushService xMPushService = this.f43683a;
                    XMPushService xMPushService2 = this.f43683a;
                    xMPushService2.getClass();
                    xMPushService.a(new XMPushService.a(xMPushService2, next));
                }
            } catch (fw e3) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
                this.f43683a.a(10, e3);
            }
        }
    }
}
