package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f68568b;

    /* renamed from: a  reason: collision with root package name */
    public Context f68569a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f68570c;

    public d(Context context) {
        this.f68569a = context;
        a();
    }

    public static d a(Context context) {
        if (f68568b == null) {
            f68568b = new d(context);
        }
        return f68568b;
    }

    private void a() {
        this.f68570c = this.f68569a.getAssets();
    }

    public int a(String str, String str2) {
        b.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f68569a.getResources().getIdentifier(str, str2, this.f68569a.getApplicationInfo().packageName);
    }
}
