package d.b.h0.a.h0;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.h0.a.i2.k0;
import d.b.h0.a.u0.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.h0.a.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0730a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c f45325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f45326b;

        public C0730a(d.c cVar, File file) {
            this.f45325a = cVar;
            this.f45326b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.c(this.f45325a, 1, 0);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            a.this.d(response, this.f45325a, this.f45326b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f45328e;

        public b(a aVar, d.c cVar) {
            this.f45328e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45328e.onSuccess();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f45329e;

        public c(a aVar, d.c cVar) {
            this.f45329e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45329e.onFailed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f45330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45331f;

        public d(a aVar, d.c cVar, int i) {
            this.f45330e = cVar;
            this.f45331f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45330e.a(this.f45331f);
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
                            d.b.h0.p.d.a(inputStream);
                            d.b.h0.p.d.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            d.b.h0.p.d.a(inputStream);
                            d.b.h0.p.d.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = byteStream;
                        d.b.h0.p.d.a(inputStream);
                        d.b.h0.p.d.a(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                c(cVar, 0, 100);
                d.b.h0.p.d.a(byteStream);
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
        d.b.h0.p.d.a(fileOutputStream);
    }

    public void e(d.C0881d c0881d, String str, d.c cVar) {
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(c0881d.f47320a, new C0730a(cVar, new File(str)));
        aVar.f49605f = false;
        aVar.f49606g = false;
        aVar.f49607h = false;
        d.b.h0.k.e.a.f().d(aVar);
    }
}
