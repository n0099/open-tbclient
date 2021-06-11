package d.a.f0.a.h;

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
    public HttpURLConnection f43515a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.a.k.b f43516b;

    /* renamed from: c  reason: collision with root package name */
    public b f43517c;

    /* renamed from: d  reason: collision with root package name */
    public c f43518d;

    /* renamed from: e  reason: collision with root package name */
    public String f43519e;

    /* renamed from: f  reason: collision with root package name */
    public String f43520f;

    /* renamed from: g  reason: collision with root package name */
    public String f43521g;

    /* renamed from: h  reason: collision with root package name */
    public String f43522h;

    /* renamed from: i  reason: collision with root package name */
    public int f43523i;
    public int j;
    public boolean k;
    public Uri.Builder l;
    public int m;

    /* renamed from: d.a.f0.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0590a extends d.a.f0.a.l.b {
        public C0590a() {
        }

        @Override // d.a.f0.a.l.b
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
        this.f43518d = cVar;
    }

    public void d() {
        try {
            if (this.m == 1) {
                d.a.f0.a.l.c.a().c(new C0590a());
            } else {
                d.a.f0.a.l.c.a().c(new C0590a());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    public final void e() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f43515a.connect();
                d.a.f0.a.k.b bVar = this.f43516b;
                bVar.b(OAdURLConnection.TAG, this.f43515a.getRequestMethod() + " connect code :" + this.f43515a.getResponseCode());
                int responseCode = this.f43515a.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f43515a.setInstanceFollowRedirects(false);
                    HttpURLConnection g2 = g(this.f43515a);
                    this.f43515a = g2;
                    responseCode = g2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    if (this.f43517c != null) {
                        this.f43517c.onFail(this.f43515a.getResponseMessage(), responseCode);
                    }
                    if (this.f43518d != null) {
                        this.f43518d.onFail(this.f43515a.getResponseMessage(), responseCode);
                    }
                } else {
                    String a2 = d.a.f0.a.l.a.a(this.f43519e);
                    if (this.f43517c != null) {
                        this.f43517c.onSuccess(f(), a2);
                    }
                    if (this.f43518d != null) {
                        this.f43518d.onSuccess(this.f43515a.getInputStream(), a2);
                    }
                }
                httpURLConnection = this.f43515a;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                if (this.f43517c != null) {
                    b bVar2 = this.f43517c;
                    bVar2.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                if (this.f43518d != null) {
                    c cVar = this.f43518d;
                    cVar.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f43515a;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f43515a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String f() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = this.f43515a.getInputStream();
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
        if (TextUtils.isEmpty(this.f43519e)) {
            return;
        }
        try {
            HttpURLConnection b2 = d.a.f0.a.l.a.b(new URL(this.f43519e));
            this.f43515a = b2;
            b2.setConnectTimeout(this.f43523i);
            this.f43515a.setReadTimeout(this.j);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f43515a.setRequestMethod(this.f43520f);
            this.f43515a.setUseCaches(this.k);
            if (!TextUtils.isEmpty(this.f43521g)) {
                this.f43515a.setRequestProperty("User-Agent", this.f43521g);
            }
            this.f43515a.setRequestProperty("Content-type", this.f43522h);
            this.f43515a.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.f43515a.setRequestProperty("Cache-Control", "no-cache");
            if (this.f43520f.equals("POST")) {
                this.f43515a.setDoInput(true);
                this.f43515a.setDoOutput(true);
                if (this.l != null) {
                    h(this.l.build().getEncodedQuery(), this.f43515a);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            b bVar = this.f43517c;
            if (bVar != null) {
                bVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f43518d;
            if (cVar != null) {
                cVar.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            b bVar2 = this.f43517c;
            if (bVar2 != null) {
                bVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            c cVar2 = this.f43518d;
            if (cVar2 != null) {
                cVar2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public a(int i2, String str, String str2) {
        this.f43516b = d.a.f0.a.k.b.i();
        this.f43517c = null;
        this.f43518d = null;
        this.f43522h = "text/plain";
        this.f43523i = 10000;
        this.j = 10000;
        this.k = false;
        this.l = null;
        this.m = i2;
        this.f43519e = str;
        this.f43520f = str2;
    }
}
