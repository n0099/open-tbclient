package com.bytedance.sdk.openadsdk.k;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.k.b;
import com.bytedance.sdk.openadsdk.k.h;
import com.bytedance.sdk.openadsdk.k.i;
import com.bytedance.sdk.openadsdk.k.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
/* loaded from: classes5.dex */
public class g extends com.bytedance.sdk.openadsdk.k.a {
    public final Socket m;
    public final c n;
    public final d o;
    public volatile com.bytedance.sdk.openadsdk.k.b p;
    public volatile boolean q;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f30288a;

        /* renamed from: b  reason: collision with root package name */
        public int f30289b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30290c;

        public b(OutputStream outputStream, int i2) {
            this.f30288a = outputStream;
            this.f30289b = i2;
        }

        public boolean a() {
            return this.f30290c;
        }

        public void b(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.k.c.d {
            try {
                this.f30288a.write(bArr, i2, i3);
                this.f30289b += i3;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.k.c.d(e2);
            }
        }

        public void a(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.k.c.d {
            if (this.f30290c) {
                return;
            }
            try {
                this.f30288a.write(bArr, i2, i3);
                this.f30290c = true;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.k.c.d(e2);
            }
        }

        public int b() {
            return this.f30289b;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    public g(a aVar) {
        super(aVar.f30283a, aVar.f30284b);
        this.q = true;
        this.m = aVar.f30285c;
        this.n = aVar.f30286d;
        this.o = d.c();
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.k.c.d, VAdError {
        byte[] a2 = a(this.f30146b.a(this.f30152h, this.f30153i.f30304c.f30305a), bVar, aVar);
        if (a2 == null) {
            return;
        }
        bVar.a(a2, 0, a2.length);
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.k.c.d, IOException, com.bytedance.sdk.openadsdk.k.c.a, com.bytedance.sdk.openadsdk.k.c.b, VAdError {
        if (this.q) {
            File c2 = this.f30145a.c(this.f30152h);
            long length = c2.length();
            com.bytedance.sdk.openadsdk.k.b.a a2 = this.f30146b.a(this.f30152h, this.f30153i.f30304c.f30305a);
            int b2 = bVar.b();
            long j = length - b2;
            int i2 = (int) j;
            int i3 = a2 == null ? -1 : a2.f30177c;
            if (length > bVar.b()) {
                if (e.f30227c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                }
                a(true, i2, i3, (int) length, b2);
                a(a2, c2, bVar, aVar);
                return;
            }
            a(false, i2, i3, (int) length, b2);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ad A[EDGE_INSN: B:101:0x01ad->B:70:0x01ad ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104 A[Catch: all -> 0x01d9, TRY_LEAVE, TryCatch #2 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:94:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: all -> 0x01d9, TryCatch #2 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:94:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f A[Catch: all -> 0x01d5, TryCatch #1 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:92:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[Catch: all -> 0x01d5, TryCatch #1 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:92:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.k.c.d, IOException, com.bytedance.sdk.openadsdk.k.c.a, com.bytedance.sdk.openadsdk.k.c.b, VAdError {
        h hVar;
        byte[] bArr;
        InputStream d2;
        int i2;
        int read;
        i();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int b2 = bVar.b();
        com.bytedance.sdk.openadsdk.k.e.a a2 = a(aVar, b2, this.f30153i.f30304c.f30309e, "GET");
        if (a2 == null) {
            return;
        }
        h hVar2 = null;
        int i3 = 0;
        try {
            String a3 = com.bytedance.sdk.openadsdk.k.g.d.a(a2, false, true);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.k.b.a a4 = this.f30146b.a(this.f30152h, f());
                int a5 = com.bytedance.sdk.openadsdk.k.g.d.a(a2);
                if (a4 != null && a4.f30177c != a5) {
                    if (e.f30227c) {
                        Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + a4.f30177c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f30152h);
                    }
                    throw new com.bytedance.sdk.openadsdk.k.c.b("Content-Length not match, old length: " + a4.f30177c + ", new length: " + a5 + ", rawKey: " + this.f30151g + ", currentUrl: " + aVar + ", previousInfo: " + a4.f30179e);
                }
                if (!bVar.a()) {
                    String a6 = com.bytedance.sdk.openadsdk.k.g.d.a(a2, b2);
                    e();
                    byte[] bytes = a6.getBytes(com.bytedance.sdk.openadsdk.k.g.d.f30298a);
                    bVar.a(bytes, 0, bytes.length);
                }
                e();
                File d3 = this.f30145a.d(this.f30152h);
                try {
                    if (this.q && d3 != null && d3.length() >= bVar.b()) {
                        com.bytedance.sdk.openadsdk.k.g.d.a(a2, this.f30146b, this.f30152h, this.f30153i.f30304c.f30305a);
                        try {
                            hVar = new h(d3, "rwd");
                            try {
                                hVar.a(bVar.b());
                            } catch (h.a e2) {
                                e = e2;
                                e.printStackTrace();
                                hVar = null;
                                if (e.f30227c) {
                                }
                                com.bytedance.sdk.openadsdk.k.b.a a7 = this.f30146b.a(this.f30152h, f());
                                if (a7 != null) {
                                }
                                bArr = new byte[8192];
                                d2 = a2.d();
                                i2 = 0;
                                while (true) {
                                    try {
                                        read = d2.read(bArr);
                                        if (read >= 0) {
                                        }
                                        e();
                                    } catch (Throwable th) {
                                        th = th;
                                        hVar2 = hVar;
                                        i3 = i2;
                                        com.bytedance.sdk.openadsdk.k.g.d.a(a2.d());
                                        if (hVar2 != null) {
                                            hVar2.a();
                                        }
                                        this.f30147c.addAndGet(i3);
                                        this.f30148d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                        throw th;
                                    }
                                }
                                if (e.f30227c) {
                                }
                                c();
                                com.bytedance.sdk.openadsdk.k.g.d.a(a2.d());
                                if (hVar != null) {
                                }
                                this.f30147c.addAndGet(i2);
                                this.f30148d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                        } catch (h.a e3) {
                            e = e3;
                        }
                        if (e.f30227c) {
                            Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b());
                        }
                    } else {
                        if (e.f30227c) {
                            Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b());
                        }
                        hVar = null;
                    }
                    com.bytedance.sdk.openadsdk.k.b.a a72 = this.f30146b.a(this.f30152h, f());
                    int i4 = a72 != null ? 0 : a72.f30177c;
                    bArr = new byte[8192];
                    d2 = a2.d();
                    i2 = 0;
                    while (true) {
                        read = d2.read(bArr);
                        if (read >= 0) {
                            break;
                        }
                        e();
                        if (read > 0) {
                            bVar.b(bArr, 0, read);
                            i2 += read;
                            if (hVar != null) {
                                hVar.a(bArr, 0, read);
                            }
                            a(i4, bVar.b());
                        }
                        e();
                    }
                    if (e.f30227c) {
                        Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
                    }
                    c();
                    com.bytedance.sdk.openadsdk.k.g.d.a(a2.d());
                    if (hVar != null) {
                        hVar.a();
                    }
                    this.f30147c.addAndGet(i2);
                    this.f30148d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                } catch (Throwable th2) {
                    th = th2;
                    hVar2 = hVar;
                }
            } else {
                throw new com.bytedance.sdk.openadsdk.k.c.c(a3 + ", rawKey: " + this.f30151g + ", url: " + aVar);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private b h() {
        try {
            this.f30153i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bytedance.sdk.openadsdk.k.a.a aVar = this.f30153i.f30304c.f30305a == 1 ? e.f30225a : e.f30226b;
            if (aVar == null) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f30145a = aVar;
            this.f30151g = this.f30153i.f30304c.f30306b;
            this.f30152h = this.f30153i.f30304c.f30307c;
            this.j = new l(this.f30153i.f30304c.f30311g);
            this.f30150f = this.f30153i.f30303b;
            if (e.f30227c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.f30153i.toString());
            }
            return new b(outputStream, this.f30153i.f30304c.f30308d);
        } catch (i.d e2) {
            com.bytedance.sdk.openadsdk.k.g.d.a(this.m);
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.f30145a == null ? null : Boolean.valueOf(g()), this.f30151g, e2);
            return null;
        } catch (IOException e3) {
            com.bytedance.sdk.openadsdk.k.g.d.a(this.m);
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
            a(this.f30145a == null ? null : Boolean.valueOf(g()), this.f30151g, e3);
            return null;
        }
    }

    private void i() {
        com.bytedance.sdk.openadsdk.k.b bVar = this.p;
        this.p = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.openadsdk.k.b.a a2;
        b h2 = h();
        if (h2 == null) {
            return;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(this);
        }
        this.f30145a.a(this.f30152h);
        if (e.f30232h != 0 && ((a2 = this.f30146b.a(this.f30152h, this.f30153i.f30304c.f30305a)) == null || this.f30145a.c(this.f30152h).length() < a2.f30177c)) {
            this.o.a(g(), this.f30152h);
        }
        try {
            a(h2);
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.k.c.a e3) {
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
        } catch (Throwable th) {
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f30145a.b(this.f30152h);
        this.o.a(g(), null);
        a();
        com.bytedance.sdk.openadsdk.k.g.d.a(this.m);
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.a.a f30283a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.b.c f30284b;

        /* renamed from: c  reason: collision with root package name */
        public Socket f30285c;

        /* renamed from: d  reason: collision with root package name */
        public c f30286d;

        public a a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
            if (cVar != null) {
                this.f30284b = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public a a(Socket socket) {
            if (socket != null) {
                this.f30285c = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        public a a(c cVar) {
            this.f30286d = cVar;
            return this;
        }

        public g a() {
            if (this.f30284b != null && this.f30285c != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.k.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(bVar, b2);
                return true;
            } catch (com.bytedance.sdk.adnet.err.a e2) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
            } catch (com.bytedance.sdk.openadsdk.k.c.b e3) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.k.c.c e4) {
                b2.a();
                a(Boolean.valueOf(g()), this.f30151g, e4);
            } catch (com.bytedance.sdk.openadsdk.k.c.d e5) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return true;
            } catch (h.a e6) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
                this.q = false;
                a(Boolean.valueOf(g()), this.f30151g, e6);
            } catch (IOException e7) {
                if (e7 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.f30227c) {
                        if (ResponseException.CANCELED.equalsIgnoreCase(e7.getMessage())) {
                            Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.f30151g, e7);
                }
            } catch (Exception e8) {
                if (e.f30227c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.k.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.k.c.a, com.bytedance.sdk.openadsdk.k.c.b, VAdError {
        if ("HEAD".equalsIgnoreCase(this.f30153i.f30302a.f30314a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private byte[] a(com.bytedance.sdk.openadsdk.k.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        if (aVar != null) {
            if (e.f30227c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bytedance.sdk.openadsdk.k.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.k.g.d.f30298a);
        }
        com.bytedance.sdk.openadsdk.k.e.a a2 = a(aVar2, 0, -1, "HEAD");
        if (a2 == null) {
            return null;
        }
        try {
            String a3 = com.bytedance.sdk.openadsdk.k.g.d.a(a2, false, false);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.k.b.a a4 = com.bytedance.sdk.openadsdk.k.g.d.a(a2, this.f30146b, this.f30152h, this.f30153i.f30304c.f30305a);
                if (e.f30227c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return com.bytedance.sdk.openadsdk.k.g.d.a(a4, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.k.g.d.f30298a);
            }
            throw new com.bytedance.sdk.openadsdk.k.c.c(a3 + ", rawKey: " + this.f30151g + ", url: " + aVar2);
        } finally {
            com.bytedance.sdk.openadsdk.k.g.d.a(a2.d());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.k.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.k.c.d, h.a, com.bytedance.sdk.openadsdk.k.c.a, com.bytedance.sdk.openadsdk.k.c.b, VAdError {
        final com.bytedance.sdk.openadsdk.l.f fVar;
        com.bytedance.sdk.openadsdk.k.b bVar2;
        if (!bVar.a()) {
            byte[] a2 = a(aVar, bVar, aVar2);
            e();
            if (a2 == null) {
                return;
            }
            bVar.a(a2, 0, a2.length);
        }
        h hVar = null;
        if (aVar == null && (aVar = this.f30146b.a(this.f30152h, this.f30153i.f30304c.f30305a)) == null) {
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.k.b.a) null, bVar, aVar2);
            aVar = this.f30146b.a(this.f30152h, this.f30153i.f30304c.f30305a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.k.c.c("failed to get header, rawKey: " + this.f30151g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.f30177c || !((bVar2 = this.p) == null || bVar2.b() || bVar2.d())) {
            fVar = null;
        } else {
            com.bytedance.sdk.openadsdk.k.b a3 = new b.a().a(this.f30145a).a(this.f30146b).a(this.f30151g).b(this.f30152h).a(new l(aVar2.f30328a)).a(this.f30150f).a(this.f30153i).a(new b.InterfaceC0321b() { // from class: com.bytedance.sdk.openadsdk.k.g.1
                @Override // com.bytedance.sdk.openadsdk.k.b.InterfaceC0321b
                public void a(com.bytedance.sdk.openadsdk.k.b bVar3) {
                    g.this.f30147c.addAndGet(bVar3.f30147c.get());
                    g.this.f30148d.addAndGet(bVar3.f30148d.get());
                    synchronized (bVar3.m) {
                        bVar3.m.notifyAll();
                    }
                    if (bVar3.d()) {
                        g.this.o.a(g.this.g(), null);
                    }
                }
            }).a();
            this.p = a3;
            fVar = new com.bytedance.sdk.openadsdk.l.f(a3, null, 10, 1);
            com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("processCacheNetWorkConcurrent") { // from class: com.bytedance.sdk.openadsdk.k.g.2
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            if (e.f30227c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, r.f7975a);
            try {
                hVar2.a(bVar.b());
                int min = this.f30153i.f30304c.f30309e > 0 ? Math.min(aVar.f30177c, this.f30153i.f30304c.f30309e) : aVar.f30177c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar2.a(bArr);
                    if (a4 <= 0) {
                        com.bytedance.sdk.openadsdk.k.b bVar3 = this.p;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.k.c.b i2 = bVar3.i();
                            if (i2 == null) {
                                h.a h2 = bVar3.h();
                                if (h2 != null) {
                                    throw h2;
                                }
                            } else {
                                throw i2;
                            }
                        }
                        if (bVar3 != null && !bVar3.b() && !bVar3.d()) {
                            e();
                            synchronized (bVar3.m) {
                                try {
                                    bVar3.m.wait(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (e.f30227c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bytedance.sdk.openadsdk.k.c.c("illegal state download task has finished, rawKey: " + this.f30151g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, a4);
                    e();
                }
                if (e.f30227c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + StringUtil.ARRAY_ELEMENT_SEPARATOR + min);
                }
                c();
                hVar2.a();
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
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
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a() {
        super.a();
        i();
    }
}
