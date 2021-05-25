package d.a.l0.n.i.i.g;

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
    public e f48068a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f48069b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f48070c;

    /* renamed from: d  reason: collision with root package name */
    public T f48071d;

    public j(f<T> fVar) {
        this.f48069b = fVar;
        this.f48068a = fVar.f48054e;
        this.f48071d = fVar.f48055f;
        this.f48070c = fVar.f48057h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        int i2 = 32768;
        byte[] bArr = new byte[32768];
        long j2 = 0;
        int i3 = 0;
        while (!this.f48070c.get() && i3 != -1) {
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
                this.f48068a.f48053b.f48007b = j2;
                this.f48069b.k();
            }
        }
        if (d.a.l0.n.c.f47984a) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f48070c.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    public void b() {
        if (this.f48070c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f48068a.f48052a = new d.a.l0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f48069b.c()) {
            this.f48068a.f48052a = new d.a.l0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f48069b.o();
            d.a.l0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = d.a.l0.n.c.b().y().b(this.f48068a.f48053b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f48068a.f48052a.f48002a != d2) {
                        this.f48068a.f48052a = new d.a.l0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.l0.n.c.f47984a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f48068a.f48052a.f48002a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.l0.n.c.f47984a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f48068a.f48052a = new d.a.l0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.l0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        if (!new File(str).exists()) {
            this.f48068a.f48052a = new d.a.l0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.l0.n.o.d.a("local file save failed:", str)));
            return false;
        }
        String str2 = this.f48068a.f48053b.l;
        String b2 = d.a.l0.n.o.b.b(new File(str), true);
        if (str2 != null && b2 != null) {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b2)) {
                return true;
            }
            this.f48068a.f48052a = new d.a.l0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.l0.n.o.d.a("server:", upperCase, ",local", b2));
            return false;
        }
        this.f48068a.f48052a = new d.a.l0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.l0.n.o.d.a("server:", str2, ",local", b2)));
        return false;
    }

    public final int d(d.a.l0.n.i.i.f.e eVar, int i2) {
        if (d.a.l0.n.c.f47984a) {
            Log.d("PMSTaskProcessor", "download " + this.f48068a.f48053b.n + "response code:" + eVar.code());
        }
        this.f48068a.f48052a = null;
        if (i2 >= 200 && i2 <= 300) {
            d.a.l0.n.i.i.f.d body = eVar.body();
            if (body != null) {
                long a2 = body.a();
                if (d.a.l0.n.c.f47984a) {
                    Log.d("PMSTaskProcessor", "currentSize:" + this.f48068a.f48053b.f48007b + ",totalBytes:" + this.f48068a.f48053b.k + ",Content-Length:" + a2);
                }
                if (!this.f48069b.i(this.f48068a.f48053b.k)) {
                    this.f48068a.f48052a = new d.a.l0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                    return this.f48068a.f48052a.f48002a;
                }
                try {
                    if (e(body, a2)) {
                        this.f48068a.f48052a = new d.a.l0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                        return this.f48068a.f48052a.f48002a;
                    }
                } catch (IOException e2) {
                    if (d.a.l0.n.c.f47984a) {
                        e2.printStackTrace();
                    }
                    this.f48068a.f48052a = new d.a.l0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                    return this.f48068a.f48052a.f48002a;
                }
            }
            e eVar2 = this.f48068a;
            if (eVar2.f48052a == null) {
                eVar2.f48052a = new d.a.l0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
            }
            return this.f48068a.f48052a.f48002a;
        }
        this.f48068a.f48052a = new d.a.l0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
        return this.f48068a.f48052a.f48002a;
    }

    public final boolean e(d.a.l0.n.i.i.f.d dVar, long j) throws IOException {
        f<T> fVar = this.f48069b;
        c<T> cVar = fVar.f48058i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f48071d;
            File file = fVar.f48056g;
            ReadableByteChannel source = dVar.source();
            try {
                d.a.l0.n.h.a h2 = cVar.h(t, file, j, source);
                if (h2.f48002a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f48069b.f48056g), j) && c(this.f48068a.f48053b.f48006a)) {
                        if (source != null && source.isOpen()) {
                            d.a.l0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        d.a.l0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f48002a == 2300) {
                    this.f48068a.f48053b.f48007b = j;
                    this.f48069b.k();
                    if (source != null && source.isOpen()) {
                        d.a.l0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f48068a.f48052a = h2;
                    if (source != null && source.isOpen()) {
                        d.a.l0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.a.l0.t.d.d(readableByteChannel);
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
                if (d.a.l0.n.c.f47984a) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                }
                d.a.l0.t.d.d(inputStream);
                d.a.l0.t.d.d(outputStream);
                return false;
            }
        } finally {
            d.a.l0.t.d.d(inputStream);
            d.a.l0.t.d.d(outputStream);
        }
    }
}
