package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    private static class a extends Application {

        /* renamed from: a  reason: collision with root package name */
        private final Context f8195a;

        a(Context context) {
            this.f8195a = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.f8195a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ApplicationInfo getApplicationInfo() {
            return this.f8195a.getApplicationInfo();
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? !applicationContext.getClassLoader().equals(context.getClassLoader()) ? new a(context) : context.getApplicationContext() : context;
    }
}
