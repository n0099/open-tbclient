package com.bytedance.sdk.openadsdk.video.a.a;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.video.d.c;
import d.b.c.a.b.a0;
import d.b.c.a.b.d;
import d.b.c.a.b.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public File f31070a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f31071b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public final Object f31072c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public long f31073d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f31074e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f31075f = false;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f31076g;

    /* renamed from: h  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f31077h;

    public b(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f31076g = null;
        this.f31077h = aVar;
        try {
            File a2 = c.a(context, aVar.b());
            this.f31070a = a2;
            boolean a3 = c.a(a2);
            this.f31076g = new RandomAccessFile(this.f31070a, a3 ? r.f7975a : "rw");
            if (a3) {
                return;
            }
            c();
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "Error using file ", aVar.a(), " as disc cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws IOException {
        synchronized (this.f31072c) {
            if (c.a(this.f31070a)) {
                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "complete: isCompleted ", this.f31077h.a(), this.f31077h.b());
                return;
            }
            File file = new File(this.f31070a.getParentFile(), this.f31070a.getName().substring(0, this.f31070a.getName().length() - 9));
            if (this.f31070a.renameTo(file)) {
                this.f31070a = file;
                if (this.f31076g != null) {
                    this.f31076g.close();
                }
                this.f31076g = new RandomAccessFile(this.f31070a, "rw");
                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "complete: rename ", this.f31077h.b(), this.f31077h.a());
                return;
            }
            throw new IOException("Error renaming file " + this.f31070a + " to " + file + " for completion!");
        }
    }

    public void c() {
        e.a(new g("executeNetRequest") { // from class: com.bytedance.sdk.openadsdk.video.a.a.b.1
            /* JADX WARN: Removed duplicated region for block: B:119:0x01c9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x019f A[Catch: all -> 0x0261, TryCatch #1 {all -> 0x0261, blocks: (B:5:0x0090, B:8:0x009a, B:27:0x00e8, B:28:0x00f4, B:30:0x0107, B:32:0x0112, B:37:0x0128, B:39:0x019f, B:40:0x01a5, B:48:0x01d0, B:51:0x0219, B:41:0x01a6, B:42:0x01c1, B:43:0x01c2), top: B:105:0x0090 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                d.b.c.a.b.c cVar;
                d dVar;
                boolean z;
                InputStream inputStream = null;
                try {
                    try {
                        b.this.f31073d = b.this.f31070a.length();
                        y yVar = new y();
                        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "RANGE, bytes=", Long.valueOf(b.this.f31073d), " file hash=", b.this.f31077h.b());
                        a0.a aVar = new a0.a();
                        aVar.g("RANGE", "bytes=" + b.this.f31073d + "-");
                        aVar.e(b.this.f31077h.a());
                        aVar.a();
                        cVar = yVar.c(aVar.p()).a();
                        try {
                            b.this.f31075f = cVar.s();
                            dVar = cVar.x();
                            try {
                                if (b.this.f31075f && dVar != null) {
                                    b.this.f31071b = dVar.o() + b.this.f31073d;
                                    inputStream = dVar.q();
                                }
                                if (inputStream == null) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (dVar != null) {
                                        dVar.close();
                                    }
                                    if (cVar != null) {
                                        cVar.close();
                                    }
                                    if (b.this.f31075f && b.this.f31070a.length() == b.this.f31071b) {
                                        b.this.d();
                                        return;
                                    }
                                    return;
                                }
                                byte[] bArr = new byte[16384];
                                long j = b.this.f31073d;
                                long j2 = 0;
                                long j3 = 0;
                                int i2 = 0;
                                while (true) {
                                    int read = inputStream.read(bArr, i2, 16384 - i2);
                                    if (read == -1) {
                                        break;
                                    }
                                    i2 += read;
                                    j3 += read;
                                    if (j3 % 16384 != j2 && j3 != b.this.f31071b - b.this.f31073d) {
                                        z = false;
                                        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i2), " totalLength = ", Long.valueOf(b.this.f31071b), " saveSize =", Long.valueOf(j3), " startSaved=", Long.valueOf(b.this.f31073d), " fileHash=", b.this.f31077h.b(), " url=", b.this.f31077h.a());
                                        if (!z) {
                                            synchronized (b.this.f31072c) {
                                                c.a(b.this.f31076g, bArr, Long.valueOf(j).intValue(), i2, b.this.f31077h.b());
                                            }
                                            j += i2;
                                            i2 = 0;
                                        }
                                        j2 = 0;
                                    }
                                    z = true;
                                    com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i2), " totalLength = ", Long.valueOf(b.this.f31071b), " saveSize =", Long.valueOf(j3), " startSaved=", Long.valueOf(b.this.f31073d), " fileHash=", b.this.f31077h.b(), " url=", b.this.f31077h.a());
                                    if (!z) {
                                    }
                                    j2 = 0;
                                }
                                Object[] objArr = new Object[10];
                                objArr[0] = "Write segment,Write over, startIndex =";
                                objArr[1] = Long.valueOf(b.this.f31073d);
                                objArr[2] = " totalLength = ";
                                objArr[3] = Long.valueOf(b.this.f31071b);
                                objArr[4] = " saveSize = ";
                                objArr[5] = Long.valueOf(j3);
                                objArr[6] = " writeEndSegment =";
                                objArr[7] = Boolean.valueOf(j3 == b.this.f31071b - b.this.f31073d);
                                objArr[8] = " url=";
                                objArr[9] = b.this.f31077h.a();
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", objArr);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (dVar != null) {
                                    dVar.close();
                                }
                                if (cVar != null) {
                                    cVar.close();
                                }
                                if (b.this.f31075f && b.this.f31070a.length() == b.this.f31071b) {
                                    b.this.d();
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    th.printStackTrace();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (dVar != null) {
                                        dVar.close();
                                    }
                                    if (cVar != null) {
                                        cVar.close();
                                    }
                                    if (b.this.f31075f && b.this.f31070a.length() == b.this.f31071b) {
                                        b.this.d();
                                    }
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            throw th2;
                                        }
                                    }
                                    if (dVar != null) {
                                        dVar.close();
                                    }
                                    if (cVar != null) {
                                        cVar.close();
                                    }
                                    if (b.this.f31075f && b.this.f31070a.length() == b.this.f31071b) {
                                        b.this.d();
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dVar = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cVar = null;
                        dVar = null;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.video.a.a.a
    public long b() throws IOException {
        if (c.a(this.f31070a)) {
            this.f31071b = this.f31070a.length();
        } else {
            synchronized (this.f31072c) {
                int i2 = 0;
                do {
                    if (this.f31071b == -2147483648L) {
                        try {
                            com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "totalLength: wait");
                            i2 += 15;
                            this.f31072c.wait(5L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i2 <= 20000);
                return -1L;
            }
        }
        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "totalLength= ", Long.valueOf(this.f31071b));
        return this.f31071b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0084, code lost:
        if (r11 <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        if (r0 <= 20000) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        r6 = 2;
        r8 = 1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:? -> B:31:0x009a). Please submit an issue!!! */
    @Override // com.bytedance.sdk.openadsdk.video.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(long j, byte[] bArr, int i2, int i3) throws IOException {
        char c2 = 2;
        int i4 = 1;
        try {
            try {
                if (j == this.f31071b) {
                    return -1;
                }
                int i5 = 0;
                int i6 = 0;
                while (!this.f31074e) {
                    synchronized (this.f31072c) {
                        try {
                            if (j < this.f31070a.length()) {
                                Object[] objArr = new Object[i4];
                                objArr[0] = "read:  read " + j + " success";
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", objArr);
                                this.f31076g.seek(j);
                                try {
                                    i6 = this.f31076g.read(bArr, i2, i3);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                Object[] objArr2 = new Object[4];
                                objArr2[0] = "read: wait at ";
                                objArr2[i4] = Long.valueOf(j);
                                objArr2[c2] = "  file size = ";
                                objArr2[3] = Long.valueOf(this.f31070a.length());
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", objArr2);
                                i5 += 33;
                                this.f31072c.wait(33L);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    try {
                        throw th;
                    } catch (IOException e2) {
                        e = e2;
                        throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(this.f31070a.length()), Integer.valueOf(bArr.length)), e);
                    }
                }
                return -1;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (InterruptedException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.video.a.a.a
    public void a() {
        try {
            if (!this.f31074e) {
                this.f31076g.close();
            }
        } finally {
            this.f31074e = true;
        }
        this.f31074e = true;
    }
}
