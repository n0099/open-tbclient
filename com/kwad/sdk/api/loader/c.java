package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes6.dex */
public class c {

    /* loaded from: classes6.dex */
    public static class a extends Application {

        /* renamed from: a  reason: collision with root package name */
        public final Context f31822a;

        public a(Context context) {
            this.f31822a = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.f31822a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ApplicationInfo getApplicationInfo() {
            return this.f31822a.getApplicationInfo();
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : !applicationContext.getClassLoader().equals(context.getClassLoader()) ? new a(context) : context.getApplicationContext();
    }
}
