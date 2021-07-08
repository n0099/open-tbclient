package d.a.n0.h.y.d;

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
import d.a.n0.a.c2.f.f;
import d.a.n0.a.j2.k;
import d.a.n0.a.n1.o.a;
import d.a.n0.h.y.f.e;
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
public class b extends d.a.n0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50358a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.h.y.b f50359b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f50360c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.k2.f.d f50361d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50362e;

        public a(b bVar, String str, d.a.n0.h.y.b bVar2, boolean z, d.a.n0.a.k2.f.d dVar) {
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
            this.f50362e = bVar;
            this.f50358a = str;
            this.f50359b = bVar2;
            this.f50360c = z;
            this.f50361d = dVar;
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f50362e.D(this.f50358a, -1, "downloadFile:fail exceed max file size");
                this.f50359b.cancelTag(this.f50362e.f50348g);
            }
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f50362e.l <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i2 <= 100) {
                    d.a.n0.h.y.d.a aVar = new d.a.n0.h.y.d.a(i2, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = aVar;
                    this.f50362e.dispatchEvent(jSEvent);
                }
                if (this.f50360c && this.f50361d.d().a(j)) {
                    this.f50362e.D(this.f50358a, -1, "downloadFile:fail exceed max file size");
                    this.f50359b.cancelTag(this.f50362e.f50348g);
                }
            } else {
                this.f50362e.D(this.f50358a, -1, "downloadFile:fail exceed max file size");
                this.f50359b.cancelTag(this.f50362e.f50348g);
            }
            this.f50362e.l = System.currentTimeMillis();
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f50362e.D(this.f50358a, 0, "progress callback fail()");
                this.f50359b.cancelTag(this.f50362e.f50348g);
            }
        }
    }

    /* renamed from: d.a.n0.h.y.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1126b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50363a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50365c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.k2.f.d f50366d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50368f;

        public C1126b(b bVar, String str, String str2, String str3, d.a.n0.a.k2.f.d dVar, boolean z) {
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
            this.f50368f = bVar;
            this.f50363a = str;
            this.f50364b = str2;
            this.f50365c = str3;
            this.f50366d = dVar;
            this.f50367e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f50368f.D(this.f50363a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    k.r(0, this.f50363a, 1, iOException.getMessage());
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
                    jSEvent.data = new e(this.f50368f.J(response.headers()));
                    this.f50368f.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (b.m) {
                        e2.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(this.f50364b)) {
                    U = f.A(response, this.f50365c);
                } else {
                    U = this.f50368f.U(this.f50364b);
                }
                if (!TextUtils.isEmpty(U)) {
                    if (b.m) {
                        Log.d("DownloadTask", "the real file path is " + U);
                    }
                    if (TextUtils.isEmpty(this.f50364b)) {
                        str = this.f50366d.g(U);
                    } else {
                        str = this.f50364b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f50368f.D(this.f50363a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(this.f50364b)) {
                        cVar.tempFilePath = str;
                    } else {
                        cVar.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(U);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.f50367e) {
                            this.f50366d.d().b(-length);
                        }
                    }
                    if (this.f50368f.V(byteStream, file)) {
                        if (this.f50367e) {
                            this.f50366d.d().b(file.length());
                        }
                        this.f50368f.E(cVar);
                    } else {
                        this.f50368f.D(this.f50363a, -1, "downloadFile:fail abort");
                    }
                    d.a.n0.t.d.d(byteStream);
                    d.a.n0.t.d.d(response);
                    if (b.m) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.f50363a + ", msg=" + message);
                    }
                    k.r(code, this.f50363a, 1, message);
                    return;
                }
                this.f50368f.D(this.f50363a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(227974665, "Ld/a/n0/h/y/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(227974665, "Ld/a/n0/h/y/d/b;");
                return;
            }
        }
        m = d.a.n0.a.k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.n0.a.l0.c cVar, d.a.n0.a.y.b.a aVar) {
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
                super((d.a.n0.a.l0.c) objArr2[0], (d.a.n0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50346e = 2;
    }

    @Override // d.a.n0.h.y.a
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            d.a.n0.h.f0.e.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void T(Request request, String str, String str2, d.a.n0.h.y.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, bVar, dVar) == null) {
            String httpUrl = request.url().toString();
            d.a.n0.a.k2.f.d I = d.a.n0.a.g1.f.V().I();
            boolean b2 = I.b(str);
            k.x(httpUrl, 1);
            bVar.a(request, Collections.singletonList(dVar), new C1126b(this, httpUrl, str, str2, I, b2));
        }
    }

    @Nullable
    public String U(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = d.a.n0.a.g1.f.V().I().i(str);
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
                    d.a.n0.t.d.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a.n0.t.d.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a.n0.t.d.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f50347f == null) {
            return;
        }
        String A = A();
        if (TextUtils.isEmpty(A)) {
            return;
        }
        if (d.a.n0.a.a2.e.i() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        d.a.n0.h.y.b bVar = (d.a.n0.h.y.b) d.a.n0.a.a2.e.i().X();
        String C = this.f50347f.C("filePath");
        if (!TextUtils.isEmpty(C)) {
            if (d.a.n0.t.d.w(C)) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = C.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        d.a.n0.a.k2.f.d I = d.a.n0.a.g1.f.V().I();
        boolean b2 = I.b(C);
        if (b2 && I.d().a(0L)) {
            D(A, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        H(builder, this.f50347f.x("header"), hashMap, false);
        builder.url(A).tag(this.f50348g).build();
        String s = d.a.n0.t.d.s(A);
        this.l = 0L;
        d dVar = new d();
        dVar.c(new a(this, A, bVar, b2, I));
        T(builder.build(), C, s, bVar, dVar);
    }
}
