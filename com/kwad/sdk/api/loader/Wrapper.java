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
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
@Keep
/* loaded from: classes4.dex */
public class Wrapper {
    public static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    public static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    public static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    public static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    public static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    public static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    public static final String TAG = "Wrapper";
    public static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    public static final List<String> sAutoUnWrapStackList = new ArrayList();
    public static Map<Context, Context> sResContextCache = new WeakHashMap();

    /* loaded from: classes4.dex */
    public static class a {
        public WeakReference<Context> a;

        /* renamed from: b  reason: collision with root package name */
        public int f55593b;

        /* renamed from: c  reason: collision with root package name */
        public StackTraceElement[] f55594c;

        /* renamed from: d  reason: collision with root package name */
        public int f55595d;

        public a() {
            this.a = new WeakReference<>(null);
            this.f55593b = 0;
            this.f55594c = null;
            this.f55595d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.a = new WeakReference<>(null);
            this.f55593b = 0;
            this.f55594c = null;
            this.f55595d = 0;
        }

        public static /* synthetic */ int b(a aVar) {
            int i2 = aVar.f55593b;
            aVar.f55593b = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int f(a aVar) {
            int i2 = aVar.f55595d;
            aVar.f55595d = i2 + 1;
            return i2;
        }
    }

    public static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static boolean needAutoUnWrap(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.f55594c)) {
            a.f(aVar);
            aVar.f55594c = stackTrace;
            return aVar.f55595d >= 5;
        } else if (aVar.f55594c != null) {
            aVar.a();
            return false;
        } else {
            aVar.f55594c = stackTrace;
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

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i2) {
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

    public static boolean returnUnWrappedContext(Context context) {
        a aVar = sAutoUnWrapModelTL.get();
        if (aVar == null) {
            sAutoUnWrapModelTL.set(new a());
            return false;
        } else if (aVar.a.get() != context) {
            aVar.a();
            aVar.a = new WeakReference(context);
            return false;
        } else {
            a.b(aVar);
            if (aVar.f55593b < (context instanceof Application ? 15 : 5) || !needAutoUnWrap(context, aVar)) {
                return false;
            }
            aVar.a();
            return true;
        }
    }

    @Keep
    public static Context unwrapContextIfNeed(Context context) {
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

    @Nullable
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
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

    @Keep
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
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

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
        }
        return obj;
    }
}
