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
    public static final /* synthetic */ boolean f32395a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f32396b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f32397c;

    /* renamed from: d  reason: collision with root package name */
    public j f32398d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f32399e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Loader f32400a = new Loader();
    }

    public Loader() {
        this.f32397c = null;
        this.f32398d = null;
        this.f32399e = new AtomicBoolean(false);
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!f32395a && ksAdSdkDynamicApi == null) {
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
            f.a(context, f.f32433b, b2);
            a(context, a2);
            f.a(context, f.f32432a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.9")) {
            String a3 = f.a(context, f.f32433b);
            f.a(context, f.f32433b, "");
            f.a(context, f.f32432a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.9");
        }
    }

    public static Loader get() {
        return a.f32400a;
    }

    public String a(Context context) {
        return f.a(context, f.f32433b);
    }

    public String b(Context context) {
        return f.a(context, f.f32432a);
    }

    public void checkUpdate() {
        r.a(this.f32396b);
    }

    public Context getContext() {
        return this.f32396b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f32398d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f32398d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f32398d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f32397c == null) {
            this.f32397c = a(this.f32396b != null ? this.f32396b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f32397c.setIsExternal(false);
        return this.f32397c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f32398d;
        return jVar != null ? jVar.b() : this.f32396b.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f32399e.get()) {
            return;
        }
        this.f32399e.set(true);
        this.f32396b = context.getApplicationContext();
        d(this.f32396b);
        if (c(context)) {
            this.f32398d = j.a(this.f32396b, a(context));
        }
        if (this.f32398d == null) {
            this.f32397c = a(this.f32396b.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f32398d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f32399e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f32399e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
