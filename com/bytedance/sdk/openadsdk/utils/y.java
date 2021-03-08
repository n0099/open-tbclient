package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.embedapplog.i;
import com.bytedance.sdk.openadsdk.TTCustomController;
/* loaded from: classes6.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f5153a;
    private static volatile boolean b = false;

    static {
        f5153a = "";
        try {
            if (TextUtils.isEmpty(f5153a)) {
                f5153a = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).b("oaid", "");
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        try {
            com.bytedance.embedapplog.b.a(new com.bytedance.embedapplog.i() { // from class: com.bytedance.sdk.openadsdk.utils.y.1
                @Override // com.bytedance.embedapplog.i
                public void onOaidLoaded(@NonNull i.a aVar) {
                    try {
                        if (!TextUtils.isEmpty(aVar.id)) {
                            boolean unused = y.b = true;
                            String unused2 = y.f5153a = aVar.id;
                            y.c();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public static String a() {
        TTCustomController e;
        if (TextUtils.isEmpty(f5153a) && !b && (e = com.bytedance.sdk.openadsdk.core.i.d().e()) != null && !TextUtils.isEmpty(e.getDevOaid())) {
            f5153a = e.getDevOaid();
            c();
        }
        return f5153a == null ? "" : f5153a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        if (!TextUtils.isEmpty(f5153a)) {
            com.bytedance.sdk.openadsdk.j.e.a(new a(f5153a), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f5154a;

        a(String str) {
            this.f5154a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f5154a)) {
                com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).a("oaid", this.f5154a);
                u.b("OAIDHelper", "oaid=" + this.f5154a);
            }
        }
    }
}
