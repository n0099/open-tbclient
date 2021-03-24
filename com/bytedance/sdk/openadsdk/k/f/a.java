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
    public static final boolean f29664a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29665b;

    /* renamed from: c  reason: collision with root package name */
    public C0324a f29666c;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29679a = new a();
    }

    public static a a() {
        return b.f29679a;
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
        if (this.f29666c != null) {
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
            C0324a c0324a = new C0324a();
            this.f29666c = c0324a;
            c0324a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29666c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29665b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29666c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0324a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0325a> f29670d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0325a> f29668b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29669c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0325a> f29671e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0325a {

            /* renamed from: a  reason: collision with root package name */
            public int f29672a;

            /* renamed from: b  reason: collision with root package name */
            public String f29673b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29674c;

            /* renamed from: d  reason: collision with root package name */
            public int f29675d;

            /* renamed from: e  reason: collision with root package name */
            public String f29676e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29677f;

            public C0325a() {
            }
        }

        public C0324a() {
        }

        private C0325a a(int i, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29670d.size());
            C0325a poll = this.f29670d.poll();
            if (poll == null) {
                poll = new C0325a();
            }
            poll.f29672a = i;
            poll.f29677f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0325a c0325a) {
            b();
            this.f29671e.add(c0325a);
            notify();
        }

        private void c(C0325a c0325a) {
            a();
            if (c0325a == null) {
                return;
            }
            this.f29668b.offer(c0325a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29669c) {
                synchronized (this) {
                    if (!this.f29671e.isEmpty()) {
                        c();
                    }
                    while (!this.f29668b.isEmpty()) {
                        C0325a poll = this.f29668b.poll();
                        if (poll != null) {
                            int i = poll.f29672a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.f29673b);
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
                                    this.f29669c = false;
                                }
                            } else if (poll.f29674c != null && poll.f29674c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29674c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29676e), poll.f29675d, poll.f29673b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0325a poll = this.f29671e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29677f;
                String str = bVar.f29680a;
                poll.f29673b = str;
                poll.f29674c = new String[]{str};
                poll.f29675d = bVar.f29681b;
                String str2 = bVar.f29682c;
                poll.f29676e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29673b = poll.f29677f.f29682c;
                }
                poll.f29677f = null;
                c(poll);
            }
        }

        private void a(C0325a c0325a) {
            a();
            c0325a.f29674c = null;
            c0325a.f29673b = null;
            c0325a.f29672a = -1;
            c0325a.f29677f = null;
            this.f29670d.offer(c0325a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29682c);
        return f.a().a(false, z, z ? bVar.f29682c : bVar.f29680a, bVar.f29680a);
    }
}
