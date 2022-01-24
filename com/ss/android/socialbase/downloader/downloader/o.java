package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public interface o<T extends DownloadService> {
    IBinder a(Intent intent);

    void a(int i2);

    void a(int i2, Notification notification);

    void a(Intent intent, int i2, int i3);

    void a(n nVar);

    void a(WeakReference<T> weakReference);

    void a(boolean z);

    boolean a();

    void b(DownloadTask downloadTask);

    boolean b();

    void c();

    void c(DownloadTask downloadTask);

    void d();

    void startService();
}
