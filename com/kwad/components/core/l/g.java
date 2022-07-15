package com.kwad.components.core.l;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
    public static volatile g b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public a d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273811348, "Lcom/kwad/components/core/l/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273811348, "Lcom/kwad/components/core/l/g;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = context.getApplicationContext();
    }

    public static g a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (g.class) {
                    if (b == null) {
                        b = new g(context);
                    }
                }
            }
            return b;
        }
        return (g) invokeL.objValue;
    }

    private void c() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && a.get() && (context = this.c) != null) {
            context.unregisterReceiver(this.d);
            a.set(false);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null || a.get()) {
            return;
        }
        if (this.d == null) {
            this.d = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.c.registerReceiver(this.d, intentFilter);
        a.set(true);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
        }
    }
}
