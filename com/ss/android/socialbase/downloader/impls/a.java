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
/* loaded from: classes6.dex */
public abstract class a implements f.a {
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> b = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> qhJ = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> d = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> e = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.g.d> f = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.m.f<Integer, com.ss.android.socialbase.downloader.g.d> qhK = new com.ss.android.socialbase.downloader.m.f<>();
    private final SparseArray<Long> h = new SparseArray<>();
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> qhL = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.l.f qhN = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.k qhM = com.ss.android.socialbase.downloader.downloader.b.eGw();

    protected abstract com.ss.android.socialbase.downloader.l.c RT(int i);

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
                com.ss.android.socialbase.downloader.h.a.a(dVar.eIm(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "downloadInfo is Invalid, url is " + a2.j() + " name is " + a2.h() + " savePath is " + a2.k()), a2 != null ? a2.q() : 0);
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
            synchronized (this.qhJ) {
                if (this.qhJ.get(g) != null) {
                    this.qhJ.remove(g);
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
                synchronized (this.b) {
                    com.ss.android.socialbase.downloader.g.d dVar3 = this.b.get(g);
                    if (dVar3 != null) {
                        dVar3.a(dVar);
                    } else {
                        this.b.put(g, dVar);
                    }
                }
            }
            if (a(g) && !a2.eHC()) {
                com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
                if (a2.eHl()) {
                    dVar.p();
                }
                com.ss.android.socialbase.downloader.h.a.a(dVar.eIm(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), a2 != null ? a2.q() : 0);
                return;
            }
            if (a2.eHC()) {
                a2.a(com.ss.android.socialbase.downloader.b.a.ASYNC_HANDLE_RESTART);
            }
            if (com.ss.android.socialbase.downloader.m.a.a(32768)) {
                synchronized (this.qhK) {
                    dVar2 = (com.ss.android.socialbase.downloader.g.d) this.qhK.remove(Integer.valueOf(g));
                }
                if (dVar2 != null) {
                    dVar.b(dVar2);
                }
            }
            synchronized (this.b) {
                Long l = this.h.get(g);
                long longValue = l != null ? l.longValue() : 0L;
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - longValue < 50) {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.b.get(g);
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
                        } else if (a2.eHl()) {
                            dVar.p();
                        } else {
                            com.ss.android.socialbase.downloader.h.a.a(dVar.eIm(), a2, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task within 50 milliseconds and addListenerToSameTask is false"), a2 != null ? a2.q() : 0);
                            this.b.put(g, dVar);
                            this.h.put(g, Long.valueOf(uptimeMillis));
                            a(g, dVar);
                        }
                    } else {
                        this.b.put(g, dVar);
                        this.h.put(g, Long.valueOf(uptimeMillis));
                        a(g, dVar);
                    }
                } else {
                    this.b.put(g, dVar);
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
            if (a2.eHd() != com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE) {
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
                synchronized (this.qhL) {
                    if (this.qhL.isEmpty()) {
                        a(dVar, true);
                        this.qhL.put(dVar);
                    } else if (a2.eHd() == com.ss.android.socialbase.downloader.b.g.ENQUEUE_TAIL) {
                        if (this.qhL.getFirst().o() != dVar.o() || !a(dVar.o())) {
                            Iterator<com.ss.android.socialbase.downloader.g.d> it = this.qhL.iterator();
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
                            this.qhL.put(dVar);
                            new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qhN).a();
                        }
                    } else {
                        com.ss.android.socialbase.downloader.g.d first = this.qhL.getFirst();
                        if (first.o() != dVar.o() || !a(dVar.o())) {
                            e(first.o());
                            a(dVar, true);
                            if (first.o() != dVar.o()) {
                                this.qhL.putFirst(dVar);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public com.ss.android.socialbase.downloader.g.c RU(int i) {
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b == null) {
            synchronized (this.b) {
                com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
                a2 = dVar != null ? dVar.a() : b;
            }
            return a2;
        }
        return b;
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.g.c> a2 = this.qhM.a(str);
        if (a2 == null || a2.isEmpty()) {
            synchronized (this.b) {
                arrayList = new ArrayList();
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    com.ss.android.socialbase.downloader.g.d valueAt = this.b.valueAt(i);
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
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b == null || b.q() != 11) {
            b(i);
            if (b == null) {
                synchronized (this.b) {
                    com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
                    if (dVar != null) {
                        new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qhN).d();
                        return true;
                    }
                }
            } else {
                a(b);
                if (b.q() == 1) {
                    synchronized (this.b) {
                        com.ss.android.socialbase.downloader.g.d dVar2 = this.b.get(i);
                        if (dVar2 != null) {
                            new com.ss.android.socialbase.downloader.downloader.e(dVar2, this.qhN).d();
                            return true;
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.b.f.b(b.q())) {
                    b.c(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a(int i, boolean z) {
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
        if (dVar == null && com.ss.android.socialbase.downloader.m.a.a(65536)) {
            dVar = RX(i);
        }
        if (dVar != null) {
            new com.ss.android.socialbase.downloader.downloader.e(dVar, this.qhN).c();
            final com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            final SparseArray<com.ss.android.socialbase.downloader.d.b> b = dVar.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            final SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = dVar.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            this.qhN.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b != null) {
                        synchronized (b) {
                            for (int i2 = 0; i2 < b.size(); i2++) {
                                com.ss.android.socialbase.downloader.d.b bVar = (com.ss.android.socialbase.downloader.d.b) b.get(b.keyAt(i2));
                                if (bVar != null) {
                                    bVar.f(a2);
                                }
                            }
                        }
                    }
                    if (a2 != null && a2.eHs() && b2 != null) {
                        synchronized (b2) {
                            for (int i3 = 0; i3 < b2.size(); i3++) {
                                com.ss.android.socialbase.downloader.d.b bVar2 = (com.ss.android.socialbase.downloader.d.b) b2.get(b2.keyAt(i3));
                                if (bVar2 != null) {
                                    bVar2.f(a2);
                                }
                            }
                        }
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.g.c b3 = this.qhM.b(i);
        if (com.ss.android.socialbase.downloader.m.a.a(65536)) {
            if (b3 != null) {
                b3.c(-4);
            }
        } else if (b3 != null && com.ss.android.socialbase.downloader.b.f.b(b3.q())) {
            b3.c(-4);
        }
        b(i, z);
        return true;
    }

    public synchronized boolean f(int i) {
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
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
                if (cVar.q() == 7 || cVar.eHy() != com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_NONE) {
                    cVar.c(5);
                    cVar.a(com.ss.android.socialbase.downloader.b.i.DELAY_RETRY_NONE);
                    AlarmManager eGm = com.ss.android.socialbase.downloader.downloader.b.eGm();
                    Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                    intent.putExtra("extra_download_id", cVar.g());
                    intent.setClass(com.ss.android.socialbase.downloader.downloader.b.eGG(), DownloadHandleService.class);
                    eGm.cancel(PendingIntent.getService(com.ss.android.socialbase.downloader.downloader.b.eGG(), cVar.g(), intent, 1073741824));
                    com.ss.android.socialbase.downloader.f.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.d dVar) {
        synchronized (this.b) {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.b.get(i);
            if (dVar2 != null) {
                dVar2.b(dVar);
            }
        }
    }

    public synchronized com.ss.android.socialbase.downloader.d.r RV(int i) {
        com.ss.android.socialbase.downloader.d.r rVar;
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
        if (dVar != null) {
            rVar = dVar.eIs();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.qhJ.get(i);
            if (dVar2 != null) {
                rVar = dVar2.eIs();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.d.get(i);
                if (dVar3 != null) {
                    rVar = dVar3.eIs();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.e.get(i);
                    if (dVar4 != null) {
                        rVar = dVar4.eIs();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar5 = this.f.get(i);
                        if (dVar5 != null) {
                            rVar = dVar5.eIs();
                        } else {
                            rVar = null;
                        }
                    }
                }
            }
        }
        return rVar;
    }

    public synchronized com.ss.android.socialbase.downloader.d.d Rx(int i) {
        com.ss.android.socialbase.downloader.d.d dVar;
        com.ss.android.socialbase.downloader.g.d dVar2 = this.b.get(i);
        if (dVar2 != null) {
            dVar = dVar2.eIr();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar3 = this.qhJ.get(i);
            if (dVar3 != null) {
                dVar = dVar3.eIr();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar4 = this.d.get(i);
                if (dVar4 != null) {
                    dVar = dVar4.eIr();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar5 = this.e.get(i);
                    if (dVar5 != null) {
                        dVar = dVar5.eIr();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar6 = this.f.get(i);
                        if (dVar6 != null) {
                            dVar = dVar6.eIr();
                        } else {
                            dVar = null;
                        }
                    }
                }
            }
        }
        return dVar;
    }

    public synchronized ah RW(int i) {
        ah ahVar;
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
        if (dVar != null) {
            ahVar = dVar.eIt();
        } else {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.qhJ.get(i);
            if (dVar2 != null) {
                ahVar = dVar2.eIt();
            } else {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.d.get(i);
                if (dVar3 != null) {
                    ahVar = dVar3.eIt();
                } else {
                    com.ss.android.socialbase.downloader.g.d dVar4 = this.e.get(i);
                    if (dVar4 != null) {
                        ahVar = dVar4.eIt();
                    } else {
                        com.ss.android.socialbase.downloader.g.d dVar5 = this.f.get(i);
                        if (dVar5 != null) {
                            ahVar = dVar5.eIt();
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
            if (a2.eHB()) {
                a(dVar, false);
            }
            z = true;
        } else {
            com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
            if (b != null && b.eHB()) {
                a(new com.ss.android.socialbase.downloader.g.d(b), false);
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean RA(int i) {
        boolean z;
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.d dVar = this.f.get(i);
        if (dVar == null || (a2 = dVar.a()) == null) {
            z = false;
        } else {
            if (a2.eHC()) {
                a(dVar);
            }
            z = true;
        }
        return z;
    }

    public synchronized void a(List<String> list) {
        com.ss.android.socialbase.downloader.g.c a2;
        try {
            boolean a3 = com.ss.android.socialbase.downloader.m.a.a(1048576) ? com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG()) : true;
            for (int i = 0; i < this.d.size(); i++) {
                com.ss.android.socialbase.downloader.g.d dVar = this.d.get(this.d.keyAt(i));
                if (dVar != null && (a2 = dVar.a()) != null && a2.at() != null && list.contains(a2.at()) && (!a2.x() || a3)) {
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
            if (com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG())) {
                for (int i = 0; i < this.b.size(); i++) {
                    com.ss.android.socialbase.downloader.g.d dVar = this.b.get(this.b.keyAt(i));
                    if (dVar != null && (a2 = dVar.a()) != null && a2.at() != null && list.contains(a2.at()) && b(a2)) {
                        a2.a(true);
                        a2.b(true);
                        a(dVar);
                        a2.d(true);
                        com.ss.android.socialbase.downloader.downloader.r eGL = com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).eGL();
                        if (eGL != null) {
                            eGL.a(a2, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null && cVar.eHi()) {
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
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b != null) {
            a(b);
        }
        this.qhN.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.eIK().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.RT(i);
                a.this.d(i, z);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i, boolean z) {
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b != null) {
            if (z) {
                com.ss.android.socialbase.downloader.m.d.a(b);
            } else {
                com.ss.android.socialbase.downloader.m.d.c(b.l(), b.m());
            }
            b.eHP();
        }
        try {
            this.qhM.f(i);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        a(i, -4);
        if (this.d.get(i) != null) {
            this.d.remove(i);
        }
        if (this.qhJ.get(i) != null) {
            this.qhJ.remove(i);
        }
        synchronized (this.qhK) {
            this.qhK.remove(Integer.valueOf(i));
        }
        com.ss.android.socialbase.downloader.k.a.b(i);
    }

    public void c(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b != null) {
            a(b);
        }
        this.qhN.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.eIK().f(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.RT(i);
                a.this.e(i, z);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, boolean z) {
        try {
            com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
            if (b != null) {
                com.ss.android.socialbase.downloader.m.d.a(b, z);
                b.eHP();
            }
            try {
                this.qhM.d(i);
                this.qhM.a(b);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.qhJ.get(i) != null) {
                this.qhJ.remove(i);
            }
            synchronized (this.qhK) {
                this.qhK.remove(Integer.valueOf(i));
            }
            com.ss.android.socialbase.downloader.k.a.b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void m(int i) {
        com.ss.android.socialbase.downloader.g.c a2;
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
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
            if (this.b == null || this.b.get(i) == null) {
                if (this.d != null) {
                }
            }
            z = true;
        }
        z = false;
        return z;
    }

    public synchronized void a(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        com.ss.android.socialbase.downloader.g.d RX = RX(i);
        if (RX == null) {
            RX = this.qhK.get(Integer.valueOf(i));
        }
        if (RX != null) {
            RX.a(i2, bVar, hVar, z);
        }
    }

    public synchronized void b(int i, int i2, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        a(i, i2, bVar, hVar, z, true);
    }

    public synchronized void a(int i, int i2, final com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.g.c b;
        com.ss.android.socialbase.downloader.g.d RX = RX(i);
        if (RX != null) {
            RX.b(i2, bVar, hVar, z);
            final com.ss.android.socialbase.downloader.g.c a2 = RX.a();
            if (z2 && a2 != null && !a(i) && (hVar == com.ss.android.socialbase.downloader.b.h.MAIN || hVar == com.ss.android.socialbase.downloader.b.h.NOTIFICATION)) {
                boolean z3 = true;
                if (hVar == com.ss.android.socialbase.downloader.b.h.NOTIFICATION && !a2.eHs()) {
                    z3 = false;
                }
                if (z3) {
                    this.qhN.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
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
        } else if (com.ss.android.socialbase.downloader.m.a.a(32768) && (b = this.qhM.b(i)) != null && b.q() != -3) {
            com.ss.android.socialbase.downloader.g.d dVar = this.qhK.get(Integer.valueOf(i));
            if (dVar == null) {
                dVar = new com.ss.android.socialbase.downloader.g.d(b);
                synchronized (this.qhK) {
                    this.qhK.put(Integer.valueOf(i), dVar);
                }
            }
            dVar.b(i2, bVar, hVar, z);
        }
    }

    private com.ss.android.socialbase.downloader.g.d RX(int i) {
        com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
        if (dVar == null) {
            com.ss.android.socialbase.downloader.g.d dVar2 = this.d.get(i);
            if (dVar2 == null) {
                com.ss.android.socialbase.downloader.g.d dVar3 = this.qhJ.get(i);
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
            com.ss.android.socialbase.downloader.g.c RU = RU(num.intValue());
            if (RU != null && str.equals(RU.at())) {
                arrayList.add(RU);
            }
        }
        return arrayList;
    }

    private void a(int i, com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.g.c a2 = dVar.a();
            SparseArray<com.ss.android.socialbase.downloader.d.b> b = dVar.b(com.ss.android.socialbase.downloader.b.h.MAIN);
            SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = dVar.b(com.ss.android.socialbase.downloader.b.h.NOTIFICATION);
            boolean m = dVar.m();
            com.ss.android.socialbase.downloader.m.c.a(i, b, true, a2, aVar);
            com.ss.android.socialbase.downloader.m.c.a(i, b2, m, a2, aVar);
        }
    }

    private void p(int i) {
        if (!this.qhL.isEmpty()) {
            synchronized (this.qhL) {
                com.ss.android.socialbase.downloader.g.d first = this.qhL.getFirst();
                if (first != null && first.o() == i) {
                    this.qhL.poll();
                }
                if (!this.qhL.isEmpty()) {
                    com.ss.android.socialbase.downloader.g.d first2 = this.qhL.getFirst();
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
                com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
                if (dVar != null) {
                    if (this.d.get(i) == null) {
                        this.d.put(i, dVar);
                    }
                    this.b.remove(i);
                }
                p(i);
                break;
            case -6:
                this.qhJ.put(i, this.b.get(i));
                this.b.remove(i);
                break;
            case -4:
                this.b.remove(i);
                p(i);
                break;
            case -3:
                this.qhJ.put(i, this.b.get(i));
                this.b.remove(i);
                p(i);
                break;
            case 7:
                com.ss.android.socialbase.downloader.g.d dVar2 = this.b.get(i);
                if (dVar2 != null) {
                    if (this.e.get(i) == null) {
                        this.e.put(i, dVar2);
                    }
                    this.b.remove(i);
                }
                p(i);
                break;
            case 8:
                com.ss.android.socialbase.downloader.g.d dVar3 = this.b.get(i);
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
            com.ss.android.socialbase.downloader.g.d dVar = this.b.get(i);
            if (dVar != null) {
                a(message.what, aVar, dVar);
                a(i, message.what);
            }
        }
    }

    public void b(int i, long j) {
        com.ss.android.socialbase.downloader.g.c b = this.qhM.b(i);
        if (b != null) {
            b.jo(j);
        }
        a(i, j);
    }
}
