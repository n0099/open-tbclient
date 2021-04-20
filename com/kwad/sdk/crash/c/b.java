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
    public static final String f34729a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f34730b;

    /* renamed from: c  reason: collision with root package name */
    public e f34731c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f34732d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f34733e;

    /* renamed from: f  reason: collision with root package name */
    public File f34734f;

    /* renamed from: g  reason: collision with root package name */
    public File f34735g;

    /* renamed from: h  reason: collision with root package name */
    public File f34736h;
    public File i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f34730b = file;
        if (file.exists()) {
            return;
        }
        f34730b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f34733e = file;
        if (!file.exists()) {
            this.f34733e.mkdirs();
        }
        File file2 = this.f34733e;
        this.f34734f = new File(file2, f34729a + "-" + this.f34732d + ".dump");
        File file3 = this.f34733e;
        this.f34735g = new File(file3, f34729a + "-" + this.f34732d + ".log");
        File file4 = this.f34733e;
        this.f34736h = new File(file4, f34729a + "-" + this.f34732d + ".jtrace");
        this.f34731c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f34733e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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
        File file2 = f34730b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f34730b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f34730b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
