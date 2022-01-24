package com.xiaomi.push.service;

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
/* loaded from: classes4.dex */
public final class aa extends bk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f876a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(String str, long j2, XMPushService xMPushService, l lVar) {
        super(str, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), xMPushService, lVar};
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
        this.a = xMPushService;
        this.f876a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bkVar) == null) {
            com.xiaomi.push.ax a = com.xiaomi.push.ax.a(this.a);
            String a2 = bkVar.a("MSAID", "msaid");
            String str = a.a() + a.mo213b() + a.c() + a.d();
            if (TextUtils.isEmpty(str) || TextUtils.equals(a2, str)) {
                return;
            }
            bkVar.a("MSAID", "msaid", str);
            ie ieVar = new ie();
            ieVar.b(this.f876a.f61503d);
            ieVar.c(hp.f61254g.f514a);
            ieVar.a(at.a());
            ieVar.a(new HashMap());
            a.a(ieVar.m530a());
            byte[] a3 = ip.a(y.a(this.a.getPackageName(), this.f876a.f61503d, ieVar, hf.f61211i));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a3, true);
        }
    }
}
