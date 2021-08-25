package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes10.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f74764b;

    /* renamed from: a  reason: collision with root package name */
    public Context f74765a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f74766c;

    public d(Context context) {
        this.f74765a = context;
        a();
    }

    public static d a(Context context) {
        if (f74764b == null) {
            f74764b = new d(context);
        }
        return f74764b;
    }

    private void a() {
        this.f74766c = this.f74765a.getAssets();
    }

    public int a(String str, String str2) {
        c.l.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f74765a.getResources().getIdentifier(str, str2, this.f74765a.getApplicationInfo().packageName);
    }
}
