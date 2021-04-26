package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import d.b.b.c;
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f31064a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f31065b = false;

    static {
        try {
            if (TextUtils.isEmpty(f31064a)) {
                f31064a = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).b("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (TextUtils.isEmpty(f31064a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", f31064a);
    }

    public static void a(Context context) {
        try {
            d.b.b.a.t(new d.b.b.c() { // from class: com.bytedance.sdk.openadsdk.utils.y.1
                @Override // d.b.b.c
                public void onOaidLoaded(@NonNull c.a aVar) {
                    try {
                        if (TextUtils.isEmpty(aVar.f64255a)) {
                            return;
                        }
                        boolean unused = y.f31065b = true;
                        String unused2 = y.f31064a = aVar.f64255a;
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
        if (TextUtils.isEmpty(f31064a)) {
            f31064a = com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", 86400000L);
        }
        if (TextUtils.isEmpty(f31064a) && !f31065b && (e2 = com.bytedance.sdk.openadsdk.core.i.d().e()) != null && !TextUtils.isEmpty(e2.getDevOaid())) {
            f31064a = e2.getDevOaid();
            c();
        }
        return f31064a == null ? "" : f31064a;
    }
}
