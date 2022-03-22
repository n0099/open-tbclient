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
/* loaded from: classes7.dex */
public final class z extends bk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f965a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(String str, long j, XMPushService xMPushService, l lVar) {
        super(str, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), xMPushService, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xMPushService;
        this.f965a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bkVar) == null) {
            String a = bkVar.a("GAID", "gaid");
            String a2 = com.xiaomi.push.i.a((Context) this.a);
            com.xiaomi.channel.commonutils.logger.b.c("gaid :" + a2);
            if (TextUtils.isEmpty(a2) || TextUtils.equals(a, a2)) {
                return;
            }
            bkVar.a("GAID", "gaid", a2);
            ie ieVar = new ie();
            ieVar.b(this.f965a.f44583d);
            ieVar.c(hp.f44364g.f490a);
            ieVar.a(at.a());
            ieVar.a(new HashMap());
            ieVar.m508a().put("gaid", a2);
            byte[] a3 = ip.a(y.a(this.a.getPackageName(), this.f965a.f44583d, ieVar, hf.i));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a3, true);
        }
    }
}
