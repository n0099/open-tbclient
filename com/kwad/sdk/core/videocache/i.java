package com.kwad.sdk.core.videocache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends ProxySelector {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f65184a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f65185b;

    /* renamed from: c  reason: collision with root package name */
    public final String f65186c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65187d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1359207483, "Lcom/kwad/sdk/core/videocache/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1359207483, "Lcom/kwad/sdk/core/videocache/i;");
                return;
            }
        }
        f65184a = Arrays.asList(Proxy.NO_PROXY);
    }

    public i(ProxySelector proxySelector, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {proxySelector, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65185b = (ProxySelector) j.a(proxySelector);
        this.f65186c = (String) j.a(str);
        this.f65187d = i2;
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
        }
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, uri, socketAddress, iOException) == null) {
            this.f65185b.connectFailed(uri, socketAddress, iOException);
        }
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            return this.f65186c.equals(uri.getHost()) && this.f65187d == uri.getPort() ? f65184a : this.f65185b.select(uri);
        }
        return (List) invokeL.objValue;
    }
}
