package com.kwad.sdk.core.download;

import android.text.TextUtils;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ab;
import java.util.Map;
/* loaded from: classes7.dex */
public final class b extends com.ksad.download.c {
    public static final Map WN = new LruHashMap(10);

    public static String l(DownloadTask downloadTask) {
        String url = downloadTask.getUrl();
        String str = (String) WN.get(url);
        if (TextUtils.isEmpty(str)) {
            String dI = ab.dI(downloadTask.getUrl());
            WN.put(url, dI);
            return dI;
        }
        return str;
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask) {
        c.u(l(downloadTask), downloadTask.getTargetFilePath());
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask, int i, int i2) {
        c.a(l(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask, Throwable th) {
        String str;
        if (th == null || th.getStackTrace().length <= 0) {
            str = "";
        } else {
            str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
        }
        c.b(l(downloadTask), 0, str);
    }

    @Override // com.ksad.download.c
    public final void b(DownloadTask downloadTask) {
        if (downloadTask.getSmallFileSoFarBytes() == 0) {
            c.bE(l(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public final void c(DownloadTask downloadTask) {
        c.bF(l(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void d(DownloadTask downloadTask) {
        c.bH(l(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void e(DownloadTask downloadTask) {
        c.bG(l(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void f(DownloadTask downloadTask) {
        c.bI(l(downloadTask));
    }
}
