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
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerThread f67210a = new HandlerThread("Downloader-preconnecter");

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f67211b;

    /* renamed from: c  reason: collision with root package name */
    public static long f67212c;

    /* renamed from: d  reason: collision with root package name */
    public static long f67213d;

    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class RunnableC1853b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f67215f;

        public RunnableC1853b(String str, l lVar) {
            this.f67214e = str;
            this.f67215f = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f67214e)) {
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.c> d2 = b.d(0L, null, null);
                        r1 = d.o.a.e.b.o.b.a.a().e(this.f67214e) ? d.o.a.e.b.o.b.a.a().b(this.f67214e, d2) : null;
                        if (r1 == null) {
                            c cVar = new c(this.f67214e, d2, 0L);
                            try {
                                cVar.e();
                                if (cVar.h()) {
                                    d.o.a.e.b.o.b.a.a().d(this.f67214e, cVar);
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
                        if (this.f67215f != null) {
                            this.f67215f.a(l);
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
                l lVar = this.f67215f;
                if (lVar != null) {
                    lVar.a(null);
                }
            }
        }
    }

    static {
        e();
        f67210a.start();
        Handler handler = new Handler(f67210a.getLooper());
        f67211b = handler;
        handler.post(new a());
    }

    public static Looper a() {
        return f67210a.getLooper();
    }

    public static void c(String str, l lVar) {
        f67211b.post(new RunnableC1853b(str, lVar));
    }

    public static List<com.ss.android.socialbase.downloader.model.c> d(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        return e.q(list, downloadInfo == null ? null : downloadInfo.U0(), j, 0L);
    }

    public static void e() {
        f67212c = d.o.a.e.b.j.a.r().c("preconnect_connection_outdate_time", 300000L);
        f67213d = d.o.a.e.b.j.a.r().c("preconnect_head_info_outdate_time", 300000L);
        d.o.a.e.b.o.b.a.a().c(d.o.a.e.b.j.a.r().b("preconnect_max_cache_size", 3));
    }
}
