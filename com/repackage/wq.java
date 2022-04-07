package com.repackage;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uq;
import java.util.Map;
/* loaded from: classes7.dex */
public class wq implements i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uq a;
    public final BDHttpDns b;
    public final BDHttpDns.CachePolicy c;
    public final com.baidu.bdhttpdns.i d;

    public wq(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BDHttpDns j = BDHttpDns.j(context);
        this.b = j;
        this.a = j.a();
        this.c = this.b.f();
        this.d = this.b.g();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), dVar, map, str}) == null) {
            if (i != -1) {
                if (i != 0) {
                    xq.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                } else {
                    for (Map.Entry<String, i.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        i.e value = entry.getValue();
                        if (value != null) {
                            uq.a aVar = new uq.a();
                            aVar.a(value.b());
                            aVar.e(System.currentTimeMillis() / 1000);
                            aVar.b(value.a());
                            this.a.c(key, aVar);
                        } else if (this.c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                            this.a.f(key);
                        }
                    }
                }
            } else if (dVar.equals(i.d.a) && this.c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.a.f(str2);
                }
            }
            if (this.b.h() <= 0 || this.d.C()) {
                return;
            }
            this.d.s(true);
            xq.a("preResolve has finished", new Object[0]);
        }
    }
}
