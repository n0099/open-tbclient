package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f11635b;

    /* renamed from: a  reason: collision with root package name */
    private Context f11636a;
    private AssetManager c;

    private d(Context context) {
        this.f11636a = context;
        a();
    }

    public static d a(Context context) {
        if (f11635b == null) {
            f11635b = new d(context);
        }
        return f11635b;
    }

    private void a() {
        this.c = this.f11636a.getAssets();
    }

    public int a(String str, String str2) {
        com.meizu.cloud.a.a.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f11636a.getResources().getIdentifier(str, str2, this.f11636a.getApplicationInfo().packageName);
    }
}
