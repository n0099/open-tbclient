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
    public static final /* synthetic */ boolean f31792a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f31793b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f31794c;

    /* renamed from: d  reason: collision with root package name */
    public j f31795d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f31796e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Loader f31797a = new Loader();
    }

    public Loader() {
        this.f31794c = null;
        this.f31795d = null;
        this.f31796e = new AtomicBoolean(false);
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!f31792a && ksAdSdkDynamicApi == null) {
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
            f.a(context, f.f31830b, b2);
            a(context, a2);
            f.a(context, f.f31829a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.8.3")) {
            String a3 = f.a(context, f.f31830b);
            f.a(context, f.f31830b, "");
            f.a(context, f.f31829a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.8.3");
        }
    }

    public static Loader get() {
        return a.f31797a;
    }

    public String a(Context context) {
        return f.a(context, f.f31830b);
    }

    public String b(Context context) {
        return f.a(context, f.f31829a);
    }

    public void checkUpdate() {
        r.a(this.f31793b);
    }

    public Context getContext() {
        return this.f31793b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f31795d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f31795d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f31795d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f31794c == null) {
            this.f31794c = a(this.f31793b != null ? this.f31793b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f31794c.setIsExternal(false);
        return this.f31794c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f31795d;
        return jVar != null ? jVar.b() : Loader.class.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f31796e.get()) {
            return;
        }
        this.f31796e.set(true);
        this.f31793b = context.getApplicationContext();
        d(this.f31793b);
        if (c(context)) {
            this.f31795d = j.a(this.f31793b, a(context));
        }
        if (this.f31795d == null) {
            this.f31794c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f31795d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f31796e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f31796e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
