package com.kwad.sdk.core.download;

import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes5.dex */
public final class c {
    public static final boolean a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).j();

    public static void a(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadStart(), id=" + str);
        }
        e.a().b(str);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i + " soFarBytes=" + i2 + " totalBytes=" + i3);
        }
        e.a().a(str, i, i2, i3);
    }

    public static void a(String str, int i, String str2) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadFail(), id=" + str + " errorCode=0 errorMsg=" + str2);
        }
        e.a().a(str, 0, str2);
    }

    public static void a(String str, String str2) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadFinished(), id=" + str + " filePath=" + str2);
        }
        e.a().a(str, str2);
    }

    public static void b(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadPaused(), id=" + str);
        }
        e.a().c(str);
    }

    public static void c(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadResumed(), id=" + str);
        }
        e.a().d(str);
    }

    public static void d(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
        }
        e.a().e(str);
    }

    public static void e(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onLowStorage(), id=" + str);
        }
        e.a().g(str);
    }

    public static void f(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("DownloadMonitor", "onStartInstallApk(), id=" + str);
        }
        e.a().f(str);
    }
}
