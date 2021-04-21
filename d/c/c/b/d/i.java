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
    public final Executor f66652a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f66653b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.c.c f66654c = d.c.c.b.c.f.a();

    /* loaded from: classes5.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f66655e;

        public a(i iVar, Handler handler) {
            this.f66655e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f66655e.post(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f66656e;

        /* renamed from: f  reason: collision with root package name */
        public final o f66657f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f66658g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f66656e = request;
            this.f66657f = oVar;
            this.f66658g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f66656e.isCanceled()) {
                this.f66656e.a("canceled-at-delivery");
                return;
            }
            this.f66657f.f66685g = this.f66656e.getExtra();
            this.f66657f.a(SystemClock.elapsedRealtime() - this.f66656e.getStartTime());
            this.f66657f.g(this.f66656e.getNetDuration());
            try {
                if (this.f66657f.f()) {
                    this.f66656e.a(this.f66657f);
                } else {
                    this.f66656e.deliverError(this.f66657f);
                }
            } catch (Throwable unused) {
            }
            if (this.f66657f.f66682d) {
                this.f66656e.addMarker("intermediate-response");
            } else {
                this.f66656e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f66658g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f66652a = new a(this, handler);
    }

    @Override // d.c.c.b.f.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.c.c.b.c.c cVar = this.f66654c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    @Override // d.c.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        c(request, oVar, null);
        d.c.c.b.c.c cVar = this.f66654c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.c.c.b.f.d
    public void c(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.c.c.b.c.c cVar = this.f66654c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f66652a : this.f66653b;
    }
}
