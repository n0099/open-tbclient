package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
class h {

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f10995b;
    private int d;

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<DownloadLaunchRunnable> f10994a = new SparseArray<>();
    private final String c = "Network";
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        this.f10995b = com.kwai.filedownloader.f.b.a(i, "Network");
        this.d = i;
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f10994a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f10994a.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.f10994a.get(keyAt);
            if (downloadLaunchRunnable.e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f10994a = sparseArray;
    }

    public synchronized int a() {
        c();
        return this.f10994a.size();
    }

    public int a(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.f10994a.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.f10994a.valueAt(i2);
            if (valueAt != null && valueAt.e() && valueAt.d() != i && str.equals(valueAt.f())) {
                return valueAt.d();
            }
        }
        return 0;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.b();
        synchronized (this) {
            this.f10994a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
        }
        this.f10995b.execute(downloadLaunchRunnable);
        if (this.e < 600) {
            this.e++;
            return;
        }
        c();
        this.e = 0;
    }

    public synchronized boolean a(int i) {
        boolean z = false;
        synchronized (this) {
            if (a() > 0) {
                com.kwai.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            } else {
                int a2 = com.kwai.filedownloader.f.e.a(i);
                if (com.kwai.filedownloader.f.d.f10930a) {
                    com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.d), Integer.valueOf(a2));
                }
                List<Runnable> shutdownNow = this.f10995b.shutdownNow();
                this.f10995b = com.kwai.filedownloader.f.b.a(a2, "Network");
                if (shutdownNow.size() > 0) {
                    com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
                }
                this.d = a2;
                z = true;
            }
        }
        return z;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f10994a.size()) {
                arrayList.add(Integer.valueOf(this.f10994a.get(this.f10994a.keyAt(i2)).d()));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void b(int i) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f10994a.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.a();
                boolean remove = this.f10995b.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.f.d.f10930a) {
                    com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.f10994a.remove(i);
        }
    }

    public boolean c(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.f10994a.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
    }
}
