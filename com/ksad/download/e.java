package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f5300a;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f5301a = new e();
    }

    public static e a() {
        return a.f5301a;
    }

    public synchronized void a(int i) {
        if (this.f5300a != null) {
            this.f5300a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f5300a != null) {
            this.f5300a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f5300a != null) {
            this.f5300a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f5300a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f5300a != null) {
            this.f5300a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
