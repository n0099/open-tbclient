package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.n.a.a.a.a.a;
import d.n.a.a.a.b.b;
/* loaded from: classes8.dex */
public final class c implements b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43714a;

    /* renamed from: b  reason: collision with root package name */
    public String f43715b;

    /* renamed from: c  reason: collision with root package name */
    public String f43716c;

    /* renamed from: d  reason: collision with root package name */
    public String f43717d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43718e;

    /* renamed from: f  reason: collision with root package name */
    public a f43719f;

    /* renamed from: g  reason: collision with root package name */
    public d.n.a.a.a.b.c.a f43720g;

    public c(Context context, a aVar) {
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
        this.f43715b = "";
        this.f43716c = "";
        this.f43717d = "";
        this.f43718e = false;
        this.f43714a = context;
        this.f43719f = aVar;
        this.f43720g = new d.n.a.a.a.b.c.a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iInterface) == null) {
            try {
                String a2 = ((d) iInterface).a();
                this.f43715b = a2;
                if (TextUtils.isEmpty(a2)) {
                    if (this.f43719f != null) {
                        this.f43719f.a(false, null);
                        return;
                    }
                    return;
                }
                this.f43718e = true;
                if (this.f43719f != null) {
                    this.f43719f.a(true, this);
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    @Override // d.n.a.a.a.b.b
    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f43720g.d(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43715b : (String) invokeV.objValue;
    }

    @Override // d.n.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43718e : invokeV.booleanValue;
    }

    @Override // d.n.a.a.a.b.b
    public final void d() {
        d.n.a.a.a.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f43720g) == null) {
            return;
        }
        aVar.c();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f43719f) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
