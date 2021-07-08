package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class Loader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f33772a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f33773b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f33774c;

    /* renamed from: d  reason: collision with root package name */
    public j f33775d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f33776e;

    /* renamed from: com.kwad.sdk.api.loader.Loader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Loader f33777a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1854454337, "Lcom/kwad/sdk/api/loader/Loader$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1854454337, "Lcom/kwad/sdk/api/loader/Loader$a;");
                    return;
                }
            }
            f33777a = new Loader(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(51701532, "Lcom/kwad/sdk/api/loader/Loader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(51701532, "Lcom/kwad/sdk/api/loader/Loader;");
                return;
            }
        }
        f33772a = !Loader.class.desiredAssertionStatus();
    }

    public Loader() {
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
        this.f33774c = null;
        this.f33775d = null;
        this.f33776e = new AtomicBoolean(false);
    }

    public /* synthetic */ Loader(AnonymousClass1 anonymousClass1) {
        this();
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        InterceptResult invokeL;
        IKsAdSDK iKsAdSDK;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, classLoader)) == null) {
            synchronized (Loader.class) {
                try {
                    KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                    if (!f33772a && ksAdSdkDynamicApi == null) {
                        throw new AssertionError();
                    }
                    Object invoke = Class.forName(ksAdSdkDynamicApi.value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                    if (invoke == null) {
                        throw new RuntimeException("Can not get sdk form " + classLoader);
                    }
                    iKsAdSDK = (IKsAdSDK) invoke;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            return iKsAdSDK;
        }
        return (IKsAdSDK) invokeL.objValue;
    }

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str) == null) {
            g.g(context, str);
        }
    }

    private boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            String a2 = a(context);
            String b2 = b(context);
            if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(b2)) {
                return false;
            }
            if (!TextUtils.isEmpty(b2) && f.a(b2, a2)) {
                f.a(context, f.f33810b, b2);
                a(context, a2);
                f.a(context, f.f33809a, "");
                a2 = b2;
            }
            return !TextUtils.isEmpty(a2);
        }
        return invokeL.booleanValue;
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            String a2 = f.a(context);
            if (TextUtils.isEmpty(a2) || !a2.equals("3.3.11")) {
                String a3 = f.a(context, f.f33810b);
                f.a(context, f.f33810b, "");
                f.a(context, f.f33809a, "");
                g.b(g.c(context, a3));
                f.b(context, "3.3.11");
            }
        }
    }

    public static Loader get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.f33777a : (Loader) invokeV.objValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? f.a(context, f.f33810b) : (String) invokeL.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? f.a(context, f.f33809a) : (String) invokeL.objValue;
    }

    public void checkUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r.a(this.f33773b);
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33773b : (Context) invokeV.objValue;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            j jVar = this.f33775d;
            if (jVar != null) {
                return jVar.b();
            }
            return null;
        }
        return (ClassLoader) invokeV.objValue;
    }

    @MainThread
    public Resources getExternalResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j jVar = this.f33775d;
            if (jVar != null) {
                return jVar.a();
            }
            return null;
        }
        return (Resources) invokeV.objValue;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f33775d;
            if (jVar != null) {
                IKsAdSDK c2 = jVar.c();
                c2.setIsExternal(true);
                return c2;
            }
            if (this.f33774c == null) {
                this.f33774c = a(this.f33773b != null ? this.f33773b.getClassLoader() : Loader.class.getClassLoader());
            }
            this.f33774c.setIsExternal(false);
            return this.f33774c;
        }
        return (IKsAdSDK) invokeV.objValue;
    }

    public ClassLoader getRealClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            j jVar = this.f33775d;
            return jVar != null ? jVar.b() : Loader.class.getClassLoader();
        }
        return (ClassLoader) invokeV.objValue;
    }

    @MainThread
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || this.f33776e.get()) {
            return;
        }
        this.f33776e.set(true);
        this.f33773b = context.getApplicationContext();
        d(this.f33773b);
        if (c(context)) {
            this.f33775d = j.a(this.f33773b, a(context));
        }
        if (this.f33775d == null) {
            this.f33774c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33775d != null : invokeV.booleanValue;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, cls, obj)) == null) {
            if (!this.f33776e.get()) {
                KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
            }
            return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
        }
        return (T) invokeLLL.objValue;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, cls, obj)) == null) {
            if (!this.f33776e.get()) {
                KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
            }
            return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
        }
        return (T) invokeLLL.objValue;
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) ? (T) getKsAdSDKImpl().newInstance(cls) : (T) invokeL.objValue;
    }
}
