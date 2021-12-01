package f.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.text.SimpleDateFormat;
import java.util.Locale;
@TargetApi(14)
/* loaded from: classes3.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final SimpleDateFormat f63448j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Integer f63449e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f63450f;

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f63451g;

    /* renamed from: h  reason: collision with root package name */
    public final g f63452h;

    /* renamed from: i  reason: collision with root package name */
    public final f f63453i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1697320210, "Lf/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1697320210, "Lf/a/l;");
                return;
            }
        }
        f63448j = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public l(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, g gVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dxmSdkSensorsDataAPI, gVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63449e = 0;
        this.f63450f = new Object();
        this.f63451g = dxmSdkSensorsDataAPI;
        this.f63452h = gVar;
        this.f63453i = fVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            try {
                synchronized (this.f63450f) {
                    if (this.f63449e.intValue() == 0) {
                        if (this.f63453i.b() == null) {
                            this.f63453i.a(f63448j.format(Long.valueOf(System.currentTimeMillis())));
                        }
                        this.f63452h.b().booleanValue();
                        try {
                            this.f63451g.i();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f63451g.F();
                    }
                    this.f63449e = Integer.valueOf(this.f63449e.intValue() + 1);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            try {
                synchronized (this.f63450f) {
                    Integer valueOf = Integer.valueOf(this.f63449e.intValue() - 1);
                    this.f63449e = valueOf;
                    if (valueOf.intValue() == 0) {
                        try {
                            this.f63451g.K();
                            this.f63451g.j();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        try {
                            this.f63451g.p();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
