package d.p.a.d;

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
import d.p.a.a.a.a.q;
import d.p.a.a.a.d.c;
import d.p.a.d.f.c;
import d.p.a.d.f.n;
import d.p.a.d.j;
import d.p.a.e.a.d;
import d.p.a.e.b.a.a;
/* loaded from: classes6.dex */
public class h implements d.j {

    /* renamed from: a  reason: collision with root package name */
    public Handler f67830a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(5, n.a(), null, "无网络，请检查网络设置", null, 0);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.p.a.e.b.j.a f67831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.p.a.a.a.c.d f67832f;

        public b(h hVar, d.p.a.e.b.j.a aVar, d.p.a.a.a.c.d dVar) {
            this.f67831e = aVar;
            this.f67832f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(2, n.a(), this.f67832f, this.f67831e.h("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.p.a.b.a.c.b f67833e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f67834f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f67835g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f67836h;
        public final /* synthetic */ DownloadInfo i;

        public c(h hVar, d.p.a.b.a.c.b bVar, long j, long j2, double d2, DownloadInfo downloadInfo) {
            this.f67833e = bVar;
            this.f67834f = j;
            this.f67835g = j2;
            this.f67836h = d2;
            this.i = downloadInfo;
        }

        @Override // d.p.a.e.b.a.a.b
        public void b() {
            if (!d.p.a.d.n.k.D(this.f67833e)) {
                long j = this.f67834f;
                if (j <= -1 || this.f67835g <= -1 || j >= this.f67836h) {
                    return;
                }
                j.c.a().u("clean_space_install", d.p.a.d.f.h.d("install_no_enough_space"), this.f67833e);
                if (d.p.a.d.f.h.p(this.i, ((long) this.f67836h) - this.f67834f)) {
                    d.p.a.e.b.a.a.c().h(this);
                    this.f67833e.G0(true);
                    return;
                }
                return;
            }
            d.p.a.e.b.a.a.c().h(this);
        }

        @Override // d.p.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d.p.a.a.a.a.k {

        /* loaded from: classes6.dex */
        public static class a implements DialogInterface.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.p.a.a.a.d.c f67837e;

            public a(d.p.a.a.a.d.c cVar) {
                this.f67837e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.InterfaceC1857c interfaceC1857c = this.f67837e.f67501h;
                if (interfaceC1857c != null) {
                    interfaceC1857c.a(dialogInterface);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class b implements DialogInterface.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.p.a.a.a.d.c f67838e;

            public b(d.p.a.a.a.d.c cVar) {
                this.f67838e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.InterfaceC1857c interfaceC1857c = this.f67838e.f67501h;
                if (interfaceC1857c != null) {
                    interfaceC1857c.b(dialogInterface);
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class c implements DialogInterface.OnCancelListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.p.a.a.a.d.c f67839e;

            public c(d.p.a.a.a.d.c cVar) {
                this.f67839e = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1857c interfaceC1857c = this.f67839e.f67501h;
                if (interfaceC1857c != null) {
                    interfaceC1857c.c(dialogInterface);
                }
            }
        }

        @Override // d.p.a.a.a.a.k
        public void a(int i, @Nullable Context context, d.p.a.a.a.c.d dVar, String str, Drawable drawable, int i2) {
            Toast.makeText(context, str, 0).show();
        }

        @Override // d.p.a.a.a.a.k
        public Dialog b(@NonNull d.p.a.a.a.d.c cVar) {
            return a(cVar);
        }

        public static Dialog a(d.p.a.a.a.d.c cVar) {
            if (cVar == null) {
                return null;
            }
            AlertDialog show = new AlertDialog.Builder(cVar.f67494a).setTitle(cVar.f67495b).setMessage(cVar.f67496c).setPositiveButton(cVar.f67497d, new b(cVar)).setNegativeButton(cVar.f67498e, new a(cVar)).show();
            show.setCanceledOnTouchOutside(cVar.f67499f);
            show.setOnCancelListener(new c(cVar));
            Drawable drawable = cVar.f67500g;
            if (drawable != null) {
                show.setIcon(drawable);
            }
            return show;
        }
    }

    @Override // d.p.a.e.a.d.j
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
        d.p.a.b.a.c.b c2;
        d.p.a.a.a.c.d a2;
        if (downloadInfo == null || (c2 = c.g.e().c(downloadInfo)) == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    d.p.a.d.e.n(downloadInfo, c2);
                    return;
                } else if (i == 2001) {
                    d.p.a.d.e.d().o(downloadInfo, c2, 2001);
                    return;
                } else if (i == 11) {
                    d.p.a.d.e.d().o(downloadInfo, c2, 2000);
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
                if (d.p.a.e.b.j.a.d(downloadInfo.c0()).b("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f67830a.post(new a(this));
                }
                if (d.p.a.e.b.l.e.M0(baseException)) {
                    if (n.v() != null) {
                        n.v().a(c2.b());
                    }
                    j.c.a().o("download_failed_for_space", c2);
                    if (!c2.L()) {
                        j.c.a().o("download_can_restart", c2);
                        a(downloadInfo);
                    }
                    if ((n.v() == null || !n.v().d()) && (a2 = c.g.e().a(c2.b())) != null && a2.k()) {
                        d.p.a.e.b.j.a d2 = d.p.a.e.b.j.a.d(downloadInfo.c0());
                        if (d2.b("show_no_enough_space_toast", 0) == 1) {
                            this.f67830a.post(new b(this, d2, a2));
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), d.p.a.d.n.k.l(baseException.getMessage(), n.s().optInt("exception_msg_length", 500)));
            }
            j.c.a().z(downloadInfo, baseException2);
            k.b().h(downloadInfo, baseException, "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(DownloadInfo downloadInfo, d.p.a.b.a.c.b bVar) {
        long f2 = d.p.a.d.n.k.f(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, d.p.a.d.n.k.e(Environment.getDataDirectory()) / 10);
        long Q0 = downloadInfo.Q0();
        double d2 = (Q0 * 2.5d) + min;
        if (f2 > -1 && Q0 > -1) {
            double d3 = f2;
            if (d3 < d2 && d2 - d3 > d.p.a.d.f.h.q()) {
                d.p.a.d.f.h.e(downloadInfo.c0());
            }
        }
        d.p.a.e.b.a.a.c().f(new c(this, bVar, f2, Q0, d2, downloadInfo));
    }

    /* loaded from: classes6.dex */
    public class e implements d.p.a.a.a.a.h {

        /* renamed from: a  reason: collision with root package name */
        public q f67840a;

        @Override // d.p.a.a.a.a.h
        public void a(@NonNull Activity activity, @NonNull String[] strArr, q qVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f67840a = qVar;
                activity.requestPermissions(strArr, 1);
            } else if (qVar != null) {
                qVar.a();
            }
        }

        @Override // d.p.a.a.a.a.h
        public boolean a(@Nullable Context context, @NonNull String str) {
            return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
        }

        @Override // d.p.a.a.a.a.h
        public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            q qVar;
            if (iArr.length <= 0 || (qVar = this.f67840a) == null) {
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
        if (d.p.a.d.n.e.n(downloadInfo.c0())) {
            i.a().f(new d.p.a.d.f.d.b(downloadInfo));
        }
    }
}
