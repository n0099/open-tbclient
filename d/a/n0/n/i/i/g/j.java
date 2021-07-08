package d.a.n0.n.i.i.g;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f50692a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f50693b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f50694c;

    /* renamed from: d  reason: collision with root package name */
    public T f50695d;

    public j(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50693b = fVar;
        this.f50692a = fVar.f50678e;
        this.f50695d = fVar.f50679f;
        this.f50694c = fVar.f50681h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            int i2 = 32768;
            byte[] bArr = new byte[32768];
            long j2 = 0;
            int i3 = 0;
            while (!this.f50694c.get() && i3 != -1) {
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
                    this.f50692a.f50677b.f50631b = j2;
                    this.f50693b.k();
                }
            }
            if (d.a.n0.n.c.f50608a) {
                Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f50694c.get() + ", readed=" + j2 + ",totalBytes" + j);
            }
            return j2 == j;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f50694c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f50692a.f50676a = new d.a.n0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f50693b.c()) {
            this.f50692a.f50676a = new d.a.n0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f50693b.o();
            d.a.n0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = d.a.n0.n.c.b().y().b(this.f50692a.f50677b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f50692a.f50676a.f50626a != d2) {
                        this.f50692a.f50676a = new d.a.n0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.n0.n.c.f50608a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f50692a.f50676a.f50626a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.n0.n.c.f50608a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f50692a.f50676a = new d.a.n0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.n0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.f50692a.f50676a = new d.a.n0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.n0.n.o.d.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.f50692a.f50677b.l;
            String b2 = d.a.n0.n.o.b.b(new File(str), true);
            if (str2 != null && b2 != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b2)) {
                    return true;
                }
                this.f50692a.f50676a = new d.a.n0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.n0.n.o.d.a("server:", upperCase, ",local", b2));
                return false;
            }
            this.f50692a.f50676a = new d.a.n0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.n0.n.o.d.a("server:", str2, ",local", b2)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(d.a.n0.n.i.i.f.e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, eVar, i2)) == null) {
            if (d.a.n0.n.c.f50608a) {
                Log.d("PMSTaskProcessor", "download " + this.f50692a.f50677b.n + "response code:" + eVar.code());
            }
            this.f50692a.f50676a = null;
            if (i2 >= 200 && i2 <= 300) {
                d.a.n0.n.i.i.f.d body = eVar.body();
                if (body != null) {
                    long a2 = body.a();
                    if (d.a.n0.n.c.f50608a) {
                        Log.d("PMSTaskProcessor", "currentSize:" + this.f50692a.f50677b.f50631b + ",totalBytes:" + this.f50692a.f50677b.k + ",Content-Length:" + a2);
                    }
                    if (!this.f50693b.i(this.f50692a.f50677b.k)) {
                        this.f50692a.f50676a = new d.a.n0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.f50692a.f50676a.f50626a;
                    }
                    try {
                        if (e(body, a2)) {
                            this.f50692a.f50676a = new d.a.n0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.f50692a.f50676a.f50626a;
                        }
                    } catch (IOException e2) {
                        if (d.a.n0.n.c.f50608a) {
                            e2.printStackTrace();
                        }
                        this.f50692a.f50676a = new d.a.n0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.f50692a.f50676a.f50626a;
                    }
                }
                e eVar2 = this.f50692a;
                if (eVar2.f50676a == null) {
                    eVar2.f50676a = new d.a.n0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
                return this.f50692a.f50676a.f50626a;
            }
            this.f50692a.f50676a = new d.a.n0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            return this.f50692a.f50676a.f50626a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(d.a.n0.n.i.i.f.d dVar, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048580, this, dVar, j)) != null) {
            return invokeLJ.booleanValue;
        }
        f<T> fVar = this.f50693b;
        c<T> cVar = fVar.f50682i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f50695d;
            File file = fVar.f50680g;
            ReadableByteChannel source = dVar.source();
            try {
                d.a.n0.n.h.a h2 = cVar.h(t, file, j, source);
                if (h2.f50626a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f50693b.f50680g), j) && c(this.f50692a.f50677b.f50630a)) {
                        if (source != null && source.isOpen()) {
                            d.a.n0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        d.a.n0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f50626a == 2300) {
                    this.f50692a.f50677b.f50631b = j;
                    this.f50693b.k();
                    if (source != null && source.isOpen()) {
                        d.a.n0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f50692a.f50676a = h2;
                    if (source != null && source.isOpen()) {
                        d.a.n0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.a.n0.t.d.d(readableByteChannel);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean f(InputStream inputStream, OutputStream outputStream, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            try {
                try {
                    return a(inputStream, outputStream, j);
                } catch (IOException e2) {
                    if (d.a.n0.n.c.f50608a) {
                        Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                    }
                    d.a.n0.t.d.d(inputStream);
                    d.a.n0.t.d.d(outputStream);
                    return false;
                }
            } finally {
                d.a.n0.t.d.d(inputStream);
                d.a.n0.t.d.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
