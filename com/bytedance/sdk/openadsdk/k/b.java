package com.bytedance.sdk.openadsdk.k;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.k.h;
import com.bytedance.sdk.openadsdk.k.i;
import com.bytedance.sdk.openadsdk.k.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.bytedance.sdk.openadsdk.k.a {
    public final Object m;
    public final Object n;
    public final int o;
    public final InterfaceC0326b p;
    public volatile h.a q;
    public volatile com.bytedance.sdk.openadsdk.k.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0326b {
        void a(b bVar);
    }

    public b(a aVar) {
        super(aVar.f29276d, aVar.f29277e);
        this.o = aVar.f29279g;
        this.p = aVar.i;
        this.m = this;
        this.f29246g = aVar.f29273a;
        this.f29247h = aVar.f29274b;
        this.f29245f = aVar.f29278f;
        this.j = aVar.f29275c;
        this.i = aVar.f29280h;
        this.n = aVar.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018b, code lost:
        if (com.bytedance.sdk.openadsdk.k.e.f29318c == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018d, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r5 + ", max: " + r12.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ad, code lost:
        com.bytedance.sdk.openadsdk.k.g.d.a(r6.d());
        r4.a();
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01bc, code lost:
        if (com.bytedance.sdk.openadsdk.k.e.f29318c == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01be, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c5, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ca, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cf, code lost:
        if (com.bytedance.sdk.openadsdk.k.e.f29318c == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d1, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d8, code lost:
        com.bytedance.sdk.openadsdk.k.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e2, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l.a aVar) throws IOException, h.a, com.bytedance.sdk.openadsdk.k.c.a, com.bytedance.sdk.openadsdk.k.c.b, VAdError {
        File c2 = this.f29240a.c(this.f29247h);
        long length = c2.length();
        int i = this.o;
        if (i > 0 && length >= i) {
            if (e.f29318c) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.f29247h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int f2 = f();
        com.bytedance.sdk.openadsdk.k.b.a a2 = this.f29241b.a(this.f29247h, f2);
        if (a2 != null && length >= a2.f29270c) {
            if (e.f29318c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.f29247h);
                return;
            }
            return;
        }
        e();
        int i2 = (int) length;
        com.bytedance.sdk.openadsdk.k.e.a a3 = a(aVar, i2, this.o, "GET");
        if (a3 == null) {
            return;
        }
        h hVar = null;
        boolean z = true;
        try {
            e();
            String a4 = com.bytedance.sdk.openadsdk.k.g.d.a(a3, this.i == null && e.f29320e, true);
            if (a4 == null) {
                int a5 = com.bytedance.sdk.openadsdk.k.g.d.a(a3);
                if (a2 != null && a2.f29270c != a5) {
                    if (e.f29318c) {
                        Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.f29270c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f29247h);
                    }
                    throw new com.bytedance.sdk.openadsdk.k.c.b("Content-Length not match, old length: " + a2.f29270c + ", new length: " + a5 + ", rawKey: " + this.f29246g + ", currentUrl: " + aVar + ", previousInfo: " + a2.f29272e);
                }
                com.bytedance.sdk.openadsdk.k.g.d.a(a3, this.f29241b, this.f29247h, f2);
                com.bytedance.sdk.openadsdk.k.b.a a6 = this.f29241b.a(this.f29247h, f2);
                int i3 = a6 == null ? 0 : a6.f29270c;
                InputStream d2 = a3.d();
                h hVar2 = new h(c2, e.f29319d ? "rwd" : "rw");
                try {
                    hVar2.a(length);
                    if (e.f29318c) {
                        Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                    }
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = d2.read(bArr);
                        if (read >= 0) {
                            e();
                            if (read > 0) {
                                hVar2.a(bArr, 0, read);
                                i2 += read;
                                if (this.i != null) {
                                    synchronized (this.m) {
                                        this.m.notifyAll();
                                    }
                                }
                                this.f29242c.addAndGet(read);
                                a(i3, i2);
                            }
                            if (this.o > 0 && i2 >= this.o) {
                                break;
                            }
                            e();
                        } else {
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                                hVar = hVar2;
                                z = false;
                                com.bytedance.sdk.openadsdk.k.g.d.a(a3.d());
                                if (hVar != null) {
                                    hVar.a();
                                }
                                if (z) {
                                    a();
                                    if (e.f29318c) {
                                        Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    hVar = hVar2;
                }
            } else {
                throw new com.bytedance.sdk.openadsdk.k.c.c(a4 + ", rawKey: " + this.f29246g + ", url: " + aVar);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.k.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b2 = this.j.b();
            try {
                a(b2);
                return true;
            } catch (com.bytedance.sdk.openadsdk.k.c.b e2) {
                this.r = e2;
                if (e.f29318c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.k.c.c e3) {
                b2.a();
                a(Boolean.valueOf(g()), this.f29246g, e3);
            } catch (h.a e4) {
                this.q = e4;
                a(Boolean.valueOf(g()), this.f29246g, e4);
                return false;
            } catch (IOException e5) {
                if (e5 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.f29318c) {
                        if (ResponseException.CANCELED.equalsIgnoreCase(e5.getMessage())) {
                            Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e5));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.f29246g, e5);
                }
            } catch (Throwable th) {
                if (e.f29318c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                }
                return false;
            }
        }
        return false;
    }

    public h.a h() {
        return this.q;
    }

    public com.bytedance.sdk.openadsdk.k.c.b i() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f29240a.a(this.f29247h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.adnet.err.a e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.k.c.a e4) {
            if (e.f29318c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
            }
        } catch (Throwable th) {
            if (e.f29318c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.f29243d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f29240a.b(this.f29247h);
        InterfaceC0326b interfaceC0326b = this.p;
        if (interfaceC0326b != null) {
            interfaceC0326b.a(this);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29273a;

        /* renamed from: b  reason: collision with root package name */
        public String f29274b;

        /* renamed from: c  reason: collision with root package name */
        public l f29275c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.a.a f29276d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.b.c f29277e;

        /* renamed from: f  reason: collision with root package name */
        public List<i.b> f29278f;

        /* renamed from: g  reason: collision with root package name */
        public int f29279g;

        /* renamed from: h  reason: collision with root package name */
        public i f29280h;
        public InterfaceC0326b i;
        public Object j;

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f29273a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f29274b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        public a a(l lVar) {
            if (lVar != null) {
                this.f29275c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        public a a(com.bytedance.sdk.openadsdk.k.a.a aVar) {
            if (aVar != null) {
                this.f29276d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        public a a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
            if (cVar != null) {
                this.f29277e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public a a(List<i.b> list) {
            this.f29278f = list;
            return this;
        }

        public a a(int i) {
            this.f29279g = i;
            return this;
        }

        public a a(InterfaceC0326b interfaceC0326b) {
            this.i = interfaceC0326b;
            return this;
        }

        public a a(i iVar) {
            this.f29280h = iVar;
            return this;
        }

        public a a(Object obj) {
            this.j = obj;
            return this;
        }

        public b a() {
            if (this.f29276d != null && this.f29277e != null && !TextUtils.isEmpty(this.f29273a) && !TextUtils.isEmpty(this.f29274b) && this.f29275c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
