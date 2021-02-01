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

    /* renamed from: b  reason: collision with root package name */
    private final Context f13031b;
    private String d;
    private String e;
    private String f;
    private final Resources qdz;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        this.f13031b = context.getApplicationContext();
        this.qdz = this.f13031b.getResources();
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
        if (this.f13031b != null) {
            try {
                this.f13252a = b(aVar, z);
                c(this.f13252a);
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
        NotificationCompat.Builder eFt = eFt();
        eFt.setWhen(f());
        int a3 = a();
        com.ss.android.socialbase.downloader.k.a RV = com.ss.android.socialbase.downloader.k.a.RV(a3);
        if (Build.VERSION.SDK_INT >= 24 && RV.a("set_notification_group", 0) == 1) {
            eFt.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            eFt.setGroupSummary(false);
        }
        int a4 = a(a2);
        if (a4 != 0) {
            eFt.setSmallIcon(a4);
        }
        boolean z2 = true;
        if (a2 == 1 || a2 == 4 || a2 == 2) {
            eFt.setContentIntent(I("android.ss.intent.action.DOWNLOAD_DELETE", a2, a3));
            eFt.setOngoing(a2 == 1 || a2 == 4);
            eFt.setAutoCancel(false);
        } else if (a2 == 3) {
            eFt.setOngoing(false);
            eFt.setAutoCancel(true);
            if (e == -1 || e == -4) {
                str = "android.ss.intent.action.DOWNLOAD_DELETE";
            } else {
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
                if (e == -3 && RV.a("notification_click_install_auto_cancel", 1) == 0) {
                    eFt.setAutoCancel(false);
                    if (h() > 0) {
                        eFt.setOngoing(false);
                        z2 = false;
                    } else {
                        eFt.setOngoing(true);
                    }
                }
            }
            eFt.setContentIntent(I(str, a2, a3));
            eFt.setDeleteIntent(I("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
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
            d = this.qdz.getString(i.b("appdownloader_download_unknown_title"));
        }
        RemoteViews eFs = eFs();
        Intent intent = new Intent(this.f13031b, DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_CLICK");
        intent.putExtra("notification_name", d());
        intent.putExtra("extra_click_download_ids", a3);
        intent.putExtra("extra_click_download_type", a2);
        int k = e.k();
        eFs.setOnClickPendingIntent(k, PendingIntent.getService(this.f13031b, a3, intent, 134217728));
        if (com.ss.android.socialbase.downloader.k.a.RV(a3).b("enable_notification_ui") == 1) {
            eFs.setInt(k, "setBackgroundResource", e.s());
            eFs.setTextColor(k, -1);
        }
        eFs.setTextViewText(e.m(), d);
        int b6 = b(a3);
        eFs.setViewVisibility(b6, 0);
        eFs.setProgressBar(b6, 100, i, z);
        int l = e.l();
        if (a4 != 0) {
            eFs.setImageViewResource(l, a4);
        }
        if (com.ss.android.socialbase.downloader.k.a.RV(a3).b("enable_notification_ui") == 1) {
            Bitmap a5 = c.eFv().a(a3);
            if (a5 != null) {
                eFs.setInt(l, "setBackgroundColor", 0);
                eFs.setImageViewBitmap(l, a5);
            } else {
                eFs.setInt(l, "setBackgroundResource", e.s());
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
            str3 = this.f13031b.getResources().getString(b2);
            string = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_pause"));
            eFs.setViewVisibility(b(a3), 0);
            eFs.setViewVisibility(e.i(), 8);
            eFs.setViewVisibility(e.j(), 0);
            int k2 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eFs.setViewVisibility(k2, 8);
            } else {
                eFs.setViewVisibility(k2, 0);
            }
        } else if (a2 == 2) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            str3 = this.f13031b.getResources().getString(i.b("appdownloader_notification_pausing"));
            string = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_resume"));
            eFs.setViewVisibility(b(a3), 8);
            eFs.setViewVisibility(e.i(), 8);
            eFs.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eFs.setViewVisibility(k3, 8);
            } else {
                eFs.setViewVisibility(k3, 0);
            }
        } else if (a2 != 3) {
            string = "";
        } else {
            com.ss.android.socialbase.downloader.g.c h = f.iB(com.ss.android.socialbase.downloader.downloader.b.eGu()).h(a3);
            if (e() == -1 || e() == -4) {
                str2 = "";
                eFs.setViewVisibility(e.o(), 8);
                if (aVar != null && aVar.a() == 1006) {
                    string2 = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_space_failed"));
                } else if (a(aVar, RV, h)) {
                    if (h != null && h.x()) {
                        b3 = i.b("appdownloader_notification_download_waiting_wifi");
                    } else {
                        b3 = i.b("appdownloader_notification_download_waiting_net");
                    }
                    string2 = this.f13031b.getResources().getString(b3);
                } else {
                    string2 = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_failed"));
                }
                string = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_restart"));
                str3 = string2;
            } else if (e() != -3) {
                string = "";
            } else {
                str2 = com.ss.android.socialbase.appdownloader.c.a(c());
                if (h != null && !TextUtils.isEmpty(h.eHf()) && h.eHf().equals("application/vnd.android.package-archive")) {
                    if (com.ss.android.socialbase.appdownloader.c.b(this.f13031b, h)) {
                        b4 = i.b("appdownloader_notification_install_finished_open");
                    } else {
                        b4 = i.b("appdownloader_notification_download_complete_with_install");
                    }
                    eFt.setContentText(this.qdz.getString(b4));
                } else {
                    b4 = i.b("appdownloader_notification_download_complete_without_install");
                    if (com.ss.android.socialbase.downloader.downloader.c.eGy().Rp(a3) != null) {
                        b4 = i.b("appdownloader_notification_download_complete_open");
                    }
                    eFt.setContentText(this.qdz.getString(b4));
                }
                str3 = this.f13031b.getResources().getString(b4);
                string = this.f13031b.getResources().getString(i.b("appdownloader_notification_download_install"));
            }
            eFs.setViewVisibility(b(a3), 8);
            eFs.setViewVisibility(e.i(), 0);
            eFs.setViewVisibility(e.j(), 8);
            eFs.setViewVisibility(e.k(), 8);
        }
        eFs.setTextViewText(e.n(), str2);
        eFs.setTextViewText(e.p(), str3);
        eFs.setTextViewText(e.o(), str2);
        eFs.setTextViewText(e.q(), str3);
        eFs.setTextViewText(e.k(), string);
        Notification build = eFt.build();
        if (z2) {
            build.flags |= 2;
            a(true);
        } else {
            a(false);
        }
        build.contentView = eFs;
        return build;
    }

    private boolean a(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.k.a aVar2, com.ss.android.socialbase.downloader.g.c cVar) {
        return aVar != null && (aVar.a() == 1013 || aVar.a() == 1049) && cVar != null && "application/vnd.android.package-archive".contains(cVar.eHf()) && aVar2.a("notification_text_opt", 0) == 1;
    }

    private RemoteViews eFs() {
        RemoteViews remoteViews = new RemoteViews(this.f13031b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.f13031b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.f13031b.getResources().getColor(e.r()));
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
        Intent intent = new Intent(this.f13031b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f13031b, i2, intent, 134217728);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:17:0x0015). Please submit an issue!!! */
    private NotificationCompat.Builder eFt() {
        NotificationCompat.Builder builder;
        String i = com.ss.android.socialbase.appdownloader.d.eFn().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f13031b);
        }
        String b2 = TextUtils.isEmpty(i) ? com.ss.android.socialbase.appdownloader.c.b(this.f13031b) : i;
        try {
            if (com.ss.android.socialbase.appdownloader.d.eFn().eFo() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.eFn().eFo().bF(this.f13031b, b2);
            } else {
                builder = new NotificationCompat.Builder(this.f13031b, b2);
            }
        } catch (NoSuchMethodError e) {
            builder = new NotificationCompat.Builder(this.f13031b);
        }
        return builder;
    }

    private int b(int i) {
        return com.ss.android.socialbase.downloader.k.a.RV(i).b("enable_notification_ui") == 1 ? e.h() : e.g();
    }
}
