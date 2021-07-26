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
/* loaded from: classes6.dex */
public final class d implements d.n.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.n.a.a.a.b.d.a f41008a;

    /* renamed from: b  reason: collision with root package name */
    public d.n.a.a.a.a.a f41009b;

    /* renamed from: c  reason: collision with root package name */
    public Context f41010c;

    /* renamed from: d  reason: collision with root package name */
    public String f41011d;

    /* renamed from: e  reason: collision with root package name */
    public String f41012e;

    /* renamed from: f  reason: collision with root package name */
    public String f41013f;

    /* renamed from: g  reason: collision with root package name */
    public String f41014g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41015h;

    public d(Context context, d.n.a.a.a.a.a aVar) {
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
        this.f41011d = "";
        this.f41012e = "";
        this.f41013f = "";
        this.f41014g = "";
        this.f41015h = false;
        this.f41009b = aVar;
        this.f41010c = context;
    }

    @Override // d.n.a.a.a.b.b
    public final void a(d.n.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f41008a = new d.n.a.a.a.b.d.a(this.f41010c, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        d.n.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    d.n.a.a.c.b.c.b("SupplierImpl bindService 5!");
                    aVar = this.f41009b;
                } else {
                    this.f41011d = str;
                    if (!TextUtils.isEmpty(str)) {
                        this.f41009b.a(true, this);
                    }
                    aVar = this.f41009b;
                }
                aVar.a(false, null);
            } catch (Throwable th) {
                try {
                    d.n.a.a.c.b.c.c(th);
                } finally {
                    d();
                }
            }
        }
    }

    @Override // d.n.a.a.a.b.b
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

    @Override // d.n.a.a.a.b.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41011d : (String) invokeV.objValue;
    }

    @Override // d.n.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.n.a.a.a.b.d.a aVar = this.f41008a;
            if (aVar != null) {
                return aVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.n.a.a.a.b.b
    public final void d() {
        d.n.a.a.a.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f41008a) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.n.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f41009b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
