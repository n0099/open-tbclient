package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    public static final int DEFAULT_SPLASH_TIME_OUT = 5000;
    public static final long serialVersionUID = -7796837168148055391L;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject abConfig;
    public long requestInterval;
    public TemplateConfig rewardMiddleEndcardConfig;
    public TemplateConfig rewardMiniCardConfig;
    public TemplateConfig splashConfig;
    public TemplateConfig templateConfig;
    public TemplateConfigMap templateConfigMap;

    /* loaded from: classes7.dex */
    public static class TemplateConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6943205584670122269L;
        public transient /* synthetic */ FieldHolder $fh;
        public String h5Checksum;
        public String h5Url;
        public String h5Version;

        public TemplateConfig() {
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
    }

    /* loaded from: classes7.dex */
    public static class TemplateConfigMap extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6512236636350788192L;
        public transient /* synthetic */ FieldHolder $fh;
        public TemplateConfig downloadPopWindowConfig;

        public TemplateConfigMap() {
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
    }

    public SdkConfigData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestInterval = 3600L;
        this.templateConfig = new TemplateConfig();
        this.splashConfig = new TemplateConfig();
        this.rewardMiniCardConfig = new TemplateConfig();
        this.rewardMiddleEndcardConfig = new TemplateConfig();
        this.templateConfigMap = new TemplateConfigMap();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                String optString = jSONObject.optString("data");
                e.a(jSONObject.optString("egid"));
                JSONObject jSONObject2 = new JSONObject(d.b(optString));
                this.requestInterval = jSONObject2.optLong("requestInterval");
                JSONObject optJSONObject = jSONObject2.optJSONObject("abConfig");
                this.abConfig = optJSONObject;
                com.kwad.sdk.core.config.b.a(optJSONObject);
                this.templateConfig.parseJson(jSONObject2.optJSONObject("templateConfig"));
                this.splashConfig.parseJson(jSONObject2.optJSONObject("splashConfig"));
                this.rewardMiniCardConfig.parseJson(jSONObject2.optJSONObject("rewardMiniCardConfig"));
                this.rewardMiddleEndcardConfig.parseJson(jSONObject2.optJSONObject("rewardMiddleEndcardConfig"));
                this.templateConfigMap.parseJson(jSONObject2.optJSONObject("templateConfigMap"));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, "requestInterval", this.requestInterval);
            o.a(json, "abConfig", this.abConfig);
            o.a(json, "templateConfig", this.templateConfig);
            o.a(json, "splashConfig", this.splashConfig);
            o.a(json, "rewardMiniCardConfig", this.rewardMiniCardConfig);
            o.a(json, "rewardMiddleEndcardConfig", this.rewardMiddleEndcardConfig);
            o.a(json, "templateConfigMap", this.templateConfigMap);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
