package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.api.core.ResContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class l extends ContextThemeWrapper implements ResContext {

    /* renamed from: a  reason: collision with root package name */
    private final ContextThemeWrapper f8234a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f8235b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.f8234a = contextThemeWrapper;
        this.c = ((Integer) Reflect.a(contextThemeWrapper).d("getThemeResId").a()).intValue();
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
        return this.f8234a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            LayoutInflater layoutInflater = (LayoutInflater) this.f8234a.getSystemService(str);
            return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
        }
        return this.f8234a.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (this.f8235b == null) {
                this.f8235b = externalResource.newTheme();
                this.f8235b.applyStyle(this.c, true);
            }
            return this.f8235b;
        }
        return theme;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f8234a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f8234a.unregisterComponentCallbacks(componentCallbacks);
    }
}
