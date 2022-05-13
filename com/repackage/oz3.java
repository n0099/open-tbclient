package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oz3 extends zy3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes6.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ az3 b;
        public final /* synthetic */ oz3 c;

        public a(oz3 oz3Var, String str, az3 az3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, str, az3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = str;
            this.b = az3Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.b.cancelTag(this.c.c);
                this.c.X(this.a, 0, iOException.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    try {
                        JSEvent jSEvent = new JSEvent("headersReceived");
                        jSEvent.data = new mz3(this.c.J(response.headers()));
                        this.c.dispatchEvent(jSEvent);
                    } catch (JSONException e) {
                        try {
                            if (zy3.e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (zy3.e) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.c.D(this.a, -1, e.getMessage());
                        }
                    }
                    nz3 nz3Var = new nz3();
                    nz3Var.statusCode = response.code();
                    nz3Var.header = this.c.J(response.headers());
                    nz3Var.data = this.c.Y(response.body());
                    if (zy3.e) {
                        Log.d("UploadFileTask", "onResponse = " + nz3Var.data);
                    }
                    this.c.E(nz3Var);
                } catch (IOException e3) {
                    e = e3;
                    if (zy3.e) {
                    }
                    this.c.D(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements os2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ oz3 c;

        public b(oz3 oz3Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz3Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz3Var;
            this.a = j;
            this.b = str;
        }

        @Override // com.repackage.os2
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.c.W(this.a, j, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz3(e82 e82Var, bt1 bt1Var) {
        super(e82Var, bt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var, bt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e82) objArr2[0], (bt1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.a = 3;
    }

    public static void Z(MultipartBody.Builder builder, bt1 bt1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, builder, bt1Var) == null) || builder == null || bt1Var == null || bt1Var.k() < 1) {
            return;
        }
        for (String str : bt1Var.j()) {
            if (!TextUtils.isEmpty(str)) {
                String H = bt1Var.H(str);
                if (!TextUtils.isEmpty(H)) {
                    builder.addFormDataPart(str, H);
                }
            }
        }
    }

    @Override // com.repackage.zy3
    public void D(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            super.D(str, i, str2);
            n14.k(str, i, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = A();
            if (!TextUtils.isEmpty(A)) {
                String B = this.b.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (xg4.x(B)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.b.b("header") && this.b.getType("header") != 9) {
                    D(A, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File V = V(A, B);
                    if (V != null) {
                        bt1 w = this.b.w("formData");
                        Request.Builder builder = new Request.Builder();
                        yr2 yr2Var = new yr2(V, IMAudioTransRequest.CONTENT_TYPE, new b(this, V.length(), A));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Z(type, w);
                        type.addFormDataPart(this.b.B("name"), V.getName(), yr2Var);
                        MultipartBody build = type.build();
                        H(builder, this.b.w("header"), new HashMap(), false);
                        return builder.url(A).tag(this.c).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File V(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = hm2.U().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        D(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.b.B("name"))) {
                        D(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.b.b("formData") || this.b.getType("formData") == 9) {
                        return file;
                    } else {
                        D(str, -1, "uploadFile:formData is invalid");
                        return null;
                    }
                }
                D(str, -1, "request:file not exists or not file");
                return null;
            }
            D(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void W(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) || j <= 0 || j2 > j || j2 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - this.h > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new pz3(floor, j, j2)));
            }
            this.h = System.currentTimeMillis();
        }
    }

    public final void X(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            if (zy3.e) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            D(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public final Object Y(ResponseBody responseBody) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
            if (responseBody == null) {
                return null;
            }
            String string = responseBody.string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return string;
            }
        }
        return invokeL.objValue;
    }

    public void start() {
        Request U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.b == null || (U = U()) == null) {
            return;
        }
        if (u03.L() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = U.url().toString();
        az3 az3Var = (az3) u03.L().h0();
        az3Var.call(U, new a(this, httpUrl, az3Var));
    }
}
