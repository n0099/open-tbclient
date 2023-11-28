package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class Loader {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;
    public final AtomicBoolean JB;
    public IKsAdSDK ame;
    public k amf;

    /* loaded from: classes10.dex */
    public static class a {
        public static final Loader amg = new Loader((byte) 0);
    }

    public Loader() {
        this.amf = null;
        this.JB = new AtomicBoolean(false);
    }

    public static Loader get() {
        return a.amg;
    }

    public static void zm() {
        try {
            int ze = com.kwad.sdk.api.c.ze();
            if (ze > 0) {
                d.ax(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                Thread.setDefaultUncaughtExceptionHandler(d.ax(mContext));
                d.ax(mContext).bP(ze);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        k kVar = this.amf;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        k kVar = this.amf;
        if (kVar != null) {
            return kVar.zj();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        k kVar = this.amf;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return Loader.class.getClassLoader();
    }

    public boolean isExternalLoaded() {
        if (this.amf != null) {
            return true;
        }
        return false;
    }

    public void rest() {
        this.JB.set(false);
        mContext = null;
        this.ame = null;
        this.amf = null;
    }

    public /* synthetic */ Loader(byte b) {
        this();
    }

    public static void checkInitSDK(Context context) {
        if (!KsAdSDK.sHasInit.get()) {
            if (context == null) {
                context = KSLifecycleObserver.getInstance().getApplication();
            }
            KsAdSDK.init(context, SdkConfig.create(t.getString(context, "sdkconfig")));
        }
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.ame.newInstance(cls);
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    iKsAdSDK = (IKsAdSDK) invoke;
                } else {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return iKsAdSDK;
    }

    private boolean aC(Context context) {
        String ay = g.ay(context);
        String az = g.az(context);
        if (TextUtils.isEmpty(ay) && TextUtils.isEmpty(az)) {
            return false;
        }
        if (!TextUtils.isEmpty(az) && g.G(az, ay)) {
            g.m(context, az);
            w(context, ay);
            g.n(context, "");
            ay = az;
        }
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return true;
    }

    public static void aD(Context context) {
        String aA = g.aA(context);
        boolean b = t.b(context, g.alK, false);
        if (TextUtils.isEmpty(aA) || !aA.equals(BuildConfig.VERSION_NAME) || b) {
            String ay = g.ay(context);
            g.m(context, "");
            g.n(context, "");
            t.a(context, g.alK, false);
            h.j(h.r(context, ay));
            g.o(context, BuildConfig.VERSION_NAME);
        }
    }

    public static void w(Context context, String str) {
        h.v(context, str);
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.JB.get()) {
            return this.ame;
        }
        mContext = context.getApplicationContext();
        aD(context);
        if (aC(context)) {
            this.amf = k.a(context, classLoader, g.ay(context));
        }
        k kVar = this.amf;
        if (kVar == null) {
            IKsAdSDK a2 = a(Loader.class.getClassLoader());
            this.ame = a2;
            a2.setIsExternal(false);
        } else {
            IKsAdSDK zk = kVar.zk();
            this.ame = zk;
            zk.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.ame);
        if (this.amf != null) {
            zm();
        }
        this.JB.set(true);
        return this.ame;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.ame.newComponentProxy(cls, obj);
    }
}
