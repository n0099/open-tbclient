package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f67656b;

    /* renamed from: a  reason: collision with root package name */
    public Context f67657a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f67658c;

    public d(Context context) {
        this.f67657a = context;
        a();
    }

    public static d a(Context context) {
        if (f67656b == null) {
            f67656b = new d(context);
        }
        return f67656b;
    }

    private void a() {
        this.f67658c = this.f67657a.getAssets();
    }

    public int a(String str, String str2) {
        b.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f67657a.getResources().getIdentifier(str, str2, this.f67657a.getApplicationInfo().packageName);
    }
}
