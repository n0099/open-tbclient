package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
import com.meizu.cloud.pushinternal.DebugLogger;
/* loaded from: classes8.dex */
public class d {
    public static d b;
    public Context a;
    public AssetManager c;

    public d(Context context) {
        this.a = context;
        a();
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private void a() {
        this.c = this.a.getAssets();
    }

    public int a(String str, String str2) {
        DebugLogger.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.a.getResources().getIdentifier(str, str2, this.a.getApplicationInfo().packageName);
    }
}
