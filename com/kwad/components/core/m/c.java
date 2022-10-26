package com.kwad.components.core.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c IR;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c ox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (IR == null) {
                synchronized (c.class) {
                    if (IR == null) {
                        IR = new c();
                    }
                }
            }
            return IR;
        }
        return (c) invokeV.objValue;
    }

    public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, jSONObject, fVar) == null) {
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                com.kwad.sdk.core.e.b.d("AdEventHelper", "processAdImpress notImpression: false");
            }
            com.kwad.sdk.core.report.a.b(adTemplate, (JSONObject) null, fVar);
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, adTemplate) { // from class: com.kwad.components.core.m.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c IS;
                public final /* synthetic */ AdTemplate kp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.IS = this;
                    this.kp = adTemplate;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.a.a lP;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (lP = com.kwad.components.core.a.a.lP()) == null) {
                        return;
                    }
                    lP.j(com.kwad.sdk.core.response.a.d.ca(this.kp));
                }
            });
            com.kwad.components.core.a.f.mb().I(adTemplate);
        }
    }
}
