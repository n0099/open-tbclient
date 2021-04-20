package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f38145b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38146a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f38147c;

    public d(Context context) {
        this.f38146a = context;
        a();
    }

    public static d a(Context context) {
        if (f38145b == null) {
            f38145b = new d(context);
        }
        return f38145b;
    }

    private void a() {
        this.f38147c = this.f38146a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f38146a.getResources().getIdentifier(str, str2, this.f38146a.getApplicationInfo().packageName);
    }
}
