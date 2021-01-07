package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f8217a;

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f8218a = new e();
    }

    public static e a() {
        return a.f8218a;
    }

    public synchronized void a(int i) {
        if (this.f8217a != null) {
            this.f8217a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f8217a != null) {
            this.f8217a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f8217a != null) {
            this.f8217a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f8217a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f8217a != null) {
            this.f8217a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
