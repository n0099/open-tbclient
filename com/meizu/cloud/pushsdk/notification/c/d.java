package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes4.dex */
public class d {
    private static d b;

    /* renamed from: a  reason: collision with root package name */
    private Context f7442a;
    private AssetManager c;

    private d(Context context) {
        this.f7442a = context;
        a();
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private void a() {
        this.c = this.f7442a.getAssets();
    }

    public int a(String str, String str2) {
        com.meizu.cloud.a.a.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f7442a.getResources().getIdentifier(str, str2, this.f7442a.getApplicationInfo().packageName);
    }
}
