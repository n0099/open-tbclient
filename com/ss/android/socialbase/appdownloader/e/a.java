package com.ss.android.socialbase.appdownloader.e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.f;
/* loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {
    private final Context b;
    private String d;
    private String e;
    private String f;
    private final Resources qeN;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        this.b = context.getApplicationContext();
        this.qeN = this.b.getResources();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        super.a(cVar);
        this.e = cVar.k();
        this.d = cVar.h();
        this.f = cVar.C();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        if (this.b != null) {
            try {
                this.f7898a = b(aVar, z);
                c(this.f7898a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Notification b(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        int b;
        String string;
        String string2;
        int b2;
        int b3;
        String str;
        int e = e();
        int a2 = com.ss.android.socialbase.appdownloader.c.a(e);
        if (a2 == 0) {
            return null;
        }
        NotificationCompat.Builder eFF = eFF();
        eFF.setWhen(f());
        int a3 = a();
        com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(a3);
        if (Build.VERSION.SDK_INT >= 24 && Sa.a("set_notification_group", 0) == 1) {
            eFF.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            eFF.setGroupSummary(false);
        }
        int a4 = a(a2);
        if (a4 != 0) {
            eFF.setSmallIcon(a4);
        }
        boolean z2 = true;
        if (a2 == 1 || a2 == 4 || a2 == 2) {
            eFF.setContentIntent(I("android.ss.intent.action.DOWNLOAD_DELETE", a2, a3));
            eFF.setOngoing(a2 == 1 || a2 == 4);
            eFF.setAutoCancel(false);
        } else if (a2 == 3) {
            eFF.setOngoing(false);
            eFF.setAutoCancel(true);
            if (e == -1 || e == -4) {
                str = "android.ss.intent.action.DOWNLOAD_DELETE";
            } else {
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
                if (e == -3 && Sa.a("notification_click_install_auto_cancel", 1) == 0) {
                    eFF.setAutoCancel(false);
                    if (h() > 0) {
                        eFF.setOngoing(false);
                        z2 = false;
                    } else {
                        eFF.setOngoing(true);
                    }
                }
            }
            eFF.setContentIntent(I(str, a2, a3));
            eFF.setDeleteIntent(I("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
        }
        int i = 0;
        long b4 = b();
        long c = c();
        if (a2 == 1 || a2 == 4) {
            if (c > 0) {
                i = (int) ((b4 * 100) / c);
            } else {
                i = 0;
            }
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            d = this.qeN.getString(i.b("appdownloader_download_unknown_title"));
        }
        RemoteViews eFE = eFE();
        Intent intent = new Intent(this.b, DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_CLICK");
        intent.putExtra("notification_name", d());
        intent.putExtra("extra_click_download_ids", a3);
        intent.putExtra("extra_click_download_type", a2);
        int k = e.k();
        eFE.setOnClickPendingIntent(k, PendingIntent.getService(this.b, a3, intent, 134217728));
        if (com.ss.android.socialbase.downloader.k.a.Sa(a3).b("enable_notification_ui") == 1) {
            eFE.setInt(k, "setBackgroundResource", e.s());
            eFE.setTextColor(k, -1);
        }
        eFE.setTextViewText(e.m(), d);
        int b5 = b(a3);
        eFE.setViewVisibility(b5, 0);
        eFE.setProgressBar(b5, 100, i, z);
        int l = e.l();
        if (a4 != 0) {
            eFE.setImageViewResource(l, a4);
        }
        if (com.ss.android.socialbase.downloader.k.a.Sa(a3).b("enable_notification_ui") == 1) {
            Bitmap a5 = c.eFH().a(a3);
            if (a5 != null) {
                eFE.setInt(l, "setBackgroundColor", 0);
                eFE.setImageViewBitmap(l, a5);
            } else {
                eFE.setInt(l, "setBackgroundResource", e.s());
            }
        }
        String str2 = "";
        String str3 = "";
        if (a2 == 1 || a2 == 4) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            if (a2 == 1) {
                if (e() == 11) {
                    b = i.b("appdownloader_notification_waiting_download_complete_handler");
                } else {
                    b = i.b("appdownloader_notification_downloading");
                }
            } else {
                b = i.b("appdownloader_notification_prepare");
            }
            str3 = this.b.getResources().getString(b);
            string = this.b.getResources().getString(i.b("appdownloader_notification_download_pause"));
            eFE.setViewVisibility(b(a3), 0);
            eFE.setViewVisibility(e.i(), 8);
            eFE.setViewVisibility(e.j(), 0);
            int k2 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eFE.setViewVisibility(k2, 8);
            } else {
                eFE.setViewVisibility(k2, 0);
            }
        } else if (a2 == 2) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            str3 = this.b.getResources().getString(i.b("appdownloader_notification_pausing"));
            string = this.b.getResources().getString(i.b("appdownloader_notification_download_resume"));
            eFE.setViewVisibility(b(a3), 8);
            eFE.setViewVisibility(e.i(), 8);
            eFE.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eFE.setViewVisibility(k3, 8);
            } else {
                eFE.setViewVisibility(k3, 0);
            }
        } else if (a2 != 3) {
            string = "";
        } else {
            com.ss.android.socialbase.downloader.g.c h = f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).h(a3);
            if (e() == -1 || e() == -4) {
                str2 = "";
                eFE.setViewVisibility(e.o(), 8);
                if (aVar != null && aVar.a() == 1006) {
                    string2 = this.b.getResources().getString(i.b("appdownloader_notification_download_space_failed"));
                } else if (a(aVar, Sa, h)) {
                    if (h != null && h.x()) {
                        b2 = i.b("appdownloader_notification_download_waiting_wifi");
                    } else {
                        b2 = i.b("appdownloader_notification_download_waiting_net");
                    }
                    string2 = this.b.getResources().getString(b2);
                } else {
                    string2 = this.b.getResources().getString(i.b("appdownloader_notification_download_failed"));
                }
                string = this.b.getResources().getString(i.b("appdownloader_notification_download_restart"));
                str3 = string2;
            } else if (e() != -3) {
                string = "";
            } else {
                str2 = com.ss.android.socialbase.appdownloader.c.a(c());
                if (h != null && !TextUtils.isEmpty(h.at()) && h.at().equals("application/vnd.android.package-archive")) {
                    if (com.ss.android.socialbase.appdownloader.c.b(this.b, h)) {
                        b3 = i.b("appdownloader_notification_install_finished_open");
                    } else {
                        b3 = i.b("appdownloader_notification_download_complete_with_install");
                    }
                    eFF.setContentText(this.qeN.getString(b3));
                } else {
                    b3 = i.b("appdownloader_notification_download_complete_without_install");
                    if (com.ss.android.socialbase.downloader.downloader.c.eGK().Ru(a3) != null) {
                        b3 = i.b("appdownloader_notification_download_complete_open");
                    }
                    eFF.setContentText(this.qeN.getString(b3));
                }
                str3 = this.b.getResources().getString(b3);
                string = this.b.getResources().getString(i.b("appdownloader_notification_download_install"));
            }
            eFE.setViewVisibility(b(a3), 8);
            eFE.setViewVisibility(e.i(), 0);
            eFE.setViewVisibility(e.j(), 8);
            eFE.setViewVisibility(e.k(), 8);
        }
        eFE.setTextViewText(e.n(), str2);
        eFE.setTextViewText(e.p(), str3);
        eFE.setTextViewText(e.o(), str2);
        eFE.setTextViewText(e.q(), str3);
        eFE.setTextViewText(e.k(), string);
        Notification build = eFF.build();
        if (z2) {
            build.flags |= 2;
            a(true);
        } else {
            a(false);
        }
        build.contentView = eFE;
        return build;
    }

    private boolean a(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.k.a aVar2, com.ss.android.socialbase.downloader.g.c cVar) {
        return aVar != null && (aVar.a() == 1013 || aVar.a() == 1049) && cVar != null && "application/vnd.android.package-archive".contains(cVar.at()) && aVar2.a("notification_text_opt", 0) == 1;
    }

    private RemoteViews eFE() {
        RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.b.getResources().getColor(e.r()));
                }
            } catch (Throwable th) {
            }
        }
        return remoteViews;
    }

    private int a(int i) {
        if (i == 1 || i == 4) {
            return e.t();
        }
        if (i == 2) {
            return e.u();
        }
        if (i != 3) {
            return 0;
        }
        return e.v();
    }

    private PendingIntent I(String str, int i, int i2) {
        Intent intent = new Intent(this.b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.b, i2, intent, 134217728);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:17:0x0015). Please submit an issue!!! */
    private NotificationCompat.Builder eFF() {
        NotificationCompat.Builder builder;
        String i = com.ss.android.socialbase.appdownloader.d.eFz().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.b);
        }
        String b = TextUtils.isEmpty(i) ? com.ss.android.socialbase.appdownloader.c.b(this.b) : i;
        try {
            if (com.ss.android.socialbase.appdownloader.d.eFz().eFA() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.eFz().eFA().bD(this.b, b);
            } else {
                builder = new NotificationCompat.Builder(this.b, b);
            }
        } catch (NoSuchMethodError e) {
            builder = new NotificationCompat.Builder(this.b);
        }
        return builder;
    }

    private int b(int i) {
        return com.ss.android.socialbase.downloader.k.a.Sa(i).b("enable_notification_ui") == 1 ? e.h() : e.g();
    }
}
