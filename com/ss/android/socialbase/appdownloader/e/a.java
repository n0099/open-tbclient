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
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes8.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {
    public final Context b;
    public final Resources c;
    public String d;
    public String e;
    public String f;

    public a(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.e = str2;
        this.d = str3;
        this.f = str4;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification b(BaseException baseException, boolean z) {
        String str;
        int b;
        String string;
        String str2;
        boolean z2;
        boolean z3;
        int b2;
        String string2;
        int i;
        int b3;
        int i2;
        int e = e();
        int a = com.ss.android.socialbase.appdownloader.c.a(e);
        if (a == 0) {
            return null;
        }
        NotificationCompat.Builder k = k();
        k.setWhen(f());
        int a2 = a();
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(a2);
        if (Build.VERSION.SDK_INT >= 24 && a3.a("set_notification_group", 0) == 1) {
            k.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            k.setGroupSummary(false);
        }
        int a4 = a(a, a2);
        if (a4 != 0) {
            k.setSmallIcon(a4);
        }
        String str3 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (a == 1 || a == 4 || a == 2) {
            k.setContentIntent(a("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", a, a2));
            k.setOngoing(a == 1 || a == 4);
            k.setAutoCancel(false);
        } else if (a == 3) {
            k.setOngoing(false);
            k.setAutoCancel(true);
            if (e != -1 && e != -4) {
                if (e == -3 && a3.a("notification_click_install_auto_cancel", 1) == 0) {
                    k.setAutoCancel(false);
                    if (h() > 0) {
                        k.setOngoing(false);
                    } else {
                        k.setOngoing(true);
                    }
                }
                str3 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            k.setContentIntent(a(str3, a, a2));
            k.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a, a2));
        }
        long b4 = b();
        long c = c();
        int i3 = c > 0 ? (int) ((b4 * 100) / c) : 0;
        String d = d();
        if (TextUtils.isEmpty(d)) {
            d = this.c.getString(i.b("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews j = j();
        int k2 = e.k();
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
            j.setOnClickPendingIntent(k2, a("android.ss.intent.action.DOWNLOAD_CLICK_BTN", a, a2));
        }
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            j.setInt(k2, "setBackgroundResource", e.s());
            j.setTextColor(k2, -1);
        }
        j.setTextViewText(e.m(), d);
        int a5 = a(a2);
        j.setViewVisibility(a5, 0);
        j.setProgressBar(a5, 100, i3, z);
        int l = e.l();
        if (a4 != 0) {
            j.setImageViewResource(l, a4);
        }
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            Bitmap a6 = c.a().a(a2);
            if (a6 != null) {
                j.setInt(l, "setBackgroundColor", 0);
                j.setImageViewBitmap(l, a6);
            } else {
                j.setInt(l, "setBackgroundResource", e.s());
            }
        }
        str = "";
        if (a == 1 || a == 4) {
            str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            if (a == 1) {
                if (e() == 11) {
                    b = i.b("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    b = i.b("tt_appdownloader_notification_downloading");
                }
            } else {
                b = i.b("tt_appdownloader_notification_prepare");
            }
            String string3 = this.b.getResources().getString(b);
            string = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
            j.setViewVisibility(a(a2), 0);
            j.setViewVisibility(e.i(), 8);
            j.setViewVisibility(e.j(), 0);
            int k3 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                j.setViewVisibility(k3, 8);
            } else {
                j.setViewVisibility(k3, 0);
            }
            if (a3.b("enable_notification_ui") >= 2) {
                j.setViewVisibility(k3, 8);
            }
            str2 = string3;
        } else if (a == 2) {
            String str4 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            String string4 = this.b.getResources().getString(i.b("tt_appdownloader_notification_pausing"));
            string = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
            if (a3.b("notification_opt_2") == 1) {
                if (i3 >= a3.a("noti_progress_show_th", 70)) {
                    j.setViewVisibility(a(a2), 0);
                    j.setViewVisibility(e.j(), 0);
                    j.setViewVisibility(e.i(), 8);
                } else {
                    j.setViewVisibility(a(a2), 8);
                    j.setViewVisibility(e.j(), 8);
                    j.setViewVisibility(e.i(), 0);
                    j.setViewVisibility(e.o(), 8);
                    string4 = this.c.getString(i.b("tt_appdownloader_notification_download_continue"));
                }
            } else {
                j.setViewVisibility(e.j(), 0);
                int a7 = a(a2);
                if (a3.b("enable_notification_ui") >= 2) {
                    j.setViewVisibility(a7, 0);
                } else {
                    j.setViewVisibility(a7, 8);
                }
                j.setViewVisibility(e.i(), 8);
            }
            int k4 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f)) {
                j.setViewVisibility(k4, 8);
            } else {
                j.setViewVisibility(k4, 0);
                if (a3.b("enable_notification_ui") >= 2) {
                    str4 = com.ss.android.socialbase.appdownloader.c.a(b(), false) + "/" + com.ss.android.socialbase.appdownloader.c.a(c(), false);
                }
            }
            str2 = string4;
            str = str4;
        } else if (a == 3) {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(a2);
            if (e() != -1 && e() != -4) {
                if (e() == -3) {
                    String a8 = com.ss.android.socialbase.appdownloader.c.a(c());
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                        if (com.ss.android.socialbase.appdownloader.c.a(this.b, downloadInfo, !a3.b("fix_ui_thread_parser_apk_file", true))) {
                            b3 = i.b("tt_appdownloader_notification_install_finished_open");
                            i2 = i.b("tt_appdownloader_notification_download_open");
                        } else {
                            b3 = i.b("tt_appdownloader_notification_download_complete_with_install");
                            i2 = i.b("tt_appdownloader_notification_download_install");
                        }
                    } else {
                        b3 = i.b("tt_appdownloader_notification_download_complete_without_install");
                        if (com.ss.android.socialbase.downloader.downloader.d.a().m(a2) != null) {
                            b3 = i.b("tt_appdownloader_notification_download_complete_open");
                        }
                        i2 = 0;
                    }
                    String string5 = this.c.getString(b3);
                    k.setContentText(string5);
                    str = i2 != 0 ? this.c.getString(i2) : "";
                    if (a3.b("notification_opt_2") == 1) {
                        j.setTextViewText(e.k(), str);
                        j.setViewVisibility(e.o(), 8);
                    } else {
                        j.setViewVisibility(e.k(), 8);
                    }
                    i = 0;
                    string2 = str;
                    str = a8;
                    str2 = string5;
                    j.setViewVisibility(a(a2), 8);
                    j.setViewVisibility(e.i(), i);
                    j.setViewVisibility(e.j(), 8);
                    if (a3.b("enable_notification_ui") >= 2) {
                    }
                    string = string2;
                } else {
                    str2 = "";
                    string2 = str2;
                    i = 0;
                    j.setViewVisibility(a(a2), 8);
                    j.setViewVisibility(e.i(), i);
                    j.setViewVisibility(e.j(), 8);
                    if (a3.b("enable_notification_ui") >= 2) {
                    }
                    string = string2;
                }
            } else {
                if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                    str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                }
                j.setViewVisibility(e.o(), 8);
                if (baseException != null && baseException.getErrorCode() == 1006) {
                    str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_space_failed"));
                } else if (a(baseException, a3, downloadInfo)) {
                    if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                        b2 = i.b("tt_appdownloader_notification_download_waiting_wifi");
                    } else {
                        b2 = i.b("tt_appdownloader_notification_download_waiting_net");
                    }
                    str2 = this.b.getResources().getString(b2);
                } else {
                    str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_failed"));
                }
                string2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_restart"));
                j.setViewVisibility(e.k(), 8);
                if (a3.b("enable_notification_ui") >= 2 && e() == -1) {
                    if (f.i(baseException)) {
                        if (f.b(baseException, downloadInfo)) {
                            str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_no_wifi_and_in_net"));
                            string2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                        } else {
                            str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_no_internet_error"));
                        }
                    } else if (f.h(baseException)) {
                        i = 0;
                        str2 = this.b.getResources().getString(i.b("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.c.b(c() - b()));
                        j.setViewVisibility(a(a2), 8);
                        j.setViewVisibility(e.i(), i);
                        j.setViewVisibility(e.j(), 8);
                        if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                            j.setViewVisibility(a(a2), 0);
                            j.setViewVisibility(e.i(), 8);
                            j.setViewVisibility(e.j(), 0);
                            int k5 = e.k();
                            if (!f.b(baseException, downloadInfo)) {
                                j.setViewVisibility(k5, 0);
                                str = com.ss.android.socialbase.appdownloader.c.a(b(), false) + "/" + com.ss.android.socialbase.appdownloader.c.a(c(), false);
                            } else {
                                j.setViewVisibility(k5, 8);
                            }
                        }
                        string = string2;
                    }
                }
                i = 0;
                j.setViewVisibility(a(a2), 8);
                j.setViewVisibility(e.i(), i);
                j.setViewVisibility(e.j(), 8);
                if (a3.b("enable_notification_ui") >= 2) {
                    j.setViewVisibility(a(a2), 0);
                    j.setViewVisibility(e.i(), 8);
                    j.setViewVisibility(e.j(), 0);
                    int k52 = e.k();
                    if (!f.b(baseException, downloadInfo)) {
                    }
                }
                string = string2;
            }
        } else {
            string = "";
            str2 = string;
        }
        j.setTextViewText(e.n(), str);
        j.setTextViewText(e.p(), str2);
        j.setTextViewText(e.o(), str);
        j.setTextViewText(e.q(), str2);
        int k6 = e.k();
        if (TextUtils.isEmpty(string)) {
            j.setViewVisibility(k6, 8);
        } else {
            j.setTextViewText(k6, string);
        }
        if (a3.b("notification_opt_2") == 1) {
            k.setAutoCancel(true);
            z2 = false;
            if (a3.a("notification_ongoing", 0) == 1) {
                k.setOngoing(true);
                z3 = true;
                Notification build = k.build();
                if (!z3) {
                    build.flags |= 2;
                    a(true);
                } else {
                    a(z2);
                }
                build.contentView = j;
                return build;
            }
            k.setOngoing(false);
        } else {
            z2 = false;
        }
        z3 = false;
        Notification build2 = k.build();
        if (!z3) {
        }
        build2.contentView = j;
        return build2;
    }

    private RemoteViews j() {
        RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.b.getResources().getColor(e.r()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:15:0x004b). Please submit an issue!!! */
    private NotificationCompat.Builder k() {
        NotificationCompat.Builder builder;
        String i = com.ss.android.socialbase.appdownloader.d.j().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.b);
        }
        if (TextUtils.isEmpty(i)) {
            i = com.ss.android.socialbase.appdownloader.c.b(this.b);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.d.j().k() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.j().k().a(this.b, i);
            } else {
                builder = new NotificationCompat.Builder(this.b, i);
            }
        } catch (NoSuchMethodError unused) {
            builder = new NotificationCompat.Builder(this.b);
        }
        return builder;
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        super.a(downloadInfo);
        this.e = downloadInfo.getSavePath();
        this.d = downloadInfo.getName();
        this.f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        if (this.b == null) {
            return;
        }
        try {
            Notification b = b(baseException, z);
            this.a = b;
            a(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && aVar.a("notification_text_opt", 0) == 1;
    }

    private int a(int i, int i2) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("notification_opt_2") == 1) {
            return e.v();
        }
        if (i == 1 || i == 4) {
            return e.t();
        }
        if (i == 2) {
            return e.u();
        }
        if (i == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i, int i2) {
        Intent intent = new Intent(this.b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.b, i2, intent, 201326592);
    }

    private int a(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).b("enable_notification_ui") >= 1) {
            return e.h();
        }
        return e.g();
    }
}
