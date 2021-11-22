package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Application f69991a;

    /* renamed from: b  reason: collision with root package name */
    public c f69992b;

    /* renamed from: c  reason: collision with root package name */
    public final List<InterfaceC2021a> f69993c;

    /* renamed from: d  reason: collision with root package name */
    public int f69994d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f69995e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f69996f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f69997g;

    /* renamed from: h  reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f69998h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2021a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f70000a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(941936584, "Lcom/ss/android/socialbase/downloader/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(941936584, "Lcom/ss/android/socialbase/downloader/a/a$b;");
                    return;
                }
            }
            f70000a = new a();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    private Object[] d() {
        InterceptResult invokeV;
        Object[] array;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            synchronized (this.f69993c) {
                array = this.f69993c.size() > 0 ? this.f69993c.toArray() : null;
            }
            return array;
        }
        return (Object[]) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f69996f = 1;
            Object[] d2 = d();
            if (d2 != null) {
                for (Object obj : d2) {
                    ((InterfaceC2021a) obj).b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f69996f = 0;
            Object[] d2 = d();
            if (d2 != null) {
                for (Object obj : d2) {
                    ((InterfaceC2021a) obj).c();
                }
            }
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            try {
                Application application = this.f69991a;
                if (application == null) {
                    return false;
                }
                String packageName = application.getPackageName();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100 && TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69993c = new ArrayList();
        this.f69996f = -1;
        this.f69997g = false;
        this.f69998h = new Application.ActivityLifecycleCallbacks(this) { // from class: com.ss.android.socialbase.downloader.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f69999a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69999a = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                    this.f69999a.f69997g = true;
                    if (this.f69999a.f69994d != 0 || activity == null) {
                        return;
                    }
                    this.f69999a.f69994d = activity.hashCode();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) {
                    int i4 = this.f69999a.f69994d;
                    this.f69999a.f69997g = false;
                    this.f69999a.f69994d = activity != null ? activity.hashCode() : i4;
                    if (i4 == 0) {
                        this.f69999a.e();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                    this.f69999a.f69995e = new WeakReference(activity);
                    int i4 = this.f69999a.f69994d;
                    this.f69999a.f69994d = activity != null ? activity.hashCode() : i4;
                    this.f69999a.f69997g = false;
                    if (i4 == 0) {
                        this.f69999a.e();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                    if (activity != null && activity.hashCode() == this.f69999a.f69994d) {
                        this.f69999a.f69994d = 0;
                        this.f69999a.f();
                    }
                    this.f69999a.f69997g = false;
                }
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f69996f;
            int i3 = i2;
            if (i2 == -1) {
                ?? g2 = g();
                this.f69996f = g2;
                i3 = g2;
            }
            return i3 == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b() && !this.f69997g : invokeV.booleanValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.f70000a : (a) invokeV.objValue;
    }

    public void b(InterfaceC2021a interfaceC2021a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC2021a) == null) {
            synchronized (this.f69993c) {
                this.f69993c.remove(interfaceC2021a);
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && this.f69991a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f69991a == null) {
                    Application application = (Application) context;
                    this.f69991a = application;
                    application.registerActivityLifecycleCallbacks(this.f69998h);
                }
            }
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f69992b = cVar;
        }
    }

    public void a(InterfaceC2021a interfaceC2021a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2021a) == null) || interfaceC2021a == null) {
            return;
        }
        synchronized (this.f69993c) {
            if (!this.f69993c.contains(interfaceC2021a)) {
                this.f69993c.add(interfaceC2021a);
            }
        }
    }
}
