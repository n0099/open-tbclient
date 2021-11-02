package e.a;

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
/* loaded from: classes2.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleDateFormat j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Integer f71669e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f71670f;

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f71671g;

    /* renamed from: h  reason: collision with root package name */
    public final g f71672h;

    /* renamed from: i  reason: collision with root package name */
    public final f f71673i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668691059, "Le/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668691059, "Le/a/l;");
                return;
            }
        }
        j = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
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
        this.f71669e = 0;
        this.f71670f = new Object();
        this.f71671g = dxmSdkSensorsDataAPI;
        this.f71672h = gVar;
        this.f71673i = fVar;
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
                synchronized (this.f71670f) {
                    if (this.f71669e.intValue() == 0) {
                        if (this.f71673i.b() == null) {
                            this.f71673i.a(j.format(Long.valueOf(System.currentTimeMillis())));
                        }
                        this.f71672h.b().booleanValue();
                        try {
                            this.f71671g.i();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        this.f71671g.F();
                    }
                    this.f71669e = Integer.valueOf(this.f71669e.intValue() + 1);
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
                synchronized (this.f71670f) {
                    Integer valueOf = Integer.valueOf(this.f71669e.intValue() - 1);
                    this.f71669e = valueOf;
                    if (valueOf.intValue() == 0) {
                        try {
                            this.f71671g.K();
                            this.f71671g.j();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        try {
                            this.f71671g.p();
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
