package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f31666a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f31667a = new e();
    }

    public static e a() {
        return a.f31667a;
    }

    public synchronized void a(int i2) {
        if (this.f31666a != null) {
            this.f31666a.a(i2);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31666a != null) {
            this.f31666a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31666a != null) {
            this.f31666a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f31666a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31666a != null) {
            this.f31666a.b(downloadTask);
        }
    }

    public synchronized void c(DownloadTask downloadTask) {
        if (this.f31666a != null) {
            this.f31666a.c(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
