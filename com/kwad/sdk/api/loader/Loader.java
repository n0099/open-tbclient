package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class Loader {
    public static final /* synthetic */ boolean a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f55410b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f55411c;

    /* renamed from: d  reason: collision with root package name */
    public j f55412d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f55413e;

    /* loaded from: classes3.dex */
    public static class a {
        public static final Loader a = new Loader();
    }

    public Loader() {
        this.f55411c = null;
        this.f55412d = null;
        this.f55413e = new AtomicBoolean(false);
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
                Object invoke = Class.forName(ksAdSdkDynamicApi.value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return iKsAdSDK;
    }

    private void a(Context context, String str) {
        g.g(context, str);
    }

    private boolean c(Context context) {
        String a2 = a(context);
        String b2 = b(context);
        if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(b2)) {
            return false;
        }
        if (!TextUtils.isEmpty(b2) && f.a(b2, a2)) {
            f.a(context, f.f55441b, b2);
            a(context, a2);
            f.a(context, f.a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.17.4")) {
            String a3 = f.a(context, f.f55441b);
            f.a(context, f.f55441b, "");
            f.a(context, f.a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.17.4");
        }
    }

    public static Loader get() {
        return a.a;
    }

    public String a(Context context) {
        return f.a(context, f.f55441b);
    }

    public String b(Context context) {
        return f.a(context, f.a);
    }

    public void checkUpdate(IKsAdSDK iKsAdSDK) {
        r.a(this.f55410b, iKsAdSDK);
    }

    public Context getContext() {
        return this.f55410b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f55412d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f55412d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f55412d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f55411c == null) {
            this.f55411c = a(this.f55410b != null ? this.f55410b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f55411c.setIsExternal(false);
        return this.f55411c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f55412d;
        return jVar != null ? jVar.b() : Loader.class.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f55413e.get()) {
            return;
        }
        this.f55413e.set(true);
        this.f55410b = context.getApplicationContext();
        d(this.f55410b);
        if (c(context)) {
            this.f55412d = j.a(this.f55410b, a(context));
        }
        if (this.f55412d == null) {
            this.f55411c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f55412d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f55413e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f55413e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
