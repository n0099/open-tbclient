package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class q implements IPushActionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p.a f42193a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f42194b;

    public q(p pVar, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42194b = pVar;
        this.f42193a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 0) {
                Object[] b2 = this.f42193a.b();
                if (b2 != null && b2.length != 0) {
                    this.f42194b.a((String) this.f42193a.b()[0]);
                    return;
                } else {
                    com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                    return;
                }
            }
            this.f42194b.l = null;
            aVar = this.f42194b.k;
            aVar.c("APP_TOKEN");
        }
    }
}
