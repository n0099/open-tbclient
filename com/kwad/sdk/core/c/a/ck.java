package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ck implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfigMap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, templateConfigMap, jSONObject) == null) || jSONObject == null) {
            return;
        }
        SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
        templateConfigMap.downloadPopWindowConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("downloadPopWindowConfig"));
        SdkConfigData.TemplateConfig templateConfig2 = new SdkConfigData.TemplateConfig();
        templateConfigMap.interactPageConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("interactPageConfig"));
        SdkConfigData.TemplateConfig templateConfig3 = new SdkConfigData.TemplateConfig();
        templateConfigMap.interactPageDialogTipsConfig = templateConfig3;
        templateConfig3.parseJson(jSONObject.optJSONObject("interactPageDialogTipsConfig"));
        SdkConfigData.TemplateConfig templateConfig4 = new SdkConfigData.TemplateConfig();
        templateConfigMap.insertScreenTemplateConfig = templateConfig4;
        templateConfig4.parseJson(jSONObject.optJSONObject("insertScreenTemplateConfig"));
        SdkConfigData.TemplateConfig templateConfig5 = new SdkConfigData.TemplateConfig();
        templateConfigMap.interstitialAdConfig = templateConfig5;
        templateConfig5.parseJson(jSONObject.optJSONObject("interstitialAdConfig"));
        SdkConfigData.TemplateConfig templateConfig6 = new SdkConfigData.TemplateConfig();
        templateConfigMap.couponOpenConfig = templateConfig6;
        templateConfig6.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        SdkConfigData.TemplateConfig templateConfig7 = new SdkConfigData.TemplateConfig();
        templateConfigMap.couponInfoConfig = templateConfig7;
        templateConfig7.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, templateConfigMap, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "downloadPopWindowConfig", templateConfigMap.downloadPopWindowConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "interactPageConfig", templateConfigMap.interactPageConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "interactPageDialogTipsConfig", templateConfigMap.interactPageDialogTipsConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "insertScreenTemplateConfig", templateConfigMap.insertScreenTemplateConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "interstitialAdConfig", templateConfigMap.interstitialAdConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
            com.kwad.sdk.utils.q.a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
