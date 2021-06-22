package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f38750b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38751a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f38752c;

    public d(Context context) {
        this.f38751a = context;
        a();
    }

    public static d a(Context context) {
        if (f38750b == null) {
            f38750b = new d(context);
        }
        return f38750b;
    }

    private void a() {
        this.f38752c = this.f38751a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f38751a.getResources().getIdentifier(str, str2, this.f38751a.getApplicationInfo().packageName);
    }
}
