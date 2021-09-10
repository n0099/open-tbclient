package com.bytedance.sdk.openadsdk.q;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68825a;

    /* renamed from: b  reason: collision with root package name */
    public static long f68826b;

    /* renamed from: c  reason: collision with root package name */
    public static long f68827c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public volatile InterfaceC1933a f68828d;

    /* renamed from: e  reason: collision with root package name */
    public volatile b f68829e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f68830f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f68831g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<Integer> f68832h;

    /* renamed from: com.bytedance.sdk.openadsdk.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1933a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(98109293, "Lcom/bytedance/sdk/openadsdk/q/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(98109293, "Lcom/bytedance/sdk/openadsdk/q/a;");
        }
    }

    public a() {
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
        this.f68830f = new AtomicInteger(0);
        this.f68831g = new AtomicBoolean(false);
        this.f68832h = new HashSet<>();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.q.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68833a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68833a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68833a.a()) {
                        a.f68825a = false;
                        a.f68827c = System.currentTimeMillis();
                        com.bytedance.sdk.openadsdk.j.a.a().a(a.f68826b / 1000, a.f68827c / 1000, !com.bytedance.sdk.openadsdk.core.l.f66743e.get());
                        com.bytedance.sdk.openadsdk.core.l.f66743e.set(false);
                    }
                }
            });
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long b2 = e.b();
            if (b2 <= 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - b2;
            if (currentTimeMillis >= 86400000 || currentTimeMillis <= 0) {
                return;
            }
            String c2 = e.c();
            String d2 = e.d();
            if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(d2)) {
                return;
            }
            com.bytedance.sdk.openadsdk.e.d.a(currentTimeMillis, c2, d2);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68831g.get() : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f68828d == null) {
            return;
        }
        this.f68828d = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) || this.f68828d == null) {
            return;
        }
        this.f68828d.d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            if (activity != null) {
                this.f68832h.remove(Integer.valueOf(activity.hashCode()));
            }
            if (this.f68828d != null) {
                this.f68828d.f();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, activity) == null) || this.f68828d == null) {
            return;
        }
        this.f68828d.c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (activity != null) {
                this.f68832h.add(Integer.valueOf(activity.hashCode()));
            }
            if (this.f68828d != null) {
                this.f68828d.a();
            }
            com.bytedance.sdk.component.adnet.a.a(activity);
            if (!f68825a) {
                f68826b = System.currentTimeMillis();
                f68825a = true;
            }
            com.bytedance.sdk.openadsdk.core.r.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            if (this.f68830f.incrementAndGet() > 0) {
                this.f68831g.set(false);
            }
            d();
            if (this.f68828d != null) {
                this.f68828d.b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            if (this.f68830f.decrementAndGet() == 0) {
                this.f68831g.set(true);
                if (this.f68829e != null) {
                    this.f68829e.b();
                }
            }
            if (this.f68828d != null) {
                this.f68828d.e();
            }
            c();
        }
    }

    public boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? activity != null && this.f68832h.contains(Integer.valueOf(activity.hashCode())) : invokeL.booleanValue;
    }

    public void a(InterfaceC1933a interfaceC1933a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1933a) == null) {
            this.f68828d = interfaceC1933a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f68829e = bVar;
        }
    }
}
