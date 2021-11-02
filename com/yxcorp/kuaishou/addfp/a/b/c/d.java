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
public final class d implements b.r.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.r.a.a.a.b.d.a f71557a;

    /* renamed from: b  reason: collision with root package name */
    public b.r.a.a.a.a.a f71558b;

    /* renamed from: c  reason: collision with root package name */
    public Context f71559c;

    /* renamed from: d  reason: collision with root package name */
    public String f71560d;

    /* renamed from: e  reason: collision with root package name */
    public String f71561e;

    /* renamed from: f  reason: collision with root package name */
    public String f71562f;

    /* renamed from: g  reason: collision with root package name */
    public String f71563g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71564h;

    public d(Context context, b.r.a.a.a.a.a aVar) {
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
        this.f71560d = "";
        this.f71561e = "";
        this.f71562f = "";
        this.f71563g = "";
        this.f71564h = false;
        this.f71558b = aVar;
        this.f71559c = context;
    }

    @Override // b.r.a.a.a.b.b
    public final void a(b.r.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f71557a = new b.r.a.a.a.b.d.a(this.f71559c, this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        b.r.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    b.r.a.a.c.b.c.b("SupplierImpl bindService 5!");
                    aVar = this.f71558b;
                } else {
                    this.f71560d = str;
                    if (!TextUtils.isEmpty(str)) {
                        this.f71558b.a(true, this);
                    }
                    aVar = this.f71558b;
                }
                aVar.a(false, null);
            } catch (Throwable th) {
                try {
                    b.r.a.a.c.b.c.c(th);
                } finally {
                    d();
                }
            }
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71560d : (String) invokeV.objValue;
    }

    @Override // b.r.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.r.a.a.a.b.d.a aVar = this.f71557a;
            if (aVar != null) {
                return aVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.r.a.a.a.b.b
    public final void d() {
        b.r.a.a.a.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f71557a) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        b.r.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f71558b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
