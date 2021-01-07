package com.bytedance.sdk.openadsdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static volatile com.bytedance.sdk.openadsdk.j.a.b f7556a;

    /* renamed from: b  reason: collision with root package name */
    static volatile com.bytedance.sdk.openadsdk.j.a.c f7557b;
    public static volatile boolean d;
    static volatile boolean f;
    public static volatile Integer i;
    private static volatile com.bytedance.sdk.openadsdk.j.b.c j;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context k;
    public static final boolean c = u.c();
    static volatile boolean e = true;
    static volatile int g = 0;
    public static volatile int h = 3;

    public static Context a() {
        return k;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static void b(boolean z) {
        f = z;
    }

    public static void a(int i2) {
        g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.j.a.c cVar, Context context) {
        if (cVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        k = context.getApplicationContext();
        if (f7557b == null) {
            com.bytedance.sdk.openadsdk.j.a.b bVar = f7556a;
            if (bVar != null && bVar.f7520a.getAbsolutePath().equals(cVar.f7522a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            f7557b = cVar;
            j = com.bytedance.sdk.openadsdk.j.b.c.a(context);
            f7557b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.j.e.1
                @Override // com.bytedance.sdk.openadsdk.j.a.c.a
                public void a(String str) {
                    if (e.c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.j.a.c.a
                public void a(Set<String> set) {
                    e.j.a(set, 0);
                    if (e.c) {
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
        }
    }

    public static com.bytedance.sdk.openadsdk.j.a.c b() {
        return f7557b;
    }

    public static com.bytedance.sdk.openadsdk.j.a.b c() {
        return f7556a;
    }
}
