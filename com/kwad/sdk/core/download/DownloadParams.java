package com.kwad.sdk.core.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class DownloadParams extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4966891183505507851L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean downloadEnablePause;
    public int downloadPlace;
    public String filePath;
    public String mAppIcon;
    public String mAppName;
    public long mAppSize;
    public String mDownloadid;
    public String mFileMd5;
    public String mFileUrl;
    public String mPkgname;
    public String mShortDesc;
    public int mTaskId;
    public String mVersion;
    public String mVersionCode;
    public boolean requestInstallPermission;

    public DownloadParams() {
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
        this.downloadEnablePause = false;
        this.downloadPlace = 1;
    }

    public static DownloadParams transform(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.mDownloadid = adInfo.downloadId;
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            downloadParams.mAppName = adBaseInfo.appName;
            downloadParams.mPkgname = adBaseInfo.appPackageName;
            downloadParams.mFileUrl = adInfo.adConversionInfo.appDownloadUrl;
            downloadParams.mAppIcon = adBaseInfo.appIconUrl;
            downloadParams.mShortDesc = adBaseInfo.adDescription;
            downloadParams.downloadEnablePause = com.kwad.sdk.core.response.a.a.ax(adInfo);
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}
