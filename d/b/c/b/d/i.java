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
    public final Executor f65780a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f65781b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.c.c f65782c = d.b.c.b.c.f.a();

    /* loaded from: classes6.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65783e;

        public a(i iVar, Handler handler) {
            this.f65783e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f65783e.post(runnable);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f65784e;

        /* renamed from: f  reason: collision with root package name */
        public final o f65785f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f65786g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f65784e = request;
            this.f65785f = oVar;
            this.f65786g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f65784e.isCanceled()) {
                this.f65784e.a("canceled-at-delivery");
                return;
            }
            this.f65785f.f65815g = this.f65784e.getExtra();
            this.f65785f.a(SystemClock.elapsedRealtime() - this.f65784e.getStartTime());
            this.f65785f.g(this.f65784e.getNetDuration());
            try {
                if (this.f65785f.f()) {
                    this.f65784e.a(this.f65785f);
                } else {
                    this.f65784e.deliverError(this.f65785f);
                }
            } catch (Throwable unused) {
            }
            if (this.f65785f.f65812d) {
                this.f65784e.addMarker("intermediate-response");
            } else {
                this.f65784e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f65786g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f65780a = new a(this, handler);
    }

    @Override // d.b.c.b.f.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.b.c.b.c.c cVar = this.f65782c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        d.b.c.b.c.c cVar = this.f65782c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void c(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.b.c.b.c.c cVar = this.f65782c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f65780a : this.f65781b;
    }
}
