package com.yxcorp.kuaishou.addfp.a.b.f;

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
public final class g implements d.n.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43732a;

    /* renamed from: b  reason: collision with root package name */
    public d.n.a.a.a.a.a f43733b;

    public g(Context context, d.n.a.a.a.a.a aVar) {
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
        this.f43732a = context;
        this.f43733b = aVar;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.n.a.a.a.a.a aVar;
        d.n.a.a.a.b.g.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iInterface) == null) || (aVar = this.f43733b) == null) {
            return;
        }
        aVar2 = d.n.a.a.a.b.g.c.f75093a;
        aVar.a(aVar2.f(), this);
    }

    @Override // d.n.a.a.a.b.b
    public final void a(d.n.a.a.a.a.a aVar) {
        d.n.a.a.a.b.g.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar2 = d.n.a.a.a.b.g.c.f75093a;
            aVar2.d(this.f43732a, this);
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
        d.n.a.a.a.b.g.a aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                aVar = d.n.a.a.a.b.g.c.f75093a;
                String a2 = aVar.a(this.f43732a, "OUID");
                return a2 != null ? a2 : a2;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // d.n.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        d.n.a.a.a.b.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            aVar = d.n.a.a.a.b.g.c.f75093a;
            return aVar.f();
        }
        return invokeV.booleanValue;
    }

    @Override // d.n.a.a.a.b.b
    public final void d() {
        d.n.a.a.a.b.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            aVar = d.n.a.a.a.b.g.c.f75093a;
            aVar.c(this.f43732a);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f43733b == null) {
            return;
        }
        d.n.a.a.c.b.b.e("failed here");
        this.f43733b.a(false, this);
    }
}
