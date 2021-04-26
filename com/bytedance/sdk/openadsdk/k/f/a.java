package com.bytedance.sdk.openadsdk.k.f;

import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f30261a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f30262b;

    /* renamed from: c  reason: collision with root package name */
    public C0322a f30263c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30276a = new a();
    }

    public static a a() {
        return b.f30276a;
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
                cVar.a(DownloadStrategy.FOUR_CONNECTION_UPPER_LIMIT);
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
        if (this.f30263c != null) {
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
            C0322a c0322a = new C0322a();
            this.f30263c = c0322a;
            c0322a.setName("tt_pangle_thread_video_cache_preloader");
            this.f30263c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f30262b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f30263c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0322a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0323a> f30267d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0323a> f30265b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f30266c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0323a> f30268e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0323a {

            /* renamed from: a  reason: collision with root package name */
            public int f30269a;

            /* renamed from: b  reason: collision with root package name */
            public String f30270b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f30271c;

            /* renamed from: d  reason: collision with root package name */
            public int f30272d;

            /* renamed from: e  reason: collision with root package name */
            public String f30273e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f30274f;

            public C0323a() {
            }
        }

        public C0322a() {
        }

        private C0323a a(int i2, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f30267d.size());
            C0323a poll = this.f30267d.poll();
            if (poll == null) {
                poll = new C0323a();
            }
            poll.f30269a = i2;
            poll.f30274f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0323a c0323a) {
            b();
            this.f30268e.add(c0323a);
            notify();
        }

        private void c(C0323a c0323a) {
            a();
            if (c0323a == null) {
                return;
            }
            this.f30265b.offer(c0323a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f30266c) {
                synchronized (this) {
                    if (!this.f30268e.isEmpty()) {
                        c();
                    }
                    while (!this.f30265b.isEmpty()) {
                        C0323a poll = this.f30265b.poll();
                        if (poll != null) {
                            int i2 = poll.f30269a;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    d.c().a(poll.f30270b);
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
                                    this.f30266c = false;
                                }
                            } else if (poll.f30271c != null && poll.f30271c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f30271c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f30273e), poll.f30272d, poll.f30270b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0323a poll = this.f30268e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f30274f;
                String str = bVar.f30277a;
                poll.f30270b = str;
                poll.f30271c = new String[]{str};
                poll.f30272d = bVar.f30278b;
                String str2 = bVar.f30279c;
                poll.f30273e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f30270b = poll.f30274f.f30279c;
                }
                poll.f30274f = null;
                c(poll);
            }
        }

        private void a(C0323a c0323a) {
            a();
            c0323a.f30271c = null;
            c0323a.f30270b = null;
            c0323a.f30269a = -1;
            c0323a.f30274f = null;
            this.f30267d.offer(c0323a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f30279c);
        return f.a().a(false, z, z ? bVar.f30279c : bVar.f30277a, bVar.f30277a);
    }
}
