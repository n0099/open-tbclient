package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f37741a;

    /* renamed from: b  reason: collision with root package name */
    public final f f37742b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37743c;

    /* renamed from: d  reason: collision with root package name */
    public final int f37744d;

    /* renamed from: e  reason: collision with root package name */
    public final c f37745e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.filedownloader.a.b f37746f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37747g;

    /* renamed from: h  reason: collision with root package name */
    public final long f37748h;

    /* renamed from: i  reason: collision with root package name */
    public final long f37749i;
    public final long j;
    public final String k;
    public com.kwai.filedownloader.e.a l;
    public volatile boolean m;
    public final com.kwai.filedownloader.b.a n;
    public volatile long o;
    public volatile long p;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f37750a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.a.b f37751b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f37752c;

        /* renamed from: d  reason: collision with root package name */
        public f f37753d;

        /* renamed from: e  reason: collision with root package name */
        public String f37754e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f37755f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f37756g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f37757h;

        public a a(int i2) {
            this.f37756g = Integer.valueOf(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.a.b bVar) {
            this.f37751b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f37752c = aVar;
            return this;
        }

        public a a(c cVar) {
            this.f37750a = cVar;
            return this;
        }

        public a a(f fVar) {
            this.f37753d = fVar;
            return this;
        }

        public a a(String str) {
            this.f37754e = str;
            return this;
        }

        public a a(boolean z) {
            this.f37755f = Boolean.valueOf(z);
            return this;
        }

        public e a() {
            com.kwai.filedownloader.a.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.f37755f == null || (bVar = this.f37751b) == null || (aVar = this.f37752c) == null || this.f37753d == null || this.f37754e == null || (num = this.f37757h) == null || this.f37756g == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.f37750a, num.intValue(), this.f37756g.intValue(), this.f37755f.booleanValue(), this.f37753d, this.f37754e);
        }

        public a b(int i2) {
            this.f37757h = Integer.valueOf(i2);
            return this;
        }
    }

    public e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.f37742b = fVar;
        this.k = str;
        this.f37746f = bVar;
        this.f37747g = z;
        this.f37745e = cVar;
        this.f37744d = i3;
        this.f37743c = i2;
        this.n = b.a().c();
        this.f37748h = aVar.f37705a;
        this.f37749i = aVar.f37707c;
        this.f37741a = aVar.f37706b;
        this.j = aVar.f37708d;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.f.f.a(this.f37741a - this.o, elapsedRealtime - this.p)) {
            d();
            this.o = this.f37741a;
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
            if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            if (this.f37745e != null) {
                this.n.a(this.f37743c, this.f37744d, this.f37741a);
            } else {
                this.f37742b.c();
            }
            if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f37743c), Integer.valueOf(this.f37744d), Long.valueOf(this.f37741a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
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
        long b2 = com.kwai.filedownloader.f.f.b(this.f37744d, this.f37746f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f37743c), Integer.valueOf(this.f37744d)));
        }
        long j = this.j;
        char c2 = 3;
        if (j > 0 && b2 != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f37749i == 0 ? com.kwai.filedownloader.f.f.a("range[%d-)", Long.valueOf(this.f37741a)) : com.kwai.filedownloader.f.f.a("range[%d-%d)", Long.valueOf(this.f37741a), Long.valueOf(this.f37749i)), Long.valueOf(this.j), Long.valueOf(b2), Integer.valueOf(this.f37743c), Integer.valueOf(this.f37744d)));
        }
        long j2 = this.f37741a;
        InputStream inputStream = null;
        try {
            boolean e2 = b.a().e();
            if (this.f37745e != null && !e2) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.f.f.l(this.k);
            try {
                this.l = aVar;
                if (e2) {
                    aVar.a(this.f37741a);
                }
                if (com.kwai.filedownloader.f.d.f37776a) {
                    com.kwai.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f37744d), Long.valueOf(this.f37748h), Long.valueOf(this.f37749i), Long.valueOf(this.f37741a));
                }
                inputStream = this.f37746f.a();
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
                        long j3 = this.f37741a - j2;
                        if (b2 == -1 || b2 == j3) {
                            this.f37742b.a(this.f37745e, this.f37748h, this.f37749i);
                            return;
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j3);
                        objArr[1] = Long.valueOf(b2);
                        objArr[2] = Long.valueOf(this.f37748h);
                        objArr[c2] = Long.valueOf(this.f37749i);
                        objArr[4] = Long.valueOf(this.f37741a);
                        objArr[5] = Long.valueOf(j2);
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", objArr));
                    }
                    aVar.a(bArr, 0, read);
                    long j4 = read;
                    this.f37741a += j4;
                    this.f37742b.a(j4);
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
                    if (this.f37747g && com.kwai.filedownloader.f.f.d()) {
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
