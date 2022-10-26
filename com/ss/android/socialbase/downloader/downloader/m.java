package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes8.dex */
public interface m {
    int a(String str, String str2);

    List a(String str);

    void a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, int i3, long j);

    void a(int i, int i2, long j);

    void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void a(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2);

    void a(int i, long j);

    void a(int i, Notification notification);

    void a(int i, z zVar);

    void a(int i, List list);

    void a(int i, boolean z);

    void a(ak akVar);

    void a(DownloadTask downloadTask);

    void a(com.ss.android.socialbase.downloader.model.b bVar);

    void a(List list);

    void a(boolean z, boolean z2);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(String str, String str2);

    List b(String str);

    void b(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void b(int i, List list);

    void b(int i, boolean z);

    void b(DownloadInfo downloadInfo);

    void b(DownloadTask downloadTask);

    void b(List list);

    boolean b();

    boolean b(int i);

    List c(String str);

    void c(int i);

    void c(int i, boolean z);

    boolean c();

    boolean c(DownloadInfo downloadInfo);

    List d();

    List d(String str);

    void d(int i);

    long e(int i);

    List e(String str);

    boolean e();

    int f(int i);

    void f();

    boolean g();

    boolean g(int i);

    DownloadInfo h(int i);

    List i(int i);

    void j(int i);

    void k(int i);

    boolean l(int i);

    int m(int i);

    boolean n(int i);

    void o(int i);

    boolean p(int i);

    z q(int i);

    af r(int i);

    IDownloadFileUriProvider s(int i);

    void startService();
}
