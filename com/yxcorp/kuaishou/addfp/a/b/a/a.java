package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class a implements d.n.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.n.a.a.a.a.a f43706a;

    /* renamed from: b  reason: collision with root package name */
    public String f43707b;

    /* renamed from: c  reason: collision with root package name */
    public String f43708c;

    /* renamed from: d  reason: collision with root package name */
    public String f43709d;

    /* renamed from: e  reason: collision with root package name */
    public String f43710e;

    /* renamed from: f  reason: collision with root package name */
    public d.n.a.a.a.b.a.a f43711f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43712g;

    public a(Context context, d.n.a.a.a.a.a aVar) {
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
        this.f43707b = "";
        this.f43708c = "";
        this.f43709d = "";
        this.f43710e = "";
        this.f43712g = false;
        this.f43706a = aVar;
        this.f43711f = new d.n.a.a.a.b.a.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iInterface) == null) {
            b bVar = (b) iInterface;
            try {
                String b2 = bVar.b();
                this.f43707b = b2;
                if (b2 == null) {
                    this.f43707b = "";
                }
            } catch (Throwable unused) {
            }
            try {
                String c2 = bVar.c();
                this.f43708c = c2;
                if (c2 == null) {
                    this.f43708c = "";
                }
            } catch (Throwable unused2) {
            }
            try {
                String d2 = bVar.d();
                this.f43709d = d2;
                if (d2 == null) {
                    this.f43709d = "";
                }
            } catch (Throwable unused3) {
            }
            try {
                String e2 = bVar.e();
                this.f43710e = e2;
                if (e2 == null) {
                    this.f43710e = "";
                }
            } catch (Throwable unused4) {
            }
            try {
                this.f43712g = bVar.a();
            } catch (Throwable unused5) {
            }
            d.n.a.a.a.b.a.a aVar = this.f43711f;
            if (aVar != null) {
                aVar.b();
            }
            d.n.a.a.a.a.a aVar2 = this.f43706a;
            if (aVar2 != null) {
                aVar2.a(this.f43712g, this);
            }
        }
    }

    @Override // d.n.a.a.a.b.b
    public final void a(d.n.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f43711f.c(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43708c : (String) invokeV.objValue;
    }

    @Override // d.n.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43712g : invokeV.booleanValue;
    }

    @Override // d.n.a.a.a.b.b
    public final void d() {
        d.n.a.a.a.b.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f43711f) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.n.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f43706a) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
