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
/* loaded from: classes15.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private Handler f11607a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, C1189b> f11608b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f11611a = new b();
    }

    /* renamed from: com.qq.e.comm.plugin.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1189b {

        /* renamed from: a  reason: collision with root package name */
        public int f11612a;

        /* renamed from: b  reason: collision with root package name */
        public int f11613b;
    }

    public static b a() {
        return a.f11611a;
    }

    private void a(final String str, final C1189b c1189b, final long j) {
        this.f11607a.post(new Runnable() { // from class: com.qq.e.comm.plugin.a.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(str, c1189b, j);
                } catch (Exception e) {
                }
            }
        });
    }

    private C1189b b(Context context, String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1189b c1189b = this.f11608b.get(a2);
        if (c1189b == null || c1189b.f11612a == 8) {
            c1189b = new C1189b();
            if (com.qq.e.comm.plugin.a.e.a.a(new File(ah.h(), a2 + ".apk"), str, context)) {
                c1189b.f11612a = 8;
                c1189b.f11613b = 100;
            } else {
                c1189b.f11612a = 0;
                c1189b.f11613b = 0;
            }
        }
        return c1189b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, C1189b c1189b, long j) {
        Intent intent = new Intent();
        Context appContext = GDTADManager.getInstance().getAppContext();
        String packageName = appContext.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", c1189b.f11612a);
        intent.putExtra("progress", c1189b.f11613b);
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
        C1189b b2 = b(context, str);
        return b2 != null ? c | b2.f11612a : c;
    }

    public void a(String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1189b c1189b = this.f11608b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, 0L);
        }
        if (c1189b != null) {
            c1189b.f11613b = 0;
            return;
        }
        C1189b c1189b2 = new C1189b();
        c1189b2.f11613b = 0;
        this.f11608b.put(a2, c1189b2);
    }

    public void a(String str, int i) {
        C1189b c1189b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1189b c1189b2 = this.f11608b.get(a2);
        if (c1189b2 != null) {
            c1189b2.f11612a = i;
            c1189b = c1189b2;
        } else {
            C1189b c1189b3 = new C1189b();
            c1189b3.f11612a = i;
            this.f11608b.put(a2, c1189b3);
            c1189b = c1189b3;
        }
        long longValue = this.c.get(a2) == null ? 0L : this.c.get(a2).longValue();
        a(str, c1189b.f11612a, c1189b.f11613b, longValue);
        a(str, c1189b, longValue);
    }

    public void a(String str, int i, long j) {
        C1189b c1189b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1189b c1189b2 = this.f11608b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, Long.valueOf(j));
        }
        boolean z = true;
        if (c1189b2 == null) {
            C1189b c1189b3 = new C1189b();
            c1189b3.f11613b = i;
            this.f11608b.put(a2, c1189b3);
            c1189b = c1189b3;
        } else if (c1189b2.f11613b != i) {
            c1189b2.f11613b = i;
            c1189b = c1189b2;
        } else {
            z = false;
            c1189b = c1189b2;
        }
        if (z) {
            a(str, c1189b.f11612a, c1189b.f11613b, j);
            if (c1189b.f11613b % 5 == 0) {
                a(str, c1189b, j);
            }
        }
    }

    public void b(String str) {
        a(str, 1, 100, 0L);
        C1189b c1189b = new C1189b();
        c1189b.f11612a = 1;
        c1189b.f11613b = 100;
        a(str, c1189b, 0L);
    }
}
