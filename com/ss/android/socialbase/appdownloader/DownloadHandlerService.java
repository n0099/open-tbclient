package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class DownloadHandlerService extends Service {
    public static final String a = DownloadHandlerService.class.getSimpleName();

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
        z downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.g.a.a(intExtra).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(downloadInfo, b2, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, downloadInfo, b2, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            a(this, downloadInfo, b2, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.g.a.a(intExtra).a("no_hide_notification", 0) == 0) {
                if (!((com.ss.android.socialbase.downloader.g.a.a(intExtra).b("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1) ? false : false)) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
                    com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(downloadInfo, b2, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.b.a().a(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.a(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.c.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    public static void a(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.i.f.b(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    public static void a(Context context, final com.ss.android.socialbase.appdownloader.c.d dVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (dVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo a2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.c.N() == null || (a2 = c.a(DownloadInfo.this, file)) == null) ? "" : a2.packageName;
                            if (dVar != null) {
                                dVar.a(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.a(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        boolean a2;
        int id = downloadInfo.getId();
        af m = com.ss.android.socialbase.downloader.downloader.d.a().m(id);
        if (m != null) {
            try {
                a2 = m.a(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (a2) {
                Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
                intent.putExtra("extra_click_download_ids", id);
                intent.addFlags(268435456);
                startActivity(intent);
                com.ss.android.socialbase.downloader.notification.b.a().a(id);
                downloadInfo.updateDownloadTime();
                if (dVar != null) {
                    dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(7, downloadInfo, "", "");
                    return;
                }
                return;
            }
            return;
        }
        a2 = false;
        if (a2) {
        }
    }

    public static void a(Context context, int i2, boolean z) {
        boolean z2;
        af m;
        DownloadInfo downloadInfo;
        if (z && (m = com.ss.android.socialbase.downloader.downloader.d.a().m(i2)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = m.b(downloadInfo);
                if (z2 && c.a(context, i2, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void a(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        com.ss.android.socialbase.downloader.notification.a e2;
        int id = downloadInfo.getId();
        af m = com.ss.android.socialbase.downloader.downloader.d.a().m(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && m != null && c.a(context, downloadInfo) && m.c(downloadInfo)) {
            return;
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.g.a.a(id).b("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                a(com.ss.android.socialbase.downloader.downloader.c.N(), id, true);
                a(context, dVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.g.a.a(id).a("notification_click_install_auto_cancel", 1) != 0 || (e2 = com.ss.android.socialbase.downloader.notification.b.a().e(id)) == null) {
                    z = true;
                } else {
                    e2.g();
                    e2.a(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(id);
                    return;
                }
                return;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.d.a().e(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    c.a(downloadInfo, true, false);
                }
                if (dVar != null) {
                    dVar.a(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(6, downloadInfo, "", "");
                    return;
                }
                return;
            case 0:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                a(context, downloadInfo);
                if (dVar != null) {
                    dVar.a(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
