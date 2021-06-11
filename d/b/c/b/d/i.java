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
    public final Executor f69511a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f69512b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.c.c f69513c = d.b.c.b.c.f.a();

    /* loaded from: classes6.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f69514e;

        public a(i iVar, Handler handler) {
            this.f69514e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f69514e.post(runnable);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f69515e;

        /* renamed from: f  reason: collision with root package name */
        public final o f69516f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f69517g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f69515e = request;
            this.f69516f = oVar;
            this.f69517g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f69515e.isCanceled()) {
                this.f69515e.a("canceled-at-delivery");
                return;
            }
            this.f69516f.f69546g = this.f69515e.getExtra();
            this.f69516f.a(SystemClock.elapsedRealtime() - this.f69515e.getStartTime());
            this.f69516f.g(this.f69515e.getNetDuration());
            try {
                if (this.f69516f.f()) {
                    this.f69515e.a(this.f69516f);
                } else {
                    this.f69515e.deliverError(this.f69516f);
                }
            } catch (Throwable unused) {
            }
            if (this.f69516f.f69543d) {
                this.f69515e.addMarker("intermediate-response");
            } else {
                this.f69515e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f69517g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f69511a = new a(this, handler);
    }

    @Override // d.b.c.b.f.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.b.c.b.c.c cVar = this.f69513c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        d.b.c.b.c.c cVar = this.f69513c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void c(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.b.c.b.c.c cVar = this.f69513c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f69511a : this.f69512b;
    }
}
