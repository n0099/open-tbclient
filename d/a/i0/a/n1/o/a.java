package d.a.i0.a.n1.o;

import d.a.i0.a.k;
import d.a.i0.a.n1.e;
import d.a.i0.a.n1.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public b f43555a;

    /* renamed from: b  reason: collision with root package name */
    public final e f43556b = new C0753a();

    /* renamed from: d.a.i0.a.n1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0753a implements e {
        public C0753a() {
        }

        @Override // d.a.i0.a.n1.e
        public void a(long j, long j2, boolean z) {
            if (a.this.f43555a == null) {
                if (k.f43025a) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.f43555a.b(0, j, j2);
            } else if (j2 > 52428800) {
                a.this.f43555a.a(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.f43555a.c(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    a.this.f43555a.b(floor, j, j2);
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
        this.f43555a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f43556b)).build();
    }
}
