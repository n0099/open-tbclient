package com.ss.android.socialbase.downloader.impls;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.l.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes4.dex */
public abstract class a implements f.a {

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> f13480b = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> Au = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> d = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> e = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> f = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.m.f<Integer, com.ss.android.socialbase.downloader.g.d> qaP = new com.ss.android.socialbase.downloader.m.f<>();
    private final SparseArray<Long> h = new SparseArray<>();
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> qaQ = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.l.f qaS = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.k qaR = com.ss.android.socialbase.downloader.downloader.b.eHJ();

    protected abstract com.ss.android.socialbase.downloader.l.c Ta(int i);

    protected abstract List<Integer> a();

    public abstract void a(int i, long j);

    protected abstract void a(int i, com.ss.android.socialbase.downloader.g.d dVar);

    public abstract void a(com.ss.android.socialbase.downloader.l.c cVar);

    public abstract boolean a(int i);

    protected abstract void b(int i);

    private void a(com.ss.android.socialbase.downloader.g.d dVar, boolean z) {
        com.ss.android.socialbase.downloader.g.c a2;
        boolean z2;
        int i;
        com.ss.android.socialbase.downloader.g.c a3;
        com.ss.android.socialbase.downloader.g.d dVar2;
        if (dVar != null && (a2 = dVar.a()) != null) {
            if (a2.aW()) {
                com.ss.android.socialbase.downloader.h.a.a(dVar.eJB(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "downloadInfo is Invalid, url is " + a2.j() + " name is " + a2.h() + " savePath is " + a2.k()), a2 != null ? a2.q() : 0);
                return;
            }
            int g = a2.g();
            if (z) {
                a(a2);
            }
            synchronized (this.d) {
                if (this.d.get(g) != null) {
                    this.d.remove(g);
                }
            }
            synchronized (this.Au) {
                if (this.Au.get(g) != null) {
                    this.Au.remove(g);
                }
            }
            synchronized (this.e) {
                if (this.e.get(g) != null) {
                    this.e.remove(g);
                }
            }
            synchronized (this.f) {
                if (this.f.get(g) != null) {
                    this.f.remove(g);
                }
            }
            if (com.ss.android.socialbase.downloader.m.a.a(512) && a(g)) {
                synchronized (this.f13480b) {
                    com.ss.android.socialbase.downloader.g.d dVar3 = this.f13480b.get(g);
                    if (dVar3 != null) {
                        dVar3.a(dVar);
                    } else {
                        this.f13480b.put(g, dVar);
                    }
                }
            }
            if (a(g) && !a2.eIR()) {
                com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
                if (a2.ai()) {
                    dVar.p();
                }
                com.ss.android.socialbase.downloader.h.a.a(dVar.eJB(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), a2 != null ? a2.q() : 0);
                return;
            }
            if (a2.eIR()) {
                a2.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_RESTART);
            }
            if (com.ss.android.socialbase.downloader.m.a.a(32768)) {
                synchronized (this.qaP) {
                    dVar2 = (com.ss.android.socialbase.downloader.g.d) this.qaP.remove(Integer.valueOf(g));
                }
                if (dVar2 != null) {
                    dVar.b(dVar2);
                }
            }
            synchronized (this.f13480b) {
                Long l = this.h.get(g);
                long longValue = l != null ? l.longValue() : 0L;
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - longValue < 50) {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.f13480b.get(g);
                    if (dVar4 == null || (a3 = dVar4.a()) == null) {
                        z2 = false;
                        i = 0;
                    } else {
                        i = a3.q();
                        z2 = i == 0 && com.ss.android.socialbase.downloader.b.f.b(i);
                    }
                    if (z2) {
                        com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "can add listener, oldTaskStatus is :" + i);
                        if (i >= 0 && i < 2) {
                            dVar.p();
                        } else if (a2.ai()) {
                            dVar.p();
                        } else {
                            com.ss.android.socialbase.downloader.h.a.a(dVar.eJB(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task within 50 milliseconds and addListenerToSameTask is false"), a2 != null ? a2.q() : 0);
                            this.f13480b.put(g, dVar);
                            this.h.put(g, Long.valueOf(uptimeMillis));
                            a(g, dVar);
                        }
                    } else {
                        this.f13480b.put(g, dVar);
                        this.h.put(g, Long.valueOf(uptimeMillis));
                        a(g, dVar);
                    }
                } else {
                    this.f13480b.put(g, dVar);
                    this.h.put(g, Long.valueOf(uptimeMillis));
                    a(g, dVar);
                }
            }
        }
    }

    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        com.ss.android.socialbase.downloader.g.c a2;
        if (dVar != null && (a2 = dVar.a()) != null) {
            a2.d(false);
            if (a2.eIq() != com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE) {
                b(dVar);
            } else {
                a(dVar, true);
            }
        }
    }

    private void b(com.ss.android.socialbase.downloader.g.d dVar) {
        com.ss.android.socialbase.downloader.g.c a2;
        if (dVar != null && (a2 = dVar.a()) != null) {
            try {
                synchronized (this.qaQ) {
                    if (this.qaQ.isEmpty()) {
                        a(dVar, true);
                        this.qaQ.put(dVar);
                    } else if (a2.eIq() == com.ss.android.socialbase.downloader.b.g.ENQUEUE_TAIL) {
                        if (this.qaQ.getFirst().o() != dVar.o() || !a(dVar.o())) {
                            Iterator<com.ss.android.socialbase.downloader.g.d> it = this.qaQ.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.ss.android.socialbase.downloader.g.d next = it.next();
                                if (next != null && next.o() == dVar.o()) {
                                    it.remove();
                                    break;
                                }
                            }
                            this.qaQ.put(dVar);
                            new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qaS).a();
                        }
                    } else {
                        com.ss.android.socialbase.downloader.g.d first = this.qaQ.getFirst();
                        if (first.o() != dVar.o() || !a(dVar.o())) {
                            e(first.o());
                            a(dVar, true);
                            if (first.o() != dVar.o()) {
                                this.qaQ.putFirst(dVar);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public com.ss.android.socialbase.downloader.g.c Tb(int i) {
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 == null) {
            synchronized (this.f13480b) {
                com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
                a2 = dVar != null ? dVar.a() : b2;
            }
            return a2;
        }
        return b2;
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.g.c> a2 = this.qaR.a(str);
        if (a2 == null || a2.isEmpty()) {
            synchronized (this.f13480b) {
                arrayList = new ArrayList();
                int size = this.f13480b.size();
                for (int i = 0; i < size; i++) {
                    com.ss.android.socialbase.downloader.g.d valueAt = this.f13480b.valueAt(i);
                    if (valueAt != null && valueAt.a() != null && str.equals(valueAt.a().j())) {
                        arrayList.add(valueAt.a());
                    }
                }
            }
            return arrayList;
        }
        return a2;
    }

    public boolean e(int i) {
        com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "pause id");
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 == null || b2.q() != 11) {
            b(i);
            if (b2 == null) {
                synchronized (this.f13480b) {
                    com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
                    if (dVar != null) {
                        new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qaS).d();
                        return true;
                    }
                }
            } else {
                a(b2);
                if (b2.q() == 1) {
                    synchronized (this.f13480b) {
                        com.ss.android.socialbase.downloader.g.d dVar2 = this.f13480b.get(i);
                        if (dVar2 != null) {
                            new com.ss.android.socialbase.downloader.downloader.e(dVar2, this.qaS).d();
                            return true;
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.b.f.b(b2.q())) {
                    b2.c(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a(int i, boolean z) {
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar == null && com.ss.android.socialbase.downloader.m.a.a(65536)) {
            dVar = Te(i);
        }
        if (dVar != null) {
            new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qaS).c();
            final com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            final SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = dVar.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            final SparseArray<com.ss.android.socialbase.downloader.d.b> b3 = dVar.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.qaS.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b2 != null) {
                        synchronized (b2) {
                            for (int i2 = 0; i2 < b2.size(); i2++) {
                                com.ss.android.socialbase.downloader.d.b bVar = (com.ss.android.socialbase.downloader.d.b) b2.get(b2.keyAt(i2));
                                if (bVar != null) {
                                    bVar.f(a2);
                                }
                            }
                        }
                    }
                    if (a2 != null && a2.eID() && b3 != null) {
                        synchronized (b3) {
                            for (int i3 = 0; i3 < b3.size(); i3++) {
                                com.ss.android.socialbase.downloader.d.b bVar2 = (com.ss.android.socialbase.downloader.d.b) b3.get(b3.keyAt(i3));
                                if (bVar2 != null) {
                                    bVar2.f(a2);
                                }
                            }
                        }
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.g.c b4 = this.qaR.b(i);
        if (com.ss.android.socialbase.downloader.m.a.a(65536)) {
            if (b4 != null) {
                b4.c(-4);
            }
        } else if (b4 != null && com.ss.android.socialbase.downloader.b.f.b(b4.q())) {
            b4.c(-4);
        }
        b(i, z);
        return true;
    }

    public synchronized boolean f(int i) {
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar != null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                a2.d(false);
            }
            a(dVar);
        } else {
            g(i);
        }
        return true;
    }

    public synchronized boolean g(int i) {
        boolean z;
        com.ss.android.socialbase.downloader.g.d dVar = this.d.get(i);
        if (dVar == null) {
            dVar = this.e.get(i);
        }
        if (dVar != null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            if (a2 != null) {
                a2.d(false);
            }
            a(dVar);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            try {
                if (cVar.q() == 7 || cVar.eIN() != com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_NONE) {
                    cVar.c(5);
                    cVar.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_NONE);
                    AlarmManager eHz = com.ss.android.socialbase.downloader.downloader.b.eHz();
                    Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                    intent.putExtra("extra_download_id", cVar.g());
                    intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eHT(), DownloadHandleService.class);
                    eHz.cancel(PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eHT(), cVar.g(), intent, 1073741824));
                    com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        synchronized (this.f13480b) {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.f13480b.get(i);
            if (dVar2 != null) {
                dVar2.b(dVar);
            }
        }
    }

    public synchronized com.ss.android.socialbase.downloader.d.r Tc(int i) {
        com.ss.android.socialbase.downloader.d.r rVar;
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar != null) {
            rVar = dVar.eJH();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.Au.get(i);
            if (dVar2 != null) {
                rVar = dVar2.eJH();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.d.get(i);
                if (dVar3 != null) {
                    rVar = dVar3.eJH();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.e.get(i);
                    if (dVar4 != null) {
                        rVar = dVar4.eJH();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar5 = this.f.get(i);
                        if (dVar5 != null) {
                            rVar = dVar5.eJH();
                        } else {
                            rVar = null;
                        }
                    }
                }
            }
        }
        return rVar;
    }

    public synchronized com.ss.android.socialbase.downloader.d.d SE(int i) {
        com.ss.android.socialbase.downloader.d.d dVar;
        com.ss.android.socialbase.downloader.g.d dVar2 = this.f13480b.get(i);
        if (dVar2 != null) {
            dVar = dVar2.eJG();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar3 = this.Au.get(i);
            if (dVar3 != null) {
                dVar = dVar3.eJG();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar4 = this.d.get(i);
                if (dVar4 != null) {
                    dVar = dVar4.eJG();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar5 = this.e.get(i);
                    if (dVar5 != null) {
                        dVar = dVar5.eJG();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar6 = this.f.get(i);
                        if (dVar6 != null) {
                            dVar = dVar6.eJG();
                        } else {
                            dVar = null;
                        }
                    }
                }
            }
        }
        return dVar;
    }

    public synchronized ah Td(int i) {
        ah ahVar;
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar != null) {
            ahVar = dVar.eJI();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.Au.get(i);
            if (dVar2 != null) {
                ahVar = dVar2.eJI();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.d.get(i);
                if (dVar3 != null) {
                    ahVar = dVar3.eJI();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.e.get(i);
                    if (dVar4 != null) {
                        ahVar = dVar4.eJI();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar5 = this.f.get(i);
                        if (dVar5 != null) {
                            ahVar = dVar5.eJI();
                        } else {
                            ahVar = null;
                        }
                    }
                }
            }
        }
        return ahVar;
    }

    public synchronized boolean k(int i) {
        boolean z;
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.d dVar = this.e.get(i);
        if (dVar != null && (a2 = dVar.a()) != null) {
            if (a2.eIQ()) {
                a(dVar, false);
            }
            z = true;
        } else {
            com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
            if (b2 != null && b2.eIQ()) {
                a(new com.ss.android.socialbase.downloader.g.d(b2), false);
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean SH(int i) {
        boolean z;
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.d dVar = this.f.get(i);
        if (dVar == null || (a2 = dVar.a()) == null) {
            z = false;
        } else {
            if (a2.eIR()) {
                a(dVar);
            }
            z = true;
        }
        return z;
    }

    public synchronized void a(List<String> list) {
        com.ss.android.socialbase.downloader.g.c a2;
        try {
            boolean a3 = com.ss.android.socialbase.downloader.m.a.a(1048576) ? com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eHT()) : true;
            for (int i = 0; i < this.d.size(); i++) {
                com.ss.android.socialbase.downloader.g.d dVar = this.d.get(this.d.keyAt(i));
                if (dVar != null && (a2 = dVar.a()) != null && a2.eIE() != null && list.contains(a2.eIE()) && (!a2.x() || a3)) {
                    a2.a(true);
                    a2.b(true);
                    a(dVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(List<String> list) {
        com.ss.android.socialbase.downloader.g.c a2;
        try {
            if (com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eHT())) {
                for (int i = 0; i < this.f13480b.size(); i++) {
                    com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(this.f13480b.keyAt(i));
                    if (dVar != null && (a2 = dVar.a()) != null && a2.eIE() != null && list.contains(a2.eIE()) && b(a2)) {
                        a2.a(true);
                        a2.b(true);
                        a(dVar);
                        a2.d(true);
                        com.ss.android.socialbase.downloader.downloader.r eHY = com.ss.android.socialbase.downloader.downloader.f.iA(com.ss.android.socialbase.downloader.downloader.b.eHT()).eHY();
                        if (eHY != null) {
                            eHY.a(a2, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eIx()) {
            return cVar.U();
        }
        return false;
    }

    public void b() {
        List<Integer> a2 = a();
        if (a2 != null) {
            for (Integer num : a2) {
                e(num.intValue());
            }
        }
    }

    public void b(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 != null) {
            a(b2);
        }
        this.qaS.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.eKa().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.Ta(i);
                a.this.d(i, z);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i, boolean z) {
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 != null) {
            if (z) {
                com.ss.android.socialbase.downloader.m.d.a(b2);
            } else {
                com.ss.android.socialbase.downloader.m.d.c(b2.l(), b2.m());
            }
            b2.eJe();
        }
        try {
            this.qaR.f(i);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(i, -4);
        if (this.d.get(i) != null) {
            this.d.remove(i);
        }
        if (this.Au.get(i) != null) {
            this.Au.remove(i);
        }
        synchronized (this.qaP) {
            this.qaP.remove(Integer.valueOf(i));
        }
        com.ss.android.socialbase.downloader.k.a.b(i);
    }

    public void c(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 != null) {
            a(b2);
        }
        this.qaS.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.eKa().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.Ta(i);
                a.this.e(i, z);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, boolean z) {
        try {
            com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
            if (b2 != null) {
                com.ss.android.socialbase.downloader.m.d.a(b2, z);
                b2.eJe();
            }
            try {
                this.qaR.d(i);
                this.qaR.a(b2);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.Au.get(i) != null) {
                this.Au.remove(i);
            }
            synchronized (this.qaP) {
                this.qaP.remove(Integer.valueOf(i));
            }
            com.ss.android.socialbase.downloader.k.a.b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void m(int i) {
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar != null && (a2 = dVar.a()) != null) {
            a2.j(true);
            a(dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r1.d.get(r2) != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(int i) {
        boolean z;
        if (i != 0) {
            if (this.f13480b == null || this.f13480b.get(i) == null) {
                if (this.d != null) {
                }
            }
            z = true;
        }
        z = false;
        return z;
    }

    public synchronized void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        com.ss.android.socialbase.downloader.g.d Te = Te(i);
        if (Te == null) {
            Te = this.qaP.get(Integer.valueOf(i));
        }
        if (Te != null) {
            Te.a(i2, bVar, hVar, z);
        }
    }

    public synchronized void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        a(i, i2, bVar, hVar, z, true);
    }

    public synchronized void a(int i, int i2, final com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.g.c b2;
        com.ss.android.socialbase.downloader.g.d Te = Te(i);
        if (Te != null) {
            Te.b(i2, bVar, hVar, z);
            final com.ss.android.socialbase.downloader.g.c a2 = Te.a();
            if (z2 && a2 != null && !a(i) && (hVar == com.ss.android.socialbase.downloader.b.h.MAIN || hVar == com.ss.android.socialbase.downloader.b.h.NOTIFICATION)) {
                boolean z3 = true;
                if (hVar == com.ss.android.socialbase.downloader.b.h.NOTIFICATION && !a2.eID()) {
                    z3 = false;
                }
                if (z3) {
                    this.qaS.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a2 != null && bVar != null) {
                                if (a2.q() == -3) {
                                    bVar.e(a2);
                                } else if (a2.q() == -1) {
                                    bVar.a(a2, new com.ss.android.socialbase.downloader.e.a(1000, "尝试为failed的任务add listener"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.m.a.a(32768) && (b2 = this.qaR.b(i)) != null && b2.q() != -3) {
            com.ss.android.socialbase.downloader.g.d dVar = this.qaP.get(Integer.valueOf(i));
            if (dVar == null) {
                dVar = new com.ss.android.socialbase.downloader.g.d(b2);
                synchronized (this.qaP) {
                    this.qaP.put(Integer.valueOf(i), dVar);
                }
            }
            dVar.b(i2, bVar, hVar, z);
        }
    }

    private com.ss.android.socialbase.downloader.g.d Te(int i) {
        com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
        if (dVar == null) {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.d.get(i);
            if (dVar2 == null) {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.Au.get(i);
                if (dVar3 == null) {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.e.get(i);
                    if (dVar4 == null) {
                        return this.f.get(i);
                    }
                    return dVar4;
                }
                return dVar3;
            }
            return dVar2;
        }
        return dVar;
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : a()) {
            com.ss.android.socialbase.downloader.g.c Tb = Tb(num.intValue());
            if (Tb != null && str.equals(Tb.eIE())) {
                arrayList.add(Tb);
            }
        }
        return arrayList;
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = dVar.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            SparseArray<com.ss.android.socialbase.downloader.d.b> b3 = dVar.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            boolean m = dVar.m();
            com.ss.android.socialbase.downloader.m.c.a(i, b2, true, a2, aVar);
            com.ss.android.socialbase.downloader.m.c.a(i, b3, m, a2, aVar);
        }
    }

    private void p(int i) {
        if (!this.qaQ.isEmpty()) {
            synchronized (this.qaQ) {
                com.ss.android.socialbase.downloader.g.d first = this.qaQ.getFirst();
                if (first != null && first.o() == i) {
                    this.qaQ.poll();
                }
                if (!this.qaQ.isEmpty()) {
                    com.ss.android.socialbase.downloader.g.d first2 = this.qaQ.getFirst();
                    if (first2 != null) {
                        a(first2, true);
                    }
                }
            }
        }
    }

    public synchronized void a(int i, int i2) {
        switch (i2) {
            case -7:
            case -1:
                com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
                if (dVar != null) {
                    if (this.d.get(i) == null) {
                        this.d.put(i, dVar);
                    }
                    this.f13480b.remove(i);
                }
                p(i);
                break;
            case -6:
                this.Au.put(i, this.f13480b.get(i));
                this.f13480b.remove(i);
                break;
            case -4:
                this.f13480b.remove(i);
                p(i);
                break;
            case -3:
                this.Au.put(i, this.f13480b.get(i));
                this.f13480b.remove(i);
                p(i);
                break;
            case 7:
                com.ss.android.socialbase.downloader.g.d dVar2 = this.f13480b.get(i);
                if (dVar2 != null) {
                    if (this.e.get(i) == null) {
                        this.e.put(i, dVar2);
                    }
                    this.f13480b.remove(i);
                }
                p(i);
                break;
            case 8:
                com.ss.android.socialbase.downloader.g.d dVar3 = this.f13480b.get(i);
                if (dVar3 != null && this.f.get(i) == null) {
                    this.f.put(i, dVar3);
                }
                p(i);
                break;
        }
    }

    @Override // com.ss.android.socialbase.downloader.l.f.a
    public void a(Message message) {
        com.ss.android.socialbase.downloader.e.a aVar;
        int i = message.arg1;
        if (!(message.obj instanceof Exception)) {
            aVar = null;
        } else {
            aVar = (com.ss.android.socialbase.downloader.e.a) message.obj;
        }
        synchronized (a.class) {
            com.ss.android.socialbase.downloader.g.d dVar = this.f13480b.get(i);
            if (dVar != null) {
                a(message.what, aVar, dVar);
                a(i, message.what);
            }
        }
    }

    public void b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b2 = this.qaR.b(i);
        if (b2 != null) {
            b2.jl(j);
        }
        a(i, j);
    }
}
