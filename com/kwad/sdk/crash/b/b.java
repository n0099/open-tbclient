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
/* loaded from: classes3.dex */
public abstract class b {
    public static final String a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f56566b;

    /* renamed from: c  reason: collision with root package name */
    public e f56567c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f56568d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f56569e;

    /* renamed from: f  reason: collision with root package name */
    public File f56570f;

    /* renamed from: g  reason: collision with root package name */
    public File f56571g;

    /* renamed from: h  reason: collision with root package name */
    public File f56572h;

    /* renamed from: i  reason: collision with root package name */
    public File f56573i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.crash.report.c f56574j;

    public static void a(File file) {
        f56566b = file;
        if (file.exists()) {
            return;
        }
        f56566b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.f56574j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f56569e = file;
        if (!file.exists()) {
            this.f56569e.mkdirs();
        }
        File file2 = this.f56569e;
        this.f56570f = new File(file2, a + "-" + this.f56568d + ".dump");
        File file3 = this.f56569e;
        this.f56571g = new File(file3, a + "-" + this.f56568d + ".log");
        File file4 = this.f56569e;
        this.f56572h = new File(file4, a + "-" + this.f56568d + ".jtrace");
        this.f56567c = eVar;
        this.f56574j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f56569e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
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
        File file2 = f56566b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f56566b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f56566b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
