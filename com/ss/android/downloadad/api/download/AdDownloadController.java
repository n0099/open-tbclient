package com.ss.android.downloadad.api.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdDownloadController implements DownloadController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDownloadMode;
    public boolean mEnableAH;
    public boolean mEnableAM;
    public boolean mEnableNewActivity;
    public boolean mEnableShowComplianceDialog;
    public Object mExtraClickOperation;
    public JSONObject mExtraJson;
    public Object mExtraObject;
    public int mInterceptFlag;
    public boolean mIsAddToDownloadManage;
    public boolean mIsAutoDownloadOnCardShow;
    public boolean mIsEnableBackDialog;
    public int mLinkMode;
    public boolean mShouldUseNewWebView;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdDownloadController controller;

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
            this.controller = new AdDownloadController();
        }

        public AdDownloadController build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.controller : (AdDownloadController) invokeV.objValue;
        }

        @Deprecated
        public Builder setDowloadChunkCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this : (Builder) invokeI.objValue;
        }

        public Builder setDownloadMode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.controller.mDownloadMode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setEnableAH(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.controller.mEnableAH = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableAM(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.controller.mEnableAM = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableNewActivity(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.controller.mEnableNewActivity = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableShowComplianceDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.controller.mEnableShowComplianceDialog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
                this.controller.mExtraJson = jSONObject;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtraObject(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                this.controller.mExtraObject = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder setExtraOperation(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                this.controller.mExtraClickOperation = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setInterceptFlag(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.controller.mInterceptFlag = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIsAddToDownloadManage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.controller.mIsAddToDownloadManage = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.controller.mIsAutoDownloadOnCardShow = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsEnableBackDialog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.controller.mIsEnableBackDialog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder setIsEnableMultipleDownload(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }

        public Builder setLinkMode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.controller.mLinkMode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setShouldUseNewWebView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.controller.mShouldUseNewWebView = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public AdDownloadController() {
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
        this.mEnableShowComplianceDialog = true;
        this.mEnableNewActivity = true;
        this.mEnableAH = true;
        this.mEnableAM = true;
    }

    public static AdDownloadController fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            Builder builder = new Builder();
            try {
                builder.setLinkMode(jSONObject.optInt("link_mode"));
                builder.setDownloadMode(jSONObject.optInt("download_mode"));
                builder.setIsEnableBackDialog(jSONObject.optInt("enable_back_dialog") == 1);
                builder.setIsAddToDownloadManage(jSONObject.optInt("add_to_manage") == 1);
                builder.setShouldUseNewWebView(jSONObject.optInt("use_new_webview") == 1);
                builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
                builder.setEnableShowComplianceDialog(jSONObject.optInt("enable_show_compliance_dialog", 1) == 1);
                builder.setIsAutoDownloadOnCardShow(jSONObject.optInt("is_auto_download_on_card_show") == 1);
                builder.setEnableNewActivity(jSONObject.optInt("enable_new_activity", 1) == 1);
                builder.setEnableAH(jSONObject.optInt("enable_ah", 1) == 1);
                builder.setEnableAM(jSONObject.optInt("enable_am", 1) == 1);
                builder.setExtraJson(jSONObject.optJSONObject("extra"));
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadController fromJson");
            }
            return builder.build();
        }
        return (AdDownloadController) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEnableAH : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEnableAM : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEnableNewActivity : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEnableShowComplianceDialog : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDownloadMode : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mExtraClickOperation : invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mExtraJson : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mExtraObject : invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mInterceptFlag : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mLinkMode : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIsAddToDownloadManage : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsAutoDownloadOnCardShow : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsEnableBackDialog : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mDownloadMode = i2;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mEnableNewActivity = z;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mEnableShowComplianceDialog = z;
        }
    }

    public void setExtraJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) {
            this.mExtraJson = jSONObject;
        }
    }

    public void setExtraObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, obj) == null) {
            this.mExtraObject = obj;
        }
    }

    public void setIsAutoDownloadOnCardShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsAutoDownloadOnCardShow = z;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mLinkMode = i2;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mShouldUseNewWebView : invokeV.booleanValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("link_mode", Integer.valueOf(this.mLinkMode));
                jSONObject.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));
                int i2 = 1;
                jSONObject.putOpt("enable_back_dialog", Integer.valueOf(this.mIsEnableBackDialog ? 1 : 0));
                jSONObject.putOpt("add_to_manage", Integer.valueOf(this.mIsAddToDownloadManage ? 1 : 0));
                jSONObject.putOpt("use_new_webview", Integer.valueOf(this.mShouldUseNewWebView ? 1 : 0));
                jSONObject.putOpt("intercept_flag", Integer.valueOf(this.mInterceptFlag));
                jSONObject.putOpt("enable_show_compliance_dialog", Integer.valueOf(this.mEnableShowComplianceDialog ? 1 : 0));
                jSONObject.putOpt("is_auto_download_on_card_show", Integer.valueOf(this.mIsAutoDownloadOnCardShow ? 1 : 0));
                jSONObject.putOpt("extra", this.mExtraJson);
                jSONObject.putOpt("enable_new_activity", Integer.valueOf(this.mEnableNewActivity ? 1 : 0));
                jSONObject.putOpt("enable_ah", Integer.valueOf(this.mEnableAH ? 1 : 0));
                if (!this.mEnableAM) {
                    i2 = 0;
                }
                jSONObject.putOpt("enable_am", Integer.valueOf(i2));
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadController toJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
