package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes6.dex */
public class c {

    /* loaded from: classes6.dex */
    public static class a extends Application {

        /* renamed from: a  reason: collision with root package name */
        public final Context f31782a;

        public a(Context context) {
            this.f31782a = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.f31782a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ApplicationInfo getApplicationInfo() {
            return this.f31782a.getApplicationInfo();
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
