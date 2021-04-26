package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f35799b;

    /* renamed from: a  reason: collision with root package name */
    public Context f35800a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f35801c;

    public d(Context context) {
        this.f35800a = context;
        a();
    }

    public static d a(Context context) {
        if (f35799b == null) {
            f35799b = new d(context);
        }
        return f35799b;
    }

    private void a() {
        this.f35801c = this.f35800a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f35800a.getResources().getIdentifier(str, str2, this.f35800a.getApplicationInfo().packageName);
    }
}
