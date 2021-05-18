package d.a.i0.n.i.i.g;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class j<T> {

    /* renamed from: a  reason: collision with root package name */
    public e f47892a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f47893b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f47894c;

    /* renamed from: d  reason: collision with root package name */
    public T f47895d;

    public j(f<T> fVar) {
        this.f47893b = fVar;
        this.f47892a = fVar.f47878e;
        this.f47895d = fVar.f47879f;
        this.f47894c = fVar.f47881h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        int i2 = 32768;
        byte[] bArr = new byte[32768];
        long j2 = 0;
        int i3 = 0;
        while (!this.f47894c.get() && i3 != -1) {
            if (j > 0) {
                if (j2 >= j) {
                    break;
                } else if (i2 + j2 > j) {
                    i2 = (int) (j - j2);
                }
            }
            i3 = inputStream.read(bArr, 0, i2);
            if (i3 > 0) {
                outputStream.write(bArr, 0, i3);
                j2 += i3;
                this.f47892a.f47877b.f47831b = j2;
                this.f47893b.k();
            }
        }
        if (d.a.i0.n.c.f47808a) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f47894c.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    public void b() {
        if (this.f47894c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f47892a.f47876a = new d.a.i0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f47893b.c()) {
            this.f47892a.f47876a = new d.a.i0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f47893b.o();
            d.a.i0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = d.a.i0.n.c.b().y().b(this.f47892a.f47877b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f47892a.f47876a.f47826a != d2) {
                        this.f47892a.f47876a = new d.a.i0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.i0.n.c.f47808a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f47892a.f47876a.f47826a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.i0.n.c.f47808a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f47892a.f47876a = new d.a.i0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.i0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        if (!new File(str).exists()) {
            this.f47892a.f47876a = new d.a.i0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.i0.n.o.d.a("local file save failed:", str)));
            return false;
        }
        String str2 = this.f47892a.f47877b.l;
        String b2 = d.a.i0.n.o.b.b(new File(str), true);
        if (str2 != null && b2 != null) {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b2)) {
                return true;
            }
            this.f47892a.f47876a = new d.a.i0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.i0.n.o.d.a("server:", upperCase, ",local", b2));
            return false;
        }
        this.f47892a.f47876a = new d.a.i0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.i0.n.o.d.a("server:", str2, ",local", b2)));
        return false;
    }

    public final int d(d.a.i0.n.i.i.f.e eVar, int i2) {
        if (d.a.i0.n.c.f47808a) {
            Log.d("PMSTaskProcessor", "download " + this.f47892a.f47877b.n + "response code:" + eVar.code());
        }
        this.f47892a.f47876a = null;
        if (i2 >= 200 && i2 <= 300) {
            d.a.i0.n.i.i.f.d body = eVar.body();
            if (body != null) {
                long a2 = body.a();
                if (d.a.i0.n.c.f47808a) {
                    Log.d("PMSTaskProcessor", "currentSize:" + this.f47892a.f47877b.f47831b + ",totalBytes:" + this.f47892a.f47877b.k + ",Content-Length:" + a2);
                }
                if (!this.f47893b.i(this.f47892a.f47877b.k)) {
                    this.f47892a.f47876a = new d.a.i0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                    return this.f47892a.f47876a.f47826a;
                }
                try {
                    if (e(body, a2)) {
                        this.f47892a.f47876a = new d.a.i0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                        return this.f47892a.f47876a.f47826a;
                    }
                } catch (IOException e2) {
                    if (d.a.i0.n.c.f47808a) {
                        e2.printStackTrace();
                    }
                    this.f47892a.f47876a = new d.a.i0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                    return this.f47892a.f47876a.f47826a;
                }
            }
            e eVar2 = this.f47892a;
            if (eVar2.f47876a == null) {
                eVar2.f47876a = new d.a.i0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
            }
            return this.f47892a.f47876a.f47826a;
        }
        this.f47892a.f47876a = new d.a.i0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
        return this.f47892a.f47876a.f47826a;
    }

    public final boolean e(d.a.i0.n.i.i.f.d dVar, long j) throws IOException {
        f<T> fVar = this.f47893b;
        c<T> cVar = fVar.f47882i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f47895d;
            File file = fVar.f47880g;
            ReadableByteChannel source = dVar.source();
            try {
                d.a.i0.n.h.a h2 = cVar.h(t, file, j, source);
                if (h2.f47826a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f47893b.f47880g), j) && c(this.f47892a.f47877b.f47830a)) {
                        if (source != null && source.isOpen()) {
                            d.a.i0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        d.a.i0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f47826a == 2300) {
                    this.f47892a.f47877b.f47831b = j;
                    this.f47893b.k();
                    if (source != null && source.isOpen()) {
                        d.a.i0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f47892a.f47876a = h2;
                    if (source != null && source.isOpen()) {
                        d.a.i0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.a.i0.t.d.d(readableByteChannel);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        try {
            try {
                return a(inputStream, outputStream, j);
            } catch (IOException e2) {
                if (d.a.i0.n.c.f47808a) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                }
                d.a.i0.t.d.d(inputStream);
                d.a.i0.t.d.d(outputStream);
                return false;
            }
        } finally {
            d.a.i0.t.d.d(inputStream);
            d.a.i0.t.d.d(outputStream);
        }
    }
}
