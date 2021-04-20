package d.o.a.e.b.o.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.l;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerThread f68203a = new HandlerThread("Downloader-preconnecter");

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f68204b;

    /* renamed from: c  reason: collision with root package name */
    public static long f68205c;

    /* renamed from: d  reason: collision with root package name */
    public static long f68206d;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(10);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d.o.a.e.b.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC1888b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f68208f;

        public RunnableC1888b(String str, l lVar) {
            this.f68207e = str;
            this.f68208f = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f68207e)) {
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.c> d2 = b.d(0L, null, null);
                        r1 = d.o.a.e.b.o.b.a.a().e(this.f68207e) ? d.o.a.e.b.o.b.a.a().b(this.f68207e, d2) : null;
                        if (r1 == null) {
                            c cVar = new c(this.f68207e, d2, 0L);
                            try {
                                cVar.e();
                                if (cVar.h()) {
                                    d.o.a.e.b.o.b.a.a().d(this.f68207e, cVar);
                                }
                                r1 = cVar;
                            } catch (Exception e2) {
                                e = e2;
                                r1 = cVar;
                                e.printStackTrace();
                                r1.c();
                            } catch (Throwable th) {
                                th = th;
                                r1 = cVar;
                                try {
                                    r1.c();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> l = r1.l();
                        if (this.f68208f != null) {
                            this.f68208f.a(l);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    r1.c();
                } catch (Throwable unused2) {
                }
            } else {
                l lVar = this.f68208f;
                if (lVar != null) {
                    lVar.a(null);
                }
            }
        }
    }

    static {
        e();
        f68203a.start();
        Handler handler = new Handler(f68203a.getLooper());
        f68204b = handler;
        handler.post(new a());
    }

    public static Looper a() {
        return f68203a.getLooper();
    }

    public static void c(String str, l lVar) {
        f68204b.post(new RunnableC1888b(str, lVar));
    }

    public static List<com.ss.android.socialbase.downloader.model.c> d(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        return e.q(list, downloadInfo == null ? null : downloadInfo.U0(), j, 0L);
    }

    public static void e() {
        f68205c = d.o.a.e.b.j.a.r().c("preconnect_connection_outdate_time", 300000L);
        f68206d = d.o.a.e.b.j.a.r().c("preconnect_head_info_outdate_time", 300000L);
        d.o.a.e.b.o.b.a.a().c(d.o.a.e.b.j.a.r().b("preconnect_max_cache_size", 3));
    }
}
