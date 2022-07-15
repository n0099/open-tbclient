package com.kwad.components.core.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
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

    @NonNull
    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c();
                    }
                }
            }
            return a;
        }
        return (c) invokeV.objValue;
    }

    public final void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, jSONObject, fVar) == null) {
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.a(DevelopMangerComponents.class)) != null) {
                com.kwad.sdk.core.d.b.a("AdEventHelper", "processAdImpress notImpression: false");
            }
            com.kwad.sdk.core.report.a.a(adTemplate, (JSONObject) null, fVar);
            com.kwad.sdk.utils.g.a(new Runnable(this, adTemplate) { // from class: com.kwad.components.core.l.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;
                public final /* synthetic */ c b;

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
                    this.b = this;
                    this.a = adTemplate;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.a.a a2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (a2 = com.kwad.components.core.a.a.a()) == null) {
                        return;
                    }
                    a2.a(com.kwad.sdk.core.response.a.d.t(this.a));
                }
            });
        }
    }
}
