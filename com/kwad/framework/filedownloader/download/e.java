package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class e {
    public final String Vz;
    public long afA;
    public final long afB;
    public final com.kwad.framework.filedownloader.b.a afG;
    public final boolean afO;
    public final int afr;
    public final long afz;
    public final c agG;
    public final com.kwad.framework.filedownloader.a.b agH;
    public com.kwad.framework.filedownloader.e.a agI;
    public volatile long agJ;
    public volatile long agK;
    public final f ago;
    public final int agq;
    public final long contentLength;
    public volatile boolean kG;

    public e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.agJ = 0L;
        this.agK = 0L;
        this.ago = fVar;
        this.Vz = str;
        this.agH = bVar;
        this.afO = z;
        this.agG = cVar;
        this.agq = i2;
        this.afr = i;
        this.afG = b.ve().vg();
        this.afz = aVar.afz;
        this.afB = aVar.afB;
        this.afA = aVar.afA;
        this.contentLength = aVar.contentLength;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public String Vz;
        public Integer afx;
        public com.kwad.framework.filedownloader.download.a afy;
        public com.kwad.framework.filedownloader.a.b agH;
        public c agL;
        public Boolean agl;
        public f ago;
        public Integer ags;

        public final a a(c cVar) {
            this.agL = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.ago = fVar;
            return this;
        }

        public final a be(String str) {
            this.Vz = str;
            return this;
        }

        public final a bq(int i) {
            this.ags = Integer.valueOf(i);
            return this;
        }

        public final a br(int i) {
            this.afx = Integer.valueOf(i);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.afy = aVar;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.agH = bVar;
            return this;
        }

        public final a be(boolean z) {
            this.agl = Boolean.valueOf(z);
            return this;
        }

        public final e vI() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.agl != null && (bVar = this.agH) != null && (aVar = this.afy) != null && this.ago != null && this.Vz != null && (num = this.afx) != null && this.ags != null) {
                return new e(bVar, aVar, this.agL, num.intValue(), this.ags.intValue(), this.agl.booleanValue(), this.ago, this.Vz, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    public /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void sync() {
        boolean z;
        boolean z2;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.agI.wy();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.agG != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.afG.a(this.afr, this.agq, this.afA);
            } else {
                this.ago.vq();
            }
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.afr), Integer.valueOf(this.agq), Long.valueOf(this.afA), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    private void vH() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.afA - this.agJ, elapsedRealtime - this.agK)) {
            sync();
            this.agJ = this.afA;
            this.agK = elapsedRealtime;
        }
    }

    public final void pause() {
        this.kG = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
        if (r13 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0120, code lost:
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r13);
        r6 = r16.afA - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012d, code lost:
        if (r2 == (-1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0131, code lost:
        if (r2 != r6) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0170, code lost:
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.afz), java.lang.Long.valueOf(r16.afB), java.lang.Long.valueOf(r16.afA), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0171, code lost:
        r16.ago.a(r16.agG, r16.afz, r16.afB);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017c, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        com.kwad.framework.filedownloader.e.a aVar;
        String b;
        if (this.kG) {
            return;
        }
        long b2 = com.kwad.framework.filedownloader.f.f.b(this.agq, this.agH);
        int i = 0;
        if (b2 != 0) {
            long j = this.contentLength;
            if (j > 0 && b2 != j) {
                if (this.afB == 0) {
                    b = com.kwad.framework.filedownloader.f.f.b("range[%d-)", Long.valueOf(this.afA));
                } else {
                    b = com.kwad.framework.filedownloader.f.f.b("range[%d-%d)", Long.valueOf(this.afA), Long.valueOf(this.afB));
                }
                throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", b, Long.valueOf(this.contentLength), Long.valueOf(b2), Integer.valueOf(this.afr), Integer.valueOf(this.agq)));
            }
            long j2 = this.afA;
            try {
                boolean vi2 = b.ve().vi();
                if (this.agG != null && !vi2) {
                    throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
                }
                aVar = com.kwad.framework.filedownloader.f.f.bt(this.Vz);
                try {
                    this.agI = aVar;
                    if (vi2) {
                        aVar.seek(this.afA);
                    }
                    if (com.kwad.framework.filedownloader.f.d.ahW) {
                        com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.agq), Long.valueOf(this.afz), Long.valueOf(this.afB), Long.valueOf(this.afA));
                    }
                    InputStream inputStream = this.agH.getInputStream();
                    byte[] bArr = new byte[4096];
                    if (!this.kG) {
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            aVar.write(bArr, i, read);
                            long j3 = read;
                            this.afA += j3;
                            this.ago.onProgress(j3);
                            vH();
                            if (this.kG) {
                                break;
                            }
                            if (this.afO && com.kwad.framework.filedownloader.f.f.wI()) {
                                throw new FileDownloadNetworkPolicyException();
                            }
                            i = 0;
                        }
                    } else {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        } else {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.afr), Integer.valueOf(this.agq)));
        }
    }
}
