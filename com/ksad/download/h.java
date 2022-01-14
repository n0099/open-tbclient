package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.c;
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
/* loaded from: classes3.dex */
public class h implements com.kwai.filedownloader.kwai.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;

    /* renamed from: b  reason: collision with root package name */
    public final Request.Builder f55014b;

    /* renamed from: c  reason: collision with root package name */
    public Request f55015c;

    /* renamed from: d  reason: collision with root package name */
    public Response f55016d;

    /* renamed from: com.ksad.download.h$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f55017b;

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
            this.f55017b = z ? h.j() : h.i();
        }

        @Override // com.kwai.filedownloader.e.c.b
        public com.kwai.filedownloader.kwai.b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a == null) {
                    synchronized (a.class) {
                        if (this.a == null) {
                            this.a = this.f55017b != null ? this.f55017b.build() : new OkHttpClient();
                            this.f55017b = null;
                        }
                    }
                }
                return new h(str, this.a, null);
            }
            return (com.kwai.filedownloader.kwai.b) invokeL.objValue;
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
        this.f55014b = builder;
        this.a = okHttpClient;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            String a2 = a("Content-Type");
            String b2 = com.ksad.download.c.a.b(str);
            boolean isEmpty = TextUtils.isEmpty(a2);
            String str2 = Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
            if (isEmpty || !TextUtils.isEmpty(b2)) {
                if (TextUtils.isEmpty(str)) {
                    return System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true) : (OkHttpClient.Builder) invokeV.objValue;
    }

    public static OkHttpClient.Builder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).protocols(Util.immutableList(Protocol.HTTP_1_1)).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true) : (OkHttpClient.Builder) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public InputStream a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Response response = this.f55016d;
            if (response != null) {
                return com.kwad.sdk.core.h.b.a().b(response.body().byteStream());
            }
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!"Content-Disposition".equals(str)) {
                Response response = this.f55016d;
                if (response == null) {
                    return null;
                }
                return response.header(str);
            }
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(com.kwai.filedownloader.e.f.g(this.f55016d.header(str)))) {
                List<String> pathSegments = this.f55016d.request().url().pathSegments();
                str2 = pathSegments.get(pathSegments.size() - 1);
                return "attachment; filename=\"" + b(str2) + "\"";
            }
            return this.f55016d.header(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f55014b.addHeader(str, str2);
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public boolean a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) {
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f55015c == null) {
                this.f55015c = this.f55014b.build();
            }
            return this.f55015c.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public Map<String, List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Response response = this.f55016d;
            if (response == null) {
                return null;
            }
            return response.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f55015c == null) {
                this.f55015c = this.f55014b.build();
            }
            this.f55016d = this.a.newCall(this.f55015c).execute();
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Response response = this.f55016d;
            if (response != null) {
                return response.code();
            }
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f55015c = null;
            Response response = this.f55016d;
            if (response != null && response.body() != null) {
                this.f55016d.body().close();
            }
            this.f55016d = null;
        }
    }
}
