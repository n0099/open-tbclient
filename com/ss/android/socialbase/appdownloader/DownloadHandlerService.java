package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.d.r;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13002a = DownloadHandlerService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13002a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    private boolean a(Intent intent) {
        com.ss.android.socialbase.downloader.g.c h;
        int q;
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.c.d eFr = d.eFv().eFr();
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        int intExtra2 = intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.downloader.d.d Rt = com.ss.android.socialbase.downloader.downloader.f.iB(this).Rt(intExtra);
        if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN") || action.equals("android.ss.intent.action.DOWNLOAD_DELETE") || action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            a(this, intent);
            if (!action.equals("android.ss.intent.action.DOWNLOAD_DELETE") || (h = com.ss.android.socialbase.downloader.downloader.f.iB(this).h(intExtra)) == null) {
                return false;
            }
            h.aa();
            if (eFr != null) {
                eFr.a(intExtra, 7, "", h.q(), h.eHB());
            }
            if (Rt != null) {
                Rt.a(7, h, "", "");
                return false;
            }
            return false;
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK")) {
            com.ss.android.socialbase.downloader.g.c h2 = com.ss.android.socialbase.downloader.downloader.f.iB(this).h(intExtra);
            if (h2 == null || (q = h2.q()) == 0) {
                return false;
            }
            if (q == -3) {
                c.f((Context) this, intExtra, true);
                a(eFr, h2);
                return true;
            }
            if (intExtra2 == 1 || intExtra2 == 4) {
                if (com.ss.android.socialbase.downloader.b.f.b(q)) {
                    a(h2);
                    com.ss.android.socialbase.downloader.downloader.f.iB(this).a(intExtra);
                    if (eFr != null) {
                        eFr.a(intExtra, 5, "", h2.q(), h2.eHB());
                    }
                    if (Rt != null) {
                        Rt.a(5, h2, "", "");
                    }
                }
            } else if (intExtra2 == 2) {
                com.ss.android.socialbase.downloader.downloader.f.iB(this).c(intExtra);
                if (eFr != null) {
                    eFr.a(intExtra, 6, "", h2.q(), h2.eHB());
                }
                if (Rt != null) {
                    Rt.a(6, h2, "", "");
                }
            } else if (intExtra2 == 3) {
                if (q == -1 || q == -4) {
                    com.ss.android.socialbase.downloader.downloader.f.iB(this).e(intExtra);
                }
            } else {
                a(h2, eFr, Rt);
            }
            if (h2.aQ() && com.ss.android.socialbase.downloader.k.a.RW(intExtra).a("no_hide_notification", 0) == 0) {
                com.ss.android.socialbase.downloader.notification.b.eIJ().a(intExtra);
                com.ss.android.socialbase.downloader.notification.b.eIJ().f(intExtra);
                return false;
            }
            return false;
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plugin");
                        com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).a(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        } else {
            return false;
        }
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (com.ss.android.socialbase.downloader.m.d.a(getApplicationContext()) && cVar.U()) {
            cVar.Y();
        }
    }

    private void a(final com.ss.android.socialbase.appdownloader.c.d dVar, final com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            final com.ss.android.socialbase.downloader.d.d Rt = com.ss.android.socialbase.downloader.downloader.f.iB(this).Rt(cVar.g());
            if (dVar != null || Rt != null) {
                com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PackageInfo a2;
                        try {
                            File file = new File(cVar.k(), cVar.h());
                            if (file.exists()) {
                                try {
                                    String str = "";
                                    Context eGC = com.ss.android.socialbase.downloader.downloader.b.eGC();
                                    if (eGC != null && (a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(eGC, file, c.a())) != null) {
                                        str = a2.packageName;
                                    }
                                    if (dVar != null) {
                                        dVar.a(cVar.g(), 3, str, -3, cVar.eHB());
                                    }
                                    if (Rt != null) {
                                        Rt.a(3, cVar, str, "");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void a(Context context, Intent intent) {
        com.ss.android.socialbase.downloader.notification.a Sc;
        com.ss.android.socialbase.downloader.g.c h;
        boolean z = false;
        String action = intent.getAction();
        try {
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            boolean booleanExtra = intent.getBooleanExtra("extra_from_notification", false);
            if ("android.ss.intent.action.DOWNLOAD_DELETE".equals(action)) {
                if (booleanExtra) {
                    r Rq = com.ss.android.socialbase.downloader.downloader.c.eGG().Rq(intExtra);
                    if (Rq == null) {
                        Rq = com.ss.android.socialbase.downloader.downloader.b.eGz();
                    }
                    if (Rq != null && (h = com.ss.android.socialbase.downloader.downloader.f.iB(context).h(intExtra)) != null) {
                        z = Rq.a(h);
                    }
                }
                if (!z) {
                    Intent intent2 = new Intent(context, DownloadTaskDeleteActivity.class);
                    intent2.putExtra("extra_click_download_ids", intExtra);
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                    com.ss.android.socialbase.downloader.notification.b.eIJ().a(intExtra);
                }
            } else if ("android.ss.intent.action.DOWNLOAD_OPEN".equals(action)) {
                com.ss.android.socialbase.downloader.g.c h2 = com.ss.android.socialbase.downloader.downloader.f.iB(this).h(intExtra);
                r Rq2 = com.ss.android.socialbase.downloader.downloader.c.eGG().Rq(intExtra);
                if (booleanExtra && h2 != null && "application/vnd.android.package-archive".equals(h2.eHn()) && Rq2 != null && c.b(this, h2)) {
                    Rq2.c(h2);
                    return;
                }
                a(context, intExtra, booleanExtra);
                com.ss.android.socialbase.appdownloader.c.d eFr = d.eFv().eFr();
                com.ss.android.socialbase.downloader.d.d Rt = com.ss.android.socialbase.downloader.downloader.f.iB(this).Rt(intExtra);
                if ((eFr != null || Rt != null) && h2 != null) {
                    a(eFr, h2);
                }
                if (com.ss.android.socialbase.downloader.k.a.RW(intExtra).a("notification_click_install_auto_cancel", 1) != 0 || (Sc = com.ss.android.socialbase.downloader.notification.b.eIJ().Sc(intExtra)) == null) {
                    z = true;
                } else {
                    Sc.g();
                    Sc.a(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.b.eIJ().a(intExtra);
                }
            } else if ("android.ss.intent.action.DOWNLOAD_HIDE".equals(action)) {
                com.ss.android.socialbase.downloader.notification.b.eIJ().a(intExtra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, int i, boolean z) {
        boolean z2;
        r Rq;
        com.ss.android.socialbase.downloader.g.c h;
        if (z && (Rq = com.ss.android.socialbase.downloader.downloader.c.eGG().Rq(i)) != null) {
            try {
                h = com.ss.android.socialbase.downloader.downloader.f.iB(context).h(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (h != null) {
                z2 = Rq.b(h);
                if (!z2 && c.f(context, i, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (!z2) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.downloader.d.d dVar2) {
        int g = cVar.g();
        switch (cVar.q()) {
            case -4:
            case -1:
                com.ss.android.socialbase.downloader.downloader.f.iB(this).e(g);
                return;
            case -3:
                c.f((Context) this, g, true);
                a(dVar, cVar);
                return;
            case -2:
                com.ss.android.socialbase.downloader.downloader.f.iB(this).c(g);
                if (dVar != null) {
                    dVar.a(g, 6, "", cVar.q(), cVar.eHB());
                }
                if (dVar2 != null) {
                    dVar2.a(6, cVar, "", "");
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
                com.ss.android.socialbase.downloader.downloader.f.iB(this).a(g);
                a(cVar);
                if (dVar != null) {
                    dVar.a(g, 5, "", cVar.q(), cVar.eHB());
                }
                if (dVar2 != null) {
                    dVar2.a(5, cVar, "", "");
                    return;
                }
                return;
        }
    }
}
