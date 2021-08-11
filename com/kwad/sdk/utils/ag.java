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
    public static volatile ag f73499a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f73500b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f73501c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f73502d;

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
        f73499a = new ag();
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
        this.f73501c = 0L;
    }

    public static ag a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f73499a : (ag) invokeV.objValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f73501c <= 0 || SystemClock.elapsedRealtime() - this.f73501c >= 600) {
                if (this.f73502d == null && context != null) {
                    synchronized (this) {
                        if (this.f73502d == null) {
                            this.f73502d = (PowerManager) context.getApplicationContext().getSystemService("power");
                        }
                    }
                }
                this.f73500b = this.f73502d != null ? Build.VERSION.SDK_INT >= 20 ? this.f73502d.isInteractive() : this.f73502d.isScreenOn() : false;
                this.f73501c = SystemClock.elapsedRealtime();
                return this.f73500b;
            }
            return this.f73500b;
        }
        return invokeL.booleanValue;
    }
}
