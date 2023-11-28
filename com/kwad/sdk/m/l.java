package com.kwad.sdk.m;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
/* loaded from: classes10.dex */
public final class l {
    public static Application aRO;

    public static Application MA() {
        Application application = (Application) s.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        if (application != null) {
            return application;
        }
        return (Application) s.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static Application My() {
        checkInit();
        Application Mz = Mz();
        if (i.Mw()) {
            aRO = (Application) i.wrapContextIfNeed(Mz);
        }
        return aRO;
    }

    public static void checkInit() {
        if (!e.Mt().KY()) {
            ServiceProvider.b(new RuntimeException("please init KSPlugin"));
        }
    }

    public static Application Mz() {
        Context applicationContext;
        Application application = aRO;
        if (application != null) {
            return application;
        }
        Context Jn = ServiceProvider.Jn();
        if (Jn instanceof Application) {
            Application application2 = (Application) Jn;
            aRO = application2;
            return application2;
        }
        Context applicationContext2 = Jn.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            Application application3 = (Application) applicationContext2;
            aRO = application3;
            return application3;
        }
        if (ar(applicationContext2)) {
            applicationContext = i.dl(applicationContext2);
        } else if (j.ar(applicationContext2)) {
            applicationContext = j.dl(applicationContext2);
        } else {
            applicationContext = Jn.getApplicationContext();
        }
        if (applicationContext instanceof Application) {
            aRO = (Application) applicationContext;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Ct().getApplication();
            if (application4 != null) {
                aRO = application4;
            } else if (applicationContext instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) applicationContext).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    aRO = (Application) baseContext;
                }
            }
        }
        if (aRO == null) {
            aRO = MA();
        }
        Application ds = ds(aRO);
        aRO = ds;
        return ds;
    }

    public static View a(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup, boolean z) {
        return dv(context).inflate(i, viewGroup, false);
    }

    public static void a(Application application) {
        if (aRO == null) {
            aRO = application;
        }
    }

    public static boolean ar(Context context) {
        return context instanceof a;
    }

    public static int dn(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object callMethod = s.callMethod(context, "getThemeResId", new Object[0]);
            if (callMethod == null) {
                return 0;
            }
            return ((Integer) callMethod).intValue();
        } else if (!(context instanceof androidx.appcompat.view.ContextThemeWrapper)) {
            return 0;
        } else {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
    }

    @Nullable
    /* renamed from: do  reason: not valid java name */
    public static Activity m186do(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context dq = dq(context);
        if (dq instanceof Activity) {
            return (Activity) dq;
        }
        com.kwad.sdk.core.c.b.Ct();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    @NonNull
    public static Context dq(Context context) {
        Context unwrapContextIfNeed;
        checkInit();
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()) {
            return context;
        }
        if (dt(context)) {
            return context;
        }
        if (ar(context)) {
            unwrapContextIfNeed = i.dk(context);
        } else {
            unwrapContextIfNeed = j.unwrapContextIfNeed(context);
        }
        return dr(unwrapContextIfNeed);
    }

    public static boolean dt(Context context) {
        if (!ar(context) && !j.ar(context)) {
            return true;
        }
        return false;
    }

    public static LayoutInflater dv(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (j.ar(wrapContextIfNeed)) {
            LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
            a(from);
            return from;
        }
        return LayoutInflater.from(wrapContextIfNeed);
    }

    public static Context dw(Context context) {
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public static void h(Activity activity) {
        j.onDestroy(activity);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        Context wrapContextIfNeed;
        checkInit();
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()) {
            return context;
        }
        if (i.Mw()) {
            wrapContextIfNeed = i.wrapContextIfNeed(context);
        } else {
            wrapContextIfNeed = j.wrapContextIfNeed(context);
        }
        return dp(wrapContextIfNeed);
    }

    public static void a(LayoutInflater layoutInflater) {
        s.a(layoutInflater, "mFactory", (Object) null);
        s.a(layoutInflater, "mFactory2", (Object) null);
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(dw(context)).cloneInContext(context2);
        a(cloneInContext);
        return cloneInContext;
    }

    public static void x(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    @NonNull
    public static Context dp(Context context) {
        if (i.Mw() && !ar(context)) {
            boolean hasInitFinish = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
            ServiceProvider.b(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish));
        } else if (!i.Mw() && !j.ar(context)) {
            boolean hasInitFinish2 = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
            ServiceProvider.b(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish2));
        }
        return context;
    }

    public static Context dr(Context context) {
        if (j.ar(context) || (context instanceof a)) {
            boolean hasInitFinish = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
            ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish));
        }
        return context;
    }

    public static Context du(Context context) {
        if (j.ar(context)) {
            context = j.aq(context);
        }
        if (context instanceof a) {
            context = ((a) context).getDelegatedContext();
        }
        if (dt(context)) {
            return context;
        }
        for (int i = 0; i < 5; i++) {
            if (j.ar(context)) {
                context = j.aq(context);
            }
            if (context instanceof a) {
                context = ((a) context).getDelegatedContext();
            }
            if (dt(context)) {
                return context;
            }
        }
        return context;
    }

    public static Application ds(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        boolean hasInitFinish = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).hasInitFinish();
        ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()));
        return null;
    }

    public static View inflate(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup) {
        return dv(context).inflate(i, viewGroup);
    }
}
