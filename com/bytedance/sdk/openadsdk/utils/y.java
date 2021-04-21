package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import d.c.b.c;
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f30147a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f30148b = false;

    static {
        try {
            if (TextUtils.isEmpty(f30147a)) {
                f30147a = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).b("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (TextUtils.isEmpty(f30147a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", f30147a);
    }

    public static void a(Context context) {
        try {
            d.c.b.a.t(new d.c.b.c() { // from class: com.bytedance.sdk.openadsdk.utils.y.1
                @Override // d.c.b.c
                public void onOaidLoaded(@NonNull c.a aVar) {
                    try {
                        if (TextUtils.isEmpty(aVar.f65900a)) {
                            return;
                        }
                        boolean unused = y.f30148b = true;
                        String unused2 = y.f30147a = aVar.f65900a;
                        y.c();
                    } catch (Throwable unused3) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        TTCustomController e2;
        if (TextUtils.isEmpty(f30147a)) {
            f30147a = com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", 86400000L);
        }
        if (TextUtils.isEmpty(f30147a) && !f30148b && (e2 = com.bytedance.sdk.openadsdk.core.i.d().e()) != null && !TextUtils.isEmpty(e2.getDevOaid())) {
            f30147a = e2.getDevOaid();
            c();
        }
        return f30147a == null ? "" : f30147a;
    }
}
