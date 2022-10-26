package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public interface o {
    IBinder a(Intent intent);

    void a(int i);

    void a(int i, Notification notification);

    void a(Intent intent, int i, int i2);

    void a(n nVar);

    void a(WeakReference weakReference);

    void a(boolean z);

    boolean a();

    void b(DownloadTask downloadTask);

    boolean b();

    void c();

    void c(DownloadTask downloadTask);

    void d();

    void startService();
}
