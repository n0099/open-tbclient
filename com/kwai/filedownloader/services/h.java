package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f37502b;

    /* renamed from: d  reason: collision with root package name */
    public int f37504d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DownloadLaunchRunnable> f37501a = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f37503c = "Network";

    /* renamed from: e  reason: collision with root package name */
    public int f37505e = 0;

    public h(int i) {
        this.f37502b = com.kwai.filedownloader.f.b.a(i, "Network");
        this.f37504d = i;
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f37501a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f37501a.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37501a.get(keyAt);
            if (downloadLaunchRunnable.e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f37501a = sparseArray;
    }

    public synchronized int a() {
        c();
        return this.f37501a.size();
    }

    public int a(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.f37501a.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.f37501a.valueAt(i2);
            if (valueAt != null && valueAt.e() && valueAt.d() != i && str.equals(valueAt.f())) {
                return valueAt.d();
            }
        }
        return 0;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i;
        downloadLaunchRunnable.b();
        synchronized (this) {
            this.f37501a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
        }
        this.f37502b.execute(downloadLaunchRunnable);
        int i2 = this.f37505e;
        if (i2 >= 600) {
            c();
            i = 0;
        } else {
            i = i2 + 1;
        }
        this.f37505e = i;
    }

    public synchronized boolean a(int i) {
        if (a() > 0) {
            com.kwai.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a2 = com.kwai.filedownloader.f.e.a(i);
        if (com.kwai.filedownloader.f.d.f37396a) {
            com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f37504d), Integer.valueOf(a2));
        }
        List<Runnable> shutdownNow = this.f37502b.shutdownNow();
        this.f37502b = com.kwai.filedownloader.f.b.a(a2, "Network");
        if (shutdownNow.size() > 0) {
            com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f37504d = a2;
        return true;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (int i = 0; i < this.f37501a.size(); i++) {
            arrayList.add(Integer.valueOf(this.f37501a.get(this.f37501a.keyAt(i)).d()));
        }
        return arrayList;
    }

    public void b(int i) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37501a.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.a();
                boolean remove = this.f37502b.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.f.d.f37396a) {
                    com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.f37501a.remove(i);
        }
    }

    public boolean c(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.f37501a.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
    }
}
