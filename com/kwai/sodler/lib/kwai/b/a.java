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
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLAZZ_NAME = "com.kwai.sodler.lib.kwai.b.a";
    public static final ThreadLocal<C0715a> sAutoUnWrapModelTL;
    public static final List<String> sAutoUnWrapStackList;
    public static Map<Context, Context> sResContextCache;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwai.sodler.lib.kwai.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0715a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> axK;
        public int axL;
        public StackTraceElement[] axM;
        public int axN;
        public long axO;

        public C0715a() {
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
            this.axK = new WeakReference<>(null);
            this.axL = 0;
            this.axM = null;
            this.axN = 0;
        }

        public /* synthetic */ C0715a(byte b) {
            this();
        }

        public static /* synthetic */ int c(C0715a c0715a) {
            int i = c0715a.axL;
            c0715a.axL = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, this) == null) {
                this.axK = new WeakReference<>(null);
                this.axL = 0;
                this.axM = null;
                this.axN = 0;
                this.axO = 0L;
            }
        }

        public static /* synthetic */ int g(C0715a c0715a) {
            int i = c0715a.axN;
            c0715a.axN = i + 1;
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
        sAutoUnWrapModelTL = new ThreadLocal<>();
        sAutoUnWrapStackList = new ArrayList();
        sResContextCache = new WeakHashMap();
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

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        InterceptResult invokeLLIL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65538, null, theme, theme2, i, str)) == null) {
            com.kwai.sodler.lib.kwai.a eS = eS(str);
            if (eS == null || !eS.isLoaded() || (resources = eS.getResources()) == null) {
                return theme;
            }
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, resources, str)) == null) {
            com.kwai.sodler.lib.kwai.a eS = eS(str);
            if (eS == null || !eS.isLoaded()) {
                StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
                sb.append(str);
                sb.append(" , plugin: ");
                sb.append(eS);
                sb.append(", isLoaded(): false");
                return resources;
            }
            Resources resources2 = eS.getResources();
            StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
            sb2.append(str);
            sb2.append(", wrappedResources: ");
            sb2.append(resources2);
            return resources2 != null ? resources2 : resources;
        }
        return (Resources) invokeLL.objValue;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutInflater, str)) == null) {
            com.kwai.sodler.lib.kwai.a eS = eS(str);
            if (eS == null || !eS.isLoaded()) {
                return layoutInflater;
            }
            Context context = layoutInflater.getContext();
            if (context instanceof b) {
                return layoutInflater;
            }
            Context ae = ae(context, str);
            return ae instanceof b ? layoutInflater.cloneInContext(ae) : layoutInflater;
        }
        return (LayoutInflater) invokeLL.objValue;
    }

    public static void a(Context context, Context context2) {
        Application dH;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, context2) == null) {
            sResContextCache.put(context, context2);
            if (!(context instanceof Activity) || (dH = dH(context)) == null) {
                return;
            }
            dH.registerActivityLifecycleCallbacks(new com.kwad.sdk.core.kwai.a(context, dH) { // from class: com.kwai.sodler.lib.kwai.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Application axJ;
                public final /* synthetic */ Context gC;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, dH};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.gC = context;
                    this.axJ = dH;
                }

                @Override // com.kwad.sdk.core.kwai.a, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(@NonNull Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) && activity == this.gC) {
                        this.axJ.unregisterActivityLifecycleCallbacks(this);
                        a.onDestroy(this.gC);
                    }
                }
            });
        }
    }

    public static boolean a(Context context, C0715a c0715a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, c0715a)) == null) {
            Context context2 = sResContextCache.get(context);
            String name = context2 != null ? context2.getClass().getName() : "";
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (!Arrays.equals(stackTrace, c0715a.axM)) {
                if (c0715a.axM != null) {
                    c0715a.clear();
                    return false;
                }
                c0715a.axM = stackTrace;
                int i = 0;
                int i2 = 0;
                while (i < stackTrace.length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    String className = stackTraceElement.getClassName();
                    for (String str2 : getAutoUnWrapStackList()) {
                        str = className.contains(str2) ? "needAutoUnWrap true 命中白名单" : "needAutoUnWrap true 命中白名单";
                    }
                    String methodName = stackTraceElement.getMethodName();
                    i++;
                    if (i < stackTrace.length && CLAZZ_NAME.equals(className) && Wrapper.METHOD_WRAP_CONTEXT.equals(methodName)) {
                        StackTraceElement stackTraceElement2 = stackTrace[i];
                        if (TextUtils.equals(name, stackTraceElement2.getClassName()) && Wrapper.METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                            return true;
                        }
                    }
                }
                return false;
            }
            C0715a.g(c0715a);
            c0715a.axM = stackTrace;
            if (c0715a.axN < 5) {
                return false;
            }
            str = "needAutoUnWrap true 连续相同堆栈";
            Log.d("Solder.PluginWrapper", str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static Context ae(@Nullable Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            com.kwai.sodler.lib.kwai.a eS = eS(str);
            if (eS != null && eS.isLoaded()) {
                if (context == null) {
                    return null;
                }
                if (!(context instanceof b) && !returnUnWrappedContext(context)) {
                    Context context2 = sResContextCache.get(context);
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

    public static ClassLoader b(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        com.kwai.sodler.lib.kwai.kwai.b Ff;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, classLoader, str)) == null) {
            com.kwai.sodler.lib.kwai.a eS = eS(str);
            return (eS == null || !eS.isLoaded() || (Ff = eS.Ff()) == null) ? classLoader : Ff;
        }
        return (ClassLoader) invokeLL.objValue;
    }

    @Nullable
    public static Application dH(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Context unwrapContextIfNeed = unwrapContextIfNeed(context);
            for (int i = 0; i < 15; i++) {
                unwrapContextIfNeed = unwrapContextIfNeed.getApplicationContext();
                if (unwrapContextIfNeed instanceof b) {
                    unwrapContextIfNeed = ((b) unwrapContextIfNeed).getDelegatedContext();
                }
                if (unwrapContextIfNeed instanceof Application) {
                    return (Application) unwrapContextIfNeed;
                }
            }
            return null;
        }
        return (Application) invokeL.objValue;
    }

    public static com.kwai.sodler.lib.kwai.a eS(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            com.kwai.sodler.lib.a.a eQ = i.EU().EY().eQ(str);
            if (eQ != null && eQ.isLoaded() && (eQ instanceof com.kwai.sodler.lib.kwai.a)) {
                return (com.kwai.sodler.lib.kwai.a) eQ;
            }
            return null;
        }
        return (com.kwai.sodler.lib.kwai.a) invokeL.objValue;
    }

    public static List<String> getAutoUnWrapStackList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sAutoUnWrapStackList.isEmpty()) {
                sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
            }
            return sAutoUnWrapStackList;
        }
        return (List) invokeV.objValue;
    }

    public static void onDestroy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            sResContextCache.remove(context);
        }
    }

    public static boolean returnUnWrappedContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            C0715a c0715a = sAutoUnWrapModelTL.get();
            if (c0715a == null) {
                sAutoUnWrapModelTL.set(new C0715a((byte) 0));
            } else if (c0715a.axK.get() != context || Math.abs(System.currentTimeMillis() - c0715a.axO) >= 150) {
                c0715a.clear();
                c0715a.axK = new WeakReference(context);
                c0715a.axO = System.currentTimeMillis();
            } else {
                C0715a.c(c0715a);
                if (c0715a.axL >= (context instanceof Application ? 15 : 5) && a(context, c0715a)) {
                    c0715a.clear();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Context unwrapContextIfNeed(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            b bVar = context instanceof b ? (b) context : null;
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof b) {
                    bVar = (b) context2;
                    context2 = bVar.getDelegatedContext();
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            return bVar != null ? bVar.getDelegatedContext() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, obj, str, context)) == null) {
            if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
                LayoutInflater layoutInflater = (LayoutInflater) obj;
                return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
            }
            return obj;
        }
        return invokeLLL.objValue;
    }
}
