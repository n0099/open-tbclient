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
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Pair<FileLock, AtomicLong>> f29986a = new HashMap();

    public static void a(String str) throws Exception {
        synchronized (f29986a) {
            Pair<FileLock, AtomicLong> pair = f29986a.get(str);
            if (pair == null) {
                Pair<FileLock, AtomicLong> pair2 = new Pair<>(FileLock.a(str, Process.myPid()), new AtomicLong(0L));
                f29986a.put(str, pair2);
                pair = pair2;
            }
            ((AtomicLong) pair.second).incrementAndGet();
        }
    }

    public static void b(String str) throws Exception {
        synchronized (f29986a) {
            Pair<FileLock, AtomicLong> pair = f29986a.get(str);
            if (pair != null) {
                int i = (((AtomicLong) pair.second).decrementAndGet() > 0L ? 1 : (((AtomicLong) pair.second).decrementAndGet() == 0L ? 0 : -1));
                if (i < 0) {
                    throw new RuntimeException("using.lock count illegal");
                }
                if (i == 0) {
                    ((FileLock) pair.first).a();
                    f29986a.remove(str);
                }
            } else {
                throw new RuntimeException("using.lock illegal state");
            }
        }
    }

    public static void c(String str) throws Exception {
        synchronized (f29986a) {
            FileLock b2 = FileLock.b(str);
            if (b2 == null) {
                return;
            }
            Pair<FileLock, AtomicLong> pair = f29986a.get(str);
            if (pair != null && ((AtomicLong) pair.second).get() != 0) {
                b2.a();
                FileLock.a(str, Process.myPid());
                return;
            }
            File parentFile = new File(str).getParentFile();
            final File file = new File(parentFile.getAbsolutePath() + "--pending-delete");
            if (parentFile.renameTo(file)) {
                b2.a();
                b2.b();
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
