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
    private final Map<String, C1187b> f11608b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f11611a = new b();
    }

    /* renamed from: com.qq.e.comm.plugin.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1187b {

        /* renamed from: a  reason: collision with root package name */
        public int f11612a;

        /* renamed from: b  reason: collision with root package name */
        public int f11613b;
    }

    public static b a() {
        return a.f11611a;
    }

    private void a(final String str, final C1187b c1187b, final long j) {
        this.f11607a.post(new Runnable() { // from class: com.qq.e.comm.plugin.a.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(str, c1187b, j);
                } catch (Exception e) {
                }
            }
        });
    }

    private C1187b b(Context context, String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1187b c1187b = this.f11608b.get(a2);
        if (c1187b == null || c1187b.f11612a == 8) {
            c1187b = new C1187b();
            if (com.qq.e.comm.plugin.a.e.a.a(new File(ah.h(), a2 + ".apk"), str, context)) {
                c1187b.f11612a = 8;
                c1187b.f11613b = 100;
            } else {
                c1187b.f11612a = 0;
                c1187b.f11613b = 0;
            }
        }
        return c1187b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, C1187b c1187b, long j) {
        Intent intent = new Intent();
        Context appContext = GDTADManager.getInstance().getAppContext();
        String packageName = appContext.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", c1187b.f11612a);
        intent.putExtra("progress", c1187b.f11613b);
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
        C1187b b2 = b(context, str);
        return b2 != null ? c | b2.f11612a : c;
    }

    public void a(String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1187b c1187b = this.f11608b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, 0L);
        }
        if (c1187b != null) {
            c1187b.f11613b = 0;
            return;
        }
        C1187b c1187b2 = new C1187b();
        c1187b2.f11613b = 0;
        this.f11608b.put(a2, c1187b2);
    }

    public void a(String str, int i) {
        C1187b c1187b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1187b c1187b2 = this.f11608b.get(a2);
        if (c1187b2 != null) {
            c1187b2.f11612a = i;
            c1187b = c1187b2;
        } else {
            C1187b c1187b3 = new C1187b();
            c1187b3.f11612a = i;
            this.f11608b.put(a2, c1187b3);
            c1187b = c1187b3;
        }
        long longValue = this.c.get(a2) == null ? 0L : this.c.get(a2).longValue();
        a(str, c1187b.f11612a, c1187b.f11613b, longValue);
        a(str, c1187b, longValue);
    }

    public void a(String str, int i, long j) {
        C1187b c1187b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1187b c1187b2 = this.f11608b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, Long.valueOf(j));
        }
        boolean z = true;
        if (c1187b2 == null) {
            C1187b c1187b3 = new C1187b();
            c1187b3.f11613b = i;
            this.f11608b.put(a2, c1187b3);
            c1187b = c1187b3;
        } else if (c1187b2.f11613b != i) {
            c1187b2.f11613b = i;
            c1187b = c1187b2;
        } else {
            z = false;
            c1187b = c1187b2;
        }
        if (z) {
            a(str, c1187b.f11612a, c1187b.f11613b, j);
            if (c1187b.f11613b % 5 == 0) {
                a(str, c1187b, j);
            }
        }
    }

    public void b(String str) {
        a(str, 1, 100, 0L);
        C1187b c1187b = new C1187b();
        c1187b.f11612a = 1;
        c1187b.f11613b = 100;
        a(str, c1187b, 0L);
    }
}
