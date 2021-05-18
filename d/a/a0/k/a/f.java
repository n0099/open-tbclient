package d.a.a0.k.a;

import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38337a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38338b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.a.c f38340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.a.b f38341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.a.a f38342h;

        /* renamed from: d.a.a0.k.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0475a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f38344e;

            public RunnableC0475a(String str) {
                this.f38344e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f38342h.a(this.f38344e);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f38346e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f38347f;

            public b(int i2, String str) {
                this.f38346e = i2;
                this.f38347f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.a0.k.a.a aVar = a.this.f38342h;
                aVar.b(new IOException("status code " + this.f38346e + ", response " + this.f38347f), null);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f38349e;

            public c(Throwable th) {
                this.f38349e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f38342h.b(this.f38349e, null);
            }
        }

        public a(String str, d.a.a0.k.a.c cVar, d.a.a0.k.a.b bVar, d.a.a0.k.a.a aVar) {
            this.f38339e = str;
            this.f38340f = cVar;
            this.f38341g = bVar;
            this.f38342h = aVar;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00ea */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x00bb */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.io.Closeable[] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.Closeable[] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0150 A[Catch: all -> 0x0176, TryCatch #1 {all -> 0x0176, blocks: (B:55:0x0149, B:57:0x0150, B:59:0x0158, B:60:0x0167), top: B:68:0x0149 }] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable[]] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            DataOutputStream dataOutputStream;
            Throwable th;
            HttpURLConnection httpURLConnection;
            int i2 = 2;
            i2 = 2;
            i2 = 2;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f38339e).openConnection();
                for (Map.Entry<String, String> entry : this.f38340f.d().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : this.f38341g.d().entrySet()) {
                    String encode = URLEncoder.encode(entry2.getValue());
                    sb.append(entry2.getKey());
                    sb.append("=");
                    sb.append(encode);
                    sb.append("&");
                }
                byte[] bytes = sb.toString().getBytes();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        if (responseCode >= 200 && responseCode <= 299) {
                            try {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                String a2 = d.a.a0.n.c.a(inputStream);
                                httpURLConnection = inputStream;
                                if (this.f38342h != null) {
                                    if (f.this.f38338b) {
                                        f.this.f38337a.post(new RunnableC0475a(a2));
                                        httpURLConnection = inputStream;
                                    } else {
                                        this.f38342h.a(a2);
                                        httpURLConnection = inputStream;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = null;
                                try {
                                    d.a.a0.n.d.a("POST FAILED", th);
                                    if (this.f38342h != null) {
                                    }
                                    Closeable[] closeableArr = new Closeable[i2];
                                    closeableArr[0] = httpURLConnection;
                                    closeableArr[1] = dataOutputStream;
                                    d.a.a0.n.c.c(closeableArr);
                                } catch (Throwable th3) {
                                    Closeable[] closeableArr2 = new Closeable[i2];
                                    closeableArr2[0] = httpURLConnection;
                                    closeableArr2[1] = dataOutputStream;
                                    d.a.a0.n.c.c(closeableArr2);
                                    throw th3;
                                }
                            }
                        } else {
                            InputStream errorStream = httpURLConnection.getErrorStream();
                            String a3 = d.a.a0.n.c.a(errorStream);
                            httpURLConnection = errorStream;
                            if (this.f38342h != null) {
                                if (f.this.f38338b) {
                                    f.this.f38337a.post(new b(responseCode, a3));
                                    httpURLConnection = errorStream;
                                } else {
                                    d.a.a0.k.a.a aVar = this.f38342h;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("status code ");
                                    sb2.append(responseCode);
                                    sb2.append(", response ");
                                    sb2.append(a3);
                                    aVar.b(new IOException(sb2.toString()), null);
                                    httpURLConnection = errorStream;
                                }
                            }
                        }
                        i2 = new Closeable[]{httpURLConnection, dataOutputStream};
                        d.a.a0.n.c.c(i2);
                    } catch (Throwable th4) {
                        th = th4;
                        d.a.a0.n.d.a("POST FAILED", th);
                        if (this.f38342h != null) {
                            if (f.this.f38338b) {
                                f.this.f38337a.post(new c(th));
                            } else {
                                this.f38342h.b(th, null);
                            }
                        }
                        Closeable[] closeableArr3 = new Closeable[i2];
                        closeableArr3[0] = httpURLConnection;
                        closeableArr3[1] = dataOutputStream;
                        d.a.a0.n.c.c(closeableArr3);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                dataOutputStream = null;
                th = th6;
                httpURLConnection = null;
            }
        }
    }

    public f() {
        this(true);
    }

    @Override // d.a.a0.k.a.e
    public void a(String str, c cVar, b bVar, d.a.a0.k.a.a<String> aVar) {
        d.a.a0.m.a.a(new a(str, cVar, bVar, aVar));
    }

    public f(boolean z) {
        this.f38337a = new Handler(Looper.getMainLooper());
        this.f38338b = z;
    }
}
