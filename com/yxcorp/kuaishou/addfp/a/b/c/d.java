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
/* loaded from: classes2.dex */
public final class d implements b.p.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.p.a.a.a.b.d.a f72476a;

    /* renamed from: b  reason: collision with root package name */
    public b.p.a.a.a.a.a f72477b;

    /* renamed from: c  reason: collision with root package name */
    public Context f72478c;

    /* renamed from: d  reason: collision with root package name */
    public String f72479d;

    /* renamed from: e  reason: collision with root package name */
    public String f72480e;

    /* renamed from: f  reason: collision with root package name */
    public String f72481f;

    /* renamed from: g  reason: collision with root package name */
    public String f72482g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72483h;

    public d(Context context, b.p.a.a.a.a.a aVar) {
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
        this.f72479d = "";
        this.f72480e = "";
        this.f72481f = "";
        this.f72482g = "";
        this.f72483h = false;
        this.f72477b = aVar;
        this.f72478c = context;
    }

    @Override // b.p.a.a.a.b.b
    public final void a(b.p.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f72476a = new b.p.a.a.a.b.d.a(this.f72478c, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        b.p.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    b.p.a.a.c.b.c.b("SupplierImpl bindService 5!");
                    aVar = this.f72477b;
                } else {
                    this.f72479d = str;
                    if (!TextUtils.isEmpty(str)) {
                        this.f72477b.a(true, this);
                    }
                    aVar = this.f72477b;
                }
                aVar.a(false, null);
            } catch (Throwable th) {
                try {
                    b.p.a.a.c.b.c.c(th);
                } finally {
                    d();
                }
            }
        }
    }

    @Override // b.p.a.a.a.b.b
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

    @Override // b.p.a.a.a.b.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72479d : (String) invokeV.objValue;
    }

    @Override // b.p.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.p.a.a.a.b.d.a aVar = this.f72476a;
            if (aVar != null) {
                return aVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.p.a.a.a.b.b
    public final void d() {
        b.p.a.a.a.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f72476a) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        b.p.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f72477b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
