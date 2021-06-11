package d.a.l0.c.a.k;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.l0.a.v2.q;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50188a;

        /* renamed from: d.a.l0.c.a.k.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1018a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f50189e;

            public RunnableC1018a(byte[] bArr) {
                this.f50189e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f50188a;
                if (bVar != null) {
                    bVar.a(true, this.f50189e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f50188a;
                if (bVar != null) {
                    bVar.a(false, null);
                }
            }
        }

        public a(e eVar, b bVar) {
            this.f50188a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(byte[] bArr, int i2) {
            q.k(new RunnableC1018a(bArr), "HandshakeRequest");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            q.k(new b(), "HandshakeRequest");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public byte[] parseResponse(Response response, int i2) throws Exception {
            return response.body().bytes();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, byte[] bArr);
    }

    public void a(byte[] bArr, b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("Bdtls", "Bdtls");
        d.a.l0.m.e.a.g().postByteRequest().url(d.a.l0.c.a.b.f50125b).cookieManager(d.a.l0.a.c1.a.p().a()).headers(hashMap).content(bArr).build().executeAsync(new a(this, bVar));
    }
}
