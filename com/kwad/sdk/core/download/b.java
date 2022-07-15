package com.kwad.sdk.core.download;

import android.text.TextUtils;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.z;
import java.util.Map;
/* loaded from: classes5.dex */
public final class b extends com.ksad.download.c {
    public static final Map<String, String> b = new LruHashMap(10);

    public static String g(DownloadTask downloadTask) {
        String url = downloadTask.getUrl();
        String str = b.get(url);
        if (TextUtils.isEmpty(str)) {
            String a = z.a(downloadTask.getUrl());
            b.put(url, a);
            return a;
        }
        return str;
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask) {
        c.a(g(downloadTask), downloadTask.getTargetFilePath());
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask, int i, int i2) {
        c.a(g(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
    }

    @Override // com.ksad.download.c
    public final void a(DownloadTask downloadTask, Throwable th) {
        String str;
        if (th == null || th.getStackTrace().length <= 0) {
            str = "";
        } else {
            str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
        }
        c.a(g(downloadTask), 0, str);
    }

    @Override // com.ksad.download.c
    public final void b(DownloadTask downloadTask) {
        if (downloadTask.getSmallFileSoFarBytes() == 0) {
            c.a(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public final void c(DownloadTask downloadTask) {
        c.b(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void d(DownloadTask downloadTask) {
        c.d(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void e(DownloadTask downloadTask) {
        c.c(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public final void f(DownloadTask downloadTask) {
        c.e(g(downloadTask));
    }
}
