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
    public static final boolean f29506a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29507b;

    /* renamed from: c  reason: collision with root package name */
    public C0309a f29508c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29521a = new a();
    }

    public static a a() {
        return b.f29521a;
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
        if (this.f29508c != null) {
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
            C0309a c0309a = new C0309a();
            this.f29508c = c0309a;
            c0309a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29508c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29507b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29508c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0309a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0310a> f29512d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0310a> f29510b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29511c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0310a> f29513e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0310a {

            /* renamed from: a  reason: collision with root package name */
            public int f29514a;

            /* renamed from: b  reason: collision with root package name */
            public String f29515b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29516c;

            /* renamed from: d  reason: collision with root package name */
            public int f29517d;

            /* renamed from: e  reason: collision with root package name */
            public String f29518e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29519f;

            public C0310a() {
            }
        }

        public C0309a() {
        }

        private C0310a a(int i2, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29512d.size());
            C0310a poll = this.f29512d.poll();
            if (poll == null) {
                poll = new C0310a();
            }
            poll.f29514a = i2;
            poll.f29519f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0310a c0310a) {
            b();
            this.f29513e.add(c0310a);
            notify();
        }

        private void c(C0310a c0310a) {
            a();
            if (c0310a == null) {
                return;
            }
            this.f29510b.offer(c0310a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29511c) {
                synchronized (this) {
                    if (!this.f29513e.isEmpty()) {
                        c();
                    }
                    while (!this.f29510b.isEmpty()) {
                        C0310a poll = this.f29510b.poll();
                        if (poll != null) {
                            int i2 = poll.f29514a;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    d.c().a(poll.f29515b);
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
                                    this.f29511c = false;
                                }
                            } else if (poll.f29516c != null && poll.f29516c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29516c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29518e), poll.f29517d, poll.f29515b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0310a poll = this.f29513e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29519f;
                String str = bVar.f29522a;
                poll.f29515b = str;
                poll.f29516c = new String[]{str};
                poll.f29517d = bVar.f29523b;
                String str2 = bVar.f29524c;
                poll.f29518e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29515b = poll.f29519f.f29524c;
                }
                poll.f29519f = null;
                c(poll);
            }
        }

        private void a(C0310a c0310a) {
            a();
            c0310a.f29516c = null;
            c0310a.f29515b = null;
            c0310a.f29514a = -1;
            c0310a.f29519f = null;
            this.f29512d.offer(c0310a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29524c);
        return f.a().a(false, z, z ? bVar.f29524c : bVar.f29522a, bVar.f29522a);
    }
}
