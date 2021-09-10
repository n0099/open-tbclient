package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class d implements c.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.r.a.a.a.b.d.a f78265a;

    /* renamed from: b  reason: collision with root package name */
    public c.r.a.a.a.a.a f78266b;

    /* renamed from: c  reason: collision with root package name */
    public Context f78267c;

    /* renamed from: d  reason: collision with root package name */
    public String f78268d;

    /* renamed from: e  reason: collision with root package name */
    public String f78269e;

    /* renamed from: f  reason: collision with root package name */
    public String f78270f;

    /* renamed from: g  reason: collision with root package name */
    public String f78271g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f78272h;

    public d(Context context, c.r.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78268d = "";
        this.f78269e = "";
        this.f78270f = "";
        this.f78271g = "";
        this.f78272h = false;
        this.f78266b = aVar;
        this.f78267c = context;
    }

    @Override // c.r.a.a.a.b.b
    public final void a(c.r.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f78265a = new c.r.a.a.a.b.d.a(this.f78267c, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        c.r.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    c.r.a.a.c.b.c.b("SupplierImpl bindService 5!");
                    aVar = this.f78266b;
                } else {
                    this.f78268d = str;
                    if (!TextUtils.isEmpty(str)) {
                        this.f78266b.a(true, this);
                    }
                    aVar = this.f78266b;
                }
                aVar.a(false, null);
            } catch (Throwable th) {
                try {
                    c.r.a.a.c.b.c.c(th);
                } finally {
                    d();
                }
            }
        }
    }

    @Override // c.r.a.a.a.b.b
    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // c.r.a.a.a.b.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f78268d : (String) invokeV.objValue;
    }

    @Override // c.r.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.r.a.a.a.b.d.a aVar = this.f78265a;
            if (aVar != null) {
                return aVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.r.a.a.a.b.b
    public final void d() {
        c.r.a.a.a.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f78265a) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        c.r.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f78266b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
