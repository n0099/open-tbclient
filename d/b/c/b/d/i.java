package d.b.c.b.d;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class i implements d.b.c.b.f.d {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f69615a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f69616b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.c.c f69617c = d.b.c.b.c.f.a();

    /* loaded from: classes6.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f69618e;

        public a(i iVar, Handler handler) {
            this.f69618e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f69618e.post(runnable);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f69619e;

        /* renamed from: f  reason: collision with root package name */
        public final o f69620f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f69621g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f69619e = request;
            this.f69620f = oVar;
            this.f69621g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f69619e.isCanceled()) {
                this.f69619e.a("canceled-at-delivery");
                return;
            }
            this.f69620f.f69650g = this.f69619e.getExtra();
            this.f69620f.a(SystemClock.elapsedRealtime() - this.f69619e.getStartTime());
            this.f69620f.g(this.f69619e.getNetDuration());
            try {
                if (this.f69620f.f()) {
                    this.f69619e.a(this.f69620f);
                } else {
                    this.f69619e.deliverError(this.f69620f);
                }
            } catch (Throwable unused) {
            }
            if (this.f69620f.f69647d) {
                this.f69619e.addMarker("intermediate-response");
            } else {
                this.f69619e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f69621g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f69615a = new a(this, handler);
    }

    @Override // d.b.c.b.f.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.b.c.b.c.c cVar = this.f69617c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        d.b.c.b.c.c cVar = this.f69617c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void c(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.b.c.b.c.c cVar = this.f69617c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f69615a : this.f69616b;
    }
}
