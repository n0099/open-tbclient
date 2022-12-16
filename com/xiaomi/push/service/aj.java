package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.bx;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class aj extends bx.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ t f912a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), xMPushService, tVar};
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
        this.f912a = tVar;
    }

    @Override // com.xiaomi.push.service.bx.a
    public void a(bx bxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bxVar) == null) {
            com.xiaomi.push.ba a = com.xiaomi.push.ba.a(this.a);
            String a2 = bxVar.a("MSAID", "msaid");
            String str = a.b() + a.a() + a.c() + a.d();
            if (TextUtils.isEmpty(str) || TextUtils.equals(a2, str)) {
                return;
            }
            bxVar.a("MSAID", "msaid", str);
            ii iiVar = new ii();
            iiVar.b(this.f912a.d);
            iiVar.c(ht.g.f529a);
            iiVar.a(bd.a());
            iiVar.a(new HashMap());
            a.a(iiVar.m491a());
            byte[] a3 = it.a(ah.a(this.a.getPackageName(), this.f912a.d, iiVar, hj.i));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a3, true);
        }
    }
}
