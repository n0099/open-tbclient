package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f37980b;

    /* renamed from: d  reason: collision with root package name */
    public int f37982d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DownloadLaunchRunnable> f37979a = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f37981c = "Network";

    /* renamed from: e  reason: collision with root package name */
    public int f37983e = 0;

    public h(int i2) {
        this.f37980b = com.kwai.filedownloader.f.b.a(i2, "Network");
        this.f37982d = i2;
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f37979a.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.f37979a.keyAt(i2);
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37979a.get(keyAt);
            if (downloadLaunchRunnable.e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f37979a = sparseArray;
    }

    public synchronized int a() {
        c();
        return this.f37979a.size();
    }

    public int a(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.f37979a.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadLaunchRunnable valueAt = this.f37979a.valueAt(i3);
            if (valueAt != null && valueAt.e() && valueAt.d() != i2 && str.equals(valueAt.f())) {
                return valueAt.d();
            }
        }
        return 0;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i2;
        downloadLaunchRunnable.b();
        synchronized (this) {
            this.f37979a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
        }
        this.f37980b.execute(downloadLaunchRunnable);
        int i3 = this.f37983e;
        if (i3 >= 600) {
            c();
            i2 = 0;
        } else {
            i2 = i3 + 1;
        }
        this.f37983e = i2;
    }

    public synchronized boolean a(int i2) {
        if (a() > 0) {
            com.kwai.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a2 = com.kwai.filedownloader.f.e.a(i2);
        if (com.kwai.filedownloader.f.d.f37874a) {
            com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f37982d), Integer.valueOf(a2));
        }
        List<Runnable> shutdownNow = this.f37980b.shutdownNow();
        this.f37980b = com.kwai.filedownloader.f.b.a(a2, "Network");
        if (shutdownNow.size() > 0) {
            com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f37982d = a2;
        return true;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f37979a.size(); i2++) {
            arrayList.add(Integer.valueOf(this.f37979a.get(this.f37979a.keyAt(i2)).d()));
        }
        return arrayList;
    }

    public void b(int i2) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37979a.get(i2);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.a();
                boolean remove = this.f37980b.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.f.d.f37874a) {
                    com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                }
            }
            this.f37979a.remove(i2);
        }
    }

    public boolean c(int i2) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.f37979a.get(i2);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
    }
}
