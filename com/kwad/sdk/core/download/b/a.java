package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.baidu.nps.utils.Constant;
import com.ksad.download.DownloadTask;
import com.ksad.download.b;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ab;
import java.io.File;
/* loaded from: classes9.dex */
public final class a implements AdDownloadProxy {
    public final boolean Xo;

    public a(boolean z) {
        this.Xo = z;
    }

    public static String bL(String str) {
        return ab.dI(str) + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public final void cancelDownload(Context context, String str, DownloadParams downloadParams) {
        com.ksad.download.kwai.a.f(context, str);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    @Nullable
    public final String getDownloadFilePath(DownloadParams downloadParams) {
        if (TextUtils.isEmpty(downloadParams.mFileUrl)) {
            return null;
        }
        return b.M() + File.separator + bL(downloadParams.mFileUrl);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public final void pauseDownload(Context context, String str, DownloadParams downloadParams) {
        com.ksad.download.kwai.a.e(context, str);
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public final void startDownload(Context context, String str, DownloadParams downloadParams) {
        String str2 = downloadParams.mFileUrl;
        if (TextUtils.isEmpty(str2) || !URLUtil.isNetworkUrl(str2)) {
            return;
        }
        DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParams.mFileUrl);
        downloadRequest.setDestinationFileName(bL(downloadParams.mFileUrl));
        downloadRequest.setTag(downloadParams);
        downloadRequest.setDownloadEnablePause(downloadParams.downloadEnablePause);
        downloadRequest.setNotificationVisibility(this.Xo ? 3 : 0);
        com.ksad.download.kwai.a.a(context, str, downloadRequest);
    }
}
