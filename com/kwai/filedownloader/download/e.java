package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f34328a;

    /* renamed from: b  reason: collision with root package name */
    public final f f34329b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34330c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34331d;

    /* renamed from: e  reason: collision with root package name */
    public final c f34332e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.filedownloader.a.b f34333f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f34334g;

    /* renamed from: h  reason: collision with root package name */
    public final long f34335h;

    /* renamed from: i  reason: collision with root package name */
    public final long f34336i;
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
        public c f34337a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.a.b f34338b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f34339c;

        /* renamed from: d  reason: collision with root package name */
        public f f34340d;

        /* renamed from: e  reason: collision with root package name */
        public String f34341e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f34342f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f34343g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f34344h;

        public a a(int i2) {
            this.f34343g = Integer.valueOf(i2);
            return this;
        }

        public a a(com.kwai.filedownloader.a.b bVar) {
            this.f34338b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            this.f34339c = aVar;
            return this;
        }

        public a a(c cVar) {
            this.f34337a = cVar;
            return this;
        }

        public a a(f fVar) {
            this.f34340d = fVar;
            return this;
        }

        public a a(String str) {
            this.f34341e = str;
            return this;
        }

        public a a(boolean z) {
            this.f34342f = Boolean.valueOf(z);
            return this;
        }

        public e a() {
            com.kwai.filedownloader.a.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.f34342f == null || (bVar = this.f34338b) == null || (aVar = this.f34339c) == null || this.f34340d == null || this.f34341e == null || (num = this.f34344h) == null || this.f34343g == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.f34337a, num.intValue(), this.f34343g.intValue(), this.f34342f.booleanValue(), this.f34340d, this.f34341e);
        }

        public a b(int i2) {
            this.f34344h = Integer.valueOf(i2);
            return this;
        }
    }

    public e(com.kwai.filedownloader.a.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.f34329b = fVar;
        this.k = str;
        this.f34333f = bVar;
        this.f34334g = z;
        this.f34332e = cVar;
        this.f34331d = i3;
        this.f34330c = i2;
        this.n = b.a().c();
        this.f34335h = aVar.f34292a;
        this.f34336i = aVar.f34294c;
        this.f34328a = aVar.f34293b;
        this.j = aVar.f34295d;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.f.f.a(this.f34328a - this.o, elapsedRealtime - this.p)) {
            d();
            this.o = this.f34328a;
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
            if (com.kwai.filedownloader.f.d.f34363a) {
                com.kwai.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            if (this.f34332e != null) {
                this.n.a(this.f34330c, this.f34331d, this.f34328a);
            } else {
                this.f34329b.c();
            }
            if (com.kwai.filedownloader.f.d.f34363a) {
                com.kwai.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f34330c), Integer.valueOf(this.f34331d), Long.valueOf(this.f34328a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
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
        long b2 = com.kwai.filedownloader.f.f.b(this.f34331d, this.f34333f);
        if (b2 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f34330c), Integer.valueOf(this.f34331d)));
        }
        long j = this.j;
        char c2 = 3;
        if (j > 0 && b2 != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f34336i == 0 ? com.kwai.filedownloader.f.f.a("range[%d-)", Long.valueOf(this.f34328a)) : com.kwai.filedownloader.f.f.a("range[%d-%d)", Long.valueOf(this.f34328a), Long.valueOf(this.f34336i)), Long.valueOf(this.j), Long.valueOf(b2), Integer.valueOf(this.f34330c), Integer.valueOf(this.f34331d)));
        }
        long j2 = this.f34328a;
        InputStream inputStream = null;
        try {
            boolean e2 = b.a().e();
            if (this.f34332e != null && !e2) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.f.f.l(this.k);
            try {
                this.l = aVar;
                if (e2) {
                    aVar.a(this.f34328a);
                }
                if (com.kwai.filedownloader.f.d.f34363a) {
                    com.kwai.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f34331d), Long.valueOf(this.f34335h), Long.valueOf(this.f34336i), Long.valueOf(this.f34328a));
                }
                inputStream = this.f34333f.a();
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
                        long j3 = this.f34328a - j2;
                        if (b2 == -1 || b2 == j3) {
                            this.f34329b.a(this.f34332e, this.f34335h, this.f34336i);
                            return;
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j3);
                        objArr[1] = Long.valueOf(b2);
                        objArr[2] = Long.valueOf(this.f34335h);
                        objArr[c2] = Long.valueOf(this.f34336i);
                        objArr[4] = Long.valueOf(this.f34328a);
                        objArr[5] = Long.valueOf(j2);
                        throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", objArr));
                    }
                    aVar.a(bArr, 0, read);
                    long j4 = read;
                    this.f34328a += j4;
                    this.f34329b.a(j4);
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
                    if (this.f34334g && com.kwai.filedownloader.f.f.d()) {
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
