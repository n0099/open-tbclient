package com.bytedance.sdk.openadsdk.j;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.j.h;
import com.bytedance.sdk.openadsdk.j.i;
import com.bytedance.sdk.openadsdk.j.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends com.bytedance.sdk.openadsdk.j.a {
    final Object m;
    final Object n;
    private final int o;
    private final InterfaceC1035b p;
    private volatile h.a q;
    private volatile com.bytedance.sdk.openadsdk.j.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1035b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.d, aVar.e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.m = this;
        this.g = aVar.f7535a;
        this.h = aVar.f7536b;
        this.f = aVar.f;
        this.j = aVar.c;
        this.i = aVar.h;
        this.n = aVar.j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7517a.a(this.h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.adnet.err.a e) {
            e.printStackTrace();
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.j.c.a e3) {
            if (e.c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e3));
            }
        } catch (Throwable th) {
            if (e.c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f7517a.b(this.h);
        if (this.p != null) {
            this.p.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h.a h() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.j.c.b i() {
        return this.r;
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.j.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(b2);
                return true;
            } catch (com.bytedance.sdk.openadsdk.j.c.b e) {
                this.r = e;
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e));
                    return false;
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.j.c.c e2) {
                b2.a();
                a(Boolean.valueOf(g()), this.g, e2);
            } catch (h.a e3) {
                this.q = e3;
                a(Boolean.valueOf(g()), this.g, e3);
                return false;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.c) {
                        if (ResponseException.CANCELED.equalsIgnoreCase(e4.getMessage())) {
                            Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.g, e4);
                }
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [231=5] */
    /* JADX WARN: Code restructure failed: missing block: B:113:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01fd, code lost:
        if (com.bytedance.sdk.openadsdk.j.e.c == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01ff, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r0 + ", max: " + r11.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0226, code lost:
        com.bytedance.sdk.openadsdk.j.g.d.a(r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022d, code lost:
        if (r2 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x022f, code lost:
        r2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0232, code lost:
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0237, code lost:
        if (com.bytedance.sdk.openadsdk.j.e.c == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0239, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x025a, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x025f, code lost:
        if (com.bytedance.sdk.openadsdk.j.e.c == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0261, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x026a, code lost:
        com.bytedance.sdk.openadsdk.j.g.d.a(r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0271, code lost:
        if (r2 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0273, code lost:
        r2.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l.a aVar) throws IOException, h.a, com.bytedance.sdk.openadsdk.j.c.a, com.bytedance.sdk.openadsdk.j.c.b, VAdError {
        boolean z = true;
        File c = this.f7517a.c(this.h);
        long length = c.length();
        if (this.o > 0 && length >= this.o) {
            if (e.c) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int f = f();
        com.bytedance.sdk.openadsdk.j.b.a a2 = this.f7518b.a(this.h, f);
        if (a2 != null && length >= a2.c) {
            if (e.c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.h);
                return;
            }
            return;
        }
        e();
        com.bytedance.sdk.openadsdk.j.e.a a3 = a(aVar, (int) length, this.o, "GET");
        if (a3 == null) {
            return;
        }
        h hVar = null;
        try {
            e();
            String a4 = com.bytedance.sdk.openadsdk.j.g.d.a(a3, this.i == null && e.e, true);
            if (a4 != null) {
                throw new com.bytedance.sdk.openadsdk.j.c.c(a4 + ", rawKey: " + this.g + ", url: " + aVar);
            }
            int a5 = com.bytedance.sdk.openadsdk.j.g.d.a(a3);
            if (a2 != null && a2.c != a5) {
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.c + ", " + a5 + ", key: " + this.h);
                }
                throw new com.bytedance.sdk.openadsdk.j.c.b("Content-Length not match, old length: " + a2.c + ", new length: " + a5 + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + a2.e);
            }
            com.bytedance.sdk.openadsdk.j.g.d.a(a3, this.f7518b, this.h, f);
            com.bytedance.sdk.openadsdk.j.b.a a6 = this.f7518b.a(this.h, f);
            int i = a6 == null ? 0 : a6.c;
            InputStream d = a3.d();
            h hVar2 = new h(c, e.d ? "rwd" : "rw");
            try {
                hVar2.a(length);
                if (e.c) {
                    Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                }
                byte[] bArr = new byte[8192];
                int i2 = (int) length;
                while (true) {
                    int read = d.read(bArr);
                    if (read < 0) {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                            hVar = hVar2;
                            z = false;
                            com.bytedance.sdk.openadsdk.j.g.d.a(a3.d());
                            if (hVar != null) {
                                hVar.a();
                            }
                            if (z) {
                                a();
                                if (e.c) {
                                    Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                }
                            }
                            throw th;
                        }
                    }
                    e();
                    if (read > 0) {
                        hVar2.a(bArr, 0, read);
                        i2 += read;
                        if (this.i != null) {
                            synchronized (this.m) {
                                this.m.notifyAll();
                            }
                        }
                        this.c.addAndGet(read);
                        a(i, i2);
                    }
                    if (this.o > 0 && i2 >= this.o) {
                        break;
                    }
                    e();
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f7535a;

        /* renamed from: b  reason: collision with root package name */
        String f7536b;
        l c;
        com.bytedance.sdk.openadsdk.j.a.a d;
        com.bytedance.sdk.openadsdk.j.b.c e;
        List<i.b> f;
        int g;
        i h;
        InterfaceC1035b i;
        Object j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f7535a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.f7536b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(l lVar) {
            if (lVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.c = lVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.j.a.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.d = aVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.j.b.c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.e = cVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(List<i.b> list) {
            this.f = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i) {
            this.g = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(InterfaceC1035b interfaceC1035b) {
            this.i = interfaceC1035b;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(i iVar) {
            this.h = iVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Object obj) {
            this.j = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a() {
            if (this.d == null || this.e == null || TextUtils.isEmpty(this.f7535a) || TextUtils.isEmpty(this.f7536b) || this.c == null) {
                throw new IllegalArgumentException();
            }
            return new b(this);
        }
    }
}
