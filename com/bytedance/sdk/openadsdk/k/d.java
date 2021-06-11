package com.bytedance.sdk.openadsdk.k;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.k.b;
import com.bytedance.sdk.openadsdk.k.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f29478e;

    /* renamed from: c  reason: collision with root package name */
    public final b<Runnable> f29481c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f29482d;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.b.c f29483f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.c f29484g;

    /* renamed from: h  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.b f29485h;
    public volatile c k;
    public volatile c l;
    public volatile String m;
    public volatile boolean n;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f29479a = 163840;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<Map<String, com.bytedance.sdk.openadsdk.k.b>> f29480b = new SparseArray<>(2);

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<a> f29486i = new HashSet<>();
    public final b.InterfaceC0311b j = new b.InterfaceC0311b() { // from class: com.bytedance.sdk.openadsdk.k.d.1
        @Override // com.bytedance.sdk.openadsdk.k.b.InterfaceC0311b
        public void a(com.bytedance.sdk.openadsdk.k.b bVar) {
            int f2 = bVar.f();
            synchronized (d.this.f29480b) {
                Map map = (Map) d.this.f29480b.get(f2);
                if (map != null) {
                    map.remove(bVar.f29429h);
                }
            }
            if (e.f29504c) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.f29429h);
            }
        }
    };

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f29495a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29496b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29497c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29498d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, String> f29499e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f29500f;

        public a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String[] strArr) {
            this.f29495a = z;
            this.f29496b = z2;
            this.f29497c = i2;
            this.f29498d = str;
            this.f29499e = map;
            this.f29500f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f29495a == aVar.f29495a && this.f29496b == aVar.f29496b && this.f29497c == aVar.f29497c) {
                return this.f29498d.equals(aVar.f29498d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f29495a ? 1 : 0) * 31) + (this.f29496b ? 1 : 0)) * 31) + this.f29497c) * 31) + this.f29498d.hashCode();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f29501a;

        public b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f29501a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor != null) {
                    this.f29501a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f29501a.getPoolSize();
                int activeCount = this.f29501a.getActiveCount();
                int maximumPoolSize = this.f29501a.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (e.f29504c) {
                        Log.i("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    public d() {
        b<Runnable> bVar = new b<>();
        this.f29481c = bVar;
        ExecutorService a2 = a(bVar);
        this.f29482d = a2;
        this.f29481c.a((ThreadPoolExecutor) a2);
        this.f29480b.put(0, new HashMap());
        this.f29480b.put(1, new HashMap());
    }

    public static d c() {
        if (f29478e == null) {
            synchronized (d.class) {
                if (f29478e == null) {
                    f29478e = new d();
                }
            }
        }
        return f29478e;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.k.g.d.a(new com.bytedance.sdk.openadsdk.l.g("cancelAll") { // from class: com.bytedance.sdk.openadsdk.k.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.k.b> arrayList = new ArrayList();
                synchronized (d.this.f29480b) {
                    int size = d.this.f29480b.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Map map = (Map) d.this.f29480b.get(d.this.f29480b.keyAt(i2));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.f29481c.clear();
                }
                for (com.bytedance.sdk.openadsdk.k.b bVar : arrayList) {
                    bVar.a();
                    if (e.f29504c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        this.f29484g = cVar;
    }

    public c b() {
        return this.l;
    }

    public void a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29483f = cVar;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.f29479a = i2;
        }
        if (e.f29504c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i2);
        }
    }

    public synchronized void a(long j, long j2, long j3) {
    }

    public c a() {
        return this.k;
    }

    public void a(boolean z, String str) {
        com.bytedance.sdk.openadsdk.k.b remove;
        this.m = str;
        this.n = z;
        if (e.f29504c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.f29486i) {
                if (!this.f29486i.isEmpty()) {
                    hashSet2 = new HashSet(this.f29486i);
                    this.f29486i.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    a(aVar.f29495a, aVar.f29496b, aVar.f29497c, aVar.f29498d, aVar.f29499e, aVar.f29500f);
                    if (e.f29504c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.f29498d);
                    }
                }
                return;
            }
            return;
        }
        int i2 = e.f29509h;
        if (i2 != 3 && i2 != 2) {
            if (i2 == 1) {
                synchronized (this.f29480b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map = this.f29480b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
                    remove = map != null ? map.remove(str) : null;
                }
                if (remove != null) {
                    remove.a();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f29480b) {
            int size = this.f29480b.size();
            for (int i3 = 0; i3 < size; i3++) {
                Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29480b.get(this.f29480b.keyAt(i3));
                if (map2 != null) {
                    Collection<com.bytedance.sdk.openadsdk.k.b> values = map2.values();
                    if (values != null && !values.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(values);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.bytedance.sdk.openadsdk.k.b bVar = (com.bytedance.sdk.openadsdk.k.b) it2.next();
            bVar.a();
            if (e.f29504c) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.f29428g);
            }
        }
        if (i2 == 3) {
            synchronized (this.f29486i) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    a aVar2 = (a) ((com.bytedance.sdk.openadsdk.k.b) it3.next()).n;
                    if (aVar2 != null) {
                        this.f29486i.add(aVar2);
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i2, String str, String... strArr) {
        a(z, z2, i2, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String... strArr) {
        if (e.f29504c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.k.a.a aVar = z ? this.f29485h : this.f29484g;
        com.bytedance.sdk.openadsdk.k.b.c cVar = this.f29483f;
        if (aVar != null && cVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i3 = i2 <= 0 ? this.f29479a : i2;
            String a2 = z2 ? str : com.bytedance.sdk.openadsdk.k.g.b.a(str);
            File d2 = aVar.d(a2);
            if (d2 != null && d2.length() >= i3) {
                if (e.f29504c) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d2.length() + ", need preload size: " + i3);
                }
            } else if (f.a().a(com.bytedance.sdk.openadsdk.k.b.b.a(z), a2)) {
                if (e.f29504c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.f29480b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29480b.get(z ? 1 : 0);
                    if (map2.containsKey(a2)) {
                        return;
                    }
                    int i4 = i3;
                    a aVar2 = new a(z, z2, i3, str, map, strArr);
                    String str2 = this.m;
                    if (str2 != null) {
                        int i5 = e.f29509h;
                        if (i5 == 3) {
                            synchronized (this.f29486i) {
                                this.f29486i.add(aVar2);
                            }
                            if (e.f29504c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                            }
                            return;
                        } else if (i5 == 2) {
                            if (e.f29504c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                            }
                            return;
                        } else if (i5 == 1 && this.n == z && str2.equals(a2)) {
                            if (e.f29504c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                            }
                            return;
                        }
                    }
                    ArrayList arrayList = null;
                    List<i.b> a3 = com.bytedance.sdk.openadsdk.k.g.d.a(com.bytedance.sdk.openadsdk.k.g.d.a(map));
                    if (a3 != null) {
                        arrayList = new ArrayList(a3.size());
                        int size = a3.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            i.b bVar = a3.get(i6);
                            if (bVar != null) {
                                arrayList.add(new i.b(bVar.f29589a, bVar.f29590b));
                            }
                        }
                    }
                    com.bytedance.sdk.openadsdk.k.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.k.g.d.a(strArr))).a((List<i.b>) arrayList).a(i4).a(this.j).a(aVar2).a();
                    map2.put(a2, a4);
                    this.f29482d.execute(a4);
                }
            }
        } else if (e.f29504c) {
            Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.k.g.d.a(new com.bytedance.sdk.openadsdk.l.g("cancel b b S") { // from class: com.bytedance.sdk.openadsdk.k.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.k.b bVar;
                synchronized (d.this.f29480b) {
                    Map map = (Map) d.this.f29480b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
                    if (map != null) {
                        bVar = (com.bytedance.sdk.openadsdk.k.b) map.remove(z2 ? str : com.bytedance.sdk.openadsdk.k.g.b.a(str));
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
    }

    public static ExecutorService a(final b<Runnable> bVar) {
        int a2 = com.bytedance.sdk.openadsdk.k.g.d.a();
        return new ThreadPoolExecutor(0, a2 < 1 ? 1 : a2 > 4 ? 4 : a2, 60L, TimeUnit.SECONDS, bVar, new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.k.d.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bytedance.sdk.openadsdk.k.d.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                thread.setName("tt_pangle_thread_video_preload_" + thread.getId());
                thread.setDaemon(true);
                if (e.f29504c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.k.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    b.this.offerFirst(runnable);
                    if (e.f29504c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
