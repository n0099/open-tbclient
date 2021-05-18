package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f35044b;

    /* renamed from: a  reason: collision with root package name */
    public Context f35045a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f35046c;

    public d(Context context) {
        this.f35045a = context;
        a();
    }

    public static d a(Context context) {
        if (f35044b == null) {
            f35044b = new d(context);
        }
        return f35044b;
    }

    private void a() {
        this.f35046c = this.f35045a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f35045a.getResources().getIdentifier(str, str2, this.f35045a.getApplicationInfo().packageName);
    }
}
