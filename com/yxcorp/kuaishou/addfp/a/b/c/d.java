package com.yxcorp.kuaishou.addfp.a.b.c;

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
/* loaded from: classes8.dex */
public final class d implements d.n.a.a.a.b.b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.n.a.a.a.b.d.a f43723a;

    /* renamed from: b  reason: collision with root package name */
    public d.n.a.a.a.a.a f43724b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43725c;

    /* renamed from: d  reason: collision with root package name */
    public String f43726d;

    /* renamed from: e  reason: collision with root package name */
    public String f43727e;

    /* renamed from: f  reason: collision with root package name */
    public String f43728f;

    /* renamed from: g  reason: collision with root package name */
    public String f43729g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43730h;

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
        this.f43726d = "";
        this.f43727e = "";
        this.f43728f = "";
        this.f43729g = "";
        this.f43730h = false;
        this.f43724b = aVar;
        this.f43725c = context;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(IInterface iInterface) {
        d.n.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iInterface) == null) {
            try {
                boolean c2 = c();
                this.f43730h = c2;
                if (c2) {
                    String b2 = this.f43723a.b();
                    this.f43726d = b2;
                    if (TextUtils.isEmpty(b2)) {
                        this.f43726d = "";
                    }
                    String h2 = this.f43723a.h();
                    this.f43729g = h2;
                    if (TextUtils.isEmpty(h2)) {
                        this.f43729g = "";
                    }
                    String g2 = this.f43723a.g();
                    this.f43728f = g2;
                    if (TextUtils.isEmpty(g2)) {
                        this.f43728f = "";
                    }
                    String e2 = this.f43723a.e();
                    this.f43727e = e2;
                    if (TextUtils.isEmpty(e2)) {
                        this.f43727e = "";
                    }
                    if (!TextUtils.isEmpty(this.f43726d)) {
                        this.f43724b.a(true, this);
                    }
                    aVar = this.f43724b;
                } else {
                    aVar = this.f43724b;
                }
                aVar.a(false, null);
            } catch (Throwable th) {
                try {
                    d.n.a.a.c.b.b.c(th);
                } finally {
                    d();
                }
            }
        }
    }

    @Override // d.n.a.a.a.b.b
    public final void a(d.n.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f43723a = new d.n.a.a.a.b.d.a(this.f43725c, this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43726d : (String) invokeV.objValue;
    }

    @Override // d.n.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.n.a.a.a.b.d.a aVar = this.f43723a;
            if (aVar != null) {
                return aVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.n.a.a.a.b.b
    public final void d() {
        d.n.a.a.a.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f43723a) == null) {
            return;
        }
        aVar.i();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        d.n.a.a.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f43724b) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
