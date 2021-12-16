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
/* loaded from: classes3.dex */
public class ak {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ak a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f60178b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f60179c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f60180d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734328, "Lcom/kwad/sdk/utils/ak;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734328, "Lcom/kwad/sdk/utils/ak;");
                return;
            }
        }
        a = new ak();
    }

    public ak() {
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
        this.f60179c = 0L;
    }

    public static ak a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (ak) invokeV.objValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f60179c <= 0 || SystemClock.elapsedRealtime() - this.f60179c >= 600) {
                if (this.f60180d == null && context != null) {
                    synchronized (this) {
                        if (this.f60180d == null) {
                            this.f60180d = (PowerManager) context.getApplicationContext().getSystemService("power");
                        }
                    }
                }
                this.f60178b = this.f60180d != null ? Build.VERSION.SDK_INT >= 20 ? this.f60180d.isInteractive() : this.f60180d.isScreenOn() : false;
                this.f60179c = SystemClock.elapsedRealtime();
                return this.f60178b;
            }
            return this.f60178b;
        }
        return invokeL.booleanValue;
    }
}
