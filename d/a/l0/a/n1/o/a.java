package d.a.l0.a.n1.o;

import d.a.l0.a.k;
import d.a.l0.a.n1.e;
import d.a.l0.a.n1.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public b f43729a;

    /* renamed from: b  reason: collision with root package name */
    public final e f43730b = new C0764a();

    /* renamed from: d.a.l0.a.n1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0764a implements e {
        public C0764a() {
        }

        @Override // d.a.l0.a.n1.e
        public void a(long j, long j2, boolean z) {
            if (a.this.f43729a == null) {
                if (k.f43199a) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.f43729a.b(0, j, j2);
            } else if (j2 > 52428800) {
                a.this.f43729a.a(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.f43729a.c(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    a.this.f43729a.b(floor, j, j2);
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
        this.f43729a = bVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.f43730b)).build();
    }
}
