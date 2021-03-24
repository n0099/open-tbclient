package com.bytedance.sdk.openadsdk.video.a.a;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.video.d.c;
import d.c.c.a.b.a0;
import d.c.c.a.b.d;
import d.c.c.a.b.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public File f30459a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f30460b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public final Object f30461c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public long f30462d = 0;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f30463e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f30464f = false;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f30465g;

    /* renamed from: h  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30466h;

    public b(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30465g = null;
        this.f30466h = aVar;
        try {
            File a2 = c.a(context, aVar.b());
            this.f30459a = a2;
            boolean a3 = c.a(a2);
            this.f30465g = new RandomAccessFile(this.f30459a, a3 ? r.f7663a : "rw");
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
        synchronized (this.f30461c) {
            if (c.a(this.f30459a)) {
                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "complete: isCompleted ", this.f30466h.a(), this.f30466h.b());
                return;
            }
            File file = new File(this.f30459a.getParentFile(), this.f30459a.getName().substring(0, this.f30459a.getName().length() - 9));
            if (this.f30459a.renameTo(file)) {
                this.f30459a = file;
                if (this.f30465g != null) {
                    this.f30465g.close();
                }
                this.f30465g = new RandomAccessFile(this.f30459a, "rw");
                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "complete: rename ", this.f30466h.b(), this.f30466h.a());
                return;
            }
            throw new IOException("Error renaming file " + this.f30459a + " to " + file + " for completion!");
        }
    }

    public void c() {
        e.a(new g("executeNetRequest") { // from class: com.bytedance.sdk.openadsdk.video.a.a.b.1
            /* JADX WARN: Removed duplicated region for block: B:121:0x01c9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x019f A[Catch: all -> 0x0261, TryCatch #1 {all -> 0x0261, blocks: (B:5:0x0090, B:8:0x009a, B:27:0x00e8, B:28:0x00f4, B:30:0x0107, B:32:0x0112, B:37:0x0128, B:39:0x019f, B:40:0x01a5, B:48:0x01d0, B:51:0x0219, B:41:0x01a6, B:42:0x01c1, B:43:0x01c2), top: B:107:0x0090 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                d.c.c.a.b.c cVar;
                d dVar;
                boolean z;
                InputStream inputStream = null;
                try {
                    try {
                        b.this.f30462d = b.this.f30459a.length();
                        y yVar = new y();
                        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "RANGE, bytes=", Long.valueOf(b.this.f30462d), " file hash=", b.this.f30466h.b());
                        a0.a aVar = new a0.a();
                        aVar.g("RANGE", "bytes=" + b.this.f30462d + "-");
                        aVar.e(b.this.f30466h.a());
                        aVar.a();
                        cVar = yVar.c(aVar.p()).a();
                        try {
                            b.this.f30464f = cVar.s();
                            dVar = cVar.x();
                            try {
                                if (b.this.f30464f && dVar != null) {
                                    b.this.f30460b = dVar.o() + b.this.f30462d;
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
                                    if (b.this.f30464f && b.this.f30459a.length() == b.this.f30460b) {
                                        b.this.d();
                                        return;
                                    }
                                    return;
                                }
                                byte[] bArr = new byte[16384];
                                long j = b.this.f30462d;
                                long j2 = 0;
                                long j3 = 0;
                                int i = 0;
                                while (true) {
                                    int read = inputStream.read(bArr, i, 16384 - i);
                                    if (read == -1) {
                                        break;
                                    }
                                    i += read;
                                    j3 += read;
                                    if (j3 % 16384 != j2 && j3 != b.this.f30460b - b.this.f30462d) {
                                        z = false;
                                        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i), " totalLength = ", Long.valueOf(b.this.f30460b), " saveSize =", Long.valueOf(j3), " startSaved=", Long.valueOf(b.this.f30462d), " fileHash=", b.this.f30466h.b(), " url=", b.this.f30466h.a());
                                        if (!z) {
                                            synchronized (b.this.f30461c) {
                                                c.a(b.this.f30465g, bArr, Long.valueOf(j).intValue(), i, b.this.f30466h.b());
                                            }
                                            j += i;
                                            i = 0;
                                        }
                                        j2 = 0;
                                    }
                                    z = true;
                                    com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i), " totalLength = ", Long.valueOf(b.this.f30460b), " saveSize =", Long.valueOf(j3), " startSaved=", Long.valueOf(b.this.f30462d), " fileHash=", b.this.f30466h.b(), " url=", b.this.f30466h.a());
                                    if (!z) {
                                    }
                                    j2 = 0;
                                }
                                Object[] objArr = new Object[10];
                                objArr[0] = "Write segment,Write over, startIndex =";
                                objArr[1] = Long.valueOf(b.this.f30462d);
                                objArr[2] = " totalLength = ";
                                objArr[3] = Long.valueOf(b.this.f30460b);
                                objArr[4] = " saveSize = ";
                                objArr[5] = Long.valueOf(j3);
                                objArr[6] = " writeEndSegment =";
                                objArr[7] = Boolean.valueOf(j3 == b.this.f30460b - b.this.f30462d);
                                objArr[8] = " url=";
                                objArr[9] = b.this.f30466h.a();
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
                                if (b.this.f30464f && b.this.f30459a.length() == b.this.f30460b) {
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
                                    if (b.this.f30464f && b.this.f30459a.length() == b.this.f30460b) {
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
                                    if (b.this.f30464f && b.this.f30459a.length() == b.this.f30460b) {
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
        if (c.a(this.f30459a)) {
            this.f30460b = this.f30459a.length();
        } else {
            synchronized (this.f30461c) {
                int i = 0;
                do {
                    if (this.f30460b == -2147483648L) {
                        try {
                            com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "totalLength: wait");
                            i += 15;
                            this.f30461c.wait(5L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 20000);
                return -1L;
            }
        }
        com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", "totalLength= ", Long.valueOf(this.f30460b));
        return this.f30460b;
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:31:0x009a). Please submit an issue!!! */
    @Override // com.bytedance.sdk.openadsdk.video.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(long j, byte[] bArr, int i, int i2) throws IOException {
        char c2 = 2;
        int i3 = 1;
        try {
            try {
                if (j == this.f30460b) {
                    return -1;
                }
                int i4 = 0;
                int i5 = 0;
                while (!this.f30463e) {
                    synchronized (this.f30461c) {
                        try {
                            if (j < this.f30459a.length()) {
                                Object[] objArr = new Object[i3];
                                objArr[0] = "read:  read " + j + " success";
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", objArr);
                                this.f30465g.seek(j);
                                try {
                                    i5 = this.f30465g.read(bArr, i, i2);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                Object[] objArr2 = new Object[4];
                                objArr2[0] = "read: wait at ";
                                objArr2[i3] = Long.valueOf(j);
                                objArr2[c2] = "  file size = ";
                                objArr2[3] = Long.valueOf(this.f30459a.length());
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoCacheImpl", objArr2);
                                i4 += 33;
                                this.f30461c.wait(33L);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    try {
                        throw th;
                    } catch (IOException e2) {
                        e = e2;
                        throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(this.f30459a.length()), Integer.valueOf(bArr.length)), e);
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
            if (!this.f30463e) {
                this.f30465g.close();
            }
        } finally {
            this.f30463e = true;
        }
        this.f30463e = true;
    }
}
