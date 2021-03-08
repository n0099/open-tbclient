package com.kwad.sdk.crash.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.utils.g;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6376a = UUID.randomUUID().toString();
    public static File b;
    protected e c;
    protected AtomicInteger d = new AtomicInteger();
    protected File e;
    protected File f;
    protected File g;
    protected File h;
    protected File i;
    protected com.kwad.sdk.crash.report.c j;

    public static void a(File file) {
        b = file;
        if (b.exists()) {
            return;
        }
        b.mkdirs();
    }

    public final com.kwad.sdk.crash.report.c a() {
        return this.j;
    }

    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        this.e = file;
        if (!this.e.exists()) {
            this.e.mkdirs();
        }
        this.f = new File(this.e, f6376a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d + ".dump");
        this.g = new File(this.e, f6376a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
        this.h = new File(this.e, f6376a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d + ".jtrace");
        this.c = eVar;
        this.j = cVar;
    }

    protected abstract void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        File[] listFiles = this.e.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.c.b.1
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(File file) {
        if (b == null) {
            return;
        }
        if (!b.exists()) {
            b.mkdirs();
        }
        try {
            g.a(file.getParentFile().getParentFile(), b);
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    protected abstract int c();
}
