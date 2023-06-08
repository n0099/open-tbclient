package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bp implements com.kwad.sdk.core.d<DownloadParams> {
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
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j = downloadParams.mAppSize;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mAppSize", j);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i = downloadParams.mTaskId;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mTaskId", i);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "filePath", downloadParams.filePath);
        }
        boolean z = downloadParams.requestInstallPermission;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestInstallPermission", z);
        }
        boolean z2 = downloadParams.downloadEnablePause;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadEnablePause", z2);
        }
        int i2 = downloadParams.downloadPlace;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadPlace", i2);
        }
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
