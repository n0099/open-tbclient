package d.a.m0.c.a.k;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.m0.a.v2.q;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50296a;

        /* renamed from: d.a.m0.c.a.k.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1021a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f50297e;

            public RunnableC1021a(byte[] bArr) {
                this.f50297e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f50296a;
                if (bVar != null) {
                    bVar.a(true, this.f50297e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f50296a;
                if (bVar != null) {
                    bVar.a(false, null);
                }
            }
        }

        public a(e eVar, b bVar) {
            this.f50296a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(byte[] bArr, int i2) {
            q.k(new RunnableC1021a(bArr), "HandshakeRequest");
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
        d.a.m0.m.e.a.g().postByteRequest().url(d.a.m0.c.a.b.f50233b).cookieManager(d.a.m0.a.c1.a.p().a()).headers(hashMap).content(bArr).build().executeAsync(new a(this, bVar));
    }
}
