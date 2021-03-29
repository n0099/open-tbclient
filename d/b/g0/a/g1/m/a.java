package d.b.g0.a.g1.m;

import d.b.g0.a.g1.e;
import d.b.g0.a.g1.h;
import d.b.g0.a.k;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public b f44550a;

    /* renamed from: b  reason: collision with root package name */
    public final e f44551b = new C0694a();

    /* renamed from: d.b.g0.a.g1.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0694a implements e {
        public C0694a() {
        }

        @Override // d.b.g0.a.g1.e
        public void a(long j, long j2, boolean z) {
            if (a.this.f44550a == null) {
                if (k.f45051a) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.f44550a.b(0, j, j2);
            } else if (j2 > 52428800) {
                a.this.f44550a.a(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.f44550a.c(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    a.this.f44550a.b(floor, j, j2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(long j);

        void b(int i, long j, long j2);

        void c(long j, long j2);
    }

    public void b(b bVar) {
        this.f44550a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f44551b)).build();
    }
}
