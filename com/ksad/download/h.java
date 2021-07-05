package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
/* loaded from: classes7.dex */
public class h implements com.kwai.filedownloader.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f33549a;

    /* renamed from: b  reason: collision with root package name */
    public final Request.Builder f33550b;

    /* renamed from: c  reason: collision with root package name */
    public Request f33551c;

    /* renamed from: d  reason: collision with root package name */
    public Response f33552d;

    /* renamed from: com.ksad.download.h$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public OkHttpClient f33553a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f33554b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33554b = z ? h.j() : h.i();
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f33553a == null) {
                    synchronized (a.class) {
                        if (this.f33553a == null) {
                            this.f33553a = this.f33554b != null ? this.f33554b.build() : new OkHttpClient();
                            this.f33554b = null;
                        }
                    }
                }
                return new h(str, this.f33553a, null);
            }
            return (com.kwai.filedownloader.a.b) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, okHttpClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Request.Builder) objArr2[0], (OkHttpClient) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ h(String str, OkHttpClient okHttpClient, AnonymousClass1 anonymousClass1) {
        this(str, okHttpClient);
    }

    public h(Request.Builder builder, OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, okHttpClient};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33550b = builder;
        this.f33549a = okHttpClient;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            String a2 = a("Content-Type");
            String b2 = com.ksad.download.d.a.b(str);
            String str2 = ".apk";
            if (TextUtils.isEmpty(a2) || !TextUtils.isEmpty(b2)) {
                if (TextUtils.isEmpty(str)) {
                    return System.currentTimeMillis() + ".apk";
                }
                return str;
            }
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(a2);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            if (!TextUtils.isEmpty(extensionFromMimeType)) {
                str2 = "." + extensionFromMimeType;
            }
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static OkHttpClient.Builder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true) : (OkHttpClient.Builder) invokeV.objValue;
    }

    public static OkHttpClient.Builder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).protocols(Util.immutableList(Protocol.HTTP_1_1)).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true) : (OkHttpClient.Builder) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Response response = this.f33552d;
            if (response != null) {
                return com.kwad.sdk.core.h.b.a().b(response.body().byteStream());
            }
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!"Content-Disposition".equals(str)) {
                Response response = this.f33552d;
                if (response == null) {
                    return null;
                }
                return response.header(str);
            }
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(com.kwai.filedownloader.f.f.g(this.f33552d.header(str)))) {
                List<String> pathSegments = this.f33552d.request().url().pathSegments();
                str2 = pathSegments.get(pathSegments.size() - 1);
                return "attachment; filename=\"" + b(str2) + "\"";
            }
            return this.f33552d.header(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f33550b.addHeader(str, str2);
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33551c == null) {
                this.f33551c = this.f33550b.build();
            }
            return this.f33551c.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Response response = this.f33552d;
            if (response == null) {
                return null;
            }
            return response.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f33551c == null) {
                this.f33551c = this.f33550b.build();
            }
            this.f33552d = this.f33549a.newCall(this.f33551c).execute();
        }
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Response response = this.f33552d;
            if (response != null) {
                return response.code();
            }
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f33551c = null;
            Response response = this.f33552d;
            if (response != null && response.body() != null) {
                this.f33552d.body().close();
            }
            this.f33552d = null;
        }
    }
}
