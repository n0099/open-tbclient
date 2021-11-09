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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f68961b;

    /* renamed from: c  reason: collision with root package name */
    public final Resources f68962c;

    /* renamed from: d  reason: collision with root package name */
    public String f68963d;

    /* renamed from: e  reason: collision with root package name */
    public String f68964e;

    /* renamed from: f  reason: collision with root package name */
    public String f68965f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68964e = str2;
        this.f68963d = str3;
        this.f68965f = str4;
        Context applicationContext = context.getApplicationContext();
        this.f68961b = applicationContext;
        this.f68962c = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification b(BaseException baseException, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        String d2;
        RemoteViews j;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, baseException, z)) == null) {
            int e2 = e();
            int a2 = com.ss.android.socialbase.appdownloader.c.a(e2);
            if (a2 == 0) {
                return null;
            }
            NotificationCompat.Builder k = k();
            k.setWhen(f());
            int a3 = a();
            com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(a3);
            if (Build.VERSION.SDK_INT >= 24 && a4.a("set_notification_group", 0) == 1) {
                k.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
                k.setGroupSummary(false);
            }
            int a5 = a(a2, a3);
            if (a5 != 0) {
                k.setSmallIcon(a5);
            }
            String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
            if (a2 == 1 || a2 == 4 || a2 == 2) {
                k.setContentIntent(a("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", a2, a3));
                k.setOngoing(a2 == 1 || a2 == 4);
                k.setAutoCancel(false);
            } else if (a2 == 3) {
                k.setOngoing(false);
                k.setAutoCancel(true);
                if (e2 != -1 && e2 != -4) {
                    if (e2 == -3 && a4.a("notification_click_install_auto_cancel", 1) == 0) {
                        k.setAutoCancel(false);
                        if (h() > 0) {
                            k.setOngoing(false);
                            str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                            z2 = false;
                            k.setContentIntent(a(str5, a2, a3));
                            k.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
                            long b5 = b();
                            long c2 = c();
                            int i4 = c2 > 0 ? (int) ((b5 * 100) / c2) : 0;
                            d2 = d();
                            if (TextUtils.isEmpty(d2)) {
                                d2 = this.f68962c.getString(i.b("tt_appdownloader_download_unknown_title"));
                            }
                            j = j();
                            int k2 = e.k();
                            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("notification_opt_2") != 1) {
                                j.setOnClickPendingIntent(k2, a("android.ss.intent.action.DOWNLOAD_CLICK_BTN", a2, a3));
                            }
                            z3 = z2;
                            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
                                j.setInt(k2, "setBackgroundResource", e.s());
                                j.setTextColor(k2, -1);
                            }
                            j.setTextViewText(e.m(), d2);
                            int a6 = a(a3);
                            j.setViewVisibility(a6, 0);
                            j.setProgressBar(a6, 100, i4, z);
                            int l = e.l();
                            if (a5 != 0) {
                                j.setImageViewResource(l, a5);
                            }
                            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
                                Bitmap a7 = c.a().a(a3);
                                if (a7 != null) {
                                    j.setInt(l, "setBackgroundColor", 0);
                                    j.setImageViewBitmap(l, a7);
                                } else {
                                    j.setInt(l, "setBackgroundResource", e.s());
                                }
                            }
                            str = "";
                            if (a2 != 1 || a2 == 4) {
                                str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                                if (a2 == 1) {
                                    if (e() == 11) {
                                        b2 = i.b("tt_appdownloader_notification_waiting_download_complete_handler");
                                    } else {
                                        b2 = i.b("tt_appdownloader_notification_downloading");
                                    }
                                } else {
                                    b2 = i.b("tt_appdownloader_notification_prepare");
                                }
                                String string = this.f68961b.getResources().getString(b2);
                                String string2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
                                j.setViewVisibility(a(a3), 0);
                                j.setViewVisibility(e.i(), 8);
                                j.setViewVisibility(e.j(), 0);
                                int k3 = e.k();
                                if (com.ss.android.socialbase.appdownloader.c.a(this.f68965f)) {
                                    j.setViewVisibility(k3, 8);
                                } else {
                                    j.setViewVisibility(k3, 0);
                                }
                                if (a4.b("enable_notification_ui") >= 2) {
                                    j.setViewVisibility(k3, 8);
                                }
                                str2 = string;
                                str3 = string2;
                            } else if (a2 == 2) {
                                String str6 = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                                String string3 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_pausing"));
                                String string4 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                                if (a4.b("notification_opt_2") == 1) {
                                    if (i4 >= a4.a("noti_progress_show_th", 70)) {
                                        j.setViewVisibility(a(a3), 0);
                                        j.setViewVisibility(e.j(), 0);
                                        j.setViewVisibility(e.i(), 8);
                                    } else {
                                        j.setViewVisibility(a(a3), 8);
                                        j.setViewVisibility(e.j(), 8);
                                        j.setViewVisibility(e.i(), 0);
                                        j.setViewVisibility(e.o(), 8);
                                        string3 = this.f68962c.getString(i.b("tt_appdownloader_notification_download_continue"));
                                    }
                                } else {
                                    j.setViewVisibility(e.j(), 0);
                                    int a8 = a(a3);
                                    if (a4.b("enable_notification_ui") >= 2) {
                                        j.setViewVisibility(a8, 0);
                                    } else {
                                        j.setViewVisibility(a8, 8);
                                    }
                                    j.setViewVisibility(e.i(), 8);
                                }
                                int k4 = e.k();
                                if (com.ss.android.socialbase.appdownloader.c.a(this.f68965f)) {
                                    j.setViewVisibility(k4, 8);
                                } else {
                                    j.setViewVisibility(k4, 0);
                                    if (a4.b("enable_notification_ui") >= 2) {
                                        str6 = com.ss.android.socialbase.appdownloader.c.a(b(), false) + "/" + com.ss.android.socialbase.appdownloader.c.a(c(), false);
                                    }
                                }
                                str2 = string3;
                                str3 = string4;
                                str = str6;
                            } else if (a2 == 3) {
                                DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(a3);
                                if (e() != -1 && e() != -4) {
                                    if (e() == -3) {
                                        String a9 = com.ss.android.socialbase.appdownloader.c.a(c());
                                        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                                            if (com.ss.android.socialbase.appdownloader.c.a(this.f68961b, downloadInfo, !a4.b("fix_ui_thread_parser_apk_file", true))) {
                                                b4 = i.b("tt_appdownloader_notification_install_finished_open");
                                                i3 = i.b("tt_appdownloader_notification_download_open");
                                            } else {
                                                b4 = i.b("tt_appdownloader_notification_download_complete_with_install");
                                                i3 = i.b("tt_appdownloader_notification_download_install");
                                            }
                                        } else {
                                            b4 = i.b("tt_appdownloader_notification_download_complete_without_install");
                                            if (com.ss.android.socialbase.downloader.downloader.d.a().m(a3) != null) {
                                                b4 = i.b("tt_appdownloader_notification_download_complete_open");
                                            }
                                            i3 = 0;
                                        }
                                        str2 = this.f68962c.getString(b4);
                                        k.setContentText(str2);
                                        str = i3 != 0 ? this.f68962c.getString(i3) : "";
                                        if (a4.b("notification_opt_2") == 1) {
                                            j.setTextViewText(e.k(), str);
                                            j.setViewVisibility(e.o(), 8);
                                        } else {
                                            j.setViewVisibility(e.k(), 8);
                                        }
                                        str3 = str;
                                        str4 = a9;
                                    } else {
                                        str2 = "";
                                        str3 = str2;
                                        str4 = str3;
                                    }
                                } else {
                                    if (a4.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                                        str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                                    }
                                    j.setViewVisibility(e.o(), 8);
                                    if (baseException != null && baseException.getErrorCode() == 1006) {
                                        str2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_space_failed"));
                                    } else if (a(baseException, a4, downloadInfo)) {
                                        if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                                            b3 = i.b("tt_appdownloader_notification_download_waiting_wifi");
                                        } else {
                                            b3 = i.b("tt_appdownloader_notification_download_waiting_net");
                                        }
                                        str2 = this.f68961b.getResources().getString(b3);
                                    } else {
                                        str2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_failed"));
                                    }
                                    str3 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_restart"));
                                    j.setViewVisibility(e.k(), 8);
                                    if (a4.b("enable_notification_ui") >= 2 && e() == -1) {
                                        if (f.i(baseException)) {
                                            if (f.b(baseException, downloadInfo)) {
                                                str2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_no_wifi_and_in_net"));
                                                str3 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_resume"));
                                            } else {
                                                str2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_no_internet_error"));
                                            }
                                        } else if (f.h(baseException)) {
                                            str4 = str;
                                            i2 = 0;
                                            str2 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.c.b(c() - b()));
                                            j.setViewVisibility(a(a3), 8);
                                            j.setViewVisibility(e.i(), i2);
                                            j.setViewVisibility(e.j(), 8);
                                            if (a4.b("enable_notification_ui") >= 2 && e() == -1 && (f.i(baseException) || f.h(baseException))) {
                                                j.setViewVisibility(a(a3), 0);
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
                                            str = str4;
                                        }
                                    }
                                    str4 = str;
                                }
                                i2 = 0;
                                j.setViewVisibility(a(a3), 8);
                                j.setViewVisibility(e.i(), i2);
                                j.setViewVisibility(e.j(), 8);
                                if (a4.b("enable_notification_ui") >= 2) {
                                    j.setViewVisibility(a(a3), 0);
                                    j.setViewVisibility(e.i(), 8);
                                    j.setViewVisibility(e.j(), 0);
                                    int k52 = e.k();
                                    if (!f.b(baseException, downloadInfo)) {
                                    }
                                }
                                str = str4;
                            } else {
                                str2 = "";
                                str3 = str2;
                            }
                            j.setTextViewText(e.n(), str);
                            j.setTextViewText(e.p(), str2);
                            j.setTextViewText(e.o(), str);
                            j.setTextViewText(e.q(), str2);
                            int k6 = e.k();
                            if (TextUtils.isEmpty(str3)) {
                                j.setViewVisibility(k6, 8);
                            } else {
                                j.setTextViewText(k6, str3);
                            }
                            if (a4.b("notification_opt_2") == 1) {
                                k.setAutoCancel(true);
                                z4 = false;
                                if (a4.a("notification_ongoing", 0) == 1) {
                                    k.setOngoing(true);
                                    z3 = true;
                                } else {
                                    k.setOngoing(false);
                                    z3 = false;
                                }
                            } else {
                                z4 = false;
                            }
                            Notification build = k.build();
                            if (z3) {
                                build.flags |= 2;
                                a(true);
                            } else {
                                a(z4);
                            }
                            build.contentView = j;
                            return build;
                        }
                        k.setOngoing(true);
                    }
                    str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                }
                z2 = true;
                k.setContentIntent(a(str5, a2, a3));
                k.setDeleteIntent(a("android.ss.intent.action.DOWNLOAD_HIDE", a2, a3));
                long b52 = b();
                long c22 = c();
                if (c22 > 0) {
                }
                d2 = d();
                if (TextUtils.isEmpty(d2)) {
                }
                j = j();
                int k22 = e.k();
                if (com.ss.android.socialbase.downloader.g.a.a(a3).b("notification_opt_2") != 1) {
                }
                z3 = z2;
                if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
                }
                j.setTextViewText(e.m(), d2);
                int a62 = a(a3);
                j.setViewVisibility(a62, 0);
                j.setProgressBar(a62, 100, i4, z);
                int l2 = e.l();
                if (a5 != 0) {
                }
                if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
                }
                str = "";
                if (a2 != 1) {
                }
                str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
                if (a2 == 1) {
                }
                String string5 = this.f68961b.getResources().getString(b2);
                String string22 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
                j.setViewVisibility(a(a3), 0);
                j.setViewVisibility(e.i(), 8);
                j.setViewVisibility(e.j(), 0);
                int k32 = e.k();
                if (com.ss.android.socialbase.appdownloader.c.a(this.f68965f)) {
                }
                if (a4.b("enable_notification_ui") >= 2) {
                }
                str2 = string5;
                str3 = string22;
                j.setTextViewText(e.n(), str);
                j.setTextViewText(e.p(), str2);
                j.setTextViewText(e.o(), str);
                j.setTextViewText(e.q(), str2);
                int k62 = e.k();
                if (TextUtils.isEmpty(str3)) {
                }
                if (a4.b("notification_opt_2") == 1) {
                }
                Notification build2 = k.build();
                if (z3) {
                }
                build2.contentView = j;
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
            j = j();
            int k222 = e.k();
            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("notification_opt_2") != 1) {
            }
            z3 = z2;
            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
            }
            j.setTextViewText(e.m(), d2);
            int a622 = a(a3);
            j.setViewVisibility(a622, 0);
            j.setProgressBar(a622, 100, i4, z);
            int l22 = e.l();
            if (a5 != 0) {
            }
            if (com.ss.android.socialbase.downloader.g.a.a(a3).b("enable_notification_ui") >= 1) {
            }
            str = "";
            if (a2 != 1) {
            }
            str = com.ss.android.socialbase.appdownloader.c.a(b()) + "/" + com.ss.android.socialbase.appdownloader.c.a(c());
            if (a2 == 1) {
            }
            String string52 = this.f68961b.getResources().getString(b2);
            String string222 = this.f68961b.getResources().getString(i.b("tt_appdownloader_notification_download_pause"));
            j.setViewVisibility(a(a3), 0);
            j.setViewVisibility(e.i(), 8);
            j.setViewVisibility(e.j(), 0);
            int k322 = e.k();
            if (com.ss.android.socialbase.appdownloader.c.a(this.f68965f)) {
            }
            if (a4.b("enable_notification_ui") >= 2) {
            }
            str2 = string52;
            str3 = string222;
            j.setTextViewText(e.n(), str);
            j.setTextViewText(e.p(), str2);
            j.setTextViewText(e.o(), str);
            j.setTextViewText(e.q(), str2);
            int k622 = e.k();
            if (TextUtils.isEmpty(str3)) {
            }
            if (a4.b("notification_opt_2") == 1) {
            }
            Notification build22 = k.build();
            if (z3) {
            }
            build22.contentView = j;
            return build22;
        }
        return (Notification) invokeLZ.objValue;
    }

    private RemoteViews j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            RemoteViews remoteViews = new RemoteViews(this.f68961b.getPackageName(), e.a());
            if (Build.VERSION.SDK_INT > 20) {
                try {
                    if (com.ss.android.socialbase.appdownloader.c.a(this.f68961b)) {
                        remoteViews.setInt(e.f(), "setBackgroundColor", this.f68961b.getResources().getColor(e.r()));
                    }
                } catch (Throwable unused) {
                }
            }
            return remoteViews;
        }
        return (RemoteViews) invokeV.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0048 -> B:21:0x004f). Please submit an issue!!! */
    private NotificationCompat.Builder k() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String i2 = com.ss.android.socialbase.appdownloader.d.j().i();
            if (Build.VERSION.SDK_INT < 26) {
                return new NotificationCompat.Builder(this.f68961b);
            }
            if (TextUtils.isEmpty(i2)) {
                i2 = com.ss.android.socialbase.appdownloader.c.b(this.f68961b);
            }
            try {
                if (com.ss.android.socialbase.appdownloader.d.j().k() != null) {
                    builder = com.ss.android.socialbase.appdownloader.d.j().k().a(this.f68961b, i2);
                } else {
                    builder = new NotificationCompat.Builder(this.f68961b, i2);
                }
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(this.f68961b);
            }
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            super.a(downloadInfo);
            this.f68964e = downloadInfo.getSavePath();
            this.f68963d = downloadInfo.getName();
            this.f68965f = downloadInfo.getExtra();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, baseException, z) == null) || this.f68961b == null) {
            return;
        }
        try {
            Notification b2 = b(baseException, z);
            this.f69735a = b2;
            a(b2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, baseException, aVar, downloadInfo)) == null) ? baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && aVar.a("notification_text_opt", 0) == 1 : invokeLLL.booleanValue;
    }

    private int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
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
        return invokeII.intValue;
    }

    private PendingIntent a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, this, str, i2, i3)) == null) {
            Intent intent = new Intent(this.f68961b, DownloadHandlerService.class);
            intent.setAction(str);
            intent.putExtra("extra_click_download_ids", i3);
            intent.putExtra("extra_click_download_type", i2);
            intent.putExtra("extra_from_notification", true);
            return PendingIntent.getService(this.f68961b, i3, intent, 134217728);
        }
        return (PendingIntent) invokeLII.objValue;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.a(i2).b("enable_notification_ui") >= 1) {
                return e.h();
            }
            return e.g();
        }
        return invokeI.intValue;
    }
}
