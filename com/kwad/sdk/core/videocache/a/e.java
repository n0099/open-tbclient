package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f9775a = Executors.newSingleThreadExecutor();

    /* loaded from: classes5.dex */
    private class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        private final File f9777b;

        public a(File file) {
            this.f9777b = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            e.this.b(this.f9777b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        Iterator<File> it = list.iterator();
        while (true) {
            int i = size;
            if (!it.hasNext()) {
                return;
            }
            File next = it.next();
            if (!a(next, b2, i)) {
                long length = next.length();
                if (next.delete()) {
                    i--;
                    b2 -= length;
                } else {
                    com.kwad.sdk.core.d.a.d("LruDiskUsage", "Error deleting file " + next + " for trimming cache");
                }
            }
            size = i;
        }
    }

    private long b(List<File> list) {
        long j = 0;
        Iterator<File> it = list.iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = it.next().length() + j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.kwad.sdk.core.videocache.a.a
    public void a(File file) {
        this.f9775a.submit(new a(file));
    }

    protected abstract boolean a(File file, long j, int i);
}
