package com.kwai.sodler.lib.kwai.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwai.sodler.lib.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.kwai.sodler.lib.kwai.b.a";
    public static final ThreadLocal<C0571a> b;
    public static final List<String> c;
    public static Map<Context, Context> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwai.sodler.lib.kwai.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0571a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;
        public int b;
        public StackTraceElement[] c;
        public int d;
        public long e;

        public C0571a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(null);
            this.b = 0;
            this.c = null;
            this.d = 0;
        }

        public /* synthetic */ C0571a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                this.a = new WeakReference<>(null);
                this.b = 0;
                this.c = null;
                this.d = 0;
                this.e = 0L;
            }
        }

        public static /* synthetic */ int c(C0571a c0571a) {
            int i = c0571a.b;
            c0571a.b = i + 1;
            return i;
        }

        public static /* synthetic */ int g(C0571a c0571a) {
            int i = c0571a.d;
            c0571a.d = i + 1;
            return i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2108335899, "Lcom/kwai/sodler/lib/kwai/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2108335899, "Lcom/kwai/sodler/lib/kwai/b/a;");
                return;
            }
        }
        b = new ThreadLocal<>();
        c = new ArrayList();
        d = new WeakHashMap();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public static Context a(@Nullable Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            com.kwai.sodler.lib.kwai.a a2 = a(str);
            if (a2 != null && a2.d()) {
                if (context == null) {
                    return null;
                }
                if (!(context instanceof b) && !d(context)) {
                    Context context2 = d.get(context);
                    if (context instanceof ContextThemeWrapper) {
                        if (context2 == null) {
                            context2 = new c((ContextThemeWrapper) context, str);
                            a(context, context2);
                        }
                        return context2;
                    } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                        if (context2 == null) {
                            context2 = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
                            a(context, context2);
                        }
                        return context2;
                    } else if (context instanceof ContextWrapper) {
                        if (context2 == null) {
                            context2 = new e(context, str);
                            a(context, context2);
                        }
                        return context2;
                    } else {
                        if (context2 == null) {
                            context2 = new e(context, str);
                            a(context, context2);
                        }
                        return context2;
                    }
                }
            }
            return context;
        }
        return (Context) invokeLL.objValue;
    }

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        InterceptResult invokeLLIL;
        Resources b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, theme, theme2, i, str)) == null) {
            com.kwai.sodler.lib.kwai.a a2 = a(str);
            if (a2 == null || !a2.d() || (b2 = a2.b()) == null) {
                return theme;
            }
            if (theme2 == null) {
                Resources.Theme newTheme = b2.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return (Resources.Theme) invokeLLIL.objValue;
    }

    public static Resources a(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, str)) == null) {
            com.kwai.sodler.lib.kwai.a a2 = a(str);
            if (a2 == null || !a2.d()) {
                StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
                sb.append(str);
                sb.append(" , plugin: ");
                sb.append(a2);
                sb.append(", isLoaded(): false");
                return resources;
            }
            Resources b2 = a2.b();
            StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
            sb2.append(str);
            sb2.append(", wrappedResources: ");
            sb2.append(b2);
            return b2 != null ? b2 : resources;
        }
        return (Resources) invokeLL.objValue;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, layoutInflater, str)) == null) {
            com.kwai.sodler.lib.kwai.a a2 = a(str);
            if (a2 == null || !a2.d()) {
                return layoutInflater;
            }
            Context context = layoutInflater.getContext();
            if (context instanceof b) {
                return layoutInflater;
            }
            Context a3 = a(context, str);
            return a3 instanceof b ? layoutInflater.cloneInContext(a3) : layoutInflater;
        }
        return (LayoutInflater) invokeLL.objValue;
    }

    public static com.kwai.sodler.lib.kwai.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            com.kwai.sodler.lib.a.a a2 = i.a().d().a(str);
            if (a2 != null && a2.d() && (a2 instanceof com.kwai.sodler.lib.kwai.a)) {
                return (com.kwai.sodler.lib.kwai.a) a2;
            }
            return null;
        }
        return (com.kwai.sodler.lib.kwai.a) invokeL.objValue;
    }

    public static ClassLoader a(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        com.kwai.sodler.lib.kwai.kwai.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, classLoader, str)) == null) {
            com.kwai.sodler.lib.kwai.a a3 = a(str);
            return (a3 == null || !a3.d() || (a2 = a3.a()) == null) ? classLoader : a2;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    public static Object a(Object obj, String str, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, str, context)) == null) {
            if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
                LayoutInflater layoutInflater = (LayoutInflater) obj;
                return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
            }
            return obj;
        }
        return invokeLLL.objValue;
    }

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (c.isEmpty()) {
                c.add("com.sensorsdata.analytics.android.sdk");
            }
            return c;
        }
        return (List) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            d.remove(context);
        }
    }

    public static void a(Context context, Context context2) {
        Application c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, context2) == null) {
            d.put(context, context2);
            if (!(context instanceof Activity) || (c2 = c(context)) == null) {
                return;
            }
            c2.registerActivityLifecycleCallbacks(new com.kwad.sdk.core.kwai.a(context, c2) { // from class: com.kwai.sodler.lib.kwai.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ Application b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, c2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.b = c2;
                }

                @Override // com.kwad.sdk.core.kwai.a, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) && activity == this.a) {
                        this.b.unregisterActivityLifecycleCallbacks(this);
                        a.a(this.a);
                    }
                }
            });
        }
    }

    public static boolean a(Context context, C0571a c0571a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, c0571a)) == null) {
            Context context2 = d.get(context);
            String name = context2 != null ? context2.getClass().getName() : "";
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (!Arrays.equals(stackTrace, c0571a.c)) {
                if (c0571a.c != null) {
                    c0571a.a();
                    return false;
                }
                c0571a.c = stackTrace;
                int i = 0;
                int i2 = 0;
                while (i < stackTrace.length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    String className = stackTraceElement.getClassName();
                    for (String str2 : a()) {
                        str = className.contains(str2) ? "needAutoUnWrap true 命中白名单" : "needAutoUnWrap true 命中白名单";
                    }
                    String methodName = stackTraceElement.getMethodName();
                    i++;
                    if (i < stackTrace.length && a.equals(className) && Wrapper.METHOD_WRAP_CONTEXT.equals(methodName)) {
                        StackTraceElement stackTraceElement2 = stackTrace[i];
                        if (TextUtils.equals(name, stackTraceElement2.getClassName()) && Wrapper.METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                            return true;
                        }
                    }
                }
                return false;
            }
            C0571a.g(c0571a);
            c0571a.c = stackTrace;
            if (c0571a.d < 5) {
                return false;
            }
            str = "needAutoUnWrap true 连续相同堆栈";
            Log.d("Solder.PluginWrapper", str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Context b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            b bVar = context instanceof b ? (b) context : null;
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof b) {
                    bVar = (b) context2;
                    context2 = bVar.a();
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            return bVar != null ? bVar.a() : context;
        }
        return (Context) invokeL.objValue;
    }

    @Nullable
    public static Application c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            Context b2 = b(context);
            for (int i = 0; i < 15; i++) {
                b2 = b2.getApplicationContext();
                if (b2 instanceof b) {
                    b2 = ((b) b2).a();
                }
                if (b2 instanceof Application) {
                    return (Application) b2;
                }
            }
            return null;
        }
        return (Application) invokeL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            C0571a c0571a = b.get();
            if (c0571a == null) {
                b.set(new C0571a((byte) 0));
            } else if (c0571a.a.get() != context || Math.abs(System.currentTimeMillis() - c0571a.e) >= 150) {
                c0571a.a();
                c0571a.a = new WeakReference(context);
                c0571a.e = System.currentTimeMillis();
            } else {
                C0571a.c(c0571a);
                if (c0571a.b >= (context instanceof Application ? 15 : 5) && a(context, c0571a)) {
                    c0571a.a();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
