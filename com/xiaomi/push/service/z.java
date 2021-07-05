package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.bk;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class z extends bk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f43699a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f984a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(String str, long j, XMPushService xMPushService, l lVar) {
        super(str, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), xMPushService, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43699a = xMPushService;
        this.f984a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bkVar) == null) {
            String a2 = bkVar.a("GAID", "gaid");
            String a3 = com.xiaomi.push.i.a((Context) this.f43699a);
            com.xiaomi.channel.commonutils.logger.b.c("gaid :" + a3);
            if (TextUtils.isEmpty(a3) || TextUtils.equals(a2, a3)) {
                return;
            }
            bkVar.a("GAID", "gaid", a3);
            ie ieVar = new ie();
            ieVar.b(this.f984a.f43676d);
            ieVar.c(hp.f43293g.f509a);
            ieVar.a(at.a());
            ieVar.a(new HashMap());
            ieVar.m466a().put("gaid", a3);
            byte[] a4 = ip.a(y.a(this.f43699a.getPackageName(), this.f984a.f43676d, ieVar, hf.f43244i));
            XMPushService xMPushService = this.f43699a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
