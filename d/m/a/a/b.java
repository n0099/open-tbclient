package d.m.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidubce.AbstractBceClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f65740a;

    /* renamed from: b  reason: collision with root package name */
    public String f65741b;

    /* renamed from: d  reason: collision with root package name */
    public int f65743d;

    /* renamed from: e  reason: collision with root package name */
    public int f65744e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f65745f;
    public HandlerThread m;
    public Handler n;

    /* renamed from: c  reason: collision with root package name */
    public String f65742c = "";

    /* renamed from: g  reason: collision with root package name */
    public int f65746g = -1;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f65747h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f65748i = 10000;
    public int j = 1;
    public int k = 0;
    public boolean l = false;
    public boolean o = false;
    public HttpURLConnection p = null;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (b.this.k >= b.this.j) {
                b.this.l = false;
                b.this.k = 0;
                b.this.m.quit();
                return false;
            } else if (!b.this.e()) {
                b.this.n.sendEmptyMessageDelayed(1, b.this.f65748i * 1);
                b.p(b.this);
                return false;
            } else {
                b.this.l = false;
                b.this.k = 0;
                b.this.m.quit();
                return true;
            }
        }
    }

    public b(Context context, String str) {
        str = (str == null || str.length() <= 0) ? "" : "";
        this.f65740a = context;
        this.f65741b = str;
    }

    public static /* synthetic */ int p(b bVar) {
        int i2 = bVar.k;
        bVar.k = i2 + 1;
        return i2;
    }

    public final void c(int i2) {
        String str = "GET";
        switch (i2) {
            case 1:
                str = "POST";
                break;
            case 3:
                str = HttpPut.METHOD_NAME;
                break;
            case 4:
                str = HttpDelete.METHOD_NAME;
                break;
            case 5:
                str = "HEAD";
                break;
            case 6:
                str = HttpTrace.METHOD_NAME;
                break;
        }
        this.p.setRequestMethod(str);
    }

    public synchronized void d(int i2, int i3, byte[] bArr) {
        if (this.l) {
            return;
        }
        this.j = 2;
        k(i2, i3, bArr);
        this.l = true;
        this.k = 0;
        HandlerThread handlerThread = new HandlerThread("request");
        this.m = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.m.getLooper(), new a());
        this.n = handler;
        handler.sendEmptyMessage(1);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET, INVOKE, IPUT, IF] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IPUT, IF] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IPUT, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0097, code lost:
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        f(r4.f65746g, r4.f65747h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        boolean z = true;
        try {
            URL url = new URL(this.f65742c);
            if (this.o) {
                HttpsURLConnection.setDefaultSSLSocketFactory(SSLContext.getInstance("TLS").getSocketFactory());
                httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            this.p = httpURLConnection;
            this.p.setConnectTimeout(this.f65748i);
            this.p.setReadTimeout(this.f65748i);
            c(this.f65743d);
            j(this.f65744e);
            if (this.f65745f != null && this.f65745f.length > 0) {
                this.p.setDoOutput(true);
                OutputStream outputStream = this.p.getOutputStream();
                outputStream.write(this.f65745f);
                outputStream.flush();
                outputStream.close();
            }
            this.p.connect();
            try {
                this.f65746g = this.p.getResponseCode();
                inputStream = this.p.getInputStream();
                try {
                    this.f65747h = h(inputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                z = false;
                HttpURLConnection httpURLConnection2 = this.p;
            } finally {
                HttpURLConnection httpURLConnection3 = this.p;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.p = null;
                }
            }
        }
    }

    public abstract boolean f(int i2, byte[] bArr);

    public final byte[] h(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public final void j(int i2) {
        HttpURLConnection httpURLConnection;
        StringBuilder sb;
        String str = i2 != 1 ? i2 != 2 ? "" : "application/octet-stream" : AbstractBceClient.DEFAULT_CONTENT_TYPE;
        if (str.length() > 0) {
            this.p.addRequestProperty("Content-Type", str);
        }
        HttpURLConnection httpURLConnection2 = this.p;
        httpURLConnection2.addRequestProperty("Cookie", "sessionid=" + this.f65741b);
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                httpURLConnection = this.p;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(",");
                sb.append(language);
                sb.append(";q=0.9");
            } else {
                httpURLConnection = this.p;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(",");
                sb.append(language);
                sb.append(";q=0.9,en-US;q=0.6,en;q=0.4");
            }
            httpURLConnection.addRequestProperty("Accept-Language", sb.toString());
        } catch (Throwable unused) {
        }
    }

    public final void k(int i2, int i3, byte[] bArr) {
        this.f65743d = i2;
        this.f65744e = i3;
        this.f65745f = bArr;
    }
}
