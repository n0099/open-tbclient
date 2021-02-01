package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f7919a;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f7920a = new e();
    }

    public static e a() {
        return a.f7920a;
    }

    public synchronized void a(int i) {
        if (this.f7919a != null) {
            this.f7919a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f7919a != null) {
            this.f7919a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f7919a != null) {
            this.f7919a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f7919a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f7919a != null) {
            this.f7919a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
