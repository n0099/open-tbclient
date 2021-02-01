package com.kwai.filedownloader.download;

import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.c;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private com.kwai.filedownloader.services.c f10902a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f10903b;
    private c.b c;
    private c.e d;
    private com.kwai.filedownloader.b.a e;
    private c.d f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f10904a = new b();
    }

    public static b a() {
        return a.f10904a;
    }

    private static void a(a.InterfaceC1154a interfaceC1154a) {
        Iterator<com.kwai.filedownloader.d.c> it = interfaceC1154a.iterator();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        c.d b2 = a().b();
        long currentTimeMillis = System.currentTimeMillis();
        while (it.hasNext()) {
            try {
                boolean z = false;
                com.kwai.filedownloader.d.c next = it.next();
                if (next.f() == 3 || next.f() == 2 || next.f() == -1 || (next.f() == 1 && next.g() > 0)) {
                    next.a((byte) -2);
                }
                String d = next.d();
                if (d == null) {
                    z = true;
                } else {
                    File file = new File(d);
                    if (next.f() == -2 && com.kwai.filedownloader.f.f.a(next.a(), next, next.c(), null)) {
                        File file2 = new File(next.e());
                        if (!file2.exists() && file.exists()) {
                            boolean renameTo = file.renameTo(file2);
                            if (com.kwai.filedownloader.f.d.f10930a) {
                                com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                            }
                        }
                    }
                    if (next.f() == 1 && next.g() <= 0) {
                        z = true;
                    } else if (!com.kwai.filedownloader.f.f.a(next.a(), next)) {
                        z = true;
                    } else if (file.exists()) {
                        z = true;
                    }
                }
                if (z) {
                    it.remove();
                    interfaceC1154a.a(next);
                    j2++;
                } else {
                    int a2 = next.a();
                    int a3 = b2.a(a2, next.b(), next.c(), next.l());
                    if (a3 != a2) {
                        if (com.kwai.filedownloader.f.d.f10930a) {
                            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(a2), Integer.valueOf(a3));
                        }
                        next.a(a3);
                        interfaceC1154a.a(a2, next);
                        j3++;
                    }
                    interfaceC1154a.b(next);
                    j++;
                }
                j3 = j3;
            } catch (Throwable th) {
                com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                interfaceC1154a.a();
                if (com.kwai.filedownloader.f.d.f10930a) {
                    com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                throw th;
            }
        }
        com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
        interfaceC1154a.a();
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private c.a f() {
        if (this.f10903b != null) {
            return this.f10903b;
        }
        synchronized (this) {
            if (this.f10903b == null) {
                this.f10903b = i().e();
            }
        }
        return this.f10903b;
    }

    private c.b g() {
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = i().d();
            }
        }
        return this.c;
    }

    private c.e h() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = i().c();
            }
        }
        return this.d;
    }

    private com.kwai.filedownloader.services.c i() {
        if (this.f10902a != null) {
            return this.f10902a;
        }
        synchronized (this) {
            if (this.f10902a == null) {
                this.f10902a = new com.kwai.filedownloader.services.c();
            }
        }
        return this.f10902a;
    }

    public int a(int i, String str, String str2, long j) {
        return f().a(i, str, str2, j);
    }

    public com.kwai.filedownloader.a.b a(String str) {
        return g().a(str);
    }

    public com.kwai.filedownloader.e.a a(File file) {
        return h().a(file);
    }

    public void a(c.a aVar) {
        synchronized (this) {
            this.f10902a = new com.kwai.filedownloader.services.c(aVar);
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    public c.d b() {
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = i().f();
            }
        }
        return this.f;
    }

    public void b(c.a aVar) {
        synchronized (this) {
            this.f10902a = new com.kwai.filedownloader.services.c(aVar);
        }
    }

    public com.kwai.filedownloader.b.a c() {
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = i().b();
                a(this.e.b());
            }
        }
        return this.e;
    }

    public int d() {
        return i().a();
    }

    public boolean e() {
        return h().a();
    }
}
