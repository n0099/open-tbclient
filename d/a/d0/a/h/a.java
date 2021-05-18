package d.a.d0.a.h;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f39848a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d0.a.k.b f39849b;

    /* renamed from: c  reason: collision with root package name */
    public b f39850c;

    /* renamed from: d  reason: collision with root package name */
    public c f39851d;

    /* renamed from: e  reason: collision with root package name */
    public String f39852e;

    /* renamed from: f  reason: collision with root package name */
    public String f39853f;

    /* renamed from: g  reason: collision with root package name */
    public String f39854g;

    /* renamed from: h  reason: collision with root package name */
    public String f39855h;

    /* renamed from: i  reason: collision with root package name */
    public int f39856i;
    public int j;
    public boolean k;
    public Uri.Builder l;
    public int m;

    /* renamed from: d.a.d0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0528a extends d.a.d0.a.l.b {
        public C0528a() {
        }

        @Override // d.a.d0.a.l.b
        public Object b() {
            a.this.i();
            a.this.e();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onFail(String str, int i2);

        void onSuccess(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onFail(String str, int i2);

        void onSuccess(InputStream inputStream, String str);
    }

    public a(int i2, String str) {
        this(i2, str, "GET");
    }

    public void c(c cVar) {
        this.f39851d = cVar;
    }

    public void d() {
        try {
            if (this.m == 1) {
                d.a.d0.a.l.c.a().c(new C0528a());
            } else {
                d.a.d0.a.l.c.a().c(new C0528a());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    public final void e() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f39848a.connect();
                d.a.d0.a.k.b bVar = this.f39849b;
                bVar.b(OAdURLConnection.TAG, this.f39848a.getRequestMethod() + " connect code :" + this.f39848a.getResponseCode());
                int responseCode = this.f39848a.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f39848a.setInstanceFollowRedirects(false);
                    HttpURLConnection g2 = g(this.f39848a);
                    this.f39848a = g2;
                    responseCode = g2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    if (this.f39850c != null) {
                        this.f39850c.onFail(this.f39848a.getResponseMessage(), responseCode);
                    }
                    if (this.f39851d != null) {
                        this.f39851d.onFail(this.f39848a.getResponseMessage(), responseCode);
                    }
                } else {
                    String a2 = d.a.d0.a.l.a.a(this.f39852e);
                    if (this.f39850c != null) {
                        this.f39850c.onSuccess(f(), a2);
                    }
                    if (this.f39851d != null) {
                        this.f39851d.onSuccess(this.f39848a.getInputStream(), a2);
                    }
                }
                httpURLConnection = this.f39848a;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                if (this.f39850c != null) {
                    b bVar2 = this.f39850c;
                    bVar2.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                if (this.f39851d != null) {
                    c cVar = this.f39851d;
                    cVar.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f39848a;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f39848a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String f() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = this.f39848a.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public final HttpURLConnection g(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public final void h(String str, HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public final void i() {
        if (TextUtils.isEmpty(this.f39852e)) {
            return;
        }
        try {
            HttpURLConnection b2 = d.a.d0.a.l.a.b(new URL(this.f39852e));
            this.f39848a = b2;
            b2.setConnectTimeout(this.f39856i);
            this.f39848a.setReadTimeout(this.j);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f39848a.setRequestMethod(this.f39853f);
            this.f39848a.setUseCaches(this.k);
            if (!TextUtils.isEmpty(this.f39854g)) {
                this.f39848a.setRequestProperty("User-Agent", this.f39854g);
            }
            this.f39848a.setRequestProperty("Content-type", this.f39855h);
            this.f39848a.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.f39848a.setRequestProperty("Cache-Control", "no-cache");
            if (this.f39853f.equals("POST")) {
                this.f39848a.setDoInput(true);
                this.f39848a.setDoOutput(true);
                if (this.l != null) {
                    h(this.l.build().getEncodedQuery(), this.f39848a);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            b bVar = this.f39850c;
            if (bVar != null) {
                bVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f39851d;
            if (cVar != null) {
                cVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            b bVar2 = this.f39850c;
            if (bVar2 != null) {
                bVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            c cVar2 = this.f39851d;
            if (cVar2 != null) {
                cVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public a(int i2, String str, String str2) {
        this.f39849b = d.a.d0.a.k.b.i();
        this.f39850c = null;
        this.f39851d = null;
        this.f39855h = "text/plain";
        this.f39856i = 10000;
        this.j = 10000;
        this.k = false;
        this.l = null;
        this.m = i2;
        this.f39852e = str;
        this.f39853f = str2;
    }
}
