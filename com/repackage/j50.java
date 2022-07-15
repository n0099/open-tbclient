package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.dns.Dns;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public class j50 implements Cloneable, Call.Factory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final e50 b;
    @Nullable
    public final Proxy c;
    public final List<f50> d;
    public final List<f50> e;
    public final ProxySelector f;
    public final SSLSocketFactory g;
    public final HostnameVerifier h;
    public final Dns i;
    public final int j;
    public final int k;
    public final int l;
    public n50 m;
    public boolean n;
    public boolean o;
    public String p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755637812, "Lcom/repackage/j50;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755637812, "Lcom/repackage/j50;");
                return;
            }
        }
        new ArrayList(2);
    }

    public j50(a aVar) {
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
        this.n = false;
        this.o = false;
        this.p = null;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = Util.immutableList(aVar.d);
        this.e = Util.immutableList(aVar.e);
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.k;
        this.j = aVar.l;
        this.k = aVar.m;
        this.l = aVar.n;
        if (!this.d.contains(null)) {
            if (!this.e.contains(null)) {
                this.m = aVar.o;
                this.n = aVar.i;
                this.o = aVar.j;
                this.p = aVar.p;
                return;
            }
            throw new IllegalStateException("Null network interceptor: " + this.e);
        }
        throw new IllegalStateException("Null interceptor: " + this.d);
    }

    @Override // com.baidu.searchbox.network.outback.core.Call.Factory
    public Call newCall(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? i50.c(request, this, false) : (Call) invokeL.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    public e50 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (e50) invokeV.objValue;
    }

    public HostnameVerifier q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (HostnameVerifier) invokeV.objValue;
    }

    public n50 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (n50) invokeV.objValue;
    }

    public List<f50> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public List<f50> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public ProxySelector v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (ProxySelector) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public SSLSocketFactory x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : (SSLSocketFactory) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public e50 b;
        @Nullable
        public Proxy c;
        public final List<f50> d;
        public final List<f50> e;
        public ProxySelector f;
        @Nullable
        public SSLSocketFactory g;
        public HostnameVerifier h;
        public boolean i;
        public boolean j;
        public Dns k;
        public int l;
        public int m;
        public int n;
        public n50 o;
        public String p;

        public a() {
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
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = new e50();
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f = proxySelector;
            if (proxySelector == null) {
                this.f = new h50();
            }
            SocketFactory.getDefault();
            this.h = null;
            this.k = Dns.SYSTEM;
            this.l = 10000;
            this.m = 10000;
            this.n = 10000;
            this.o = new l50();
        }

        public a a(f50 f50Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f50Var)) == null) {
                if (f50Var != null) {
                    this.d.add(f50Var);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (a) invokeL.objValue;
        }

        public j50 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new j50(this) : (j50) invokeV.objValue;
        }

        public a c(e50 e50Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e50Var)) == null) {
                if (e50Var != null) {
                    this.b = e50Var;
                    return this;
                }
                throw new IllegalArgumentException("dispatcher == null");
            }
            return (a) invokeL.objValue;
        }

        public a d(n50 n50Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, n50Var)) == null) {
                this.o = n50Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a(j50 j50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j50Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = j50Var.b;
            this.c = j50Var.c;
            this.d.addAll(j50Var.d);
            this.e.addAll(j50Var.e);
            this.f = j50Var.f;
            this.k = j50Var.i;
            this.l = j50Var.j;
            this.m = j50Var.k;
            this.n = j50Var.l;
            this.o = j50Var.m;
            this.i = j50Var.n;
            this.j = j50Var.o;
            this.p = j50Var.p;
            this.h = j50Var.h;
            this.g = j50Var.g;
        }
    }
}
