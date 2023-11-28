package com.kwad.sdk.m;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class e {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final AtomicBoolean JB;
    public h aRA;
    public boolean aRB;
    public ClassLoader aRC;
    public Resources aRy;
    public Resources aRz;

    /* loaded from: classes10.dex */
    public static class a {
        public static final e aRD = new e((byte) 0);
    }

    public e() {
        this.JB = new AtomicBoolean(false);
    }

    public static e Mt() {
        return a.aRD;
    }

    public static boolean yA() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yA();
    }

    public static boolean yB() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yB();
    }

    public final boolean KY() {
        return this.JB.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aRC;
    }

    public final Resources getResources() {
        return this.aRA;
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    private boolean Mu() {
        Context Jn;
        Field[] declaredFields;
        Object a2;
        Field[] declaredFields2;
        try {
            Jn = ServiceProvider.Jn();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!l.dt(Jn)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a2 = s.a(field, invoke)) != null) {
                for (Field field2 : a2.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(a2);
                        Resources resources2 = Jn.getResources();
                        h hVar = new h(resources, resources2);
                        s.a(field2, a2, hVar);
                        this.aRy = resources2;
                        this.aRz = resources;
                        this.aRA = hVar;
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final void init() {
        if (this.JB.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal()) {
                if (yA() && Mu()) {
                    this.aRC = getClass().getClassLoader();
                    i.cg(yB());
                    com.kwad.sdk.core.e.c.d("KSDY/KSPlugin", toString());
                    this.aRB = true;
                } else {
                    this.aRB = false;
                }
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.JB.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aRy + ", mResResources=" + this.aRz + ", mPluginResources=" + this.aRA + ", mEnable=" + this.aRB + '}';
    }
}
