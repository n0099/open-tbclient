package com.bytedance.sdk.openadsdk.i;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.i.h;
import com.bytedance.sdk.openadsdk.i.i;
import com.bytedance.sdk.openadsdk.i.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.http.client.methods.HttpHead;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g extends com.bytedance.sdk.openadsdk.i.a {
    private final Socket m;
    private final c n;
    private final d o;
    private volatile com.bytedance.sdk.openadsdk.i.b p;
    private volatile boolean q;

    /* loaded from: classes6.dex */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    g(a aVar) {
        super(aVar.f4844a, aVar.b);
        this.q = true;
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = d.c();
    }

    private b h() {
        try {
            this.i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bytedance.sdk.openadsdk.i.a.a aVar = this.i.c.f4852a == 1 ? e.f4826a : e.b;
            if (aVar == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                    return null;
                }
                return null;
            }
            this.f4800a = aVar;
            this.g = this.i.c.b;
            this.h = this.i.c.c;
            this.j = new l(this.i.c.g);
            this.f = this.i.b;
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.i.toString());
            }
            return new b(outputStream, this.i.c.d);
        } catch (i.d e) {
            com.bytedance.sdk.openadsdk.i.g.d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            a(this.f4800a == null ? null : Boolean.valueOf(g()), this.g, e);
            return null;
        } catch (IOException e2) {
            com.bytedance.sdk.openadsdk.i.g.d.a(this.m);
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.f4800a == null ? null : Boolean.valueOf(g()), this.g, e2);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.openadsdk.i.b.a a2;
        b h = h();
        if (h != null) {
            if (this.n != null) {
                this.n.a(this);
            }
            this.f4800a.a(this.h);
            if (e.h != 0 && ((a2 = this.b.a(this.h, this.i.c.f4852a)) == null || this.f4800a.c(this.h).length() < a2.c)) {
                this.o.a(g(), this.h);
            }
            try {
                a(h);
            } catch (VAdError e) {
                e.printStackTrace();
            } catch (com.bytedance.sdk.openadsdk.i.c.a e2) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
                }
            }
            this.f4800a.b(this.h);
            this.o.a(g(), null);
            a();
            com.bytedance.sdk.openadsdk.i.g.d.a(this.m);
            if (this.n != null) {
                this.n.b(this);
            }
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.i.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(bVar, b2);
                return true;
            } catch (com.bytedance.sdk.adnet.err.a e) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
            } catch (com.bytedance.sdk.openadsdk.i.c.b e2) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.i.c.c e3) {
                b2.a();
                a(Boolean.valueOf(g()), this.g, e3);
            } catch (com.bytedance.sdk.openadsdk.i.c.d e4) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                    return true;
                }
                return true;
            } catch (h.a e5) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                this.q = false;
                a(Boolean.valueOf(g()), this.g, e5);
            } catch (IOException e6) {
                if (e6 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.c) {
                        if (ResponseException.CANCELED.equalsIgnoreCase(e6.getMessage())) {
                            Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.g, e6);
                }
            } catch (Exception e7) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.i.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        if (HttpHead.METHOD_NAME.equalsIgnoreCase(this.i.f4851a.f4854a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.i.c.d, VAdError {
        byte[] a2 = a(this.b.a(this.h, this.i.c.f4852a), bVar, aVar);
        if (a2 != null) {
            bVar.a(a2, 0, a2.length);
        }
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.i.c.d, IOException, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        if (this.q) {
            File c2 = this.f4800a.c(this.h);
            long length = c2.length();
            com.bytedance.sdk.openadsdk.i.b.a a2 = this.b.a(this.h, this.i.c.f4852a);
            int b2 = bVar.b();
            int i = (int) (length - b2);
            int i2 = a2 == null ? -1 : a2.c;
            if (length > bVar.b()) {
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - b2));
                }
                a(true, i, i2, (int) length, b2);
                a(a2, c2, bVar, aVar);
                return;
            }
            a(false, i, i2, (int) length, b2);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
    }

    private byte[] a(com.bytedance.sdk.openadsdk.i.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        if (aVar != null) {
            if (e.c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bytedance.sdk.openadsdk.i.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.i.g.d.f4848a);
        }
        com.bytedance.sdk.openadsdk.i.e.a a2 = a(aVar2, 0, -1, HttpHead.METHOD_NAME);
        if (a2 == null) {
            return null;
        }
        try {
            String a3 = com.bytedance.sdk.openadsdk.i.g.d.a(a2, false, false);
            if (a3 != null) {
                throw new com.bytedance.sdk.openadsdk.i.c.c(a3 + ", rawKey: " + this.g + ", url: " + aVar2);
            }
            com.bytedance.sdk.openadsdk.i.b.a a4 = com.bytedance.sdk.openadsdk.i.g.d.a(a2, this.b, this.h, this.i.c.f4852a);
            if (e.c) {
                Log.w("TAG_PROXY_ProxyTask", "get header from network");
            }
            return com.bytedance.sdk.openadsdk.i.g.d.a(a4, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.i.g.d.f4848a);
        } finally {
            com.bytedance.sdk.openadsdk.i.g.d.a(a2.d());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.i.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.i.c.d, h.a, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        final com.bytedance.sdk.openadsdk.j.f fVar;
        h hVar;
        com.bytedance.sdk.openadsdk.i.b bVar2;
        if (!bVar.a()) {
            byte[] a2 = a(aVar, bVar, aVar2);
            e();
            if (a2 != null) {
                bVar.a(a2, 0, a2.length);
            } else {
                return;
            }
        }
        if (aVar == null && (aVar = this.b.a(this.h, this.i.c.f4852a)) == null) {
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.i.b.a) null, bVar, aVar2);
            aVar = this.b.a(this.h, this.i.c.f4852a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.i.c.c("failed to get header, rawKey: " + this.g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.c || !((bVar2 = this.p) == null || bVar2.b() || bVar2.d())) {
            fVar = null;
        } else {
            com.bytedance.sdk.openadsdk.i.b a3 = new b.a().a(this.f4800a).a(this.b).a(this.g).b(this.h).a(new l(aVar2.f4857a)).a(this.f).a(this.i).a(new b.InterfaceC1035b() { // from class: com.bytedance.sdk.openadsdk.i.g.1
                @Override // com.bytedance.sdk.openadsdk.i.b.InterfaceC1035b
                public void a(com.bytedance.sdk.openadsdk.i.b bVar3) {
                    g.this.c.addAndGet(bVar3.c.get());
                    g.this.d.addAndGet(bVar3.d.get());
                    synchronized (bVar3.m) {
                        bVar3.m.notifyAll();
                    }
                    if (bVar3.d()) {
                        g.this.o.a(g.this.g(), null);
                    }
                }
            }).a();
            this.p = a3;
            fVar = new com.bytedance.sdk.openadsdk.j.f(a3, null, 10, 1);
            com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.i.g.2
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            if (e.c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            hVar = new h(file, "r");
            try {
                hVar.a(bVar.b());
                int min = this.i.c.e > 0 ? Math.min(aVar.c, this.i.c.e) : aVar.c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar.a(bArr);
                    if (a4 <= 0) {
                        com.bytedance.sdk.openadsdk.i.b bVar3 = this.p;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.i.c.b i = bVar3.i();
                            if (i != null) {
                                throw i;
                            }
                            h.a h = bVar3.h();
                            if (h != null) {
                                throw h;
                            }
                        }
                        if (bVar3 == null || bVar3.b() || bVar3.d()) {
                            if (e.c) {
                                Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                            }
                            throw new com.bytedance.sdk.openadsdk.i.c.c("illegal state download task has finished, rawKey: " + this.g + ", url: " + aVar2);
                        }
                        e();
                        synchronized (bVar3.m) {
                            try {
                                bVar3.m.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        bVar.b(bArr, 0, a4);
                    }
                    e();
                }
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + ", " + min);
                }
                c();
                if (hVar != null) {
                    hVar.a();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                    hVar.a();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            hVar = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [522=4] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x022f A[EDGE_INSN: B:102:0x022f->B:75:0x022f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015e A[Catch: all -> 0x025c, TRY_LEAVE, TryCatch #7 {all -> 0x025c, blocks: (B:35:0x0152, B:36:0x015a, B:38:0x015e, B:61:0x01cc), top: B:95:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa A[Catch: all -> 0x01c5, TryCatch #3 {all -> 0x01c5, blocks: (B:45:0x01a4, B:47:0x01aa, B:49:0x01af, B:54:0x01ba, B:55:0x01c1, B:75:0x022f, B:77:0x0233, B:78:0x023c, B:53:0x01b7), top: B:93:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0204 A[Catch: all -> 0x0260, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0260, blocks: (B:40:0x018c, B:43:0x019b, B:67:0x0204), top: B:100:0x018c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0233 A[Catch: all -> 0x01c5, TryCatch #3 {all -> 0x01c5, blocks: (B:45:0x01a4, B:47:0x01aa, B:49:0x01af, B:54:0x01ba, B:55:0x01c1, B:75:0x022f, B:77:0x0233, B:78:0x023c, B:53:0x01b7), top: B:93:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.i.c.d, IOException, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        h hVar;
        byte[] bArr;
        InputStream d;
        int i;
        int read;
        h hVar2;
        h hVar3 = null;
        int i2 = 0;
        i();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int b2 = bVar.b();
        com.bytedance.sdk.openadsdk.i.e.a a2 = a(aVar, b2, this.i.c.e, "GET");
        if (a2 == null) {
            return;
        }
        try {
            String a3 = com.bytedance.sdk.openadsdk.i.g.d.a(a2, false, true);
            if (a3 != null) {
                throw new com.bytedance.sdk.openadsdk.i.c.c(a3 + ", rawKey: " + this.g + ", url: " + aVar);
            }
            com.bytedance.sdk.openadsdk.i.b.a a4 = this.b.a(this.h, f());
            int a5 = com.bytedance.sdk.openadsdk.i.g.d.a(a2);
            if (a4 != null && a4.c != a5) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + a4.c + ", " + a5 + ", key: " + this.h);
                }
                throw new com.bytedance.sdk.openadsdk.i.c.b("Content-Length not match, old length: " + a4.c + ", new length: " + a5 + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + a4.e);
            }
            if (!bVar.a()) {
                String a6 = com.bytedance.sdk.openadsdk.i.g.d.a(a2, b2);
                e();
                byte[] bytes = a6.getBytes(com.bytedance.sdk.openadsdk.i.g.d.f4848a);
                bVar.a(bytes, 0, bytes.length);
            }
            e();
            File d2 = this.f4800a.d(this.h);
            if (!this.q || d2 == null || d2.length() < bVar.b()) {
                if (e.c) {
                    Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + d2.length() + ", from: " + bVar.b());
                }
                hVar = null;
            } else {
                com.bytedance.sdk.openadsdk.i.g.d.a(a2, this.b, this.h, this.i.c.f4852a);
                try {
                    hVar2 = new h(d2, "rwd");
                } catch (h.a e) {
                    e = e;
                }
                try {
                    try {
                        hVar2.a(bVar.b());
                    } catch (h.a e2) {
                        e = e2;
                        e.printStackTrace();
                        hVar2 = null;
                        if (e.c) {
                        }
                        com.bytedance.sdk.openadsdk.i.b.a a7 = this.b.a(this.h, f());
                        if (a7 != null) {
                        }
                        bArr = new byte[8192];
                        d = a2.d();
                        i = 0;
                        while (true) {
                            try {
                                read = d.read(bArr);
                                if (read >= 0) {
                                }
                                e();
                            } catch (Throwable th) {
                                th = th;
                                i2 = i;
                                hVar3 = hVar;
                                com.bytedance.sdk.openadsdk.i.g.d.a(a2.d());
                                if (hVar3 != null) {
                                    hVar3.a();
                                }
                                this.c.addAndGet(i2);
                                this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                throw th;
                            }
                        }
                        if (e.c) {
                        }
                        c();
                        com.bytedance.sdk.openadsdk.i.g.d.a(a2.d());
                        if (hVar != null) {
                        }
                        this.c.addAndGet(i);
                        this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                    }
                    if (e.c) {
                        hVar = hVar2;
                    } else {
                        Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + d2.length() + ", from: " + bVar.b());
                        hVar = hVar2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    hVar3 = hVar2;
                    com.bytedance.sdk.openadsdk.i.g.d.a(a2.d());
                    if (hVar3 != null) {
                    }
                    this.c.addAndGet(i2);
                    this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                    throw th;
                }
            }
            try {
                com.bytedance.sdk.openadsdk.i.b.a a72 = this.b.a(this.h, f());
                int i3 = a72 != null ? 0 : a72.c;
                bArr = new byte[8192];
                d = a2.d();
                i = 0;
                while (true) {
                    read = d.read(bArr);
                    if (read >= 0) {
                        break;
                    }
                    e();
                    if (read > 0) {
                        bVar.b(bArr, 0, read);
                        i += read;
                        if (hVar != null) {
                            hVar.a(bArr, 0, read);
                        }
                        a(i3, bVar.b());
                    }
                    e();
                }
                if (e.c) {
                    Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
                }
                c();
                com.bytedance.sdk.openadsdk.i.g.d.a(a2.d());
                if (hVar != null) {
                    hVar.a();
                }
                this.c.addAndGet(i);
                this.d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
            } catch (Throwable th3) {
                th = th3;
                hVar3 = hVar;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a
    public void a() {
        super.a();
        i();
    }

    private void i() {
        com.bytedance.sdk.openadsdk.i.b bVar = this.p;
        this.p = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final OutputStream f4846a;
        private int b;
        private boolean c;

        b(OutputStream outputStream, int i) {
            this.f4846a = outputStream;
            this.b = i;
        }

        boolean a() {
            return this.c;
        }

        void a(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.i.c.d {
            if (!this.c) {
                try {
                    this.f4846a.write(bArr, i, i2);
                    this.c = true;
                } catch (IOException e) {
                    throw new com.bytedance.sdk.openadsdk.i.c.d(e);
                }
            }
        }

        void b(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.i.c.d {
            try {
                this.f4846a.write(bArr, i, i2);
                this.b += i2;
            } catch (IOException e) {
                throw new com.bytedance.sdk.openadsdk.i.c.d(e);
            }
        }

        int b() {
            return this.b;
        }
    }

    /* loaded from: classes6.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.i.a.a f4844a;
        com.bytedance.sdk.openadsdk.i.b.c b;
        Socket c;
        c d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.i.b.c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.b = cVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.c = socket;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g a() {
            if (this.b == null || this.c == null) {
                throw new IllegalArgumentException();
            }
            return new g(this);
        }
    }
}
