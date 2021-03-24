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
    public final Executor f65711a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f65712b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.c.c f65713c = d.c.c.b.c.f.a();

    /* loaded from: classes5.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65714e;

        public a(i iVar, Handler handler) {
            this.f65714e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f65714e.post(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f65715e;

        /* renamed from: f  reason: collision with root package name */
        public final o f65716f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f65717g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f65715e = request;
            this.f65716f = oVar;
            this.f65717g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f65715e.isCanceled()) {
                this.f65715e.a("canceled-at-delivery");
                return;
            }
            this.f65716f.f65744g = this.f65715e.getExtra();
            this.f65716f.a(SystemClock.elapsedRealtime() - this.f65715e.getStartTime());
            this.f65716f.g(this.f65715e.getNetDuration());
            try {
                if (this.f65716f.f()) {
                    this.f65715e.a(this.f65716f);
                } else {
                    this.f65715e.deliverError(this.f65716f);
                }
            } catch (Throwable unused) {
            }
            if (this.f65716f.f65741d) {
                this.f65715e.addMarker("intermediate-response");
            } else {
                this.f65715e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f65717g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f65711a = new a(this, handler);
    }

    @Override // d.c.c.b.f.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.c.c.b.c.c cVar = this.f65713c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    @Override // d.c.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        c(request, oVar, null);
        d.c.c.b.c.c cVar = this.f65713c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.c.c.b.f.d
    public void c(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.c.c.b.c.c cVar = this.f65713c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f65711a : this.f65712b;
    }
}
