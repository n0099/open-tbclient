package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
@Keep
/* loaded from: classes3.dex */
public class Wrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    public static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    public static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    public static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    public static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    public static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    public static final String TAG = "Wrapper";
    public static final ThreadLocal<a> sAutoUnWrapModelTL;
    public static final List<String> sAutoUnWrapStackList;
    public static Map<Context, Context> sResContextCache;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.api.loader.Wrapper$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;

        /* renamed from: b  reason: collision with root package name */
        public int f57566b;

        /* renamed from: c  reason: collision with root package name */
        public StackTraceElement[] f57567c;

        /* renamed from: d  reason: collision with root package name */
        public int f57568d;

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
            this.a = new WeakReference<>(null);
            this.f57566b = 0;
            this.f57567c = null;
            this.f57568d = 0;
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.a = new WeakReference<>(null);
                this.f57566b = 0;
                this.f57567c = null;
                this.f57568d = 0;
            }
        }

        public static /* synthetic */ int b(a aVar) {
            int i2 = aVar.f57566b;
            aVar.f57566b = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int f(a aVar) {
            int i2 = aVar.f57568d;
            aVar.f57568d = i2 + 1;
            return i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1972734964, "Lcom/kwad/sdk/api/loader/Wrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1972734964, "Lcom/kwad/sdk/api/loader/Wrapper;");
                return;
            }
        }
        sAutoUnWrapModelTL = new ThreadLocal<>();
        sAutoUnWrapStackList = new ArrayList();
        sResContextCache = new WeakHashMap();
    }

    public Wrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> getAutoUnWrapStackList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sAutoUnWrapStackList.isEmpty()) {
                sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
            }
            return sAutoUnWrapStackList;
        }
        return (List) invokeV.objValue;
    }

    public static boolean needAutoUnWrap(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, aVar)) == null) {
            Context context2 = sResContextCache.get(context);
            String name = context2 != null ? context2.getClass().getName() : "";
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (Arrays.equals(stackTrace, aVar.f57567c)) {
                a.f(aVar);
                aVar.f57567c = stackTrace;
                return aVar.f57568d >= 5;
            } else if (aVar.f57567c != null) {
                aVar.a();
                return false;
            } else {
                aVar.f57567c = stackTrace;
                int i2 = 0;
                int i3 = 0;
                while (i2 < stackTrace.length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    String className = stackTraceElement.getClassName();
                    for (String str : getAutoUnWrapStackList()) {
                        if (className.contains(str)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    i2++;
                    if (i2 < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                        StackTraceElement stackTraceElement2 = stackTrace[i2];
                        if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i3 = i3 + 1) >= 5) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, classLoader)) == null) {
            ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
            return externalClassLoader != null ? externalClassLoader : classLoader;
        }
        return (ClassLoader) invokeL.objValue;
    }

    public static Resources replaceExternalResources(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, resources)) == null) {
            Resources externalResource = Loader.get().getExternalResource();
            return externalResource != null ? externalResource : resources;
        }
        return (Resources) invokeL.objValue;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, theme, theme2, i2)) == null) {
            Resources externalResource = Loader.get().getExternalResource();
            if (externalResource != null) {
                if (theme2 == null) {
                    Resources.Theme newTheme = externalResource.newTheme();
                    newTheme.applyStyle(i2, true);
                    return newTheme;
                }
                return theme2;
            }
            return theme;
        }
        return (Resources.Theme) invokeLLI.objValue;
    }

    public static boolean returnUnWrappedContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            a aVar = sAutoUnWrapModelTL.get();
            if (aVar == null) {
                sAutoUnWrapModelTL.set(new a(null));
                return false;
            } else if (aVar.a.get() != context) {
                aVar.a();
                aVar.a = new WeakReference(context);
                return false;
            } else {
                a.b(aVar);
                if (aVar.f57566b < (context instanceof Application ? 15 : 5) || !needAutoUnWrap(context, aVar)) {
                    return false;
                }
                aVar.a();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Keep
    public static Context unwrapContextIfNeed(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof ResContext) {
                    resContext = (ResContext) context2;
                    context2 = resContext.getDelegatedContext();
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            return resContext != null ? resContext.getDelegatedContext() : context;
        }
        return (Context) invokeL.objValue;
    }

    @Nullable
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (Loader.get().isExternalLoaded()) {
                if (context == null) {
                    return null;
                }
                if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
                    return context;
                }
                if (context instanceof ContextThemeWrapper) {
                    Context context2 = sResContextCache.get(context);
                    if (context2 == null) {
                        l lVar = new l((ContextThemeWrapper) context);
                        sResContextCache.put(context, lVar);
                        return lVar;
                    }
                    return context2;
                } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                    Context context3 = sResContextCache.get(context);
                    if (context3 == null) {
                        m mVar = new m((androidx.appcompat.view.ContextThemeWrapper) context);
                        sResContextCache.put(context, mVar);
                        return mVar;
                    }
                    return context3;
                } else if (context instanceof ContextWrapper) {
                    Context context4 = sResContextCache.get(context);
                    if (context4 == null) {
                        n nVar = new n(context);
                        sResContextCache.put(context, nVar);
                        return nVar;
                    }
                    return context4;
                } else {
                    Context context5 = sResContextCache.get(context);
                    if (context5 == null) {
                        n nVar2 = new n(context);
                        sResContextCache.put(context, nVar2);
                        return nVar2;
                    }
                    return context5;
                }
            }
            return context;
        }
        return (Context) invokeL.objValue;
    }

    @Keep
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, layoutInflater)) == null) {
            if (Loader.get().isExternalLoaded()) {
                Context context = layoutInflater.getContext();
                if (context instanceof ResContext) {
                    return layoutInflater;
                }
                Context wrapContextIfNeed = wrapContextIfNeed(context);
                return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
            }
            return layoutInflater;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, obj, str, context)) == null) {
            if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
                LayoutInflater layoutInflater = (LayoutInflater) obj;
                return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
            }
            return obj;
        }
        return invokeLLL.objValue;
    }
}
