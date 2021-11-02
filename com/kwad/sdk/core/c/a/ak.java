package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ak implements com.kwad.sdk.core.d<DownloadParams> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ak() {
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
    public void a(DownloadParams downloadParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, downloadParams, jSONObject) == null) || jSONObject == null) {
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
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadParams, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "mDownloadid", downloadParams.mDownloadid);
            com.kwad.sdk.utils.q.a(jSONObject, "mAppName", downloadParams.mAppName);
            com.kwad.sdk.utils.q.a(jSONObject, "mPkgname", downloadParams.mPkgname);
            com.kwad.sdk.utils.q.a(jSONObject, "mVersion", downloadParams.mVersion);
            com.kwad.sdk.utils.q.a(jSONObject, "mVersionCode", downloadParams.mVersionCode);
            com.kwad.sdk.utils.q.a(jSONObject, "mAppSize", downloadParams.mAppSize);
            com.kwad.sdk.utils.q.a(jSONObject, "mFileMd5", downloadParams.mFileMd5);
            com.kwad.sdk.utils.q.a(jSONObject, "mFileUrl", downloadParams.mFileUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "mAppIcon", downloadParams.mAppIcon);
            com.kwad.sdk.utils.q.a(jSONObject, "mShortDesc", downloadParams.mShortDesc);
            com.kwad.sdk.utils.q.a(jSONObject, "mTaskId", downloadParams.mTaskId);
            com.kwad.sdk.utils.q.a(jSONObject, "filePath", downloadParams.filePath);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadEnablePause", downloadParams.downloadEnablePause);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadPlace", downloadParams.downloadPlace);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
