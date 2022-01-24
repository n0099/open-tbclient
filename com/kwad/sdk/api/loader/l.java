package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes3.dex */
public class l extends ContextThemeWrapper implements ResContext {
    public final ContextThemeWrapper a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f55470b;

    /* renamed from: c  reason: collision with root package name */
    public int f55471c;

    public l(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.a = contextThemeWrapper;
        this.f55471c = ((Integer) Reflect.a(contextThemeWrapper).d("getThemeResId").a()).intValue();
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
        return Wrapper.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public Context getDelegatedContext() {
        return this.a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return Wrapper.wrapSystemService(this.a.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e2) {
            e2.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.f55470b;
        if (theme2 == null || theme2 == theme) {
            this.f55470b = Wrapper.replaceTheme(theme, this.f55470b, this.f55471c);
        }
        return this.f55470b;
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        this.f55471c = i2;
        super.setTheme(i2);
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.a.unregisterComponentCallbacks(componentCallbacks);
    }
}
