package com.cmic.sso.sdk.b.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.b.b.g;
import com.cmic.sso.sdk.d.r;
/* loaded from: classes9.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final e f69496b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69497c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (g) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69497c = false;
        this.f69496b = eVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f69497c) {
            return;
        }
        String a2 = r.a(true);
        String a3 = r.a(true, "1".equals(aVar.b("operatortype", "")));
        aVar.a("ipv4_list", a2);
        aVar.a("ipv6_list", a3);
        com.cmic.sso.sdk.b.b.a c2 = this.f69496b.c();
        if (!aVar.b("isCloseIpv4", false)) {
            c2.s(a2);
        }
        if (!aVar.b("isCloseIpv6", false)) {
            c2.t(a3);
        }
        c2.p(c2.w(aVar.b("appkey")));
        this.f69496b.a(c2);
        this.f69496b.a(true);
        this.f69498a = this.f69496b.b().toString();
        this.f69497c = true;
    }
}
