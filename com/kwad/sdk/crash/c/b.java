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
    public static final String f32964a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public static File f32965b;

    /* renamed from: c  reason: collision with root package name */
    public e f32966c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f32967d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public File f32968e;

    /* renamed from: f  reason: collision with root package name */
    public File f32969f;

    /* renamed from: g  reason: collision with root package name */
    public File f32970g;

    /* renamed from: h  reason: collision with root package name */
    public File f32971h;

    /* renamed from: i  reason: collision with root package name */
    public File f32972i;
    public com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        f32965b = file;
        if (file.exists()) {
            return;
        }
        f32965b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.f32968e = file;
        if (!file.exists()) {
            this.f32968e.mkdirs();
        }
        File file2 = this.f32968e;
        this.f32969f = new File(file2, f32964a + "-" + this.f32967d + ".dump");
        File file3 = this.f32968e;
        this.f32970g = new File(file3, f32964a + "-" + this.f32967d + ".log");
        File file4 = this.f32968e;
        this.f32971h = new File(file4, f32964a + "-" + this.f32967d + ".jtrace");
        this.f32966c = eVar;
        this.j = cVar;
    }

    public abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    public void b() {
        File[] listFiles = this.f32968e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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
        File file2 = f32965b;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            f32965b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), f32965b);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    public abstract int c();
}
