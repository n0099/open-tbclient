package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f67655b;

    /* renamed from: a  reason: collision with root package name */
    public Context f67656a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f67657c;

    public d(Context context) {
        this.f67656a = context;
        a();
    }

    public static d a(Context context) {
        if (f67655b == null) {
            f67655b = new d(context);
        }
        return f67655b;
    }

    private void a() {
        this.f67657c = this.f67656a.getAssets();
    }

    public int a(String str, String str2) {
        b.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f67656a.getResources().getIdentifier(str, str2, this.f67656a.getApplicationInfo().packageName);
    }
}
