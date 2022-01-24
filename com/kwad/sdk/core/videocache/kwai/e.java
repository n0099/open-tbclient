package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    public final ExecutorService a = com.kwad.sdk.core.i.b.b();

    /* loaded from: classes3.dex */
    public class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final File f56351b;

        public a(File file) {
            this.f56351b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            e.this.b(this.f56351b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b2, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                } else {
                    com.kwad.sdk.core.d.a.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        long j2 = 0;
        for (File file : list) {
            j2 += file.length();
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.kwad.sdk.core.videocache.kwai.a
    public void a(File file) {
        this.a.submit(new a(file));
    }

    public abstract boolean a(File file, long j2, int i2);
}
