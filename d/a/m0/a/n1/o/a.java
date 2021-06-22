package d.a.m0.a.n1.o;

import d.a.m0.a.k;
import d.a.m0.a.n1.e;
import d.a.m0.a.n1.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public b f47513a;

    /* renamed from: b  reason: collision with root package name */
    public final e f47514b = new C0823a();

    /* renamed from: d.a.m0.a.n1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0823a implements e {
        public C0823a() {
        }

        @Override // d.a.m0.a.n1.e
        public void a(long j, long j2, boolean z) {
            if (a.this.f47513a == null) {
                if (k.f46983a) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.f47513a.b(0, j, j2);
            } else if (j2 > 52428800) {
                a.this.f47513a.a(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.f47513a.c(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    a.this.f47513a.b(floor, j, j2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j);

        void b(int i2, long j, long j2);

        void c(long j, long j2);
    }

    public void b(b bVar) {
        this.f47513a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f47514b)).build();
    }
}
