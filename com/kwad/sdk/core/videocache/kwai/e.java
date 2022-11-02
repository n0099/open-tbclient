package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes8.dex */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    public final ExecutorService aeY = com.kwad.sdk.core.threads.b.vh();

    /* loaded from: classes8.dex */
    public class a implements Callable<Void> {
        public final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: sH */
        public Void call() {
            e.this.w(this.file);
            return null;
        }
    }

    private void s(List<File> list) {
        long t = t(list);
        list.size();
        for (File file : list) {
            if (!J(t)) {
                long length = file.length();
                if (file.delete()) {
                    t -= length;
                } else {
                    com.kwad.sdk.core.e.b.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    public static long t(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(File file) {
        d.t(file);
        s(d.s(file.getParentFile()));
    }

    public abstract boolean J(long j);

    @Override // com.kwad.sdk.core.videocache.kwai.a
    public final void p(File file) {
        this.aeY.submit(new a(file));
    }
}
