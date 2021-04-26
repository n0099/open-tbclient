package com.bytedance.sdk.openadsdk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.k.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Set;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.k.a.b f30225a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.k.a.c f30226b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f30228d;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f30230f;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f30233i;
    public static volatile com.bytedance.sdk.openadsdk.k.b.c j;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context k;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f30227c = u.c();

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f30229e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f30231g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f30232h = 3;

    public static Context a() {
        return k;
    }

    public static void b(boolean z) {
        f30230f = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.b c() {
        return f30225a;
    }

    public static void a(boolean z) {
        f30229e = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.c b() {
        return f30226b;
    }

    public static void a(int i2) {
        f30231g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.k.a.c cVar, Context context) {
        if (cVar != null && context != null) {
            k = context.getApplicationContext();
            if (f30226b != null) {
                return;
            }
            com.bytedance.sdk.openadsdk.k.a.b bVar = f30225a;
            if (bVar != null && bVar.f30155a.getAbsolutePath().equals(cVar.f30157a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            f30226b = cVar;
            j = com.bytedance.sdk.openadsdk.k.b.c.a(context);
            f30226b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.k.e.1
                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(String str) {
                    if (e.f30227c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(Set<String> set) {
                    e.j.a(set, 0);
                    if (e.f30227c) {
                        Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                    }
                }
            });
            f a2 = f.a();
            a2.a(cVar);
            a2.a(j);
            d c2 = d.c();
            c2.a(cVar);
            c2.a(j);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }
}
