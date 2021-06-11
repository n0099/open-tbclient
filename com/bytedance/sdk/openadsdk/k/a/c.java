package com.bytedance.sdk.openadsdk.k.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.k.d;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
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
public class c extends com.bytedance.sdk.openadsdk.k.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final File f29434a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap<String, File> f29435b = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: c  reason: collision with root package name */
    public final ReentrantReadWriteLock f29436c;

    /* renamed from: d  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f29437d;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f29438e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<a> f29439f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f29440g;

    /* renamed from: h  reason: collision with root package name */
    public volatile float f29441h;

    /* renamed from: i  reason: collision with root package name */
    public final b f29442i;
    public final Runnable j;
    public final Handler k;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, Integer> f29451a;

        public b() {
            this.f29451a = new HashMap();
        }

        public synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f29451a.get(str);
                if (num == null) {
                    this.f29451a.put(str, 1);
                } else {
                    this.f29451a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        public synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f29451a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f29451a.remove(str);
                } else {
                    this.f29451a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f29451a.containsKey(str);
        }
    }

    public c(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f29436c = reentrantReadWriteLock;
        this.f29437d = reentrantReadWriteLock.readLock();
        this.f29438e = this.f29436c.writeLock();
        this.f29439f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f29440g = 104857600L;
        this.f29441h = 0.5f;
        this.f29442i = new b();
        this.j = new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                e.a(new g("cleanupCmd", 1) { // from class: com.bytedance.sdk.openadsdk.k.a.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        cVar.b(cVar.f29440g);
                    }
                });
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f29434a = file;
            e.a(new g("DiskLruCache", 5) { // from class: com.bytedance.sdk.openadsdk.k.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  " + str);
    }

    private void c() {
        this.k.removeCallbacks(this.j);
        this.k.postDelayed(this.j, 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public File d(String str) {
        if (this.f29437d.tryLock()) {
            File file = this.f29435b.get(str);
            this.f29437d.unlock();
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f29438e.lock();
        try {
            File[] listFiles = this.f29434a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.k.a.c.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue()) > 0L ? 1 : ((((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue()) == 0L ? 0 : -1));
                        if (i2 < 0) {
                            return -1;
                        }
                        return i2 > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.f29435b.put(a(file2), file2);
                }
            }
            this.f29438e.unlock();
            c();
        } catch (Throwable th) {
            this.f29438e.unlock();
            throw th;
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f29439f.add(aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public File c(String str) {
        this.f29437d.lock();
        File file = this.f29435b.get(str);
        this.f29437d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f29434a, str);
        this.f29438e.lock();
        this.f29435b.put(str, file2);
        this.f29438e.unlock();
        for (a aVar : this.f29439f) {
            aVar.a(str);
        }
        c();
        return file2;
    }

    public void a(long j) {
        this.f29440g = j;
        c();
    }

    public void a() {
        d.c().d();
        Context a2 = com.bytedance.sdk.openadsdk.k.e.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.k.b.c.a(a2).a(0);
        }
        this.k.removeCallbacks(this.j);
        e.a(new g("clear", 1) { // from class: com.bytedance.sdk.openadsdk.k.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29442i.a(str);
    }

    private String a(File file) {
        return file.getName();
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29442i.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[LOOP:3: B:41:0x00de->B:43:0x00e4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) {
        final HashSet hashSet = new HashSet();
        this.f29438e.lock();
        long j2 = 0;
        HashSet hashSet2 = null;
        try {
            for (Map.Entry<String, File> entry : this.f29435b.entrySet()) {
                j2 += entry.getValue().length();
            }
        } catch (Throwable th) {
            th = th;
        }
        if (j2 <= j) {
            return;
        }
        long j3 = ((float) j) * this.f29441h;
        HashSet hashSet3 = new HashSet();
        try {
            for (Map.Entry<String, File> entry2 : this.f29435b.entrySet()) {
                File value = entry2.getValue();
                if (value != null && value.exists()) {
                    if (!this.f29442i.c(a(value))) {
                        long length = value.length();
                        File file = new File(value.getAbsolutePath() + "-tmp");
                        if (value.renameTo(file)) {
                            hashSet.add(file);
                            j2 -= length;
                            hashSet3.add(entry2.getKey());
                        }
                    }
                } else {
                    hashSet3.add(entry2.getKey());
                }
                if (j2 <= j3) {
                    break;
                }
            }
            Iterator it = hashSet3.iterator();
            while (it.hasNext()) {
                this.f29435b.remove((String) it.next());
            }
        } catch (Throwable th2) {
            th = th2;
            hashSet2 = hashSet3;
            try {
                th.printStackTrace();
                this.f29438e.unlock();
                hashSet3 = hashSet2;
                while (r13.hasNext()) {
                }
                e.a(new g("trimSize", 1) { // from class: com.bytedance.sdk.openadsdk.k.a.c.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            try {
                                ((File) it2.next()).delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } finally {
                this.f29438e.unlock();
            }
        }
        for (a aVar : this.f29439f) {
            aVar.a(hashSet3);
        }
        e.a(new g("trimSize", 1) { // from class: com.bytedance.sdk.openadsdk.k.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    try {
                        ((File) it2.next()).delete();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
