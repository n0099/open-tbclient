package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f38652b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38653a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f38654c;

    public d(Context context) {
        this.f38653a = context;
        a();
    }

    public static d a(Context context) {
        if (f38652b == null) {
            f38652b = new d(context);
        }
        return f38652b;
    }

    private void a() {
        this.f38654c = this.f38653a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f38653a.getResources().getIdentifier(str, str2, this.f38653a.getApplicationInfo().packageName);
    }
}
