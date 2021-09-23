package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f75263b;

    /* renamed from: a  reason: collision with root package name */
    public Context f75264a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f75265c;

    public d(Context context) {
        this.f75264a = context;
        a();
    }

    public static d a(Context context) {
        if (f75263b == null) {
            f75263b = new d(context);
        }
        return f75263b;
    }

    private void a() {
        this.f75265c = this.f75264a.getAssets();
    }

    public int a(String str, String str2) {
        c.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f75264a.getResources().getIdentifier(str, str2, this.f75264a.getApplicationInfo().packageName);
    }
}
