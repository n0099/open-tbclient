package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.e;
/* loaded from: classes7.dex */
public final class g implements IPushActionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e.a a;
    public final /* synthetic */ e b;

    public g(e eVar, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = eVar;
        this.a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 0) {
                Object[] b = this.a.b();
                if (b != null && b.length != 0) {
                    this.b.a((String) this.a.b()[0]);
                    return;
                } else {
                    com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                    return;
                }
            }
            this.b.k = null;
            bVar = this.b.j;
            bVar.b("APP_TOKEN");
        }
    }
}
