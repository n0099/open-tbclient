package com.bytedance.sdk.openadsdk.o;

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
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class j extends ProxySelector {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f31803a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f31804b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31805c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31806d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98049990, "Lcom/bytedance/sdk/openadsdk/o/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98049990, "Lcom/bytedance/sdk/openadsdk/o/j;");
                return;
            }
        }
        f31803a = Collections.singletonList(Proxy.NO_PROXY);
    }

    public j(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31804b = ProxySelector.getDefault();
        this.f31805c = str;
        this.f31806d = i2;
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            ProxySelector.setDefault(new j(str, i2));
        }
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, uri, socketAddress, iOException) == null) {
            this.f31804b.connectFailed(uri, socketAddress, iOException);
        }
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            if (uri != null) {
                return (this.f31805c.equalsIgnoreCase(uri.getHost()) && this.f31806d == uri.getPort()) ? f31803a : this.f31804b.select(uri);
            }
            throw new IllegalArgumentException("URI can't be null");
        }
        return (List) invokeL.objValue;
    }
}
