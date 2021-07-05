package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.core.c<DownloadParams> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(DownloadParams downloadParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadParams)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "mDownloadid", downloadParams.mDownloadid);
            com.kwad.sdk.utils.o.a(jSONObject, "mAppName", downloadParams.mAppName);
            com.kwad.sdk.utils.o.a(jSONObject, "mPkgname", downloadParams.mPkgname);
            com.kwad.sdk.utils.o.a(jSONObject, "mVersion", downloadParams.mVersion);
            com.kwad.sdk.utils.o.a(jSONObject, "mVersionCode", downloadParams.mVersionCode);
            com.kwad.sdk.utils.o.a(jSONObject, "mAppSize", downloadParams.mAppSize);
            com.kwad.sdk.utils.o.a(jSONObject, "mFileMd5", downloadParams.mFileMd5);
            com.kwad.sdk.utils.o.a(jSONObject, "mFileUrl", downloadParams.mFileUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "mAppIcon", downloadParams.mAppIcon);
            com.kwad.sdk.utils.o.a(jSONObject, "mShortDesc", downloadParams.mShortDesc);
            com.kwad.sdk.utils.o.a(jSONObject, "mTaskId", downloadParams.mTaskId);
            com.kwad.sdk.utils.o.a(jSONObject, "filePath", downloadParams.filePath);
            com.kwad.sdk.utils.o.a(jSONObject, "downloadPlace", downloadParams.downloadPlace);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(DownloadParams downloadParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadParams, jSONObject) == null) || jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        downloadParams.mAppName = jSONObject.optString("mAppName");
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        downloadParams.mVersion = jSONObject.optString("mVersion");
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }
}
