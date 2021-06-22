package com.ksad.download;

import com.kwad.sdk.core.download.DownloadParams;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public f f31784a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f31785a = new e();
    }

    public static e a() {
        return a.f31785a;
    }

    public synchronized void a(int i2) {
        if (this.f31784a != null) {
            this.f31784a.a(i2);
        }
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31784a != null) {
            this.f31784a.a(downloadTask);
        }
    }

    public synchronized void a(DownloadTask downloadTask, boolean z) {
        if (downloadTask.isCanceled()) {
            a(downloadTask.getId());
        } else if (this.f31784a != null) {
            this.f31784a.a(downloadTask, z);
        }
    }

    public void a(f fVar) {
        this.f31784a = fVar;
    }

    public synchronized void b(DownloadTask downloadTask) {
        if (this.f31784a != null) {
            this.f31784a.b(downloadTask);
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
        }
    }
}
