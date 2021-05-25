package d.a.l0.h.y.d;

import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.n1.e;
import d.a.l0.a.n1.h;
import d.a.l0.a.n1.o.a;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public a.b f47743a;

    /* renamed from: b  reason: collision with root package name */
    public final e f47744b = new a();

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.l0.a.n1.e
        public void a(long j, long j2, boolean z) {
            if (d.this.f47743a == null) {
                if (k.f43199a) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.f47743a.b(0, j, j2);
            } else if (j2 > 52428800) {
                d.this.f47743a.a(j2);
                d.this.f47743a = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.f47743a.c(j, j2);
                d.this.f47743a = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.f47743a.b(floor, j, j2);
                }
            }
        }
    }

    public void c(a.b bVar) {
        this.f47743a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f47744b)).build();
    }
}
