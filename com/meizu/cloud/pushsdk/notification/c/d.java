package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f74944b;

    /* renamed from: a  reason: collision with root package name */
    public Context f74945a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f74946c;

    public d(Context context) {
        this.f74945a = context;
        a();
    }

    public static d a(Context context) {
        if (f74944b == null) {
            f74944b = new d(context);
        }
        return f74944b;
    }

    private void a() {
        this.f74946c = this.f74945a.getAssets();
    }

    public int a(String str, String str2) {
        c.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f74945a.getResources().getIdentifier(str, str2, this.f74945a.getApplicationInfo().packageName);
    }
}
