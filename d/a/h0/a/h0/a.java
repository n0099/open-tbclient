package d.a.h0.a.h0;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.a.i2.k0;
import d.a.h0.a.u0.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.h0.a.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0669a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c f42640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f42641b;

        public C0669a(d.c cVar, File file) {
            this.f42640a = cVar;
            this.f42641b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.c(this.f42640a, 1, 0);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.d(response, this.f42640a, this.f42641b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f42643e;

        public b(a aVar, d.c cVar) {
            this.f42643e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42643e.onSuccess();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f42644e;

        public c(a aVar, d.c cVar) {
            this.f42644e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42644e.onFailed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f42645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42646f;

        public d(a aVar, d.c cVar, int i2) {
            this.f42645e = cVar;
            this.f42646f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42645e.a(this.f42646f);
        }
    }

    public final void c(d.c cVar, int i2, int i3) {
        Runnable bVar;
        if (cVar == null) {
            return;
        }
        if (i2 == 0) {
            bVar = new b(this, cVar);
        } else if (i2 != 2) {
            bVar = new c(this, cVar);
        } else {
            bVar = new d(this, cVar, i3);
        }
        k0.X(bVar);
    }

    public final void d(Response response, d.c cVar, File file) throws IOException {
        FileOutputStream fileOutputStream;
        ResponseBody body = response.body();
        if (body == null) {
            c(cVar, 1, 0);
            return;
        }
        byte[] bArr = new byte[2048];
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
        InputStream inputStream = null;
        try {
            InputStream byteStream = body.byteStream();
            try {
                long contentLength = body.contentLength();
                fileOutputStream = new FileOutputStream(file);
                long j = 0;
                while (true) {
                    try {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j += read;
                        c(cVar, 2, contentLength <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) contentLength)) * 100.0f));
                    } catch (Exception unused) {
                        inputStream = byteStream;
                        try {
                            c(cVar, 1, 0);
                            d.a.h0.p.d.a(inputStream);
                            d.a.h0.p.d.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            d.a.h0.p.d.a(inputStream);
                            d.a.h0.p.d.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = byteStream;
                        d.a.h0.p.d.a(inputStream);
                        d.a.h0.p.d.a(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                c(cVar, 0, 100);
                d.a.h0.p.d.a(byteStream);
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        d.a.h0.p.d.a(fileOutputStream);
    }

    public void e(d.C0820d c0820d, String str, d.c cVar) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(c0820d.f44731a, new C0669a(cVar, new File(str)));
        aVar.f47111f = false;
        aVar.f47112g = false;
        aVar.f47113h = false;
        d.a.h0.k.e.a.f().d(aVar);
    }
}
