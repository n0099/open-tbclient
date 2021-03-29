package d.b.g0.a.h0;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.a.i2.k0;
import d.b.g0.a.u0.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.g0.a.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0698a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c f44604a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f44605b;

        public C0698a(d.c cVar, File file) {
            this.f44604a = cVar;
            this.f44605b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.c(this.f44604a, 1, 0);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            a.this.d(response, this.f44604a, this.f44605b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f44607e;

        public b(a aVar, d.c cVar) {
            this.f44607e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44607e.onSuccess();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f44608e;

        public c(a aVar, d.c cVar) {
            this.f44608e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44608e.onFailed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f44609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44610f;

        public d(a aVar, d.c cVar, int i) {
            this.f44609e = cVar;
            this.f44610f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44609e.a(this.f44610f);
        }
    }

    public final void c(d.c cVar, int i, int i2) {
        Runnable bVar;
        if (cVar == null) {
            return;
        }
        if (i == 0) {
            bVar = new b(this, cVar);
        } else if (i != 2) {
            bVar = new c(this, cVar);
        } else {
            bVar = new d(this, cVar, i2);
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
                            d.b.g0.p.d.a(inputStream);
                            d.b.g0.p.d.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            d.b.g0.p.d.a(inputStream);
                            d.b.g0.p.d.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = byteStream;
                        d.b.g0.p.d.a(inputStream);
                        d.b.g0.p.d.a(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                c(cVar, 0, 100);
                d.b.g0.p.d.a(byteStream);
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
        d.b.g0.p.d.a(fileOutputStream);
    }

    public void e(d.C0849d c0849d, String str, d.c cVar) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(c0849d.f46599a, new C0698a(cVar, new File(str)));
        aVar.f48884f = false;
        aVar.f48885g = false;
        aVar.f48886h = false;
        d.b.g0.k.e.a.f().d(aVar);
    }
}
