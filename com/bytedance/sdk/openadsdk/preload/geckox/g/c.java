package com.bytedance.sdk.openadsdk.preload.geckox.g;

import android.os.Process;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Pair<FileLock, AtomicLong>> f5080a = new HashMap();

    public static void a(String str) throws Exception {
        synchronized (f5080a) {
            Pair<FileLock, AtomicLong> pair = f5080a.get(str);
            if (pair == null) {
                pair = new Pair<>(FileLock.a(str, Process.myPid()), new AtomicLong(0L));
                f5080a.put(str, pair);
            }
            ((AtomicLong) pair.second).incrementAndGet();
        }
    }

    public static void b(String str) throws Exception {
        synchronized (f5080a) {
            Pair<FileLock, AtomicLong> pair = f5080a.get(str);
            if (pair == null) {
                throw new RuntimeException("using.lock illegal state");
            }
            long decrementAndGet = ((AtomicLong) pair.second).decrementAndGet();
            if (decrementAndGet < 0) {
                throw new RuntimeException("using.lock count illegal");
            }
            if (decrementAndGet == 0) {
                ((FileLock) pair.first).a();
                f5080a.remove(str);
            }
        }
    }

    public static void c(String str) throws Exception {
        synchronized (f5080a) {
            FileLock b = FileLock.b(str);
            if (b != null) {
                Pair<FileLock, AtomicLong> pair = f5080a.get(str);
                if (pair != null && ((AtomicLong) pair.second).get() != 0) {
                    b.a();
                    FileLock.a(str, Process.myPid());
                    return;
                }
                File parentFile = new File(str).getParentFile();
                final File file = new File(parentFile.getAbsolutePath() + "--pending-delete");
                if (parentFile.renameTo(file)) {
                    b.a();
                    b.b();
                    f.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.g.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.a(file);
                        }
                    });
                }
            }
        }
    }
}
