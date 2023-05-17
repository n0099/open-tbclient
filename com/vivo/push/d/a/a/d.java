package com.vivo.push.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;
    public j b;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new n();
        this.b = new k();
    }

    public final void a(com.vivo.push.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            i iVar = new i(this.a, this.b, com.vivo.push.d.a.a().c());
            f fVar = new f(aVar, iVar);
            c cVar = new c(aVar, iVar);
            g gVar = new g(aVar, iVar);
            e eVar = new e(aVar, iVar);
            fVar.a((a) cVar);
            cVar.a((a) gVar);
            gVar.a((a) eVar);
            iVar.a((a) fVar);
            fVar.a();
        }
    }
}
