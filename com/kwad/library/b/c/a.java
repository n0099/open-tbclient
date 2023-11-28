package com.kwad.library.b.c;

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
import com.kwad.sdk.api.loader.Wrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    public static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    public static final ThreadLocal<C0688a> sAutoUnWrapModelTL = new ThreadLocal<>();
    public static final List<String> sAutoUnWrapStackList = new ArrayList();
    public static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwad.library.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0688a {
        public WeakReference<Context> aiu;
        public int aiv;
        public StackTraceElement[] aiw;
        public int aix;
        public long aiy;

        public C0688a() {
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

        public /* synthetic */ C0688a(byte b) {
            this();
        }

        public static /* synthetic */ int c(C0688a c0688a) {
            int i = c0688a.aiv;
            c0688a.aiv = i + 1;
            return i;
        }

        public static /* synthetic */ int g(C0688a c0688a) {
            int i = c0688a.aix;
            c0688a.aix = i + 1;
            return i;
        }
    }

    public static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    @Nullable
    public static Context a(String str, Context context) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        WeakReference<Context> weakReference = map.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        com.kwad.library.b.a bw = bw(str);
        if (bw != null && bw.isLoaded() && (resources = bw.getResources()) != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    public static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bw = bw(str);
        if (bw != null && bw.isLoaded()) {
            Resources resources2 = bw.getResources();
            StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
            sb.append(str);
            sb.append(", wrappedResources: ");
            sb.append(resources2);
            if (resources2 != null) {
                return resources2;
            }
            return resources;
        }
        StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
        sb2.append(str);
        sb2.append(" , plugin: ");
        sb2.append(bw);
        sb2.append(", isLoaded(): false");
        return resources;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bw = bw(str);
        if (bw != null && bw.isLoaded()) {
            Context context = layoutInflater.getContext();
            if (!(context instanceof b)) {
                Context h = h(context, str);
                if (h instanceof b) {
                    return layoutInflater.cloneInContext(h);
                }
                return layoutInflater;
            }
            return layoutInflater;
        }
        return layoutInflater;
    }

    public static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b wK;
        com.kwad.library.b.a bw = bw(str);
        if (bw != null && bw.isLoaded() && (wK = bw.wK()) != null) {
            return wK;
        }
        return classLoader;
    }

    public static void a(String str, Context context, Context context2) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        map.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            if (layoutInflater.getContext() instanceof b) {
                return layoutInflater;
            }
            return layoutInflater.cloneInContext(context);
        }
        return obj;
    }

    public static boolean a(String str, Context context, C0688a c0688a) {
        String str2;
        Context a = a(str, context);
        if (a != null) {
            str2 = a.getClass().getName();
        } else {
            str2 = "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c0688a.aiw)) {
            C0688a.g(c0688a);
            c0688a.aiw = stackTrace;
            if (c0688a.aix < 5) {
                return false;
            }
            Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
            return true;
        } else if (c0688a.aiw != null) {
            c0688a.clear();
            return false;
        } else {
            c0688a.aiw = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str3 : getAutoUnWrapStackList()) {
                    if (className.contains(str3)) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && Wrapper.METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(str2, stackTraceElement2.getClassName()) && Wrapper.METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static Context aq(Context context) {
        return ((b) context).getDelegatedContext();
    }

    public static boolean ar(Context context) {
        return context instanceof b;
    }

    public static com.kwad.library.b.a bw(String str) {
        return com.kwad.library.solder.a.a.i(null, str);
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (ar(context)) {
            context = aq(context);
        }
        if (!ar(context)) {
            return context;
        }
        for (int i = 0; i < 10; i++) {
            context = aq(context);
            if (!ar(context)) {
                return context;
            }
        }
        return context;
    }

    public static boolean b(String str, Context context) {
        int i;
        C0688a c0688a = sAutoUnWrapModelTL.get();
        if (c0688a != null) {
            if (c0688a.aiu.get() != context || Math.abs(System.currentTimeMillis() - c0688a.aiy) >= 150) {
                c0688a.clear();
                c0688a.aiu = new WeakReference(context);
                c0688a.aiy = System.currentTimeMillis();
            } else {
                C0688a.c(c0688a);
                if (context instanceof Application) {
                    i = 15;
                } else {
                    i = 5;
                }
                if (c0688a.aiv >= i && a(str, context, c0688a)) {
                    c0688a.clear();
                    return true;
                }
            }
        } else {
            sAutoUnWrapModelTL.set(new C0688a((byte) 0));
        }
        return false;
    }

    @NonNull
    public static Context h(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bw = bw(str);
        if (bw != null && bw.isLoaded() && !(context instanceof b) && !b(str, context)) {
            Context a = a(str, context);
            if (a != null) {
                return a;
            }
            if (context instanceof ContextThemeWrapper) {
                eVar = new c((ContextThemeWrapper) context, str);
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
            } else if (context instanceof ContextWrapper) {
                eVar = new e(context, str);
            } else {
                eVar = new e(context, str);
            }
            a(str, context, eVar);
            return eVar;
        }
        return context;
    }
}
