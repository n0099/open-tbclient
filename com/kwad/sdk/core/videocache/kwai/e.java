package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    public final ExecutorService a = com.kwad.sdk.core.threads.b.a();

    /* loaded from: classes5.dex */
    public class a implements Callable<Void> {
        public final File b;

        public a(File file) {
            this.b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            e.this.b(this.b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b = b(list);
        list.size();
        for (File file : list) {
            if (!a(b)) {
                long length = file.length();
                if (file.delete()) {
                    b -= length;
                } else {
                    com.kwad.sdk.core.d.b.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    public static long b(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.kwad.sdk.core.videocache.kwai.a
    public final void a(File file) {
        this.a.submit(new a(file));
    }

    public abstract boolean a(long j);
}
