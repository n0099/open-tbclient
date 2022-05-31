package com.vivo.push.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class d extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.vivo.push.o oVar) {
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
            com.vivo.push.e.a().a(iVar.g(), iVar.h(), e);
            if (TextUtils.isEmpty(iVar.g()) && !TextUtils.isEmpty(e)) {
                com.vivo.push.e.a().a(e);
            }
            com.vivo.push.m.b(new e(this, e, iVar));
        }
    }
}
