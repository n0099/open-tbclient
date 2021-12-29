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
/* loaded from: classes3.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {

    /* renamed from: b  reason: collision with root package name */
    public final Context f62093b;

    /* renamed from: c  reason: collision with root package name */
    public final Resources f62094c;

    /* renamed from: d  reason: collision with root package name */
    public String f62095d;

    /* renamed from: e  reason: collision with root package name */
    public String f62096e;

    /* renamed from: f  reason: collision with root package name */
    public String f62097f;

    public a(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        this.f62096e = str2;
        this.f62095d = str3;
        this.f62097f = str4;
        Context applicationContext = context.getApplicationContext();
        this.f62093b = applicationContext;
        this.f62094c = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification b(BaseException baseException, boolean z) {
        boolean z2;
        String d2;
        RemoteViews j2;
        boolean z3;
        String str;
        int b2;
        String str2;
        String str3;
        boolean z4;
        int b3;
        String str4;
        int i2;
        int b4;
        int i3;
        int e2 = e();
        int a = com.ss.android.socialbase.appdownloader.c.a(e2);
        if (a == 0) {
            return null;
        }
        NotificationCompat.Builder k2 = k();
        k2.setWhen(f());
        int a2 = a();
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(a2);
        if (Build.VERSION.SDK_INT >= 24 && a3.a("set_notification_group", 0) == 1) {
            k2.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            k2.setGroupSummary(false);
        }
        int a4 = a(a, a2);
        if (a4 != 0) {
            k2.setSmallIcon(a4);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (a == 1 || a == 4 || a == 2) {
            k2.setContentIntent(a("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", a, a2));
            k2.setOngoing(a == 1 || a == 4);
            k2.setAutoCancel(false);
        } else if (a == 3) {
            k2.setOngoing(false);
            k2.setAutoCancel(true);
            if (e2 != -1 && e2 != -4) {
                if (e2 == -3 && a3.a("notification_click_install_auto_cancel", 1) == 0) {
                    k2.setAutoCancel(false);
                    if (h() > 0) {
                        k2.setOngoing(false);
                        str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                        z2 = false;
                        k2.setContentIntent(a(str5, a, a2));
                        k2.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a, a2));
                        long b5 = b();
                        long c2 = c();
                        int i4 = c2 > 0 ? (int) ((b5 * 100) / c2) : 0;
                        d2 = d();
                        if (TextUtils.isEmpty(d2)) {
                            d2 = this.f62094c.getString(i.b("tt_appdownloader_download_unknown_title"));
                        }
                        j2 = j();
                        int k3 = e.k();
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
                            j2.setOnClickPendingIntent(k3, a("android.ss.intent.action.DOWNLOAD_CLICK_BTN", a, a2));
                        }
                        z3 = z2;
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
                            j2.setInt(k3, "setBackgroundResource", e.s());
                            j2.setTextColor(k3, -1);
                        }
                        j2.setTextViewText(e.m(), d2);
                        int a5 = a(a2);
                        j2.setViewVisibility(a5, 0);
                        j2.setProgressBar(a5, 100, i4, z);
                        int l = e.l();
                        if (a4 != 0) {
                            j2.setImageViewResource(l, a4);
                        }
                        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
                            Bitmap a6 = c.a().a(a2);
                            if (a6 != null) {
                                j2.setInt(l, "setBackgroundColor", 0);
                                j2.setImageViewBitmap(l, a6);
                            } else {
                                j2.setInt(l, "setBackgroundResource", e.s());
                            }
                        }
                        str = "";
                        if (a != 1 || a == 4) {
                            str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                            if (a == 1) {
                                if (e() == 11) {
                                    b2 = i.b("tt_appdownloader_notification_waiting_download_complete_handler");
                                } else {
                                    b2 = i.b("tt_appdownloader_notification_downloading");
                                }
                            } else {
                                b2 = i.b("tt_appdownloader_notification_prepare");
                            }
                            String string = this.f62093b.getResources().getString(b2);
                            String string2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
                            j2.setViewVisibility(a(a2), 0);
                            j2.setViewVisibility(e.i(), 8);
                            j2.setViewVisibility(e.j(), 0);
                            int k4 = e.k();
                            if (com.ss.android.socialbase.appdownloader.c.a(this.f62097f)) {
                                j2.setViewVisibility(k4, 8);
                            } else {
                                j2.setViewVisibility(k4, 0);
                            }
                            if (a3.b("enable_notification_ui") >= 2) {
                                j2.setViewVisibility(k4, 8);
                            }
                            str2 = string;
                            str3 = string2;
                        } else if (a == 2) {
                            String str6 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                            String string3 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_pausing"));
                            String string4 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                            if (a3.b("notification_opt_2") == 1) {
                                if (i4 >= a3.a("noti_progress_show_th", 70)) {
                                    j2.setViewVisibility(a(a2), 0);
                                    j2.setViewVisibility(e.j(), 0);
                                    j2.setViewVisibility(e.i(), 8);
                                } else {
                                    j2.setViewVisibility(a(a2), 8);
                                    j2.setViewVisibility(e.j(), 8);
                                    j2.setViewVisibility(e.i(), 0);
                                    j2.setViewVisibility(e.o(), 8);
                                    string3 = this.f62094c.getString(i.b("tt_appdownloader_notification_download_continue"));
                                }
                            } else {
                                j2.setViewVisibility(e.j(), 0);
                                int a7 = a(a2);
                                if (a3.b("enable_notification_ui") >= 2) {
                                    j2.setViewVisibility(a7, 0);
                                } else {
                                    j2.setViewVisibility(a7, 8);
                                }
                                j2.setViewVisibility(e.i(), 8);
                            }
                            int k5 = e.k();
                            if (com.ss.android.socialbase.appdownloader.c.a(this.f62097f)) {
                                j2.setViewVisibility(k5, 8);
                            } else {
                                j2.setViewVisibility(k5, 0);
                                if (a3.b("enable_notification_ui") >= 2) {
                                    str6 = com.ss.android.socialbase.appdownloader.c.a(b(), false) + "/" + com.ss.android.socialbase.appdownloader.c.a(c(), false);
                                }
                            }
                            str2 = string3;
                            str3 = string4;
                            str = str6;
                        } else if (a == 3) {
                            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(a2);
                            if (e() != -1 && e() != -4) {
                                if (e() == -3) {
                                    String a8 = com.ss.android.socialbase.appdownloader.c.a(c());
                                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                                        if (com.ss.android.socialbase.appdownloader.c.a(this.f62093b, downloadInfo, !a3.b("fix_ui_thread_parser_apk_file", true))) {
                                            b4 = i.b("tt_appdownloader_notification_install_finished_open");
                                            i3 = i.b("tt_appdownloader_notification_download_open");
                                        } else {
                                            b4 = i.b("tt_appdownloader_notification_download_complete_with_install");
                                            i3 = i.b("tt_appdownloader_notification_download_install");
                                        }
                                    } else {
                                        b4 = i.b("tt_appdownloader_notification_download_complete_without_install");
                                        if (com.ss.android.socialbase.downloader.downloader.d.a().m(a2) != null) {
                                            b4 = i.b("tt_appdownloader_notification_download_complete_open");
                                        }
                                        i3 = 0;
                                    }
                                    str2 = this.f62094c.getString(b4);
                                    k2.setContentText(str2);
                                    str = i3 != 0 ? this.f62094c.getString(i3) : "";
                                    if (a3.b("notification_opt_2") == 1) {
                                        j2.setTextViewText(e.k(), str);
                                        j2.setViewVisibility(e.o(), 8);
                                    } else {
                                        j2.setViewVisibility(e.k(), 8);
                                    }
                                    str3 = str;
                                    str4 = a8;
                                } else {
                                    str2 = "";
                                    str3 = str2;
                                    str4 = str3;
                                }
                            } else {
                                if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                                    str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                                }
                                j2.setViewVisibility(e.o(), 8);
                                if (baseException != null && baseException.getErrorCode() == 1006) {
                                    str2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_space_failed"));
                                } else if (a(baseException, a3, downloadInfo)) {
                                    if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                                        b3 = i.b("tt_appdownloader_notification_download_waiting_wifi");
                                    } else {
                                        b3 = i.b("tt_appdownloader_notification_download_waiting_net");
                                    }
                                    str2 = this.f62093b.getResources().getString(b3);
                                } else {
                                    str2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_failed"));
                                }
                                str3 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_restart"));
                                j2.setViewVisibility(e.k(), 8);
                                if (a3.b("enable_notification_ui") >= 2 && e() == -1) {
                                    if (f.i(baseException)) {
                                        if (f.b(baseException, downloadInfo)) {
                                            str2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_no_wifi_and_in_net"));
                                            str3 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                                        } else {
                                            str2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_no_internet_error"));
                                        }
                                    } else if (f.h(baseException)) {
                                        str4 = str;
                                        i2 = 0;
                                        str2 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.c.b(c() - b()));
                                        j2.setViewVisibility(a(a2), 8);
                                        j2.setViewVisibility(e.i(), i2);
                                        j2.setViewVisibility(e.j(), 8);
                                        if (a3.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                                            j2.setViewVisibility(a(a2), 0);
                                            j2.setViewVisibility(e.i(), 8);
                                            j2.setViewVisibility(e.j(), 0);
                                            int k6 = e.k();
                                            if (!f.b(baseException, downloadInfo)) {
                                                j2.setViewVisibility(k6, 0);
                                                str = com.ss.android.socialbase.appdownloader.c.a(b(), false) + "/" + com.ss.android.socialbase.appdownloader.c.a(c(), false);
                                            } else {
                                                j2.setViewVisibility(k6, 8);
                                            }
                                        }
                                        str = str4;
                                    }
                                }
                                str4 = str;
                            }
                            i2 = 0;
                            j2.setViewVisibility(a(a2), 8);
                            j2.setViewVisibility(e.i(), i2);
                            j2.setViewVisibility(e.j(), 8);
                            if (a3.b("enable_notification_ui") >= 2) {
                                j2.setViewVisibility(a(a2), 0);
                                j2.setViewVisibility(e.i(), 8);
                                j2.setViewVisibility(e.j(), 0);
                                int k62 = e.k();
                                if (!f.b(baseException, downloadInfo)) {
                                }
                            }
                            str = str4;
                        } else {
                            str2 = "";
                            str3 = str2;
                        }
                        j2.setTextViewText(e.n(), str);
                        j2.setTextViewText(e.p(), str2);
                        j2.setTextViewText(e.o(), str);
                        j2.setTextViewText(e.q(), str2);
                        int k7 = e.k();
                        if (TextUtils.isEmpty(str3)) {
                            j2.setViewVisibility(k7, 8);
                        } else {
                            j2.setTextViewText(k7, str3);
                        }
                        if (a3.b("notification_opt_2") == 1) {
                            k2.setAutoCancel(true);
                            z4 = false;
                            if (a3.a("notification_ongoing", 0) == 1) {
                                k2.setOngoing(true);
                                z3 = true;
                            } else {
                                k2.setOngoing(false);
                                z3 = false;
                            }
                        } else {
                            z4 = false;
                        }
                        Notification build = k2.build();
                        if (z3) {
                            build.flags |= 2;
                            a(true);
                        } else {
                            a(z4);
                        }
                        build.contentView = j2;
                        return build;
                    }
                    k2.setOngoing(true);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            z2 = true;
            k2.setContentIntent(a(str5, a, a2));
            k2.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a, a2));
            long b52 = b();
            long c22 = c();
            if (c22 > 0) {
            }
            d2 = d();
            if (TextUtils.isEmpty(d2)) {
            }
            j2 = j();
            int k32 = e.k();
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
            }
            z3 = z2;
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            }
            j2.setTextViewText(e.m(), d2);
            int a52 = a(a2);
            j2.setViewVisibility(a52, 0);
            j2.setProgressBar(a52, 100, i4, z);
            int l2 = e.l();
            if (a4 != 0) {
            }
            if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
            }
            str = "";
            if (a != 1) {
            }
            str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            if (a == 1) {
            }
            String string5 = this.f62093b.getResources().getString(b2);
            String string22 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
            j2.setViewVisibility(a(a2), 0);
            j2.setViewVisibility(e.i(), 8);
            j2.setViewVisibility(e.j(), 0);
            int k42 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f62097f)) {
            }
            if (a3.b("enable_notification_ui") >= 2) {
            }
            str2 = string5;
            str3 = string22;
            j2.setTextViewText(e.n(), str);
            j2.setTextViewText(e.p(), str2);
            j2.setTextViewText(e.o(), str);
            j2.setTextViewText(e.q(), str2);
            int k72 = e.k();
            if (TextUtils.isEmpty(str3)) {
            }
            if (a3.b("notification_opt_2") == 1) {
            }
            Notification build2 = k2.build();
            if (z3) {
            }
            build2.contentView = j2;
            return build2;
        }
        z2 = true;
        long b522 = b();
        long c222 = c();
        if (c222 > 0) {
        }
        d2 = d();
        if (TextUtils.isEmpty(d2)) {
        }
        j2 = j();
        int k322 = e.k();
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("notification_opt_2") != 1) {
        }
        z3 = z2;
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
        }
        j2.setTextViewText(e.m(), d2);
        int a522 = a(a2);
        j2.setViewVisibility(a522, 0);
        j2.setProgressBar(a522, 100, i4, z);
        int l22 = e.l();
        if (a4 != 0) {
        }
        if (com.ss.android.socialbase.downloader.g.a.a(a2).b("enable_notification_ui") >= 1) {
        }
        str = "";
        if (a != 1) {
        }
        str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
        if (a == 1) {
        }
        String string52 = this.f62093b.getResources().getString(b2);
        String string222 = this.f62093b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
        j2.setViewVisibility(a(a2), 0);
        j2.setViewVisibility(e.i(), 8);
        j2.setViewVisibility(e.j(), 0);
        int k422 = e.k();
        if (com.ss.android.socialbase.appdownloader.c.a(this.f62097f)) {
        }
        if (a3.b("enable_notification_ui") >= 2) {
        }
        str2 = string52;
        str3 = string222;
        j2.setTextViewText(e.n(), str);
        j2.setTextViewText(e.p(), str2);
        j2.setTextViewText(e.o(), str);
        j2.setTextViewText(e.q(), str2);
        int k722 = e.k();
        if (TextUtils.isEmpty(str3)) {
        }
        if (a3.b("notification_opt_2") == 1) {
        }
        Notification build22 = k2.build();
        if (z3) {
        }
        build22.contentView = j2;
        return build22;
    }

    private RemoteViews j() {
        RemoteViews remoteViews = new RemoteViews(this.f62093b.getPackageName(), e.a());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.c.a(this.f62093b)) {
                    remoteViews.setInt(e.f(), "setBackgroundColor", this.f62093b.getResources().getColor(e.r()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0044 -> B:15:0x004b). Please submit an issue!!! */
    private NotificationCompat.Builder k() {
        NotificationCompat.Builder builder;
        String i2 = com.ss.android.socialbase.appdownloader.d.j().i();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f62093b);
        }
        if (TextUtils.isEmpty(i2)) {
            i2 = com.ss.android.socialbase.appdownloader.c.b(this.f62093b);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.d.j().k() != null) {
                builder = com.ss.android.socialbase.appdownloader.d.j().k().a(this.f62093b, i2);
            } else {
                builder = new NotificationCompat.Builder(this.f62093b, i2);
            }
        } catch (NoSuchMethodError unused) {
            builder = new NotificationCompat.Builder(this.f62093b);
        }
        return builder;
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        super.a(downloadInfo);
        this.f62096e = downloadInfo.getSavePath();
        this.f62095d = downloadInfo.getName();
        this.f62097f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        if (this.f62093b == null) {
            return;
        }
        try {
            Notification b2 = b(baseException, z);
            this.a = b2;
            a(b2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && aVar.a("notification_text_opt", 0) == 1;
    }

    private int a(int i2, int i3) {
        if (com.ss.android.socialbase.downloader.g.a.a(i3).b("notification_opt_2") == 1) {
            return e.v();
        }
        if (i2 == 1 || i2 == 4) {
            return e.t();
        }
        if (i2 == 2) {
            return e.u();
        }
        if (i2 == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i2, int i3) {
        Intent intent = new Intent(this.f62093b, DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i3);
        intent.putExtra("extra_click_download_type", i2);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f62093b, i3, intent, 134217728);
    }

    private int a(int i2) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("enable_notification_ui") >= 1) {
            return e.h();
        }
        return e.g();
    }
}
