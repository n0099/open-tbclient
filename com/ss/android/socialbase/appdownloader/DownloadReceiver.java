package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes6.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7740a = DownloadReceiver.class.getSimpleName();
    private Handler b = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                com.ss.android.socialbase.appdownloader.c.c eFu = d.eFz().eFu();
                if (action.equals("android.intent.action.BOOT_COMPLETED") && (eFu == null || eFu.a())) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f7740a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f7740a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    com.ss.android.socialbase.downloader.downloader.b.eGo().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Uri data = intent.getData();
                            if (data != null) {
                                String schemeSpecificPart = data.getSchemeSpecificPart();
                                com.ss.android.socialbase.appdownloader.c.d eFv = d.eFz().eFv();
                                if (eFv != null) {
                                    eFv.a(context, schemeSpecificPart);
                                }
                                List<com.ss.android.socialbase.downloader.g.c> b = com.ss.android.socialbase.downloader.downloader.f.iC(context).b("application/vnd.android.package-archive");
                                if (b != null) {
                                    for (final com.ss.android.socialbase.downloader.g.c cVar : b) {
                                        if (cVar != null && c.c(cVar, schemeSpecificPart)) {
                                            com.ss.android.socialbase.downloader.d.d Rx = com.ss.android.socialbase.downloader.downloader.f.iC(context).Rx(cVar.g());
                                            if (Rx != null && com.ss.android.socialbase.downloader.m.d.e(Rx.a())) {
                                                Rx.a(9, cVar, schemeSpecificPart, "");
                                            }
                                            com.ss.android.socialbase.downloader.notification.a Sg = com.ss.android.socialbase.downloader.notification.b.eIK().Sg(cVar.g());
                                            if (Sg != null) {
                                                Sg.a((com.ss.android.socialbase.downloader.e.a) null, false);
                                            }
                                            if (com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("install_queue_enable", 0) == 1) {
                                                h.eGa().a(cVar, schemeSpecificPart);
                                            }
                                            DownloadReceiver.this.b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    com.ss.android.socialbase.downloader.downloader.b.eGo().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            try {
                                                                if (cVar.eIe()) {
                                                                    com.ss.android.socialbase.downloader.m.d.b(cVar);
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
                        }
                    });
                }
            }
        }
    }

    private void a(Context context, String str) {
        if (com.ss.android.socialbase.downloader.downloader.b.A()) {
            try {
                Intent intent = new Intent(context, DownloadHandlerService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
