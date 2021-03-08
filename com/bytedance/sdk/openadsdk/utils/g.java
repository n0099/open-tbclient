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
    private static final Map<String, a> f5135a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(String str, String str2, String str3, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a(str, aVar);
            TTDelegateActivity.a(str, str2, str3);
        }
    }

    public static void a(String str, String str2, a aVar, String str3, String str4, boolean z) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a(str, aVar);
            TTDelegateActivity.a(str, str2, str3, str4, z);
        }
    }

    public static void a(String str, String str2, a aVar, String str3, boolean z) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a(str, aVar);
            TTDelegateActivity.a(str, str2, str3, z);
        }
    }

    public static void a(String str) {
        TTDelegateActivity.a(str);
    }

    public static void a(final com.bytedance.sdk.openadsdk.core.d.l lVar, final Context context, final String str) {
        if (lVar != null && context != null && !TextUtils.isEmpty(str)) {
            a(lVar.ag(), lVar.Q(), new a() { // from class: com.bytedance.sdk.openadsdk.utils.g.1
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
            }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar), lVar.T() == 4);
        }
    }

    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar, Context context, String str) {
        if (lVar != null && context != null && lVar.T() == 4) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, str);
            if (a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).g(false);
            }
            a2.g();
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a(str, aVar);
            TTDelegateActivity.a(str, str2, str3, str4, str5);
        }
    }

    public static void b(String str) {
        a(str, 1);
    }

    public static void c(String str) {
        a(str, 2);
    }

    public static void d(String str) {
        a(str, 3);
    }

    public static void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.j.e.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            g.b().registerDialogListener(str, new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(aVar));
                        } catch (Throwable th) {
                        }
                    }
                }, 5);
            } else {
                f5135a.put(str, aVar);
            }
        }
    }

    public static a e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f5135a.remove(str);
    }

    private static void a(final String str, final int i) {
        if (!TextUtils.isEmpty(str)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.j.e.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            g.b().broadcastDialogListener(str, i);
                        } catch (Throwable th) {
                        }
                    }
                }, 5);
                return;
            }
            a e = e(str);
            if (e != null) {
                switch (i) {
                    case 1:
                        e.a();
                        return;
                    case 2:
                        e.b();
                        return;
                    case 3:
                        e.c();
                        return;
                    default:
                        e.c();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = com.bytedance.sdk.openadsdk.multipro.aidl.a.c.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(2));
        }
        return b;
    }
}
