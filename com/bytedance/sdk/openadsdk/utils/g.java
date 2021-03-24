package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, a> f30414a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static IListenerManager f30415b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar, Context context, String str) {
        if (lVar == null || context == null || lVar.Z() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, str);
        if (a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).g(false);
        }
        a2.g();
    }

    public static void c(String str) {
        a(str, 3);
    }

    public static a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f30414a.remove(str);
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3);
    }

    public static void a(Context context, String str, String str2, a aVar, String str3, String str4, boolean z) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, str4, z);
    }

    public static void b(String str) {
        a(str, 2);
    }

    public static IListenerManager b() {
        if (f30415b == null) {
            f30415b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(2));
        }
        return f30415b;
    }

    public static void a(Context context, String str, String str2, a aVar, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, z);
    }

    public static void a(Context context, String str) {
        TTDelegateActivity.a(context, str);
    }

    public static void a(final com.bytedance.sdk.openadsdk.core.d.l lVar, final Context context, final String str) {
        if (lVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(context, lVar.am(), lVar.W(), new a() { // from class: com.bytedance.sdk.openadsdk.utils.g.1
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                g.b(com.bytedance.sdk.openadsdk.core.d.l.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
            }
        }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar), lVar.Z() == 4);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, str4, str5);
    }

    public static void a(String str) {
        a(str, 1);
    }

    public static void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.utils.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g.b().registerDialogListener(str, new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(aVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            f30414a.put(str, aVar);
        }
    }

    public static void a(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("doHandler") { // from class: com.bytedance.sdk.openadsdk.utils.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g.b().broadcastDialogListener(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        a d2 = d(str);
        if (d2 == null) {
            return;
        }
        if (i == 1) {
            d2.a();
        } else if (i == 2) {
            d2.b();
        } else if (i != 3) {
            d2.c();
        } else {
            d2.c();
        }
    }
}
