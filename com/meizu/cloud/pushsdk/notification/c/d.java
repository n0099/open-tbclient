package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f37856b;

    /* renamed from: a  reason: collision with root package name */
    public Context f37857a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f37858c;

    public d(Context context) {
        this.f37857a = context;
        a();
    }

    public static d a(Context context) {
        if (f37856b == null) {
            f37856b = new d(context);
        }
        return f37856b;
    }

    private void a() {
        this.f37858c = this.f37857a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f37857a.getResources().getIdentifier(str, str2, this.f37857a.getApplicationInfo().packageName);
    }
}
