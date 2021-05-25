package com.bytedance.sdk.openadsdk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.k.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Set;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.k.a.b f29399a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.k.a.c f29400b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f29402d;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f29404f;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f29407i;
    public static volatile com.bytedance.sdk.openadsdk.k.b.c j;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context k;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f29401c = u.c();

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f29403e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f29405g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f29406h = 3;

    public static Context a() {
        return k;
    }

    public static void b(boolean z) {
        f29404f = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.b c() {
        return f29399a;
    }

    public static void a(boolean z) {
        f29403e = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.c b() {
        return f29400b;
    }

    public static void a(int i2) {
        f29405g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.k.a.c cVar, Context context) {
        if (cVar != null && context != null) {
            k = context.getApplicationContext();
            if (f29400b != null) {
                return;
            }
            com.bytedance.sdk.openadsdk.k.a.b bVar = f29399a;
            if (bVar != null && bVar.f29329a.getAbsolutePath().equals(cVar.f29331a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            f29400b = cVar;
            j = com.bytedance.sdk.openadsdk.k.b.c.a(context);
            f29400b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.k.e.1
                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(String str) {
                    if (e.f29401c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(Set<String> set) {
                    e.j.a(set, 0);
                    if (e.f29401c) {
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
