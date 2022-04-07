package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bb implements com.kwad.sdk.core.d<DownloadParams> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (jSONObject.opt("mDownloadid") == JSONObject.NULL) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (jSONObject.opt("mAppName") == JSONObject.NULL) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (jSONObject.opt("mPkgname") == JSONObject.NULL) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (jSONObject.opt("mVersion") == JSONObject.NULL) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (jSONObject.opt("mVersionCode") == JSONObject.NULL) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (jSONObject.opt("mFileMd5") == JSONObject.NULL) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (jSONObject.opt("mFileUrl") == JSONObject.NULL) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (jSONObject.opt("mAppIcon") == JSONObject.NULL) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (jSONObject.opt("mShortDesc") == JSONObject.NULL) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        if (jSONObject.opt("filePath") == JSONObject.NULL) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        com.kwad.sdk.utils.t.a(jSONObject, "mAppName", downloadParams.mAppName);
        com.kwad.sdk.utils.t.a(jSONObject, "mPkgname", downloadParams.mPkgname);
        com.kwad.sdk.utils.t.a(jSONObject, "mVersion", downloadParams.mVersion);
        com.kwad.sdk.utils.t.a(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        com.kwad.sdk.utils.t.a(jSONObject, "mAppSize", downloadParams.mAppSize);
        com.kwad.sdk.utils.t.a(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        com.kwad.sdk.utils.t.a(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        com.kwad.sdk.utils.t.a(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        com.kwad.sdk.utils.t.a(jSONObject, "mTaskId", downloadParams.mTaskId);
        com.kwad.sdk.utils.t.a(jSONObject, "filePath", downloadParams.filePath);
        com.kwad.sdk.utils.t.a(jSONObject, "requestInstallPermission", downloadParams.requestInstallPermission);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadEnablePause", downloadParams.downloadEnablePause);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadPlace", downloadParams.downloadPlace);
        return jSONObject;
    }
}
