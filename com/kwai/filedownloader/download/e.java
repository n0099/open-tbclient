package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    long f11210a;

    /* renamed from: b  reason: collision with root package name */
    private final f f11211b;
    private final int c;
    private final int d;
    private final c e;
    private final com.kwai.filedownloader.a.b f;
    private final boolean g;
    private final long h;
    private final long i;
    private final long j;
    private final String k;
    private com.kwai.filedownloader.e.a l;
    private volatile boolean m;
    private final com.kwai.filedownloader.b.a n;
    private volatile long o;
    private volatile long p;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        c f11212a;

        /* renamed from: b  reason: collision with root package name */
        com.kwai.filedownloader.a.b f11213b;
        com.kwai.filedownloader.download.a c;
        f d;
        String e;
        Boolean f;
        Integer g;
        Integer h;

        public a a(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.a.b bVar) {
            this.f11213b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.c = aVar;
            return this;
        }

        public a a(c cVar) {
            this.f11212a = cVar;
            return this;
        }

        public a a(f fVar) {
            this.d = fVar;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a a(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        public e a() {
            if (this.f == null || this.f11213b == null || this.c == null || this.d == null || this.e == null || this.h == null || this.g == null) {
                throw new IllegalArgumentException();
            }
            return new e(this.f11213b, this.c, this.f11212a, this.h.intValue(), this.g.intValue(), this.f.booleanValue(), this.d, this.e);
        }

        public a b(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }
    }

    private e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.f11211b = fVar;
        this.k = str;
        this.f = bVar;
        this.g = z;
        this.e = cVar;
        this.d = i2;
        this.c = i;
        this.n = b.a().c();
        this.h = aVar.f11197a;
        this.i = aVar.c;
        this.f11210a = aVar.f11198b;
        this.j = aVar.d;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.f.f.a(this.f11210a - this.o, elapsedRealtime - this.p)) {
            d();
            this.o = this.f11210a;
            this.p = elapsedRealtime;
        }
    }

    private void d() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.l.a();
            z = true;
        } catch (IOException e) {
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.e != null) {
                this.n.a(this.c, this.d, this.f11210a);
            } else {
                this.f11211b.c();
            }
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.f11210a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void a() {
        this.m = true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void b() {
        if (this.m) {
            return;
        }
        long b2 = com.kwai.filedownloader.f.f.b(this.d, this.f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.c), Integer.valueOf(this.d)));
        }
        if (this.j > 0 && b2 != this.j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.i == 0 ? com.kwai.filedownloader.f.f.a("range[%d-)", Long.valueOf(this.f11210a)) : com.kwai.filedownloader.f.f.a("range[%d-%d)", Long.valueOf(this.f11210a), Long.valueOf(this.i)), Long.valueOf(this.j), Long.valueOf(b2), Integer.valueOf(this.c), Integer.valueOf(this.d)));
        }
        long j = this.f11210a;
        InputStream inputStream = null;
        com.kwai.filedownloader.e.a aVar = null;
        try {
            boolean e = b.a().e();
            if (this.e != null && !e) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            com.kwai.filedownloader.e.a l = com.kwai.filedownloader.f.f.l(this.k);
            this.l = l;
            if (e) {
                l.a(this.f11210a);
            }
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.d), Long.valueOf(this.h), Long.valueOf(this.i), Long.valueOf(this.f11210a));
            }
            InputStream a2 = this.f.a();
            byte[] bArr = new byte[4096];
            if (this.m) {
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (l != null) {
                    try {
                        d();
                    } finally {
                    }
                }
                if (l != null) {
                    try {
                        l.b();
                        return;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            while (true) {
                int read = a2.read(bArr);
                if (read == -1) {
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (l != null) {
                        try {
                            d();
                        } finally {
                            if (l != null) {
                                try {
                                    l.b();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                    if (l != null) {
                        try {
                            l.b();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    long j2 = this.f11210a - j;
                    if (b2 != -1 && b2 != j2) {
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j2), Long.valueOf(b2), Long.valueOf(this.h), Long.valueOf(this.i), Long.valueOf(this.f11210a), Long.valueOf(j)));
                    }
                    this.f11211b.a(this.e, this.h, this.i);
                    return;
                }
                l.a(bArr, 0, read);
                this.f11210a += read;
                this.f11211b.a(read);
                c();
                if (this.m) {
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (l != null) {
                        try {
                            d();
                        } finally {
                        }
                    }
                    if (l != null) {
                        try {
                            l.b();
                            return;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            return;
                        }
                    }
                    return;
                } else if (this.g && com.kwai.filedownloader.f.f.d()) {
                    throw new FileDownloadNetworkPolicyException();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            if (0 != 0) {
                try {
                    d();
                } finally {
                    if (0 != 0) {
                        try {
                            aVar.b();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
            }
            throw th;
        }
    }
}
