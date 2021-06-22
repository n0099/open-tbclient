package d.a.m0.n.i.i.g;

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
    public e f51850a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f51851b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f51852c;

    /* renamed from: d  reason: collision with root package name */
    public T f51853d;

    public j(f<T> fVar) {
        this.f51851b = fVar;
        this.f51850a = fVar.f51836e;
        this.f51853d = fVar.f51837f;
        this.f51852c = fVar.f51839h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        int i2 = 32768;
        byte[] bArr = new byte[32768];
        long j2 = 0;
        int i3 = 0;
        while (!this.f51852c.get() && i3 != -1) {
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
                this.f51850a.f51835b.f51789b = j2;
                this.f51851b.k();
            }
        }
        if (d.a.m0.n.c.f51766a) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f51852c.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    public void b() {
        if (this.f51852c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f51850a.f51834a = new d.a.m0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f51851b.c()) {
            this.f51850a.f51834a = new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f51851b.o();
            d.a.m0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = d.a.m0.n.c.b().y().b(this.f51850a.f51835b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f51850a.f51834a.f51784a != d2) {
                        this.f51850a.f51834a = new d.a.m0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.m0.n.c.f51766a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f51850a.f51834a.f51784a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.m0.n.c.f51766a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f51850a.f51834a = new d.a.m0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.m0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        if (!new File(str).exists()) {
            this.f51850a.f51834a = new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.m0.n.o.d.a("local file save failed:", str)));
            return false;
        }
        String str2 = this.f51850a.f51835b.l;
        String b2 = d.a.m0.n.o.b.b(new File(str), true);
        if (str2 != null && b2 != null) {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b2)) {
                return true;
            }
            this.f51850a.f51834a = new d.a.m0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.m0.n.o.d.a("server:", upperCase, ",local", b2));
            return false;
        }
        this.f51850a.f51834a = new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.m0.n.o.d.a("server:", str2, ",local", b2)));
        return false;
    }

    public final int d(d.a.m0.n.i.i.f.e eVar, int i2) {
        if (d.a.m0.n.c.f51766a) {
            Log.d("PMSTaskProcessor", "download " + this.f51850a.f51835b.n + "response code:" + eVar.code());
        }
        this.f51850a.f51834a = null;
        if (i2 >= 200 && i2 <= 300) {
            d.a.m0.n.i.i.f.d body = eVar.body();
            if (body != null) {
                long a2 = body.a();
                if (d.a.m0.n.c.f51766a) {
                    Log.d("PMSTaskProcessor", "currentSize:" + this.f51850a.f51835b.f51789b + ",totalBytes:" + this.f51850a.f51835b.k + ",Content-Length:" + a2);
                }
                if (!this.f51851b.i(this.f51850a.f51835b.k)) {
                    this.f51850a.f51834a = new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                    return this.f51850a.f51834a.f51784a;
                }
                try {
                    if (e(body, a2)) {
                        this.f51850a.f51834a = new d.a.m0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                        return this.f51850a.f51834a.f51784a;
                    }
                } catch (IOException e2) {
                    if (d.a.m0.n.c.f51766a) {
                        e2.printStackTrace();
                    }
                    this.f51850a.f51834a = new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                    return this.f51850a.f51834a.f51784a;
                }
            }
            e eVar2 = this.f51850a;
            if (eVar2.f51834a == null) {
                eVar2.f51834a = new d.a.m0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
            }
            return this.f51850a.f51834a.f51784a;
        }
        this.f51850a.f51834a = new d.a.m0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
        return this.f51850a.f51834a.f51784a;
    }

    public final boolean e(d.a.m0.n.i.i.f.d dVar, long j) throws IOException {
        f<T> fVar = this.f51851b;
        c<T> cVar = fVar.f51840i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f51853d;
            File file = fVar.f51838g;
            ReadableByteChannel source = dVar.source();
            try {
                d.a.m0.n.h.a h2 = cVar.h(t, file, j, source);
                if (h2.f51784a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f51851b.f51838g), j) && c(this.f51850a.f51835b.f51788a)) {
                        if (source != null && source.isOpen()) {
                            d.a.m0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        d.a.m0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f51784a == 2300) {
                    this.f51850a.f51835b.f51789b = j;
                    this.f51851b.k();
                    if (source != null && source.isOpen()) {
                        d.a.m0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f51850a.f51834a = h2;
                    if (source != null && source.isOpen()) {
                        d.a.m0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.a.m0.t.d.d(readableByteChannel);
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
                if (d.a.m0.n.c.f51766a) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                }
                d.a.m0.t.d.d(inputStream);
                d.a.m0.t.d.d(outputStream);
                return false;
            }
        } finally {
            d.a.m0.t.d.d(inputStream);
            d.a.m0.t.d.d(outputStream);
        }
    }
}
