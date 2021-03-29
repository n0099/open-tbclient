package com.kwad.sdk.crash.c;

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
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34440a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f34441b;

    /* renamed from: c  reason: collision with root package name */
    public e f34442c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f34443d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f34444e;

    /* renamed from: f  reason: collision with root package name */
    public File f34445f;

    /* renamed from: g  reason: collision with root package name */
    public File f34446g;

    /* renamed from: h  reason: collision with root package name */
    public File f34447h;
    public File i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f34441b = file;
        if (file.exists()) {
            return;
        }
        f34441b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f34444e = file;
        if (!file.exists()) {
            this.f34444e.mkdirs();
        }
        File file2 = this.f34444e;
        this.f34445f = new File(file2, f34440a + "-" + this.f34443d + ".dump");
        File file3 = this.f34444e;
        this.f34446g = new File(file3, f34440a + "-" + this.f34443d + ".log");
        File file4 = this.f34444e;
        this.f34447h = new File(file4, f34440a + "-" + this.f34443d + ".jtrace");
        this.f34442c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f34444e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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
        File file2 = f34441b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f34441b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f34441b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
