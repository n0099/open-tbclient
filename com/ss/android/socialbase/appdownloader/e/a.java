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
    private final Context f13328b;
    private String d;
    private String e;
    private String f;
    private final Resources pWn;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        this.f13328b = context.getApplicationContext();
        this.pWn = this.f13328b.getResources();
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
        if (this.f13328b != null) {
            try {
                this.f13549a = b(aVar, z);
                c(this.f13549a);
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
        NotificationCompat.Builder eGo = eGo();
        eGo.setWhen(f());
        int a3 = a();
        com.ss.android.socialbase.downloader.k.a SR = com.ss.android.socialbase.downloader.k.a.SR(a3);
        if (Build.VERSION.SDK_INT >= 24 && SR.a("set_notification_group", 0) == 1) {
            eGo.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            eGo.setGroupSummary(false);
        }
        int a4 = a(a2);
        if (a4 != 0) {
            eGo.setSmallIcon(a4);
        }
        boolean z2 = true;
        if (a2 == 1 || a2 == 4 || a2 == 2) {
            eGo.setContentIntent(I("android.ss.intent.action.DOWNLOAD_DELETE", a2, a3));
            eGo.setOngoing(a2 == 1 || a2 == 4);
            eGo.setAutoCancel(false);
        } else if (a2 == 3) {
            eGo.setOngoing(false);
            eGo.setAutoCancel(true);
            if (e == -1 || e == -4) {
                str = "android.ss.intent.action.DOWNLOAD_DELETE";
            } else {
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
                if (e == -3 && SR.a("notification_click_install_auto_cancel", 1) == 0) {
                    eGo.setAutoCancel(false);
                    if (h() > 0) {
                        eGo.setOngoing(false);
                        z2 = false;
                    } else {
                        eGo.setOngoing(true);
                    }
                }
            }
            eGo.setContentIntent(I(str, a2, a3));
            eGo.setDeleteIntent(I("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
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
            d = this.pWn.getString(i.b("appdownloader_download_unknown_title"));
        }
        RemoteViews eGn = eGn();
        Intent intent = new Intent(this.f13328b, DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_CLICK");
        intent.putExtra("notification_name", d());
        intent.putExtra("extra_click_download_ids", a3);
        intent.putExtra("extra_click_download_type", a2);
        int k = e.k();
        eGn.setOnClickPendingIntent(k, PendingIntent.getService(this.f13328b, a3, intent, 134217728));
        if (com.ss.android.socialbase.downloader.k.a.SR(a3).b("enable_notification_ui") == 1) {
            eGn.setInt(k, "setBackgroundResource", e.s());
            eGn.setTextColor(k, -1);
        }
        eGn.setTextViewText(e.m(), d);
        int b6 = b(a3);
        eGn.setViewVisibility(b6, 0);
        eGn.setProgressBar(b6, 100, i, z);
        int l = e.l();
        if (a4 != 0) {
            eGn.setImageViewResource(l, a4);
        }
        if (com.ss.android.socialbase.downloader.k.a.SR(a3).b("enable_notification_ui") == 1) {
            Bitmap a5 = c.eGq().a(a3);
            if (a5 != null) {
                eGn.setInt(l, "setBackgroundColor", 0);
                eGn.setImageViewBitmap(l, a5);
            } else {
                eGn.setInt(l, "setBackgroundResource", e.s());
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
            str3 = this.f13328b.getResources().getString(b2);
            string = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_pause"));
            eGn.setViewVisibility(b(a3), 0);
            eGn.setViewVisibility(e.i(), 8);
            eGn.setViewVisibility(e.j(), 0);
            int k2 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eGn.setViewVisibility(k2, 8);
            } else {
                eGn.setViewVisibility(k2, 0);
            }
        } else if (a2 == 2) {
            str2 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            str3 = this.f13328b.getResources().getString(i.b("appdownloader_notification_pausing"));
            string = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_resume"));
            eGn.setViewVisibility(b(a3), 8);
            eGn.setViewVisibility(e.i(), 8);
            eGn.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                eGn.setViewVisibility(k3, 8);
            } else {
                eGn.setViewVisibility(k3, 0);
            }
        } else if (a2 != 3) {
            string = "";
        } else {
            com.ss.android.socialbase.downloader.g.c h = f.iA(com.ss.android.socialbase.downloader.downloader.b.eHp()).h(a3);
            if (e() == -1 || e() == -4) {
                str2 = "";
                eGn.setViewVisibility(e.o(), 8);
                if (aVar != null && aVar.a() == 1006) {
                    string2 = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_space_failed"));
                } else if (a(aVar, SR, h)) {
                    if (h != null && h.x()) {
                        b3 = i.b("appdownloader_notification_download_waiting_wifi");
                    } else {
                        b3 = i.b("appdownloader_notification_download_waiting_net");
                    }
                    string2 = this.f13328b.getResources().getString(b3);
                } else {
                    string2 = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_failed"));
                }
                string = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_restart"));
                str3 = string2;
            } else if (e() != -3) {
                string = "";
            } else {
                str2 = com.ss.android.socialbase.appdownloader.c.a(c());
                if (h != null && !TextUtils.isEmpty(h.eIa()) && h.eIa().equals("application/vnd.android.package-archive")) {
                    if (com.ss.android.socialbase.appdownloader.c.b(this.f13328b, h)) {
                        b4 = i.b("appdownloader_notification_install_finished_open");
                    } else {
                        b4 = i.b("appdownloader_notification_download_complete_with_install");
                    }
                    eGo.setContentText(this.pWn.getString(b4));
                } else {
                    b4 = i.b("appdownloader_notification_download_complete_without_install");
                    if (com.ss.android.socialbase.downloader.downloader.c.eHt().Sl(a3) != null) {
                        b4 = i.b("appdownloader_notification_download_complete_open");
                    }
                    eGo.setContentText(this.pWn.getString(b4));
                }
                str3 = this.f13328b.getResources().getString(b4);
                string = this.f13328b.getResources().getString(i.b("appdownloader_notification_download_install"));
            }
            eGn.setViewVisibility(b(a3), 8);
            eGn.setViewVisibility(e.i(), 0);
            eGn.setViewVisibility(e.j(), 8);
            eGn.setViewVisibility(e.k(), 8);
        }
        eGn.setTextViewText(e.n(), str2);
        eGn.setTextViewText(e.p(), str3);
        eGn.setTextViewText(e.o(), str2);
        eGn.setTextViewText(e.q(), str3);
        eGn.setTextViewText(e.k(), string);
        Notification build = eGo.build();
        if (z2) {
            build.flags |= 2;
            a(true);
        } else {
            a(false);
        }
        build.contentView = eGn;
        return build;
    }

    private boolean a(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.k.a aVar2, com.ss.android.socialbase.downloader.g.c cVar) {
        return aVar != null && (aVar.a() == 1013 || aVar.a() == 1049) && cVar != null && "application/vnd.android.package-archive".contains(cVar.eIa()) && aVar2.a("notification_text_opt", 0) == 1;
    }

    private RemoteViews eGn() {
        RemoteViews remoteViews = new RemoteViews(this.f13328b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.f13328b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.f13328b.getResources().getColor(e.r()));
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
        Intent intent = new Intent(this.f13328b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f13328b, i2, intent, 134217728);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:17:0x0015). Please submit an issue!!! */
    private NotificationCompat.Builder eGo() {
        NotificationCompat.Builder builder;
        String i = com.ss.android.socialbase.appdownloader.d.eGi().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f13328b);
        }
        String b2 = TextUtils.isEmpty(i) ? com.ss.android.socialbase.appdownloader.c.b(this.f13328b) : i;
        try {
            if (com.ss.android.socialbase.appdownloader.d.eGi().eGj() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.eGi().eGj().bG(this.f13328b, b2);
            } else {
                builder = new NotificationCompat.Builder(this.f13328b, b2);
            }
        } catch (NoSuchMethodError e) {
            builder = new NotificationCompat.Builder(this.f13328b);
        }
        return builder;
    }

    private int b(int i) {
        return com.ss.android.socialbase.downloader.k.a.SR(i).b("enable_notification_ui") == 1 ? e.h() : e.g();
    }
}
