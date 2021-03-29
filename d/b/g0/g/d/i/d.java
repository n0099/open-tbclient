package d.b.g0.g.d.i;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.a.i2.p;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48079a;

        /* renamed from: d.b.g0.g.d.i.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0960a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f48080e;

            public RunnableC0960a(byte[] bArr) {
                this.f48080e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f48079a;
                if (bVar != null) {
                    bVar.a(true, this.f48080e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f48079a;
                if (bVar != null) {
                    bVar.a(false, null);
                }
            }
        }

        public a(d dVar, b bVar) {
            this.f48079a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(byte[] bArr, int i) {
            p.l(new RunnableC0960a(bArr), "HandshakeRequest");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            p.l(new b(), "HandshakeRequest");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public byte[] parseResponse(Response response, int i) throws Exception {
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
        d.b.g0.k.e.a.f().postByteRequest().url("https://mbd.baidu.com/bdtls").cookieManager(d.b.g0.a.w0.a.m().a()).headers(hashMap).content(bArr).build().executeAsync(new a(this, bVar));
    }
}
