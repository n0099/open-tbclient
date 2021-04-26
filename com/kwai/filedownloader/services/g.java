package com.kwai.filedownloader.services;

import android.text.TextUtils;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.x;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements x {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f35221a;

    /* renamed from: b  reason: collision with root package name */
    public final h f35222b;

    public g() {
        com.kwai.filedownloader.download.b a2 = com.kwai.filedownloader.download.b.a();
        this.f35221a = a2.c();
        this.f35222b = new h(a2.d());
    }

    @Override // com.kwai.filedownloader.x
    public int a(String str, int i2) {
        return this.f35222b.a(str, i2);
    }

    public void a() {
        List<Integer> b2 = this.f35222b.b();
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(b2.size()));
        }
        for (Integer num : b2) {
            b(num.intValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0180 A[Catch: all -> 0x01cb, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0031, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x006f, B:23:0x0075, B:25:0x0079, B:29:0x008a, B:31:0x0093, B:33:0x009c, B:35:0x00a0, B:40:0x00b3, B:43:0x00bc, B:45:0x00c5, B:47:0x00d4, B:49:0x00d8, B:51:0x00e9, B:55:0x00f7, B:57:0x00fe, B:59:0x0105, B:61:0x010b, B:63:0x0112, B:65:0x0118, B:67:0x011e, B:69:0x0138, B:70:0x013c, B:72:0x0142, B:81:0x0180, B:82:0x0185, B:73:0x0151, B:75:0x015b, B:77:0x0161, B:78:0x0166, B:44:0x00c1, B:30:0x008f), top: B:88:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        com.kwai.filedownloader.d.c cVar;
        List<com.kwai.filedownloader.d.a> list;
        boolean z4 = false;
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        int a2 = com.kwai.filedownloader.f.f.a(str, str2, z);
        com.kwai.filedownloader.d.c b2 = this.f35221a.b(a2);
        if (z || b2 != null) {
            cVar = b2;
            list = null;
        } else {
            int a3 = com.kwai.filedownloader.f.f.a(str, com.kwai.filedownloader.f.f.h(str2), true);
            com.kwai.filedownloader.d.c b3 = this.f35221a.b(a3);
            if (b3 == null || !str2.equals(b3.d())) {
                list = null;
            } else {
                if (com.kwai.filedownloader.f.d.f35118a) {
                    com.kwai.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(a2), Integer.valueOf(a3));
                }
                list = this.f35221a.c(a3);
            }
            cVar = b3;
        }
        if (com.kwai.filedownloader.f.c.a(a2, cVar, (x) this, true)) {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(a2));
            }
            return;
        }
        String d2 = cVar != null ? cVar.d() : com.kwai.filedownloader.f.f.a(str2, z, (String) null);
        if (com.kwai.filedownloader.f.c.a(a2, d2, z2, true)) {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(a2));
            }
            return;
        }
        if (com.kwai.filedownloader.f.c.a(a2, cVar != null ? cVar.g() : 0L, cVar != null ? cVar.e() : com.kwai.filedownloader.f.f.d(d2), d2, this)) {
            if (com.kwai.filedownloader.f.d.f35118a) {
                com.kwai.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(a2), d2);
                if (cVar != null) {
                    this.f35221a.e(a2);
                    this.f35221a.d(a2);
                }
            }
            return;
        }
        if (cVar == null || !(cVar.f() == -2 || cVar.f() == -1 || cVar.f() == 1 || cVar.f() == 6 || cVar.f() == 2)) {
            if (cVar == null) {
                cVar = new com.kwai.filedownloader.d.c();
            }
            cVar.a(str);
            cVar.a(str2, z);
            cVar.a(a2);
            cVar.a(0L);
            cVar.c(0L);
            cVar.a((byte) 1);
            cVar.b(1);
        } else if (cVar.a() == a2) {
            if (!TextUtils.equals(str, cVar.b())) {
                cVar.a(str);
            }
            if (z4) {
                this.f35221a.a(cVar);
            }
            this.f35222b.a(new DownloadLaunchRunnable.a().a(cVar).a(bVar).a(this).a(Integer.valueOf(i3)).b(Integer.valueOf(i2)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i4)).a());
        } else {
            this.f35221a.e(cVar.a());
            this.f35221a.d(cVar.a());
            cVar.a(a2);
            cVar.a(str2, z);
            if (list != null) {
                for (com.kwai.filedownloader.d.a aVar : list) {
                    aVar.a(a2);
                    this.f35221a.a(aVar);
                }
            }
        }
        z4 = true;
        if (z4) {
        }
        this.f35222b.a(new DownloadLaunchRunnable.a().a(cVar).a(bVar).a(this).a(Integer.valueOf(i3)).b(Integer.valueOf(i2)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i4)).a());
    }

    public boolean a(int i2) {
        return a(this.f35221a.b(i2));
    }

    @Override // com.kwai.filedownloader.x
    public boolean a(com.kwai.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean c2 = this.f35222b.c(cVar.a());
        if (com.kwai.filedownloader.d.d.a(cVar.f())) {
            if (!c2) {
                return false;
            }
        } else if (!c2) {
            com.kwai.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f()));
            return false;
        }
        return true;
    }

    public boolean a(String str, String str2) {
        return a(com.kwai.filedownloader.f.f.b(str, str2));
    }

    public boolean b() {
        return this.f35222b.a() <= 0;
    }

    public boolean b(int i2) {
        if (com.kwai.filedownloader.f.d.f35118a) {
            com.kwai.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i2));
        }
        com.kwai.filedownloader.d.c b2 = this.f35221a.b(i2);
        if (b2 == null) {
            return false;
        }
        b2.a((byte) -2);
        this.f35222b.b(i2);
        return true;
    }

    public long c(int i2) {
        com.kwai.filedownloader.d.c b2 = this.f35221a.b(i2);
        if (b2 == null) {
            return 0L;
        }
        int n = b2.n();
        if (n <= 1) {
            return b2.g();
        }
        List<com.kwai.filedownloader.d.a> c2 = this.f35221a.c(i2);
        if (c2 == null || c2.size() != n) {
            return 0L;
        }
        return com.kwai.filedownloader.d.a.a(c2);
    }

    public void c() {
        this.f35221a.a();
    }

    public long d(int i2) {
        com.kwai.filedownloader.d.c b2 = this.f35221a.b(i2);
        if (b2 == null) {
            return 0L;
        }
        return b2.h();
    }

    public byte e(int i2) {
        com.kwai.filedownloader.d.c b2 = this.f35221a.b(i2);
        if (b2 == null) {
            return (byte) 0;
        }
        return b2.f();
    }

    public synchronized boolean f(int i2) {
        return this.f35222b.a(i2);
    }

    public boolean g(int i2) {
        if (i2 == 0) {
            com.kwai.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        } else if (a(i2)) {
            com.kwai.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        } else {
            this.f35221a.e(i2);
            this.f35221a.d(i2);
            return true;
        }
    }
}
