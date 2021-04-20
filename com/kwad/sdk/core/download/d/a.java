package com.kwad.sdk.core.download.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.t;
import java.io.File;
/* loaded from: classes6.dex */
public class a implements AdDownloadProxy {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33876a;

    public a(boolean z) {
        this.f33876a = z;
    }

    private String a(String str) {
        return t.a(str) + ".apk";
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void cancelDownload(Context context, String str, DownloadParams downloadParams) {
        com.ksad.download.a.a.b(context, str);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    @Nullable
    public String getDownloadFilePath(DownloadParams downloadParams) {
        if (TextUtils.isEmpty(downloadParams.mFileUrl)) {
            return null;
        }
        return com.ksad.download.b.b() + File.separator + a(downloadParams.mFileUrl);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void pauseDownload(Context context, String str, DownloadParams downloadParams) {
        com.ksad.download.a.a.a(context, str);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void startDownload(Context context, String str, DownloadParams downloadParams) {
        String str2 = downloadParams.mFileUrl;
        if (TextUtils.isEmpty(str2) || !URLUtil.isNetworkUrl(str2)) {
            return;
        }
        DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParams.mFileUrl);
        downloadRequest.setDestinationFileName(a(downloadParams.mFileUrl));
        downloadRequest.setTag(downloadParams);
        downloadRequest.setNotificationVisibility(this.f33876a ? 3 : 0);
        com.ksad.download.a.a.a(context, str, downloadRequest);
    }
}
