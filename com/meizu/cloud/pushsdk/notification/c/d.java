package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f58808b;
    public Context a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f58809c;

    public d(Context context) {
        this.a = context;
        a();
    }

    public static d a(Context context) {
        if (f58808b == null) {
            f58808b = new d(context);
        }
        return f58808b;
    }

    private void a() {
        this.f58809c = this.a.getAssets();
    }

    public int a(String str, String str2) {
        c.k.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.a.getResources().getIdentifier(str, str2, this.a.getApplicationInfo().packageName);
    }
}
