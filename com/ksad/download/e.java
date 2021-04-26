package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f32421a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f32422a = new e();
    }

    public static e a() {
        return a.f32422a;
    }

    public synchronized void a(int i2) {
        if (this.f32421a != null) {
            this.f32421a.a(i2);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f32421a != null) {
            this.f32421a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f32421a != null) {
            this.f32421a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f32421a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f32421a != null) {
            this.f32421a.b(downloadTask);
        }
    }

    public synchronized void c(DownloadTask downloadTask) {
        if (this.f32421a != null) {
            this.f32421a.c(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
