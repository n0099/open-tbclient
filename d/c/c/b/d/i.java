package d.c.c.b.d;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class i implements d.c.c.b.f.d {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f66557a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f66558b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.c.c f66559c = d.c.c.b.c.f.a();

    /* loaded from: classes5.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f66560e;

        public a(i iVar, Handler handler) {
            this.f66560e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f66560e.post(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f66561e;

        /* renamed from: f  reason: collision with root package name */
        public final o f66562f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f66563g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f66561e = request;
            this.f66562f = oVar;
            this.f66563g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f66561e.isCanceled()) {
                this.f66561e.a("canceled-at-delivery");
                return;
            }
            this.f66562f.f66590g = this.f66561e.getExtra();
            this.f66562f.a(SystemClock.elapsedRealtime() - this.f66561e.getStartTime());
            this.f66562f.g(this.f66561e.getNetDuration());
            try {
                if (this.f66562f.f()) {
                    this.f66561e.a(this.f66562f);
                } else {
                    this.f66561e.deliverError(this.f66562f);
                }
            } catch (Throwable unused) {
            }
            if (this.f66562f.f66587d) {
                this.f66561e.addMarker("intermediate-response");
            } else {
                this.f66561e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f66563g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f66557a = new a(this, handler);
    }

    @Override // d.c.c.b.f.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.c.c.b.c.c cVar = this.f66559c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    @Override // d.c.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        c(request, oVar, null);
        d.c.c.b.c.c cVar = this.f66559c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.c.c.b.f.d
    public void c(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.c.c.b.c.c cVar = this.f66559c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f66557a : this.f66558b;
    }
}
