package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    public final ExecutorService aeY = com.kwad.sdk.core.threads.b.vh();

    /* loaded from: classes7.dex */
    public final class a implements Callable {
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

    private void s(List list) {
        long t = t(list);
        list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
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

    public static long t(List list) {
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
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
