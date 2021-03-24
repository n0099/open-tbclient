package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes6.dex */
public class n extends ContextWrapper implements ResContext {

    /* renamed from: a  reason: collision with root package name */
    public final Context f31841a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f31842b;

    /* renamed from: c  reason: collision with root package name */
    public int f31843c;

    public n(Context context) {
        super(context);
        this.f31843c = -1;
        this.f31841a = context;
        this.f31843c = ((Integer) Reflect.a(context).d("getThemeResId").a()).intValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return Wrapper.wrapContextIfNeed(super.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return Wrapper.wrapContextIfNeed(super.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : super.getClassLoader();
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public Context getDelegatedContext() {
        return this.f31841a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        boolean equals = "layout_inflater".equals(str);
        Object systemService = super.getSystemService(str);
        if (equals) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
        }
        return systemService;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (this.f31842b == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                this.f31842b = newTheme;
                int i = this.f31843c;
                if (i > 0) {
                    newTheme.applyStyle(i, true);
                }
            }
            return this.f31842b;
        }
        return theme;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f31841a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f31841a.unregisterComponentCallbacks(componentCallbacks);
    }
}
