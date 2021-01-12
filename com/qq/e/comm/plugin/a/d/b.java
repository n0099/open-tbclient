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
/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private Handler f11605a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, C1183b> f11606b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f11609a = new b();
    }

    /* renamed from: com.qq.e.comm.plugin.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1183b {

        /* renamed from: a  reason: collision with root package name */
        public int f11610a;

        /* renamed from: b  reason: collision with root package name */
        public int f11611b;
    }

    public static b a() {
        return a.f11609a;
    }

    private void a(final String str, final C1183b c1183b, final long j) {
        this.f11605a.post(new Runnable() { // from class: com.qq.e.comm.plugin.a.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(str, c1183b, j);
                } catch (Exception e) {
                }
            }
        });
    }

    private C1183b b(Context context, String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1183b c1183b = this.f11606b.get(a2);
        if (c1183b == null || c1183b.f11610a == 8) {
            c1183b = new C1183b();
            if (com.qq.e.comm.plugin.a.e.a.a(new File(ah.h(), a2 + ".apk"), str, context)) {
                c1183b.f11610a = 8;
                c1183b.f11611b = 100;
            } else {
                c1183b.f11610a = 0;
                c1183b.f11611b = 0;
            }
        }
        return c1183b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, C1183b c1183b, long j) {
        Intent intent = new Intent();
        Context appContext = GDTADManager.getInstance().getAppContext();
        String packageName = appContext.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", c1183b.f11610a);
        intent.putExtra("progress", c1183b.f11611b);
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
        C1183b b2 = b(context, str);
        return b2 != null ? c | b2.f11610a : c;
    }

    public void a(String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1183b c1183b = this.f11606b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, 0L);
        }
        if (c1183b != null) {
            c1183b.f11611b = 0;
            return;
        }
        C1183b c1183b2 = new C1183b();
        c1183b2.f11611b = 0;
        this.f11606b.put(a2, c1183b2);
    }

    public void a(String str, int i) {
        C1183b c1183b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1183b c1183b2 = this.f11606b.get(a2);
        if (c1183b2 != null) {
            c1183b2.f11610a = i;
            c1183b = c1183b2;
        } else {
            C1183b c1183b3 = new C1183b();
            c1183b3.f11610a = i;
            this.f11606b.put(a2, c1183b3);
            c1183b = c1183b3;
        }
        long longValue = this.c.get(a2) == null ? 0L : this.c.get(a2).longValue();
        a(str, c1183b.f11610a, c1183b.f11611b, longValue);
        a(str, c1183b, longValue);
    }

    public void a(String str, int i, long j) {
        C1183b c1183b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1183b c1183b2 = this.f11606b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, Long.valueOf(j));
        }
        boolean z = true;
        if (c1183b2 == null) {
            C1183b c1183b3 = new C1183b();
            c1183b3.f11611b = i;
            this.f11606b.put(a2, c1183b3);
            c1183b = c1183b3;
        } else if (c1183b2.f11611b != i) {
            c1183b2.f11611b = i;
            c1183b = c1183b2;
        } else {
            z = false;
            c1183b = c1183b2;
        }
        if (z) {
            a(str, c1183b.f11610a, c1183b.f11611b, j);
            if (c1183b.f11611b % 5 == 0) {
                a(str, c1183b, j);
            }
        }
    }

    public void b(String str) {
        a(str, 1, 100, 0L);
        C1183b c1183b = new C1183b();
        c1183b.f11610a = 1;
        c1183b.f11611b = 100;
        a(str, c1183b, 0L);
    }
}
