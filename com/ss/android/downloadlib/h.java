package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.a.a.a.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class h {
    private static volatile h pSA = null;
    private long f;
    private final List<com.ss.android.downloadlib.a.g> c = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.a.g> d = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<com.ss.android.a.a.b.a.a> pSB = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f12997b = new Handler(Looper.getMainLooper());

    private h() {
    }

    public static h eCM() {
        if (pSA == null) {
            synchronized (h.class) {
                if (pSA == null) {
                    pSA = new h();
                }
            }
        }
        return pSA;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.a())) {
            com.ss.android.downloadlib.a.g gVar = this.d.get(cVar.a());
            if (gVar != null) {
                gVar.iv(context).b(i, dVar).d(cVar).a();
            } else if (!this.c.isEmpty()) {
                b(context, i, dVar, cVar);
            } else {
                c(context, i, dVar, cVar);
            }
        }
    }

    public com.ss.android.downloadlib.a.f ZM(String str) {
        if (this.d == null || this.d.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        com.ss.android.downloadlib.a.g gVar = this.d.get(str);
        if (gVar instanceof com.ss.android.downloadlib.a.f) {
            return (com.ss.android.downloadlib.a.f) gVar;
        }
        return null;
    }

    private synchronized void b(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        if (this.c.size() <= 0) {
            c(context, i, dVar, cVar);
        } else {
            com.ss.android.downloadlib.a.g remove = this.c.remove(0);
            remove.iv(context).b(i, dVar).d(cVar).a();
            this.d.put(cVar.a(), remove);
        }
    }

    private void c(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        if (cVar != null) {
            com.ss.android.downloadlib.a.f fVar = new com.ss.android.downloadlib.a.f();
            fVar.iv(context).b(i, dVar).d(cVar).a();
            this.d.put(cVar.a(), fVar);
        }
    }

    public void a(String str, int i) {
        com.ss.android.downloadlib.a.g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            if (gVar.a(i)) {
                this.c.add(gVar);
                this.d.remove(str);
            }
            b();
        }
    }

    public void a(String str, boolean z) {
        com.ss.android.downloadlib.a.g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            gVar.a(z);
        }
    }

    public void c(String str, long j, int i) {
        a(str, j, i, null, null);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        a(str, j, i, bVar, aVar, null);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar, s sVar) {
        com.ss.android.downloadlib.a.g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.d.get(str)) != null) {
            gVar.b(bVar).b(aVar).a(sVar).a(j, i);
        }
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        if (aVar != null) {
            this.pSB.add(aVar);
        }
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= 120000) {
            this.f = currentTimeMillis;
            if (!this.c.isEmpty()) {
                c();
            }
        }
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.a.g gVar : this.c) {
            if (!gVar.b() && currentTimeMillis - gVar.d() > 120000) {
                gVar.g();
                arrayList.add(gVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.c.removeAll(arrayList);
        }
    }

    public void a(final com.ss.android.a.a.b.c cVar, @Nullable final com.ss.android.a.a.b.a aVar, @Nullable final com.ss.android.a.a.b.b bVar) {
        this.f12997b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.pSB.iterator();
                while (it.hasNext()) {
                    ((com.ss.android.a.a.b.a.a) it.next()).a(cVar, aVar, bVar);
                }
            }
        });
    }

    public void a(final com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.socialbase.downloader.e.a aVar, final String str) {
        this.f12997b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.pSB.iterator();
                while (it.hasNext()) {
                    ((com.ss.android.a.a.b.a.a) it.next()).a(cVar, aVar, str);
                }
            }
        });
    }

    public void a(final com.ss.android.socialbase.downloader.g.c cVar, final String str) {
        this.f12997b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.pSB.iterator();
                while (it.hasNext()) {
                    ((com.ss.android.a.a.b.a.a) it.next()).a(cVar, str);
                }
            }
        });
    }

    public void b(final com.ss.android.socialbase.downloader.g.c cVar, final String str) {
        this.f12997b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.pSB.iterator();
                while (it.hasNext()) {
                    ((com.ss.android.a.a.b.a.a) it.next()).b(cVar, str);
                }
            }
        });
    }

    public void a(final com.ss.android.socialbase.downloader.g.c cVar) {
        this.f12997b.post(new Runnable() { // from class: com.ss.android.downloadlib.h.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.pSB.iterator();
                while (it.hasNext()) {
                    ((com.ss.android.a.a.b.a.a) it.next()).a(cVar);
                }
            }
        });
    }
}
