package com.kwai.filedownloader.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import com.kwai.filedownloader.e.c;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class c implements com.kwai.filedownloader.kwai.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URLConnection a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Proxy a;
        public Integer b;
        public Integer c;
    }

    /* loaded from: classes5.dex */
    public static class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
        }

        @Override // com.kwai.filedownloader.e.c.b
        public final com.kwai.filedownloader.kwai.b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new c(str, this.a) : (com.kwai.filedownloader.kwai.b) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str, a aVar) {
        this(new URL(str), aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(URL url, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = (aVar == null || aVar.a == null) ? url.openConnection() : url.openConnection(aVar.a);
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.a);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.b != null) {
                this.a.setReadTimeout(aVar.b.intValue());
            }
            if (aVar.c != null) {
                this.a.setConnectTimeout(aVar.c.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final InputStream a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((h) ServiceProvider.a(h.class)).a(this.a.getInputStream()) : (InputStream) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a.getHeaderField(str) : (String) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.addRequestProperty(str, str2);
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getRequestProperties() : (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getHeaderFields() : (Map) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.connect();
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            URLConnection uRLConnection = this.a;
            if (uRLConnection instanceof HttpURLConnection) {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
