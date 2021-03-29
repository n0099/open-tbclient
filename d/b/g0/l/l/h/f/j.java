package d.b.g0.l.l.h.f;

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
    public e f48967a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f48968b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f48969c;

    /* renamed from: d  reason: collision with root package name */
    public T f48970d;

    public j(f<T> fVar) {
        this.f48968b = fVar;
        this.f48967a = fVar.f48954e;
        this.f48970d = fVar.f48955f;
        this.f48969c = fVar.f48957h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        int i = 32768;
        byte[] bArr = new byte[32768];
        long j2 = 0;
        int i2 = 0;
        while (!this.f48969c.get() && i2 != -1) {
            if (j > 0) {
                if (j2 >= j) {
                    break;
                } else if (i + j2 > j) {
                    i = (int) (j - j2);
                }
            }
            i2 = inputStream.read(bArr, 0, i);
            if (i2 > 0) {
                outputStream.write(bArr, 0, i2);
                j2 += i2;
                this.f48967a.f48953b.f48918b = j2;
                this.f48968b.k();
            }
        }
        if (d.b.g0.l.f.f48889a) {
            Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f48969c.get() + ", readed=" + j2 + ",totalBytes" + j);
        }
        return j2 == j;
    }

    public void b() {
        if (this.f48969c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f48967a.f48952a = new d.b.g0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f48968b.c()) {
            this.f48967a.f48952a = new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            GetRequest.GetRequestBuilder url = d.b.g0.k.e.a.f().getRequest().url(this.f48967a.f48953b.n);
            this.f48968b.o();
            Response response = null;
            try {
                try {
                    response = url.build().executeSync();
                    int code = response.code();
                    int d2 = d(response, code);
                    if (this.f48967a.f48952a.f48914a != d2) {
                        this.f48967a.f48952a = new d.b.g0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.b.g0.l.f.f48889a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f48967a.f48952a.f48914a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.b.g0.l.f.f48889a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f48967a.f48952a = new d.b.g0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.b.g0.p.d.a(response);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        if (!new File(str).exists()) {
            this.f48967a.f48952a = new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.b.g0.l.r.d.a("local file save failed:", str)));
            return false;
        }
        String str2 = this.f48967a.f48953b.l;
        String b2 = d.b.g0.l.r.b.b(new File(str), true);
        if (str2 != null && b2 != null) {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals(b2)) {
                return true;
            }
            this.f48967a.f48952a = new d.b.g0.l.k.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.b.g0.l.r.d.a("server:", upperCase, ",local", b2));
            return false;
        }
        this.f48967a.f48952a = new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.b.g0.l.r.d.a("server:", str2, ",local", b2)));
        return false;
    }

    public final int d(Response response, int i) {
        if (d.b.g0.l.f.f48889a) {
            Log.d("PMSTaskProcessor", "download " + this.f48967a.f48953b.n + "response code:" + response.code());
        }
        this.f48967a.f48952a = null;
        if (i >= 200 && i <= 300) {
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength = body.contentLength();
                if (d.b.g0.l.f.f48889a) {
                    Log.d("PMSTaskProcessor", "currentSize:" + this.f48967a.f48953b.f48918b + ",totalBytes:" + this.f48967a.f48953b.k + ",Content-Length:" + contentLength);
                }
                if (!this.f48968b.i(this.f48967a.f48953b.k)) {
                    this.f48967a.f48952a = new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                    return this.f48967a.f48952a.f48914a;
                }
                try {
                    if (e(body, contentLength)) {
                        this.f48967a.f48952a = new d.b.g0.l.k.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                        return this.f48967a.f48952a.f48914a;
                    }
                } catch (IOException e2) {
                    if (d.b.g0.l.f.f48889a) {
                        e2.printStackTrace();
                    }
                    this.f48967a.f48952a = new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                    return this.f48967a.f48952a.f48914a;
                }
            }
            e eVar = this.f48967a;
            if (eVar.f48952a == null) {
                eVar.f48952a = new d.b.g0.l.k.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
            }
            return this.f48967a.f48952a.f48914a;
        }
        this.f48967a.f48952a = new d.b.g0.l.k.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
        return this.f48967a.f48952a.f48914a;
    }

    public final boolean e(ResponseBody responseBody, long j) throws IOException {
        c<T> cVar = this.f48968b.i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f48970d;
            BufferedSource source = responseBody.source();
            d.b.g0.l.k.a f2 = cVar.f(t, source, this.f48968b.f48956g, j);
            if (f2.f48914a == 2302) {
                if (f(Channels.newInputStream(source), new FileOutputStream(this.f48968b.f48956g), j) && c(this.f48967a.f48953b.f48917a)) {
                    if (source != null && source.isOpen()) {
                        d.b.g0.p.d.a(source);
                    }
                    return true;
                }
                if (source != null && source.isOpen()) {
                    d.b.g0.p.d.a(source);
                }
                return false;
            } else if (f2.f48914a == 2300) {
                this.f48967a.f48953b.f48918b = j;
                this.f48968b.k();
                if (source != null && source.isOpen()) {
                    d.b.g0.p.d.a(source);
                }
                return true;
            } else {
                this.f48967a.f48952a = f2;
                if (source != null && source.isOpen()) {
                    d.b.g0.p.d.a(source);
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0 && readableByteChannel.isOpen()) {
                d.b.g0.p.d.a(null);
            }
            throw th;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        try {
            try {
                return a(inputStream, outputStream, j);
            } catch (IOException e2) {
                if (d.b.g0.l.f.f48889a) {
                    Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                }
                d.b.g0.p.d.a(inputStream);
                d.b.g0.p.d.a(outputStream);
                return false;
            }
        } finally {
            d.b.g0.p.d.a(inputStream);
            d.b.g0.p.d.a(outputStream);
        }
    }
}
