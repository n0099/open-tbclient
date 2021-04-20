package d.b.g0.g.w.e;

import android.util.Log;
import d.b.g0.a.g1.e;
import d.b.g0.a.g1.h;
import d.b.g0.a.g1.m.a;
import d.b.g0.a.k;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public a.b f49000a;

    /* renamed from: b  reason: collision with root package name */
    public final e f49001b = new a();

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.b.g0.a.g1.e
        public void a(long j, long j2, boolean z) {
            if (d.this.f49000a == null) {
                if (k.f45443a) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.f49000a.b(0, j, j2);
            } else if (j2 > 52428800) {
                d.this.f49000a.a(j2);
                d.this.f49000a = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.f49000a.c(j, j2);
                d.this.f49000a = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.f49000a.b(floor, j, j2);
                }
            }
        }
    }

    public void c(a.b bVar) {
        this.f49000a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f49001b)).build();
    }
}
