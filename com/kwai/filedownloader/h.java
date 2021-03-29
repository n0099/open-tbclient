package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a.b> f37027a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f37028a = new h();
    }

    public h() {
        this.f37027a = new ArrayList<>();
    }

    public static h a() {
        return a.f37028a;
    }

    public int a(int i) {
        int i2;
        synchronized (this.f37027a) {
            Iterator<a.b> it = this.f37027a.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().b(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void a(List<a.b> list) {
        synchronized (this.f37027a) {
            Iterator<a.b> it = this.f37027a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.f37027a.clear();
        }
    }

    public boolean a(a.b bVar) {
        return this.f37027a.isEmpty() || !this.f37027a.contains(bVar);
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte b2 = messageSnapshot.b();
        synchronized (this.f37027a) {
            remove = this.f37027a.remove(bVar);
        }
        if (com.kwai.filedownloader.f.d.f37012a && this.f37027a.size() == 0) {
            com.kwai.filedownloader.f.d.e(this, "remove %s left %d %d", bVar, Byte.valueOf(b2), Integer.valueOf(this.f37027a.size()));
        }
        if (remove) {
            s d2 = bVar.G().d();
            if (b2 == -4) {
                d2.g(messageSnapshot);
            } else if (b2 == -3) {
                d2.e(com.kwai.filedownloader.message.f.a(messageSnapshot));
            } else if (b2 == -2) {
                d2.i(messageSnapshot);
            } else if (b2 == -1) {
                d2.h(messageSnapshot);
            }
        } else {
            com.kwai.filedownloader.f.d.a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b2));
        }
        return remove;
    }

    public int b() {
        return this.f37027a.size();
    }

    public List<a.b> b(int i) {
        byte v;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f37027a) {
            Iterator<a.b> it = this.f37027a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.b(i) && !next.H() && (v = next.F().v()) != 0 && v != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void b(a.b bVar) {
        if (!bVar.F().d()) {
            bVar.J();
        }
        if (bVar.G().d().a()) {
            c(bVar);
        }
    }

    public List<a.b> c(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f37027a) {
            Iterator<a.b> it = this.f37027a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.b(i) && !next.H()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void c(a.b bVar) {
        if (bVar.K()) {
            return;
        }
        synchronized (this.f37027a) {
            if (this.f37027a.contains(bVar)) {
                com.kwai.filedownloader.f.d.d(this, "already has %s", bVar);
            } else {
                bVar.L();
                this.f37027a.add(bVar);
                if (com.kwai.filedownloader.f.d.f37012a) {
                    com.kwai.filedownloader.f.d.e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.F().v()), Integer.valueOf(this.f37027a.size()));
                }
            }
        }
    }
}
