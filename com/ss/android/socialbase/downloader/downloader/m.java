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
/* loaded from: classes3.dex */
public interface m {
    int a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a();

    void a(int i2);

    void a(int i2, int i3);

    void a(int i2, int i3, int i4, int i5);

    void a(int i2, int i3, int i4, long j2);

    void a(int i2, int i3, long j2);

    void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2);

    void a(int i2, long j2);

    void a(int i2, Notification notification);

    void a(int i2, z zVar);

    void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list);

    void a(int i2, boolean z);

    void a(ak akVar);

    void a(DownloadTask downloadTask);

    void a(com.ss.android.socialbase.downloader.model.b bVar);

    void a(List<String> list);

    void a(boolean z, boolean z2);

    boolean a(DownloadInfo downloadInfo);

    DownloadInfo b(String str, String str2);

    List<DownloadInfo> b(String str);

    void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z);

    void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list);

    void b(int i2, boolean z);

    void b(DownloadInfo downloadInfo);

    void b(DownloadTask downloadTask);

    void b(List<String> list);

    boolean b();

    boolean b(int i2);

    List<DownloadInfo> c(String str);

    void c(int i2);

    void c(int i2, boolean z);

    boolean c();

    boolean c(DownloadInfo downloadInfo);

    List<DownloadInfo> d();

    List<DownloadInfo> d(String str);

    void d(int i2);

    long e(int i2);

    List<DownloadInfo> e(String str);

    boolean e();

    int f(int i2);

    void f();

    boolean g();

    boolean g(int i2);

    DownloadInfo h(int i2);

    List<com.ss.android.socialbase.downloader.model.b> i(int i2);

    void j(int i2);

    void k(int i2);

    boolean l(int i2);

    int m(int i2);

    boolean n(int i2);

    void o(int i2);

    boolean p(int i2);

    z q(int i2);

    af r(int i2);

    IDownloadFileUriProvider s(int i2);

    void startService();
}
