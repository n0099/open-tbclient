package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class b {
    public com.kwad.framework.filedownloader.services.c afC;
    public c.a afD;
    public c.b afE;
    public c.e afF;
    public volatile com.kwad.framework.filedownloader.b.a afG;
    public c.d afH;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final b afI = new b();
    }

    public static b ve() {
        return a.afI;
    }

    private c.a vj() {
        c.a aVar = this.afD;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.afD == null) {
                this.afD = vm().wk();
            }
        }
        return this.afD;
    }

    private c.b vk() {
        c.b bVar = this.afE;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.afE == null) {
                this.afE = vm().wj();
            }
        }
        return this.afE;
    }

    private c.e vl() {
        c.e eVar = this.afF;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.afF == null) {
                this.afF = vm().wi();
            }
        }
        return this.afF;
    }

    private com.kwad.framework.filedownloader.services.c vm() {
        com.kwad.framework.filedownloader.services.c cVar = this.afC;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.afC == null) {
                this.afC = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.afC;
    }

    public final c.d vf() {
        c.d dVar = this.afH;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.afH == null) {
                this.afH = vm().wl();
            }
        }
        return this.afH;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a vg() {
        if (this.afG != null) {
            return this.afG;
        }
        this.afG = vm().wh();
        a(this.afG.uV());
        return this.afG;
    }

    public final int vh() {
        return vm().vh();
    }

    public final boolean vi() {
        vl();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r8.wb() <= 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        if (r8.wb() > 0) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:82:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:55:0x00f1, B:56:0x00fd, B:58:0x0113, B:60:0x0117, B:61:0x012f, B:62:0x0136, B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5), top: B:80:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a.InterfaceC0678a interfaceC0678a) {
        long j;
        long j2;
        String targetFilePath;
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<com.kwad.framework.filedownloader.d.c> it = interfaceC0678a.iterator();
        c.d vf = ve().vf();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (it.hasNext()) {
            try {
                com.kwad.framework.filedownloader.d.c next = it.next();
                String str2 = str;
                if (next.tL() != 3) {
                    try {
                        if (next.tL() != 2) {
                            if (next.tL() != -1) {
                                if (next.tL() == 1) {
                                }
                                targetFilePath = next.getTargetFilePath();
                                if (targetFilePath != null) {
                                    j = currentTimeMillis;
                                    j2 = j3;
                                    z = true;
                                } else {
                                    File file = new File(targetFilePath);
                                    if (next.tL() == -2) {
                                        j = currentTimeMillis;
                                        try {
                                            if (com.kwad.framework.filedownloader.f.f.a(next.getId(), next, next.getPath(), null)) {
                                                File file2 = new File(next.vt());
                                                if (!file2.exists() && file.exists()) {
                                                    boolean renameTo = file.renameTo(file2);
                                                    if (com.kwad.framework.filedownloader.f.d.ahW) {
                                                        j2 = j3;
                                                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                        if (next.tL() != 1) {
                                                        }
                                                        if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next) && !file.exists()) {
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
                                            com.kwad.framework.filedownloader.f.f.ao(com.kwad.framework.filedownloader.f.c.wB());
                                            interfaceC0678a.uW();
                                            if (com.kwad.framework.filedownloader.f.d.ahW) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        j = currentTimeMillis;
                                    }
                                    j2 = j3;
                                    if (next.tL() != 1) {
                                    }
                                    if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next)) {
                                        z = false;
                                    }
                                    z = true;
                                }
                                if (!z) {
                                    try {
                                        it.remove();
                                        j4++;
                                        str = str2;
                                        currentTimeMillis = j;
                                        j3 = j2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = str2;
                                        com.kwad.framework.filedownloader.f.f.ao(com.kwad.framework.filedownloader.f.c.wB());
                                        interfaceC0678a.uW();
                                        if (com.kwad.framework.filedownloader.f.d.ahW) {
                                            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j));
                                        }
                                        throw th;
                                    }
                                } else {
                                    int id = next.getId();
                                    int f = vf.f(next.getUrl(), next.getPath(), next.tH());
                                    if (f != id) {
                                        if (com.kwad.framework.filedownloader.f.d.ahW) {
                                            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(f));
                                        }
                                        next.setId(f);
                                        interfaceC0678a.a(id, next);
                                        j5++;
                                    }
                                    interfaceC0678a.c(next);
                                    j3 = j2 + 1;
                                    str = str2;
                                    currentTimeMillis = j;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j = currentTimeMillis;
                        j2 = j3;
                        str = str2;
                        com.kwad.framework.filedownloader.f.f.ao(com.kwad.framework.filedownloader.f.c.wB());
                        interfaceC0678a.uW();
                        if (com.kwad.framework.filedownloader.f.d.ahW) {
                        }
                        throw th;
                    }
                }
                next.d((byte) -2);
                targetFilePath = next.getTargetFilePath();
                if (targetFilePath != null) {
                }
                if (!z) {
                }
            } catch (Throwable th4) {
                th = th4;
                j = currentTimeMillis;
                j2 = j3;
            }
        }
        String str3 = str;
        long j6 = currentTimeMillis;
        long j7 = j3;
        com.kwad.framework.filedownloader.f.f.ao(com.kwad.framework.filedownloader.f.c.wB());
        interfaceC0678a.uW();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str3, Long.valueOf(j7), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j6));
        }
    }

    public final int a(int i, String str, String str2, long j) {
        return vj().K(j);
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.afC = new com.kwad.framework.filedownloader.services.c(bVar);
            this.afE = null;
            this.afF = null;
            this.afG = null;
            this.afH = null;
        }
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return vl().c(file);
    }

    public final com.kwad.framework.filedownloader.a.b ba(String str) {
        try {
            return vk().aX(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.afE = bVar;
            return bVar.aX(str);
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.afC = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }
}
