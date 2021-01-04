package com.bytedance.sdk.openadsdk.j;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.j.i;
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
/* loaded from: classes4.dex */
public class d {
    private static volatile d e;
    private volatile com.bytedance.sdk.openadsdk.j.b.c f;
    private volatile com.bytedance.sdk.openadsdk.j.a.c g;
    private volatile com.bytedance.sdk.openadsdk.j.a.b h;
    private volatile c k;
    private volatile c l;
    private volatile String m;
    private volatile boolean n;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f7544a = 163840;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<Map<String, com.bytedance.sdk.openadsdk.j.b>> f7545b = new SparseArray<>(2);
    private final HashSet<a> i = new HashSet<>();
    private final b.InterfaceC0997b j = new b.InterfaceC0997b() { // from class: com.bytedance.sdk.openadsdk.j.d.1
        @Override // com.bytedance.sdk.openadsdk.j.b.InterfaceC0997b
        public void a(com.bytedance.sdk.openadsdk.j.b bVar) {
            int f = bVar.f();
            synchronized (d.this.f7545b) {
                Map map = (Map) d.this.f7545b.get(f);
                if (map != null) {
                    map.remove(bVar.h);
                }
            }
            if (e.c) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.h);
            }
        }
    };
    private final b<Runnable> c = new b<>();
    private final ExecutorService d = a(this.c);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        this.g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.j.b.c cVar) {
        this.f = cVar;
    }

    public void a(int i) {
        if (i > 0) {
            this.f7544a = i;
        }
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i);
        }
    }

    private d() {
        this.c.a((ThreadPoolExecutor) this.d);
        this.f7545b.put(0, new HashMap());
        this.f7545b.put(1, new HashMap());
    }

    public synchronized void a(long j, long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return this.l;
    }

    public static d c() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, String str) {
        com.bytedance.sdk.openadsdk.j.b bVar;
        com.bytedance.sdk.openadsdk.j.b remove;
        HashSet hashSet = null;
        this.m = str;
        this.n = z;
        if (e.c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        if (str == null) {
            synchronized (this.i) {
                if (!this.i.isEmpty()) {
                    hashSet = new HashSet(this.i);
                    this.i.clear();
                }
            }
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    a(aVar.f7552a, aVar.f7553b, aVar.c, aVar.d, aVar.e, aVar.f);
                    if (e.c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.d);
                    }
                }
                return;
            }
            return;
        }
        int i = e.h;
        if (i == 3 || i == 2) {
            synchronized (this.f7545b) {
                int size = this.f7545b.size();
                int i2 = 0;
                while (i2 < size) {
                    Map<String, com.bytedance.sdk.openadsdk.j.b> map = this.f7545b.get(this.f7545b.keyAt(i2));
                    if (map != null) {
                        Collection<com.bytedance.sdk.openadsdk.j.b> values = map.values();
                        if (values != null && !values.isEmpty()) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.addAll(values);
                        }
                        map.clear();
                    }
                    i2++;
                    hashSet = hashSet;
                }
            }
            if (hashSet != null && !hashSet.isEmpty()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((com.bytedance.sdk.openadsdk.j.b) it2.next()).a();
                    if (e.c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.g);
                    }
                }
                if (i == 3) {
                    synchronized (this.i) {
                        Iterator it3 = hashSet.iterator();
                        while (it3.hasNext()) {
                            a aVar2 = (a) ((com.bytedance.sdk.openadsdk.j.b) it3.next()).n;
                            if (aVar2 != null) {
                                this.i.add(aVar2);
                            }
                        }
                    }
                }
            }
        } else if (i == 1) {
            synchronized (this.f7545b) {
                Map<String, com.bytedance.sdk.openadsdk.j.b> map2 = this.f7545b.get(com.bytedance.sdk.openadsdk.j.b.b.a(z));
                remove = map2 != null ? map2.remove(str) : null;
            }
            if (remove != null) {
                remove.a();
            }
        }
    }

    public void a(boolean z, boolean z2, int i, String str, String... strArr) {
        a(z, z2, i, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        if (e.c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.j.a.a aVar = z ? this.h : this.g;
        com.bytedance.sdk.openadsdk.j.b.c cVar = this.f;
        if (aVar == null || cVar == null) {
            if (e.c) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
            }
        } else if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            int i2 = i <= 0 ? this.f7544a : i;
            String a2 = z2 ? str : com.bytedance.sdk.openadsdk.j.g.b.a(str);
            File d = aVar.d(a2);
            if (d != null && d.length() >= i2) {
                if (e.c) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + d.length() + ", need preload size: " + i2);
                }
            } else if (f.a().a(com.bytedance.sdk.openadsdk.j.b.b.a(z), a2)) {
                if (e.c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.f7545b) {
                    Map<String, com.bytedance.sdk.openadsdk.j.b> map2 = this.f7545b.get(z ? 1 : 0);
                    if (!map2.containsKey(a2)) {
                        a aVar2 = new a(z, z2, i2, str, map, strArr);
                        String str2 = this.m;
                        if (str2 != null) {
                            int i3 = e.h;
                            if (i3 == 3) {
                                synchronized (this.i) {
                                    this.i.add(aVar2);
                                }
                                if (e.c) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                }
                                return;
                            } else if (i3 == 2) {
                                if (e.c) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                                }
                                return;
                            } else if (i3 == 1 && this.n == z && str2.equals(a2)) {
                                if (e.c) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                }
                                return;
                            }
                        }
                        ArrayList arrayList = null;
                        List<i.b> a3 = com.bytedance.sdk.openadsdk.j.g.d.a(com.bytedance.sdk.openadsdk.j.g.d.a(map));
                        if (a3 != null) {
                            ArrayList arrayList2 = new ArrayList(a3.size());
                            int size = a3.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                i.b bVar = a3.get(i4);
                                if (bVar != null) {
                                    arrayList2.add(new i.b(bVar.f7600a, bVar.f7601b));
                                }
                            }
                            arrayList = arrayList2;
                        }
                        com.bytedance.sdk.openadsdk.j.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.j.g.d.a(strArr))).a((List<i.b>) arrayList).a(i2).a(this.j).a(aVar2).a();
                        map2.put(a2, a4);
                        this.d.execute(a4);
                    }
                }
            }
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(final boolean z, final boolean z2, final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.j.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.d.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.j.b bVar;
                    synchronized (d.this.f7545b) {
                        Map map = (Map) d.this.f7545b.get(com.bytedance.sdk.openadsdk.j.b.b.a(z));
                        if (map != null) {
                            bVar = (com.bytedance.sdk.openadsdk.j.b) map.remove(z2 ? str : com.bytedance.sdk.openadsdk.j.g.b.a(str));
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
    }

    public void d() {
        com.bytedance.sdk.openadsdk.j.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.j.b> arrayList = new ArrayList();
                synchronized (d.this.f7545b) {
                    int size = d.this.f7545b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.f7545b.get(d.this.f7545b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.c.clear();
                }
                for (com.bytedance.sdk.openadsdk.j.b bVar : arrayList) {
                    bVar.a();
                    if (e.c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final boolean f7552a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f7553b;
        final int c;
        final String d;
        final Map<String, String> e;
        final String[] f;

        a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f7552a = z;
            this.f7553b = z2;
            this.c = i;
            this.d = str;
            this.e = map;
            this.f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f7552a == aVar.f7552a && this.f7553b == aVar.f7553b && this.c == aVar.c) {
                return this.d.equals(aVar.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f7552a ? 1 : 0) * 31) + (this.f7553b ? 1 : 0)) * 31) + this.c) * 31) + this.d.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f7554a;

        private b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f7554a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.f7554a = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f7554a.getPoolSize();
                int activeCount = this.f7554a.getActiveCount();
                int maximumPoolSize = this.f7554a.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService a(final b<Runnable> bVar) {
        int i = 1;
        int a2 = com.bytedance.sdk.openadsdk.j.g.d.a();
        if (a2 >= 1) {
            i = a2 > 4 ? 4 : a2;
        }
        return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, bVar, new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.j.d.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bytedance.sdk.openadsdk.j.d.4.1
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
                thread.setName("video-preload-" + thread.getId());
                thread.setDaemon(true);
                if (e.c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.j.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    b.this.offerFirst(runnable);
                    if (e.c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
