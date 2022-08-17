package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.okhttp.converters.RequestConverter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.ProxySelector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
/* loaded from: classes7.dex */
public class w40 implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;
    public String b;
    public EventListener c;
    public e50 d;

    /* loaded from: classes7.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallFactoryParams a;
        public final /* synthetic */ OkHttpClient b;
        public final /* synthetic */ w40 c;

        /* renamed from: com.repackage.w40$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0608a implements d50 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0608a(a aVar, Request request) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, request};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public a(w40 w40Var, CallFactoryParams callFactoryParams, OkHttpClient okHttpClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, callFactoryParams, okHttpClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w40Var;
            this.a = callFactoryParams;
            this.b = okHttpClient;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                Request e = this.c.e(request);
                if (this.c.h(e, this.a)) {
                    OkHttpClient.Builder newBuilder = this.b.newBuilder();
                    if (e.getConnectionTimeout() > 0) {
                        newBuilder.connectTimeout(e.getConnectionTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e.getReadTimeout() > 0) {
                        newBuilder.readTimeout(e.getReadTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e.getWriteTimeout() > 0) {
                        newBuilder.writeTimeout(e.getWriteTimeout(), TimeUnit.MILLISECONDS);
                    }
                    if (e.getCookieManager() != null && e.getCookieManager() != this.a.getCookieManager()) {
                        newBuilder.cookieJar(new x40(e.getCookieManager()));
                    }
                    if (!e.isFollowSslRedirects()) {
                        newBuilder.followSslRedirects(e.isFollowSslRedirects());
                    }
                    if (!e.isFollowRedirects()) {
                        newBuilder.followRedirects(e.isFollowRedirects());
                    }
                    newBuilder.eventListener(new y40(this.c.c));
                    if (this.c.d != null) {
                        Dns a = this.c.d.a(e, new C0608a(this, e));
                        newBuilder.dns(a);
                        newBuilder.addNetworkInterceptor(new a50(a));
                    }
                    return new v40(e, RequestConverter.toOks(e), newBuilder.build());
                }
                return new v40(e, RequestConverter.toOks(e), this.b);
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static List<Class<? extends Interceptor>> o;
        public static List<Class<? extends Interceptor>> p;
        public transient /* synthetic */ FieldHolder $fh;
        public OkHttpClient a;
        public OkHttpClient.Builder b;
        public int c;
        public int d;
        public int e;
        public ConnectionPool f;
        public Dns g;
        public ProxySelector h;
        public int i;
        public CookieManager j;
        public boolean k;
        public String l;
        public EventListener m;
        public e50 n;

        public b() {
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
            this.c = 30000;
            this.d = 30000;
            this.e = 30000;
            this.k = true;
        }

        public final void m(OkHttpClient.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, builder) == null) {
                List<Class<? extends Interceptor>> list = o;
                if (list != null) {
                    try {
                        for (Class<? extends Interceptor> cls : list) {
                            builder.addNetworkInterceptor(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                List<Class<? extends Interceptor>> list2 = p;
                if (list2 != null) {
                    try {
                        for (Class<? extends Interceptor> cls2 : list2) {
                            builder.addInterceptor(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public w40 n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a == null) {
                    if (this.b == null) {
                        this.b = new OkHttpClient.Builder();
                    }
                    o();
                    this.a = this.b.build();
                }
                return new w40(this, null);
            }
            return (w40) invokeV.objValue;
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.b.connectTimeout(this.c, TimeUnit.MILLISECONDS).readTimeout(this.d, TimeUnit.MILLISECONDS).writeTimeout(this.e, TimeUnit.MILLISECONDS);
                    if (this.f == null) {
                        this.f = new ConnectionPool(10, 5L, TimeUnit.MINUTES);
                    }
                    this.b.connectionPool(this.f);
                    if (this.g != null && (this.g instanceof Dns)) {
                        this.b.dns(this.g);
                    }
                    this.b.addNetworkInterceptor(new z40());
                    this.b.addInterceptor(new b50());
                    m(this.b);
                    if (this.h != null) {
                        this.b.proxySelector(this.h);
                    }
                    if (this.j != null) {
                        this.b.cookieJar(new x40(this.j));
                    }
                    this.b.followRedirects(this.k);
                    this.b.eventListener(new y40(this.m));
                } catch (Exception unused) {
                }
            }
        }

        public b p(OkHttpClient okHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, okHttpClient)) == null) {
                this.a = okHttpClient;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public /* synthetic */ w40(b bVar, a aVar) {
        this(bVar);
    }

    public final Request e(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? !Util.isTextEmpty(g()) ? request.newBuilder().header("User-Agent", g()).build() : request : (Request) invokeL.objValue;
    }

    public final void f(OkHttpClient.Builder builder, CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, builder, callFactoryParams) == null) {
            builder.dispatcher(new Dispatcher(this.a.dispatcher().executorService()));
            if (callFactoryParams != null) {
                if (callFactoryParams.getConnectTimeoutMs() > 0) {
                    builder.connectTimeout(callFactoryParams.getConnectTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getReadTimeoutMs() > 0) {
                    builder.readTimeout(callFactoryParams.getReadTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getWriteTimeoutMs() > 0) {
                    builder.writeTimeout(callFactoryParams.getWriteTimeoutMs(), TimeUnit.MILLISECONDS);
                }
                if (callFactoryParams.getConnectionPoolMaxIdleConnections() > 0) {
                    builder.connectionPool(new ConnectionPool(callFactoryParams.getConnectionPoolMaxIdleConnections(), callFactoryParams.getConnectionPoolKeepAliveDurationNs(), callFactoryParams.getConnectionPoolTimeUnit()));
                }
                if (callFactoryParams.getProxySelector() != null) {
                    builder.proxySelector(callFactoryParams.getProxySelector());
                }
                if (callFactoryParams.getCookieManager() != null) {
                    builder.cookieJar(new x40(callFactoryParams.getCookieManager()));
                }
            }
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public String getEngineName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? EngineName.OKHTTP : (String) invokeV.objValue;
    }

    public final boolean h(Request request, CallFactoryParams callFactoryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, request, callFactoryParams)) == null) ? (request.getConnectionTimeout() <= 0 && request.getWriteTimeout() <= 0 && request.getReadTimeout() <= 0 && request.getHeaders() == null && request.getNetworkStatRecord() == null && request.isFollowRedirects() && request.isFollowSslRedirects() && this.d == null && (request.getCookieManager() == null || request.getCookieManager() == callFactoryParams.getCookieManager())) ? false : true : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public CallFactory produceCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callFactoryParams)) == null) {
            OkHttpClient.Builder newBuilder = this.a.newBuilder();
            newBuilder.addNetworkInterceptor(new c50());
            f(newBuilder, callFactoryParams);
            return new a(this, callFactoryParams, newBuilder.build());
        }
        return (CallFactory) invokeL.objValue;
    }

    public w40(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar.a;
        int unused = bVar.c;
        int unused2 = bVar.d;
        Dns unused3 = bVar.g;
        ConnectionPool unused4 = bVar.f;
        int unused5 = bVar.e;
        ProxySelector unused6 = bVar.h;
        boolean unused7 = bVar.k;
        int unused8 = bVar.i;
        this.b = bVar.l;
        this.c = bVar.m;
        this.d = bVar.n;
    }
}
