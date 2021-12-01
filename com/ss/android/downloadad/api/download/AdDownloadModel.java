package com.ss.android.downloadad.api.download;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.c.b;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.d;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdDownloadModel implements DownloadModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppIcon;
    public String mAppName;
    public boolean mAutoInstall;
    public boolean mAutoInstallWithoutNotification;
    public List<String> mBackupUrls;
    public List<String> mClickTrackUrl;
    public DeepLink mDeepLink;
    public boolean mDistinctDir;
    public JSONObject mDownloadSettings;
    public String mDownloadUrl;
    public boolean mEnablePause;
    public int mExecutorGroup;
    public long mExpectFileLength;
    public JSONObject mExtra;
    public long mExtraValue;
    public String mFileName;
    public String mFilePath;
    public IDownloadFileUriProvider mFileUriProvider;
    public int mFunnelType;
    public Map<String, String> mHeaders;
    public long mId;
    public boolean mIndependentProcess;
    public boolean mIsAd;
    @Deprecated
    public boolean mIsInExternalPublicDir;
    public boolean mIsShowNotification;
    public boolean mIsShowToast;
    public String mLogExtra;
    public String mMd5;
    public String mMimeType;
    public int mModelType;
    public boolean mNeedWifi;
    public String mNotificationJumpUrl;
    public String mPackageName;
    public d mQuickAppModel;
    public String mSdkMonitorScene;
    public String mStartToast;
    public int mVersionCode;
    public String mVersionName;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdDownloadModel model;

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
            this.model = new AdDownloadModel();
        }

        public AdDownloadModel build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.model : (AdDownloadModel) invokeV.objValue;
        }

        @Deprecated
        public Builder setAdId(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? setId(j2) : (Builder) invokeJ.objValue;
        }

        public Builder setAppIcon(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.model.mAppIcon = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.model.mAppName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAutoInstall(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.model.mAutoInstall = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoInstallWithoutNotification(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.model.mAutoInstallWithoutNotification = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setBackupUrls(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
                this.model.mBackupUrls = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setClickTrackUrl(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
                this.model.mClickTrackUrl = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDeepLink(DeepLink deepLink) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, deepLink)) == null) {
                this.model.mDeepLink = deepLink;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDistinctDir(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.model.mDistinctDir = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDownloadSettings(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.model.mDownloadSettings = jSONObject;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDownloadUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.model.mDownloadUrl = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEnablePause(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.model.mEnablePause = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setExecutorGroup(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.model.mExecutorGroup = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setExpectFileLength(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
                this.model.mExpectFileLength = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setExtra(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
                this.model.mExtra = jSONObject;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtraValue(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
                this.model.mExtraValue = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setFileName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.model.mFileName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFilePath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.model.mFilePath = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, iDownloadFileUriProvider)) == null) {
                this.model.mFileUriProvider = iDownloadFileUriProvider;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setHeaders(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, map)) == null) {
                this.model.mHeaders = map;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setId(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j2)) == null) {
                this.model.mId = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setIsAd(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
                this.model.mIsAd = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder setIsInExternalPublicDir(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
                this.model.mIsInExternalPublicDir = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsShowNotification(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
                this.model.mIsShowNotification = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setIsShowToast(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                this.model.mIsShowToast = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLogExtra(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                this.model.mLogExtra = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMd5(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.model.mMd5 = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMimeType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.model.mMimeType = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setModelType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
                this.model.mModelType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNeedIndependentProcess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
                this.model.mIndependentProcess = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedWifi(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.model.mNeedWifi = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNotificationJumpUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
                this.model.mNotificationJumpUrl = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPackageName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                this.model.mPackageName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setQuickAppModel(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, dVar)) == null) {
                this.model.mQuickAppModel = dVar;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSdkMonitorScene(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                this.model.mSdkMonitorScene = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setStartToast(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
                this.model.mStartToast = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVersionCode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
                this.model.mVersionCode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setVersionName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
                this.model.mVersionName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public AdDownloadModel() {
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
        this.mIsAd = true;
        this.mIsShowToast = true;
        this.mIsShowNotification = true;
        this.mAutoInstall = true;
        this.mNeedWifi = false;
        this.mExecutorGroup = 2;
        this.mEnablePause = true;
        this.mFunnelType = 1;
    }

    public static void appendBackupUrlsFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, jSONObject, builder) == null) || (optJSONArray = jSONObject.optJSONArray("backup_urls")) == null || optJSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        builder.setBackupUrls(arrayList);
    }

    public static void appendDeepLinkFromJson(JSONObject jSONObject, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, builder) == null) {
            builder.setDeepLink(new DeepLink(jSONObject.optString("open_url"), jSONObject.optString("web_url"), null));
        }
    }

    public static void appendHeaderMapFromJson(JSONObject jSONObject, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONObject, builder) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("header_keys");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("header_values");
            if (optJSONArray == null || optJSONArray2 == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hashMap.put(optJSONArray.optString(i2), optJSONArray2.optString(i2));
            }
            builder.setHeaders(hashMap);
        }
    }

    public static void appendQuickAppUrlFromJson(JSONObject jSONObject, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, builder) == null) {
            String optString = jSONObject.optString("quick_app_url");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            builder.setQuickAppModel(new d.a().a(optString).a());
        }
    }

    public static void appendTrackUrlFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, jSONObject, builder) == null) || (optJSONArray = jSONObject.optJSONArray("click_track_urls")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            arrayList.add(optJSONArray.optString(i2));
        }
        builder.setClickTrackUrl(arrayList);
    }

    public static AdDownloadModel fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            Builder builder = new Builder();
            try {
                boolean z = true;
                Builder distinctDir = builder.setAdId(b.a(jSONObject, "id")).setIsAd(jSONObject.optInt("is_ad", 1) == 1).setModelType(jSONObject.optInt(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY)).setMimeType(jSONObject.optString("mime_type")).setExtraValue(b.a(jSONObject, "ext_value")).setLogExtra(jSONObject.optString(BaseConstants.EVENT_LABEL_LOG_EXTRA)).setPackageName(jSONObject.optString("package_name")).setDownloadUrl(jSONObject.optString("download_url")).setAppName(jSONObject.optString("app_name")).setAppIcon(jSONObject.optString("app_icon")).setIsShowToast(jSONObject.optInt("is_show_toast", 1) == 1).setIsShowNotification(jSONObject.optInt("show_notification", 1) == 1).setNeedWifi(jSONObject.optInt("need_wifi") == 1).setMd5(jSONObject.optString(PackageTable.MD5)).setExpectFileLength(jSONObject.optLong("expect_file_length")).setNeedIndependentProcess(jSONObject.optInt("independent_process") == 1).setVersionCode(jSONObject.optInt("version_code")).setVersionName(jSONObject.optString("version_name")).setFilePath(jSONObject.optString(PackageTable.FILE_PATH)).setFileName(jSONObject.optString("file_name")).setNotificationJumpUrl(jSONObject.optString("notification_jump_url")).setAutoInstallWithoutNotification(jSONObject.optInt("auto_install_without_notify") == 1).setExecutorGroup(jSONObject.optInt("executor_group")).setDownloadSettings(jSONObject.optJSONObject("download_settings")).setExtra(jSONObject.optJSONObject("extra")).setStartToast(jSONObject.optString("start_toast")).setSdkMonitorScene(jSONObject.optString("sdk_monitor_scene")).setAutoInstall(jSONObject.optInt("auto_install", 1) == 1).setDistinctDir(jSONObject.optInt("distinct_dir") == 1);
                if (jSONObject.optInt("enable_pause", 1) != 1) {
                    z = false;
                }
                distinctDir.setEnablePause(z);
                appendDeepLinkFromJson(jSONObject, builder);
                appendQuickAppUrlFromJson(jSONObject, builder);
                appendTrackUrlFromJson(jSONObject, builder);
                appendHeaderMapFromJson(jSONObject, builder);
                appendBackupUrlsFromJson(jSONObject, builder);
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadModel fromJson");
            }
            return builder.build();
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean autoInstallWithoutNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAutoInstallWithoutNotification : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean distinctDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDistinctDir : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean enablePause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEnablePause : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mIsShowNotification = false;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mIsShowToast = false;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mNeedWifi = true;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getAppIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAppIcon : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getBackupUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBackupUrls : (List) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getClickTrackUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mClickTrackUrl : (List) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public DeepLink getDeepLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mDeepLink : (DeepLink) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public IDownloadFileUriProvider getDownloadFileUriProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mFileUriProvider : (IDownloadFileUriProvider) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getDownloadSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDownloadSettings : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mDownloadUrl : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getExecutorGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mExecutorGroup : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExpectFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mExpectFileLength : invokeV.longValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mExtra : (JSONObject) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mExtraValue : invokeV.longValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mFileName : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mFilePath : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getFunnelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mFunnelType : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mHeaders : (Map) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mId : invokeV.longValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getLogExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mLogExtra : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mMd5 : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mMimeType : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mModelType : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getNotificationJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mNotificationJumpUrl : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public d getQuickAppModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mQuickAppModel : (d) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getSdkMonitorScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mSdkMonitorScene : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getStartToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mStartToast : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mVersionCode : invokeV.intValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mVersionName : (String) invokeV.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mIsAd : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAutoInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mAutoInstall : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mIsInExternalPublicDir : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mNeedWifi : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mIsShowNotification : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mIsShowToast : invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean needIndependentProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mIndependentProcess : invokeV.booleanValue;
    }

    @Deprecated
    public AdDownloadModel setAdId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j2)) == null) ? setId(j2) : (AdDownloadModel) invokeJ.objValue;
    }

    public AdDownloadModel setAppIcon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            this.mAppIcon = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mAppName = str;
        }
    }

    public AdDownloadModel setAutoInstallWithoutNotification(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
            this.mAutoInstallWithoutNotification = z;
            return this;
        }
        return (AdDownloadModel) invokeZ.objValue;
    }

    public AdDownloadModel setBackupUrls(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, list)) == null) {
            this.mBackupUrls = list;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setClickTrackUrl(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, list)) == null) {
            this.mClickTrackUrl = list;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setDeepLink(DeepLink deepLink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, deepLink)) == null) {
            this.mDeepLink = deepLink;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setDownloadUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            this.mDownloadUrl = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public void setExpectFileLength(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048626, this, j2) == null) {
            this.mExpectFileLength = j2;
        }
    }

    public void setExtra(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jSONObject) == null) {
            this.mExtra = jSONObject;
        }
    }

    public void setExtraValue(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) {
            this.mExtraValue = j2;
        }
    }

    public AdDownloadModel setFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            this.mFileName = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, iDownloadFileUriProvider)) == null) {
            this.mFileUriProvider = iDownloadFileUriProvider;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setFunnelType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            this.mFunnelType = i2;
            return this;
        }
        return (AdDownloadModel) invokeI.objValue;
    }

    public AdDownloadModel setHeaders(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, map)) == null) {
            this.mHeaders = map;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setId(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048635, this, j2)) == null) {
            this.mId = j2;
            return this;
        }
        return (AdDownloadModel) invokeJ.objValue;
    }

    public AdDownloadModel setIsAd(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048636, this, z)) == null) {
            this.mIsAd = z;
            return this;
        }
        return (AdDownloadModel) invokeZ.objValue;
    }

    public AdDownloadModel setIsShowNotification(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048637, this, z)) == null) {
            this.mIsShowNotification = z;
            return this;
        }
        return (AdDownloadModel) invokeZ.objValue;
    }

    public void setIsShowToast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.mIsShowToast = z;
        }
    }

    public AdDownloadModel setLogExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, str)) == null) {
            this.mLogExtra = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public void setMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.mMd5 = str;
        }
    }

    public AdDownloadModel setMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            this.mMimeType = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setModelType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i2)) == null) {
            this.mModelType = i2;
            return this;
        }
        return (AdDownloadModel) invokeI.objValue;
    }

    public AdDownloadModel setNeedIndependentProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            this.mIndependentProcess = z;
            return this;
        }
        return (AdDownloadModel) invokeZ.objValue;
    }

    public void setNeedWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.mNeedWifi = z;
        }
    }

    public AdDownloadModel setNotificationJumpUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            this.mNotificationJumpUrl = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, str)) == null) {
            this.mPackageName = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public AdDownloadModel setQuickAppModel(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, dVar)) == null) {
            this.mQuickAppModel = dVar;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    public void setSdkMonitorScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.mSdkMonitorScene = str;
        }
    }

    public void setStartToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.mStartToast = str;
        }
    }

    public AdDownloadModel setVersionCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i2)) == null) {
            this.mVersionCode = i2;
            return this;
        }
        return (AdDownloadModel) invokeI.objValue;
    }

    public AdDownloadModel setVersionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, str)) == null) {
            this.mVersionName = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? b.a(a.a(getDownloadSettings()), getMimeType()) : invokeV.booleanValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.mId);
                int i2 = 1;
                jSONObject.put("is_ad", this.mIsAd ? 1 : 0);
                jSONObject.putOpt(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, Integer.valueOf(this.mModelType));
                jSONObject.putOpt("mime_type", this.mMimeType);
                jSONObject.putOpt("ext_value", Long.valueOf(this.mExtraValue));
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.mLogExtra);
                jSONObject.putOpt("package_name", this.mPackageName);
                jSONObject.putOpt("download_url", this.mDownloadUrl);
                jSONObject.putOpt("app_name", this.mAppName);
                jSONObject.putOpt("app_icon", this.mAppIcon);
                jSONObject.putOpt("is_show_toast", Integer.valueOf(this.mIsShowToast ? 1 : 0));
                jSONObject.putOpt("show_notification", Integer.valueOf(this.mIsShowNotification ? 1 : 0));
                jSONObject.put("need_wifi", this.mNeedWifi ? 1 : 0);
                jSONObject.put(PackageTable.MD5, this.mMd5);
                jSONObject.put("expect_file_length", this.mExpectFileLength);
                jSONObject.put("independent_process", this.mIndependentProcess ? 1 : 0);
                jSONObject.put("version_code", this.mVersionCode);
                jSONObject.putOpt("version_name", this.mVersionName);
                jSONObject.putOpt(PackageTable.FILE_PATH, this.mFilePath);
                jSONObject.putOpt("file_name", this.mFileName);
                jSONObject.putOpt("notification_jump_url", this.mNotificationJumpUrl);
                jSONObject.putOpt("auto_install_without_notify", Integer.valueOf(this.mAutoInstallWithoutNotification ? 1 : 0));
                jSONObject.putOpt("executor_group", Integer.valueOf(this.mExecutorGroup));
                jSONObject.putOpt("start_toast", this.mStartToast);
                jSONObject.putOpt("sdk_monitor_scene", this.mSdkMonitorScene);
                jSONObject.putOpt("auto_install", Integer.valueOf(this.mAutoInstall ? 1 : 0));
                jSONObject.putOpt("distinct_dir", Integer.valueOf(this.mDistinctDir ? 1 : 0));
                if (!this.mEnablePause) {
                    i2 = 0;
                }
                jSONObject.putOpt("enable_pause", Integer.valueOf(i2));
                if (this.mDownloadSettings != null) {
                    jSONObject.put("download_settings", this.mDownloadSettings);
                }
                if (this.mBackupUrls != null && !this.mBackupUrls.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : this.mBackupUrls) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(str);
                        }
                    }
                    jSONObject.put("backup_urls", jSONArray);
                }
                if (this.mDeepLink != null) {
                    if (!TextUtils.isEmpty(this.mDeepLink.getOpenUrl())) {
                        jSONObject.put("open_url", this.mDeepLink.getOpenUrl());
                    }
                    if (!TextUtils.isEmpty(this.mDeepLink.getWebUrl())) {
                        jSONObject.put("web_url", this.mDeepLink.getWebUrl());
                    }
                }
                if (this.mQuickAppModel != null) {
                    jSONObject.putOpt("quick_app_url", this.mQuickAppModel.a());
                }
                if (this.mClickTrackUrl != null && !this.mClickTrackUrl.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str2 : this.mClickTrackUrl) {
                        jSONArray2.put(str2);
                    }
                    jSONObject.put("click_track_urls", jSONArray2);
                }
                if (this.mExtra != null) {
                    jSONObject.put("extra", this.mExtra);
                }
                if (this.mHeaders != null && !this.mHeaders.isEmpty()) {
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = new JSONArray();
                    for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                        jSONArray3.put(entry.getKey());
                        jSONArray4.put(entry.getKey());
                    }
                    jSONObject.put("header_keys", jSONArray3);
                    jSONObject.put("header_values", jSONArray4);
                }
            } catch (Exception e2) {
                j.s().a(e2, "AdDownloadModel toJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.download.api.download.DownloadModel
    public AdDownloadModel setFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            this.mFilePath = str;
            return this;
        }
        return (AdDownloadModel) invokeL.objValue;
    }
}
