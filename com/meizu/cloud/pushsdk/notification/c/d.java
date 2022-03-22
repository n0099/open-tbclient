package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f42195b;
    public Context a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f42196c;

    public d(Context context) {
        this.a = context;
        a();
    }

    public static d a(Context context) {
        if (f42195b == null) {
            f42195b = new d(context);
        }
        return f42195b;
    }

    private void a() {
        this.f42196c = this.a.getAssets();
    }

    public int a(String str, String str2) {
        c.h.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.a.getResources().getIdentifier(str, str2, this.a.getApplicationInfo().packageName);
    }
}
