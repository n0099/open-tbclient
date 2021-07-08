package d.l.a.e.a.f;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.a.d;
import d.l.a.e.a.g;
import d.l.a.e.a.l;
import d.l.a.e.b.g.e;
import d.l.a.e.b.g.f;
/* loaded from: classes8.dex */
public class a extends d.l.a.e.b.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context j;
    public final Resources k;
    public String l;

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
        this.l = str4;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.k = applicationContext.getResources();
    }

    @Override // d.l.a.e.b.p.a
    public void g(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, baseException, z) == null) || this.j == null) {
            return;
        }
        try {
            Notification w = w(baseException, z);
            this.f72086i = w;
            f(w);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.p.a
    public void h(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            super.h(downloadInfo);
            downloadInfo.getSavePath();
            downloadInfo.getName();
            this.l = downloadInfo.getExtra();
        }
    }

    public final int s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (d.l.a.e.b.j.a.d(i2).m("enable_notification_ui") >= 1) {
                return g.h();
            }
            return g.g();
        }
        return invokeI.intValue;
    }

    public final int t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (d.l.a.e.b.j.a.d(i3).m("notification_opt_2") == 1) {
                return g.v();
            }
            if (i2 == 1 || i2 == 4) {
                return g.t();
            }
            if (i2 == 2) {
                return g.u();
            }
            if (i2 == 3) {
                return g.v();
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public final PendingIntent u(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i2, i3)) == null) {
            Intent intent = new Intent(this.j, DownloadHandlerService.class);
            intent.setAction(str);
            intent.putExtra("extra_click_download_ids", i3);
            intent.putExtra("extra_click_download_type", i2);
            intent.putExtra("extra_from_notification", true);
            return PendingIntent.getService(this.j, i3, intent, 134217728);
        }
        return (PendingIntent) invokeLII.objValue;
    }

    public final boolean v(BaseException baseException, d.l.a.e.b.j.a aVar, DownloadInfo downloadInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, baseException, aVar, downloadInfo)) == null) ? baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && aVar.b("notification_text_opt", 0) == 1 : invokeLLL.booleanValue;
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
    public final Notification w(BaseException baseException, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        String m;
        RemoteViews x;
        boolean z3;
        String str;
        int d2;
        String str2;
        String str3;
        boolean z4;
        int d3;
        String str4;
        int i2;
        int d4;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, baseException, z)) == null) {
            int n = n();
            int b2 = d.b(n);
            if (b2 == 0) {
                return null;
            }
            NotificationCompat.Builder y = y();
            y.setWhen(o());
            int a2 = a();
            d.l.a.e.b.j.a d5 = d.l.a.e.b.j.a.d(a2);
            if (Build.VERSION.SDK_INT >= 24 && d5.b("set_notification_group", 0) == 1) {
                y.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
                y.setGroupSummary(false);
            }
            int t = t(b2, a2);
            if (t != 0) {
                y.setSmallIcon(t);
            }
            String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
            if (b2 == 1 || b2 == 4 || b2 == 2) {
                y.setContentIntent(u("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", b2, a2));
                y.setOngoing(b2 == 1 || b2 == 4);
                y.setAutoCancel(false);
            } else if (b2 == 3) {
                y.setOngoing(false);
                y.setAutoCancel(true);
                if (n != -1 && n != -4) {
                    if (n == -3 && d5.b("notification_click_install_auto_cancel", 1) == 0) {
                        y.setAutoCancel(false);
                        if (q() > 0) {
                            y.setOngoing(false);
                            str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                            z2 = false;
                            y.setContentIntent(u(str5, b2, a2));
                            y.setDeleteIntent(u("android.ss.intent.action.DOWNLOAD_HIDE", b2, a2));
                            long j = j();
                            long l = l();
                            int i4 = l > 0 ? (int) ((j * 100) / l) : 0;
                            m = m();
                            if (TextUtils.isEmpty(m)) {
                                m = this.k.getString(l.d("tt_appdownloader_download_unknown_title"));
                            }
                            x = x();
                            int k = g.k();
                            if (d.l.a.e.b.j.a.d(a2).m("notification_opt_2") != 1) {
                                x.setOnClickPendingIntent(k, u("android.ss.intent.action.DOWNLOAD_CLICK_BTN", b2, a2));
                            }
                            z3 = z2;
                            if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
                                x.setInt(k, "setBackgroundResource", g.s());
                                x.setTextColor(k, -1);
                            }
                            x.setTextViewText(g.m(), m);
                            int s = s(a2);
                            x.setViewVisibility(s, 0);
                            x.setProgressBar(s, 100, i4, z);
                            int l2 = g.l();
                            if (t != 0) {
                                x.setImageViewResource(l2, t);
                            }
                            if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
                                Bitmap b3 = com.ss.android.socialbase.appdownloader.e.c.d().b(a2);
                                if (b3 != null) {
                                    x.setInt(l2, "setBackgroundColor", 0);
                                    x.setImageViewBitmap(l2, b3);
                                } else {
                                    x.setInt(l2, "setBackgroundResource", g.s());
                                }
                            }
                            str = "";
                            if (b2 != 1 || b2 == 4) {
                                str = d.k(j()) + "/" + d.k(l());
                                if (b2 == 1) {
                                    if (n() == 11) {
                                        d2 = l.d("tt_appdownloader_notification_waiting_download_complete_handler");
                                    } else {
                                        d2 = l.d("tt_appdownloader_notification_downloading");
                                    }
                                } else {
                                    d2 = l.d("tt_appdownloader_notification_prepare");
                                }
                                String string = this.j.getResources().getString(d2);
                                String string2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_pause"));
                                x.setViewVisibility(s(a2), 0);
                                x.setViewVisibility(g.i(), 8);
                                x.setViewVisibility(g.j(), 0);
                                int k2 = g.k();
                                if (d.B(this.l)) {
                                    x.setViewVisibility(k2, 8);
                                } else {
                                    x.setViewVisibility(k2, 0);
                                }
                                if (d5.m("enable_notification_ui") >= 2) {
                                    x.setViewVisibility(k2, 8);
                                }
                                str2 = string;
                                str3 = string2;
                            } else if (b2 == 2) {
                                String str6 = d.k(j()) + "/" + d.k(l());
                                String string3 = this.j.getResources().getString(l.d("tt_appdownloader_notification_pausing"));
                                String string4 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_resume"));
                                if (d5.m("notification_opt_2") == 1) {
                                    if (i4 >= d5.b("noti_progress_show_th", 70)) {
                                        x.setViewVisibility(s(a2), 0);
                                        x.setViewVisibility(g.j(), 0);
                                        x.setViewVisibility(g.i(), 8);
                                    } else {
                                        x.setViewVisibility(s(a2), 8);
                                        x.setViewVisibility(g.j(), 8);
                                        x.setViewVisibility(g.i(), 0);
                                        x.setViewVisibility(g.o(), 8);
                                        string3 = this.k.getString(l.d("tt_appdownloader_notification_download_continue"));
                                    }
                                } else {
                                    x.setViewVisibility(g.j(), 0);
                                    int s2 = s(a2);
                                    if (d5.m("enable_notification_ui") >= 2) {
                                        x.setViewVisibility(s2, 0);
                                    } else {
                                        x.setViewVisibility(s2, 8);
                                    }
                                    x.setViewVisibility(g.i(), 8);
                                }
                                int k3 = g.k();
                                if (d.B(this.l)) {
                                    x.setViewVisibility(k3, 8);
                                } else {
                                    x.setViewVisibility(k3, 0);
                                    if (d5.m("enable_notification_ui") >= 2) {
                                        str6 = d.n(j(), false) + "/" + d.n(l(), false);
                                    }
                                }
                                str2 = string3;
                                str3 = string4;
                                str = str6;
                            } else if (b2 == 3) {
                                DownloadInfo f2 = d.l.a.e.b.g.a.H(e.n()).f(a2);
                                if (n() != -1 && n() != -4) {
                                    if (n() == -3) {
                                        String k4 = d.k(l());
                                        if (f2 != null && !TextUtils.isEmpty(f2.getMimeType()) && f2.getMimeType().equals("application/vnd.android.package-archive")) {
                                            if (d.z(this.j, f2, !d5.q("fix_ui_thread_parser_apk_file", true))) {
                                                d4 = l.d("tt_appdownloader_notification_install_finished_open");
                                                i3 = l.d("tt_appdownloader_notification_download_open");
                                            } else {
                                                d4 = l.d("tt_appdownloader_notification_download_complete_with_install");
                                                i3 = l.d("tt_appdownloader_notification_download_install");
                                            }
                                        } else {
                                            d4 = l.d("tt_appdownloader_notification_download_complete_without_install");
                                            if (f.c().I(a2) != null) {
                                                d4 = l.d("tt_appdownloader_notification_download_complete_open");
                                            }
                                            i3 = 0;
                                        }
                                        str2 = this.k.getString(d4);
                                        y.setContentText(str2);
                                        str = i3 != 0 ? this.k.getString(i3) : "";
                                        if (d5.m("notification_opt_2") == 1) {
                                            x.setTextViewText(g.k(), str);
                                            x.setViewVisibility(g.o(), 8);
                                        } else {
                                            x.setViewVisibility(g.k(), 8);
                                        }
                                        str3 = str;
                                        str4 = k4;
                                    } else {
                                        str2 = "";
                                        str3 = str2;
                                        str4 = str3;
                                    }
                                } else {
                                    if (d5.m("enable_notification_ui") >= 2 && n() == -1 && (d.l.a.e.b.l.f.Y0(baseException) || d.l.a.e.b.l.f.V0(baseException))) {
                                        str = d.k(j()) + "/" + d.k(l());
                                    }
                                    x.setViewVisibility(g.o(), 8);
                                    if (baseException != null && baseException.getErrorCode() == 1006) {
                                        str2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_space_failed"));
                                    } else if (v(baseException, d5, f2)) {
                                        if (f2 != null && f2.isOnlyWifi()) {
                                            d3 = l.d("tt_appdownloader_notification_download_waiting_wifi");
                                        } else {
                                            d3 = l.d("tt_appdownloader_notification_download_waiting_net");
                                        }
                                        str2 = this.j.getResources().getString(d3);
                                    } else {
                                        str2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_failed"));
                                    }
                                    str3 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_restart"));
                                    x.setViewVisibility(g.k(), 8);
                                    if (d5.m("enable_notification_ui") >= 2 && n() == -1) {
                                        if (d.l.a.e.b.l.f.Y0(baseException)) {
                                            if (d.l.a.e.b.l.f.i0(baseException, f2)) {
                                                str2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_no_wifi_and_in_net"));
                                                str3 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_resume"));
                                            } else {
                                                str2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_no_internet_error"));
                                            }
                                        } else if (d.l.a.e.b.l.f.V0(baseException)) {
                                            str4 = str;
                                            i2 = 0;
                                            str2 = this.j.getResources().getString(l.d("tt_appdownloader_notification_insufficient_space_error"), d.G(l() - j()));
                                            x.setViewVisibility(s(a2), 8);
                                            x.setViewVisibility(g.i(), i2);
                                            x.setViewVisibility(g.j(), 8);
                                            if (d5.m("enable_notification_ui") >= 2 && n() == -1 && (d.l.a.e.b.l.f.Y0(baseException) || d.l.a.e.b.l.f.V0(baseException))) {
                                                x.setViewVisibility(s(a2), 0);
                                                x.setViewVisibility(g.i(), 8);
                                                x.setViewVisibility(g.j(), 0);
                                                int k5 = g.k();
                                                if (!d.l.a.e.b.l.f.i0(baseException, f2)) {
                                                    x.setViewVisibility(k5, 0);
                                                    str = d.n(j(), false) + "/" + d.n(l(), false);
                                                } else {
                                                    x.setViewVisibility(k5, 8);
                                                }
                                            }
                                            str = str4;
                                        }
                                    }
                                    str4 = str;
                                }
                                i2 = 0;
                                x.setViewVisibility(s(a2), 8);
                                x.setViewVisibility(g.i(), i2);
                                x.setViewVisibility(g.j(), 8);
                                if (d5.m("enable_notification_ui") >= 2) {
                                    x.setViewVisibility(s(a2), 0);
                                    x.setViewVisibility(g.i(), 8);
                                    x.setViewVisibility(g.j(), 0);
                                    int k52 = g.k();
                                    if (!d.l.a.e.b.l.f.i0(baseException, f2)) {
                                    }
                                }
                                str = str4;
                            } else {
                                str2 = "";
                                str3 = str2;
                            }
                            x.setTextViewText(g.n(), str);
                            x.setTextViewText(g.p(), str2);
                            x.setTextViewText(g.o(), str);
                            x.setTextViewText(g.q(), str2);
                            int k6 = g.k();
                            if (TextUtils.isEmpty(str3)) {
                                x.setViewVisibility(k6, 8);
                            } else {
                                x.setTextViewText(k6, str3);
                            }
                            if (d5.m("notification_opt_2") == 1) {
                                y.setAutoCancel(true);
                                z4 = false;
                                if (d5.b("notification_ongoing", 0) == 1) {
                                    y.setOngoing(true);
                                    z3 = true;
                                } else {
                                    y.setOngoing(false);
                                    z3 = false;
                                }
                            } else {
                                z4 = false;
                            }
                            Notification build = y.build();
                            if (z3) {
                                build.flags |= 2;
                                i(true);
                            } else {
                                i(z4);
                            }
                            build.contentView = x;
                            return build;
                        }
                        y.setOngoing(true);
                    }
                    str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
                }
                z2 = true;
                y.setContentIntent(u(str5, b2, a2));
                y.setDeleteIntent(u("android.ss.intent.action.DOWNLOAD_HIDE", b2, a2));
                long j2 = j();
                long l3 = l();
                if (l3 > 0) {
                }
                m = m();
                if (TextUtils.isEmpty(m)) {
                }
                x = x();
                int k7 = g.k();
                if (d.l.a.e.b.j.a.d(a2).m("notification_opt_2") != 1) {
                }
                z3 = z2;
                if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
                }
                x.setTextViewText(g.m(), m);
                int s3 = s(a2);
                x.setViewVisibility(s3, 0);
                x.setProgressBar(s3, 100, i4, z);
                int l22 = g.l();
                if (t != 0) {
                }
                if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
                }
                str = "";
                if (b2 != 1) {
                }
                str = d.k(j()) + "/" + d.k(l());
                if (b2 == 1) {
                }
                String string5 = this.j.getResources().getString(d2);
                String string22 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_pause"));
                x.setViewVisibility(s(a2), 0);
                x.setViewVisibility(g.i(), 8);
                x.setViewVisibility(g.j(), 0);
                int k22 = g.k();
                if (d.B(this.l)) {
                }
                if (d5.m("enable_notification_ui") >= 2) {
                }
                str2 = string5;
                str3 = string22;
                x.setTextViewText(g.n(), str);
                x.setTextViewText(g.p(), str2);
                x.setTextViewText(g.o(), str);
                x.setTextViewText(g.q(), str2);
                int k62 = g.k();
                if (TextUtils.isEmpty(str3)) {
                }
                if (d5.m("notification_opt_2") == 1) {
                }
                Notification build2 = y.build();
                if (z3) {
                }
                build2.contentView = x;
                return build2;
            }
            z2 = true;
            long j22 = j();
            long l32 = l();
            if (l32 > 0) {
            }
            m = m();
            if (TextUtils.isEmpty(m)) {
            }
            x = x();
            int k72 = g.k();
            if (d.l.a.e.b.j.a.d(a2).m("notification_opt_2") != 1) {
            }
            z3 = z2;
            if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
            }
            x.setTextViewText(g.m(), m);
            int s32 = s(a2);
            x.setViewVisibility(s32, 0);
            x.setProgressBar(s32, 100, i4, z);
            int l222 = g.l();
            if (t != 0) {
            }
            if (d.l.a.e.b.j.a.d(a2).m("enable_notification_ui") >= 1) {
            }
            str = "";
            if (b2 != 1) {
            }
            str = d.k(j()) + "/" + d.k(l());
            if (b2 == 1) {
            }
            String string52 = this.j.getResources().getString(d2);
            String string222 = this.j.getResources().getString(l.d("tt_appdownloader_notification_download_pause"));
            x.setViewVisibility(s(a2), 0);
            x.setViewVisibility(g.i(), 8);
            x.setViewVisibility(g.j(), 0);
            int k222 = g.k();
            if (d.B(this.l)) {
            }
            if (d5.m("enable_notification_ui") >= 2) {
            }
            str2 = string52;
            str3 = string222;
            x.setTextViewText(g.n(), str);
            x.setTextViewText(g.p(), str2);
            x.setTextViewText(g.o(), str);
            x.setTextViewText(g.q(), str2);
            int k622 = g.k();
            if (TextUtils.isEmpty(str3)) {
            }
            if (d5.m("notification_opt_2") == 1) {
            }
            Notification build22 = y.build();
            if (z3) {
            }
            build22.contentView = x;
            return build22;
        }
        return (Notification) invokeLZ.objValue;
    }

    public final RemoteViews x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RemoteViews remoteViews = new RemoteViews(this.j.getPackageName(), g.a());
            if (Build.VERSION.SDK_INT > 20) {
                try {
                    if (d.t(this.j)) {
                        remoteViews.setInt(g.f(), "setBackgroundColor", this.j.getResources().getColor(g.r()));
                    }
                } catch (Throwable unused) {
                }
            }
            return remoteViews;
        }
        return (RemoteViews) invokeV.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0048 -> B:21:0x004f). Please submit an issue!!! */
    public final NotificationCompat.Builder y() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String F = d.l.a.e.a.e.G().F();
            if (Build.VERSION.SDK_INT < 26) {
                return new NotificationCompat.Builder(this.j);
            }
            if (TextUtils.isEmpty(F)) {
                F = d.H(this.j);
            }
            try {
                if (d.l.a.e.a.e.G().H() != null) {
                    builder = d.l.a.e.a.e.G().H().a(this.j, F);
                } else {
                    builder = new NotificationCompat.Builder(this.j, F);
                }
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(this.j);
            }
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }
}
