package d.a.h0.g.w.e;

import android.util.Log;
import d.a.h0.a.g1.e;
import d.a.h0.a.g1.h;
import d.a.h0.a.g1.m.a;
import d.a.h0.a.k;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public a.b f46825a;

    /* renamed from: b  reason: collision with root package name */
    public final e f46826b = new a();

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.h0.a.g1.e
        public void a(long j, long j2, boolean z) {
            if (d.this.f46825a == null) {
                if (k.f43101a) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.f46825a.b(0, j, j2);
            } else if (j2 > 52428800) {
                d.this.f46825a.a(j2);
                d.this.f46825a = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.f46825a.c(j, j2);
                d.this.f46825a = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.f46825a.b(floor, j, j2);
                }
            }
        }
    }

    public void c(a.b bVar) {
        this.f46825a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f46826b)).build();
    }
}
