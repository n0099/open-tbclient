package com.kwad.sdk.core.download;

import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes7.dex */
public class b {
    public static final boolean a = KsAdSDKImpl.get().isDebugLogEnable();

    public static void a(String str) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadStart(), id=" + str);
        }
        DownloadStatusManager.a().a(str);
    }

    public static void a(String str, int i2, int i3, int i4) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i2 + " soFarBytes=" + i3 + " totalBytes=" + i4);
        }
        DownloadStatusManager.a().a(str, i2, i3, i4);
    }

    public static void a(String str, int i2, String str2) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFail(), id=" + str + " errorCode=" + i2 + " errorMsg=" + str2);
        }
        DownloadStatusManager.a().a(str, i2, str2);
    }

    public static void a(String str, String str2) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFinished(), id=" + str + " filePath=" + str2);
        }
        DownloadStatusManager.a().a(str, str2);
    }

    public static void b(String str) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadPaused(), id=" + str);
        }
        DownloadStatusManager.a().b(str);
    }

    public static void c(String str) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadResumed(), id=" + str);
        }
        DownloadStatusManager.a().c(str);
    }

    public static void d(String str) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
        }
        DownloadStatusManager.a().d(str);
    }

    public static void e(String str) {
        if (a) {
            com.kwad.sdk.core.d.a.a("DownloadMonitor", "onLowStorage(), id=" + str);
        }
        DownloadStatusManager.a().e(str);
    }
}
