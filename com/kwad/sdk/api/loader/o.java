package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes5.dex */
public final class o extends ContextThemeWrapper implements ResContext {
    public final ContextThemeWrapper SE;
    public Resources.Theme SF;
    public int c;

    public o(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.SE = contextThemeWrapper;
        this.c = ((Integer) Reflect.b(contextThemeWrapper).bd("getThemeResId").a).intValue();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return Wrapper.wrapContextIfNeed(super.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return Wrapper.wrapContextIfNeed(super.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return Wrapper.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public final Context getDelegatedContext() {
        return this.SE;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return Wrapper.wrapSystemService(this.SE.getSystemService(str), str, this);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.SF;
        if (theme2 == null || theme2 == theme) {
            this.SF = Wrapper.replaceTheme(theme, this.SF, this.c);
        }
        return this.SF;
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.SE.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.c = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.SE.unregisterComponentCallbacks(componentCallbacks);
    }
}
