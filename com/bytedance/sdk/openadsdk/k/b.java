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
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.k.a {
    public final Object m;
    public final Object n;
    public final int o;
    public final InterfaceC0311b p;
    public volatile h.a q;
    public volatile com.bytedance.sdk.openadsdk.k.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0311b {
        void a(b bVar);
    }

    public b(a aVar) {
        super(aVar.f29460d, aVar.f29461e);
        this.o = aVar.f29463g;
        this.p = aVar.f29465i;
        this.m = this;
        this.f29428g = aVar.f29457a;
        this.f29429h = aVar.f29458b;
        this.f29427f = aVar.f29462f;
        this.j = aVar.f29459c;
        this.f29430i = aVar.f29464h;
        this.n = aVar.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018b, code lost:
        if (com.bytedance.sdk.openadsdk.k.e.f29504c == false) goto L74;
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
        if (com.bytedance.sdk.openadsdk.k.e.f29504c == false) goto L78;
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
        if (com.bytedance.sdk.openadsdk.k.e.f29504c == false) goto L87;
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
        File c2 = this.f29422a.c(this.f29429h);
        long length = c2.length();
        int i2 = this.o;
        if (i2 > 0 && length >= i2) {
            if (e.f29504c) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.f29429h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int f2 = f();
        com.bytedance.sdk.openadsdk.k.b.a a2 = this.f29423b.a(this.f29429h, f2);
        if (a2 != null && length >= a2.f29454c) {
            if (e.f29504c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.f29429h);
                return;
            }
            return;
        }
        e();
        int i3 = (int) length;
        com.bytedance.sdk.openadsdk.k.e.a a3 = a(aVar, i3, this.o, "GET");
        if (a3 == null) {
            return;
        }
        h hVar = null;
        boolean z = true;
        try {
            e();
            String a4 = com.bytedance.sdk.openadsdk.k.g.d.a(a3, this.f29430i == null && e.f29506e, true);
            if (a4 == null) {
                int a5 = com.bytedance.sdk.openadsdk.k.g.d.a(a3);
                if (a2 != null && a2.f29454c != a5) {
                    if (e.f29504c) {
                        Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.f29454c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f29429h);
                    }
                    throw new com.bytedance.sdk.openadsdk.k.c.b("Content-Length not match, old length: " + a2.f29454c + ", new length: " + a5 + ", rawKey: " + this.f29428g + ", currentUrl: " + aVar + ", previousInfo: " + a2.f29456e);
                }
                com.bytedance.sdk.openadsdk.k.g.d.a(a3, this.f29423b, this.f29429h, f2);
                com.bytedance.sdk.openadsdk.k.b.a a6 = this.f29423b.a(this.f29429h, f2);
                int i4 = a6 == null ? 0 : a6.f29454c;
                InputStream d2 = a3.d();
                h hVar2 = new h(c2, e.f29505d ? "rwd" : "rw");
                try {
                    hVar2.a(length);
                    if (e.f29504c) {
                        Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                    }
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = d2.read(bArr);
                        if (read >= 0) {
                            e();
                            if (read > 0) {
                                hVar2.a(bArr, 0, read);
                                i3 += read;
                                if (this.f29430i != null) {
                                    synchronized (this.m) {
                                        this.m.notifyAll();
                                    }
                                }
                                this.f29424c.addAndGet(read);
                                a(i4, i3);
                            }
                            if (this.o > 0 && i3 >= this.o) {
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
                                    if (e.f29504c) {
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
                throw new com.bytedance.sdk.openadsdk.k.c.c(a4 + ", rawKey: " + this.f29428g + ", url: " + aVar);
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
                if (e.f29504c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.k.c.c e3) {
                b2.a();
                a(Boolean.valueOf(g()), this.f29428g, e3);
            } catch (h.a e4) {
                this.q = e4;
                a(Boolean.valueOf(g()), this.f29428g, e4);
                return false;
            } catch (IOException e5) {
                if (e5 instanceof SocketTimeoutException) {
                    b2.b();
                }
                if (b()) {
                    if (e.f29504c) {
                        if (ResponseException.CANCELED.equalsIgnoreCase(e5.getMessage())) {
                            Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e5));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.f29428g, e5);
                }
            } catch (Throwable th) {
                if (e.f29504c) {
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
        this.f29422a.a(this.f29429h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.adnet.err.a e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.k.c.a e4) {
            if (e.f29504c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
            }
        } catch (Throwable th) {
            if (e.f29504c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.f29425d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f29422a.b(this.f29429h);
        InterfaceC0311b interfaceC0311b = this.p;
        if (interfaceC0311b != null) {
            interfaceC0311b.a(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29457a;

        /* renamed from: b  reason: collision with root package name */
        public String f29458b;

        /* renamed from: c  reason: collision with root package name */
        public l f29459c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.a.a f29460d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.b.c f29461e;

        /* renamed from: f  reason: collision with root package name */
        public List<i.b> f29462f;

        /* renamed from: g  reason: collision with root package name */
        public int f29463g;

        /* renamed from: h  reason: collision with root package name */
        public i f29464h;

        /* renamed from: i  reason: collision with root package name */
        public InterfaceC0311b f29465i;
        public Object j;

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f29457a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f29458b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        public a a(l lVar) {
            if (lVar != null) {
                this.f29459c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        public a a(com.bytedance.sdk.openadsdk.k.a.a aVar) {
            if (aVar != null) {
                this.f29460d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        public a a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
            if (cVar != null) {
                this.f29461e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public a a(List<i.b> list) {
            this.f29462f = list;
            return this;
        }

        public a a(int i2) {
            this.f29463g = i2;
            return this;
        }

        public a a(InterfaceC0311b interfaceC0311b) {
            this.f29465i = interfaceC0311b;
            return this;
        }

        public a a(i iVar) {
            this.f29464h = iVar;
            return this;
        }

        public a a(Object obj) {
            this.j = obj;
            return this;
        }

        public b a() {
            if (this.f29460d != null && this.f29461e != null && !TextUtils.isEmpty(this.f29457a) && !TextUtils.isEmpty(this.f29458b) && this.f29459c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
