package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Callback;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.support.cookie.CookieJarImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class i50 implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j50 a;
    public final Request b;
    public final boolean c;
    public boolean d;
    public d50 e;

    /* loaded from: classes6.dex */
    public final class a extends g50 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback b;
        public final /* synthetic */ i50 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i50 i50Var, Callback callback) {
            super("BaiduNetwork %s", i50Var.d());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i50Var, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i50Var;
            this.b = callback;
        }

        @Override // com.repackage.g50
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.b.onResponse(this.c, this.c.b());
                    } catch (IOException e) {
                        this.b.onFailure(this.c, e);
                    }
                } finally {
                    this.c.a.p().d(this);
                }
            }
        }

        public i50 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (i50) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.b.url().host() : (String) invokeV.objValue;
        }
    }

    public i50(Request request, j50 j50Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, j50Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = request;
        this.c = z;
        this.a = j50Var;
        n50 n50Var = j50Var.m;
        this.e = new d50(j50Var);
    }

    public static i50 c(Request request, j50 j50Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, request, j50Var, z)) == null) ? new i50(request, j50Var, z) : (i50) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Call
    /* renamed from: a */
    public i50 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c(this.b, this.a, this.c) : (i50) invokeV.objValue;
    }

    public Response b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a.s());
            arrayList.add(new q50(new CookieJarImpl(this.b.getCookieManager()), this.a));
            arrayList.add(this.e);
            arrayList.addAll(this.a.t());
            arrayList.add(new r50());
            return new s50(arrayList, null, 0, this.b, this).a(this.b);
        }
        return (Response) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.b();
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.url().redact() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public void enqueue(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.d = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            this.a.p().a(new a(this, callback));
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public Response execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.d = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            try {
                try {
                    this.a.p().b(this);
                    Response b = b();
                    if (b != null) {
                        return b;
                    }
                    throw new IOException("Canceled");
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    if (TextUtils.isEmpty(e2.getMessage())) {
                        throw new IOException("unknown exception", e2);
                    }
                    throw new IOException(e2);
                }
            } finally {
                this.a.p().e(this);
            }
        }
        return (Response) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e.d() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public synchronized boolean isExecuted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (Request) invokeV.objValue;
    }
}
