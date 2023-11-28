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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a {
        public WeakReference<Context> aiu;
        public int aiv;
        public StackTraceElement[] aiw;
        public int aix;
        public long aiy;

        public a() {
            this.aiu = new WeakReference<>(null);
            this.aiv = 0;
            this.aiw = null;
            this.aix = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aiu = new WeakReference<>(null);
            this.aiv = 0;
            this.aiw = null;
            this.aix = 0;
            this.aiy = 0L;
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static /* synthetic */ int c(a aVar) {
            int i = aVar.aiv;
            aVar.aiv = i + 1;
            return i;
        }

        public static /* synthetic */ int g(a aVar) {
            int i = aVar.aix;
            aVar.aix = i + 1;
            return i;
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
        if (context2 != null) {
            str = context2.getClass().getName();
        } else {
            str = "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.aiw)) {
            a.g(aVar);
            aVar.aiw = stackTrace;
            if (aVar.aix < 5) {
                return false;
            }
            Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
            return true;
        } else if (aVar.aiw != null) {
            aVar.clear();
            return false;
        } else {
            aVar.aiw = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                        Log.d(TAG, "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(str, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            return externalClassLoader;
        }
        return classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            return externalResource;
        }
        return resources;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.c("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (!(context instanceof ResContext)) {
            Context wrapContextIfNeed = wrapContextIfNeed(context);
            if (wrapContextIfNeed instanceof ResContext) {
                return layoutInflater.cloneInContext(wrapContextIfNeed);
            }
            return layoutInflater;
        }
        return layoutInflater;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.c("WRT", theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
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

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            if (layoutInflater.getContext() instanceof ResContext) {
                return layoutInflater;
            }
            return layoutInflater.cloneInContext(context);
        }
        return obj;
    }

    public static boolean returnUnWrappedContext(Context context) {
        int i;
        a aVar = sAutoUnWrapModelTL.get();
        if (aVar != null) {
            if (aVar.aiu.get() != context || Math.abs(System.currentTimeMillis() - aVar.aiy) >= 150) {
                aVar.clear();
                aVar.aiu = new WeakReference(context);
                aVar.aiy = System.currentTimeMillis();
            } else {
                a.c(aVar);
                if (context instanceof Application) {
                    i = 15;
                } else {
                    i = 5;
                }
                if (aVar.aiv >= i && needAutoUnWrap(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            }
        } else {
            sAutoUnWrapModelTL.set(new a((byte) 0));
        }
        return false;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.c("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = null;
        if (context instanceof ResContext) {
            resContext = (ResContext) context;
        }
        Context context3 = context;
        while (context3 instanceof ContextWrapper) {
            if (context3 instanceof Activity) {
                return context3;
            }
            if (context3 instanceof ResContext) {
                resContext = (ResContext) context3;
                context3 = resContext.getDelegatedContext();
            } else {
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        if (resContext != null) {
            return resContext.getDelegatedContext();
        }
        return context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.c("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if (!(context instanceof ResContext) && !returnUnWrappedContext(context)) {
            if (context instanceof ContextThemeWrapper) {
                Context context3 = sResContextCache.get(context);
                if (context3 == null) {
                    n nVar = new n((ContextThemeWrapper) context);
                    sResContextCache.put(context, nVar);
                    return nVar;
                }
                return context3;
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    o oVar = new o((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, oVar);
                    return oVar;
                }
                return context4;
            } else if (context instanceof ContextWrapper) {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    p pVar = new p(context);
                    sResContextCache.put(context, pVar);
                    return pVar;
                }
                return context5;
            } else {
                Context context6 = sResContextCache.get(context);
                if (context6 == null) {
                    p pVar2 = new p(context);
                    sResContextCache.put(context, pVar2);
                    return pVar2;
                }
                return context6;
            }
        }
        return context;
    }
}
