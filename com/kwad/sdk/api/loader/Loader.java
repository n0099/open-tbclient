package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.loader.l;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class Loader {
    public static final /* synthetic */ boolean a = !Loader.class.desiredAssertionStatus();
    public volatile Context b;
    public IKsAdSDK c;
    public k d;
    public AtomicBoolean e;

    /* loaded from: classes5.dex */
    public static class a {
        public static final Loader a = new Loader((byte) 0);
    }

    public Loader() {
        this.c = null;
        this.d = null;
        this.e = new AtomicBoolean(false);
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!a && ksAdSdkDynamicApi == null) {
                    throw new AssertionError();
                }
                Object invoke = Class.forName(ksAdSdkDynamicApi.value(), true, classLoader).getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, new Class[0]).invoke(null, new Object[0]);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form ".concat(String.valueOf(classLoader)));
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return iKsAdSDK;
    }

    public static String a(Context context) {
        return g.a(context, g.b);
    }

    public static Loader get() {
        return a.a;
    }

    public void checkAutoRevert() {
        k kVar;
        int intValue;
        if (this.b == null || (kVar = this.d) == null) {
            return;
        }
        try {
            IKsAdSDK iKsAdSDK = kVar.c;
            Object dM = iKsAdSDK.dM("autoRT", new Object[0]);
            if (!(dM instanceof Integer) || (intValue = ((Integer) dM).intValue()) <= 0) {
                return;
            }
            d a2 = d.a(this.b);
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != a2) {
                a2.c = defaultUncaughtExceptionHandler;
            }
            Thread.setDefaultUncaughtExceptionHandler(d.a(this.b));
            d a3 = d.a(this.b);
            a3.f = System.currentTimeMillis();
            a3.d = intValue;
            if (a3.a) {
                Log.d("test.chen", "startCheck:");
            }
            d.a(this.b).b = iKsAdSDK;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void checkUpdate(IKsAdSDK iKsAdSDK) {
        Context context = this.b;
        if (Math.abs(System.currentTimeMillis() - r.c(context, "lastUpdateTime")) >= r.c(context, "interval") * 1000) {
            Object dM = iKsAdSDK.dM("TRANSFORM_API_HOST", "https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
            String obj = dM != null ? dM.toString() : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
            Context context2 = get().getContext();
            new l.e(new l.g(new l.d(new l.h(new l.b(obj, iKsAdSDK), context2), context2), context2), context2).a(new l.c<Boolean>() { // from class: com.kwad.sdk.api.loader.s.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.kwad.sdk.api.loader.l.c
                public final /* synthetic */ void a(Boolean bool) {
                    Log.d("Updater", "checkAndUpdate result: ".concat(String.valueOf(bool)));
                }
            });
        }
    }

    public Context getContext() {
        return this.b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        k kVar = this.d;
        if (kVar != null) {
            return kVar.b;
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        k kVar = this.d;
        if (kVar != null) {
            return kVar.a;
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        k kVar = this.d;
        if (kVar != null) {
            IKsAdSDK iKsAdSDK = kVar.c;
            iKsAdSDK.setIsExternal(true);
            return iKsAdSDK;
        }
        if (this.c == null) {
            this.c = a(this.b != null ? this.b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.c.setIsExternal(false);
        return this.c;
    }

    public ClassLoader getRealClassLoader() {
        k kVar = this.d;
        return kVar != null ? kVar.b : Loader.class.getClassLoader();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init(final Context context) {
        if (this.e.get()) {
            return;
        }
        boolean z = true;
        this.e.set(true);
        this.b = context.getApplicationContext();
        Context context2 = this.b;
        String a2 = g.a(context2);
        boolean b = r.b(context2, g.d);
        if (TextUtils.isEmpty(a2) || !a2.equals(BuildConfig.VERSION_NAME) || b) {
            String a3 = g.a(context2, g.b);
            g.a(context2, g.b, "");
            g.a(context2, g.a, "");
            r.a(context2, g.d, false);
            try {
                h.a(h.b(context2, a3));
            } catch (Exception unused) {
            }
            g.b(context2, BuildConfig.VERSION_NAME);
        }
        final String a4 = g.a(context, g.b);
        String a5 = g.a(context, g.a);
        if (!TextUtils.isEmpty(a4) || !TextUtils.isEmpty(a5)) {
            if (!TextUtils.isEmpty(a5) && g.a(a5, a4)) {
                g.a(context, g.b, a5);
                if (!TextUtils.isEmpty(a4)) {
                    j.a(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                File[] listFiles = h.b(context, a4).getParentFile().listFiles();
                                if (listFiles == null || listFiles.length <= 0) {
                                    return;
                                }
                                for (File file : listFiles) {
                                    if (g.a(a4, file.getName().substring(file.getName().indexOf("-") + 1))) {
                                        h.a(file);
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    });
                }
                g.a(context, g.a, "");
                a4 = a5;
            }
        }
        z = false;
        if (z) {
            this.d = k.a(this.b, g.a(context, g.b));
        }
        if (this.d == null) {
            this.c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.e.get()) {
            KsAdSDK.init(context, SdkConfig.create(r.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.e.get()) {
            KsAdSDK.init(context, SdkConfig.create(r.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
