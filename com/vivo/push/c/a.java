package com.vivo.push.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a extends com.vivo.push.v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.b.c cVar = (com.vivo.push.b.c) yVar;
            com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.f39291a);
            if (a2 == null) {
                com.vivo.push.p.a().a(cVar.h(), 1005, new Object[0]);
                return;
            }
            String a3 = a2.a();
            if (a2.c()) {
                com.vivo.push.p.a().a(cVar.h(), 1004, new Object[0]);
                yVar = new com.vivo.push.b.e();
            } else {
                int a4 = com.vivo.push.util.r.a(cVar);
                if (a4 != 0) {
                    com.vivo.push.p.a().a(cVar.h(), a4, new Object[0]);
                    return;
                }
            }
            com.vivo.push.a.a.a(this.f39291a, a3, yVar);
        }
    }
}
