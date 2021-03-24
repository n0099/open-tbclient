package com.kwad.sdk.core.download;

import com.ksad.download.DownloadTask;
import com.kwad.sdk.utils.t;
/* loaded from: classes6.dex */
public class b extends com.ksad.download.c {
    private String g(DownloadTask downloadTask) {
        return t.a(downloadTask.getUrl());
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask) {
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, int i, int i2) {
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, String str, boolean z, int i, int i2) {
    }

    @Override // com.ksad.download.c
    public void a(DownloadTask downloadTask, Throwable th) {
        String str;
        if (th == null || th.getStackTrace().length <= 0) {
            str = "";
        } else {
            str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
        }
        c.a(g(downloadTask), 0, str);
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask) {
        c.a(g(downloadTask), downloadTask.getTargetFilePath());
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask, int i, int i2) {
        c.a(g(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask) {
        if (downloadTask.getSmallFileSoFarBytes() == 0) {
            c.a(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask, int i, int i2) {
        c.b(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask) {
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask, int i, int i2) {
        c.c(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void e(DownloadTask downloadTask) {
        c.d(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void f(DownloadTask downloadTask) {
        c.e(g(downloadTask));
    }
}
