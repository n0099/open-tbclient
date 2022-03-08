package com.kwad.sdk.crash.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class b {
    public static final String a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f55083b;

    /* renamed from: c  reason: collision with root package name */
    public e f55084c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f55085d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f55086e;

    /* renamed from: f  reason: collision with root package name */
    public File f55087f;

    /* renamed from: g  reason: collision with root package name */
    public File f55088g;

    /* renamed from: h  reason: collision with root package name */
    public File f55089h;

    /* renamed from: i  reason: collision with root package name */
    public File f55090i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.crash.report.c f55091j;

    public static void a(File file) {
        f55083b = file;
        if (file.exists()) {
            return;
        }
        f55083b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.f55091j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f55086e = file;
        if (!file.exists()) {
            this.f55086e.mkdirs();
        }
        File file2 = this.f55086e;
        this.f55087f = new File(file2, a + "-" + this.f55085d + ".dump");
        File file3 = this.f55086e;
        this.f55088g = new File(file3, a + "-" + this.f55085d + ".log");
        File file4 = this.f55086e;
        this.f55089h = new File(file4, a + "-" + this.f55085d + ".jtrace");
        this.f55084c = eVar;
        this.f55091j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f55086e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (listFiles == null || listFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
        a(listFiles, countDownLatch);
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public void b(File file) {
        File file2 = f55083b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f55083b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f55083b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
