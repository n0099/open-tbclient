package com.bytedance.sdk.openadsdk.k.f;

import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.k.a.c;
import com.bytedance.sdk.openadsdk.k.d;
import com.bytedance.sdk.openadsdk.k.e;
import com.bytedance.sdk.openadsdk.k.f;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29538a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29539b;

    /* renamed from: c  reason: collision with root package name */
    public C0312a f29540c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29553a = new a();
    }

    public static a a() {
        return b.f29553a;
    }

    public static c c() {
        c cVar;
        c cVar2 = null;
        if (com.bytedance.sdk.openadsdk.k.g.a.d()) {
            File file = new File(com.bytedance.sdk.openadsdk.k.g.a.a(com.bytedance.sdk.openadsdk.k.g.a.b(), SapiOptions.KEY_CACHE).getPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                cVar = new c(file);
            } catch (IOException e2) {
                e = e2;
            }
            try {
                cVar.a(104857600L);
                return cVar;
            } catch (IOException e3) {
                e = e3;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return null;
    }

    public boolean b() {
        if (this.f29540c != null) {
            return true;
        }
        c c2 = c();
        if (c2 == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            C0312a c0312a = new C0312a();
            this.f29540c = c0312a;
            c0312a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29540c.start();
            e.a(c2, p.a());
            d.c().a(30000L, 30000L, 30000L);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29539b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29540c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0312a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0313a> f29544d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0313a> f29542b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29543c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0313a> f29545e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0313a {

            /* renamed from: a  reason: collision with root package name */
            public int f29546a;

            /* renamed from: b  reason: collision with root package name */
            public String f29547b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29548c;

            /* renamed from: d  reason: collision with root package name */
            public int f29549d;

            /* renamed from: e  reason: collision with root package name */
            public String f29550e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29551f;

            public C0313a() {
            }
        }

        public C0312a() {
        }

        private C0313a a(int i2, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29544d.size());
            C0313a poll = this.f29544d.poll();
            if (poll == null) {
                poll = new C0313a();
            }
            poll.f29546a = i2;
            poll.f29551f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0313a c0313a) {
            b();
            this.f29545e.add(c0313a);
            notify();
        }

        private void c(C0313a c0313a) {
            a();
            if (c0313a == null) {
                return;
            }
            this.f29542b.offer(c0313a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29543c) {
                synchronized (this) {
                    if (!this.f29545e.isEmpty()) {
                        c();
                    }
                    while (!this.f29542b.isEmpty()) {
                        C0313a poll = this.f29542b.poll();
                        if (poll != null) {
                            int i2 = poll.f29546a;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    d.c().a(poll.f29547b);
                                } else if (i2 == 2) {
                                    d.c().d();
                                } else if (i2 == 3) {
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                    }
                                } else if (i2 == 4) {
                                    d.c().d();
                                    this.f29543c = false;
                                }
                            } else if (poll.f29548c != null && poll.f29548c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29548c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29550e), poll.f29549d, poll.f29547b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            a(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C0313a poll = this.f29545e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29551f;
                String str = bVar.f29554a;
                poll.f29547b = str;
                poll.f29548c = new String[]{str};
                poll.f29549d = bVar.f29555b;
                String str2 = bVar.f29556c;
                poll.f29550e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29547b = poll.f29551f.f29556c;
                }
                poll.f29551f = null;
                c(poll);
            }
        }

        private void a(C0313a c0313a) {
            a();
            c0313a.f29548c = null;
            c0313a.f29547b = null;
            c0313a.f29546a = -1;
            c0313a.f29551f = null;
            this.f29544d.offer(c0313a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29556c);
        return f.a().a(false, z, z ? bVar.f29556c : bVar.f29554a, bVar.f29554a);
    }
}
