package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f37527b;

    /* renamed from: a  reason: collision with root package name */
    public Context f37528a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f37529c;

    public d(Context context) {
        this.f37528a = context;
        a();
    }

    public static d a(Context context) {
        if (f37527b == null) {
            f37527b = new d(context);
        }
        return f37527b;
    }

    private void a() {
        this.f37529c = this.f37528a.getAssets();
    }

    public int a(String str, String str2) {
        d.h.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f37528a.getResources().getIdentifier(str, str2, this.f37528a.getApplicationInfo().packageName);
    }
}
