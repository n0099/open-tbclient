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
/* loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {

    /* renamed from: b  reason: collision with root package name */
    private final Context f13329b;
    private String d;
    private String e;
    private String f;
    private final Resources pXV;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        this.f13329b = context.getApplicationContext();
        this.pXV = this.f13329b.getResources();
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
        if (this.f13329b != null) {
            try {
                this.f13550a = b(aVar, z);
                c(this.f13550a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Notification b(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        int b2;
        String string;
        String string2;
        int b3;
        int b4;
        String str;
        int e = e();
        int a2 = com.ss.android.socialbase.appdownloader.c.a(e);
        if (a2 == 0) {
            return null;
        }
        NotificationCompat.Builder eGS = eGS();
        eGS.setWhen(f());
        int a3 = a();
        com.ss.android.socialbase.downloader.k.a Th = com.ss.android.socialbase.downloader.k.a.Th(a3);
        if (Build.VERSION.SDK_INT >= 24 && Th.a("set_notification_group", 0) == 1) {
            eGS.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            eGS.setGroupSummary(false);
        }
        int a4 = a(a2);
        if (a4 != 0) {
            eGS.setSmallIcon(a4);
        }
        boolean z2 = true;
        if (a2 == 1 || a2 == 4 || a2 == 2) {
            eGS.setContentIntent(I("android.ss.intent.action.DOWNLOAD_DELETE", a2, a3));
            eGS.setOngoing(a2 == 1 || a2 == 4);
            eGS.setAutoCancel(false);
        } else if (a2 == 3) {
            eGS.setOngoing(false);
            eGS.setAutoCancel(true);
            if (e == -1 || e == -4) {
                str = "android.ss.intent.action.DOWNLOAD_DELETE";
            } else {
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
                if (e == -3 && Th.a("notification_click_install_auto_cancel", 1) == 0) {
                    eGS.setAutoCancel(false);
                    if (h() > 0) {
                        eGS.setOngoing(false);
                        z2 = false;
                    } else {
                        eGS.setOngoing(true);
                    }
                }
            }
            eGS.setContentIntent(I(str, a2, a3));
            eGS.setDeleteIntent(I("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
        }
        int i = 0;
        long b5 = b();
        long c = c();
        if (a2 == 1 || a2 == 4) {
            if (c > 0) {
                i = (int) ((b5 * 100) / c);
            } else {
                i = 0;
            }
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            d = this.pXV.getString(i.b("appdownloader_download_unknown_title"));
        }
        RemoteViews eGR = eGR();
        Intent intent = new Intent(this.f13329b, DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_CLICK");
        intent.putExtra("notification_name", d());
        intent.putExtra("extra_click_download_ids", a3);
        intent.putExtra("extra_click_download_type", a2);
        int k = e.k();
        eGR.setOnClickPendingIntent(k, PendingIntent.getService(this.f13329b, a3, intent, 134217728));
        if (com.ss.android.socialbase.downloader.k.a.Th(a3).b("enable_notification_ui") == 1) {
            eGR.setInt(k, "setBackgroundResource", e.s());
            eGR.setTextColor(k, -1);
        }
        eGR.setTextViewText(e.m(), d);
        int b6 = b(a3);
        eGR.setViewVisibility(b6, 0);
        eGR.setProgressBar(b6, 100, i, z);
        int l = e.l();
        if (a4 != 0) {
            eGR.setImageViewResource(l, a4);
        }
        if (com.ss.android.socialbase.downloader.k.a.Th(a3).b("enable_notification_ui") == 1) {
            Bitmap a5 = c.eGU().a(a3);
            if (a5 != null) {
                eGR.setInt(l, "setBackgroundColor", 0);
                eGR.setImageViewBitmap(l, a5);
            } else {
                eGR.setInt(l, "setBackgroundResource", e.s());
            }
        }
        String str2 = "";
        String str3 = "";
        if (a2 == 1 || a2 == 4) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            if (a2 == 1) {
                if (e() == 11) {
                    b2 = i.b("appdownloader_notification_waiting_download_complete_handler");
                } else {
                    b2 = i.b("appdownloader_notification_downloading");
                }
            } else {
                b2 = i.b("appdownloader_notification_prepare");
            }
            str3 = this.f13329b.getResources().getString(b2);
            string = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_pause"));
            eGR.setViewVisibility(b(a3), 0);
            eGR.setViewVisibility(e.i(), 8);
            eGR.setViewVisibility(e.j(), 0);
            int k2 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eGR.setViewVisibility(k2, 8);
            } else {
                eGR.setViewVisibility(k2, 0);
            }
        } else if (a2 == 2) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            str3 = this.f13329b.getResources().getString(i.b("appdownloader_notification_pausing"));
            string = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_resume"));
            eGR.setViewVisibility(b(a3), 8);
            eGR.setViewVisibility(e.i(), 8);
            eGR.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eGR.setViewVisibility(k3, 8);
            } else {
                eGR.setViewVisibility(k3, 0);
            }
        } else if (a2 != 3) {
            string = "";
        } else {
            com.ss.android.socialbase.downloader.g.c h = f.iA(com.ss.android.socialbase.downloader.downloader.b.eHT()).h(a3);
            if (e() == -1 || e() == -4) {
                str2 = "";
                eGR.setViewVisibility(e.o(), 8);
                if (aVar != null && aVar.a() == 1006) {
                    string2 = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_space_failed"));
                } else if (a(aVar, Th, h)) {
                    if (h != null && h.x()) {
                        b3 = i.b("appdownloader_notification_download_waiting_wifi");
                    } else {
                        b3 = i.b("appdownloader_notification_download_waiting_net");
                    }
                    string2 = this.f13329b.getResources().getString(b3);
                } else {
                    string2 = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_failed"));
                }
                string = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_restart"));
                str3 = string2;
            } else if (e() != -3) {
                string = "";
            } else {
                str2 = com.ss.android.socialbase.appdownloader.c.a(c());
                if (h != null && !TextUtils.isEmpty(h.eIE()) && h.eIE().equals("application/vnd.android.package-archive")) {
                    if (com.ss.android.socialbase.appdownloader.c.b(this.f13329b, h)) {
                        b4 = i.b("appdownloader_notification_install_finished_open");
                    } else {
                        b4 = i.b("appdownloader_notification_download_complete_with_install");
                    }
                    eGS.setContentText(this.pXV.getString(b4));
                } else {
                    b4 = i.b("appdownloader_notification_download_complete_without_install");
                    if (com.ss.android.socialbase.downloader.downloader.c.eHX().SB(a3) != null) {
                        b4 = i.b("appdownloader_notification_download_complete_open");
                    }
                    eGS.setContentText(this.pXV.getString(b4));
                }
                str3 = this.f13329b.getResources().getString(b4);
                string = this.f13329b.getResources().getString(i.b("appdownloader_notification_download_install"));
            }
            eGR.setViewVisibility(b(a3), 8);
            eGR.setViewVisibility(e.i(), 0);
            eGR.setViewVisibility(e.j(), 8);
            eGR.setViewVisibility(e.k(), 8);
        }
        eGR.setTextViewText(e.n(), str2);
        eGR.setTextViewText(e.p(), str3);
        eGR.setTextViewText(e.o(), str2);
        eGR.setTextViewText(e.q(), str3);
        eGR.setTextViewText(e.k(), string);
        Notification build = eGS.build();
        if (z2) {
            build.flags |= 2;
            a(true);
        } else {
            a(false);
        }
        build.contentView = eGR;
        return build;
    }

    private boolean a(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.k.a aVar2, com.ss.android.socialbase.downloader.g.c cVar) {
        return aVar != null && (aVar.a() == 1013 || aVar.a() == 1049) && cVar != null && "application/vnd.android.package-archive".contains(cVar.eIE()) && aVar2.a("notification_text_opt", 0) == 1;
    }

    private RemoteViews eGR() {
        RemoteViews remoteViews = new RemoteViews(this.f13329b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.f13329b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.f13329b.getResources().getColor(e.r()));
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
        Intent intent = new Intent(this.f13329b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f13329b, i2, intent, 134217728);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:17:0x0015). Please submit an issue!!! */
    private NotificationCompat.Builder eGS() {
        NotificationCompat.Builder builder;
        String i = com.ss.android.socialbase.appdownloader.d.eGM().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f13329b);
        }
        String b2 = TextUtils.isEmpty(i) ? com.ss.android.socialbase.appdownloader.c.b(this.f13329b) : i;
        try {
            if (com.ss.android.socialbase.appdownloader.d.eGM().eGN() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.eGM().eGN().bG(this.f13329b, b2);
            } else {
                builder = new NotificationCompat.Builder(this.f13329b, b2);
            }
        } catch (NoSuchMethodError e) {
            builder = new NotificationCompat.Builder(this.f13329b);
        }
        return builder;
    }

    private int b(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).b("enable_notification_ui") == 1 ? e.h() : e.g();
    }
}
