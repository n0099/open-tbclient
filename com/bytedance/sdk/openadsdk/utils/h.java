package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, a> f31034a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static IListenerManager f31035b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f31034a.remove(str);
    }

    public static void a(String str, String[] strArr, a aVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(str, strArr);
    }

    public static IListenerManager b() {
        if (f31035b == null) {
            f31035b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(4));
        }
        return f31035b;
    }

    public static void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.c().execute(new com.bytedance.sdk.openadsdk.l.g("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.utils.h.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.b("MultiProcess", "handleYes-1，key=" + str);
                        h.b().broadcastPermissionListener(str, null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        a b2 = b(str);
        if (b2 == null) {
            return;
        }
        b2.a();
    }

    public static void a(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.c().execute(new com.bytedance.sdk.openadsdk.l.g("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.b("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                        h.b().broadcastPermissionListener(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        a b2 = b(str);
        if (b2 == null) {
            return;
        }
        b2.a(str2);
    }

    public static void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("addListener") { // from class: com.bytedance.sdk.openadsdk.utils.h.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.f("MultiProcess", "getListenerManager().registerPermissionListener...");
                        h.b().registerPermissionListener(str, new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(aVar));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        u.f("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            f31034a.put(str, aVar);
        }
    }
}
