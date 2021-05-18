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
    public final Executor f65737a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f65738b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.c.c f65739c = d.b.c.b.c.f.a();

    /* loaded from: classes6.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65740e;

        public a(i iVar, Handler handler) {
            this.f65740e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f65740e.post(runnable);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f65741e;

        /* renamed from: f  reason: collision with root package name */
        public final o f65742f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f65743g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f65741e = request;
            this.f65742f = oVar;
            this.f65743g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f65741e.isCanceled()) {
                this.f65741e.a("canceled-at-delivery");
                return;
            }
            this.f65742f.f65772g = this.f65741e.getExtra();
            this.f65742f.a(SystemClock.elapsedRealtime() - this.f65741e.getStartTime());
            this.f65742f.g(this.f65741e.getNetDuration());
            try {
                if (this.f65742f.f()) {
                    this.f65741e.a(this.f65742f);
                } else {
                    this.f65741e.deliverError(this.f65742f);
                }
            } catch (Throwable unused) {
            }
            if (this.f65742f.f65769d) {
                this.f65741e.addMarker("intermediate-response");
            } else {
                this.f65741e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f65743g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f65737a = new a(this, handler);
    }

    @Override // d.b.c.b.f.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.b.c.b.c.c cVar = this.f65739c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        d.b.c.b.c.c cVar = this.f65739c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void c(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.b.c.b.c.c cVar = this.f65739c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f65737a : this.f65738b;
    }
}
