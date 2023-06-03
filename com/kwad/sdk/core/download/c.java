package com.kwad.sdk.core.download;

import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class c {
    public static final boolean DEBUG = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).isDebugLogEnable();

    public static void a(String str, int i, int i2, int i3) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i + " soFarBytes=" + i2 + " totalBytes=" + i3);
        }
        e.sV().a(str, i, i2, i3);
    }

    public static void b(String str, int i, String str2) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadFail(), id=" + str + " errorCode=0 errorMsg=" + str2);
        }
        e.sV().c(str, 0, str2);
    }

    public static void bE(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadStart(), id=" + str);
        }
        e.sV().bE(str);
    }

    public static void bF(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadPaused(), id=" + str);
        }
        e.sV().bF(str);
    }

    public static void bG(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadResumed(), id=" + str);
        }
        e.sV().bG(str);
    }

    public static void bH(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadCanceled(), id=" + str);
        }
        e.sV().bH(str);
    }

    public static void bI(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onLowStorage(), id=" + str);
        }
        e.sV().bI(str);
    }

    public static void bJ(String str) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onStartInstallApk(), id=" + str);
        }
        e.sV().bJ(str);
    }

    public static void u(String str, String str2) {
        if (DEBUG) {
            com.kwad.sdk.core.e.b.d("DownloadMonitor", "onDownloadFinished(), id=" + str + " filePath=" + str2);
        }
        e.sV().u(str, str2);
    }
}
