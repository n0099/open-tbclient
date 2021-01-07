package com.bytedance.sdk.openadsdk.j.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.j.d;
import com.bytedance.sdk.openadsdk.j.e;
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
/* loaded from: classes4.dex */
public class c extends com.bytedance.sdk.openadsdk.j.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final File f7522a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashMap<String, File> f7523b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock d = this.c.readLock();
    private final ReentrantReadWriteLock.WriteLock e = this.c.writeLock();
    private final Set<a> f = Collections.newSetFromMap(new ConcurrentHashMap());
    private volatile long g = 104857600;
    private volatile float h = 0.5f;
    private final b i = new b();
    private final Runnable j = new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(c.this.g);
                }
            }, 1);
        }
    };
    private final Handler k = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
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
        this.f7522a = file;
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.b();
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e.lock();
        try {
            File[] listFiles = this.f7522a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.j.a.c.3
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
                    this.f7523b.put(a(file2), file2);
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
        Context a2 = e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.j.b.c.a(a2).a(0);
        }
        this.k.removeCallbacks(this.j);
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0L);
            }
        }, 1);
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.b(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public File c(String str) {
        this.d.lock();
        File file = this.f7523b.get(str);
        this.d.unlock();
        if (file == null) {
            File file2 = new File(this.f7522a, str);
            this.e.lock();
            this.f7523b.put(str, file2);
            this.e.unlock();
            for (a aVar : this.f) {
                aVar.a(str);
            }
            c();
            return file2;
        }
        return file;
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    public File d(String str) {
        if (this.d.tryLock()) {
            File file = this.f7523b.get(str);
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
            for (Map.Entry<String, File> entry : this.f7523b.entrySet()) {
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
                for (Map.Entry<String, File> entry2 : this.f7523b.entrySet()) {
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
                    this.f7523b.remove((String) it.next());
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
                    com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.5
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
                    }, 1);
                } finally {
                    this.e.unlock();
                }
            }
            for (a aVar : this.f) {
                aVar.a(hashSet2);
            }
            com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.c.5
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
            }, 1);
        }
    }

    private String a(File file) {
        return file.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, Integer> f7532a;

        private b() {
            this.f7532a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f7532a.get(str);
                if (num == null) {
                    this.f7532a.put(str, 1);
                } else {
                    this.f7532a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f7532a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f7532a.remove(str);
                } else {
                    this.f7532a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean c(String str) {
            return !TextUtils.isEmpty(str) ? this.f7532a.containsKey(str) : false;
        }
    }
}
