package com.kwai.filedownloader.services;

import android.text.TextUtils;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g implements x {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwai.filedownloader.b.a f11289a;

    /* renamed from: b  reason: collision with root package name */
    private final h f11290b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        com.kwai.filedownloader.download.b a2 = com.kwai.filedownloader.download.b.a();
        this.f11289a = a2.c();
        this.f11290b = new h(a2.d());
    }

    @Override // com.kwai.filedownloader.x
    public int a(String str, int i) {
        return this.f11290b.a(str, i);
    }

    public void a() {
        List<Integer> b2 = this.f11290b.b();
        if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(b2.size()));
        }
        for (Integer num : b2) {
            b(num.intValue());
        }
    }

    public synchronized void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        boolean z4;
        com.kwai.filedownloader.d.c cVar;
        int a2;
        if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        int a3 = com.kwai.filedownloader.f.f.a(str, str2, z);
        com.kwai.filedownloader.d.c b2 = this.f11289a.b(a3);
        List<com.kwai.filedownloader.d.a> list = null;
        if (!z && b2 == null && (b2 = this.f11289a.b((a2 = com.kwai.filedownloader.f.f.a(str, com.kwai.filedownloader.f.f.h(str2), true)))) != null && str2.equals(b2.d())) {
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(a3), Integer.valueOf(a2));
            }
            list = this.f11289a.c(a2);
        }
        if (!com.kwai.filedownloader.f.c.a(a3, b2, (x) this, true)) {
            String d = b2 != null ? b2.d() : com.kwai.filedownloader.f.f.a(str2, z, (String) null);
            if (!com.kwai.filedownloader.f.c.a(a3, d, z2, true)) {
                if (!com.kwai.filedownloader.f.c.a(a3, b2 != null ? b2.g() : 0L, b2 != null ? b2.e() : com.kwai.filedownloader.f.f.d(d), d, this)) {
                    if (b2 == null || !(b2.f() == -2 || b2.f() == -1 || b2.f() == 1 || b2.f() == 6 || b2.f() == 2)) {
                        com.kwai.filedownloader.d.c cVar2 = b2 == null ? new com.kwai.filedownloader.d.c() : b2;
                        cVar2.a(str);
                        cVar2.a(str2, z);
                        cVar2.a(a3);
                        cVar2.a(0L);
                        cVar2.c(0L);
                        cVar2.a((byte) 1);
                        cVar2.b(1);
                        z4 = true;
                        cVar = cVar2;
                    } else if (b2.a() != a3) {
                        this.f11289a.e(b2.a());
                        this.f11289a.d(b2.a());
                        b2.a(a3);
                        b2.a(str2, z);
                        if (list != null) {
                            for (com.kwai.filedownloader.d.a aVar : list) {
                                aVar.a(a3);
                                this.f11289a.a(aVar);
                            }
                        }
                        z4 = true;
                        cVar = b2;
                    } else if (TextUtils.equals(str, b2.b())) {
                        z4 = false;
                        cVar = b2;
                    } else {
                        b2.a(str);
                        z4 = true;
                        cVar = b2;
                    }
                    if (z4) {
                        this.f11289a.a(cVar);
                    }
                    this.f11290b.a(new DownloadLaunchRunnable.a().a(cVar).a(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).a());
                } else if (com.kwai.filedownloader.f.d.f11227a) {
                    com.kwai.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(a3), d);
                    if (b2 != null) {
                        this.f11289a.e(a3);
                        this.f11289a.d(a3);
                    }
                }
            } else if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(a3));
            }
        } else if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(a3));
        }
    }

    public boolean a(int i) {
        return a(this.f11289a.b(i));
    }

    @Override // com.kwai.filedownloader.x
    public boolean a(com.kwai.filedownloader.d.c cVar) {
        boolean z = true;
        if (cVar == null) {
            return false;
        }
        boolean c = this.f11290b.c(cVar.a());
        if (com.kwai.filedownloader.d.d.a(cVar.f())) {
            if (!c) {
                z = false;
            }
        } else if (!c) {
            com.kwai.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.a()), Byte.valueOf(cVar.f()));
            z = false;
        }
        return z;
    }

    public boolean a(String str, String str2) {
        return a(com.kwai.filedownloader.f.f.b(str, str2));
    }

    public boolean b() {
        return this.f11290b.a() <= 0;
    }

    public boolean b(int i) {
        if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwai.filedownloader.d.c b2 = this.f11289a.b(i);
        if (b2 == null) {
            return false;
        }
        b2.a((byte) -2);
        this.f11290b.b(i);
        return true;
    }

    public long c(int i) {
        com.kwai.filedownloader.d.c b2 = this.f11289a.b(i);
        if (b2 == null) {
            return 0L;
        }
        int n = b2.n();
        if (n <= 1) {
            return b2.g();
        }
        List<com.kwai.filedownloader.d.a> c = this.f11289a.c(i);
        if (c == null || c.size() != n) {
            return 0L;
        }
        return com.kwai.filedownloader.d.a.a(c);
    }

    public void c() {
        this.f11289a.a();
    }

    public long d(int i) {
        com.kwai.filedownloader.d.c b2 = this.f11289a.b(i);
        if (b2 == null) {
            return 0L;
        }
        return b2.h();
    }

    public byte e(int i) {
        com.kwai.filedownloader.d.c b2 = this.f11289a.b(i);
        if (b2 == null) {
            return (byte) 0;
        }
        return b2.f();
    }

    public synchronized boolean f(int i) {
        return this.f11290b.a(i);
    }

    public boolean g(int i) {
        if (i == 0) {
            com.kwai.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        } else if (a(i)) {
            com.kwai.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        } else {
            this.f11289a.e(i);
            this.f11289a.d(i);
            return true;
        }
    }
}
