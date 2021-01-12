package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f11336b;

    /* renamed from: a  reason: collision with root package name */
    private Context f11337a;
    private AssetManager c;

    private d(Context context) {
        this.f11337a = context;
        a();
    }

    public static d a(Context context) {
        if (f11336b == null) {
            f11336b = new d(context);
        }
        return f11336b;
    }

    private void a() {
        this.c = this.f11337a.getAssets();
    }

    public int a(String str, String str2) {
        com.meizu.cloud.a.a.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f11337a.getResources().getIdentifier(str, str2, this.f11337a.getApplicationInfo().packageName);
    }
}
