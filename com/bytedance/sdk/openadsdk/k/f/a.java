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
    public static final boolean f29665a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29666b;

    /* renamed from: c  reason: collision with root package name */
    public C0325a f29667c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29680a = new a();
    }

    public static a a() {
        return b.f29680a;
    }

    public static c c() {
        c cVar;
        c cVar2 = null;
        if (com.bytedance.sdk.openadsdk.k.g.a.d()) {
            File file = new File(com.bytedance.sdk.openadsdk.k.g.a.a(com.bytedance.sdk.openadsdk.k.g.a.b(), SapiOptions.q).getPath());
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
        if (this.f29667c != null) {
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
            C0325a c0325a = new C0325a();
            this.f29667c = c0325a;
            c0325a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29667c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29666b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29667c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0325a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0326a> f29671d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0326a> f29669b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29670c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0326a> f29672e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0326a {

            /* renamed from: a  reason: collision with root package name */
            public int f29673a;

            /* renamed from: b  reason: collision with root package name */
            public String f29674b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29675c;

            /* renamed from: d  reason: collision with root package name */
            public int f29676d;

            /* renamed from: e  reason: collision with root package name */
            public String f29677e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29678f;

            public C0326a() {
            }
        }

        public C0325a() {
        }

        private C0326a a(int i, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29671d.size());
            C0326a poll = this.f29671d.poll();
            if (poll == null) {
                poll = new C0326a();
            }
            poll.f29673a = i;
            poll.f29678f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0326a c0326a) {
            b();
            this.f29672e.add(c0326a);
            notify();
        }

        private void c(C0326a c0326a) {
            a();
            if (c0326a == null) {
                return;
            }
            this.f29669b.offer(c0326a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29670c) {
                synchronized (this) {
                    if (!this.f29672e.isEmpty()) {
                        c();
                    }
                    while (!this.f29669b.isEmpty()) {
                        C0326a poll = this.f29669b.poll();
                        if (poll != null) {
                            int i = poll.f29673a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.f29674b);
                                } else if (i == 2) {
                                    d.c().d();
                                } else if (i == 3) {
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                    }
                                } else if (i == 4) {
                                    d.c().d();
                                    this.f29670c = false;
                                }
                            } else if (poll.f29675c != null && poll.f29675c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29675c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29677e), poll.f29676d, poll.f29674b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0326a poll = this.f29672e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29678f;
                String str = bVar.f29681a;
                poll.f29674b = str;
                poll.f29675c = new String[]{str};
                poll.f29676d = bVar.f29682b;
                String str2 = bVar.f29683c;
                poll.f29677e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29674b = poll.f29678f.f29683c;
                }
                poll.f29678f = null;
                c(poll);
            }
        }

        private void a(C0326a c0326a) {
            a();
            c0326a.f29675c = null;
            c0326a.f29674b = null;
            c0326a.f29673a = -1;
            c0326a.f29678f = null;
            this.f29671d.offer(c0326a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29683c);
        return f.a().a(false, z, z ? bVar.f29683c : bVar.f29681a, bVar.f29681a);
    }
}
