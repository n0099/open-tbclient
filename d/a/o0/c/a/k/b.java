package d.a.o0.c.a.k;

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
import d.a.o0.a.e2.c.h;
import d.a.o0.c.a.f;
import d.a.o0.c.a.g;
import d.a.o0.m.d.a;
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
    public String f49627d;

    /* renamed from: e  reason: collision with root package name */
    public String f49628e;

    /* renamed from: f  reason: collision with root package name */
    public ResponseCallback<T> f49629f;

    /* renamed from: g  reason: collision with root package name */
    public int f49630g;

    /* renamed from: h  reason: collision with root package name */
    public a.C1150a f49631h;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f49632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f49633b;

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
            this.f49633b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (d.a.o0.c.a.a.f49579a) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!g.l().m().b()) {
                        this.f49633b.f49629f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    g.l().m().a();
                    this.f49633b.i(true);
                    this.f49633b.p();
                    return;
                }
                g.l().m().k();
                b bVar = this.f49633b;
                if (!bVar.f49634a) {
                    if (bVar.f49629f != null) {
                        this.f49633b.f49629f.onSuccess(this.f49632a, i2);
                        this.f49633b.f49630g = 0;
                    }
                } else if (bVar.f49635b == 1) {
                    f.a("application");
                    if (this.f49633b.f49629f != null) {
                        this.f49633b.f49629f.onSuccess(this.f49632a, i2);
                    }
                    this.f49633b.f49630g = 0;
                } else if (b.m(bVar) >= 3) {
                    ResponseCallback responseCallback = this.f49633b.f49629f;
                    responseCallback.onFail(new IOException("request fail : " + this.f49632a));
                    this.f49633b.f49630g = 0;
                } else {
                    b bVar2 = this.f49633b;
                    bVar2.q(bVar2.f49627d, this.f49633b.f49628e, this.f49633b.f49629f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (d.a.o0.c.a.a.f49579a) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (this.f49633b.f49629f != null) {
                    this.f49633b.f49629f.onFail(exc);
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
                b bVar = this.f49633b;
                if (!bVar.f49634a) {
                    if (bVar.f49629f != null) {
                        this.f49632a = (T) this.f49633b.f49629f.parseResponse(response, i2);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g2 = this.f49633b.g(body.bytes());
                if (d.a.o0.c.a.a.f49579a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g2);
                }
                if (this.f49633b.f49635b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g2, Charset.forName("utf-8"));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.f49633b.f49629f != null) {
                        this.f49632a = (T) this.f49633b.f49629f.parseResponse(build, i2);
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
        this.f49627d = null;
        this.f49628e = null;
        this.f49629f = null;
    }

    public static /* synthetic */ int m(b bVar) {
        int i2 = bVar.f49630g;
        bVar.f49630g = i2 + 1;
        return i2;
    }

    @Override // d.a.o0.c.a.k.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.c.a.k.c
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f49629f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // d.a.o0.c.a.k.c
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (d.a.o0.c.a.a.f49579a) {
                Log.d("BDTLS", "onRequestError=" + i2);
            }
            ResponseCallback<T> responseCallback = this.f49629f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i2));
            }
        }
    }

    @Override // d.a.o0.c.a.k.c
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.f49627d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.f49634a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (d.a.o0.c.a.a.f49579a) {
                Log.d("BDTLS", "BdtlsPostRequest url=" + str);
            }
            h a2 = d.a.o0.a.c1.a.p().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.o0.m.e.a.g().postByteRequest();
            a.C1150a c1150a = this.f49631h;
            if (c1150a != null) {
                postByteRequest.connectionTimeout(c1150a.f51106a).readTimeout(this.f49631h.f51107b).writeTimeout(this.f49631h.f51108c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.f49627d, this.f49628e, this.f49629f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f49627d = str;
        this.f49628e = str2;
        this.f49629f = responseCallback;
        if (d.a.o0.c.a.a.f49579a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.f49628e);
    }
}
