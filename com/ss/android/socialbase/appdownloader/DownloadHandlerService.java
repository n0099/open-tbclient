package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.a.d;
import d.o.a.e.a.e;
import d.o.a.e.b.f.i;
import d.o.a.e.b.g.d;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39498a = DownloadHandlerService.class.getSimpleName();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("application/vnd.android.package-archive");
                arrayList.add("mime_type_plg");
                d.o.a.e.b.g.a.l(d.l()).A(arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f39500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f39501f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.f.d f39502g;

        public b(DownloadInfo downloadInfo, d.f fVar, d.o.a.e.b.f.d dVar) {
            this.f39500e = downloadInfo;
            this.f39501f = fVar;
            this.f39502g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo i2;
            try {
                File file = new File(this.f39500e.F0(), this.f39500e.q0());
                if (file.exists()) {
                    try {
                        String str = (d.o.a.e.b.g.d.l() == null || (i2 = d.o.a.e.a.d.i(this.f39500e, file)) == null) ? "" : i2.packageName;
                        if (this.f39501f != null) {
                            this.f39501f.b(this.f39500e.c0(), 3, str, -3, this.f39500e.M());
                        }
                        if (this.f39502g != null) {
                            this.f39502g.a(3, this.f39500e, str, "");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

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
        d.f t = e.F().t();
        d.o.a.e.b.f.d i2 = d.o.a.e.b.g.a.l(this).i(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && d.o.a.e.b.j.a.d(intExtra).m("notification_opt_2") == 1) {
            d.o.a.e.b.p.b.a().m(intExtra);
        }
        DownloadInfo f2 = d.o.a.e.b.g.a.l(this).f(intExtra);
        if (f2 == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(f2, t, i2);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, f2, t, i2);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (f2.H0() == 0) {
                return false;
            }
            a(this, f2, t, i2);
            if (f2.m1() && d.o.a.e.b.j.a.d(intExtra).b("no_hide_notification", 0) == 0) {
                if (!((d.o.a.e.b.j.a.d(intExtra).m("enable_notification_ui") < 2 || f2.H0() != -1) ? false : false)) {
                    d.o.a.e.b.p.b.a().b(intExtra);
                    d.o.a.e.b.p.b.a().m(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(f2, t, i2);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            d.o.a.e.b.p.b.a().b(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            d.o.a.e.b.g.d.w0().execute(new a());
            return true;
        }
        return false;
    }

    private void b(@NonNull DownloadInfo downloadInfo, d.f fVar, d.o.a.e.b.f.d dVar) {
        int c0 = downloadInfo.c0();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", c0);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        startActivity(intent);
        d.o.a.e.b.p.b.a().b(c0);
        downloadInfo.p3();
        if (fVar != null) {
            fVar.b(c0, 7, "", downloadInfo.H0(), downloadInfo.M());
        }
        if (dVar != null) {
            dVar.a(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d.o.a.e.b.g.d.y(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f39498a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    public static void a(Context context, DownloadInfo downloadInfo) {
        if (d.o.a.e.b.l.e.d0(context.getApplicationContext()) && downloadInfo.L1()) {
            downloadInfo.l3();
        }
    }

    public static void a(Context context, d.f fVar, DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        d.o.a.e.b.f.d i2 = d.o.a.e.b.g.a.l(context).i(downloadInfo.c0());
        if (fVar == null && i2 == null) {
            return;
        }
        d.o.a.e.b.g.d.w0().execute(new b(downloadInfo, fVar, i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@NonNull DownloadInfo downloadInfo, d.f fVar, d.o.a.e.b.f.d dVar) {
        boolean a2;
        int c0 = downloadInfo.c0();
        i I = d.o.a.e.b.g.e.c().I(c0);
        if (I != null) {
            try {
                a2 = I.a(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (a2) {
                Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
                intent.putExtra("extra_click_download_ids", c0);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                startActivity(intent);
                d.o.a.e.b.p.b.a().b(c0);
                downloadInfo.p3();
                if (fVar != null) {
                    fVar.b(c0, 7, "", downloadInfo.H0(), downloadInfo.M());
                }
                if (dVar != null) {
                    dVar.a(7, downloadInfo, "", "");
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
        i I;
        DownloadInfo f2;
        if (z && (I = d.o.a.e.b.g.e.c().I(i2)) != null) {
            try {
                f2 = d.o.a.e.b.g.a.l(context).f(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (f2 != null) {
                z2 = I.b(f2);
                if (z2 && d.o.a.e.a.d.d(context, i2, true) == 0) {
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

    public static void a(Context context, DownloadInfo downloadInfo, d.f fVar, d.o.a.e.b.f.d dVar) {
        d.o.a.e.b.p.a l;
        int c0 = downloadInfo.c0();
        i I = d.o.a.e.b.g.e.c().I(c0);
        if ("application/vnd.android.package-archive".equals(downloadInfo.m0()) && I != null && d.o.a.e.a.d.v(context, downloadInfo) && I.c(downloadInfo)) {
            return;
        }
        boolean z = false;
        switch (downloadInfo.H0()) {
            case -4:
            case -1:
                if (d.o.a.e.b.j.a.d(c0).m("enable_notification_ui") >= 2 && downloadInfo.K1()) {
                    downloadInfo.Q2(false);
                }
                d.o.a.e.b.g.a.l(context).z(c0);
                return;
            case -3:
                a(d.o.a.e.b.g.d.l(), c0, true);
                a(context, fVar, downloadInfo);
                if (d.o.a.e.b.j.a.d(c0).b("notification_click_install_auto_cancel", 1) != 0 || (l = d.o.a.e.b.p.b.a().l(c0)) == null) {
                    z = true;
                } else {
                    l.p();
                    l.c(-3, null, false, true);
                }
                if (z) {
                    d.o.a.e.b.p.b.a().b(c0);
                    return;
                }
                return;
            case -2:
                if (d.o.a.e.b.g.e.c().B(c0)) {
                    d.o.a.e.b.g.a.l(context).C(c0);
                } else {
                    d.o.a.e.a.d.s(downloadInfo, true, false);
                }
                if (fVar != null) {
                    fVar.b(c0, 6, "", downloadInfo.H0(), downloadInfo.M());
                }
                if (dVar != null) {
                    dVar.a(6, downloadInfo, "", "");
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
                d.o.a.e.b.g.a.l(context).v(c0);
                a(context, downloadInfo);
                if (fVar != null) {
                    fVar.b(c0, 5, "", downloadInfo.H0(), downloadInfo.M());
                }
                if (dVar != null) {
                    dVar.a(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
