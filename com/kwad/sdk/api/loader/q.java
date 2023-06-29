package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes10.dex */
public final class q extends ContextWrapper implements ResContext {
    public Resources.Theme SF;
    public final Context a;
    public int c;

    public q(Context context) {
        super(context);
        this.c = -1;
        this.a = context;
        this.c = ((Integer) Reflect.b(context).bd("getThemeResId").a).intValue();
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
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return Wrapper.wrapSystemService(super.getSystemService(str), str, this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
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
        this.a.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.c = i;
        super.setTheme(i);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.a.unregisterComponentCallbacks(componentCallbacks);
    }
}
