package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f40513b;

    /* renamed from: a  reason: collision with root package name */
    public Context f40514a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f40515c;

    public d(Context context) {
        this.f40514a = context;
        a();
    }

    public static d a(Context context) {
        if (f40513b == null) {
            f40513b = new d(context);
        }
        return f40513b;
    }

    private void a() {
        this.f40515c = this.f40514a.getAssets();
    }

    public int a(String str, String str2) {
        d.h.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f40514a.getResources().getIdentifier(str, str2, this.f40514a.getApplicationInfo().packageName);
    }
}
