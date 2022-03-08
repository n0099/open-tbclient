package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.e;
/* loaded from: classes8.dex */
public final class g implements IPushActionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e.a a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f59267b;

    public g(e eVar, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59267b = eVar;
        this.a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 0) {
                Object[] b2 = this.a.b();
                if (b2 != null && b2.length != 0) {
                    this.f59267b.a((String) this.a.b()[0]);
                    return;
                } else {
                    com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                    return;
                }
            }
            this.f59267b.k = null;
            bVar = this.f59267b.f59261j;
            bVar.b("APP_TOKEN");
        }
    }
}
