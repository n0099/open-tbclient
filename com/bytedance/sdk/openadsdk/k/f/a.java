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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29435a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29436b;

    /* renamed from: c  reason: collision with root package name */
    public C0310a f29437c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29450a = new a();
    }

    public static a a() {
        return b.f29450a;
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
        if (this.f29437c != null) {
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
            C0310a c0310a = new C0310a();
            this.f29437c = c0310a;
            c0310a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29437c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29436b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29437c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0310a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0311a> f29441d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0311a> f29439b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29440c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0311a> f29442e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0311a {

            /* renamed from: a  reason: collision with root package name */
            public int f29443a;

            /* renamed from: b  reason: collision with root package name */
            public String f29444b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29445c;

            /* renamed from: d  reason: collision with root package name */
            public int f29446d;

            /* renamed from: e  reason: collision with root package name */
            public String f29447e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29448f;

            public C0311a() {
            }
        }

        public C0310a() {
        }

        private C0311a a(int i2, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29441d.size());
            C0311a poll = this.f29441d.poll();
            if (poll == null) {
                poll = new C0311a();
            }
            poll.f29443a = i2;
            poll.f29448f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0311a c0311a) {
            b();
            this.f29442e.add(c0311a);
            notify();
        }

        private void c(C0311a c0311a) {
            a();
            if (c0311a == null) {
                return;
            }
            this.f29439b.offer(c0311a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29440c) {
                synchronized (this) {
                    if (!this.f29442e.isEmpty()) {
                        c();
                    }
                    while (!this.f29439b.isEmpty()) {
                        C0311a poll = this.f29439b.poll();
                        if (poll != null) {
                            int i2 = poll.f29443a;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    d.c().a(poll.f29444b);
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
                                    this.f29440c = false;
                                }
                            } else if (poll.f29445c != null && poll.f29445c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29445c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29447e), poll.f29446d, poll.f29444b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0311a poll = this.f29442e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29448f;
                String str = bVar.f29451a;
                poll.f29444b = str;
                poll.f29445c = new String[]{str};
                poll.f29446d = bVar.f29452b;
                String str2 = bVar.f29453c;
                poll.f29447e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29444b = poll.f29448f.f29453c;
                }
                poll.f29448f = null;
                c(poll);
            }
        }

        private void a(C0311a c0311a) {
            a();
            c0311a.f29445c = null;
            c0311a.f29444b = null;
            c0311a.f29443a = -1;
            c0311a.f29448f = null;
            this.f29441d.offer(c0311a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29453c);
        return f.a().a(false, z, z ? bVar.f29453c : bVar.f29451a, bVar.f29451a);
    }
}
