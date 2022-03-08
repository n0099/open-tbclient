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
/* loaded from: classes7.dex */
public class Loader {
    public static final /* synthetic */ boolean a = !Loader.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f53927b;

    /* renamed from: c  reason: collision with root package name */
    public IKsAdSDK f53928c;

    /* renamed from: d  reason: collision with root package name */
    public j f53929d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f53930e;

    /* loaded from: classes7.dex */
    public static class a {
        public static final Loader a = new Loader();
    }

    public Loader() {
        this.f53928c = null;
        this.f53929d = null;
        this.f53930e = new AtomicBoolean(false);
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
            f.a(context, f.f53958b, b2);
            a(context, a2);
            f.a(context, f.a, "");
            a2 = b2;
        }
        return !TextUtils.isEmpty(a2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.17.4")) {
            String a3 = f.a(context, f.f53958b);
            f.a(context, f.f53958b, "");
            f.a(context, f.a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.17.4");
        }
    }

    public static Loader get() {
        return a.a;
    }

    public String a(Context context) {
        return f.a(context, f.f53958b);
    }

    public String b(Context context) {
        return f.a(context, f.a);
    }

    public void checkUpdate(IKsAdSDK iKsAdSDK) {
        r.a(this.f53927b, iKsAdSDK);
    }

    public Context getContext() {
        return this.f53927b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        j jVar = this.f53929d;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        j jVar = this.f53929d;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        j jVar = this.f53929d;
        if (jVar != null) {
            IKsAdSDK c2 = jVar.c();
            c2.setIsExternal(true);
            return c2;
        }
        if (this.f53928c == null) {
            this.f53928c = a(this.f53927b != null ? this.f53927b.getClassLoader() : Loader.class.getClassLoader());
        }
        this.f53928c.setIsExternal(false);
        return this.f53928c;
    }

    public ClassLoader getRealClassLoader() {
        j jVar = this.f53929d;
        return jVar != null ? jVar.b() : Loader.class.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.f53930e.get()) {
            return;
        }
        this.f53930e.set(true);
        this.f53927b = context.getApplicationContext();
        d(this.f53927b);
        if (c(context)) {
            this.f53929d = j.a(this.f53927b, a(context));
        }
        if (this.f53929d == null) {
            this.f53928c = a(Loader.class.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.f53929d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.f53930e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.f53930e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
