package d.a.i0.a.k0;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.i0.a.a1.e;
import d.a.i0.a.v2.q0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.i0.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0715a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.c f43027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43028b;

        public C0715a(e.c cVar, File file) {
            this.f43027a = cVar;
            this.f43028b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.c(this.f43027a, 1, 0);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.d(response, this.f43027a, this.f43028b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43030e;

        public b(a aVar, e.c cVar) {
            this.f43030e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43030e.onSuccess();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43031e;

        public c(a aVar, e.c cVar) {
            this.f43031e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43031e.onFailed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43033f;

        public d(a aVar, e.c cVar, int i2) {
            this.f43032e = cVar;
            this.f43033f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43032e.a(this.f43033f);
        }
    }

    public final void c(e.c cVar, int i2, int i3) {
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
        q0.b0(bVar);
    }

    public final void d(Response response, e.c cVar, File file) throws IOException {
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
                            d.a.i0.t.d.d(inputStream);
                            d.a.i0.t.d.d(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            d.a.i0.t.d.d(inputStream);
                            d.a.i0.t.d.d(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = byteStream;
                        d.a.i0.t.d.d(inputStream);
                        d.a.i0.t.d.d(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                c(cVar, 0, 100);
                d.a.i0.t.d.d(byteStream);
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
        d.a.i0.t.d.d(fileOutputStream);
    }

    public void e(e.d dVar, String str, e.c cVar) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(dVar.f40516a, new C0715a(cVar, new File(str)));
        aVar.f47798f = false;
        aVar.f47799g = false;
        aVar.f47800h = false;
        d.a.i0.m.e.a.g().d(aVar);
    }
}
