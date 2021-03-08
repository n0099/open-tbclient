package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.b> f7216a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final h f7217a = new h();
    }

    private h() {
        this.f7216a = new ArrayList<>();
    }

    public static h a() {
        return a.f7217a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        int i2 = 0;
        synchronized (this.f7216a) {
            Iterator<a.b> it = this.f7216a.iterator();
            while (it.hasNext()) {
                i2 = it.next().b(i) ? i2 + 1 : i2;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        synchronized (this.f7216a) {
            Iterator<a.b> it = this.f7216a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.f7216a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a.b bVar) {
        return this.f7216a.isEmpty() || !this.f7216a.contains(bVar);
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte b = messageSnapshot.b();
        synchronized (this.f7216a) {
            remove = this.f7216a.remove(bVar);
        }
        if (com.kwai.filedownloader.f.d.f7212a && this.f7216a.size() == 0) {
            com.kwai.filedownloader.f.d.e(this, "remove %s left %d %d", bVar, Byte.valueOf(b), Integer.valueOf(this.f7216a.size()));
        }
        if (remove) {
            s d = bVar.G().d();
            switch (b) {
                case -4:
                    d.g(messageSnapshot);
                    break;
                case -3:
                    d.e(com.kwai.filedownloader.message.f.a(messageSnapshot));
                    break;
                case -2:
                    d.i(messageSnapshot);
                    break;
                case -1:
                    d.h(messageSnapshot);
                    break;
            }
        } else {
            com.kwai.filedownloader.f.d.a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b));
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f7216a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> b(int i) {
        byte v;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f7216a) {
            Iterator<a.b> it = this.f7216a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.b(i) && !next.H() && (v = next.F().v()) != 0 && v != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.b bVar) {
        if (!bVar.F().d()) {
            bVar.J();
        }
        if (bVar.G().d().a()) {
            c(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> c(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f7216a) {
            Iterator<a.b> it = this.f7216a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (next.b(i) && !next.H()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.b bVar) {
        if (bVar.K()) {
            return;
        }
        synchronized (this.f7216a) {
            if (this.f7216a.contains(bVar)) {
                com.kwai.filedownloader.f.d.d(this, "already has %s", bVar);
            } else {
                bVar.L();
                this.f7216a.add(bVar);
                if (com.kwai.filedownloader.f.d.f7212a) {
                    com.kwai.filedownloader.f.d.e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.F().v()), Integer.valueOf(this.f7216a.size()));
                }
            }
        }
    }
}
