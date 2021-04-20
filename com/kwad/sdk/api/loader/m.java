package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes6.dex */
public class m extends ContextThemeWrapper implements ResContext {

    /* renamed from: a  reason: collision with root package name */
    public final ContextThemeWrapper f32128a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f32129b;

    /* renamed from: c  reason: collision with root package name */
    public int f32130c;

    public m(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.f32128a = contextThemeWrapper;
        this.f32130c = ((Integer) Reflect.a(contextThemeWrapper).d("getThemeResId").a()).intValue();
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
        return this.f32128a;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : super.getResources();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        boolean equals = "layout_inflater".equals(str);
        Object systemService = super.getSystemService(str);
        if (equals) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
        }
        return systemService;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (this.f32129b == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                this.f32129b = newTheme;
                newTheme.applyStyle(this.f32130c, true);
            }
            return this.f32129b;
        }
        return theme;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f32128a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f32128a.unregisterComponentCallbacks(componentCallbacks);
    }
}
