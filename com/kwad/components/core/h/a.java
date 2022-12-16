package com.kwad.components.core.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.k.kwai.b;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends m<com.kwad.components.core.k.a, AdResultData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b EI;

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.EI = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.m
    /* renamed from: d */
    public void afterParseData(AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, adResultData) == null) {
            super.afterParseData(adResultData);
            e(adResultData);
        }
    }

    public static void e(AdResultData adResultData) {
        com.kwad.components.core.j.a og;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, adResultData) == null) {
            for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
                AdInfo bQ = d.bQ(adTemplate);
                if (com.kwad.sdk.core.response.a.a.aC(bQ)) {
                    if (com.kwad.sdk.core.response.a.a.aA(bQ).size() == 0) {
                        og = com.kwad.components.core.j.a.og();
                        i = 21005;
                        og.e(adTemplate, i);
                    }
                } else if (com.kwad.sdk.core.response.a.a.aE(bQ) && TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(bQ))) {
                    og = com.kwad.components.core.j.a.og();
                    i = 21006;
                    og.e(adTemplate, i);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.m
    @NonNull
    /* renamed from: ah */
    public AdResultData parseData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData(this.EI.HS);
            adResultData.parseJson(jSONObject);
            return adResultData;
        }
        return (AdResultData) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: fe */
    public com.kwad.components.core.k.a createRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.kwad.components.core.k.a(this.EI) : (com.kwad.components.core.k.a) invokeV.objValue;
    }
}
