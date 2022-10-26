package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class Loader {
    public static final /* synthetic */ boolean a = !Loader.class.desiredAssertionStatus();
    public IKsAdSDK RJ;
    public l RK;
    public AtomicBoolean RL;
    public AtomicBoolean RM;
    public volatile Context b;

    /* loaded from: classes7.dex */
    public final class a {
        public static final Loader RN = new Loader((byte) 0);
    }

    public Loader() {
        this.RJ = null;
        this.RK = null;
        this.RL = new AtomicBoolean(false);
        this.RM = new AtomicBoolean(false);
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!a && ksAdSdkDynamicApi == null) {
                    throw new AssertionError();
                }
                Object invoke = Class.forName(ksAdSdkDynamicApi.value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
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

    public static Loader get() {
        return a.RN;
    }

    public void checkAutoRevert() {
        if (this.b == null || this.RK == null || this.RM.get()) {
            return;
        }
        this.RM.set(true);
        try {
            Integer num = (Integer) com.kwad.sdk.api.b.a("getAutoRevertTime", new Object[0]);
            int intValue = num != null ? num.intValue() : -1;
            if (intValue > 0) {
                d aF = d.aF(this.b);
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler != aF) {
                    aF.Sj = defaultUncaughtExceptionHandler;
                }
                Thread.setDefaultUncaughtExceptionHandler(d.aF(this.b));
                d aF2 = d.aF(this.b);
                aF2.f = System.currentTimeMillis();
                aF2.d = intValue;
                if (aF2.a) {
                    Log.d("test.chen", "startCheck:");
                }
                d.aF(this.b).Si = this.RJ;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void checkUpdate(IKsAdSDK iKsAdSDK) {
        u.a(this.b, iKsAdSDK);
    }

    public Context getContext() {
        return this.b;
    }

    public ClassLoader getExternalClassLoader() {
        l lVar = this.RK;
        if (lVar != null) {
            return lVar.Su;
        }
        return null;
    }

    public Resources getExternalResource() {
        l lVar = this.RK;
        if (lVar != null) {
            return lVar.St;
        }
        return null;
    }

    public IKsAdSDK getKsAdSDKImpl() {
        l lVar = this.RK;
        if (lVar != null) {
            IKsAdSDK iKsAdSDK = lVar.RJ;
            iKsAdSDK.setIsExternal(true);
            return iKsAdSDK;
        }
        if (this.RJ == null) {
            this.RJ = a(this.b != null ? this.b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.RJ.setIsExternal(false);
        return this.RJ;
    }

    public ClassLoader getRealClassLoader() {
        l lVar = this.RK;
        return lVar != null ? lVar.Su : Loader.class.getClassLoader();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init(final Context context) {
        if (this.RL.get()) {
            return;
        }
        boolean z = true;
        this.RL.set(true);
        this.b = context.getApplicationContext();
        Context context2 = this.b;
        String c = g.c(context2);
        boolean q = t.q(context2, g.a);
        if (TextUtils.isEmpty(c) || !c.equals(BuildConfig.VERSION_NAME) || q) {
            String a2 = g.a(context2);
            g.a(context2, "");
            g.b(context2, "");
            t.a(context2, g.a, false);
            try {
                h.d(h.l(context2, a2));
            } catch (Exception unused) {
            }
            g.c(context2, BuildConfig.VERSION_NAME);
        }
        final String a3 = g.a(context);
        String b = g.b(context);
        if (!TextUtils.isEmpty(a3) || !TextUtils.isEmpty(b)) {
            if (!TextUtils.isEmpty(b) && g.a(b, a3)) {
                g.a(context, b);
                if (!TextUtils.isEmpty(a3)) {
                    k.b(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                File[] listFiles = h.l(context, a3).getParentFile().listFiles();
                                if (listFiles == null || listFiles.length <= 0) {
                                    return;
                                }
                                for (File file : listFiles) {
                                    if (g.a(a3, file.getName().substring(file.getName().indexOf("-") + 1))) {
                                        h.d(file);
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    });
                }
                g.b(context, "");
                a3 = b;
            }
        }
        z = false;
        if (z) {
            this.RK = l.p(this.b, g.a(context));
        }
        if (this.RK == null) {
            this.RJ = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.RK != null;
    }

    public IComponentProxy newComponentProxy(Context context, Class cls, Object obj) {
        if (!this.RL.get()) {
            KsAdSDK.init(context, SdkConfig.create(t.a(context, "sdkconfig")));
        }
        return getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    public IComponentProxy newComponentProxyNewProcess(Context context, Class cls, Object obj) {
        if (!this.RL.get()) {
            KsAdSDK.init(context, SdkConfig.create(t.a(context, "sdkconfig")));
        }
        return getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    public Object newInstance(Class cls) {
        return getKsAdSDKImpl().newInstance(cls);
    }
}
