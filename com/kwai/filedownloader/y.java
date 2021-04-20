package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class y extends e implements u {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a.b> f37411a = new ArrayList<>();

    @Override // com.kwai.filedownloader.e
    public void a() {
        v d2 = q.a().d();
        if (com.kwai.filedownloader.f.d.f37301a) {
            com.kwai.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f37411a) {
            this.f37411a.clear();
            ArrayList arrayList = new ArrayList(d2.b());
            for (a.b bVar : (List) this.f37411a.clone()) {
                int I = bVar.I();
                if (d2.a(I)) {
                    bVar.F().a().a();
                    if (!arrayList.contains(Integer.valueOf(I))) {
                        arrayList.add(Integer.valueOf(I));
                    }
                } else {
                    bVar.N();
                }
            }
            d2.a(arrayList);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(a.b bVar) {
        return !this.f37411a.isEmpty() && this.f37411a.contains(bVar);
    }

    @Override // com.kwai.filedownloader.e
    public void b() {
        if (c() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.a().b() > 0) {
                com.kwai.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.a().b()));
                return;
            }
            return;
        }
        v d2 = q.a().d();
        if (com.kwai.filedownloader.f.d.f37301a) {
            com.kwai.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().b()));
        }
        if (h.a().b() > 0) {
            synchronized (this.f37411a) {
                h.a().a(this.f37411a);
                Iterator<a.b> it = this.f37411a.iterator();
                while (it.hasNext()) {
                    it.next().M();
                }
                d2.a();
            }
            q.a().b();
        }
    }

    @Override // com.kwai.filedownloader.u
    public void b(a.b bVar) {
        if (this.f37411a.isEmpty()) {
            return;
        }
        synchronized (this.f37411a) {
            this.f37411a.remove(bVar);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean c(a.b bVar) {
        if (!q.a().c()) {
            synchronized (this.f37411a) {
                if (!q.a().c()) {
                    if (com.kwai.filedownloader.f.d.f37301a) {
                        com.kwai.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.F().h()));
                    }
                    m.a().a(com.kwai.filedownloader.f.c.a());
                    if (!this.f37411a.contains(bVar)) {
                        bVar.M();
                        this.f37411a.add(bVar);
                    }
                    return true;
                }
            }
        }
        b(bVar);
        return false;
    }
}
