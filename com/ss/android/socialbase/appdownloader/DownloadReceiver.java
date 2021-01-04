package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13300a = DownloadReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Handler f13301b = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                com.ss.android.socialbase.appdownloader.c.c eGd = d.eGi().eGd();
                if (action.equals("android.intent.action.BOOT_COMPLETED") && (eGd == null || eGd.a())) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f13300a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f13300a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    com.ss.android.socialbase.downloader.downloader.b.eGX().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Uri data = intent.getData();
                            if (data != null) {
                                String schemeSpecificPart = data.getSchemeSpecificPart();
                                com.ss.android.socialbase.appdownloader.c.d eGe = d.eGi().eGe();
                                if (eGe != null) {
                                    eGe.a(context, schemeSpecificPart);
                                }
                                List<com.ss.android.socialbase.downloader.g.c> b2 = com.ss.android.socialbase.downloader.downloader.f.iA(context).b("application/vnd.android.package-archive");
                                if (b2 != null) {
                                    for (final com.ss.android.socialbase.downloader.g.c cVar : b2) {
                                        if (cVar != null && c.c(cVar, schemeSpecificPart)) {
                                            com.ss.android.socialbase.downloader.d.d So = com.ss.android.socialbase.downloader.downloader.f.iA(context).So(cVar.g());
                                            if (So != null && com.ss.android.socialbase.downloader.m.d.e(So.a())) {
                                                So.a(9, cVar, schemeSpecificPart, "");
                                            }
                                            com.ss.android.socialbase.downloader.notification.a SX = com.ss.android.socialbase.downloader.notification.b.eJw().SX(cVar.g());
                                            if (SX != null) {
                                                SX.a((com.ss.android.socialbase.downloader.e.a) null, false);
                                            }
                                            if (com.ss.android.socialbase.downloader.k.a.SR(cVar.g()).a("install_queue_enable", 0) == 1) {
                                                h.eGJ().a(cVar, schemeSpecificPart);
                                            }
                                            DownloadReceiver.this.f13301b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    com.ss.android.socialbase.downloader.downloader.b.eGX().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            try {
                                                                if (cVar.eIP()) {
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
