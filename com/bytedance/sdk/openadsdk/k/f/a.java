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
    public static final boolean f29358a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29359b;

    /* renamed from: c  reason: collision with root package name */
    public C0329a f29360c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29373a = new a();
    }

    public static a a() {
        return b.f29373a;
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
        if (this.f29360c != null) {
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
            C0329a c0329a = new C0329a();
            this.f29360c = c0329a;
            c0329a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29360c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29359b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29360c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0329a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0330a> f29364d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0330a> f29362b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29363c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0330a> f29365e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0330a {

            /* renamed from: a  reason: collision with root package name */
            public int f29366a;

            /* renamed from: b  reason: collision with root package name */
            public String f29367b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29368c;

            /* renamed from: d  reason: collision with root package name */
            public int f29369d;

            /* renamed from: e  reason: collision with root package name */
            public String f29370e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29371f;

            public C0330a() {
            }
        }

        public C0329a() {
        }

        private C0330a a(int i, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29364d.size());
            C0330a poll = this.f29364d.poll();
            if (poll == null) {
                poll = new C0330a();
            }
            poll.f29366a = i;
            poll.f29371f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0330a c0330a) {
            b();
            this.f29365e.add(c0330a);
            notify();
        }

        private void c(C0330a c0330a) {
            a();
            if (c0330a == null) {
                return;
            }
            this.f29362b.offer(c0330a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29363c) {
                synchronized (this) {
                    if (!this.f29365e.isEmpty()) {
                        c();
                    }
                    while (!this.f29362b.isEmpty()) {
                        C0330a poll = this.f29362b.poll();
                        if (poll != null) {
                            int i = poll.f29366a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.f29367b);
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
                                    this.f29363c = false;
                                }
                            } else if (poll.f29368c != null && poll.f29368c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29368c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29370e), poll.f29369d, poll.f29367b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0330a poll = this.f29365e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29371f;
                String str = bVar.f29374a;
                poll.f29367b = str;
                poll.f29368c = new String[]{str};
                poll.f29369d = bVar.f29375b;
                String str2 = bVar.f29376c;
                poll.f29370e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29367b = poll.f29371f.f29376c;
                }
                poll.f29371f = null;
                c(poll);
            }
        }

        private void a(C0330a c0330a) {
            a();
            c0330a.f29368c = null;
            c0330a.f29367b = null;
            c0330a.f29366a = -1;
            c0330a.f29371f = null;
            this.f29364d.offer(c0330a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29376c);
        return f.a().a(false, z, z ? bVar.f29376c : bVar.f29374a, bVar.f29374a);
    }
}
