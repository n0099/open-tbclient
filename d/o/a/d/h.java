package d.o.a.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.q;
import d.o.a.a.a.d.c;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.e.a.d;
import d.o.a.e.b.a.a;
/* loaded from: classes7.dex */
public class h implements d.j {

    /* renamed from: a  reason: collision with root package name */
    public Handler f70694a = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(5, n.a(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.j.a f70695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f70696f;

        public b(h hVar, d.o.a.e.b.j.a aVar, d.o.a.a.a.c.d dVar) {
            this.f70695e = aVar;
            this.f70696f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(2, n.a(), this.f70696f, this.f70695e.h("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f70697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f70698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f70699g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f70700h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f70701i;

        public c(h hVar, d.o.a.b.a.c.b bVar, long j, long j2, double d2, DownloadInfo downloadInfo) {
            this.f70697e = bVar;
            this.f70698f = j;
            this.f70699g = j2;
            this.f70700h = d2;
            this.f70701i = downloadInfo;
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            if (!d.o.a.d.n.k.D(this.f70697e)) {
                long j = this.f70698f;
                if (j <= -1 || this.f70699g <= -1 || j >= this.f70700h) {
                    return;
                }
                j.c.a().u("clean_space_install", d.o.a.d.f.h.d("install_no_enough_space"), this.f70697e);
                if (d.o.a.d.f.h.p(this.f70701i, ((long) this.f70700h) - this.f70698f)) {
                    d.o.a.e.b.a.a.c().h(this);
                    this.f70697e.G0(true);
                    return;
                }
                return;
            }
            d.o.a.e.b.a.a.c().h(this);
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.o.a.a.a.a.k {

        /* loaded from: classes7.dex */
        public static class a implements DialogInterface.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.a.a.d.c f70702e;

            public a(d.o.a.a.a.d.c cVar) {
                this.f70702e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1920c interfaceC1920c = this.f70702e.f70348h;
                if (interfaceC1920c != null) {
                    interfaceC1920c.a(dialogInterface);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b implements DialogInterface.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.a.a.d.c f70703e;

            public b(d.o.a.a.a.d.c cVar) {
                this.f70703e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1920c interfaceC1920c = this.f70703e.f70348h;
                if (interfaceC1920c != null) {
                    interfaceC1920c.b(dialogInterface);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class c implements DialogInterface.OnCancelListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.a.a.d.c f70704e;

            public c(d.o.a.a.a.d.c cVar) {
                this.f70704e = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1920c interfaceC1920c = this.f70704e.f70348h;
                if (interfaceC1920c != null) {
                    interfaceC1920c.c(dialogInterface);
                }
            }
        }

        @Override // d.o.a.a.a.a.k
        public void a(int i2, @Nullable Context context, d.o.a.a.a.c.d dVar, String str, Drawable drawable, int i3) {
            Toast.makeText(context, str, 0).show();
        }

        @Override // d.o.a.a.a.a.k
        public Dialog b(@NonNull d.o.a.a.a.d.c cVar) {
            return a(cVar);
        }

        public static Dialog a(d.o.a.a.a.d.c cVar) {
            if (cVar == null) {
                return null;
            }
            AlertDialog show = new AlertDialog.Builder(cVar.f70341a).setTitle(cVar.f70342b).setMessage(cVar.f70343c).setPositiveButton(cVar.f70344d, new b(cVar)).setNegativeButton(cVar.f70345e, new a(cVar)).show();
            show.setCanceledOnTouchOutside(cVar.f70346f);
            show.setOnCancelListener(new c(cVar));
            Drawable drawable = cVar.f70347g;
            if (drawable != null) {
                show.setIcon(drawable);
            }
            return show;
        }
    }

    @Override // d.o.a.e.a.d.j
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        d.o.a.b.a.c.b c2;
        d.o.a.a.a.c.d a2;
        if (downloadInfo == null || (c2 = c.g.e().c(downloadInfo)) == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    d.o.a.d.e.n(downloadInfo, c2);
                    return;
                } else if (i2 == 2001) {
                    d.o.a.d.e.d().o(downloadInfo, c2, 2001);
                    return;
                } else if (i2 == 11) {
                    d.o.a.d.e.d().o(downloadInfo, c2, 2000);
                    if (c2.N()) {
                        return;
                    }
                    b(downloadInfo, c2);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (d.o.a.e.b.j.a.d(downloadInfo.c0()).b("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f70694a.post(new a(this));
                }
                if (d.o.a.e.b.l.e.M0(baseException)) {
                    if (n.v() != null) {
                        n.v().a(c2.b());
                    }
                    j.c.a().o("download_failed_for_space", c2);
                    if (!c2.L()) {
                        j.c.a().o("download_can_restart", c2);
                        a(downloadInfo);
                    }
                    if ((n.v() == null || !n.v().d()) && (a2 = c.g.e().a(c2.b())) != null && a2.k()) {
                        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
                        if (d2.b("show_no_enough_space_toast", 0) == 1) {
                            this.f70694a.post(new b(this, d2, a2));
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), d.o.a.d.n.k.l(baseException.getMessage(), n.s().optInt("exception_msg_length", 500)));
            }
            j.c.a().z(downloadInfo, baseException2);
            k.b().h(downloadInfo, baseException, "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(DownloadInfo downloadInfo, d.o.a.b.a.c.b bVar) {
        long f2 = d.o.a.d.n.k.f(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, d.o.a.d.n.k.e(Environment.getDataDirectory()) / 10);
        long Q0 = downloadInfo.Q0();
        double d2 = (Q0 * 2.5d) + min;
        if (f2 > -1 && Q0 > -1) {
            double d3 = f2;
            if (d3 < d2 && d2 - d3 > d.o.a.d.f.h.q()) {
                d.o.a.d.f.h.e(downloadInfo.c0());
            }
        }
        d.o.a.e.b.a.a.c().f(new c(this, bVar, f2, Q0, d2, downloadInfo));
    }

    /* loaded from: classes7.dex */
    public class e implements d.o.a.a.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        public q f70705a;

        @Override // d.o.a.a.a.a.h
        public void a(@NonNull Activity activity, @NonNull String[] strArr, q qVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f70705a = qVar;
                activity.requestPermissions(strArr, 1);
            } else if (qVar != null) {
                qVar.a();
            }
        }

        @Override // d.o.a.a.a.a.h
        public boolean a(@Nullable Context context, @NonNull String str) {
            return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
        }

        @Override // d.o.a.a.a.a.h
        public void a(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            q qVar;
            if (iArr.length <= 0 || (qVar = this.f70705a) == null) {
                return;
            }
            if (iArr[0] == -1) {
                qVar.a(strArr[0]);
            } else if (iArr[0] == 0) {
                qVar.a();
            }
        }
    }

    public final void a(@NonNull DownloadInfo downloadInfo) {
        if (d.o.a.d.n.e.n(downloadInfo.c0())) {
            i.a().f(new d.o.a.d.f.d.b(downloadInfo));
        }
    }
}
