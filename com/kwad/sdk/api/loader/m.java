package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m extends ContextThemeWrapper implements ResContext {

    /* renamed from: a  reason: collision with root package name */
    private final ContextThemeWrapper f8236a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f8237b;
    private int c;

    public m(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.f8236a = contextThemeWrapper;
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
        return this.f8236a;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : super.getResources();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            return !(layoutInflater.getContext() instanceof ResContext) ? layoutInflater.cloneInContext(this) : layoutInflater;
        }
        return super.getSystemService(str);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (this.f8237b == null) {
                this.f8237b = externalResource.newTheme();
                this.f8237b.applyStyle(this.c, true);
            }
            return this.f8237b;
        }
        return theme;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f8236a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f8236a.unregisterComponentCallbacks(componentCallbacks);
    }
}
