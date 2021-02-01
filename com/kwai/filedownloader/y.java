package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class y extends e implements u {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.b> f10996a = new ArrayList<>();

    @Override // com.kwai.filedownloader.e
    public void a() {
        v d = q.a().d();
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f10996a) {
            this.f10996a.clear();
            ArrayList arrayList = new ArrayList(d.b());
            for (a.b bVar : (List) this.f10996a.clone()) {
                int I = bVar.I();
                if (d.a(I)) {
                    bVar.F().a().a();
                    if (!arrayList.contains(Integer.valueOf(I))) {
                        arrayList.add(Integer.valueOf(I));
                    }
                } else {
                    bVar.N();
                }
            }
            d.a(arrayList);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(a.b bVar) {
        return !this.f10996a.isEmpty() && this.f10996a.contains(bVar);
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
        v d = q.a().d();
        if (com.kwai.filedownloader.f.d.f10930a) {
            com.kwai.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.a().b()));
        }
        if (h.a().b() > 0) {
            synchronized (this.f10996a) {
                h.a().a(this.f10996a);
                Iterator<a.b> it = this.f10996a.iterator();
                while (it.hasNext()) {
                    it.next().M();
                }
                d.a();
            }
            q.a().b();
        }
    }

    @Override // com.kwai.filedownloader.u
    public void b(a.b bVar) {
        if (this.f10996a.isEmpty()) {
            return;
        }
        synchronized (this.f10996a) {
            this.f10996a.remove(bVar);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean c(a.b bVar) {
        if (!q.a().c()) {
            synchronized (this.f10996a) {
                if (!q.a().c()) {
                    if (com.kwai.filedownloader.f.d.f10930a) {
                        com.kwai.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.F().h()));
                    }
                    m.a().a(com.kwai.filedownloader.f.c.a());
                    if (!this.f10996a.contains(bVar)) {
                        bVar.M();
                        this.f10996a.add(bVar);
                    }
                    return true;
                }
            }
        }
        b(bVar);
        return false;
    }
}
