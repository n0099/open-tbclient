package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f74564b;

    /* renamed from: a  reason: collision with root package name */
    public Context f74565a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f74566c;

    public d(Context context) {
        this.f74565a = context;
        a();
    }

    public static d a(Context context) {
        if (f74564b == null) {
            f74564b = new d(context);
        }
        return f74564b;
    }

    private void a() {
        this.f74566c = this.f74565a.getAssets();
    }

    public int a(String str, String str2) {
        c.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f74565a.getResources().getIdentifier(str, str2, this.f74565a.getApplicationInfo().packageName);
    }
}
