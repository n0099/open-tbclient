package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes6.dex */
public class l extends ContextThemeWrapper implements ResContext {

    /* renamed from: a  reason: collision with root package name */
    public final ContextThemeWrapper f32479a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f32480b;

    /* renamed from: c  reason: collision with root package name */
    public int f32481c;

    public l(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.f32479a = contextThemeWrapper;
        this.f32481c = ((Integer) Reflect.a(contextThemeWrapper).d("getThemeResId").a()).intValue();
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
        return this.f32479a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            LayoutInflater layoutInflater = (LayoutInflater) this.f32479a.getSystemService(str);
            return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
        }
        return this.f32479a.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (this.f32480b == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                this.f32480b = newTheme;
                newTheme.applyStyle(this.f32481c, true);
            }
            return this.f32480b;
        }
        return theme;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f32479a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f32479a.unregisterComponentCallbacks(componentCallbacks);
    }
}
