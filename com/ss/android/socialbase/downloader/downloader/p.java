package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public interface p<T extends DownloadService> {
    IBinder a(Intent intent);

    void a(int i);

    void a(int i, Notification notification);

    void a(Intent intent, int i, int i2);

    void a(o oVar);

    void a(WeakReference<T> weakReference);

    void a(boolean z);

    boolean a();

    void b(com.ss.android.socialbase.downloader.g.d dVar);

    boolean b();

    void c();

    void c(com.ss.android.socialbase.downloader.g.d dVar);

    void d();

    void f();
}
