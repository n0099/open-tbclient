package com.ss.android.socialbase.downloader.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements Runnable {
    public static final String a = b.class.getSimpleName();
    public com.ss.android.socialbase.downloader.model.b b;
    public com.ss.android.socialbase.downloader.model.b c;
    public com.ss.android.socialbase.downloader.downloader.e d;
    public final DownloadTask e;
    public DownloadInfo f;
    public final f g;
    public i h;
    public j i;
    public volatile boolean j;
    public volatile boolean k;
    public boolean l;

    private String c() {
        return this.f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.h;
        if (iVar != null) {
            iVar.d();
            this.h = null;
        }
    }

    private boolean e() {
        if (!this.j && !this.k) {
            return false;
        }
        return true;
    }

    public void a() {
        this.j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void b() {
        this.k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.l = false;
        this.c = bVar;
        this.e = downloadTask;
        if (downloadTask != null) {
            this.f = downloadTask.getDownloadInfo();
        }
        this.g = fVar;
        this.i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.c.a(this);
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (bVar.d()) {
            bVar2 = bVar.e();
        } else {
            bVar2 = bVar;
        }
        if (bVar2 != null) {
            if (bVar2.h()) {
                this.i.a(bVar2.k(), bVar2.b(), j);
            }
            bVar2.b(j);
            this.i.a(bVar2.k(), bVar2.s(), bVar2.b(), j);
        } else if (bVar.d()) {
            this.i.a(bVar.k(), bVar.s(), j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01e4 A[Catch: all -> 0x02a7, TRY_ENTER, TryCatch #3 {all -> 0x02a7, blocks: (B:135:0x01da, B:139:0x01e4, B:141:0x01ea, B:144:0x01f3, B:146:0x01fb, B:148:0x0201, B:152:0x020c, B:154:0x0210, B:156:0x0218, B:158:0x0229, B:167:0x024f, B:169:0x0255, B:171:0x0262, B:175:0x026a, B:170:0x025c, B:161:0x0236, B:162:0x0242, B:177:0x0275, B:179:0x027d, B:181:0x0285, B:183:0x028d, B:185:0x0295, B:188:0x029e, B:122:0x01bc, B:126:0x01c6, B:129:0x01cd), top: B:197:0x01da, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0255 A[Catch: all -> 0x02a7, TryCatch #3 {all -> 0x02a7, blocks: (B:135:0x01da, B:139:0x01e4, B:141:0x01ea, B:144:0x01f3, B:146:0x01fb, B:148:0x0201, B:152:0x020c, B:154:0x0210, B:156:0x0218, B:158:0x0229, B:167:0x024f, B:169:0x0255, B:171:0x0262, B:175:0x026a, B:170:0x025c, B:161:0x0236, B:162:0x0242, B:177:0x0275, B:179:0x027d, B:181:0x0285, B:183:0x028d, B:185:0x0295, B:188:0x029e, B:122:0x01bc, B:126:0x01c6, B:129:0x01cd), top: B:197:0x01da, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025c A[Catch: all -> 0x02a7, TryCatch #3 {all -> 0x02a7, blocks: (B:135:0x01da, B:139:0x01e4, B:141:0x01ea, B:144:0x01f3, B:146:0x01fb, B:148:0x0201, B:152:0x020c, B:154:0x0210, B:156:0x0218, B:158:0x0229, B:167:0x024f, B:169:0x0255, B:171:0x0262, B:175:0x026a, B:170:0x025c, B:161:0x0236, B:162:0x0242, B:177:0x0275, B:179:0x027d, B:181:0x0285, B:183:0x028d, B:185:0x0295, B:188:0x029e, B:122:0x01bc, B:126:0x01c6, B:129:0x01cd), top: B:197:0x01da, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026a A[Catch: all -> 0x02a7, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x02a7, blocks: (B:135:0x01da, B:139:0x01e4, B:141:0x01ea, B:144:0x01f3, B:146:0x01fb, B:148:0x0201, B:152:0x020c, B:154:0x0210, B:156:0x0218, B:158:0x0229, B:167:0x024f, B:169:0x0255, B:171:0x0262, B:175:0x026a, B:170:0x025c, B:161:0x0236, B:162:0x0242, B:177:0x0275, B:179:0x027d, B:181:0x0285, B:183:0x028d, B:185:0x0295, B:188:0x029e, B:122:0x01bc, B:126:0x01c6, B:129:0x01cd), top: B:197:0x01da, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103 A[Catch: all -> 0x01ba, BaseException -> 0x01d6, TRY_ENTER, TryCatch #14 {all -> 0x01ba, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:35:0x00b3, B:37:0x00b7, B:45:0x00ce, B:62:0x00f9, B:66:0x0103, B:68:0x0107, B:79:0x0137, B:76:0x012f, B:78:0x0136, B:51:0x00dd, B:53:0x00e1), top: B:211:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b bVar) {
        com.ss.android.socialbase.downloader.model.b bVar2;
        long j;
        boolean z;
        long j2;
        com.ss.android.socialbase.downloader.exception.h a2;
        boolean z2;
        int b;
        com.ss.android.socialbase.downloader.model.b e;
        while (true) {
            if (bVar.d() && bVar.f() && (e = bVar.e()) != null && e.s() == bVar.s()) {
                bVar2 = e;
            } else {
                bVar2 = null;
            }
            if (bVar2 != null && bVar2.i()) {
                return true;
            }
            long n = bVar.n();
            long p = bVar.p();
            long n2 = bVar.n();
            if (bVar2 != null) {
                n2 = bVar2.n();
                n = bVar2.n();
                p = bVar2.p();
            }
            long j3 = n;
            long j4 = p;
            long j5 = 0;
            boolean z3 = false;
            try {
                try {
                    if (e()) {
                        return false;
                    }
                    String c = c();
                    if (this.h != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.l = z2;
                    bVar.b(z2);
                    try {
                        try {
                            try {
                                try {
                                    if (!this.l) {
                                        List a3 = com.ss.android.socialbase.downloader.i.f.a(this.f.getExtraHeaders(), this.f.geteTag(), j3, j4);
                                        a3.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.s())));
                                        com.ss.android.socialbase.downloader.i.f.a(a3, this.f);
                                        com.ss.android.socialbase.downloader.i.f.b(a3, this.f);
                                        this.h = com.ss.android.socialbase.downloader.downloader.c.a(this.f.isNeedDefaultHttpServiceBackUp(), this.f.getMaxBytes(), c, a3);
                                    }
                                    if (this.h != null && this.g != null) {
                                        try {
                                            int b2 = this.h.b();
                                            if (b2 < 200 || b2 >= 300) {
                                                this.g.a(this.h);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            th.printStackTrace();
                                            if (e()) {
                                            }
                                        }
                                    }
                                } catch (BaseException e2) {
                                    e = e2;
                                    j = n2;
                                    z = false;
                                    try {
                                        if (e()) {
                                            return true;
                                        }
                                        if (com.ss.android.socialbase.downloader.i.f.b(e)) {
                                            this.g.a(e, z);
                                            return z;
                                        } else if (this.g.a(e)) {
                                            if (com.ss.android.socialbase.downloader.i.f.a(e)) {
                                                this.g.a(e, true);
                                                return z;
                                            }
                                            if (z3) {
                                                if (this.d != null) {
                                                    if (com.ss.android.socialbase.downloader.i.a.a(32)) {
                                                        j2 = this.d.a() - this.d.e();
                                                        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                                        if (i > 0) {
                                                            a(bVar, this.d.e());
                                                        } else if (i < 0) {
                                                        }
                                                        if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                                            a2 = this.g.a(bVar, e, j2);
                                                        } else {
                                                            a2 = this.g.a(e, j2);
                                                        }
                                                        if (a2 != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                                            return z;
                                                        }
                                                        bVar.b(z);
                                                        d();
                                                    } else {
                                                        j5 = this.d.a() - j;
                                                        a(bVar, j);
                                                    }
                                                } else {
                                                    this.g.b(e);
                                                    return z;
                                                }
                                            }
                                            j2 = j5;
                                            if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                            }
                                            if (a2 != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                            }
                                        } else if (this.f.isNeedChunkDowngradeRetry() && !this.f.isChunkDowngradeRetryUsed() && this.f.getChunkCount() > 1 && com.ss.android.socialbase.downloader.i.f.a(e, this.f)) {
                                            this.g.c(e);
                                            return z;
                                        } else {
                                            this.g.b(e);
                                            return z;
                                        }
                                    } finally {
                                        d();
                                    }
                                }
                            } catch (BaseException e3) {
                                e = e3;
                                z3 = false;
                                if (e()) {
                                }
                            }
                        } catch (BaseException e4) {
                            try {
                                throw e4;
                            } catch (Throwable th2) {
                                th = th2;
                                Throwable th3 = th;
                                if (this.h != null) {
                                    try {
                                        b = this.h.b();
                                        if (b >= 200) {
                                        }
                                        this.g.a(this.h);
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        } catch (Throwable th5) {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a(th5, "ChunkRunnableConnection");
                                if (this.h != null && this.g != null) {
                                    try {
                                        int b3 = this.h.b();
                                        if (b3 < 200 || b3 >= 300) {
                                            this.g.a(this.h);
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        th.printStackTrace();
                                        if (e()) {
                                        }
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                Throwable th32 = th;
                                if (this.h != null && this.g != null) {
                                    b = this.h.b();
                                    if (b >= 200 || b >= 300) {
                                        this.g.a(this.h);
                                    }
                                }
                                throw th32;
                            }
                        }
                        if (e()) {
                            return false;
                        }
                        if (this.h != null) {
                            if (!this.l) {
                                try {
                                    int b4 = this.h.b();
                                    if (!com.ss.android.socialbase.downloader.i.f.d(b4)) {
                                        throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(b4)));
                                        break;
                                    }
                                } catch (BaseException e5) {
                                    throw e5;
                                } catch (Throwable th8) {
                                    com.ss.android.socialbase.downloader.i.f.a(th8, "ChunkRunnableGetResponseCode");
                                }
                            }
                            z = false;
                            j = n2;
                            this.d = new com.ss.android.socialbase.downloader.downloader.e(this.f, c, this.h, bVar, this.g);
                            if (bVar2 != null) {
                                long c2 = bVar2.c(false);
                                if (j4 != 0 && j4 >= j3) {
                                    c2 = (j4 - j3) + 1;
                                }
                                this.d.a(bVar2.n(), bVar2.p(), c2);
                            }
                            try {
                                this.d.d();
                                return true;
                            } catch (BaseException e6) {
                                e = e6;
                                z3 = true;
                                if (e()) {
                                }
                            }
                        } else {
                            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        if (e()) {
                            return true;
                        }
                        try {
                            com.ss.android.socialbase.downloader.i.f.a(th, "downloadChunkInner");
                        } catch (BaseException e7) {
                            this.g.b(e7);
                        }
                        return z;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    z = false;
                }
            } catch (BaseException e8) {
                e = e8;
                j = n2;
                z = false;
            }
        }
    }

    public void a(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.d;
        if (eVar == null) {
            return;
        }
        eVar.a(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.b.a(false);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.b = this.c;
        while (true) {
            try {
                this.b.a(this);
                if (!a(this.b)) {
                    break;
                }
                this.b.a(false);
                if (!e()) {
                    this.b = this.g.a(this.b.s());
                    if (e() || this.b == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                com.ss.android.socialbase.downloader.model.b bVar = this.b;
                if (bVar != null) {
                    bVar.a(false);
                }
                d();
                this.g.a(this);
            }
        }
    }
}
