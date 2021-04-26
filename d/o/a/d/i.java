package d.o.a.d;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.down.request.db.DownloadDataConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.d.c;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.e.a.d;
import d.o.a.e.a.h.a;
import d.o.a.e.b.f.o;
import d.o.a.e.b.f.p;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f66191a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f66192b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledExecutorService f66193c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a(i iVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.b.g.j I0;
            synchronized (i.class) {
                try {
                    String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                    for (int i2 = 0; i2 < 13; i2++) {
                        SharedPreferences sharedPreferences = n.a().getSharedPreferences(strArr[i2], 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().clear().apply();
                        }
                    }
                    I0 = d.o.a.e.b.g.d.I0();
                } catch (Throwable unused) {
                }
                if (I0 instanceof d.o.a.e.b.m.d) {
                    SparseArray<DownloadInfo> a2 = ((d.o.a.e.b.m.d) I0).e().a();
                    for (int size = a2.size() - 1; size >= 0; size--) {
                        DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                        if (downloadInfo != null) {
                            d.o.a.e.b.g.a.l(n.a()).d(downloadInfo.c0());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static i f66194a = new i(null);
    }

    /* loaded from: classes6.dex */
    public class f implements d.o.a.e.b.e.c {
        @Override // d.o.a.e.b.e.c
        public void a(int i2, String str, JSONObject jSONObject) {
            d.o.a.b.a.c.b c2;
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(i2);
            if (f2 == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            j.c.a().u(str, jSONObject, c2);
        }

        @Override // d.o.a.e.b.e.c
        public void b(int i2, String str, JSONObject jSONObject) {
            d.o.a.b.a.c.b c2;
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(i2);
            if (f2 == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            if ("install_view_result".equals(str)) {
                jSONObject = d.o.a.d.n.k.n(jSONObject);
                d.o.a.d.e.g(jSONObject, f2);
                d.o.a.d.n.k.r(jSONObject, "model_id", Long.valueOf(c2.b()));
            }
            j.c.a().t(str, jSONObject, c2);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d.f {

        /* renamed from: a  reason: collision with root package name */
        public Context f66196a;

        public g(Context context) {
            this.f66196a = context.getApplicationContext();
        }

        @Override // d.o.a.e.a.d.f
        public void a(Context context, String str) {
            d.o.a.d.e.d().p(str);
        }

        @Override // d.o.a.e.a.d.f
        public void b(int i2, int i3, String str, int i4, long j) {
            DownloadInfo f2;
            Context context = this.f66196a;
            if (context == null || (f2 = d.o.a.e.b.g.a.l(context).f(i2)) == null || f2.H0() == 0) {
                return;
            }
            d.o.a.b.a.c.b c2 = c.g.e().c(f2);
            if (c2 == null) {
                d.o.a.d.n.k.B();
            } else if (i3 == 1) {
                d.o.a.d.e.n(f2, c2);
                if ("application/vnd.android.package-archive".equals(f2.m0())) {
                    d.o.a.d.f.b.a().c(f2, c2.b(), c2.l(), c2.e(), f2.P0(), c2.d(), f2.K0());
                }
            } else if (i3 == 3) {
                JSONObject jSONObject = new JSONObject();
                d.o.a.d.e.s(jSONObject, f2);
                j.c.a().r("download_notification", "download_notification_install", jSONObject, c2);
            } else if (i3 == 5) {
                j.c.a().p("download_notification", "download_notification_pause", c2);
            } else if (i3 == 6) {
                j.c.a().p("download_notification", "download_notification_continue", c2);
            } else if (i3 != 7) {
            } else {
                j.c.a().p("download_notification", "download_notification_click", c2);
            }
        }

        @Override // d.o.a.e.a.d.f
        public boolean a(int i2, boolean z) {
            if (n.x() != null) {
                return n.x().a(z);
            }
            return false;
        }

        @Override // d.o.a.e.a.d.f
        public void a(DownloadInfo downloadInfo) {
            if (downloadInfo == null) {
                return;
            }
            k.b().g(downloadInfo);
            if (d.o.a.e.b.j.a.d(downloadInfo.c0()).b("report_download_cancel", 1) == 1) {
                j.c.a().j(downloadInfo, new BaseException(1012, ""));
            } else {
                j.c.a().z(downloadInfo, new BaseException(1012, ""));
            }
        }

        @Override // d.o.a.e.a.d.f
        public void a(int i2, int i3, String str, String str2, String str3) {
            DownloadInfo f2;
            Context context = this.f66196a;
            if (context == null || (f2 = d.o.a.e.b.g.a.l(context).f(i2)) == null || f2.H0() != -3) {
                return;
            }
            f2.S2(str2);
            d.o.a.d.f.c.a().b(this.f66196a, f2);
        }

        @Override // d.o.a.e.a.d.f
        public boolean a() {
            return d.o.a.d.f.c.a().c();
        }
    }

    /* loaded from: classes6.dex */
    public class h extends d.c {

        /* renamed from: a  reason: collision with root package name */
        public static String f66197a = "i$h";

        /* loaded from: classes6.dex */
        public class a implements d.n {

            /* renamed from: a  reason: collision with root package name */
            public c.b f66198a;

            /* renamed from: b  reason: collision with root package name */
            public DialogInterface.OnClickListener f66199b;

            /* renamed from: c  reason: collision with root package name */
            public DialogInterface.OnClickListener f66200c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnCancelListener f66201d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f66202e;

            /* renamed from: d.o.a.d.i$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C1807a implements c.InterfaceC1792c {
                public C1807a() {
                }

                @Override // d.o.a.a.a.d.c.InterfaceC1792c
                public void a(DialogInterface dialogInterface) {
                    if (a.this.f66199b != null) {
                        a.this.f66199b.onClick(dialogInterface, -1);
                    }
                }

                @Override // d.o.a.a.a.d.c.InterfaceC1792c
                public void b(DialogInterface dialogInterface) {
                    if (a.this.f66200c != null) {
                        a.this.f66200c.onClick(dialogInterface, -2);
                    }
                }

                @Override // d.o.a.a.a.d.c.InterfaceC1792c
                public void c(DialogInterface dialogInterface) {
                    if (a.this.f66201d == null || dialogInterface == null) {
                        return;
                    }
                    a.this.f66201d.onCancel(dialogInterface);
                }
            }

            public a(h hVar, Context context) {
                this.f66202e = context;
                this.f66198a = new c.b(this.f66202e);
            }

            @Override // d.o.a.e.a.d.n
            public d.n a(int i2) {
                this.f66198a.e(this.f66202e.getResources().getString(i2));
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.n b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f66198a.j(this.f66202e.getResources().getString(i2));
                this.f66199b = onClickListener;
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.n c(DialogInterface.OnCancelListener onCancelListener) {
                this.f66201d = onCancelListener;
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.n a(String str) {
                this.f66198a.h(str);
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.n a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f66198a.l(this.f66202e.getResources().getString(i2));
                this.f66200c = onClickListener;
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.n a(boolean z) {
                this.f66198a.f(z);
                return this;
            }

            @Override // d.o.a.e.a.d.n
            public d.m a() {
                this.f66198a.d(new C1807a());
                d.o.a.d.n.j.a(h.f66197a, "getThemedAlertDlgBuilder", null);
                this.f66198a.b(3);
                return new b(n.n().b(this.f66198a.g()));
            }
        }

        /* loaded from: classes6.dex */
        public static class b implements d.m {

            /* renamed from: a  reason: collision with root package name */
            public Dialog f66204a;

            public b(Dialog dialog) {
                if (dialog != null) {
                    this.f66204a = dialog;
                    a();
                }
            }

            @Override // d.o.a.e.a.d.m
            public void a() {
                Dialog dialog = this.f66204a;
                if (dialog != null) {
                    dialog.show();
                }
            }

            @Override // d.o.a.e.a.d.m
            public boolean b() {
                Dialog dialog = this.f66204a;
                if (dialog != null) {
                    return dialog.isShowing();
                }
                return false;
            }
        }

        @Override // d.o.a.e.a.d.c, d.o.a.e.a.d.e
        public d.n a(Context context) {
            return new a(this, context);
        }

        @Override // d.o.a.e.a.d.c, d.o.a.e.a.d.e
        public boolean a() {
            return true;
        }
    }

    /* renamed from: d.o.a.d.i$i  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1808i {

        /* renamed from: d.o.a.d.i$i$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f66205e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66206f;

            public a(int i2, d.o.a.b.a.c.b bVar) {
                this.f66205e = i2;
                this.f66206f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66205e);
                JSONObject jSONObject = new JSONObject();
                d.o.a.d.n.k.r(jSONObject, "ttdownloader_type", 1);
                d.o.a.d.n.f.g(f2, jSONObject);
                if (f2 != null && -2 == f2.z0() && !f2.L1()) {
                    C1808i.this.c(this.f66205e, this.f66206f, jSONObject);
                } else {
                    d.o.a.d.n.k.r(jSONObject, "error_code", 1001);
                }
                j.c.a().t("download_notification_try_show", jSONObject, this.f66206f);
            }
        }

        /* renamed from: d.o.a.d.i$i$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f66208e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66209f;

            public b(int i2, d.o.a.b.a.c.b bVar) {
                this.f66208e = i2;
                this.f66209f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66208e);
                JSONObject jSONObject = new JSONObject();
                d.o.a.d.n.k.r(jSONObject, "ttdownloader_type", 2);
                d.o.a.d.n.f.g(f2, jSONObject);
                if (!d.o.a.d.n.k.D(this.f66209f)) {
                    C1808i.this.c(this.f66208e, this.f66209f, jSONObject);
                } else {
                    d.o.a.d.n.k.r(jSONObject, "error_code", 1002);
                }
                j.c.a().t("download_notification_try_show", jSONObject, this.f66209f);
            }
        }

        /* renamed from: d.o.a.d.i$i$c */
        /* loaded from: classes6.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f66211e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f66212f;

            public c(int i2, d.o.a.b.a.c.b bVar) {
                this.f66211e = i2;
                this.f66212f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66211e);
                JSONObject jSONObject = new JSONObject();
                d.o.a.d.n.k.r(jSONObject, "ttdownloader_type", 3);
                d.o.a.d.n.f.g(f2, jSONObject);
                if (!d.o.a.d.n.k.H(this.f66212f.e())) {
                    C1808i.this.c(this.f66211e, this.f66212f, jSONObject);
                } else {
                    d.o.a.d.n.k.r(jSONObject, "error_code", 1003);
                }
                j.c.a().t("download_notification_try_show", jSONObject, this.f66212f);
            }
        }

        /* renamed from: d.o.a.d.i$i$d */
        /* loaded from: classes6.dex */
        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public static C1808i f66214a = new C1808i(null);
        }

        public /* synthetic */ C1808i(a aVar) {
            this();
        }

        public static C1808i a() {
            return d.f66214a;
        }

        public void b(int i2) {
            DownloadInfo f2;
            if (com.ss.android.socialbase.appdownloader.e.c.d().b(i2) != null || (f2 = d.o.a.e.b.g.a.l(n.a()).f(i2)) == null) {
                return;
            }
            com.ss.android.socialbase.appdownloader.e.c.d().e(i2, f2.b0());
        }

        public final void c(int i2, d.o.a.b.a.c.b bVar, JSONObject jSONObject) {
            if (!d.o.a.e.a.f.c.d()) {
                d.o.a.d.n.k.r(jSONObject, "error_code", 1004);
                return;
            }
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(i2);
            if (f2 == null) {
                d.o.a.d.n.k.r(jSONObject, "error_code", 1005);
                return;
            }
            if (d.o.a.e.b.p.b.a().l(i2) != null) {
                d.o.a.e.b.p.b.a().m(i2);
            }
            d.o.a.e.a.f.a aVar = new d.o.a.e.a.f.a(n.a(), i2, f2.P0(), f2.F0(), f2.q0(), f2.R());
            aVar.d(f2.E());
            aVar.k(f2.Q0());
            aVar.c(f2.H0(), null, false, false);
            d.o.a.e.b.p.b.a().e(aVar);
            aVar.g(null, false);
            j.c.a().t("download_notification_show", jSONObject, bVar);
        }

        public void d(d.o.a.b.a.c.b bVar) {
            h(bVar, 5L);
        }

        public void e(@NonNull d.o.a.b.a.c.b bVar, long j) {
            int s = bVar.s();
            if (d.o.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                return;
            }
            b(s);
            i.a().c(new c(s, bVar), j * 1000);
        }

        public void g(d.o.a.b.a.c.b bVar) {
            if (bVar == null) {
                return;
            }
            h(bVar, d.o.a.e.b.j.a.d(bVar.s()).b("noti_continue_delay_secs", 5));
        }

        public final void h(@NonNull d.o.a.b.a.c.b bVar, long j) {
            int s = bVar.s();
            if (d.o.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                return;
            }
            b(s);
            i.a().c(new a(s, bVar), j * 1000);
        }

        public void i(@NonNull d.o.a.b.a.c.b bVar) {
            j(bVar, 5L);
        }

        public final void j(@NonNull d.o.a.b.a.c.b bVar, long j) {
            int s = bVar.s();
            if (d.o.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                return;
            }
            b(s);
            i.a().c(new b(s, bVar), j * 1000);
        }

        public void k(@NonNull d.o.a.b.a.c.b bVar) {
            j(bVar, d.o.a.e.b.j.a.d(bVar.s()).b("noti_install_delay_secs", 5));
        }

        public void l(@NonNull d.o.a.b.a.c.b bVar) {
            e(bVar, 5L);
        }

        public void m(@NonNull d.o.a.b.a.c.b bVar) {
            e(bVar, d.o.a.e.b.j.a.d(bVar.s()).b("noti_open_delay_secs", 5));
        }

        public C1808i() {
        }
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static i a() {
        return b.f66194a;
    }

    public void b(Runnable runnable) {
        d(runnable, false);
    }

    public void c(Runnable runnable, long j) {
        try {
            i().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !d.o.a.d.n.k.s()) {
            runnable.run();
        } else {
            e().execute(runnable);
        }
    }

    public ExecutorService e() {
        if (this.f66191a == null) {
            synchronized (i.class) {
                if (this.f66191a == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f66191a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new d.o.a.e.b.k.a(l.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f66191a;
    }

    public void f(Runnable runnable) {
        g(runnable, false);
    }

    public void g(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !d.o.a.d.n.k.s()) {
            runnable.run();
        } else {
            h().execute(runnable);
        }
    }

    public ExecutorService h() {
        if (this.f66192b == null) {
            synchronized (i.class) {
                if (this.f66192b == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f66192b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new d.o.a.e.b.k.a(l.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f66192b;
    }

    public ScheduledExecutorService i() {
        if (this.f66193c == null) {
            synchronized (i.class) {
                if (this.f66193c == null) {
                    this.f66193c = new ScheduledThreadPoolExecutor(0, new d.o.a.e.b.k.a(l.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.f66193c;
    }

    public void j() {
        b(new a(this));
    }

    /* loaded from: classes6.dex */
    public class c implements p {

        /* loaded from: classes6.dex */
        public class a implements MediaScannerConnection.OnScanCompletedListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f66195a;

            public a(c cVar, DownloadInfo downloadInfo) {
                this.f66195a = downloadInfo;
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                if (uri != null) {
                    this.f66195a.c2("file_content_uri", uri.toString());
                    d.o.a.e.b.g.d.I0().a(this.f66195a);
                }
            }
        }

        @Override // d.o.a.e.b.f.p
        public void a(DownloadInfo downloadInfo) throws BaseException {
            if (downloadInfo == null || !c(downloadInfo)) {
                return;
            }
            a(n.a(), downloadInfo);
        }

        @Override // d.o.a.e.b.f.p
        public boolean b(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                return d.o.a.d.n.e.i(d.o.a.e.b.j.a.d(downloadInfo.c0()));
            }
            return false;
        }

        public final boolean c(DownloadInfo downloadInfo) {
            String str = downloadInfo.F0() + File.separator + downloadInfo.q0();
            File file = new File(str);
            String d2 = a.e.d(n.a(), d.o.a.e.a.d.i(downloadInfo, file), str);
            boolean z = false;
            if (!TextUtils.isEmpty(d2)) {
                String str2 = d2 + ".apk";
                if (str2.equals(downloadInfo.q0())) {
                    return true;
                }
                try {
                    z = file.renameTo(new File(downloadInfo.F0() + File.separator + str2));
                    if (z) {
                        downloadInfo.N2(str2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return z;
        }

        public final void a(Context context, DownloadInfo downloadInfo) {
            String str = downloadInfo.F0() + File.separator + downloadInfo.q0();
            Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
            if (query != null && query.moveToFirst()) {
                downloadInfo.c2("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex("_id"))).toString());
            } else {
                MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new a(this, downloadInfo));
            }
            d.o.a.e.b.l.e.C(query);
        }
    }

    public i() {
    }

    /* loaded from: classes6.dex */
    public class d implements p {
        @Override // d.o.a.e.b.f.p
        public void a(DownloadInfo downloadInfo) throws BaseException {
            d.o.a.a.a.a.l t = n.t();
            if (downloadInfo == null || t == null) {
                return;
            }
            String v0 = downloadInfo.v0();
            String K0 = downloadInfo.K0();
            File a2 = a(v0, K0);
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            t.a(v0, K0, a2, c2 != null ? d.o.a.d.n.k.n(c2.g()) : null);
            downloadInfo.M2("application/vnd.android.package-archive");
            downloadInfo.N2(a2.getName());
            downloadInfo.L2(null);
        }

        @Override // d.o.a.e.b.f.p
        public boolean b(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                return d.o.a.a.a.e.a.e(d.o.a.e.b.j.a.d(downloadInfo.c0()), downloadInfo.m0());
            }
            return false;
        }

        public final File a(String str, String str2) {
            File file = new File(str2);
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str = name.substring(0, lastIndexOf);
            }
            return new File(file.getParent(), str + ".apk");
        }
    }

    /* loaded from: classes6.dex */
    public class e implements d.i, o {

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo f2;
                int G0;
                c.g.e().q();
                for (d.o.a.b.a.c.b bVar : c.g.e().t().values()) {
                    int s = bVar.s();
                    if (s != 0) {
                        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(s);
                        if (d2.m("notification_opt_2") == 1 && (f2 = d.o.a.e.b.g.a.l(n.a()).f(s)) != null) {
                            if (d.o.a.d.n.k.D(bVar) && !d.o.a.d.n.k.H(bVar.e())) {
                                int G02 = f2.G0("restart_notify_open_app_count");
                                if (G02 < d2.b("noti_open_restart_times", 3)) {
                                    C1808i.a().l(bVar);
                                    f2.Z2("restart_notify_open_app_count", String.valueOf(G02 + 1));
                                }
                            } else if (f2.z0() == -2) {
                                int G03 = f2.G0("restart_notify_continue_count");
                                if (G03 < d2.b("noti_continue_restart_times", 3)) {
                                    C1808i.a().d(bVar);
                                    f2.Z2("restart_notify_continue_count", String.valueOf(G03 + 1));
                                }
                            } else if (f2.z0() == -3 && d.o.a.e.b.l.e.r0(f2) && !d.o.a.d.n.k.D(bVar) && (G0 = f2.G0("restart_notify_install_count")) < d2.b("noti_install_restart_times", 3)) {
                                C1808i.a().i(bVar);
                                f2.Z2("restart_notify_install_count", String.valueOf(G0 + 1));
                            }
                        }
                    }
                }
            }
        }

        @Override // d.o.a.e.b.f.o
        public void a() {
        }

        @Override // d.o.a.e.a.d.i
        public void a(DownloadInfo downloadInfo, boolean z) {
            if (downloadInfo == null) {
                return;
            }
            b(downloadInfo, downloadInfo.z0(), z);
        }

        @Override // d.o.a.e.a.d.i
        public void a(List<DownloadInfo> list) {
        }

        @WorkerThread
        public void b(DownloadInfo downloadInfo, int i2, boolean z) {
            c.g.e().q();
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                d.o.a.d.n.k.B();
                return;
            }
            try {
                if (z) {
                    c2.n0(downloadInfo.V());
                } else if (c2.y() == -1) {
                    return;
                } else {
                    c2.n0(-1);
                }
                c.j.b().c(c2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("download_id", downloadInfo.c0());
                jSONObject.put("name", downloadInfo.q0());
                jSONObject.put("url", downloadInfo.T0());
                jSONObject.put("download_time", downloadInfo.M());
                jSONObject.put("download_status", i2);
                jSONObject.put("cur_bytes", downloadInfo.E());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.Q0());
                int i3 = 1;
                jSONObject.put("only_wifi", downloadInfo.K1() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.B());
                if (!z) {
                    i3 = 2;
                }
                jSONObject.put("launch_resumed", i3);
                jSONObject.put("failed_resume_count", downloadInfo.V());
                j.c.a().r("embeded_ad", "download_uncompleted", jSONObject, c2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // d.o.a.e.b.f.o
        public void b() {
            i.a().c(new a(this), 5000L);
        }
    }
}
