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
    private static final String f13003a = DownloadReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Handler f13004b = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                com.ss.android.socialbase.appdownloader.c.c eFq = d.eFv().eFq();
                if (action.equals("android.intent.action.BOOT_COMPLETED") && (eFq == null || eFq.a())) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f13003a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                    if (com.ss.android.socialbase.downloader.f.a.a()) {
                        com.ss.android.socialbase.downloader.f.a.a(f13003a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
                    }
                    a(context, action);
                } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Uri data = intent.getData();
                            if (data != null) {
                                String schemeSpecificPart = data.getSchemeSpecificPart();
                                com.ss.android.socialbase.appdownloader.c.d eFr = d.eFv().eFr();
                                if (eFr != null) {
                                    eFr.a(context, schemeSpecificPart);
                                }
                                List<com.ss.android.socialbase.downloader.g.c> b2 = com.ss.android.socialbase.downloader.downloader.f.iB(context).b("application/vnd.android.package-archive");
                                if (b2 != null) {
                                    for (final com.ss.android.socialbase.downloader.g.c cVar : b2) {
                                        if (cVar != null && c.c(cVar, schemeSpecificPart)) {
                                            com.ss.android.socialbase.downloader.d.d Rt = com.ss.android.socialbase.downloader.downloader.f.iB(context).Rt(cVar.g());
                                            if (Rt != null && com.ss.android.socialbase.downloader.m.d.e(Rt.a())) {
                                                Rt.a(9, cVar, schemeSpecificPart, "");
                                            }
                                            com.ss.android.socialbase.downloader.notification.a Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(cVar.g());
                                            if (Sc != null) {
                                                Sc.a((com.ss.android.socialbase.downloader.e.a) null, false);
                                            }
                                            if (com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("install_queue_enable", 0) == 1) {
                                                h.eFW().a(cVar, schemeSpecificPart);
                                            }
                                            DownloadReceiver.this.f13004b.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            try {
                                                                if (cVar.eIc()) {
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
