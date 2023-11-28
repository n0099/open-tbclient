package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class ServiceProvider {
    public static List<Throwable> JC;
    public static boolean aMA;
    @SuppressLint({"StaticFieldLeak"})
    public static Context aMx;
    @SuppressLint({"StaticFieldLeak"})
    public static Context aMy;
    public static SdkConfig aMz;
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;

    public static void Jm() {
        aMA = true;
    }

    @NonNull
    @Deprecated
    public static Context Jn() {
        return mContext;
    }

    @NonNull
    public static SdkConfig Jo() {
        return aMz;
    }

    @NonNull
    public static Context getContext() {
        if (aMA) {
            return Jn();
        }
        if (aMy == null) {
            aMy = l.wrapContextIfNeed(mContext);
        }
        return aMy;
    }

    /* loaded from: classes10.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;
        
        public final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }
    }

    public static void a(SdkConfig sdkConfig) {
        aMz = sdkConfig;
    }

    public static void b(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            c(th);
        }
    }

    public static void bC(Context context) {
        aMx = context;
        mContext = l.du(context);
    }

    public static void c(Throwable th) {
        if (JC == null) {
            JC = new CopyOnWriteArrayList();
        }
        JC.add(th);
    }

    public static void d(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = JC;
        if (list == null) {
            return;
        }
        for (Throwable th : list) {
            aVar.accept(th);
        }
        JC.clear();
        JC = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }
}
