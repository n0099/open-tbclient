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
    public static final String f33035a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f33036b;

    /* renamed from: c  reason: collision with root package name */
    public e f33037c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f33038d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f33039e;

    /* renamed from: f  reason: collision with root package name */
    public File f33040f;

    /* renamed from: g  reason: collision with root package name */
    public File f33041g;

    /* renamed from: h  reason: collision with root package name */
    public File f33042h;

    /* renamed from: i  reason: collision with root package name */
    public File f33043i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f33036b = file;
        if (file.exists()) {
            return;
        }
        f33036b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f33039e = file;
        if (!file.exists()) {
            this.f33039e.mkdirs();
        }
        File file2 = this.f33039e;
        this.f33040f = new File(file2, f33035a + "-" + this.f33038d + ".dump");
        File file3 = this.f33039e;
        this.f33041g = new File(file3, f33035a + "-" + this.f33038d + ".log");
        File file4 = this.f33039e;
        this.f33042h = new File(file4, f33035a + "-" + this.f33038d + ".jtrace");
        this.f33037c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f33039e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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
        File file2 = f33036b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f33036b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f33036b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
