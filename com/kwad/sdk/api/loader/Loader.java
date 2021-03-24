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
/* loaded from: classes6.dex */
public class Loader {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f31752a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f31753b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f31754c;

    /* renamed from: d  reason: collision with root package name */
    public j f31755d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f31756e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Loader f31757a = new Loader();
    }

    public Loader() {
        this.f31754c = null;
        this.f31755d = null;
        this.f31756e = new AtomicBoolean(false);
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!f31752a && ksAdSdkDynamicApi == null) {
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
            f.a(context, f.f31789b, b2);
            a(context, a2);
            f.a(context, f.f31788a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.9")) {
            String a3 = f.a(context, f.f31789b);
            f.a(context, f.f31789b, "");
            f.a(context, f.f31788a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.9");
        }
    }

    public static Loader get() {
        return a.f31757a;
    }

    public String a(Context context) {
        return f.a(context, f.f31789b);
    }

    public String b(Context context) {
        return f.a(context, f.f31788a);
    }

    public void checkUpdate() {
        r.a(this.f31753b);
    }

    public Context getContext() {
        return this.f31753b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f31755d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f31755d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f31755d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f31754c == null) {
            this.f31754c = a(this.f31753b != null ? this.f31753b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f31754c.setIsExternal(false);
        return this.f31754c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f31755d;
        return jVar != null ? jVar.b() : this.f31753b.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f31756e.get()) {
            return;
        }
        this.f31756e.set(true);
        this.f31753b = context.getApplicationContext();
        d(this.f31753b);
        if (c(context)) {
            this.f31755d = j.a(this.f31753b, a(context));
        }
        if (this.f31755d == null) {
            this.f31754c = a(this.f31753b.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f31755d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f31756e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f31756e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
