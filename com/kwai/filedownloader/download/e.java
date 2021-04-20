package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f37267a;

    /* renamed from: b  reason: collision with root package name */
    public final f f37268b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37269c;

    /* renamed from: d  reason: collision with root package name */
    public final int f37270d;

    /* renamed from: e  reason: collision with root package name */
    public final c f37271e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.filedownloader.a.b f37272f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37273g;

    /* renamed from: h  reason: collision with root package name */
    public final long f37274h;
    public final long i;
    public final long j;
    public final String k;
    public com.kwai.filedownloader.e.a l;
    public volatile boolean m;
    public final com.kwai.filedownloader.b.a n;
    public volatile long o;
    public volatile long p;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f37275a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.a.b f37276b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f37277c;

        /* renamed from: d  reason: collision with root package name */
        public f f37278d;

        /* renamed from: e  reason: collision with root package name */
        public String f37279e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f37280f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f37281g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f37282h;

        public a a(int i) {
            this.f37281g = Integer.valueOf(i);
            return this;
        }

        public a a(com.kwai.filedownloader.a.b bVar) {
            this.f37276b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37277c = aVar;
            return this;
        }

        public a a(c cVar) {
            this.f37275a = cVar;
            return this;
        }

        public a a(f fVar) {
            this.f37278d = fVar;
            return this;
        }

        public a a(String str) {
            this.f37279e = str;
            return this;
        }

        public a a(boolean z) {
            this.f37280f = Boolean.valueOf(z);
            return this;
        }

        public e a() {
            com.kwai.filedownloader.a.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.f37280f == null || (bVar = this.f37276b) == null || (aVar = this.f37277c) == null || this.f37278d == null || this.f37279e == null || (num = this.f37282h) == null || this.f37281g == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.f37275a, num.intValue(), this.f37281g.intValue(), this.f37280f.booleanValue(), this.f37278d, this.f37279e);
        }

        public a b(int i) {
            this.f37282h = Integer.valueOf(i);
            return this;
        }
    }

    public e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.f37268b = fVar;
        this.k = str;
        this.f37272f = bVar;
        this.f37273g = z;
        this.f37271e = cVar;
        this.f37270d = i2;
        this.f37269c = i;
        this.n = b.a().c();
        this.f37274h = aVar.f37232a;
        this.i = aVar.f37234c;
        this.f37267a = aVar.f37233b;
        this.j = aVar.f37235d;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.f.f.a(this.f37267a - this.o, elapsedRealtime - this.p)) {
            d();
            this.o = this.f37267a;
            this.p = elapsedRealtime;
        }
    }

    private void d() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.l.a();
            z = true;
        } catch (IOException e2) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            if (this.f37271e != null) {
                this.n.a(this.f37269c, this.f37270d, this.f37267a);
            } else {
                this.f37268b.c();
            }
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f37269c), Integer.valueOf(this.f37270d), Long.valueOf(this.f37267a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void a() {
        this.m = true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e7, code lost:
        throw new com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        Throwable th;
        com.kwai.filedownloader.e.a aVar;
        if (this.m) {
            return;
        }
        long b2 = com.kwai.filedownloader.f.f.b(this.f37270d, this.f37272f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f37269c), Integer.valueOf(this.f37270d)));
        }
        long j = this.j;
        char c2 = 3;
        if (j > 0 && b2 != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.i == 0 ? com.kwai.filedownloader.f.f.a("range[%d-)", Long.valueOf(this.f37267a)) : com.kwai.filedownloader.f.f.a("range[%d-%d)", Long.valueOf(this.f37267a), Long.valueOf(this.i)), Long.valueOf(this.j), Long.valueOf(b2), Integer.valueOf(this.f37269c), Integer.valueOf(this.f37270d)));
        }
        long j2 = this.f37267a;
        InputStream inputStream = null;
        try {
            boolean e2 = b.a().e();
            if (this.f37271e != null && !e2) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.f.f.l(this.k);
            try {
                this.l = aVar;
                if (e2) {
                    aVar.a(this.f37267a);
                }
                if (com.kwai.filedownloader.f.d.f37301a) {
                    com.kwai.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f37270d), Long.valueOf(this.f37274h), Long.valueOf(this.i), Long.valueOf(this.f37267a));
                }
                inputStream = this.f37272f.a();
                byte[] bArr = new byte[4096];
                if (this.m) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        try {
                            d();
                        } finally {
                        }
                    }
                    if (aVar != null) {
                        try {
                            aVar.b();
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                d();
                            } finally {
                                if (aVar != null) {
                                    try {
                                        aVar.b();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.b();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        long j3 = this.f37267a - j2;
                        if (b2 == -1 || b2 == j3) {
                            this.f37268b.a(this.f37271e, this.f37274h, this.i);
                            return;
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j3);
                        objArr[1] = Long.valueOf(b2);
                        objArr[2] = Long.valueOf(this.f37274h);
                        objArr[c2] = Long.valueOf(this.i);
                        objArr[4] = Long.valueOf(this.f37267a);
                        objArr[5] = Long.valueOf(j2);
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", objArr));
                    }
                    aVar.a(bArr, 0, read);
                    long j4 = read;
                    this.f37267a += j4;
                    this.f37268b.a(j4);
                    c();
                    if (this.m) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                d();
                            } finally {
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.b();
                                return;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    if (this.f37273g && com.kwai.filedownloader.f.f.d()) {
                        break;
                    }
                    c2 = 3;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (aVar != null) {
                    try {
                        d();
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.b();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                    }
                }
                if (aVar != null) {
                    try {
                        aVar.b();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
    }
}
