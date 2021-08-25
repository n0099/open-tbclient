package com.vivo.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class s implements IPushActionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f76467a;

    public s(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76467a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 0) {
                this.f76467a.l = "";
                aVar2 = this.f76467a.k;
                aVar2.a("APP_TOKEN", "");
                this.f76467a.t();
                this.f76467a.k.c("APP_TAGS");
                return;
            }
            this.f76467a.l = null;
            aVar = this.f76467a.k;
            aVar.c("APP_TOKEN");
        }
    }
}
