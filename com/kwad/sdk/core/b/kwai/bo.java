package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bo implements com.kwad.sdk.core.d<DownloadParams> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(DownloadParams downloadParams, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        com.kwad.sdk.utils.r.a(jSONObject, "mAppName", downloadParams.mAppName);
        com.kwad.sdk.utils.r.a(jSONObject, "mPkgname", downloadParams.mPkgname);
        com.kwad.sdk.utils.r.a(jSONObject, "mVersion", downloadParams.mVersion);
        com.kwad.sdk.utils.r.a(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        com.kwad.sdk.utils.r.a(jSONObject, "mAppSize", downloadParams.mAppSize);
        com.kwad.sdk.utils.r.a(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        com.kwad.sdk.utils.r.a(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        com.kwad.sdk.utils.r.a(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        com.kwad.sdk.utils.r.a(jSONObject, "mTaskId", downloadParams.mTaskId);
        com.kwad.sdk.utils.r.a(jSONObject, "filePath", downloadParams.filePath);
        com.kwad.sdk.utils.r.a(jSONObject, "requestInstallPermission", downloadParams.requestInstallPermission);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadEnablePause", downloadParams.downloadEnablePause);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadPlace", downloadParams.downloadPlace);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(DownloadParams downloadParams, JSONObject jSONObject) {
        a2(downloadParams, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        return b2(downloadParams, jSONObject);
    }
}
