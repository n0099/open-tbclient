package com.repackage;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.to;
import com.repackage.vo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class uo implements to.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BDHttpDns.e a;
    public final BDHttpDns b;
    public final vo c;

    public uo(Context context, BDHttpDns.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
        BDHttpDns h = BDHttpDns.h(context);
        this.b = h;
        this.c = h.d();
    }

    @Override // com.repackage.to.a
    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), arrayList, arrayList2, Long.valueOf(j), str}) == null) {
            if (i == -1) {
                xo.a("Async resolve failed, host(%s), dns resolve failed", str);
                BDHttpDns.e eVar = this.a;
                if (eVar != null) {
                    eVar.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2));
                }
            } else if (i != 0) {
                xo.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i));
            } else {
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = arrayList != null ? arrayList.toString() : null;
                objArr[2] = arrayList2 != null ? arrayList2.toString() : null;
                objArr[3] = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS.toString();
                xo.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                vo.a aVar = new vo.a();
                aVar.i(60L);
                aVar.h(System.currentTimeMillis() / 1000);
                aVar.f(arrayList);
                aVar.g(arrayList2);
                this.c.e(str, aVar);
                BDHttpDns.e eVar2 = this.a;
                if (eVar2 != null) {
                    eVar2.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2));
                }
            }
        }
    }
}
