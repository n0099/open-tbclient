package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f37855b;

    /* renamed from: a  reason: collision with root package name */
    public Context f37856a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f37857c;

    public d(Context context) {
        this.f37856a = context;
        a();
    }

    public static d a(Context context) {
        if (f37855b == null) {
            f37855b = new d(context);
        }
        return f37855b;
    }

    private void a() {
        this.f37857c = this.f37856a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f37856a.getResources().getIdentifier(str, str2, this.f37856a.getApplicationInfo().packageName);
    }
}
