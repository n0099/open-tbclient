package com.kwai.filedownloader.download;

import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.c;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public com.kwai.filedownloader.services.c f36946a;

    /* renamed from: b  reason: collision with root package name */
    public c.a f36947b;

    /* renamed from: c  reason: collision with root package name */
    public c.b f36948c;

    /* renamed from: d  reason: collision with root package name */
    public c.e f36949d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwai.filedownloader.b.a f36950e;

    /* renamed from: f  reason: collision with root package name */
    public c.d f36951f;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f36952a = new b();
    }

    public static b a() {
        return a.f36952a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r8.g() <= 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        if (r8.g() > 0) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:83:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:55:0x00f1, B:56:0x00fb, B:58:0x0111, B:60:0x0115, B:61:0x012d, B:62:0x0134, B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5), top: B:89:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:55:0x00f1, B:56:0x00fb, B:58:0x0111, B:60:0x0115, B:61:0x012d, B:62:0x0134, B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5), top: B:89:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a.InterfaceC0440a interfaceC0440a) {
        long j;
        long j2;
        String d2;
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<com.kwai.filedownloader.d.c> it = interfaceC0440a.iterator();
        c.d b2 = a().b();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (it.hasNext()) {
            try {
                com.kwai.filedownloader.d.c next = it.next();
                String str2 = str;
                if (next.f() != 3) {
                    try {
                        if (next.f() != 2) {
                            if (next.f() != -1) {
                                if (next.f() == 1) {
                                }
                                d2 = next.d();
                                if (d2 != null) {
                                    j = currentTimeMillis;
                                    j2 = j3;
                                    z = true;
                                } else {
                                    File file = new File(d2);
                                    if (next.f() == -2) {
                                        j = currentTimeMillis;
                                        try {
                                            if (com.kwai.filedownloader.f.f.a(next.a(), next, next.c(), null)) {
                                                File file2 = new File(next.e());
                                                if (!file2.exists() && file.exists()) {
                                                    boolean renameTo = file.renameTo(file2);
                                                    if (com.kwai.filedownloader.f.d.f37011a) {
                                                        j2 = j3;
                                                        com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                        if (next.f() != 1) {
                                                        }
                                                        if (com.kwai.filedownloader.f.f.a(next.a(), next) && !file.exists()) {
                                                            z = false;
                                                        }
                                                        z = true;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            j2 = j3;
                                            str = str2;
                                            com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                                            interfaceC0440a.a();
                                            if (com.kwai.filedownloader.f.d.f37011a) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        j = currentTimeMillis;
                                    }
                                    j2 = j3;
                                    if (next.f() != 1) {
                                    }
                                    if (com.kwai.filedownloader.f.f.a(next.a(), next)) {
                                        z = false;
                                    }
                                    z = true;
                                }
                                if (z) {
                                    int a2 = next.a();
                                    int a3 = b2.a(a2, next.b(), next.c(), next.l());
                                    if (a3 != a2) {
                                        if (com.kwai.filedownloader.f.d.f37011a) {
                                            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(a2), Integer.valueOf(a3));
                                        }
                                        next.a(a3);
                                        interfaceC0440a.a(a2, next);
                                        j5++;
                                    }
                                    interfaceC0440a.b(next);
                                    j3 = j2 + 1;
                                } else {
                                    try {
                                        it.remove();
                                        interfaceC0440a.a(next);
                                        j4++;
                                        j3 = j2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = str2;
                                        com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                                        interfaceC0440a.a();
                                        if (com.kwai.filedownloader.f.d.f37011a) {
                                        }
                                        throw th;
                                    }
                                }
                                str = str2;
                                currentTimeMillis = j;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j = currentTimeMillis;
                        j2 = j3;
                        str = str2;
                        com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
                        interfaceC0440a.a();
                        if (com.kwai.filedownloader.f.d.f37011a) {
                            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j));
                        }
                        throw th;
                    }
                }
                next.a((byte) -2);
                d2 = next.d();
                if (d2 != null) {
                }
                if (z) {
                }
                str = str2;
                currentTimeMillis = j;
            } catch (Throwable th4) {
                th = th4;
                j = currentTimeMillis;
                j2 = j3;
            }
        }
        String str3 = str;
        long j6 = currentTimeMillis;
        long j7 = j3;
        com.kwai.filedownloader.f.f.b(com.kwai.filedownloader.f.c.a());
        interfaceC0440a.a();
        if (com.kwai.filedownloader.f.d.f37011a) {
            com.kwai.filedownloader.f.d.c(com.kwai.filedownloader.b.a.class, str3, Long.valueOf(j7), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j6));
        }
    }

    private c.a f() {
        c.a aVar = this.f36947b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f36947b == null) {
                this.f36947b = i().e();
            }
        }
        return this.f36947b;
    }

    private c.b g() {
        c.b bVar = this.f36948c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f36948c == null) {
                this.f36948c = i().d();
            }
        }
        return this.f36948c;
    }

    private c.e h() {
        c.e eVar = this.f36949d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f36949d == null) {
                this.f36949d = i().c();
            }
        }
        return this.f36949d;
    }

    private com.kwai.filedownloader.services.c i() {
        com.kwai.filedownloader.services.c cVar = this.f36946a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.f36946a == null) {
                this.f36946a = new com.kwai.filedownloader.services.c();
            }
        }
        return this.f36946a;
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
            this.f36946a = new com.kwai.filedownloader.services.c(aVar);
            this.f36948c = null;
            this.f36949d = null;
            this.f36950e = null;
            this.f36951f = null;
        }
    }

    public c.d b() {
        c.d dVar = this.f36951f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f36951f == null) {
                this.f36951f = i().f();
            }
        }
        return this.f36951f;
    }

    public void b(c.a aVar) {
        synchronized (this) {
            this.f36946a = new com.kwai.filedownloader.services.c(aVar);
        }
    }

    public com.kwai.filedownloader.b.a c() {
        com.kwai.filedownloader.b.a aVar = this.f36950e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f36950e == null) {
                com.kwai.filedownloader.b.a b2 = i().b();
                this.f36950e = b2;
                a(b2.b());
            }
        }
        return this.f36950e;
    }

    public int d() {
        return i().a();
    }

    public boolean e() {
        return h().a();
    }
}
