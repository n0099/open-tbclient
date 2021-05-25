package d.a.l0.a.k0;

import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.l0.a.a1.e;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.l0.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0726a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.c f43201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43202b;

        public C0726a(e.c cVar, File file) {
            this.f43201a = cVar;
            this.f43202b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.c(this.f43201a, 1, 0);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.d(response, this.f43201a, this.f43202b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43204e;

        public b(a aVar, e.c cVar) {
            this.f43204e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43204e.onSuccess();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43205e;

        public c(a aVar, e.c cVar) {
            this.f43205e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43205e.onFailed();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f43206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43207f;

        public d(a aVar, e.c cVar, int i2) {
            this.f43206e = cVar;
            this.f43207f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43206e.a(this.f43207f);
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
                            d.a.l0.t.d.d(inputStream);
                            d.a.l0.t.d.d(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            d.a.l0.t.d.d(inputStream);
                            d.a.l0.t.d.d(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = byteStream;
                        d.a.l0.t.d.d(inputStream);
                        d.a.l0.t.d.d(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream.flush();
                c(cVar, 0, 100);
                d.a.l0.t.d.d(byteStream);
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
        d.a.l0.t.d.d(fileOutputStream);
    }

    public void e(e.d dVar, String str, e.c cVar) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(dVar.f40690a, new C0726a(cVar, new File(str)));
        aVar.f47974f = false;
        aVar.f47975g = false;
        aVar.f47976h = false;
        d.a.l0.m.e.a.g().d(aVar);
    }
}
