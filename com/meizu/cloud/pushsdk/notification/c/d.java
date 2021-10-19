package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f75298b;

    /* renamed from: a  reason: collision with root package name */
    public Context f75299a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f75300c;

    public d(Context context) {
        this.f75299a = context;
        a();
    }

    public static d a(Context context) {
        if (f75298b == null) {
            f75298b = new d(context);
        }
        return f75298b;
    }

    private void a() {
        this.f75300c = this.f75299a.getAssets();
    }

    public int a(String str, String str2) {
        c.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f75299a.getResources().getIdentifier(str, str2, this.f75299a.getApplicationInfo().packageName);
    }
}
