package com.ss.android.downloadlib.e;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class b {

    /* loaded from: classes8.dex */
    public interface a {
        Object b();
    }

    public static Object a(a aVar) {
        return a(true, null, aVar);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static Object a(boolean z, String str, a aVar) {
        try {
            return aVar.b();
        } catch (Throwable th) {
            if (!(th instanceof com.ss.android.downloadlib.e.a)) {
                c.a().a(z, th, str);
                if (!TextUtils.isEmpty(str)) {
                    return null;
                }
                throw th;
            }
            throw th;
        }
    }

    public static void a(final Runnable runnable) {
        a(new a() { // from class: com.ss.android.downloadlib.e.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Void b() {
                runnable.run();
                return null;
            }
        });
    }
}
