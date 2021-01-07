package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.embedapplog.i;
import com.bytedance.sdk.openadsdk.TTCustomController;
/* loaded from: classes4.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f7906a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f7907b = false;

    static {
        f7906a = "";
        try {
            if (TextUtils.isEmpty(f7906a)) {
                f7906a = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).b("oaid", "");
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
                            boolean unused = y.f7907b = true;
                            String unused2 = y.f7906a = aVar.id;
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
        TTCustomController d;
        if (TextUtils.isEmpty(f7906a) && !f7907b && (d = com.bytedance.sdk.openadsdk.core.i.c().d()) != null && !TextUtils.isEmpty(d.getDevOaid())) {
            f7906a = d.getDevOaid();
            c();
        }
        return f7906a == null ? "" : f7906a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        if (!TextUtils.isEmpty(f7906a)) {
            com.bytedance.sdk.openadsdk.k.a.a().c(new a(f7906a), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f7908a;

        a(String str) {
            this.f7908a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f7908a)) {
                com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.p.a()).a("oaid", this.f7908a);
                u.b("OAIDHelper", "oaid=" + this.f7908a);
            }
        }
    }
}
