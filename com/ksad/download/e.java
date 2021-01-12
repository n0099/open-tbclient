package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f7917a;

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f7918a = new e();
    }

    public static e a() {
        return a.f7918a;
    }

    public synchronized void a(int i) {
        if (this.f7917a != null) {
            this.f7917a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f7917a != null) {
            this.f7917a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f7917a != null) {
            this.f7917a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f7917a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f7917a != null) {
            this.f7917a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
