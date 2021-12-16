package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class eg implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfigMap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eg() {
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
        templateConfigMap.interactPageDialogTipsConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("interactPageDialogTipsConfig"));
        SdkConfigData.TemplateConfig templateConfig3 = new SdkConfigData.TemplateConfig();
        templateConfigMap.insertScreenTemplateConfig = templateConfig3;
        templateConfig3.parseJson(jSONObject.optJSONObject("insertScreenTemplateConfig"));
        SdkConfigData.TemplateConfig templateConfig4 = new SdkConfigData.TemplateConfig();
        templateConfigMap.couponOpenConfig = templateConfig4;
        templateConfig4.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        SdkConfigData.TemplateConfig templateConfig5 = new SdkConfigData.TemplateConfig();
        templateConfigMap.couponInfoConfig = templateConfig5;
        templateConfig5.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        SdkConfigData.TemplateConfig templateConfig6 = new SdkConfigData.TemplateConfig();
        templateConfigMap.downloadLandingPageConfig = templateConfig6;
        templateConfig6.parseJson(jSONObject.optJSONObject("downloadLandingPageConfig"));
        SdkConfigData.TemplateConfig templateConfig7 = new SdkConfigData.TemplateConfig();
        templateConfigMap.secDownloadPopWindowConfig = templateConfig7;
        templateConfig7.parseJson(jSONObject.optJSONObject("secDownloadPopWindowConfig"));
        SdkConfigData.TemplateConfig templateConfig8 = new SdkConfigData.TemplateConfig();
        templateConfigMap.rewardReflowConfig = templateConfig8;
        templateConfig8.parseJson(jSONObject.optJSONObject("rewardReflowConfig"));
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
            com.kwad.sdk.utils.t.a(jSONObject, "downloadPopWindowConfig", templateConfigMap.downloadPopWindowConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "interactPageDialogTipsConfig", templateConfigMap.interactPageDialogTipsConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "insertScreenTemplateConfig", templateConfigMap.insertScreenTemplateConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "downloadLandingPageConfig", templateConfigMap.downloadLandingPageConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "secDownloadPopWindowConfig", templateConfigMap.secDownloadPopWindowConfig);
            com.kwad.sdk.utils.t.a(jSONObject, "rewardReflowConfig", templateConfigMap.rewardReflowConfig);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
