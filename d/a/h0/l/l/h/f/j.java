package d.a.h0.l.l.h.f;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public class j<T> {

    /* renamed from: a  reason: collision with root package name */
    public e f47199a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f47200b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f47201c;

    /* renamed from: d  reason: collision with root package name */
    public T f47202d;

    public j(f<T> fVar) {
        this.f47200b = fVar;
        this.f47199a = fVar.f47185e;
        this.f47202d = fVar.f47186f;
        this.f47201c = fVar.f47188h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        int i2 = 32768;
        byte[] bArr = new byte[32768];
        long j2 = 0;
        int i3 = 0;
        while (!this.f47201c.get() && i3 != -1) {
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
                this.f47199a.f47184b.f47148b = j2;
                this.f47200b.k();
            }
        }
        if (d.a.h0.l.f.f47117a) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f47201c.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    public void b() {
        if (this.f47201c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f47199a.f47183a = new d.a.h0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f47200b.c()) {
            this.f47199a.f47183a = new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            GetRequest.GetRequestBuilder url = d.a.h0.k.e.a.f().getRequest().url(this.f47199a.f47184b.n);
            this.f47200b.o();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int d2 = d(response, code);
                    if (this.f47199a.f47183a.f47144a != d2) {
                        this.f47199a.f47183a = new d.a.h0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.h0.l.f.f47117a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f47199a.f47183a.f47144a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.h0.l.f.f47117a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f47199a.f47183a = new d.a.h0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.h0.p.d.a(response);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        if (!new File(str).exists()) {
            this.f47199a.f47183a = new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.h0.l.r.d.a("local file save failed:", str)));
            return false;
        }
        String str2 = this.f47199a.f47184b.l;
        String b2 = d.a.h0.l.r.b.b(new File(str), true);
        if (str2 != null && b2 != null) {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b2)) {
                return true;
            }
            this.f47199a.f47183a = new d.a.h0.l.k.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.h0.l.r.d.a("server:", upperCase, ",local", b2));
            return false;
        }
        this.f47199a.f47183a = new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.h0.l.r.d.a("server:", str2, ",local", b2)));
        return false;
    }

    public final int d(Response response, int i2) {
        if (d.a.h0.l.f.f47117a) {
            Log.d("PMSTaskProcessor", "download " + this.f47199a.f47184b.n + "response code:" + response.code());
        }
        this.f47199a.f47183a = null;
        if (i2 >= 200 && i2 <= 300) {
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength = body.contentLength();
                if (d.a.h0.l.f.f47117a) {
                    Log.d("PMSTaskProcessor", "currentSize:" + this.f47199a.f47184b.f47148b + ",totalBytes:" + this.f47199a.f47184b.k + ",Content-Length:" + contentLength);
                }
                if (!this.f47200b.i(this.f47199a.f47184b.k)) {
                    this.f47199a.f47183a = new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                    return this.f47199a.f47183a.f47144a;
                }
                try {
                    if (e(body, contentLength)) {
                        this.f47199a.f47183a = new d.a.h0.l.k.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                        return this.f47199a.f47183a.f47144a;
                    }
                } catch (IOException e2) {
                    if (d.a.h0.l.f.f47117a) {
                        e2.printStackTrace();
                    }
                    this.f47199a.f47183a = new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                    return this.f47199a.f47183a.f47144a;
                }
            }
            e eVar = this.f47199a;
            if (eVar.f47183a == null) {
                eVar.f47183a = new d.a.h0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
            }
            return this.f47199a.f47183a.f47144a;
        }
        this.f47199a.f47183a = new d.a.h0.l.k.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
        return this.f47199a.f47183a.f47144a;
    }

    public final boolean e(ResponseBody responseBody, long j) throws IOException {
        c<T> cVar = this.f47200b.f47189i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f47202d;
            BufferedSource source = responseBody.source();
            d.a.h0.l.k.a b2 = cVar.b(t, source, this.f47200b.f47187g, j);
            if (b2.f47144a == 2302) {
                if (f(Channels.newInputStream(source), new FileOutputStream(this.f47200b.f47187g), j) && c(this.f47199a.f47184b.f47147a)) {
                    if (source != null && source.isOpen()) {
                        d.a.h0.p.d.a(source);
                    }
                    return true;
                }
                if (source != null && source.isOpen()) {
                    d.a.h0.p.d.a(source);
                }
                return false;
            } else if (b2.f47144a == 2300) {
                this.f47199a.f47184b.f47148b = j;
                this.f47200b.k();
                if (source != null && source.isOpen()) {
                    d.a.h0.p.d.a(source);
                }
                return true;
            } else {
                this.f47199a.f47183a = b2;
                if (source != null && source.isOpen()) {
                    d.a.h0.p.d.a(source);
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0 && readableByteChannel.isOpen()) {
                d.a.h0.p.d.a(null);
            }
            throw th;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        try {
            try {
                return a(inputStream, outputStream, j);
            } catch (IOException e2) {
                if (d.a.h0.l.f.f47117a) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                }
                d.a.h0.p.d.a(inputStream);
                d.a.h0.p.d.a(outputStream);
                return false;
            }
        } finally {
            d.a.h0.p.d.a(inputStream);
            d.a.h0.p.d.a(outputStream);
        }
    }
}
