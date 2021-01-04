package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f8216a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f8217a = new e();
    }

    public static e a() {
        return a.f8217a;
    }

    public synchronized void a(int i) {
        if (this.f8216a != null) {
            this.f8216a.a(i);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f8216a != null) {
            this.f8216a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f8216a != null) {
            this.f8216a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f8216a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f8216a != null) {
            this.f8216a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
