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
    public Handler f66865a = new Handler(Looper.getMainLooper());

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
        public final /* synthetic */ d.o.a.e.b.j.a f66866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66867f;

        public b(h hVar, d.o.a.e.b.j.a aVar, d.o.a.a.a.c.d dVar) {
            this.f66866e = aVar;
            this.f66867f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.n().a(2, n.a(), this.f66867f, this.f66866e.h("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f66868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66869f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66870g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f66871h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66872i;

        public c(h hVar, d.o.a.b.a.c.b bVar, long j, long j2, double d2, DownloadInfo downloadInfo) {
            this.f66868e = bVar;
            this.f66869f = j;
            this.f66870g = j2;
            this.f66871h = d2;
            this.f66872i = downloadInfo;
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            if (!d.o.a.d.n.k.D(this.f66868e)) {
                long j = this.f66869f;
                if (j <= -1 || this.f66870g <= -1 || j >= this.f66871h) {
                    return;
                }
                j.c.a().u("clean_space_install", d.o.a.d.f.h.d("install_no_enough_space"), this.f66868e);
                if (d.o.a.d.f.h.p(this.f66872i, ((long) this.f66871h) - this.f66869f)) {
                    d.o.a.e.b.a.a.c().h(this);
                    this.f66868e.G0(true);
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
            public final /* synthetic */ d.o.a.a.a.d.c f66873e;

            public a(d.o.a.a.a.d.c cVar) {
                this.f66873e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1856c interfaceC1856c = this.f66873e.f66519h;
                if (interfaceC1856c != null) {
                    interfaceC1856c.b(dialogInterface);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class b implements DialogInterface.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.a.a.d.c f66874e;

            public b(d.o.a.a.a.d.c cVar) {
                this.f66874e = cVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1856c interfaceC1856c = this.f66874e.f66519h;
                if (interfaceC1856c != null) {
                    interfaceC1856c.a(dialogInterface);
                }
            }
        }

        /* loaded from: classes7.dex */
        public static class c implements DialogInterface.OnCancelListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.o.a.a.a.d.c f66875e;

            public c(d.o.a.a.a.d.c cVar) {
                this.f66875e = cVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1856c interfaceC1856c = this.f66875e.f66519h;
                if (interfaceC1856c != null) {
                    interfaceC1856c.c(dialogInterface);
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
            AlertDialog show = new AlertDialog.Builder(cVar.f66512a).setTitle(cVar.f66513b).setMessage(cVar.f66514c).setPositiveButton(cVar.f66515d, new b(cVar)).setNegativeButton(cVar.f66516e, new a(cVar)).show();
            show.setCanceledOnTouchOutside(cVar.f66517f);
            show.setOnCancelListener(new c(cVar));
            Drawable drawable = cVar.f66518g;
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
                    this.f66865a.post(new a(this));
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
                            this.f66865a.post(new b(this, d2, a2));
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
        public q f66876a;

        @Override // d.o.a.a.a.a.h
        public void a(@NonNull Activity activity, @NonNull String[] strArr, q qVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f66876a = qVar;
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
            if (iArr.length <= 0 || (qVar = this.f66876a) == null) {
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
