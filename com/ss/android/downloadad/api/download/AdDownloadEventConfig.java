package com.ss.android.downloadad.api.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdDownloadEventConfig implements DownloadEventConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mClickButtonTag;
    public String mClickContinueLabel;
    public String mClickInstallLabel;
    public String mClickItemTag;
    public String mClickLabel;
    public String mClickPauseLabel;
    public String mClickStartLabel;
    public int mDownloadScene;
    public transient Object mExtraEventObject;
    public JSONObject mExtraJson;
    public boolean mIsEnableClickEvent;
    public boolean mIsEnableV3Event;
    public JSONObject mParamsJson;
    public String mRefer;
    public String mStorageDenyLabel;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdDownloadEventConfig eventConfig;

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
            this.eventConfig = new AdDownloadEventConfig();
        }

        public AdDownloadEventConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.eventConfig : (AdDownloadEventConfig) invokeV.objValue;
        }

        public Builder setClickButtonTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.eventConfig.mClickButtonTag = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setClickContinueLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.eventConfig.mClickContinueLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickContinueTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setClickInstallLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.eventConfig.mClickInstallLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickInstallTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setClickItemTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.eventConfig.mClickItemTag = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setClickLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.eventConfig.mClickLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickOpenLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickOpenTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setClickPauseLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.eventConfig.mClickPauseLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickPauseTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setClickStartLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.eventConfig.mClickStartLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickStartTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setClickTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setCompletedEventTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setDownloadFailedLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setDownloadScene(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.eventConfig.mDownloadScene = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExtraEventObject(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
                this.eventConfig.mExtraEventObject = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jSONObject)) == null) {
                this.eventConfig.mExtraJson = jSONObject;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIsEnableClickEvent(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                this.eventConfig.mIsEnableClickEvent = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder setIsEnableCompletedEvent(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder setIsEnableNoChargeClickEvent(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }

        public Builder setIsEnableV3Event(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
                this.eventConfig.mIsEnableV3Event = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder setOpenLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setOpenTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setParamsJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, jSONObject)) == null) {
                this.eventConfig.mParamsJson = jSONObject;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setQuickAppEventTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setRefer(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.eventConfig.mRefer = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setStorageDenyLabel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                this.eventConfig.mStorageDenyLabel = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setStorageDenyTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }
    }

    public AdDownloadEventConfig() {
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
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
    }

    public static AdDownloadEventConfig fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            Builder builder = new Builder();
            try {
                builder.setClickButtonTag(jSONObject.optString("click_button_tag"));
                builder.setClickItemTag(jSONObject.optString("click_item_tag"));
                builder.setClickLabel(jSONObject.optString("click_label"));
                builder.setClickStartLabel(jSONObject.optString("click_start_label"));
                builder.setClickContinueLabel(jSONObject.optString("click_continue_label"));
                builder.setClickPauseLabel(jSONObject.optString("click_pause_label"));
                builder.setClickInstallLabel(jSONObject.optString("click_install_label"));
                builder.setStorageDenyLabel(jSONObject.optString("storage_deny_label"));
                builder.setRefer(jSONObject.optString(TiebaStatic.Params.REFER));
                builder.setDownloadScene(jSONObject.optInt("download_scene"));
                builder.setIsEnableClickEvent(jSONObject.optInt("enable_click_event") == 1);
                builder.setIsEnableV3Event(jSONObject.optInt("enable_v3_event") == 1);
                builder.setExtraJson(jSONObject.optJSONObject("extra"));
                builder.setParamsJson(jSONObject.optJSONObject("params_json"));
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadEventConfig fromJson");
            }
            return builder.build();
        }
        return (AdDownloadEventConfig) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mClickButtonTag : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mClickContinueLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mClickInstallLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mClickItemTag : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mClickLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mClickPauseLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mClickStartLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDownloadScene : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mExtraEventObject : invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mExtraJson : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mParamsJson : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRefer : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mStorageDenyLabel : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsEnableClickEvent : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIsEnableV3Event : invokeV.booleanValue;
    }

    public void setClickButtonTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mClickButtonTag = str;
        }
    }

    public void setClickItemTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mClickItemTag = str;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mDownloadScene = i2;
        }
    }

    public void setExtraEventObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, obj) == null) {
            this.mExtraEventObject = obj;
        }
    }

    public void setExtraJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            this.mExtraJson = jSONObject;
        }
    }

    public void setParamsJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jSONObject) == null) {
            this.mParamsJson = jSONObject;
        }
    }

    @Deprecated
    public void setQuickAppEventTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mRefer = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_button_tag", this.mClickButtonTag);
                jSONObject.putOpt("click_item_tag", this.mClickItemTag);
                jSONObject.putOpt("click_label", this.mClickLabel);
                jSONObject.putOpt("click_start_label", this.mClickStartLabel);
                jSONObject.putOpt("click_continue_label", this.mClickContinueLabel);
                jSONObject.putOpt("click_pause_label", this.mClickPauseLabel);
                jSONObject.putOpt("click_install_label", this.mClickInstallLabel);
                jSONObject.putOpt("storage_deny_label", this.mStorageDenyLabel);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.mRefer);
                jSONObject.putOpt("download_scene", Integer.valueOf(this.mDownloadScene));
                int i2 = 1;
                jSONObject.putOpt("enable_click_event", Integer.valueOf(this.mIsEnableClickEvent ? 1 : 0));
                if (!this.mIsEnableV3Event) {
                    i2 = 0;
                }
                jSONObject.putOpt("enable_v3_event", Integer.valueOf(i2));
                jSONObject.putOpt("extra", this.mExtraJson);
                jSONObject.putOpt("params_json", this.mParamsJson);
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadEventConfig toJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public AdDownloadEventConfig(AdDownloadEventConfig adDownloadEventConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adDownloadEventConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
        if (adDownloadEventConfig == null) {
            return;
        }
        this.mClickButtonTag = adDownloadEventConfig.mClickButtonTag;
        this.mClickItemTag = adDownloadEventConfig.mClickItemTag;
        this.mClickLabel = adDownloadEventConfig.mClickLabel;
        this.mClickStartLabel = adDownloadEventConfig.mClickStartLabel;
        this.mClickPauseLabel = adDownloadEventConfig.mClickPauseLabel;
        this.mClickContinueLabel = adDownloadEventConfig.mClickContinueLabel;
        this.mClickInstallLabel = adDownloadEventConfig.mClickInstallLabel;
        this.mStorageDenyLabel = adDownloadEventConfig.mStorageDenyLabel;
        this.mDownloadScene = adDownloadEventConfig.mDownloadScene;
        this.mIsEnableClickEvent = adDownloadEventConfig.mIsEnableClickEvent;
        this.mIsEnableV3Event = adDownloadEventConfig.mIsEnableV3Event;
        this.mRefer = adDownloadEventConfig.mRefer;
        this.mExtraJson = adDownloadEventConfig.mExtraJson;
        this.mParamsJson = adDownloadEventConfig.mParamsJson;
    }
}
