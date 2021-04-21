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
    public static final /* synthetic */ boolean f32137a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f32138b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f32139c;

    /* renamed from: d  reason: collision with root package name */
    public j f32140d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f32141e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Loader f32142a = new Loader();
    }

    public Loader() {
        this.f32139c = null;
        this.f32140d = null;
        this.f32141e = new AtomicBoolean(false);
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!f32137a && ksAdSdkDynamicApi == null) {
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
            f.a(context, f.f32174b, b2);
            a(context, a2);
            f.a(context, f.f32173a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.9")) {
            String a3 = f.a(context, f.f32174b);
            f.a(context, f.f32174b, "");
            f.a(context, f.f32173a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.9");
        }
    }

    public static Loader get() {
        return a.f32142a;
    }

    public String a(Context context) {
        return f.a(context, f.f32174b);
    }

    public String b(Context context) {
        return f.a(context, f.f32173a);
    }

    public void checkUpdate() {
        r.a(this.f32138b);
    }

    public Context getContext() {
        return this.f32138b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f32140d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f32140d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f32140d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f32139c == null) {
            this.f32139c = a(this.f32138b != null ? this.f32138b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f32139c.setIsExternal(false);
        return this.f32139c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f32140d;
        return jVar != null ? jVar.b() : this.f32138b.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f32141e.get()) {
            return;
        }
        this.f32141e.set(true);
        this.f32138b = context.getApplicationContext();
        d(this.f32138b);
        if (c(context)) {
            this.f32140d = j.a(this.f32138b, a(context));
        }
        if (this.f32140d == null) {
            this.f32139c = a(this.f32138b.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f32140d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f32141e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f32141e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
