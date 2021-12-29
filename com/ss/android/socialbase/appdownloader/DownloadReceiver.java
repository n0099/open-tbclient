package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static final String a = DownloadReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f62037b = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        com.ss.android.socialbase.appdownloader.c.c a2 = d.j().a();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (a2 == null || a2.a())) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.a(a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.a(a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL) || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
                    if (b2 != null) {
                        b2.a(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && c.a(downloadInfo, schemeSpecificPart)) {
                                z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.ss.android.socialbase.downloader.i.f.f(downloadNotificationEventListener.a())) {
                                    downloadNotificationEventListener.a(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.ss.android.socialbase.downloader.notification.a e2 = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
                                if (e2 != null) {
                                    e2.a((BaseException) null, false);
                                }
                                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_queue_enable", 0) == 1) {
                                    h.a().a(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.f62037b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        com.ss.android.socialbase.downloader.i.f.b(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void a(final Context context, final String str) {
        if (com.ss.android.socialbase.downloader.downloader.c.G()) {
            this.f62037b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L);
        }
    }
}
