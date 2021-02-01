package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.d;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
/* loaded from: classes15.dex */
class o implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11635a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11636b = new i();
    private final com.qq.e.comm.plugin.a.c.b c = new com.qq.e.comm.plugin.a.c.a();
    private d.a d;
    private final c e;
    private final Intent f;
    private final Lock g;
    private Future<Bitmap> h;
    private final com.qq.e.comm.plugin.a.b.a i;
    private com.qq.e.comm.plugin.a.d.a j;

    public o(Context context, c cVar, Intent intent, Lock lock) {
        this.f11635a = context;
        this.e = cVar;
        this.f = intent;
        this.i = new com.qq.e.comm.plugin.a.b.a(context, this.e);
        this.i.a(new com.qq.e.comm.plugin.a.b.b(this.f, cVar, context));
        this.g = lock;
    }

    private int a(int i) {
        switch (i) {
            case 5:
                return 1024;
            case 6:
                return 2048;
            default:
                return 0;
        }
    }

    private int a(File file, c cVar) {
        int a2 = com.qq.e.comm.plugin.a.d.b.a().a(this.f11635a, cVar.h());
        GDTLogger.d("check apk status:" + a2);
        if (file.exists()) {
            if (com.qq.e.comm.plugin.a.e.a.a(file, cVar.h(), this.f11635a)) {
                GDTLogger.d("apk exist and valid");
                com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), 8);
            } else {
                file.delete();
                d(cVar);
            }
        } else if (com.qq.e.comm.plugin.a.d.d.c(a2)) {
            d(cVar);
        }
        int a3 = com.qq.e.comm.plugin.a.d.b.a().a(this.f11635a, cVar.h());
        GDTLogger.d("after check status is:" + a3);
        if (com.qq.e.comm.plugin.a.d.d.a(a3)) {
            return 7;
        }
        if (com.qq.e.comm.plugin.a.d.d.b(a3)) {
            return 8;
        }
        if (com.qq.e.comm.plugin.a.d.d.c(a3)) {
            return 9;
        }
        if (a3 == 0) {
            GDTLogger.d("reset download task progress and total");
            cVar.a("progress", 0);
            com.qq.e.comm.plugin.a.d.b.a().a(cVar.h());
            b(3);
        }
        GDTLogger.d("set download task to downloading");
        com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), 4);
        cVar.a(4);
        t.a(this.f11635a).b(cVar);
        return 0;
    }

    private com.qq.e.comm.plugin.j.e a(final c cVar, File file) {
        final String h = cVar.h();
        final com.qq.e.comm.plugin.j.b.f fVar = new com.qq.e.comm.plugin.j.b.f(cVar.g(), file, this.f11636b.a(), new b.a().a(com.qq.e.comm.plugin.util.s.f12591a).a());
        this.j = new com.qq.e.comm.plugin.a.d.a() { // from class: com.qq.e.comm.plugin.a.o.1
            @Override // com.qq.e.comm.plugin.a.d.a
            public void a(String str, int i, int i2, long j) {
                if (TextUtils.isEmpty(h) || !h.equals(str)) {
                    return;
                }
                if (i == 32) {
                    fVar.d();
                } else if (i == 64) {
                    fVar.e();
                }
            }
        };
        com.qq.e.comm.plugin.a.d.b.a().a(h, this.j);
        com.qq.e.comm.plugin.j.a.a aVar = new com.qq.e.comm.plugin.j.a.a(fVar, new com.qq.e.comm.plugin.j.a.b(cVar.e()));
        aVar.a(new com.qq.e.comm.plugin.j.f() { // from class: com.qq.e.comm.plugin.a.o.2
            @Override // com.qq.e.comm.plugin.j.f
            public void a(long j, long j2) {
                o.this.b(j, j2);
                int i = j2 <= 0 ? 0 : (int) ((100 * j) / j2);
                com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), i, j2);
                cVar.a("progress", i);
                o.this.a(j, j2);
            }
        });
        return aVar;
    }

    private void a() {
        if (this.h == null || !this.h.isDone()) {
            return;
        }
        try {
            this.e.a(this.h.get());
        } catch (Exception e) {
        }
    }

    private void a(int i, String str) {
        a(i, str, (File) null);
    }

    private void a(int i, String str, File file) {
        if (this.d != null) {
            this.d.a(i, str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (this.d != null) {
            this.d.a(j, j2);
        }
    }

    private void a(c cVar) {
        try {
            this.g.lockInterruptibly();
            GDTLogger.d("download start");
            b(cVar);
            GDTLogger.d("download stop");
            this.g.unlock();
        } catch (Throwable th) {
            GDTLogger.d("download stop");
            this.g.unlock();
        }
    }

    private void a(c cVar, int i) {
        int i2 = i == 0 ? 8 : ((com.qq.e.comm.plugin.j.d.e(i) && GDTADManager.getInstance().getSM().getInteger("download_pause", 0) == 1) || com.qq.e.comm.plugin.j.d.c(i)) ? 32 : com.qq.e.comm.plugin.j.d.d(i) ? 64 : 16;
        com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), i2);
        cVar.a(i2);
        t.a(this.f11635a).b(cVar);
    }

    private Pair<Integer, File> b() {
        File h = ah.h();
        return h == null ? new Pair<>(5, null) : (h.exists() || h.mkdirs()) ? new Pair<>(0, h) : new Pair<>(6, null);
    }

    private void b(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2) {
        c().a(j, j2);
    }

    private void b(c cVar) {
        int i;
        b(1);
        int c = c(cVar);
        if (c != 0) {
            a(c, "");
            return;
        }
        Pair<Integer, File> b2 = b();
        int intValue = ((Integer) b2.first).intValue();
        if (intValue != 0) {
            d(a(intValue));
            a(intValue, "");
            return;
        }
        b(2);
        File a2 = com.qq.e.comm.plugin.a.e.a.a((File) b2.second, cVar);
        int a3 = a(a2, cVar);
        GDTLogger.d("check apk file result:" + a3);
        if (c(a3)) {
            f(cVar);
        }
        if (a3 != 0) {
            a(a3, "", a2);
            return;
        }
        b(4);
        d();
        com.qq.e.comm.plugin.j.e a4 = a(cVar, a2);
        a4.c();
        int a5 = a4.a();
        GDTLogger.d("download code:" + a5 + ",download message:" + a4.b());
        if (a5 == 0) {
            b(6);
            if (com.qq.e.comm.plugin.a.e.a.a(a2, cVar.h(), this.f11635a)) {
                a();
                i = 0;
            } else {
                if (a2 != null && a2.exists()) {
                    a2.delete();
                }
                a5 = 8;
                i = 12;
            }
        } else {
            i = com.qq.e.comm.plugin.j.d.a(a5) ? 11 : 10;
        }
        b(7);
        if (i != 0) {
            cVar.e(String.format("[%d]%s", Integer.valueOf(a5), a4.b()));
        }
        d(a5);
        a(cVar, a5);
        a(i, "", a2);
    }

    private int c(c cVar) {
        if (cVar.q()) {
            if (this.c.a(cVar)) {
                e(cVar);
                return 2;
            } else if (!this.c.b(cVar)) {
                return 3;
            }
        } else if (cVar.r()) {
            return 4;
        }
        return 0;
    }

    private com.qq.e.comm.plugin.a.b.a c() {
        if (this.h == null) {
            this.h = com.qq.e.comm.plugin.util.s.f12591a.submit(new h(this.e.i()));
            this.i.a(this.h);
        }
        return this.i;
    }

    private boolean c(int i) {
        return (i == 2 || i == 3 || i == 9 || i == 7 || i == 8) ? false : true;
    }

    private void d() {
        c().a();
    }

    private void d(int i) {
        if (i == 0) {
            c().b();
        } else if (com.qq.e.comm.plugin.j.d.d(i)) {
        } else {
            if (com.qq.e.comm.plugin.j.d.c(i) || com.qq.e.comm.plugin.j.d.e(i)) {
                c().a(e(i));
            } else {
                c().b(e(i));
            }
        }
    }

    private void d(c cVar) {
        cVar.a("progress", 0);
        com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), 0, 0L);
        com.qq.e.comm.plugin.a.d.b.a().a(cVar.h(), 0);
        GDTLogger.d("reset progress");
    }

    private String e(int i) {
        return com.qq.e.comm.plugin.j.d.e(i) ? "连接到运营商网络，暂停下载，点击这里继续！" : com.qq.e.comm.plugin.j.d.c(i) ? "已暂停" : com.qq.e.comm.plugin.j.d.a(i) ? "看起来网络出问题了，快去检查网络正常后点这里重试吧！" : com.qq.e.comm.plugin.j.d.b(i) ? "存储卡不可用或者存储空间不足，快去检查存储卡状态后点这里重试吧！" : "真遗憾，下载失败了，稍后点这里重试吧";
    }

    private void e(c cVar) {
        try {
            t.a(this.f11635a).d(cVar);
        } catch (SQLException e) {
        }
    }

    private void f(c cVar) {
        if (cVar.q()) {
            return;
        }
        try {
            t a2 = t.a(this.f11635a);
            c a3 = a2.a(cVar.h());
            if (a3 != null) {
                cVar.b(a3.m());
                a2.b(cVar);
            } else if (cVar.r()) {
                a2.c(cVar);
            } else {
                a2.a(cVar);
            }
        } catch (SQLException e) {
        }
    }

    @Override // com.qq.e.comm.plugin.a.d
    public void a(d.a aVar) {
        this.d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.e);
    }
}
