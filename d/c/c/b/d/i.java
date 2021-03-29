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
    public final Executor f65712a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f65713b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.c.c f65714c = d.c.c.b.c.f.a();

    /* loaded from: classes5.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65715e;

        public a(i iVar, Handler handler) {
            this.f65715e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f65715e.post(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f65716e;

        /* renamed from: f  reason: collision with root package name */
        public final o f65717f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f65718g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f65716e = request;
            this.f65717f = oVar;
            this.f65718g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f65716e.isCanceled()) {
                this.f65716e.a("canceled-at-delivery");
                return;
            }
            this.f65717f.f65745g = this.f65716e.getExtra();
            this.f65717f.a(SystemClock.elapsedRealtime() - this.f65716e.getStartTime());
            this.f65717f.g(this.f65716e.getNetDuration());
            try {
                if (this.f65717f.f()) {
                    this.f65716e.a(this.f65717f);
                } else {
                    this.f65716e.deliverError(this.f65717f);
                }
            } catch (Throwable unused) {
            }
            if (this.f65717f.f65742d) {
                this.f65716e.addMarker("intermediate-response");
            } else {
                this.f65716e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f65718g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f65712a = new a(this, handler);
    }

    @Override // d.c.c.b.f.d
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.c.c.b.c.c cVar = this.f65714c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    @Override // d.c.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        c(request, oVar, null);
        d.c.c.b.c.c cVar = this.f65714c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.c.c.b.f.d
    public void c(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.c.c.b.c.c cVar = this.f65714c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f65712a : this.f65713b;
    }
}
