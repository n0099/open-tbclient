package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes5.dex */
public class Wrapper {
    public static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    public static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    public static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    public static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    public static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    public static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    public static final String TAG = "Wrapper";
    public static final int TIMELINE_MINIWRAP = 150;
    public static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    public static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    public static Map<Context, Context> sResContextCache = new WeakHashMap();

    /* loaded from: classes5.dex */
    public static class a {
        public WeakReference<Context> Sc;
        public StackTraceElement[] Sd;
        public int b;
        public int d;
        public long e;

        public a() {
            this.Sc = new WeakReference<>(null);
            this.b = 0;
            this.Sd = null;
            this.d = 0;
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final void a() {
            this.Sc = new WeakReference<>(null);
            this.b = 0;
            this.Sd = null;
            this.d = 0;
            this.e = 0L;
        }
    }

    public static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static boolean needAutoUnWrap(Context context, a aVar) {
        String str;
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.Sd)) {
            if (aVar.Sd != null) {
                aVar.a();
                return false;
            }
            aVar.Sd = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                        str = "needAutoUnWrap true 命中白名单";
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        int i3 = aVar.d + 1;
        aVar.d = i3;
        aVar.Sd = stackTrace;
        if (i3 < 5) {
            return false;
        }
        str = "needAutoUnWrap true 连续相同堆栈";
        Log.d(TAG, str);
        return true;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    public static boolean returnUnWrappedContext(Context context) {
        a aVar = sAutoUnWrapModelTL.get();
        if (aVar == null) {
            sAutoUnWrapModelTL.set(new a((byte) 0));
        } else if (aVar.Sc.get() != context || Math.abs(System.currentTimeMillis() - aVar.e) >= 150) {
            aVar.a();
            aVar.Sc = new WeakReference<>(context);
            aVar.e = System.currentTimeMillis();
        } else {
            aVar.b++;
            if (aVar.b >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, aVar)) {
                aVar.a();
                return true;
            }
        }
        return false;
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
                    o oVar = new o((ContextThemeWrapper) context);
                    sResContextCache.put(context, oVar);
                    return oVar;
                }
                return context2;
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context3 = sResContextCache.get(context);
                if (context3 == null) {
                    p pVar = new p((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, pVar);
                    return pVar;
                }
                return context3;
            } else if (context instanceof ContextWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    q qVar = new q(context);
                    sResContextCache.put(context, qVar);
                    return qVar;
                }
                return context4;
            } else {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    q qVar2 = new q(context);
                    sResContextCache.put(context, qVar2);
                    return qVar2;
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
