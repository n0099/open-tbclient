package com.vivo.push.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class aj extends com.vivo.push.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
            com.vivo.push.model.b a = com.vivo.push.util.aa.a(this.a, com.vivo.push.d.a.a().f());
            if (a == null) {
                com.vivo.push.e.a().a(cVar.f(), 1005, new Object[0]);
                return;
            }
            String a2 = a.a();
            if (a.c()) {
                com.vivo.push.e.a().a(cVar.f(), 1004, new Object[0]);
                oVar = new com.vivo.push.b.e();
            } else {
                int a3 = com.vivo.push.util.y.a(cVar);
                if (a3 != 0) {
                    com.vivo.push.e.a().a(cVar.f(), a3, new Object[0]);
                    return;
                }
            }
            com.vivo.push.a.a.a(this.a, a2, oVar);
        }
    }
}
