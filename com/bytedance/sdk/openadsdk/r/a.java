package com.bytedance.sdk.openadsdk.r;

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
import com.bytedance.sdk.openadsdk.core.r;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f32297a;

    /* renamed from: b  reason: collision with root package name */
    public static long f32298b;

    /* renamed from: c  reason: collision with root package name */
    public static long f32299c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public volatile InterfaceC0367a f32300d;

    /* renamed from: e  reason: collision with root package name */
    public volatile b f32301e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f32302f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f32303g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<Integer> f32304h;

    /* renamed from: com.bytedance.sdk.openadsdk.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0367a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(98139084, "Lcom/bytedance/sdk/openadsdk/r/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(98139084, "Lcom/bytedance/sdk/openadsdk/r/a;");
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
        this.f32302f = new AtomicInteger(0);
        this.f32303g = new AtomicBoolean(false);
        this.f32304h = new HashSet<>();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.r.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f32305a;

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
                    this.f32305a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f32305a.a()) {
                        a.f32297a = false;
                        a.f32299c = System.currentTimeMillis();
                        com.bytedance.sdk.openadsdk.k.a.a().a(a.f32298b / 1000, a.f32299c / 1000, !com.bytedance.sdk.openadsdk.core.l.f30346e.get());
                        com.bytedance.sdk.openadsdk.core.l.f30346e.set(false);
                    }
                }
            });
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long b2 = d.b();
            if (b2 <= 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - b2;
            if (currentTimeMillis >= 86400000 || currentTimeMillis <= 0) {
                return;
            }
            String c2 = d.c();
            String d2 = d.d();
            if (TextUtils.isEmpty(c2) || TextUtils.isEmpty(d2)) {
                return;
            }
            com.bytedance.sdk.openadsdk.e.d.a(currentTimeMillis, c2, d2);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32303g.get() : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f32300d == null) {
            return;
        }
        this.f32300d = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) || this.f32300d == null) {
            return;
        }
        this.f32300d.d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            if (activity != null) {
                this.f32304h.remove(Integer.valueOf(activity.hashCode()));
            }
            if (this.f32300d != null) {
                this.f32300d.f();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, activity) == null) || this.f32300d == null) {
            return;
        }
        this.f32300d.c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (activity != null) {
                this.f32304h.add(Integer.valueOf(activity.hashCode()));
            }
            if (this.f32300d != null) {
                this.f32300d.a();
            }
            com.bytedance.sdk.component.adnet.a.a(activity);
            if (!f32297a) {
                f32298b = System.currentTimeMillis();
                f32297a = true;
            }
            r.a();
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
            if (this.f32302f.incrementAndGet() > 0) {
                this.f32303g.set(false);
            }
            d();
            if (this.f32300d != null) {
                this.f32300d.b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            if (this.f32302f.decrementAndGet() == 0) {
                this.f32303g.set(true);
                if (this.f32301e != null) {
                    this.f32301e.b();
                }
            }
            if (this.f32300d != null) {
                this.f32300d.e();
            }
            c();
        }
    }

    public boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? activity != null && this.f32304h.contains(Integer.valueOf(activity.hashCode())) : invokeL.booleanValue;
    }

    public void a(InterfaceC0367a interfaceC0367a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0367a) == null) {
            this.f32300d = interfaceC0367a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f32301e = bVar;
        }
    }
}
