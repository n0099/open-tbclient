package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f34973b;

    /* renamed from: a  reason: collision with root package name */
    public Context f34974a;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager f34975c;

    public d(Context context) {
        this.f34974a = context;
        a();
    }

    public static d a(Context context) {
        if (f34973b == null) {
            f34973b = new d(context);
        }
        return f34973b;
    }

    private void a() {
        this.f34975c = this.f34974a.getAssets();
    }

    public int a(String str, String str2) {
        d.j.a.a.a.d("ResourceReader", "Get resource type " + str2 + " " + str);
        return this.f34974a.getResources().getIdentifier(str, str2, this.f34974a.getApplicationInfo().packageName);
    }
}
