package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import c.r.a.a.a.a.a;
import c.r.a.a.a.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class c implements b, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f78610a;

    /* renamed from: b  reason: collision with root package name */
    public String f78611b;

    /* renamed from: c  reason: collision with root package name */
    public String f78612c;

    /* renamed from: d  reason: collision with root package name */
    public String f78613d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f78614e;

    /* renamed from: f  reason: collision with root package name */
    public a f78615f;

    /* renamed from: g  reason: collision with root package name */
    public c.r.a.a.a.b.c.a f78616g;

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
        this.f78611b = "";
        this.f78612c = "";
        this.f78613d = "";
        this.f78614e = false;
        this.f78610a = context;
        this.f78615f = aVar;
        this.f78616g = new c.r.a.a.a.b.c.a(context);
    }

    @Override // c.r.a.a.a.b.b
    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(this.f78610a.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        this.f78611b = string;
                        this.f78614e = true;
                        if (this.f78615f != null) {
                            this.f78615f.a(true, this);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f78616g.d(this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || !str.equals(this.f78611b)) {
                    this.f78611b = str;
                    if (TextUtils.isEmpty(str)) {
                        if (this.f78615f != null) {
                            this.f78615f.a(false, null);
                            return;
                        }
                        return;
                    }
                    this.f78614e = true;
                    if (this.f78615f != null) {
                        this.f78615f.a(true, this);
                    }
                }
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f78611b : (String) invokeV.objValue;
    }

    @Override // c.r.a.a.a.b.b
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f78614e : invokeV.booleanValue;
    }

    @Override // c.r.a.a.a.b.b
    public final void d() {
        c.r.a.a.a.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f78616g) == null) {
            return;
        }
        aVar.c();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f78615f) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
