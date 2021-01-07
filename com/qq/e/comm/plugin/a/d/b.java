package com.qq.e.comm.plugin.a.d;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private Handler f11905a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, C1200b> f11906b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f11909a = new b();
    }

    /* renamed from: com.qq.e.comm.plugin.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1200b {

        /* renamed from: a  reason: collision with root package name */
        public int f11910a;

        /* renamed from: b  reason: collision with root package name */
        public int f11911b;
    }

    public static b a() {
        return a.f11909a;
    }

    private void a(final String str, final C1200b c1200b, final long j) {
        this.f11905a.post(new Runnable() { // from class: com.qq.e.comm.plugin.a.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(str, c1200b, j);
                } catch (Exception e) {
                }
            }
        });
    }

    private C1200b b(Context context, String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1200b c1200b = this.f11906b.get(a2);
        if (c1200b == null || c1200b.f11910a == 8) {
            c1200b = new C1200b();
            if (com.qq.e.comm.plugin.a.e.a.a(new File(ah.h(), a2 + ".apk"), str, context)) {
                c1200b.f11910a = 8;
                c1200b.f11911b = 100;
            } else {
                c1200b.f11910a = 0;
                c1200b.f11911b = 0;
            }
        }
        return c1200b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, C1200b c1200b, long j) {
        Intent intent = new Intent();
        Context appContext = GDTADManager.getInstance().getAppContext();
        String packageName = appContext.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", c1200b.f11910a);
        intent.putExtra("progress", c1200b.f11911b);
        intent.putExtra("totalSize", j);
        intent.setPackage(packageName);
        GDTLogger.d("Before broadCast::" + intent);
        appContext.sendBroadcast(intent);
    }

    private int c(Context context, String str) {
        return com.qq.e.comm.plugin.a.e.a.a(context, str) ? 1 : 0;
    }

    public int a(Context context, String str) {
        if (StringUtil.isEmpty(str)) {
            return 0;
        }
        int c = c(context, str);
        if (d.a(c)) {
            return 1;
        }
        C1200b b2 = b(context, str);
        return b2 != null ? c | b2.f11910a : c;
    }

    public void a(String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1200b c1200b = this.f11906b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, 0L);
        }
        if (c1200b != null) {
            c1200b.f11911b = 0;
            return;
        }
        C1200b c1200b2 = new C1200b();
        c1200b2.f11911b = 0;
        this.f11906b.put(a2, c1200b2);
    }

    public void a(String str, int i) {
        C1200b c1200b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1200b c1200b2 = this.f11906b.get(a2);
        if (c1200b2 != null) {
            c1200b2.f11910a = i;
            c1200b = c1200b2;
        } else {
            C1200b c1200b3 = new C1200b();
            c1200b3.f11910a = i;
            this.f11906b.put(a2, c1200b3);
            c1200b = c1200b3;
        }
        long longValue = this.c.get(a2) == null ? 0L : this.c.get(a2).longValue();
        a(str, c1200b.f11910a, c1200b.f11911b, longValue);
        a(str, c1200b, longValue);
    }

    public void a(String str, int i, long j) {
        C1200b c1200b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1200b c1200b2 = this.f11906b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, Long.valueOf(j));
        }
        boolean z = true;
        if (c1200b2 == null) {
            C1200b c1200b3 = new C1200b();
            c1200b3.f11911b = i;
            this.f11906b.put(a2, c1200b3);
            c1200b = c1200b3;
        } else if (c1200b2.f11911b != i) {
            c1200b2.f11911b = i;
            c1200b = c1200b2;
        } else {
            z = false;
            c1200b = c1200b2;
        }
        if (z) {
            a(str, c1200b.f11910a, c1200b.f11911b, j);
            if (c1200b.f11911b % 5 == 0) {
                a(str, c1200b, j);
            }
        }
    }

    public void b(String str) {
        a(str, 1, 100, 0L);
        C1200b c1200b = new C1200b();
        c1200b.f11910a = 1;
        c1200b.f11911b = 100;
        a(str, c1200b, 0L);
    }
}
