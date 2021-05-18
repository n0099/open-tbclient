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
    public static volatile com.bytedance.sdk.openadsdk.k.a.b f29470a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.k.a.c f29471b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f29473d;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f29475f;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f29478i;
    public static volatile com.bytedance.sdk.openadsdk.k.b.c j;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context k;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f29472c = u.c();

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f29474e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f29476g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f29477h = 3;

    public static Context a() {
        return k;
    }

    public static void b(boolean z) {
        f29475f = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.b c() {
        return f29470a;
    }

    public static void a(boolean z) {
        f29474e = z;
    }

    public static com.bytedance.sdk.openadsdk.k.a.c b() {
        return f29471b;
    }

    public static void a(int i2) {
        f29476g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.k.a.c cVar, Context context) {
        if (cVar != null && context != null) {
            k = context.getApplicationContext();
            if (f29471b != null) {
                return;
            }
            com.bytedance.sdk.openadsdk.k.a.b bVar = f29470a;
            if (bVar != null && bVar.f29400a.getAbsolutePath().equals(cVar.f29402a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            f29471b = cVar;
            j = com.bytedance.sdk.openadsdk.k.b.c.a(context);
            f29471b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.k.e.1
                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(String str) {
                    if (e.f29472c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.k.a.c.a
                public void a(Set<String> set) {
                    e.j.a(set, 0);
                    if (e.f29472c) {
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
