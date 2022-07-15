package com.repackage;

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
import com.repackage.xr2;
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
public class qy3 extends my3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes7.dex */
    public class a implements xr2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ny3 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ k83 d;
        public final /* synthetic */ qy3 e;

        public a(qy3 qy3Var, String str, ny3 ny3Var, boolean z, k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy3Var, str, ny3Var, Boolean.valueOf(z), k83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qy3Var;
            this.a = str;
            this.b = ny3Var;
            this.c = z;
            this.d = k83Var;
        }

        @Override // com.repackage.xr2.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.e.D(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
        }

        @Override // com.repackage.xr2.b
        public void b(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.e.h <= 500) {
                return;
            }
            if (j2 <= 52428800 && j <= 52428800) {
                if (i <= 100) {
                    py3 py3Var = new py3(i, j2, j);
                    JSEvent jSEvent = new JSEvent("progressUpdate");
                    jSEvent.data = py3Var;
                    this.e.dispatchEvent(jSEvent);
                }
                if (this.c && this.d.d().a(j)) {
                    this.e.D(this.a, -1, "downloadFile:fail exceed max file size");
                    this.b.cancelTag(this.e.c);
                }
            } else {
                this.e.D(this.a, -1, "downloadFile:fail exceed max file size");
                this.b.cancelTag(this.e.c);
            }
            this.e.h = System.currentTimeMillis();
        }

        @Override // com.repackage.xr2.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.e.D(this.a, 0, "progress callback fail()");
                this.b.cancelTag(this.e.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ k83 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ qy3 f;

        public b(qy3 qy3Var, String str, String str2, String str3, k83 k83Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy3Var, str, str2, str3, k83Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qy3Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = k83Var;
            this.e = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f.D(this.a, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.i(null)) {
                    a73.u(0, this.a, 1, iOException.getMessage());
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new zy3(this.f.J(response.headers()));
                    this.f.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (qy3.i) {
                        e.printStackTrace();
                    }
                }
                String str2 = null;
                try {
                    if (TextUtils.isEmpty(this.b)) {
                        str2 = k13.A(this.f.J(response.headers()), this.c);
                    } else {
                        str2 = this.f.V(this.b);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (qy3.i) {
                        Log.d("DownloadTask", "the real file path is " + str2);
                    }
                    if (TextUtils.isEmpty(this.b)) {
                        str = this.d.g(str2);
                    } else {
                        str = this.b;
                    }
                    if (TextUtils.isEmpty(str)) {
                        this.f.D(this.a, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    ry3 ry3Var = new ry3();
                    ry3Var.statusCode = code;
                    if (TextUtils.isEmpty(this.b)) {
                        ry3Var.tempFilePath = str;
                    } else {
                        ry3Var.filePath = str;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(str2);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (this.e) {
                            this.d.d().b(-length);
                        }
                    }
                    if (this.f.W(byteStream, file)) {
                        if (this.e) {
                            this.d.d().b(file.length());
                        }
                        this.f.E(ry3Var);
                    } else {
                        this.f.D(this.a, -1, "downloadFile:fail abort");
                    }
                    jg4.d(byteStream);
                    jg4.d(response);
                    if (qy3.i) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + this.a + ", msg=" + message);
                    }
                    a73.u(code, this.a, 1, message);
                    return;
                }
                this.f.D(this.a, -1, "downloadFile:filePath is invalid");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755363834, "Lcom/repackage/qy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755363834, "Lcom/repackage/qy3;");
                return;
            }
        }
        i = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy3(r72 r72Var, os1 os1Var) {
        super(r72Var, os1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var, os1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((r72) objArr2[0], (os1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 2;
    }

    @Override // com.repackage.my3
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            a14.c(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public void U(Request request, String str, String str2, ny3 ny3Var, sy3 sy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str, str2, ny3Var, sy3Var) == null) {
            String httpUrl = request.url().toString();
            k83 G = ul2.U().G();
            boolean b2 = G.b(str);
            a73.A(httpUrl, 1);
            ny3Var.call(request, Collections.singletonList(sy3Var), new b(this, httpUrl, str, str2, G, b2));
        }
    }

    @Nullable
    public String V(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = ul2.U().G().i(str);
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

    public boolean W(InputStream inputStream, File file) {
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
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    jg4.d(fileOutputStream);
                    return true;
                }
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            jg4.d(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            jg4.d(fileOutputStream2);
            throw th;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.b == null) {
            return;
        }
        String A = A();
        if (TextUtils.isEmpty(A)) {
            return;
        }
        if (h03.M() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        ny3 ny3Var = (ny3) h03.M().i0();
        String B = this.b.B("filePath");
        if (!TextUtils.isEmpty(B)) {
            if (jg4.x(B)) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
            String[] split = B.split("/");
            if (TextUtils.isEmpty(split[split.length - 1])) {
                D(A, -1, "downloadFile:filePath is invalid");
                return;
            }
        }
        k83 G = ul2.U().G();
        boolean b2 = G.b(B);
        if (b2 && G.d().a(0L)) {
            D(A, -1, "downloadFile:fail exceed max size in usr");
            return;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        H(builder, this.b.w("header"), hashMap, false);
        builder.url(A).tag(this.c).build();
        String t = jg4.t(A);
        this.h = 0L;
        sy3 sy3Var = new sy3();
        sy3Var.c(new a(this, A, ny3Var, b2, G));
        U(builder.build(), B, t, ny3Var, sy3Var);
    }
}
