package com.vivo.push.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class b extends com.vivo.push.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.vivo.push.o oVar) {
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
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.model.b a = com.vivo.push.util.aa.a(this.a, com.vivo.push.d.a.a().f());
            try {
                if (((com.vivo.push.b.d) oVar).d()) {
                    b = j.a(this.a);
                } else {
                    b = j.b(this.a);
                }
                if (b) {
                    com.vivo.push.model.b a2 = com.vivo.push.util.aa.a(this.a, com.vivo.push.d.a.a().f());
                    if (a != null && a2 != null && a2.a() != null && a2.a().equals(a.a())) {
                        return;
                    }
                    if (a != null && a.a() != null) {
                        com.vivo.push.a.a.a(this.a, a.a(), new com.vivo.push.b.y(a.a()));
                    }
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.a, a2.a(), new com.vivo.push.b.f());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
