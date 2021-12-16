package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkApi;
import org.json.JSONException;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public class SdkConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEF_NIGHT_THEME_STYLE_FILE_NAME = "ks_adsdk_night_styles.xml";
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 2;
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_UNKNOWN = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appId;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appKey;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appName;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appWebKey;
    @KsAdSdkApi
    @Keep
    public boolean canReadICCID;
    @KsAdSdkApi
    @Keep
    public boolean canReadMacAddress;
    @KsAdSdkApi
    @Keep
    public boolean canReadNearbyWifiList;
    @KsAdSdkApi
    @Keep
    public boolean enableDebug;
    @Nullable
    @KsAdSdkApi
    @Keep
    public KsCustomController ksCustomController;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String nightThemeStyleAssetsFileName;
    @Nullable
    @KsAdSdkApi
    @Keep
    public boolean showNotification;

    /* renamed from: com.kwad.sdk.api.SdkConfig$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String appId;
        @Nullable
        public String appKey;
        @Nullable
        public String appName;
        @Nullable
        public String appWebKey;
        public boolean canReadICCID;
        public boolean canReadMacAddress;
        public boolean canReadNearbyWifiList;
        public boolean enableDebug;
        @Nullable
        public KsCustomController ksCustomController;
        public String nightThemeStyleAssetsFileName;
        public boolean showNotification;

        @KsAdSdkApi
        @Keep
        public Builder() {
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
            this.showNotification = true;
            this.canReadMacAddress = true;
            this.canReadNearbyWifiList = true;
            this.canReadICCID = true;
            this.nightThemeStyleAssetsFileName = SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME;
        }

        @KsAdSdkApi
        @Keep
        public Builder appId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.appId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder appKey(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.appKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder appName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.appName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder appWebKey(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.appWebKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public SdkConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new SdkConfig(this, null) : (SdkConfig) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadICCID(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.canReadICCID = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadMacAddress(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.canReadMacAddress = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadNearbyWifiList(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.canReadNearbyWifiList = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder customController(KsCustomController ksCustomController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksCustomController)) == null) {
                this.ksCustomController = ksCustomController;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.enableDebug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder nightThemeStyleAssetsFileName(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.nightThemeStyleAssetsFileName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder showNotification(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.showNotification = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    @KsAdSdkApi
    @Keep
    public SdkConfig(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appKey = builder.appKey;
        this.appWebKey = builder.appWebKey;
        this.showNotification = builder.showNotification;
        this.canReadMacAddress = builder.canReadMacAddress;
        this.canReadNearbyWifiList = builder.canReadNearbyWifiList;
        this.canReadICCID = builder.canReadICCID;
        this.nightThemeStyleAssetsFileName = builder.nightThemeStyleAssetsFileName;
        this.ksCustomController = builder.ksCustomController;
    }

    public /* synthetic */ SdkConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static SdkConfig create(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Builder builder = new Builder();
            try {
                JSONObject jSONObject = new JSONObject(str);
                builder.enableDebug = jSONObject.optBoolean("enableDebug");
                builder.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                builder.appName = jSONObject.optString("appName");
                builder.appKey = jSONObject.optString("appKey");
                builder.appWebKey = jSONObject.optString("appWebKey");
                builder.showNotification = jSONObject.optBoolean("showNotification");
                builder.canReadMacAddress = jSONObject.optBoolean("canReadMacAddress");
                builder.canReadNearbyWifiList = jSONObject.optBoolean("canReadNearbyWifiList");
                builder.canReadICCID = jSONObject.optBoolean("canReadICCID");
                builder.nightThemeStyleAssetsFileName = jSONObject.optString("nightThemeStyleAssetsFileName");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return builder.build();
        }
        return (SdkConfig) invokeL.objValue;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadICCID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canReadICCID : invokeV.booleanValue;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadMacAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.canReadMacAddress : invokeV.booleanValue;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadNearbyWifiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.canReadNearbyWifiList : invokeV.booleanValue;
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("enableDebug", this.enableDebug);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("appName", this.appName);
                jSONObject.put("appKey", this.appKey);
                jSONObject.put("appWebKey", this.appWebKey);
                jSONObject.put("showNotification", this.showNotification);
                jSONObject.put("canReadMacAddress", this.canReadMacAddress);
                jSONObject.put("canReadNearbyWifiList", this.canReadNearbyWifiList);
                jSONObject.put("canReadICCID", this.canReadICCID);
                jSONObject.put("nightThemeStyleAssetsFileName", this.nightThemeStyleAssetsFileName);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
