package com.qq.e.comm.plugin.a.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.util.au;
import com.qq.e.comm.plugin.util.w;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.a.c f11589a;

    /* renamed from: b  reason: collision with root package name */
    private final c f11590b;
    private final NotificationManager c;
    private Future<Bitmap> d;
    private d e;
    private String h;
    private int i;
    private int f = -1;
    private long g = System.currentTimeMillis();
    private boolean j = false;

    public a(Context context, com.qq.e.comm.plugin.a.c cVar) {
        this.f11589a = cVar;
        this.f11590b = c.a(context);
        this.c = com.qq.e.comm.plugin.d.d.a(context);
        this.h = cVar.a("notifyTag");
        this.i = cVar.b("notifyId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f11590b != null) {
            this.f11590b.a(false).a("正在下载：" + this.f11589a.f());
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f11590b == null || this.j || this.d == null || !this.d.isDone()) {
            return;
        }
        this.j = true;
        try {
            Bitmap bitmap = this.d.get();
            if (bitmap != null) {
                this.f11590b.a(bitmap);
            }
        } catch (Throwable th) {
        }
    }

    public void a() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    a.this.d();
                    a.this.f11590b.b("玩儿命下载中").a(100, 100, true);
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.a());
                    }
                    Notification a2 = a.this.f11590b.a();
                    a.this.e();
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }

    public void a(final long j, final long j2) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    int i = j2 > 0 ? (int) ((100 * j) / j2) : 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (i - a.this.f <= 1 || currentTimeMillis - a.this.g <= 1000) {
                        return;
                    }
                    a.this.f = i;
                    a.this.g = currentTimeMillis;
                    a.this.d();
                    a.this.f11590b.a(100, a.this.f, false);
                    a.this.f11590b.b("已完成：" + au.c(j) + ",总大小：" + au.c(j2));
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.a());
                    }
                    Notification a2 = a.this.f11590b.a();
                    if (i % 10 == 0) {
                        a.this.e();
                    }
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public void a(final String str) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    a.this.f11590b.a(false).a("暂停下载：" + a.this.f11589a.f());
                    a.this.f();
                    a.this.f11590b.a(100, a.this.f, false);
                    a.this.f11590b.b(str);
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.e());
                    }
                    Notification a2 = a.this.f11590b.a();
                    a.this.e();
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }

    public void a(Future<Bitmap> future) {
        this.d = future;
    }

    public void b() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    a.this.d();
                    a.this.f11590b.a(100, 100, false);
                    a.this.f11590b.b("下载完成点击安装");
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.c());
                    }
                    Notification a2 = a.this.f11590b.a();
                    a.this.e();
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }

    public void b(final String str) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    a.this.d();
                    a.this.f11590b.a(100, 100, true);
                    a.this.f11590b.b(str);
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.b());
                    }
                    Notification a2 = a.this.f11590b.a();
                    a.this.e();
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }

    public void c() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.a.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f11590b != null) {
                    if (a.this.e != null) {
                        a.this.f11590b.a(a.this.e.d());
                    }
                    if (a.this.f11589a.p() != null) {
                        a.this.f11590b.a(a.this.f11589a.p());
                    }
                    a.this.f11590b.b("点击启动").a(a.this.f11589a.f()).a(false);
                    Notification a2 = a.this.f11590b.a();
                    a.this.e();
                    a.this.c.notify(a.this.h, a.this.i, a2);
                }
            }
        });
    }
}
