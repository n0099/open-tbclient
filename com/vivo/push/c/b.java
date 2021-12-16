package com.vivo.push.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b extends com.vivo.push.v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.vivo.push.y yVar) {
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
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.model.b a = com.vivo.push.util.s.a(this.a);
            try {
                if (((com.vivo.push.b.d) yVar).d()) {
                    b2 = f.a(this.a);
                } else {
                    b2 = f.b(this.a);
                }
                if (b2) {
                    com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.a);
                    if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                        if (a != null && a.a() != null) {
                            com.vivo.push.a.a.a(this.a, a.a(), new com.vivo.push.b.ac(a.a()));
                        }
                        if (a2 == null || a2.a() == null) {
                            return;
                        }
                        com.vivo.push.a.a.a(this.a, a2.a(), new com.vivo.push.b.f());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
