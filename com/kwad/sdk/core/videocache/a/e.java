package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f34799a = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final File f34801b;

        public a(File file) {
            this.f34801b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            e.this.b(this.f34801b);
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
                    com.kwad.sdk.core.d.a.d("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
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

    @Override // com.kwad.sdk.core.videocache.a.a
    public void a(File file) {
        this.f34799a.submit(new a(file));
    }

    public abstract boolean a(File file, long j, int i2);
}
