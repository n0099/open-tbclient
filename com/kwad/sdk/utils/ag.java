package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ag f74198a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f74199b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f74200c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f74201d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734204, "Lcom/kwad/sdk/utils/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734204, "Lcom/kwad/sdk/utils/ag;");
                return;
            }
        }
        f74198a = new ag();
    }

    public ag() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74200c = 0L;
    }

    public static ag a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f74198a : (ag) invokeV.objValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f74200c <= 0 || SystemClock.elapsedRealtime() - this.f74200c >= 600) {
                if (this.f74201d == null && context != null) {
                    synchronized (this) {
                        if (this.f74201d == null) {
                            this.f74201d = (PowerManager) context.getApplicationContext().getSystemService("power");
                        }
                    }
                }
                this.f74199b = this.f74201d != null ? Build.VERSION.SDK_INT >= 20 ? this.f74201d.isInteractive() : this.f74201d.isScreenOn() : false;
                this.f74200c = SystemClock.elapsedRealtime();
                return this.f74199b;
            }
            return this.f74199b;
        }
        return invokeL.booleanValue;
    }
}
