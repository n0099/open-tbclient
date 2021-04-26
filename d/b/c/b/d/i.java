package d.b.c.b.d;

import android.os.Handler;
import android.os.SystemClock;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class i implements d.b.c.b.f.d {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f65051a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f65052b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.c.c f65053c = d.b.c.b.c.f.a();

    /* loaded from: classes5.dex */
    public class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65054e;

        public a(i iVar, Handler handler) {
            this.f65054e = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f65054e.post(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Request f65055e;

        /* renamed from: f  reason: collision with root package name */
        public final o f65056f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f65057g;

        public b(Request request, o oVar, Runnable runnable) {
            this.f65055e = request;
            this.f65056f = oVar;
            this.f65057g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f65055e.isCanceled()) {
                this.f65055e.a("canceled-at-delivery");
                return;
            }
            this.f65056f.f65086g = this.f65055e.getExtra();
            this.f65056f.a(SystemClock.elapsedRealtime() - this.f65055e.getStartTime());
            this.f65056f.g(this.f65055e.getNetDuration());
            try {
                if (this.f65056f.f()) {
                    this.f65055e.a(this.f65056f);
                } else {
                    this.f65055e.deliverError(this.f65056f);
                }
            } catch (Throwable unused) {
            }
            if (this.f65056f.f65083d) {
                this.f65055e.addMarker("intermediate-response");
            } else {
                this.f65055e.a(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f65057g;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public i(Handler handler) {
        this.f65051a = new a(this, handler);
    }

    @Override // d.b.c.b.f.d
    public void a(Request<?> request, o<?> oVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        d(request).execute(new b(request, oVar, runnable));
        d.b.c.b.c.c cVar = this.f65053c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void b(Request<?> request, o<?> oVar) {
        a(request, oVar, null);
        d.b.c.b.c.c cVar = this.f65053c;
        if (cVar != null) {
            cVar.b(request, oVar);
        }
    }

    @Override // d.b.c.b.f.d
    public void c(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        d(request).execute(new b(request, o.b(vAdError), null));
        d.b.c.b.c.c cVar = this.f65053c;
        if (cVar != null) {
            cVar.c(request, vAdError);
        }
    }

    public final Executor d(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f65051a : this.f65052b;
    }
}
