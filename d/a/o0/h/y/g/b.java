package d.a.o0.h.y.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.h.y.f.e;
import d.a.o0.t.d;
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
/* loaded from: classes7.dex */
public class b extends d.a.o0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    /* loaded from: classes7.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50886a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.y.b f50887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50888c;

        public a(b bVar, String str, d.a.o0.h.y.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50888c = bVar;
            this.f50886a = str;
            this.f50887b = bVar2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f50887b.cancelTag(this.f50888c.f50852g);
                this.f50888c.X(this.f50886a, 0, iOException.getMessage());
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
                        jSEvent.data = new e(this.f50888c.J(response.headers()));
                        this.f50888c.dispatchEvent(jSEvent);
                    } catch (JSONException e2) {
                        try {
                            if (d.a.o0.h.y.a.f50849i) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (d.a.o0.h.y.a.f50849i) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.f50888c.D(this.f50886a, -1, e.getMessage());
                        }
                    }
                    d.a.o0.h.y.g.a aVar = new d.a.o0.h.y.g.a();
                    aVar.statusCode = response.code();
                    aVar.header = this.f50888c.J(response.headers());
                    aVar.data = this.f50888c.Y(response.body());
                    if (d.a.o0.h.y.a.f50849i) {
                        Log.d("UploadFileTask", "onResponse = " + aVar.data);
                    }
                    this.f50888c.E(aVar);
                } catch (IOException e4) {
                    e = e4;
                    if (d.a.o0.h.y.a.f50849i) {
                    }
                    this.f50888c.D(this.f50886a, -1, e.getMessage());
                }
            }
        }
    }

    /* renamed from: d.a.o0.h.y.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1136b implements d.a.o0.a.n1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f50889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50891c;

        public C1136b(b bVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50891c = bVar;
            this.f50889a = j;
            this.f50890b = str;
        }

        @Override // d.a.o0.a.n1.p.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f50891c.W(this.f50889a, j, this.f50890b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.a.l0.c cVar, d.a.o0.a.y.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.o0.a.l0.c) objArr2[0], (d.a.o0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0L;
        this.f50850e = 3;
    }

    public static void Z(MultipartBody.Builder builder, d.a.o0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, builder, aVar) == null) || builder == null || aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str)) {
                String I = aVar.I(str);
                if (!TextUtils.isEmpty(I)) {
                    builder.addFormDataPart(str, I);
                }
            }
        }
    }

    @Override // d.a.o0.h.y.a
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            d.a.o0.h.f0.e.k(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = A();
            if (!TextUtils.isEmpty(A)) {
                String C = this.f50851f.C("filePath");
                if (TextUtils.isEmpty(C)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (d.w(C)) {
                    D(A, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.f50851f.b("header") && this.f50851f.i("header") != 9) {
                    D(A, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File V = V(A, C);
                    if (V != null) {
                        d.a.o0.a.y.b.a x = this.f50851f.x("formData");
                        Request.Builder builder = new Request.Builder();
                        d.a.o0.a.n1.c cVar = new d.a.o0.a.n1.c(V, IMAudioTransRequest.CONTENT_TYPE, new C1136b(this, V.length(), A));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Z(type, x);
                        type.addFormDataPart(this.f50851f.C("name"), V.getName(), cVar);
                        MultipartBody build = type.build();
                        H(builder, this.f50851f.x("header"), new HashMap(), false);
                        return builder.url(A).tag(this.f50852g).post(build).build();
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
            String a2 = f.V().I().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        D(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.f50851f.C("name"))) {
                        D(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.f50851f.b("formData") || this.f50851f.i("formData") == 9) {
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
        if (System.currentTimeMillis() - this.l > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new c(floor, j, j2)));
            }
            this.l = System.currentTimeMillis();
        }
    }

    public final void X(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            if (d.a.o0.h.y.a.f50849i) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            D(str, i2, ("Socket is closed".equalsIgnoreCase(str2) || ResponseException.CANCELED.equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f50851f == null || (U = U()) == null) {
            return;
        }
        if (d.a.o0.a.a2.e.i() == null) {
            D("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = U.url().toString();
        d.a.o0.h.y.b bVar = (d.a.o0.h.y.b) d.a.o0.a.a2.e.i().X();
        bVar.b(U, new a(this, httpUrl, bVar));
    }
}
