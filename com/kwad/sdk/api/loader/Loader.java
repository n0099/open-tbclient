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
    public volatile Context f57549b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f57550c;

    /* renamed from: d  reason: collision with root package name */
    public j f57551d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f57552e;

    /* loaded from: classes3.dex */
    public static class a {
        public static final Loader a = new Loader();
    }

    public Loader() {
        this.f57550c = null;
        this.f57551d = null;
        this.f57552e = new AtomicBoolean(false);
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
            f.a(context, f.f57581b, b2);
            a(context, a2);
            f.a(context, f.a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.17.4")) {
            String a3 = f.a(context, f.f57581b);
            f.a(context, f.f57581b, "");
            f.a(context, f.a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.17.4");
        }
    }

    public static Loader get() {
        return a.a;
    }

    public String a(Context context) {
        return f.a(context, f.f57581b);
    }

    public String b(Context context) {
        return f.a(context, f.a);
    }

    public void checkUpdate(IKsAdSDK iKsAdSDK) {
        r.a(this.f57549b, iKsAdSDK);
    }

    public Context getContext() {
        return this.f57549b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f57551d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f57551d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f57551d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f57550c == null) {
            this.f57550c = a(this.f57549b != null ? this.f57549b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f57550c.setIsExternal(false);
        return this.f57550c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f57551d;
        return jVar != null ? jVar.b() : Loader.class.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f57552e.get()) {
            return;
        }
        this.f57552e.set(true);
        this.f57549b = context.getApplicationContext();
        d(this.f57549b);
        if (c(context)) {
            this.f57551d = j.a(this.f57549b, a(context));
        }
        if (this.f57551d == null) {
            this.f57550c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f57551d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f57552e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f57552e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
