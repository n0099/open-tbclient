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
public final class q60 implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r60 a;
    public final Request b;
    public final boolean c;
    public boolean d;
    public l60 e;

    /* loaded from: classes6.dex */
    public final class a extends o60 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback b;
        public final /* synthetic */ q60 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q60 q60Var, Callback callback) {
            super("BaiduNetwork %s", q60Var.d());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q60Var, callback};
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
            this.c = q60Var;
            this.b = callback;
        }

        @Override // com.repackage.o60
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

        public q60 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (q60) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.b.url().host() : (String) invokeV.objValue;
        }
    }

    public q60(Request request, r60 r60Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, r60Var, Boolean.valueOf(z)};
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
        this.a = r60Var;
        v60 v60Var = r60Var.m;
        this.e = new l60(r60Var);
    }

    public static q60 c(Request request, r60 r60Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, request, r60Var, z)) == null) ? new q60(request, r60Var, z) : (q60) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Call
    /* renamed from: a */
    public q60 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c(this.b, this.a, this.c) : (q60) invokeV.objValue;
    }

    public Response b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a.s());
            arrayList.add(new y60(new CookieJarImpl(this.b.getCookieManager()), this.a));
            arrayList.add(this.e);
            arrayList.addAll(this.a.t());
            arrayList.add(new z60());
            return new a70(arrayList, null, 0, this.b, this).a(this.b);
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
