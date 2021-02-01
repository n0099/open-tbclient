package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f11338b;

    /* renamed from: a  reason: collision with root package name */
    private Context f11339a;
    private AssetManager c;

    private d(Context context) {
        this.f11339a = context;
        a();
    }

    public static d a(Context context) {
        if (f11338b == null) {
            f11338b = new d(context);
        }
        return f11338b;
    }

    private void a() {
        this.c = this.f11339a.getAssets();
    }

    public int a(String str, String str2) {
        com.meizu.cloud.a.a.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f11339a.getResources().getIdentifier(str, str2, this.f11339a.getApplicationInfo().packageName);
    }
}
