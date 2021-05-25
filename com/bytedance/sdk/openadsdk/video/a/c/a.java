package com.bytedance.sdk.openadsdk.video.a.c;

import android.content.Context;
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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f30255a;

    /* renamed from: b  reason: collision with root package name */
    public int f30256b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30257c;

    /* renamed from: e  reason: collision with root package name */
    public File f30259e;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f30258d = false;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0322a f30260f = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0322a {
        void a(int i2, com.bytedance.sdk.openadsdk.video.b.a aVar);

        void a(int i2, String str);
    }

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar, int i2) {
        this.f30259e = null;
        this.f30255a = context;
        this.f30256b = i2;
        this.f30257c = aVar;
        this.f30259e = c.a(context, aVar.b());
    }

    public boolean a() {
        return this.f30259e.exists() && this.f30259e.length() != 0;
    }

    public void b() {
        if (a()) {
            com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Cache file is exist");
            InterfaceC0322a interfaceC0322a = this.f30260f;
            if (interfaceC0322a != null) {
                interfaceC0322a.a(200, this.f30257c);
                return;
            }
            return;
        }
        e.a(new g("executePreLoadIfNotExist") { // from class: com.bytedance.sdk.openadsdk.video.a.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                InputStream inputStream;
                d dVar;
                long j;
                y yVar = new y();
                a0.a aVar = new a0.a();
                aVar.g("RANGE", "bytes=0-" + a.this.f30256b);
                aVar.e(a.this.f30257c.a());
                aVar.a();
                d.b.c.a.b.c cVar = null;
                InputStream inputStream2 = null;
                try {
                    try {
                        d.b.c.a.b.c a2 = yVar.c(aVar.p()).a();
                        try {
                            if (!a2.s()) {
                                if (a.this.f30260f != null) {
                                    a.this.f30260f.a(a2.r(), a2.t());
                                }
                                if (a2 != null) {
                                    try {
                                        a2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Pre finally ", a.this.f30257c.a(), " Preload size=", Integer.valueOf(a.this.f30256b));
                                return;
                            }
                            dVar = a2.x();
                            try {
                                boolean s = a2.s();
                                d x = a2.x();
                                if (!s || x == null) {
                                    j = 0;
                                } else {
                                    j = x.o();
                                    inputStream2 = x.q();
                                }
                                if (inputStream2 == null) {
                                    if (a.this.f30260f != null) {
                                        a.this.f30260f.a(a2.r(), a2.t());
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (x != null) {
                                        x.close();
                                    }
                                    if (a2 != null) {
                                        a2.close();
                                    }
                                    com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Pre finally ", a.this.f30257c.a(), " Preload size=", Integer.valueOf(a.this.f30256b));
                                    return;
                                }
                                RandomAccessFile randomAccessFile = new RandomAccessFile(a.this.f30259e, "rw");
                                byte[] bArr = new byte[16384];
                                long j2 = 0;
                                int i2 = 0;
                                int i3 = 0;
                                while (true) {
                                    int read = inputStream2.read(bArr, i2, 16384 - i2);
                                    if (read == -1) {
                                        break;
                                    } else if (a.this.f30258d) {
                                        if (a.this.f30260f != null) {
                                            a.this.f30260f.a(a2.r(), a.this.f30257c);
                                        }
                                    } else {
                                        i2 += read;
                                        j2 += read;
                                        if (j2 % 16384 != 0 && j2 != j) {
                                        }
                                        c.a(randomAccessFile, bArr, Long.valueOf(i3).intValue(), i2, a.this.f30257c.b());
                                        i3 += i2;
                                        i2 = 0;
                                    }
                                }
                                if (a.this.f30260f != null) {
                                    a.this.f30260f.a(a2.r(), a.this.f30257c);
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (x != null) {
                                    x.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                                com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Pre finally ", a.this.f30257c.a(), " Preload size=", Integer.valueOf(a.this.f30256b));
                            } catch (Throwable th) {
                                th = th;
                                cVar = a2;
                                inputStream = null;
                                try {
                                    th.printStackTrace();
                                    if (a.this.f30260f != null) {
                                        a.this.f30260f.a(cVar.r(), th.getMessage());
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (dVar != null) {
                                        dVar.close();
                                    }
                                    if (cVar != null) {
                                        cVar.close();
                                    }
                                    com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Pre finally ", a.this.f30257c.a(), " Preload size=", Integer.valueOf(a.this.f30256b));
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                            throw th2;
                                        }
                                    }
                                    if (dVar != null) {
                                        dVar.close();
                                    }
                                    if (cVar != null) {
                                        cVar.close();
                                    }
                                    com.bytedance.sdk.openadsdk.video.d.a.b("VideoPreload", "Pre finally ", a.this.f30257c.a(), " Preload size=", Integer.valueOf(a.this.f30256b));
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dVar = null;
                            cVar = a2;
                            inputStream = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                        dVar = null;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        });
    }

    public void a(boolean z) {
        this.f30258d = z;
    }
}
