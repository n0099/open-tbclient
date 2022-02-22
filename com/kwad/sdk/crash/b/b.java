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
/* loaded from: classes4.dex */
public abstract class b {
    public static final String a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f56733b;

    /* renamed from: c  reason: collision with root package name */
    public e f56734c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f56735d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f56736e;

    /* renamed from: f  reason: collision with root package name */
    public File f56737f;

    /* renamed from: g  reason: collision with root package name */
    public File f56738g;

    /* renamed from: h  reason: collision with root package name */
    public File f56739h;

    /* renamed from: i  reason: collision with root package name */
    public File f56740i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.crash.report.c f56741j;

    public static void a(File file) {
        f56733b = file;
        if (file.exists()) {
            return;
        }
        f56733b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.f56741j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f56736e = file;
        if (!file.exists()) {
            this.f56736e.mkdirs();
        }
        File file2 = this.f56736e;
        this.f56737f = new File(file2, a + "-" + this.f56735d + ".dump");
        File file3 = this.f56736e;
        this.f56738g = new File(file3, a + "-" + this.f56735d + ".log");
        File file4 = this.f56736e;
        this.f56739h = new File(file4, a + "-" + this.f56735d + ".jtrace");
        this.f56734c = eVar;
        this.f56741j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f56736e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
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
        File file2 = f56733b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f56733b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f56733b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
