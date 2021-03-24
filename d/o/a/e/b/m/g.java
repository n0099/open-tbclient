package d.o.a.e.b.m;

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
/* loaded from: classes7.dex */
public class g implements d.o.a.e.b.o.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.g<String, OkHttpClient> f67148a = new com.ss.android.socialbase.downloader.i.g<>(4, 8);

    /* loaded from: classes7.dex */
    public class a extends d.o.a.e.b.o.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputStream f67149a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f67150b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Call f67151c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ResponseBody f67152d;

        public a(g gVar, InputStream inputStream, Response response, Call call, ResponseBody responseBody) {
            this.f67149a = inputStream;
            this.f67150b = response;
            this.f67151c = call;
            this.f67152d = responseBody;
        }

        @Override // d.o.a.e.b.o.k
        public InputStream a() throws IOException {
            return this.f67149a;
        }

        @Override // d.o.a.e.b.o.i
        public int b() throws IOException {
            return this.f67150b.code();
        }

        @Override // d.o.a.e.b.o.i
        public void c() {
            Call call = this.f67151c;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.f67151c.cancel();
        }

        @Override // d.o.a.e.b.o.k
        public void d() {
            try {
                if (this.f67152d != null) {
                    this.f67152d.close();
                }
                if (this.f67151c == null || this.f67151c.isCanceled()) {
                    return;
                }
                this.f67151c.cancel();
            } catch (Throwable unused) {
            }
        }

        @Override // d.o.a.e.b.o.c
        public String e() {
            return "";
        }

        @Override // d.o.a.e.b.o.i
        public String a(String str) {
            return this.f67150b.header(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Dns {
        public b(g gVar, String str, String str2) {
        }
    }

    public final OkHttpClient a(String str, String str2) {
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.f67148a) {
                    OkHttpClient okHttpClient = this.f67148a.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder E0 = d.o.a.e.b.g.d.E0();
                    E0.dns(new b(this, host, str2));
                    OkHttpClient build = E0.build();
                    synchronized (this.f67148a) {
                        this.f67148a.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d.o.a.e.b.g.d.D0();
    }

    @Override // d.o.a.e.b.o.a
    public d.o.a.e.b.o.k downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
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
                    url.addHeader(a2, d.o.a.e.b.l.e.K0(cVar.b()));
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            D0 = a(str, str2);
        } else {
            D0 = d.o.a.e.b.g.d.D0();
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
