package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f37716b;

    /* renamed from: a  reason: collision with root package name */
    public Context f37717a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f37718c;

    public d(Context context) {
        this.f37717a = context;
        a();
    }

    public static d a(Context context) {
        if (f37716b == null) {
            f37716b = new d(context);
        }
        return f37716b;
    }

    private void a() {
        this.f37718c = this.f37717a.getAssets();
    }

    public int a(String str, String str2) {
        d.h.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f37717a.getResources().getIdentifier(str, str2, this.f37717a.getApplicationInfo().packageName);
    }
}
