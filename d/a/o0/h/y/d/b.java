package d.a.o0.h.y.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.f;
import d.a.o0.a.j2.k;
import d.a.o0.a.n1.o.a;
import d.a.o0.h.y.f.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class b extends d.a.o0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.y.b f50863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f50864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.k2.f.d f50865d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50866e;

        public a(b bVar, String str, d.a.o0.h.y.b bVar2, boolean z, d.a.o0.a.k2.f.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2, Boolean.valueOf(z), dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50866e = bVar;
            this.f50862a = str;
            this.f50863b = bVar2;
            this.f50864c = z;
            this.f50865d = dVar;
        }

        @Override // d.a.o0.a.n1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f50866e.D(this.f50862a, -1, "downloadFile:fail exceed max file size");
                this.f50863b.cancelTag(this.f50866e.f50852g);
            }
        }

        @Override // d.a.o0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f50866e.l <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i2 <= 100) {
                    d.a.o0.h.y.d.a aVar = new d.a.o0.h.y.d.a(i2, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f50866e.dispatchEvent(jSEvent);
                }
                if (this.f50864c && this.f50865d.d().a(j)) {
                    this.f50866e.D(this.f50862a, -1, "downloadFile:fail exceed max file size");
                    this.f50863b.cancelTag(this.f50866e.f50852g);
                }
            } else {
                this.f50866e.D(this.f50862a, -1, "downloadFile:fail exceed max file size");
                this.f50863b.cancelTag(this.f50866e.f50852g);
            }
            this.f50866e.l = System.currentTimeMillis();
        }

        @Override // d.a.o0.a.n1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f50866e.D(this.f50862a, 0, "progress callback fail()");
                this.f50863b.cancelTag(this.f50866e.f50852g);
            }
        }
    }

    /* renamed from: d.a.o0.h.y.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1135b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.k2.f.d f50870d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50872f;

        public C1135b(b bVar, String str, String str2, String str3, d.a.o0.a.k2.f.d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50872f = bVar;
            this.f50867a = str;
            this.f50868b = str2;
            this.f50869c = str3;
            this.f50870d = dVar;
            this.f50871e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f50872f.D(this.f50867a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    k.r(0, this.f50867a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String U;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f50872f.J(response.headers()));
                    this.f50872f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(this.f50868b)) {
                    U = f.A(response, this.f50869c);
                } else {
                    U = this.f50872f.U(this.f50868b);
                }
                if (!TextUtils.isEmpty(U)) {
                    if (b.m) {
                        Log.d("DownloadTask", "the real file path is " + U);
                    }
                    if (TextUtils.isEmpty(this.f50868b)) {
                        str = this.f50870d.g(U);
                    } else {
                        str = this.f50868b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f50872f.D(this.f50867a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f50868b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(U);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f50871e) {
                            this.f50870d.d().b(-length);
                        }
                    }
                    if (this.f50872f.V(byteStream, file)) {
                        if (this.f50871e) {
                            this.f50870d.d().b(file.length());
                        }
                        this.f50872f.E(cVar);
                    } else {
                        this.f50872f.D(this.f50867a, -1, "downloadFile:fail abort");
                    }
                    d.a.o0.t.d.d(byteStream);
                    d.a.o0.t.d.d(response);
                    if (b.m) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.f50867a + ", msg=" + message);
                    }
                    k.r(code, this.f50867a, 1, message);
                    return;
                }
                this.f50872f.D(this.f50867a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1568976694, "Ld/a/o0/h/y/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1568976694, "Ld/a/o0/h/y/d/b;");
                return;
            }
        }
        m = d.a.o0.a.k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.a.l0.c cVar, d.a.o0.a.y.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.o0.a.l0.c) objArr2[0], (d.a.o0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50850e = 2;
    }

    @Override // d.a.o0.h.y.a
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            d.a.o0.h.f0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void T(Request request, String str, String str2, d.a.o0.h.y.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            d.a.o0.a.k2.f.d I = d.a.o0.a.g1.f.V().I();
            boolean b2 = I.b(str);
            k.x(httpUrl, 1);
            bVar.a(request, Collections.singletonList(dVar), new C1135b(this, httpUrl, str, str2, I, b2));
        }
    }

    @Nullable
    public String U(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = d.a.o0.a.g1.f.V().I().i(str);
            if (i2 == null) {
                return null;
            }
            boolean endsWith = i2.endsWith(File.separator);
            File parentFile = new File(i2).getParentFile();
            boolean z = parentFile != null && parentFile.exists();
            if (endsWith || !z) {
                return null;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }

    public boolean V(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    d.a.o0.t.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.o0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.o0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f50851f == null) {
            return;
        }
        String A = A();
        if (TextUtils.isEmpty(A)) {
            return;
        }
        if (d.a.o0.a.a2.e.i() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        d.a.o0.h.y.b bVar = (d.a.o0.h.y.b) d.a.o0.a.a2.e.i().X();
        String C = this.f50851f.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (d.a.o0.t.d.w(C)) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        d.a.o0.a.k2.f.d I = d.a.o0.a.g1.f.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            D(A, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        H(builder, this.f50851f.x("header"), hashMap, false);
        builder.url(A).tag(this.f50852g).build();
        String s = d.a.o0.t.d.s(A);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, A, bVar, b2, I));
        T(builder.build(), C, s, bVar, dVar);
    }
}
