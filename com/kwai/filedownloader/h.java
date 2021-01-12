package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.b> f10934a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final h f10935a = new h();
    }

    private h() {
        this.f10934a = new ArrayList<>();
    }

    public static h a() {
        return a.f10935a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        int i2 = 0;
        synchronized (this.f10934a) {
            Iterator<a.b> it = this.f10934a.iterator();
            while (it.hasNext()) {
                i2 = it.next().b(i) ? i2 + 1 : i2;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        synchronized (this.f10934a) {
            Iterator<a.b> it = this.f10934a.iterator();
            while (it.hasNext()) {
                a.b next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.f10934a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a.b bVar) {
        return this.f10934a.isEmpty() || !this.f10934a.contains(bVar);
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte b2 = messageSnapshot.b();
        synchronized (this.f10934a) {
            remove = this.f10934a.remove(bVar);
        }
        if (com.kwai.filedownloader.f.d.f10928a && this.f10934a.size() == 0) {
            com.kwai.filedownloader.f.d.e(this, "remove %s left %d %d", bVar, Byte.valueOf(b2), Integer.valueOf(this.f10934a.size()));
        }
        if (remove) {
            s d = bVar.G().d();
            switch (b2) {
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
            com.kwai.filedownloader.f.d.a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b2));
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10934a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a.b> b(int i) {
        byte v;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f10934a) {
            Iterator<a.b> it = this.f10934a.iterator();
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
        synchronized (this.f10934a) {
            Iterator<a.b> it = this.f10934a.iterator();
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
        synchronized (this.f10934a) {
            if (this.f10934a.contains(bVar)) {
                com.kwai.filedownloader.f.d.d(this, "already has %s", bVar);
            } else {
                bVar.L();
                this.f10934a.add(bVar);
                if (com.kwai.filedownloader.f.d.f10928a) {
                    com.kwai.filedownloader.f.d.e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.F().v()), Integer.valueOf(this.f10934a.size()));
                }
            }
        }
    }
}
