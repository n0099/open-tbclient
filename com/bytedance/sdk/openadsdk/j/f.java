package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class f {
    private static volatile f d;

    /* renamed from: a  reason: collision with root package name */
    private volatile ServerSocket f7264a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f7265b;
    private volatile com.bytedance.sdk.openadsdk.j.b.c e;
    private volatile com.bytedance.sdk.openadsdk.j.a.c f;
    private volatile com.bytedance.sdk.openadsdk.j.a.b g;
    private volatile c j;
    private volatile c k;
    private final AtomicInteger c = new AtomicInteger(0);
    private final SparseArray<Set<g>> h = new SparseArray<>(2);
    private final g.c i = new g.c() { // from class: com.bytedance.sdk.openadsdk.j.f.1
        @Override // com.bytedance.sdk.openadsdk.j.g.c
        public void a(g gVar) {
            synchronized (f.this.h) {
                Set set = (Set) f.this.h.get(gVar.f());
                if (set != null) {
                    set.add(gVar);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.j.g.c
        public void b(g gVar) {
            if (e.c) {
                Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
            }
            int f = gVar.f();
            synchronized (f.this.h) {
                Set set = (Set) f.this.h.get(f);
                if (set != null) {
                    set.remove(gVar);
                }
            }
        }
    };
    private final Runnable l = new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.f.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f7264a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                f.this.f7265b = f.this.f7264a.getLocalPort();
                if (f.this.f7265b == -1) {
                    f.b("socket not bound", "");
                    f.this.e();
                    return;
                }
                j.a("127.0.0.1", f.this.f7265b);
                if (f.this.g() && f.this.c.compareAndSet(0, 1)) {
                    if (e.c) {
                        Log.i("TAG_PROXY_ProxyServer", "proxy server start!");
                    }
                    int i = 0;
                    while (f.this.c.get() == 1) {
                        try {
                            try {
                                Socket accept = f.this.f7264a.accept();
                                com.bytedance.sdk.openadsdk.j.b.c cVar = f.this.e;
                                if (cVar != null) {
                                    com.bytedance.sdk.openadsdk.k.a.a().b(new g.a().a(cVar).a(accept).a(f.this.i).a(), 10);
                                } else {
                                    com.bytedance.sdk.openadsdk.j.g.d.a(accept);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                f.b("accept error", Log.getStackTraceString(e));
                                int i2 = i + 1;
                                if (i2 > 3) {
                                    break;
                                }
                                i = i2;
                            }
                        } catch (Throwable th) {
                            String stackTraceString = Log.getStackTraceString(th);
                            Log.e("TAG_PROXY_ProxyServer", "proxy server crashed!  " + stackTraceString);
                            f.b(BdStatsConstant.StatsType.ERROR, stackTraceString);
                        }
                    }
                    if (e.c) {
                        Log.i("TAG_PROXY_ProxyServer", "proxy server closed!");
                    }
                    f.this.e();
                }
            } catch (IOException e2) {
                if (e.c) {
                    Log.e("TAG_PROXY_ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                }
                f.b("create ServerSocket error", Log.getStackTraceString(e2));
                f.this.e();
            }
        }
    };
    private final AtomicBoolean m = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, String str) {
        boolean z;
        if (str == null) {
            return false;
        }
        synchronized (this.h) {
            Set<g> set = this.h.get(i);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.h)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    public static f a() {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f();
                }
            }
        }
        return d;
    }

    private f() {
        this.h.put(0, new HashSet());
        this.h.put(1, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.j.b.c cVar) {
        this.e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        this.f = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            b("url", "url is empty");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            b("key", "key is empty");
            return strArr[0];
        } else if (this.e == null) {
            b(BdStatsConstant.OpSubType.DB, "VideoProxyDB is null");
            return strArr[0];
        } else {
            if ((z ? this.g : this.f) == null) {
                b("cache", "Cache is null");
                return strArr[0];
            }
            int i = this.c.get();
            if (i != 1) {
                b("state", "ProxyServer is not running, " + i);
                return strArr[0];
            }
            List<String> a2 = com.bytedance.sdk.openadsdk.j.g.d.a(strArr);
            if (a2 == null) {
                b("url", "url not start with http/https");
                return strArr[0];
            }
            String a3 = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.j.g.b.a(str), a2);
            if (a3 == null) {
                b("url", "combine proxy url error");
                return strArr[0];
            } else if (z) {
                return "http://127.0.0.1:" + this.f7265b + "?f=1" + ETAG.ITEM_SEPARATOR + a3;
            } else {
                return "http://127.0.0.1:" + this.f7265b + "?" + a3;
            }
        }
    }

    public void d() {
        if (this.m.compareAndSet(false, true)) {
            new Thread(this.l).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.c.compareAndSet(1, 2) || this.c.compareAndSet(0, 2)) {
            com.bytedance.sdk.openadsdk.j.g.d.a(this.f7264a);
            f();
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.h) {
            int size = this.h.size();
            for (int i = 0; i < size; i++) {
                Set<g> set = this.h.get(this.h.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        final com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(new a("127.0.0.1", this.f7265b), 5, 1);
        com.bytedance.sdk.openadsdk.k.a.a().a(new com.bytedance.sdk.openadsdk.k.c() { // from class: com.bytedance.sdk.openadsdk.j.f.3
            @Override // java.lang.Runnable
            public void run() {
                u.b("TTExecutor", "pingTest.....run");
                bVar.run();
            }
        });
        h();
        try {
            if (!((Boolean) bVar.get()).booleanValue()) {
                Log.e("TAG_PROXY_ProxyServer", "Ping error");
                b("ping error", "");
                e();
                return false;
            }
            if (e.c) {
                Log.i("TAG_PROXY_ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            b("ping error", Log.getStackTraceString(th));
            e();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7270a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7271b;

        a(String str, int i) {
            this.f7270a = str;
            this.f7271b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            Socket socket;
            try {
                socket = new Socket(this.f7270a, this.f7271b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.j.g.d.f7293a));
                    outputStream.flush();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        f.b("ping error", Log.getStackTraceString(th));
                        com.bytedance.sdk.openadsdk.j.g.d.a(socket);
                        return false;
                    } finally {
                        com.bytedance.sdk.openadsdk.j.g.d.a(socket);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socket = null;
            }
            if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                return true;
            }
            return false;
        }
    }

    private void h() {
        Socket socket = null;
        try {
            socket = this.f7264a.accept();
            socket.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.j.g.d.f7293a));
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            b("ping error", Log.getStackTraceString(e));
        } finally {
            com.bytedance.sdk.openadsdk.j.g.d.a(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }
}
