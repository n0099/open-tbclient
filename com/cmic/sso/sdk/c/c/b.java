package com.cmic.sso.sdk.c.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.e.p;
/* loaded from: classes4.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (g) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.b = eVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.c) {
            return;
        }
        com.cmic.sso.sdk.c.b.a c = this.b.c();
        if (!aVar.b("isCloseIpv4", false)) {
            c.q(p.a(true));
        }
        if (!aVar.b("isCloseIpv6", false)) {
            c.r(p.b(true));
        }
        c.n(c.u(aVar.b("appkey")));
        this.b.a(c);
        this.b.a(true);
        this.a = this.b.b().toString();
        this.c = true;
    }
}
