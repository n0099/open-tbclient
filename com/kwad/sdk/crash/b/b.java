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
/* loaded from: classes5.dex */
public abstract class b {
    public static final String a = UUID.randomUUID().toString();
    public static File b;
    public e c;
    public AtomicInteger d = new AtomicInteger();
    public File e;
    public File f;
    public File g;
    public File h;
    public File i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        b = file;
        if (file.exists()) {
            return;
        }
        b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.e = file;
        if (!file.exists()) {
            this.e.mkdirs();
        }
        File file2 = this.e;
        this.f = new File(file2, a + "-" + this.d + ".dump");
        File file3 = this.e;
        this.g = new File(file3, a + "-" + this.d + ".log");
        File file4 = this.e;
        this.h = new File(file4, a + "-" + this.d + ".jtrace");
        this.c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.b.b.1
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
        } catch (InterruptedException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    public void b(File file) {
        File file2 = b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), b);
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    public abstract int c();
}
