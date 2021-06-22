package com.bytedance.sdk.openadsdk.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.k.g;
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
/* loaded from: classes6.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f29603d;

    /* renamed from: a  reason: collision with root package name */
    public volatile ServerSocket f29604a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f29605b;

    /* renamed from: e  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.b.c f29607e;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.c f29608f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.b f29609g;
    public volatile c j;
    public volatile c k;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f29606c = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Set<g>> f29610h = new SparseArray<>(2);

    /* renamed from: i  reason: collision with root package name */
    public final g.c f29611i = new g.c() { // from class: com.bytedance.sdk.openadsdk.k.f.1
        @Override // com.bytedance.sdk.openadsdk.k.g.c
        public void a(g gVar) {
            synchronized (f.this.f29610h) {
                Set set = (Set) f.this.f29610h.get(gVar.f());
                if (set != null) {
                    set.add(gVar);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.k.g.c
        public void b(g gVar) {
            if (e.f29586c) {
                Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
            }
            int f2 = gVar.f();
            synchronized (f.this.f29610h) {
                Set set = (Set) f.this.f29610h.get(f2);
                if (set != null) {
                    set.remove(gVar);
                }
            }
        }
    };
    public final Runnable l = new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.f.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                int i2 = 0;
                f.this.f29604a = new ServerSocket(0, 50, InetAddress.getByName("127.0.0.1"));
                f fVar = f.this;
                fVar.f29605b = fVar.f29604a.getLocalPort();
                if (f.this.f29605b != -1) {
                    j.a("127.0.0.1", f.this.f29605b);
                    if (f.this.g() && f.this.f29606c.compareAndSet(0, 1)) {
                        if (e.f29586c) {
                            Log.i("TAG_PROXY_ProxyServer", "proxy server start!");
                        }
                        while (f.this.f29606c.get() == 1) {
                            try {
                                try {
                                    Socket accept = f.this.f29604a.accept();
                                    com.bytedance.sdk.openadsdk.k.b.c cVar = f.this.f29607e;
                                    if (cVar != null) {
                                        final g a2 = new g.a().a(cVar).a(accept).a(f.this.f29611i).a();
                                        com.bytedance.sdk.openadsdk.l.e.a().execute(new com.bytedance.sdk.openadsdk.l.g("ProxyTask", 10) { // from class: com.bytedance.sdk.openadsdk.k.f.2.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a2.run();
                                            }
                                        });
                                    } else {
                                        com.bytedance.sdk.openadsdk.k.g.d.a(accept);
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    f.b("accept error", Log.getStackTraceString(e2));
                                    i2++;
                                    if (i2 > 3) {
                                        break;
                                    }
                                }
                            } catch (Throwable th) {
                                String stackTraceString = Log.getStackTraceString(th);
                                Log.e("TAG_PROXY_ProxyServer", "proxy server crashed!  " + stackTraceString);
                                f.b("error", stackTraceString);
                            }
                        }
                        if (e.f29586c) {
                            Log.i("TAG_PROXY_ProxyServer", "proxy server closed!");
                        }
                        f.this.e();
                        return;
                    }
                    return;
                }
                f.b("socket not bound", "");
                f.this.e();
            } catch (IOException e3) {
                if (e.f29586c) {
                    Log.e("TAG_PROXY_ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e3));
                }
                f.b("create ServerSocket error", Log.getStackTraceString(e3));
                f.this.e();
            }
        }
    };
    public final AtomicBoolean m = new AtomicBoolean();

    /* loaded from: classes6.dex */
    public static final class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final String f29618a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29619b;

        public a(String str, int i2) {
            this.f29618a = str;
            this.f29619b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.f29618a, this.f29619b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.k.g.d.f29657a));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        return Boolean.TRUE;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        f.b("ping error", Log.getStackTraceString(th));
                        com.bytedance.sdk.openadsdk.k.g.d.a(socket);
                        return Boolean.FALSE;
                    } finally {
                        com.bytedance.sdk.openadsdk.k.g.d.a(socket);
                    }
                }
            } catch (Throwable th3) {
                socket = null;
                th = th3;
            }
            com.bytedance.sdk.openadsdk.k.g.d.a(socket);
            return Boolean.FALSE;
        }
    }

    public f() {
        this.f29610h.put(0, new HashSet());
        this.f29610h.put(1, new HashSet());
    }

    public static void b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f29606c.compareAndSet(1, 2) || this.f29606c.compareAndSet(0, 2)) {
            com.bytedance.sdk.openadsdk.k.g.d.a(this.f29604a);
            f();
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f29610h) {
            int size = this.f29610h.size();
            for (int i2 = 0; i2 < size; i2++) {
                Set<g> set = this.f29610h.get(this.f29610h.keyAt(i2));
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
        final com.bytedance.sdk.openadsdk.l.f fVar = new com.bytedance.sdk.openadsdk.l.f(new a("127.0.0.1", this.f29605b), 5, 1);
        com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("pingTest") { // from class: com.bytedance.sdk.openadsdk.k.f.3
            @Override // java.lang.Runnable
            public void run() {
                u.b("TTExecutor", "pingTest.....run");
                fVar.run();
            }
        });
        h();
        try {
            if (!((Boolean) fVar.get()).booleanValue()) {
                Log.e("TAG_PROXY_ProxyServer", "Ping error");
                b("ping error", "");
                e();
                return false;
            }
            if (e.f29586c) {
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

    private void h() {
        Socket socket = null;
        try {
            try {
                socket = this.f29604a.accept();
                socket.setSoTimeout(2000);
                if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.k.g.d.f29657a));
                    outputStream.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                b("ping error", Log.getStackTraceString(e2));
            }
        } finally {
            com.bytedance.sdk.openadsdk.k.g.d.a(socket);
        }
    }

    public c b() {
        return this.j;
    }

    public c c() {
        return this.k;
    }

    public void d() {
        if (this.m.compareAndSet(false, true)) {
            Thread thread = new Thread(this.l);
            thread.setName("tt_pangle_thread_proxy_server");
            thread.start();
        }
    }

    public boolean a(int i2, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f29610h) {
            Set<g> set = this.f29610h.get(i2);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.f29511h)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static f a() {
        if (f29603d == null) {
            synchronized (f.class) {
                if (f29603d == null) {
                    f29603d = new f();
                }
            }
        }
        return f29603d;
    }

    public void a(com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29607e = cVar;
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        this.f29608f = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                b("key", "key is empty");
                return strArr[0];
            } else if (this.f29607e == null) {
                b(IMTrackDatabase.DbEnum.TABLE_NAME, "VideoProxyDB is null");
                return strArr[0];
            } else {
                if ((z ? this.f29609g : this.f29608f) == null) {
                    b(SapiOptions.KEY_CACHE, "Cache is null");
                    return strArr[0];
                }
                int i2 = this.f29606c.get();
                if (i2 != 1) {
                    b("state", "ProxyServer is not running, " + i2);
                    return strArr[0];
                }
                List<String> a2 = com.bytedance.sdk.openadsdk.k.g.d.a(strArr);
                if (a2 == null) {
                    b("url", "url not start with http/https");
                    return strArr[0];
                }
                String a3 = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.k.g.b.a(str), a2);
                if (a3 == null) {
                    b("url", "combine proxy url error");
                    return strArr[0];
                } else if (z) {
                    return "http://127.0.0.1:" + this.f29605b + "?f=1&" + a3;
                } else {
                    return "http://127.0.0.1:" + this.f29605b + "?" + a3;
                }
            }
        }
        b("url", "url is empty");
        return null;
    }
}
