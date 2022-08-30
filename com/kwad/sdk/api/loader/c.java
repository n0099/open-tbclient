package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
/* loaded from: classes7.dex */
public final class c {

    /* loaded from: classes7.dex */
    public static class a extends Application {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.a.getApplicationInfo();
        }
    }
}
