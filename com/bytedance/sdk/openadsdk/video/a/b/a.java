package com.bytedance.sdk.openadsdk.video.a.b;

import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.video.d.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.video.a.a> f31079a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.video.a.c.a> f31080b = new ConcurrentHashMap<>();

    public static void a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (Build.VERSION.SDK_INT < 23 || f31080b.contains(aVar.b())) {
            return;
        }
        new com.bytedance.sdk.openadsdk.video.a.c.a(context, aVar, aVar.c()).b();
        u.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(aVar.c()), aVar.b());
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            com.bytedance.sdk.openadsdk.video.a.c.a remove = f31080b.remove(aVar.b());
            if (remove != null) {
                remove.a(true);
            }
            u.b("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(aVar.c()), aVar.b());
        }
    }

    public static void a(Context context, int i2) {
        c.a(context, i2);
    }
}
