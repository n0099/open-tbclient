package com.ss.android.socialbase.downloader.h;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements Runnable {
    public static final String a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f43342b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f43343c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.e f43344d;

    /* renamed from: e  reason: collision with root package name */
    public final DownloadTask f43345e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadInfo f43346f;

    /* renamed from: g  reason: collision with root package name */
    public final f f43347g;

    /* renamed from: h  reason: collision with root package name */
    public i f43348h;
    public j i;
    public volatile boolean j;
    public volatile boolean k;
    public boolean l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.l = false;
        this.f43343c = bVar;
        this.f43345e = downloadTask;
        if (downloadTask != null) {
            this.f43346f = downloadTask.getDownloadInfo();
        }
        this.f43347g = fVar;
        this.i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f43343c.a(this);
    }

    private String c() {
        return this.f43346f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.f43348h;
        if (iVar != null) {
            iVar.d();
            this.f43348h = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f43344d;
        if (eVar == null) {
            return;
        }
        eVar.a(j, j2);
    }

    public void b() {
        this.k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f43344d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.f43342b.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.f43342b = this.f43343c;
        while (true) {
            try {
                this.f43342b.a(this);
                if (!a(this.f43342b)) {
                    break;
                }
                this.f43342b.a(false);
                if (!e()) {
                    this.f43342b = this.f43347g.a(this.f43342b.s());
                    if (e() || this.f43342b == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                com.ss.android.socialbase.downloader.model.b bVar = this.f43342b;
                if (bVar != null) {
                    bVar.a(false);
                }
                d();
                this.f43347g.a(this);
            }
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
        long j;
        boolean z;
        long j2;
        com.ss.android.socialbase.downloader.exception.h a2;
        int b2;
        com.ss.android.socialbase.downloader.model.b e2;
        while (true) {
            com.ss.android.socialbase.downloader.model.b bVar2 = (bVar.d() && bVar.f() && (e2 = bVar.e()) != null && e2.s() == bVar.s()) ? e2 : null;
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
            boolean z2 = false;
            try {
                try {
                    if (e()) {
                        return false;
                    }
                    String c2 = c();
                    boolean z3 = this.f43348h != null;
                    this.l = z3;
                    bVar.b(z3);
                    try {
                        try {
                            try {
                                try {
                                    if (!this.l) {
                                        List<com.ss.android.socialbase.downloader.model.c> a3 = com.ss.android.socialbase.downloader.i.f.a(this.f43346f.getExtraHeaders(), this.f43346f.geteTag(), j3, j4);
                                        a3.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.s())));
                                        com.ss.android.socialbase.downloader.i.f.a(a3, this.f43346f);
                                        com.ss.android.socialbase.downloader.i.f.b(a3, this.f43346f);
                                        this.f43348h = com.ss.android.socialbase.downloader.downloader.c.a(this.f43346f.isNeedDefaultHttpServiceBackUp(), this.f43346f.getMaxBytes(), c2, a3);
                                    }
                                    if (this.f43348h != null && this.f43347g != null) {
                                        try {
                                            int b3 = this.f43348h.b();
                                            if (b3 < 200 || b3 >= 300) {
                                                this.f43347g.a(this.f43348h);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            th.printStackTrace();
                                            if (e()) {
                                            }
                                        }
                                    }
                                } catch (BaseException e3) {
                                    e = e3;
                                    j = n2;
                                    z = false;
                                    try {
                                        if (e()) {
                                            return true;
                                        }
                                        if (com.ss.android.socialbase.downloader.i.f.b(e)) {
                                            this.f43347g.a(e, z);
                                            return z;
                                        } else if (this.f43347g.a(e)) {
                                            if (com.ss.android.socialbase.downloader.i.f.a(e)) {
                                                this.f43347g.a(e, true);
                                                return z;
                                            }
                                            if (z2) {
                                                if (this.f43344d != null) {
                                                    if (com.ss.android.socialbase.downloader.i.a.a(32)) {
                                                        j2 = this.f43344d.a() - this.f43344d.e();
                                                        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                                                        if (i > 0) {
                                                            a(bVar, this.f43344d.e());
                                                        } else if (i < 0) {
                                                        }
                                                        if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                                            a2 = this.f43347g.a(bVar, e, j2);
                                                        } else {
                                                            a2 = this.f43347g.a(e, j2);
                                                        }
                                                        if (a2 != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                                            return z;
                                                        }
                                                        bVar.b(z);
                                                        d();
                                                    } else {
                                                        j5 = this.f43344d.a() - j;
                                                        a(bVar, j);
                                                    }
                                                } else {
                                                    this.f43347g.b(e);
                                                    return z;
                                                }
                                            }
                                            j2 = j5;
                                            if (!com.ss.android.socialbase.downloader.i.a.a(16)) {
                                            }
                                            if (a2 != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                            }
                                        } else if (this.f43346f.isNeedChunkDowngradeRetry() && !this.f43346f.isChunkDowngradeRetryUsed() && this.f43346f.getChunkCount() > 1 && com.ss.android.socialbase.downloader.i.f.a(e, this.f43346f)) {
                                            this.f43347g.c(e);
                                            return z;
                                        } else {
                                            this.f43347g.b(e);
                                            return z;
                                        }
                                    } finally {
                                        d();
                                    }
                                }
                            } catch (BaseException e4) {
                                e = e4;
                                z2 = false;
                                if (e()) {
                                }
                            }
                        } catch (BaseException e5) {
                            try {
                                throw e5;
                            } catch (Throwable th2) {
                                th = th2;
                                Throwable th3 = th;
                                if (this.f43348h != null) {
                                    try {
                                        b2 = this.f43348h.b();
                                        if (b2 >= 200) {
                                        }
                                        this.f43347g.a(this.f43348h);
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        } catch (Throwable th5) {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a(th5, "ChunkRunnableConnection");
                                if (this.f43348h != null && this.f43347g != null) {
                                    try {
                                        int b4 = this.f43348h.b();
                                        if (b4 < 200 || b4 >= 300) {
                                            this.f43347g.a(this.f43348h);
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
                                if (this.f43348h != null && this.f43347g != null) {
                                    b2 = this.f43348h.b();
                                    if (b2 >= 200 || b2 >= 300) {
                                        this.f43347g.a(this.f43348h);
                                    }
                                }
                                throw th32;
                            }
                        }
                        if (e()) {
                            return false;
                        }
                        if (this.f43348h != null) {
                            if (!this.l) {
                                try {
                                    int b5 = this.f43348h.b();
                                    if (!com.ss.android.socialbase.downloader.i.f.d(b5)) {
                                        throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(b5)));
                                        break;
                                    }
                                } catch (BaseException e6) {
                                    throw e6;
                                } catch (Throwable th8) {
                                    com.ss.android.socialbase.downloader.i.f.a(th8, "ChunkRunnableGetResponseCode");
                                }
                            }
                            z = false;
                            j = n2;
                            this.f43344d = new com.ss.android.socialbase.downloader.downloader.e(this.f43346f, c2, this.f43348h, bVar, this.f43347g);
                            if (bVar2 != null) {
                                long c3 = bVar2.c(false);
                                if (j4 != 0 && j4 >= j3) {
                                    c3 = (j4 - j3) + 1;
                                }
                                this.f43344d.a(bVar2.n(), bVar2.p(), c3);
                            }
                            try {
                                this.f43344d.d();
                                return true;
                            } catch (BaseException e7) {
                                e = e7;
                                z2 = true;
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
                        } catch (BaseException e8) {
                            this.f43347g.b(e8);
                        }
                        return z;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    z = false;
                }
            } catch (BaseException e9) {
                e = e9;
                j = n2;
                z = false;
            }
        }
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.f43348h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j) {
        com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
        if (e2 != null) {
            if (e2.h()) {
                this.i.a(e2.k(), e2.b(), j);
            }
            e2.b(j);
            this.i.a(e2.k(), e2.s(), e2.b(), j);
        } else if (bVar.d()) {
            this.i.a(bVar.k(), bVar.s(), j);
        }
    }

    public void a() {
        this.j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f43344d;
        if (eVar != null) {
            eVar.b();
        }
    }
}
