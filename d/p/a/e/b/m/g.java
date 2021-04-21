package d.p.a.e.b.m;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes6.dex */
public class g implements d.p.a.e.b.o.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.g<String, OkHttpClient> f68293a = new com.ss.android.socialbase.downloader.i.g<>(4, 8);

    /* loaded from: classes6.dex */
    public class a extends d.p.a.e.b.o.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputStream f68294a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f68295b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Call f68296c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ResponseBody f68297d;

        public a(g gVar, InputStream inputStream, Response response, Call call, ResponseBody responseBody) {
            this.f68294a = inputStream;
            this.f68295b = response;
            this.f68296c = call;
            this.f68297d = responseBody;
        }

        @Override // d.p.a.e.b.o.k
        public InputStream a() throws IOException {
            return this.f68294a;
        }

        @Override // d.p.a.e.b.o.i
        public int b() throws IOException {
            return this.f68295b.code();
        }

        @Override // d.p.a.e.b.o.i
        public void c() {
            Call call = this.f68296c;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.f68296c.cancel();
        }

        @Override // d.p.a.e.b.o.k
        public void d() {
            try {
                if (this.f68297d != null) {
                    this.f68297d.close();
                }
                if (this.f68296c == null || this.f68296c.isCanceled()) {
                    return;
                }
                this.f68296c.cancel();
            } catch (Throwable unused) {
            }
        }

        @Override // d.p.a.e.b.o.c
        public String e() {
            return "";
        }

        @Override // d.p.a.e.b.o.i
        public String a(String str) {
            return this.f68295b.header(str);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Dns {
        public b(g gVar, String str, String str2) {
        }
    }

    public final OkHttpClient a(String str, String str2) {
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f68293a) {
                    OkHttpClient okHttpClient = this.f68293a.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder E0 = d.p.a.e.b.g.d.E0();
                    E0.dns(new b(this, host, str2));
                    OkHttpClient build = E0.build();
                    synchronized (this.f68293a) {
                        this.f68293a.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d.p.a.e.b.g.d.D0();
    }

    @Override // d.p.a.e.b.o.a
    public d.p.a.e.b.o.k downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        String str2;
        OkHttpClient D0;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                String a2 = cVar.a();
                if (str2 == null && "ss_d_request_host_ip_114".equals(a2)) {
                    str2 = cVar.b();
                } else {
                    url.addHeader(a2, d.p.a.e.b.l.e.K0(cVar.b()));
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            D0 = a(str, str2);
        } else {
            D0 = d.p.a.e.b.g.d.D0();
        }
        if (D0 != null) {
            Call newCall = D0.newCall(url.build());
            Response execute = newCall.execute();
            if (execute != null) {
                ResponseBody body = execute.body();
                if (body != null) {
                    InputStream byteStream = body.byteStream();
                    String header = execute.header("Content-Encoding");
                    return new a(this, (header == null || !AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream), execute, newCall, body);
                }
                return null;
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
