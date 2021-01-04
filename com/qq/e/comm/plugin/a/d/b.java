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
    private Handler f11904a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, C1159b> f11905b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static b f11908a = new b();
    }

    /* renamed from: com.qq.e.comm.plugin.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1159b {

        /* renamed from: a  reason: collision with root package name */
        public int f11909a;

        /* renamed from: b  reason: collision with root package name */
        public int f11910b;
    }

    public static b a() {
        return a.f11908a;
    }

    private void a(final String str, final C1159b c1159b, final long j) {
        this.f11904a.post(new Runnable() { // from class: com.qq.e.comm.plugin.a.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b(str, c1159b, j);
                } catch (Exception e) {
                }
            }
        });
    }

    private C1159b b(Context context, String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1159b c1159b = this.f11905b.get(a2);
        if (c1159b == null || c1159b.f11909a == 8) {
            c1159b = new C1159b();
            if (com.qq.e.comm.plugin.a.e.a.a(new File(ah.h(), a2 + ".apk"), str, context)) {
                c1159b.f11909a = 8;
                c1159b.f11910b = 100;
            } else {
                c1159b.f11909a = 0;
                c1159b.f11910b = 0;
            }
        }
        return c1159b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, C1159b c1159b, long j) {
        Intent intent = new Intent();
        Context appContext = GDTADManager.getInstance().getAppContext();
        String packageName = appContext.getPackageName();
        intent.setAction(packageName + ".gdtdownload");
        intent.putExtra("package", str);
        intent.putExtra("status", c1159b.f11909a);
        intent.putExtra("progress", c1159b.f11910b);
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
        C1159b b2 = b(context, str);
        return b2 != null ? c | b2.f11909a : c;
    }

    public void a(String str) {
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1159b c1159b = this.f11905b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, 0L);
        }
        if (c1159b != null) {
            c1159b.f11910b = 0;
            return;
        }
        C1159b c1159b2 = new C1159b();
        c1159b2.f11910b = 0;
        this.f11905b.put(a2, c1159b2);
    }

    public void a(String str, int i) {
        C1159b c1159b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1159b c1159b2 = this.f11905b.get(a2);
        if (c1159b2 != null) {
            c1159b2.f11909a = i;
            c1159b = c1159b2;
        } else {
            C1159b c1159b3 = new C1159b();
            c1159b3.f11909a = i;
            this.f11905b.put(a2, c1159b3);
            c1159b = c1159b3;
        }
        long longValue = this.c.get(a2) == null ? 0L : this.c.get(a2).longValue();
        a(str, c1159b.f11909a, c1159b.f11910b, longValue);
        a(str, c1159b, longValue);
    }

    public void a(String str, int i, long j) {
        C1159b c1159b;
        String a2 = com.qq.e.comm.plugin.a.e.a.a(str);
        C1159b c1159b2 = this.f11905b.get(a2);
        if (this.c.get(a2) == null) {
            this.c.put(a2, Long.valueOf(j));
        }
        boolean z = true;
        if (c1159b2 == null) {
            C1159b c1159b3 = new C1159b();
            c1159b3.f11910b = i;
            this.f11905b.put(a2, c1159b3);
            c1159b = c1159b3;
        } else if (c1159b2.f11910b != i) {
            c1159b2.f11910b = i;
            c1159b = c1159b2;
        } else {
            z = false;
            c1159b = c1159b2;
        }
        if (z) {
            a(str, c1159b.f11909a, c1159b.f11910b, j);
            if (c1159b.f11910b % 5 == 0) {
                a(str, c1159b, j);
            }
        }
    }

    public void b(String str) {
        a(str, 1, 100, 0L);
        C1159b c1159b = new C1159b();
        c1159b.f11909a = 1;
        c1159b.f11910b = 100;
        a(str, c1159b, 0L);
    }
}
