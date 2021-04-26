package d.a.h0.g.d.i;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.a.i2.p;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46270a;

        /* renamed from: d.a.h0.g.d.i.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0931a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f46271e;

            public RunnableC0931a(byte[] bArr) {
                this.f46271e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f46270a;
                if (bVar != null) {
                    bVar.a(true, this.f46271e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = a.this.f46270a;
                if (bVar != null) {
                    bVar.a(false, null);
                }
            }
        }

        public a(d dVar, b bVar) {
            this.f46270a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(byte[] bArr, int i2) {
            p.l(new RunnableC0931a(bArr), "HandshakeRequest");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            p.l(new b(), "HandshakeRequest");
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
        d.a.h0.k.e.a.f().postByteRequest().url("https://mbd.baidu.com/bdtls").cookieManager(d.a.h0.a.w0.a.m().a()).headers(hashMap).content(bArr).build().executeAsync(new a(this, bVar));
    }
}
