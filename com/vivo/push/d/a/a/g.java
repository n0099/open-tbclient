package com.vivo.push.d.a.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
/* loaded from: classes10.dex */
public final class g extends a<com.vivo.push.d.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.vivo.push.d.a.a aVar, h hVar) {
        super("InitNode", aVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1], (h) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.vivo.push.d.a.a.a
    public final /* synthetic */ int a(com.vivo.push.d.a.a aVar) {
        Context b = com.vivo.push.d.a.a().b();
        com.vivo.push.e.a().a(b);
        String c = aVar.c();
        u.d("InitNode", "PushMessageReceiver " + b.getPackageName() + " ; requestId = " + c);
        return 0;
    }
}
