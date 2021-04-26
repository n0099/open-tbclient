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
    public HttpURLConnection f40603a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d0.a.k.b f40604b;

    /* renamed from: c  reason: collision with root package name */
    public b f40605c;

    /* renamed from: d  reason: collision with root package name */
    public c f40606d;

    /* renamed from: e  reason: collision with root package name */
    public String f40607e;

    /* renamed from: f  reason: collision with root package name */
    public String f40608f;

    /* renamed from: g  reason: collision with root package name */
    public String f40609g;

    /* renamed from: h  reason: collision with root package name */
    public String f40610h;

    /* renamed from: i  reason: collision with root package name */
    public int f40611i;
    public int j;
    public boolean k;
    public Uri.Builder l;
    public int m;

    /* renamed from: d.a.d0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0541a extends d.a.d0.a.l.b {
        public C0541a() {
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
        this.f40606d = cVar;
    }

    public void d() {
        try {
            if (this.m == 1) {
                d.a.d0.a.l.c.a().c(new C0541a());
            } else {
                d.a.d0.a.l.c.a().c(new C0541a());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    public final void e() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f40603a.connect();
                d.a.d0.a.k.b bVar = this.f40604b;
                bVar.b(OAdURLConnection.TAG, this.f40603a.getRequestMethod() + " connect code :" + this.f40603a.getResponseCode());
                int responseCode = this.f40603a.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f40603a.setInstanceFollowRedirects(false);
                    HttpURLConnection g2 = g(this.f40603a);
                    this.f40603a = g2;
                    responseCode = g2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    if (this.f40605c != null) {
                        this.f40605c.onFail(this.f40603a.getResponseMessage(), responseCode);
                    }
                    if (this.f40606d != null) {
                        this.f40606d.onFail(this.f40603a.getResponseMessage(), responseCode);
                    }
                } else {
                    String a2 = d.a.d0.a.l.a.a(this.f40607e);
                    if (this.f40605c != null) {
                        this.f40605c.onSuccess(f(), a2);
                    }
                    if (this.f40606d != null) {
                        this.f40606d.onSuccess(this.f40603a.getInputStream(), a2);
                    }
                }
                httpURLConnection = this.f40603a;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                if (this.f40605c != null) {
                    b bVar2 = this.f40605c;
                    bVar2.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                if (this.f40606d != null) {
                    c cVar = this.f40606d;
                    cVar.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f40603a;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f40603a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String f() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = this.f40603a.getInputStream();
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
        if (TextUtils.isEmpty(this.f40607e)) {
            return;
        }
        try {
            HttpURLConnection b2 = d.a.d0.a.l.a.b(new URL(this.f40607e));
            this.f40603a = b2;
            b2.setConnectTimeout(this.f40611i);
            this.f40603a.setReadTimeout(this.j);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f40603a.setRequestMethod(this.f40608f);
            this.f40603a.setUseCaches(this.k);
            if (!TextUtils.isEmpty(this.f40609g)) {
                this.f40603a.setRequestProperty("User-Agent", this.f40609g);
            }
            this.f40603a.setRequestProperty("Content-type", this.f40610h);
            this.f40603a.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.f40603a.setRequestProperty("Cache-Control", "no-cache");
            if (this.f40608f.equals("POST")) {
                this.f40603a.setDoInput(true);
                this.f40603a.setDoOutput(true);
                if (this.l != null) {
                    h(this.l.build().getEncodedQuery(), this.f40603a);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            b bVar = this.f40605c;
            if (bVar != null) {
                bVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f40606d;
            if (cVar != null) {
                cVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            b bVar2 = this.f40605c;
            if (bVar2 != null) {
                bVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            c cVar2 = this.f40606d;
            if (cVar2 != null) {
                cVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public a(int i2, String str, String str2) {
        this.f40604b = d.a.d0.a.k.b.i();
        this.f40605c = null;
        this.f40606d = null;
        this.f40610h = "text/plain";
        this.f40611i = 10000;
        this.j = 10000;
        this.k = false;
        this.l = null;
        this.m = i2;
        this.f40607e = str;
        this.f40608f = str2;
    }
}
