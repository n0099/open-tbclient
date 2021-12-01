package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    public static final int DEFAULT_SPLASH_TIME_OUT = 5000;
    public static final long serialVersionUID = -7796837168148055391L;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject abConfig;
    public JSONObject appConfig;
    public CouponActiveConfig couponActiveConfig;
    public List<com.kwad.sdk.c.kwai.c> h5PreloadConfigs;
    public JSONObject mDataJsonObj;
    public JSONObject mOriginalObjData;
    public long requestInterval;
    public TemplateConfig splashConfig;
    public TemplateConfig templateConfig;
    public TemplateConfigMap templateConfigMap;

    /* loaded from: classes2.dex */
    public static class CouponActiveConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6375241669684789095L;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivityInfo activityInfo;
        public String bottomTitle;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public int popUpShowTimeSeconds;
        public String secondTitle;
        public String title;
        public int videoSeconds;
        public int videoThreshold;

        public CouponActiveConfig() {
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
            this.title = "抽红包兑奖";
            this.secondTitle = "累计到100元可兑换京东卡";
            this.bottomTitle = "刷满5个视频抽红包，每个视频观看>5秒";
        }
    }

    /* loaded from: classes2.dex */
    public static class TemplateConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
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

        public boolean notEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.h5Version) || TextUtils.isEmpty(this.h5Checksum)) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class TemplateConfigMap extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6512236636350788192L;
        public transient /* synthetic */ FieldHolder $fh;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public TemplateConfig downloadLandingPageConfig;
        public TemplateConfig downloadPopWindowConfig;
        public TemplateConfig insertScreenTemplateConfig;
        public TemplateConfig interactPageDialogTipsConfig;
        public TemplateConfig rewardReflowConfig;
        public TemplateConfig secDownloadPopWindowConfig;

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
        this.h5PreloadConfigs = new ArrayList();
        this.templateConfig = new TemplateConfig();
        this.splashConfig = new TemplateConfig();
        this.templateConfigMap = new TemplateConfigMap();
        this.couponActiveConfig = new CouponActiveConfig();
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

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.mOriginalObjData = jSONObject;
                String optString = jSONObject.optString("data");
                e.a(jSONObject.optString("egid"));
                JSONObject jSONObject2 = new JSONObject(d.b(optString));
                this.mDataJsonObj = jSONObject2;
                this.requestInterval = jSONObject2.optLong("requestInterval");
                JSONObject optJSONObject = this.mDataJsonObj.optJSONObject("abConfig");
                this.abConfig = optJSONObject;
                com.kwad.sdk.core.config.a.a(optJSONObject);
                this.appConfig = this.mDataJsonObj.optJSONObject(PrefetchEvent.EVENT_KEY_APP_CONFIG);
                this.h5PreloadConfigs = t.a(this.mDataJsonObj.optString("h5PreloadConfigs"), new com.kwad.sdk.core.c<com.kwad.sdk.c.kwai.c>(this) { // from class: com.kwad.sdk.core.response.model.SdkConfigData.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SdkConfigData a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.c
                    /* renamed from: b */
                    public com.kwad.sdk.c.kwai.c a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.sdk.c.kwai.c() : (com.kwad.sdk.c.kwai.c) invokeV.objValue;
                    }
                });
                com.kwad.sdk.core.config.a.a(this.appConfig);
                this.templateConfig.parseJson(this.mDataJsonObj.optJSONObject("templateConfig"));
                this.splashConfig.parseJson(this.mDataJsonObj.optJSONObject("splashConfig"));
                this.templateConfigMap.parseJson(this.mDataJsonObj.optJSONObject("templateConfigMap"));
                this.couponActiveConfig.parseJson(this.mDataJsonObj.optJSONObject("couponActiveConfig"));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDataJsonObj : (JSONObject) invokeV.objValue;
    }
}
