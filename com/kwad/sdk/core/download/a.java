package com.kwad.sdk.core.download;

import com.ksad.download.DownloadTask;
import com.kwad.sdk.utils.aa;
/* loaded from: classes5.dex */
public class a extends com.ksad.download.c {
    private String g(DownloadTask downloadTask) {
        return aa.a(downloadTask.getUrl());
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
        b.a(g(downloadTask), 0, str);
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask) {
        b.a(g(downloadTask), downloadTask.getTargetFilePath());
    }

    @Override // com.ksad.download.c
    public void b(DownloadTask downloadTask, int i, int i2) {
        b.a(g(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask) {
        if (downloadTask.getSmallFileSoFarBytes() == 0) {
            b.a(g(downloadTask));
        }
    }

    @Override // com.ksad.download.c
    public void c(DownloadTask downloadTask, int i, int i2) {
        b.b(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask) {
    }

    @Override // com.ksad.download.c
    public void d(DownloadTask downloadTask, int i, int i2) {
        b.c(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void e(DownloadTask downloadTask) {
        b.d(g(downloadTask));
    }

    @Override // com.ksad.download.c
    public void f(DownloadTask downloadTask) {
        b.e(g(downloadTask));
    }
}
