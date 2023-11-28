package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    public final ExecutorService aBx = GlobalThreadPools.Es();

    public abstract boolean am(long j);

    /* loaded from: classes10.dex */
    public class a implements Callable<Void> {
        public final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: BI */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    public static long A(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        d.w(file);
        z(d.v(file.getParentFile()));
    }

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aBx.submit(new a(file));
    }

    private void z(List<File> list) {
        long A = A(list);
        list.size();
        for (File file : list) {
            if (!am(A)) {
                long length = file.length();
                if (file.delete()) {
                    A -= length;
                } else {
                    com.kwad.sdk.core.e.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }
}
