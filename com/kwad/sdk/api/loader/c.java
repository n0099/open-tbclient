package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public static class a extends Application {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ApplicationInfo getApplicationInfo() {
            return this.a.getApplicationInfo();
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
