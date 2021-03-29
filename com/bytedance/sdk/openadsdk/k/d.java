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
    public static volatile d f29608e;

    /* renamed from: c  reason: collision with root package name */
    public final b<Runnable> f29611c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f29612d;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.b.c f29613f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.c f29614g;

    /* renamed from: h  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.b f29615h;
    public volatile c k;
    public volatile c l;
    public volatile String m;
    public volatile boolean n;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f29609a = 163840;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<Map<String, com.bytedance.sdk.openadsdk.k.b>> f29610b = new SparseArray<>(2);
    public final HashSet<a> i = new HashSet<>();
    public final b.InterfaceC0324b j = new b.InterfaceC0324b() { // from class: com.bytedance.sdk.openadsdk.k.d.1
        @Override // com.bytedance.sdk.openadsdk.k.b.InterfaceC0324b
        public void a(com.bytedance.sdk.openadsdk.k.b bVar) {
            int f2 = bVar.f();
            synchronized (d.this.f29610b) {
                Map map = (Map) d.this.f29610b.get(f2);
                if (map != null) {
                    map.remove(bVar.f29562h);
                }
            }
            if (e.f29633c) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.f29562h);
            }
        }
    };

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f29624a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29625b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29626c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29627d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, String> f29628e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f29629f;

        public a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f29624a = z;
            this.f29625b = z2;
            this.f29626c = i;
            this.f29627d = str;
            this.f29628e = map;
            this.f29629f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f29624a == aVar.f29624a && this.f29625b == aVar.f29625b && this.f29626c == aVar.f29626c) {
                return this.f29627d.equals(aVar.f29627d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f29624a ? 1 : 0) * 31) + (this.f29625b ? 1 : 0)) * 31) + this.f29626c) * 31) + this.f29627d.hashCode();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f29630a;

        public b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f29630a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor != null) {
                    this.f29630a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f29630a.getPoolSize();
                int activeCount = this.f29630a.getActiveCount();
                int maximumPoolSize = this.f29630a.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (e.f29633c) {
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
        this.f29611c = bVar;
        ExecutorService a2 = a(bVar);
        this.f29612d = a2;
        this.f29611c.a((ThreadPoolExecutor) a2);
        this.f29610b.put(0, new HashMap());
        this.f29610b.put(1, new HashMap());
    }

    public static d c() {
        if (f29608e == null) {
            synchronized (d.class) {
                if (f29608e == null) {
                    f29608e = new d();
                }
            }
        }
        return f29608e;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.k.g.d.a(new com.bytedance.sdk.openadsdk.l.g("cancelAll") { // from class: com.bytedance.sdk.openadsdk.k.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.k.b> arrayList = new ArrayList();
                synchronized (d.this.f29610b) {
                    int size = d.this.f29610b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.f29610b.get(d.this.f29610b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.f29611c.clear();
                }
                for (com.bytedance.sdk.openadsdk.k.b bVar : arrayList) {
                    bVar.a();
                    if (e.f29633c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        this.f29614g = cVar;
    }

    public c b() {
        return this.l;
    }

    public void a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29613f = cVar;
    }

    public void a(int i) {
        if (i > 0) {
            this.f29609a = i;
        }
        if (e.f29633c) {
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
        if (e.f29633c) {
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
                    a(aVar.f29624a, aVar.f29625b, aVar.f29626c, aVar.f29627d, aVar.f29628e, aVar.f29629f);
                    if (e.f29633c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.f29627d);
                    }
                }
                return;
            }
            return;
        }
        int i = e.f29638h;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.f29610b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map = this.f29610b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
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
        synchronized (this.f29610b) {
            int size = this.f29610b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29610b.get(this.f29610b.keyAt(i2));
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
            if (e.f29633c) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.f29561g);
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
        if (e.f29633c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.k.a.a aVar = z ? this.f29615h : this.f29614g;
        com.bytedance.sdk.openadsdk.k.b.c cVar = this.f29613f;
        if (aVar != null && cVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i2 = i <= 0 ? this.f29609a : i;
            String a2 = z2 ? str : com.bytedance.sdk.openadsdk.k.g.b.a(str);
            File d2 = aVar.d(a2);
            if (d2 != null && d2.length() >= i2) {
                if (e.f29633c) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d2.length() + ", need preload size: " + i2);
                }
            } else if (f.a().a(com.bytedance.sdk.openadsdk.k.b.b.a(z), a2)) {
                if (e.f29633c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.f29610b) {
                    Map<String, com.bytedance.sdk.openadsdk.k.b> map2 = this.f29610b.get(z ? 1 : 0);
                    if (map2.containsKey(a2)) {
                        return;
                    }
                    int i3 = i2;
                    a aVar2 = new a(z, z2, i2, str, map, strArr);
                    String str2 = this.m;
                    if (str2 != null) {
                        int i4 = e.f29638h;
                        if (i4 == 3) {
                            synchronized (this.i) {
                                this.i.add(aVar2);
                            }
                            if (e.f29633c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                            }
                            return;
                        } else if (i4 == 2) {
                            if (e.f29633c) {
                                Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                            }
                            return;
                        } else if (i4 == 1 && this.n == z && str2.equals(a2)) {
                            if (e.f29633c) {
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
                                arrayList.add(new i.b(bVar.f29716a, bVar.f29717b));
                            }
                        }
                    }
                    com.bytedance.sdk.openadsdk.k.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.k.g.d.a(strArr))).a((List<i.b>) arrayList).a(i3).a(this.j).a(aVar2).a();
                    map2.put(a2, a4);
                    this.f29612d.execute(a4);
                }
            }
        } else if (e.f29633c) {
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
                synchronized (d.this.f29610b) {
                    Map map = (Map) d.this.f29610b.get(com.bytedance.sdk.openadsdk.k.b.b.a(z));
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
                if (e.f29633c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.k.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    b.this.offerFirst(runnable);
                    if (e.f29633c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
