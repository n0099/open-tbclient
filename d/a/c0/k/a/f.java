package d.a.c0.k.a;

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
    public Handler f43141a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43142b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.a.c f43144f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.a.b f43145g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.a.a f43146h;

        /* renamed from: d.a.c0.k.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0560a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43148e;

            public RunnableC0560a(String str) {
                this.f43148e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f43146h.a(this.f43148e);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43150e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43151f;

            public b(int i2, String str) {
                this.f43150e = i2;
                this.f43151f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.c0.k.a.a aVar = a.this.f43146h;
                aVar.b(new IOException("status code " + this.f43150e + ", response " + this.f43151f), null);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f43153e;

            public c(Throwable th) {
                this.f43153e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f43146h.b(this.f43153e, null);
            }
        }

        public a(String str, d.a.c0.k.a.c cVar, d.a.c0.k.a.b bVar, d.a.c0.k.a.a aVar) {
            this.f43143e = str;
            this.f43144f = cVar;
            this.f43145g = bVar;
            this.f43146h = aVar;
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
                httpURLConnection = (HttpURLConnection) new URL(this.f43143e).openConnection();
                for (Map.Entry<String, String> entry : this.f43144f.d().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : this.f43145g.d().entrySet()) {
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
                                String a2 = d.a.c0.n.c.a(inputStream);
                                httpURLConnection = inputStream;
                                if (this.f43146h != null) {
                                    if (f.this.f43142b) {
                                        f.this.f43141a.post(new RunnableC0560a(a2));
                                        httpURLConnection = inputStream;
                                    } else {
                                        this.f43146h.a(a2);
                                        httpURLConnection = inputStream;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = null;
                                try {
                                    d.a.c0.n.d.a("POST FAILED", th);
                                    if (this.f43146h != null) {
                                    }
                                    Closeable[] closeableArr = new Closeable[i2];
                                    closeableArr[0] = httpURLConnection;
                                    closeableArr[1] = dataOutputStream;
                                    d.a.c0.n.c.c(closeableArr);
                                } catch (Throwable th3) {
                                    Closeable[] closeableArr2 = new Closeable[i2];
                                    closeableArr2[0] = httpURLConnection;
                                    closeableArr2[1] = dataOutputStream;
                                    d.a.c0.n.c.c(closeableArr2);
                                    throw th3;
                                }
                            }
                        } else {
                            InputStream errorStream = httpURLConnection.getErrorStream();
                            String a3 = d.a.c0.n.c.a(errorStream);
                            httpURLConnection = errorStream;
                            if (this.f43146h != null) {
                                if (f.this.f43142b) {
                                    f.this.f43141a.post(new b(responseCode, a3));
                                    httpURLConnection = errorStream;
                                } else {
                                    d.a.c0.k.a.a aVar = this.f43146h;
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
                        d.a.c0.n.c.c(i2);
                    } catch (Throwable th4) {
                        th = th4;
                        d.a.c0.n.d.a("POST FAILED", th);
                        if (this.f43146h != null) {
                            if (f.this.f43142b) {
                                f.this.f43141a.post(new c(th));
                            } else {
                                this.f43146h.b(th, null);
                            }
                        }
                        Closeable[] closeableArr3 = new Closeable[i2];
                        closeableArr3[0] = httpURLConnection;
                        closeableArr3[1] = dataOutputStream;
                        d.a.c0.n.c.c(closeableArr3);
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

    @Override // d.a.c0.k.a.e
    public void a(String str, c cVar, b bVar, d.a.c0.k.a.a<String> aVar) {
        d.a.c0.m.a.a(new a(str, cVar, bVar, aVar));
    }

    public f(boolean z) {
        this.f43141a = new Handler(Looper.getMainLooper());
        this.f43142b = z;
    }
}
