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
/* loaded from: classes10.dex */
public final class aa extends bk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f77720a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f875a;

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
        this.f77720a = xMPushService;
        this.f875a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bkVar) == null) {
            com.xiaomi.push.ax a2 = com.xiaomi.push.ax.a(this.f77720a);
            String a3 = bkVar.a("MSAID", "msaid");
            String str = a2.a() + a2.mo152b() + a2.c() + a2.d();
            if (TextUtils.isEmpty(str) || TextUtils.equals(a3, str)) {
                return;
            }
            bkVar.a("MSAID", "msaid", str);
            ie ieVar = new ie();
            ieVar.b(this.f875a.f77838d);
            ieVar.c(hp.f77442g.f513a);
            ieVar.a(at.a());
            ieVar.a(new HashMap());
            a2.a(ieVar.m469a());
            byte[] a4 = ip.a(y.a(this.f77720a.getPackageName(), this.f875a.f77838d, ieVar, hf.f77389i));
            XMPushService xMPushService = this.f77720a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
