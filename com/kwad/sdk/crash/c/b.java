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
/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35186a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f35187b;

    /* renamed from: c  reason: collision with root package name */
    public e f35188c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f35189d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f35190e;

    /* renamed from: f  reason: collision with root package name */
    public File f35191f;

    /* renamed from: g  reason: collision with root package name */
    public File f35192g;

    /* renamed from: h  reason: collision with root package name */
    public File f35193h;

    /* renamed from: i  reason: collision with root package name */
    public File f35194i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f35187b = file;
        if (file.exists()) {
            return;
        }
        f35187b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f35190e = file;
        if (!file.exists()) {
            this.f35190e.mkdirs();
        }
        File file2 = this.f35190e;
        this.f35191f = new File(file2, f35186a + "-" + this.f35189d + ".dump");
        File file3 = this.f35190e;
        this.f35192g = new File(file3, f35186a + "-" + this.f35189d + ".log");
        File file4 = this.f35190e;
        this.f35193h = new File(file4, f35186a + "-" + this.f35189d + ".jtrace");
        this.f35188c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f35190e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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
        File file2 = f35187b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f35187b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f35187b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
