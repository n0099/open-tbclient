package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes10.dex */
public final class h {
    public ThreadPoolExecutor ahN;
    public int ahP;
    public SparseArray<DownloadLaunchRunnable> ahM = new SparseArray<>();
    public final String ahO = "Network";
    public int ahQ = 0;

    public h(int i) {
        this.ahN = com.kwad.framework.filedownloader.f.b.o(i, "Network");
        this.ahP = i;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.vo();
        synchronized (this) {
            this.ahM.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.ahN.execute(downloadLaunchRunnable);
        int i = this.ahQ;
        if (i >= 600) {
            wv();
            this.ahQ = 0;
            return;
        }
        this.ahQ = i + 1;
    }

    public final boolean bF(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.ahM.get(i);
        if (downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive()) {
            return true;
        }
        return false;
    }

    private synchronized void wv() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.ahM.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.ahM.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.ahM.get(keyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.ahM = sparseArray;
    }

    public final synchronized int ww() {
        wv();
        return this.ahM.size();
    }

    public final synchronized boolean bs(int i) {
        if (ww() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int bG = com.kwad.framework.filedownloader.f.e.bG(i);
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.ahP), Integer.valueOf(bG));
        }
        List<Runnable> shutdownNow = this.ahN.shutdownNow();
        this.ahN = com.kwad.framework.filedownloader.f.b.o(bG, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.ahP = bG;
        return true;
    }

    public final void cancel(int i) {
        wv();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.ahM.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.ahN.remove(downloadLaunchRunnable);
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.ahM.remove(i);
        }
    }

    public final int p(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.ahM.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.ahM.valueAt(i2);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.vt())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized List<Integer> wx() {
        ArrayList arrayList;
        wv();
        arrayList = new ArrayList();
        for (int i = 0; i < this.ahM.size(); i++) {
            arrayList.add(Integer.valueOf(this.ahM.get(this.ahM.keyAt(i)).getId()));
        }
        return arrayList;
    }
}
