package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes7.dex */
public class sr<T> extends tr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public ResponseCallback<T> e;
    public int f;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;
        public final /* synthetic */ sr b;

        public a(sr srVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {srVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = srVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i)) == null) {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    wr.b().i().b(0);
                    return "recovery";
                }
                sr srVar = this.b;
                if (!srVar.a) {
                    if (srVar.e != null) {
                        this.a = (T) this.b.e.parseResponse(response, i);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g = this.b.g(body.bytes());
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest parseResponse=" + g);
                if (this.b.b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.b.e != null) {
                        this.a = (T) this.b.e.parseResponse(build, i);
                    }
                }
                return g;
            }
            return (String) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onSuccess=" + str);
                if (TextUtils.equals(str, "recovery")) {
                    if (!wr.b().i().m()) {
                        this.b.e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    wr.b().i().f();
                    this.b.e(true);
                    this.b.k();
                    return;
                }
                wr.b().i().n();
                sr srVar = this.b;
                if (!srVar.a) {
                    if (srVar.e != null) {
                        this.b.e.onSuccess(this.a, i);
                        this.b.f = 0;
                    }
                } else if (srVar.b == 1) {
                    if (srVar.e != null) {
                        this.b.e.onSuccess(this.a, i);
                    }
                    this.b.f = 0;
                } else if (sr.m(srVar) >= 3) {
                    ResponseCallback responseCallback = this.b.e;
                    responseCallback.onFail(new IOException("request fail : " + this.a));
                    this.b.f = 0;
                } else {
                    sr srVar2 = this.b;
                    srVar2.j(srVar2.c, this.b.d, this.b.e);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onFail=" + exc.getMessage());
                if (this.b.e != null) {
                    this.b.e.onFail(exc);
                }
            }
        }
    }

    public sr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public static /* synthetic */ int m(sr srVar) {
        int i = srVar.f;
        srVar.f = i + 1;
        return i;
    }

    @Override // com.repackage.tr
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.repackage.tr
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("onRequestError=" + i);
            ResponseCallback<T> responseCallback = this.e;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i));
            }
        }
    }

    @Override // com.repackage.tr
    public void c(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) || (responseCallback = this.e) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // com.repackage.tr
    public void f(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.c;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
                hashMap.put("Bdtls-Content-Type", "json");
            }
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("BdtlsPostRequest url=" + str);
            HttpManager.getDefault(ar.c.h().getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(CookieManager.WEBKIT_COOKIES).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public void j(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
        this.d = str2;
        this.e = responseCallback;
        DebugTrace debugTrace = DebugTrace.a;
        debugTrace.a("requestPost url=" + str);
        DebugTrace debugTrace2 = DebugTrace.a;
        debugTrace2.a("requestPost body=" + str2);
        d(this.d);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j(this.c, this.d, this.e);
        }
    }
}
