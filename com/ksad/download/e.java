package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f31455a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f31456a = new e();
    }

    public static e a() {
        return a.f31456a;
    }

    public synchronized void a(int i) {
        if (this.f31455a != null) {
            this.f31455a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31455a != null) {
            this.f31455a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31455a != null) {
            this.f31455a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f31455a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f31455a != null) {
            this.f31455a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
