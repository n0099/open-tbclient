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
    public static final boolean f29620a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29621b;

    /* renamed from: c  reason: collision with root package name */
    public C0315a f29622c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29635a = new a();
    }

    public static a a() {
        return b.f29635a;
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
        if (this.f29622c != null) {
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
            C0315a c0315a = new C0315a();
            this.f29622c = c0315a;
            c0315a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29622c.start();
            e.a(c2, p.a());
            d.c().a(30000L, 30000L, 30000L);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29621b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29622c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0315a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0316a> f29626d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0316a> f29624b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29625c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0316a> f29627e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0316a {

            /* renamed from: a  reason: collision with root package name */
            public int f29628a;

            /* renamed from: b  reason: collision with root package name */
            public String f29629b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29630c;

            /* renamed from: d  reason: collision with root package name */
            public int f29631d;

            /* renamed from: e  reason: collision with root package name */
            public String f29632e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29633f;

            public C0316a() {
            }
        }

        public C0315a() {
        }

        private C0316a a(int i2, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29626d.size());
            C0316a poll = this.f29626d.poll();
            if (poll == null) {
                poll = new C0316a();
            }
            poll.f29628a = i2;
            poll.f29633f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0316a c0316a) {
            b();
            this.f29627e.add(c0316a);
            notify();
        }

        private void c(C0316a c0316a) {
            a();
            if (c0316a == null) {
                return;
            }
            this.f29624b.offer(c0316a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29625c) {
                synchronized (this) {
                    if (!this.f29627e.isEmpty()) {
                        c();
                    }
                    while (!this.f29624b.isEmpty()) {
                        C0316a poll = this.f29624b.poll();
                        if (poll != null) {
                            int i2 = poll.f29628a;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    d.c().a(poll.f29629b);
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
                                    this.f29625c = false;
                                }
                            } else if (poll.f29630c != null && poll.f29630c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29630c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29632e), poll.f29631d, poll.f29629b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0316a poll = this.f29627e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29633f;
                String str = bVar.f29636a;
                poll.f29629b = str;
                poll.f29630c = new String[]{str};
                poll.f29631d = bVar.f29637b;
                String str2 = bVar.f29638c;
                poll.f29632e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29629b = poll.f29633f.f29638c;
                }
                poll.f29633f = null;
                c(poll);
            }
        }

        private void a(C0316a c0316a) {
            a();
            c0316a.f29630c = null;
            c0316a.f29629b = null;
            c0316a.f29628a = -1;
            c0316a.f29633f = null;
            this.f29626d.offer(c0316a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29638c);
        return f.a().a(false, z, z ? bVar.f29638c : bVar.f29636a, bVar.f29636a);
    }
}
