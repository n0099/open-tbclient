package com.bytedance.sdk.openadsdk.i.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.i.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final File f4804a;
    private final LinkedHashMap<String, File> b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock d = this.c.readLock();
    private final ReentrantReadWriteLock.WriteLock e = this.c.writeLock();
    private final Set<a> f = Collections.newSetFromMap(new ConcurrentHashMap());
    private volatile long g = 104857600;
    private volatile float h = 0.5f;
    private final b i = new b();
    private final Runnable j = new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            e.a().execute(new g(1) { // from class: com.bytedance.sdk.openadsdk.i.a.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(c.this.g);
                }
            });
        }
    };
    private final Handler k = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f.add(aVar);
        }
    }

    public c(File file) throws IOException {
        String str;
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            if (file == null) {
                str = " dir null";
            } else {
                str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
            }
            throw new IOException("dir error!  " + str);
        }
        this.f4804a = file;
        e.a().execute(new g(5) { // from class: com.bytedance.sdk.openadsdk.i.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e.lock();
        try {
            File[] listFiles = this.f4804a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.i.a.c.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        long longValue = ((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        if (longValue > 0) {
                            return 1;
                        }
                        return 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.b.put(a(file2), file2);
                }
            }
            this.e.unlock();
            c();
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    public void a(long j) {
        this.g = j;
        c();
    }

    private void c() {
        this.k.removeCallbacks(this.j);
        this.k.postDelayed(this.j, 10000L);
    }

    public void a() {
        d.c().d();
        Context a2 = com.bytedance.sdk.openadsdk.i.e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.i.b.c.a(a2).a(0);
        }
        this.k.removeCallbacks(this.j);
        e.a().execute(new g(1) { // from class: com.bytedance.sdk.openadsdk.i.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.b(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File c(String str) {
        this.d.lock();
        File file = this.b.get(str);
        this.d.unlock();
        if (file == null) {
            File file2 = new File(this.f4804a, str);
            this.e.lock();
            this.b.put(str, file2);
            this.e.unlock();
            for (a aVar : this.f) {
                aVar.a(str);
            }
            c();
            return file2;
        }
        return file;
    }

    @Override // com.bytedance.sdk.openadsdk.i.a.a
    public File d(String str) {
        if (this.d.tryLock()) {
            File file = this.b.get(str);
            this.d.unlock();
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef A[LOOP:3: B:39:0x00e9->B:41:0x00ef, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) {
        HashSet hashSet;
        HashSet hashSet2;
        final HashSet hashSet3 = new HashSet();
        this.e.lock();
        long j2 = 0;
        try {
            for (Map.Entry<String, File> entry : this.b.entrySet()) {
                j2 += entry.getValue().length();
            }
        } catch (Throwable th) {
            th = th;
            hashSet = null;
        }
        if (j2 > j) {
            long j3 = ((float) j) * this.h;
            HashSet hashSet4 = new HashSet();
            try {
                long j4 = j2;
                for (Map.Entry<String, File> entry2 : this.b.entrySet()) {
                    File value = entry2.getValue();
                    if (value != null && value.exists()) {
                        if (!this.i.c(a(value))) {
                            long length = value.length();
                            File file = new File(value.getAbsolutePath() + "-tmp");
                            if (value.renameTo(file)) {
                                hashSet3.add(file);
                                j4 -= length;
                                hashSet4.add(entry2.getKey());
                            }
                            j4 = j4;
                        }
                    } else {
                        hashSet4.add(entry2.getKey());
                    }
                    if (j4 <= j3) {
                        break;
                    }
                }
                Iterator it = hashSet4.iterator();
                while (it.hasNext()) {
                    this.b.remove((String) it.next());
                }
                this.e.unlock();
                hashSet2 = hashSet4;
            } catch (Throwable th2) {
                th = th2;
                hashSet = hashSet4;
                try {
                    th.printStackTrace();
                    this.e.unlock();
                    hashSet2 = hashSet;
                    while (r4.hasNext()) {
                    }
                    e.a().execute(new g(1) { // from class: com.bytedance.sdk.openadsdk.i.a.c.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator it2 = hashSet3.iterator();
                            while (it2.hasNext()) {
                                try {
                                    ((File) it2.next()).delete();
                                } catch (Throwable th3) {
                                }
                            }
                        }
                    });
                } finally {
                    this.e.unlock();
                }
            }
            for (a aVar : this.f) {
                aVar.a(hashSet2);
            }
            e.a().execute(new g(1) { // from class: com.bytedance.sdk.openadsdk.i.a.c.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = hashSet3.iterator();
                    while (it2.hasNext()) {
                        try {
                            ((File) it2.next()).delete();
                        } catch (Throwable th3) {
                        }
                    }
                }
            });
        }
    }

    private String a(File file) {
        return file.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, Integer> f4811a;

        private b() {
            this.f4811a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f4811a.get(str);
                if (num == null) {
                    this.f4811a.put(str, 1);
                } else {
                    this.f4811a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f4811a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f4811a.remove(str);
                } else {
                    this.f4811a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean c(String str) {
            return !TextUtils.isEmpty(str) ? this.f4811a.containsKey(str) : false;
        }
    }
}
