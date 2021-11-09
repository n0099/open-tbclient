package com.yxcorp.kuaishou.addfp.a.b.j;

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
public final class g implements b.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71573a;

    /* renamed from: b  reason: collision with root package name */
    public b.r.a.a.a.a.a f71574b;

    /* renamed from: c  reason: collision with root package name */
    public String f71575c;

    public g(Context context, b.r.a.a.a.a.a aVar) {
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
        this.f71573a = context;
        this.f71574b = aVar;
    }

    @Override // b.r.a.a.a.b.b
    public final void a(b.r.a.a.a.a.a aVar) {
        b.r.a.a.a.b.k.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar2 = b.r.a.a.a.b.k.c.f33662a;
            aVar2.c(this.f71573a, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f71574b == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f71574b.a(false, null);
            return;
        }
        this.f71575c = str;
        this.f71574b.a(true, this);
    }

    @Override // b.r.a.a.a.b.b
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

    @Override // b.r.a.a.a.b.b
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71575c : (String) invokeV.objValue;
    }

    @Override // b.r.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        b.r.a.a.a.b.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            aVar = b.r.a.a.a.b.k.c.f33662a;
            return aVar.e();
        }
        return invokeV.booleanValue;
    }

    @Override // b.r.a.a.a.b.b
    public final void d() {
        b.r.a.a.a.b.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            aVar = b.r.a.a.a.b.k.c.f33662a;
            aVar.b(this.f71573a);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        b.r.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f71574b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
