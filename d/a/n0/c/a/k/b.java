package d.a.n0.c.a.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e2.c.h;
import d.a.n0.c.a.f;
import d.a.n0.c.a.g;
import d.a.n0.m.d.a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes7.dex */
public class b<T> extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f49123d;

    /* renamed from: e  reason: collision with root package name */
    public String f49124e;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f49125f;

    /* renamed from: g  reason: collision with root package name */
    public int f49126g;

    /* renamed from: h  reason: collision with root package name */
    public a.C1141a f49127h;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f49128a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f49129b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49129b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!g.l().m().b()) {
                        this.f49129b.f49125f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    g.l().m().a();
                    this.f49129b.i(true);
                    this.f49129b.p();
                    return;
                }
                g.l().m().k();
                b bVar = this.f49129b;
                if (!bVar.f49130a) {
                    if (bVar.f49125f != null) {
                        this.f49129b.f49125f.onSuccess(this.f49128a, i2);
                        this.f49129b.f49126g = 0;
                    }
                } else if (bVar.f49131b == 1) {
                    f.a("application");
                    if (this.f49129b.f49125f != null) {
                        this.f49129b.f49125f.onSuccess(this.f49128a, i2);
                    }
                    this.f49129b.f49126g = 0;
                } else if (b.m(bVar) >= 3) {
                    ResponseCallback responseCallback = this.f49129b.f49125f;
                    responseCallback.onFail(new IOException("request fail : " + this.f49128a));
                    this.f49129b.f49126g = 0;
                } else {
                    b bVar2 = this.f49129b;
                    bVar2.q(bVar2.f49123d, this.f49129b.f49124e, this.f49129b.f49125f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (this.f49129b.f49125f != null) {
                    this.f49129b.f49125f.onFail(exc);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                Headers headers = response.headers();
                String str = headers.get("Bdtls");
                if (headers != null && TextUtils.equals(str, "recovery")) {
                    g.l().m().s(0);
                    return "recovery";
                }
                b bVar = this.f49129b;
                if (!bVar.f49130a) {
                    if (bVar.f49125f != null) {
                        this.f49128a = (T) this.f49129b.f49125f.parseResponse(response, i2);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f49129b.g(body.bytes());
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
                }
                if (this.f49129b.f49131b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f49129b.f49125f != null) {
                        this.f49128a = (T) this.f49129b.f49125f.parseResponse(build, i2);
                    }
                }
                return g2;
            }
            return (String) invokeLI.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49123d = null;
        this.f49124e = null;
        this.f49125f = null;
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f49126g;
        bVar.f49126g = i2 + 1;
        return i2;
    }

    @Override // d.a.n0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // d.a.n0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f49125f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // d.a.n0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (d.a.n0.c.a.a.f49075a) {
                Log.d("BDTLS", "onRequestError=" + i2);
            }
            ResponseCallback<T> responseCallback = this.f49125f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i2));
            }
        }
    }

    @Override // d.a.n0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f49123d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.f49130a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (d.a.n0.c.a.a.f49075a) {
                Log.d("BDTLS", "BdtlsPostRequest url=" + str);
            }
            h a2 = d.a.n0.a.c1.a.p().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.n0.m.e.a.g().postByteRequest();
            a.C1141a c1141a = this.f49127h;
            if (c1141a != null) {
                postByteRequest.connectionTimeout(c1141a.f50602a).readTimeout(this.f49127h.f50603b).writeTimeout(this.f49127h.f50604c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f49123d, this.f49124e, this.f49125f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f49123d = str;
        this.f49124e = str2;
        this.f49125f = responseCallback;
        if (d.a.n0.c.a.a.f49075a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f49124e);
    }
}
