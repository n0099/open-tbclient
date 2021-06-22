package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import d.b.b.c;
/* loaded from: classes6.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f30423a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f30424b = false;

    static {
        try {
            if (TextUtils.isEmpty(f30423a)) {
                f30423a = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).b("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (TextUtils.isEmpty(f30423a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", f30423a);
    }

    public static void a(Context context) {
        try {
            d.b.b.a.t(new d.b.b.c() { // from class: com.bytedance.sdk.openadsdk.utils.y.1
                @Override // d.b.b.c
                public void onOaidLoaded(@NonNull c.a aVar) {
                    try {
                        if (TextUtils.isEmpty(aVar.f68819a)) {
                            return;
                        }
                        boolean unused = y.f30424b = true;
                        String unused2 = y.f30423a = aVar.f68819a;
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
        if (TextUtils.isEmpty(f30423a)) {
            f30423a = com.bytedance.sdk.openadsdk.core.i.a("sdk_app_log_oaid", 86400000L);
        }
        if (TextUtils.isEmpty(f30423a) && !f30424b && (e2 = com.bytedance.sdk.openadsdk.core.i.d().e()) != null && !TextUtils.isEmpty(e2.getDevOaid())) {
            f30423a = e2.getDevOaid();
            c();
        }
        return f30423a == null ? "" : f30423a;
    }
}
