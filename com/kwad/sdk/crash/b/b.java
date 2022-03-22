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
/* loaded from: classes7.dex */
public abstract class b {
    public static final String a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f40162b;

    /* renamed from: c  reason: collision with root package name */
    public e f40163c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f40164d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f40165e;

    /* renamed from: f  reason: collision with root package name */
    public File f40166f;

    /* renamed from: g  reason: collision with root package name */
    public File f40167g;

    /* renamed from: h  reason: collision with root package name */
    public File f40168h;
    public File i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f40162b = file;
        if (file.exists()) {
            return;
        }
        f40162b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f40165e = file;
        if (!file.exists()) {
            this.f40165e.mkdirs();
        }
        File file2 = this.f40165e;
        this.f40166f = new File(file2, a + "-" + this.f40164d + ".dump");
        File file3 = this.f40165e;
        this.f40167g = new File(file3, a + "-" + this.f40164d + ".log");
        File file4 = this.f40165e;
        this.f40168h = new File(file4, a + "-" + this.f40164d + ".jtrace");
        this.f40163c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f40165e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
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
        File file2 = f40162b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f40162b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f40162b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
