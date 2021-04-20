package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f37407b;

    /* renamed from: d  reason: collision with root package name */
    public int f37409d;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DownloadLaunchRunnable> f37406a = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f37408c = "Network";

    /* renamed from: e  reason: collision with root package name */
    public int f37410e = 0;

    public h(int i) {
        this.f37407b = com.kwai.filedownloader.f.b.a(i, "Network");
        this.f37409d = i;
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f37406a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f37406a.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37406a.get(keyAt);
            if (downloadLaunchRunnable.e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f37406a = sparseArray;
    }

    public synchronized int a() {
        c();
        return this.f37406a.size();
    }

    public int a(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.f37406a.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.f37406a.valueAt(i2);
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
            this.f37406a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
        }
        this.f37407b.execute(downloadLaunchRunnable);
        int i2 = this.f37410e;
        if (i2 >= 600) {
            c();
            i = 0;
        } else {
            i = i2 + 1;
        }
        this.f37410e = i;
    }

    public synchronized boolean a(int i) {
        if (a() > 0) {
            com.kwai.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a2 = com.kwai.filedownloader.f.e.a(i);
        if (com.kwai.filedownloader.f.d.f37301a) {
            com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f37409d), Integer.valueOf(a2));
        }
        List<Runnable> shutdownNow = this.f37407b.shutdownNow();
        this.f37407b = com.kwai.filedownloader.f.b.a(a2, "Network");
        if (shutdownNow.size() > 0) {
            com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f37409d = a2;
        return true;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (int i = 0; i < this.f37406a.size(); i++) {
            arrayList.add(Integer.valueOf(this.f37406a.get(this.f37406a.keyAt(i)).d()));
        }
        return arrayList;
    }

    public void b(int i) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f37406a.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.a();
                boolean remove = this.f37407b.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.f.d.f37301a) {
                    com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.f37406a.remove(i);
        }
    }

    public boolean c(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.f37406a.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
    }
}
