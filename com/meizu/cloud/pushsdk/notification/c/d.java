package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f60540b;
    public Context a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f60541c;

    public d(Context context) {
        this.a = context;
        a();
    }

    public static d a(Context context) {
        if (f60540b == null) {
            f60540b = new d(context);
        }
        return f60540b;
    }

    private void a() {
        this.f60541c = this.a.getAssets();
    }

    public int a(String str, String str2) {
        c.k.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.a.getResources().getIdentifier(str, str2, this.a.getApplicationInfo().packageName);
    }
}
