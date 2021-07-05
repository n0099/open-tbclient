package d.a.q0.n.i.i.g;

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
/* loaded from: classes8.dex */
public class j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f53994a;

    /* renamed from: b  reason: collision with root package name */
    public f<T> f53995b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f53996c;

    /* renamed from: d  reason: collision with root package name */
    public T f53997d;

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
        this.f53995b = fVar;
        this.f53994a = fVar.f53980e;
        this.f53997d = fVar.f53981f;
        this.f53996c = fVar.f53983h;
    }

    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            int i2 = 32768;
            byte[] bArr = new byte[32768];
            long j2 = 0;
            int i3 = 0;
            while (!this.f53996c.get() && i3 != -1) {
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
                    this.f53994a.f53979b.f53933b = j2;
                    this.f53995b.k();
                }
            }
            if (d.a.q0.n.c.f53910a) {
                Log.i("PMSTaskProcessor", "copyStream: mCanceled=" + this.f53996c.get() + ", readed=" + j2 + ",totalBytes" + j);
            }
            return j2 == j;
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f53996c.get()) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
            this.f53994a.f53978a = new d.a.q0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
        } else if (!this.f53995b.c()) {
            this.f53994a.f53978a = new d.a.q0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_PATH, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_CREATEFILE);
        } else {
            this.f53995b.o();
            d.a.q0.n.i.i.f.e eVar = null;
            try {
                try {
                    eVar = d.a.q0.n.c.b().y().b(this.f53994a.f53979b.n);
                    int code = eVar.code();
                    int d2 = d(eVar, code);
                    if (this.f53994a.f53978a.f53928a != d2) {
                        this.f53994a.f53978a = new d.a.q0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                        if (d.a.q0.n.c.f53910a) {
                            Log.w("PMSTaskProcessor", "mismatch errorCode:" + d2 + "!=" + this.f53994a.f53978a.f53928a + " HTTP-ErrorCode:" + code);
                        }
                    }
                } catch (Exception e2) {
                    if (d.a.q0.n.c.f53910a) {
                        Log.e("PMSTaskProcessor", e2.toString());
                        e2.printStackTrace();
                    }
                    this.f53994a.f53978a = new d.a.q0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
            } finally {
                d.a.q0.t.d.d(eVar);
            }
        }
    }

    public final boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!new File(str).exists()) {
                this.f53994a.f53978a = new d.a.q0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.q0.n.o.d.a("local file save failed:", str)));
                return false;
            }
            String str2 = this.f53994a.f53979b.l;
            String b2 = d.a.q0.n.o.b.b(new File(str), true);
            if (str2 != null && b2 != null) {
                String upperCase = str2.toUpperCase();
                if (upperCase.equals(b2)) {
                    return true;
                }
                this.f53994a.f53978a = new d.a.q0.n.h.a(2202, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5 + d.a.q0.n.o.d.a("server:", upperCase, ",local", b2));
                return false;
            }
            this.f53994a.f53978a = new d.a.q0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_WRITE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_FILE_INEXIST, d.a.q0.n.o.d.a("server:", str2, ",local", b2)));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int d(d.a.q0.n.i.i.f.e eVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, eVar, i2)) == null) {
            if (d.a.q0.n.c.f53910a) {
                Log.d("PMSTaskProcessor", "download " + this.f53994a.f53979b.n + "response code:" + eVar.code());
            }
            this.f53994a.f53978a = null;
            if (i2 >= 200 && i2 <= 300) {
                d.a.q0.n.i.i.f.d body = eVar.body();
                if (body != null) {
                    long a2 = body.a();
                    if (d.a.q0.n.c.f53910a) {
                        Log.d("PMSTaskProcessor", "currentSize:" + this.f53994a.f53979b.f53933b + ",totalBytes:" + this.f53994a.f53979b.k + ",Content-Length:" + a2);
                    }
                    if (!this.f53995b.i(this.f53994a.f53979b.k)) {
                        this.f53994a.f53978a = new d.a.q0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NOSPACE);
                        return this.f53994a.f53978a.f53928a;
                    }
                    try {
                        if (e(body, a2)) {
                            this.f53994a.f53978a = new d.a.q0.n.h.a(2200, ErrorConstant.ErrorMsg.DOWNLOAD_SUCCESS);
                            return this.f53994a.f53978a.f53928a;
                        }
                    } catch (IOException e2) {
                        if (d.a.q0.n.c.f53910a) {
                            e2.printStackTrace();
                        }
                        this.f53994a.f53978a = new d.a.q0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NOSPACE, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_WRITE);
                        return this.f53994a.f53978a.f53928a;
                    }
                }
                e eVar2 = this.f53994a;
                if (eVar2.f53978a == null) {
                    eVar2.f53978a = new d.a.q0.n.h.a(2201, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                }
                return this.f53994a.f53978a.f53928a;
            }
            this.f53994a.f53978a = new d.a.q0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION);
            return this.f53994a.f53978a.f53928a;
        }
        return invokeLI.intValue;
    }

    public final boolean e(d.a.q0.n.i.i.f.d dVar, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048580, this, dVar, j)) != null) {
            return invokeLJ.booleanValue;
        }
        f<T> fVar = this.f53995b;
        c<T> cVar = fVar.f53984i;
        ReadableByteChannel readableByteChannel = null;
        try {
            T t = this.f53997d;
            File file = fVar.f53982g;
            ReadableByteChannel source = dVar.source();
            try {
                d.a.q0.n.h.a h2 = cVar.h(t, file, j, source);
                if (h2.f53928a == 2302) {
                    if (f(Channels.newInputStream(source), new FileOutputStream(this.f53995b.f53982g), j) && c(this.f53994a.f53979b.f53932a)) {
                        if (source != null && source.isOpen()) {
                            d.a.q0.t.d.d(source);
                        }
                        return true;
                    }
                    if (source != null && source.isOpen()) {
                        d.a.q0.t.d.d(source);
                    }
                    return false;
                } else if (h2.f53928a == 2300) {
                    this.f53994a.f53979b.f53933b = j;
                    this.f53995b.k();
                    if (source != null && source.isOpen()) {
                        d.a.q0.t.d.d(source);
                    }
                    return true;
                } else {
                    this.f53994a.f53978a = h2;
                    if (source != null && source.isOpen()) {
                        d.a.q0.t.d.d(source);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                readableByteChannel = source;
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.a.q0.t.d.d(readableByteChannel);
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
                    if (d.a.q0.n.c.f53910a) {
                        Log.e("PMSTaskProcessor", "safeCopyStream: " + e2.getMessage());
                    }
                    d.a.q0.t.d.d(inputStream);
                    d.a.q0.t.d.d(outputStream);
                    return false;
                }
            } finally {
                d.a.q0.t.d.d(inputStream);
                d.a.q0.t.d.d(outputStream);
            }
        }
        return invokeCommon.booleanValue;
    }
}
