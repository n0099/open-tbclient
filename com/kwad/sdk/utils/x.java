package com.kwad.sdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Observable;
/* loaded from: classes3.dex */
public class x extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f60246b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f60247c;

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static x a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (x.class) {
                    if (a == null) {
                        a = new x();
                    }
                }
            }
            return a;
        }
        return (x) invokeV.objValue;
    }

    public void a(Context context) {
        Context applicationContext;
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        Application application = null;
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "init appContext: " + applicationContext);
        if (!(applicationContext instanceof Application)) {
            Field[] declaredFields = applicationContext.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Field field = declaredFields[i2];
                field.setAccessible(true);
                try {
                    obj = field.get(applicationContext);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                }
                if (obj instanceof Application) {
                    application = (Application) obj;
                    break;
                } else {
                    continue;
                    i2++;
                }
            }
        } else {
            application = (Application) applicationContext;
        }
        com.kwad.sdk.core.d.a.a("LifecycleHolder", "init application: " + application);
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) { // from class: com.kwad.sdk.utils.x.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ x a;

                /* renamed from: b  reason: collision with root package name */
                public int f60248b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                    this.f60248b = 0;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || this.a.f60246b == null || this.a.f60246b.get() == null || !((Activity) this.a.f60246b.get()).equals(activity)) {
                        return;
                    }
                    this.a.f60246b = null;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                        this.a.f60246b = new WeakReference(activity);
                        this.a.f60247c = new WeakReference(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                        int i3 = this.f60248b + 1;
                        this.f60248b = i3;
                        if (i3 == 1) {
                            this.a.e();
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                        int i3 = this.f60248b - 1;
                        this.f60248b = i3;
                        if (i3 == 0) {
                            this.a.f();
                        }
                        if (this.a.f60247c == null || this.a.f60247c.get() == null || !((Activity) this.a.f60247c.get()).equals(activity)) {
                            return;
                        }
                        this.a.f60247c = null;
                    }
                }
            });
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c() != null : invokeV.booleanValue;
    }

    @Nullable
    public Activity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Activity> weakReference = this.f60246b;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WeakReference<Activity> weakReference = this.f60247c;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return 0;
            }
            return activity.getClass().hashCode();
        }
        return invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.a.a("LifecycleHolder", "onAppBackToForeground");
            setChanged();
            notifyObservers("ACTION_APP_BACK_TO_FOREGROUND");
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.kwad.sdk.core.d.a.a("LifecycleHolder", "onAppGoToBackground");
            setChanged();
            notifyObservers("ACTION_APP_GO_TO_BACKGROUND");
        }
    }
}
