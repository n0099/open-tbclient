package com.kwad.sdk.m;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class i {
    public static final String CLAZZ_NAME = "com.kwad.sdk.m.i";
    public static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    public static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    public static final Map<Context, Context> sResContextCache = new WeakHashMap();
    public static final AtomicBoolean aRI = new AtomicBoolean(false);

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

    public static boolean Mw() {
        return aRI.get();
    }

    public static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (!(context instanceof Activity)) {
            return;
        }
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.m.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                if (activity == context) {
                    com.kwad.sdk.core.c.b.Ct();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                    i.onDestroy(context);
                }
            }
        });
    }

    public static boolean a(Context context, a aVar) {
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
            Log.d(Wrapper.TAG, "needAutoUnWrap true 连续相同堆栈");
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
                        Log.d(Wrapper.TAG, "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && Wrapper.METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(str, stackTraceElement2.getClassName()) && Wrapper.METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void cg(boolean z) {
        aRI.set(z);
    }

    public static Context dl(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = dk(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i = 0; i < 10; i++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (applicationContext instanceof com.kwad.sdk.m.a) {
                applicationContext = ((com.kwad.sdk.m.a) applicationContext).getDelegatedContext();
            }
        }
        return applicationContext;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = e.Mt().getClassLoader();
        if (classLoader2 != null) {
            return classLoader2;
        }
        return classLoader;
    }

    public static Context dk(Context context) {
        if (context instanceof com.kwad.sdk.m.a) {
            context = ((com.kwad.sdk.m.a) context).getDelegatedContext();
        }
        if (l.dt(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i = 0; i < 10; i++) {
            if (runtimeException == null) {
                boolean hasInitFinish = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            if (j.ar(context)) {
                context = j.aq(context);
            }
            if (context instanceof com.kwad.sdk.m.a) {
                context = ((com.kwad.sdk.m.a) context).getDelegatedContext();
            }
            if (l.dt(context)) {
                return context;
            }
        }
        return context;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources resources = e.Mt().getResources();
        if (resources != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
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
                if (aVar.aiv >= i && a(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            }
        } else {
            sAutoUnWrapModelTL.set(new a((byte) 0));
        }
        return false;
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        } else if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()) {
            return context;
        } else {
            if (context instanceof com.kwad.sdk.m.a) {
                return context;
            }
            if (j.ar(context)) {
                context = j.unwrapContextIfNeed(context);
                if (j.ar(context)) {
                    ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                    return context;
                }
            }
            Context context3 = sResContextCache.get(context);
            if (context3 instanceof com.kwad.sdk.m.a) {
                return context3;
            }
            if (k.dm(context)) {
                return context;
            }
            if (returnUnWrappedContext(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
                return context;
            }
            if (context instanceof Application) {
                try {
                    f fVar = new f((Application) context, new g(context, e.Mt()));
                    l.a(fVar);
                    context2 = fVar;
                } catch (Throwable unused) {
                    boolean hasInitFinish = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
                    ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish));
                    return context;
                }
            } else if (context instanceof ContextThemeWrapper) {
                context2 = new b((ContextThemeWrapper) context);
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                context2 = new c((androidx.appcompat.view.ContextThemeWrapper) context);
            } else if (context instanceof ContextWrapper) {
                context2 = new d(context);
            } else {
                context2 = new d(context);
            }
            a(context, context2);
            return context2;
        }
    }
}
