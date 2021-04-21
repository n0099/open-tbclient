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
/* loaded from: classes5.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f29301e;

    /* renamed from: c  reason: collision with root package name */
    public final b<Runnable> f29304c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f29305d;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.b.c f29306f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.c f29307g;

    /* renamed from: h  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.b f29308h;
    public volatile c k;
    public volatile c l;
    public volatile String m;
    public volatile boolean n;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f29302a = 163840;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<Map<String, com.bytedance.sdk.openadsdk.k.b>> f29303b = new SparseArray<>(2);
    public final HashSet<a> i = new HashSet<>();
    public final b.InterfaceC0328b j = new b.InterfaceC0328b() { // from class: com.bytedance.sdk.openadsdk.k.d.1
        @Override // com.bytedance.sdk.openadsdk.k.b.InterfaceC0328b
        public void a(com.bytedance.sdk.openadsdk.k.b bVar) {
            int f2 = bVar.f();
            synchronized (d.this.f29303b) {
                Map map = (Map) d.this.f29303b.get(f2);
                if (map != null) {
                    map.remove(bVar.f29255h);
                }
            }
            if (e.f29326c) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.f29255h);
            }
        }
    };

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f29317a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29318b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29319c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29320d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, String> f29321e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f29322f;

        public a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f29317a = z;
            this.f29318b = z2;
            this.f29319c = i;
            this.f29320d = str;
            this.f29321e = map;
            this.f29322f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f29317a == aVar.f29317a && this.f29318b == aVar.f29318b && this.f29319c == aVar.f29319c) {
                return this.f29320d.equals(aVar.f29320d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f29317a ? 1 : 0) * 31) + (this.f29318b ? 1 : 0)) * 31) + this.f29319c) * 31) + this.f29320d.hashCode();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f29323a;

        public b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f29323a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor != null) {
                    this.f29323a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f29323a.getPoolSize();
                int activeCount = this.f29323a.getActiveCount();
                int maximumPoolSize = this.f29323a.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (e.f29326c) {
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
        this.f29304c = bVar;
        ExecutorService a2 = a(bVar);
        this.f29305d = a2;
        this.f29304c.a((ThreadPoolExecutor) a2);
        this.f29303b.put(0, new HashMap());
        this.f29303b.put(1, new HashMap());
    }

    public static d c() {
        if (f29301e == null) {
            synchronized (d.class) {
                if (f29301e == null) {
                    f29301e = new d();
                }
            }
        }
        return f29301e;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.k.g.d.a(new com.bytedance.sdk.openadsdk.l.g("cancelAll") { // from class: com.bytedance.sdk.openadsdk.k.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.k.b> arrayList = new ArrayList();
                synchronized (d.this.f29303b) {
                    int size = d.this.f29303b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.f29303b.get(d.this.f29303b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.f29304c.clear();
                }
                for (com.bytedance.sdk.openadsdk.k.b bVar : arrayList) {
                    bVar.a();
                    if (e.f29326c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        this.f29307g = cVar;
    }

    public c b() {
        return this.l;
    }

    public void a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29306f = cVar;
    }

    public void a(int i) {
        if (i > 0) {
            this.f29302a = i;
        }
        if (e.f29326c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i);
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
        if (e.f29326c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.i) {
                if (!this.i.isEmpty()) {
                    hashSet2 = new HashSet(this.i);
                    this.i.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    a(aVar.f29317a, aVar.f29318b, aVar.f29319c, aVar.f29320d, aVar.f29321e, aVar.f29322f);
                    if (e.f29326c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.f29320d);
                    }
                }
                return;
            }
            return;
        }
        int i = e.f29331h;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.f29303b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map = this.f29303b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
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
        synchronized (this.f29303b) {
            int size = this.f29303b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29303b.get(this.f29303b.keyAt(i2));
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
            if (e.f29326c) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.f29254g);
            }
        }
        if (i == 3) {
            synchronized (this.i) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    a aVar2 = (a) ((com.bytedance.sdk.openadsdk.k.b) it3.next()).n;
                    if (aVar2 != null) {
                        this.i.add(aVar2);
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i, String str, String... strArr) {
        a(z, z2, i, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        if (e.f29326c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.k.a.a aVar = z ? this.f29308h : this.f29307g;
        com.bytedance.sdk.openadsdk.k.b.c cVar = this.f29306f;
        if (aVar != null && cVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i2 = i <= 0 ? this.f29302a : i;
            String a2 = z2 ? str : com.bytedance.sdk.openadsdk.k.g.b.a(str);
            File d2 = aVar.d(a2);
            if (d2 != null && d2.length() >= i2) {
                if (e.f29326c) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d2.length() + ", need preload size: " + i2);
                }
            } else if (f.a().a(com.bytedance.sdk.openadsdk.k.b.b.a(z), a2)) {
                if (e.f29326c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.f29303b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29303b.get(z ? 1 : 0);
                    if (map2.containsKey(a2)) {
                        return;
                    }
                    int i3 = i2;
                    a aVar2 = new a(z, z2, i2, str, map, strArr);
                    String str2 = this.m;
                    if (str2 != null) {
                        int i4 = e.f29331h;
                        if (i4 == 3) {
                            synchronized (this.i) {
                                this.i.add(aVar2);
                            }
                            if (e.f29326c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                            }
                            return;
                        } else if (i4 == 2) {
                            if (e.f29326c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                            }
                            return;
                        } else if (i4 == 1 && this.n == z && str2.equals(a2)) {
                            if (e.f29326c) {
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
                        for (int i5 = 0; i5 < size; i5++) {
                            i.b bVar = a3.get(i5);
                            if (bVar != null) {
                                arrayList.add(new i.b(bVar.f29409a, bVar.f29410b));
                            }
                        }
                    }
                    com.bytedance.sdk.openadsdk.k.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.k.g.d.a(strArr))).a((List<i.b>) arrayList).a(i3).a(this.j).a(aVar2).a();
                    map2.put(a2, a4);
                    this.f29305d.execute(a4);
                }
            }
        } else if (e.f29326c) {
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
                synchronized (d.this.f29303b) {
                    Map map = (Map) d.this.f29303b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
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
                if (e.f29326c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.k.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    b.this.offerFirst(runnable);
                    if (e.f29326c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
