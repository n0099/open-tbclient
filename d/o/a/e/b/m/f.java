package d.o.a.e.b.m;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class f implements d.o.a.e.b.o.j {

    /* loaded from: classes6.dex */
    public class a implements d.o.a.e.b.o.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Response f68144a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Call f68145b;

        public a(f fVar, Response response, Call call) {
            this.f68144a = response;
            this.f68145b = call;
        }

        @Override // d.o.a.e.b.o.i
        public String a(String str) {
            return this.f68144a.header(str);
        }

        @Override // d.o.a.e.b.o.i
        public int b() throws IOException {
            return this.f68144a.code();
        }

        @Override // d.o.a.e.b.o.i
        public void c() {
            Call call = this.f68145b;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.f68145b.cancel();
        }
    }

    @Override // d.o.a.e.b.o.j
    public d.o.a.e.b.o.i a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        OkHttpClient D0 = d.o.a.e.b.g.d.D0();
        if (D0 != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    head.addHeader(cVar.a(), d.o.a.e.b.l.e.K0(cVar.b()));
                }
            }
            Call newCall = D0.newCall(head.build());
            Response execute = newCall.execute();
            if (execute != null) {
                if (d.o.a.e.b.l.a.a(2097152)) {
                    execute.close();
                }
                return new a(this, execute, newCall);
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
