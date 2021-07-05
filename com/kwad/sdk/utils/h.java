package com.kwad.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f39393a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f39394b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f39395c;

    /* renamed from: d  reason: collision with root package name */
    public a f39396d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835508, "Lcom/kwad/sdk/utils/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835508, "Lcom/kwad/sdk/utils/h;");
                return;
            }
        }
        f39393a = new AtomicBoolean(false);
    }

    public h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39395c = context.getApplicationContext();
    }

    public static h a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f39394b == null) {
                synchronized (h.class) {
                    if (f39394b == null) {
                        f39394b = new h(context);
                    }
                }
            }
            return f39394b;
        }
        return (h) invokeL.objValue;
    }

    private void c() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && f39393a.get() && (context = this.f39395c) != null) {
            context.unregisterReceiver(this.f39396d);
            f39393a.set(false);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f39395c == null || f39393a.get()) {
            return;
        }
        if (this.f39396d == null) {
            this.f39396d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        this.f39395c.registerReceiver(this.f39396d, intentFilter);
        f39393a.set(true);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
        }
    }
}
