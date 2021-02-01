package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l implements com.kwad.sdk.core.c<DownloadParams> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(DownloadParams downloadParams) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
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
