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

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8181a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f8182b;
    private IKsAdSDK c;
    private j d;
    private AtomicBoolean e;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Loader f8183a = new Loader();
    }

    static {
        f8181a = !Loader.class.desiredAssertionStatus();
    }

    private Loader() {
        this.c = null;
        this.d = null;
        this.e = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                KsAdSdkDynamicApi ksAdSdkDynamicApi = (KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class);
                if (!f8181a && ksAdSdkDynamicApi == null) {
                    throw new AssertionError();
                }
                Object invoke = Class.forName(ksAdSdkDynamicApi.value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e) {
                throw new RuntimeException(e);
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
        if (TextUtils.isEmpty(b2) || !f.a(b2, a2)) {
            b2 = a2;
        } else {
            f.a(context, f.f8202b, b2);
            a(context, a2);
            f.a(context, f.f8201a, "");
        }
        return !TextUtils.isEmpty(b2);
    }

    private void d(Context context) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2) || !a2.equals("3.3.9")) {
            String a3 = f.a(context, f.f8202b);
            f.a(context, f.f8202b, "");
            f.a(context, f.f8201a, "");
            g.b(g.c(context, a3));
            f.b(context, "3.3.9");
        }
    }

    public static Loader get() {
        return a.f8183a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Context context) {
        return f.a(context, f.f8202b);
    }

    String b(Context context) {
        return f.a(context, f.f8201a);
    }

    public void checkUpdate() {
        r.a(this.f8182b);
    }

    public Context getContext() {
        return this.f8182b;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        if (this.d != null) {
            return this.d.b();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        if (this.d != null) {
            return this.d.a();
        }
        return null;
    }

    @MainThread
    public IKsAdSDK getKsAdSDKImpl() {
        if (this.d != null) {
            IKsAdSDK c = this.d.c();
            c.setIsExternal(true);
            return c;
        }
        if (this.c == null) {
            this.c = a(this.f8182b != null ? this.f8182b.getClassLoader() : getClass().getClassLoader());
        }
        this.c.setIsExternal(false);
        return this.c;
    }

    public ClassLoader getRealClassLoader() {
        return this.d != null ? this.d.b() : this.f8182b.getClassLoader();
    }

    @MainThread
    public void init(Context context) {
        if (this.e.get()) {
            return;
        }
        this.e.set(true);
        this.f8182b = context.getApplicationContext();
        d(this.f8182b);
        if (c(context)) {
            this.d = j.a(this.f8182b, a(context));
        }
        if (this.d == null) {
            this.c = a(this.f8182b.getClassLoader());
        }
    }

    public boolean isExternalLoaded() {
        return this.d != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!this.e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxyNewProcess(Context context, Class<?> cls, Object obj) {
        if (!this.e.get()) {
            KsAdSDK.init(context, SdkConfig.create(q.a(context, "sdkconfig")));
        }
        return (T) getKsAdSDKImpl().newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        return (T) getKsAdSDKImpl().newInstance(cls);
    }
}
