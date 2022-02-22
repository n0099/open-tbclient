package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes4.dex */
public final class c implements com.yxcorp.kuaishou.addfp.a.b.a, com.yxcorp.kuaishou.addfp.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f61701b;

    /* renamed from: c  reason: collision with root package name */
    public String f61702c;

    /* renamed from: d  reason: collision with root package name */
    public String f61703d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61704e;

    /* renamed from: f  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.a.a f61705f;

    /* renamed from: g  reason: collision with root package name */
    public a f61706g;

    public c(Context context, com.yxcorp.kuaishou.addfp.a.a.a aVar) {
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
        this.f61701b = "";
        this.f61702c = "";
        this.f61703d = "";
        this.f61704e = false;
        this.a = context;
        this.f61705f = aVar;
        this.f61706g = new a(context);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(this.a.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
                    if (!TextUtils.isEmpty(string)) {
                        this.f61701b = string;
                        this.f61704e = true;
                        if (this.f61705f != null) {
                            this.f61705f.a(true, this);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f61706g.a(this);
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || !str.equals(this.f61701b)) {
                    this.f61701b = str;
                    if (TextUtils.isEmpty(str)) {
                        if (this.f61705f != null) {
                            this.f61705f.a(false, null);
                            return;
                        }
                        return;
                    }
                    this.f61704e = true;
                    if (this.f61705f != null) {
                        this.f61705f.a(true, this);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
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

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61701b : (String) invokeV.objValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61704e : invokeV.booleanValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public final void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f61706g) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.b
    public final void e() {
        com.yxcorp.kuaishou.addfp.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f61705f) == null) {
            return;
        }
        aVar.a(false, this);
    }
}
