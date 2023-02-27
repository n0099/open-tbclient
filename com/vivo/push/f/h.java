package com.vivo.push.f;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class h extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.vivo.push.o oVar) {
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
            com.vivo.push.b.i iVar = (com.vivo.push.b.i) oVar;
            String e = iVar.e();
            com.vivo.push.e.a().a(iVar.h(), iVar.i(), e);
            if (TextUtils.isEmpty(iVar.h()) && !TextUtils.isEmpty(e)) {
                com.vivo.push.e.a().a(e);
            }
            com.vivo.push.m.b(new i(this, e, iVar));
            String f = iVar.f();
            if (!TextUtils.isEmpty(f) && iVar.i() == 0) {
                com.vivo.push.e.a().a(Long.parseLong(f) + System.currentTimeMillis());
            }
        }
    }
}
