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
    public static File f58735b;

    /* renamed from: c  reason: collision with root package name */
    public e f58736c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f58737d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f58738e;

    /* renamed from: f  reason: collision with root package name */
    public File f58739f;

    /* renamed from: g  reason: collision with root package name */
    public File f58740g;

    /* renamed from: h  reason: collision with root package name */
    public File f58741h;

    /* renamed from: i  reason: collision with root package name */
    public File f58742i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.crash.report.c f58743j;

    public static void a(File file) {
        f58735b = file;
        if (file.exists()) {
            return;
        }
        f58735b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.f58743j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f58738e = file;
        if (!file.exists()) {
            this.f58738e.mkdirs();
        }
        File file2 = this.f58738e;
        this.f58739f = new File(file2, a + "-" + this.f58737d + ".dump");
        File file3 = this.f58738e;
        this.f58740g = new File(file3, a + "-" + this.f58737d + ".log");
        File file4 = this.f58738e;
        this.f58741h = new File(file4, a + "-" + this.f58737d + ".jtrace");
        this.f58736c = eVar;
        this.f58743j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f58738e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
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
        File file2 = f58735b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f58735b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f58735b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
