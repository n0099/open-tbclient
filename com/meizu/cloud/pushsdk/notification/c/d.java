package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f38240b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38241a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f38242c;

    public d(Context context) {
        this.f38241a = context;
        a();
    }

    public static d a(Context context) {
        if (f38240b == null) {
            f38240b = new d(context);
        }
        return f38240b;
    }

    private void a() {
        this.f38242c = this.f38241a.getAssets();
    }

    public int a(String str, String str2) {
        d.k.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f38241a.getResources().getIdentifier(str, str2, this.f38241a.getApplicationInfo().packageName);
    }
}
