package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public final com.ss.android.socialbase.downloader.i.h<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f60474b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f60475c;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<InetAddress> a;

        /* renamed from: b  reason: collision with root package name */
        public long f60482b;

        public b() {
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2240c {
        public static final c a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        r10 = r2.a;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:2:0x0000, B:3:0x000a, B:7:0x0016, B:10:0x0034, B:12:0x003a, B:14:0x0052, B:21:0x0063, B:29:0x0078, B:32:0x007f, B:35:0x0087, B:37:0x008e, B:34:0x0085, B:23:0x0069, B:24:0x006d, B:4:0x000b, B:5:0x0013, B:16:0x0058), top: B:45:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(final String str, final a aVar, long j2) {
        final b bVar;
        f u;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.a) {
                bVar = this.a.get(host);
            }
            if (bVar != null) {
                if (System.currentTimeMillis() - bVar.f60482b < com.ss.android.socialbase.downloader.g.a.c().a("dns_expire_min", 10) * 60 * 1000) {
                    if (aVar != null) {
                        aVar.a(str, bVar.a);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.2
                @Override // java.lang.Runnable
                public void run() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        String str2 = str;
                        b bVar2 = bVar;
                        aVar2.a(str2, bVar2 == null ? null : bVar2.a);
                    }
                }
            };
            this.f60475c.postDelayed(runnable, j2);
            List<InetAddress> list = null;
            if (com.ss.android.socialbase.downloader.g.a.c().a("use_host_dns", 1) == 1 && (u = com.ss.android.socialbase.downloader.downloader.c.u()) != null) {
                list = u.a(host);
            }
            if (list == null || list.isEmpty()) {
                list = com.ss.android.socialbase.downloader.downloader.c.v().a(host);
            }
            if (list != null && !list.isEmpty()) {
                a(host, list);
                this.f60475c.removeCallbacks(runnable);
                if (aVar == null) {
                    aVar.a(str, list);
                    return;
                }
                return;
            }
            this.f60475c.removeCallbacks(runnable);
            if (aVar == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public c() {
        this.a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.f60474b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.f60475c = new Handler(com.ss.android.socialbase.downloader.h.e.a());
    }

    public static c a() {
        return C2240c.a;
    }

    public void a(final String str, final a aVar, final long j2) {
        this.f60474b.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(str, aVar, j2);
            }
        });
    }

    private void a(String str, List<InetAddress> list) {
        synchronized (this.a) {
            b bVar = this.a.get(str);
            if (bVar == null) {
                bVar = new b();
                this.a.put(str, bVar);
            }
            bVar.a = list;
            bVar.f60482b = System.currentTimeMillis();
        }
    }
}
