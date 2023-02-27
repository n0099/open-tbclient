package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.e;
import com.vivo.push.util.u;
/* loaded from: classes8.dex */
public final class g implements IPushActionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ e.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ e d;

    public g(e eVar, e.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, aVar, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = eVar;
        this.a = aVar;
        this.b = str;
        this.c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 0) {
                Object[] b = this.a.b();
                if (b != null && b.length != 0) {
                    this.d.a((String) this.a.b()[0]);
                    com.vivo.push.d.a.a().e().a(this.b);
                    com.vivo.push.d.a.a().e().b(this.c);
                    return;
                }
                u.a("PushClientManager", "bind app result is null");
                return;
            }
            this.d.j = null;
            com.vivo.push.d.a.a().e().h();
        }
    }
}
