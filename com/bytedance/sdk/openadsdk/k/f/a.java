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
    public static final boolean f29350a = u.c();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Boolean> f29351b;

    /* renamed from: c  reason: collision with root package name */
    public C0327a f29352c;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f29365a = new a();
    }

    public static a a() {
        return b.f29365a;
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
        if (this.f29352c != null) {
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
            C0327a c0327a = new C0327a();
            this.f29352c = c0327a;
            c0327a.setName("tt_pangle_thread_video_cache_preloader");
            this.f29352c.start();
            e.a(c2, p.a());
            d.c().a(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public a() {
        this.f29351b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (b()) {
            this.f29352c.a(bVar);
            return true;
        }
        return false;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0327a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        public final Queue<C0328a> f29356d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        public Queue<C0328a> f29354b = new LinkedBlockingQueue();

        /* renamed from: c  reason: collision with root package name */
        public boolean f29355c = true;

        /* renamed from: e  reason: collision with root package name */
        public Queue<C0328a> f29357e = new LinkedBlockingQueue();

        /* renamed from: com.bytedance.sdk.openadsdk.k.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0328a {

            /* renamed from: a  reason: collision with root package name */
            public int f29358a;

            /* renamed from: b  reason: collision with root package name */
            public String f29359b;

            /* renamed from: c  reason: collision with root package name */
            public String[] f29360c;

            /* renamed from: d  reason: collision with root package name */
            public int f29361d;

            /* renamed from: e  reason: collision with root package name */
            public String f29362e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.k.f.b f29363f;

            public C0328a() {
            }
        }

        public C0327a() {
        }

        private C0328a a(int i, com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.f29356d.size());
            C0328a poll = this.f29356d.poll();
            if (poll == null) {
                poll = new C0328a();
            }
            poll.f29358a = i;
            poll.f29363f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0328a c0328a) {
            b();
            this.f29357e.add(c0328a);
            notify();
        }

        private void c(C0328a c0328a) {
            a();
            if (c0328a == null) {
                return;
            }
            this.f29354b.offer(c0328a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.f29355c) {
                synchronized (this) {
                    if (!this.f29357e.isEmpty()) {
                        c();
                    }
                    while (!this.f29354b.isEmpty()) {
                        C0328a poll = this.f29354b.poll();
                        if (poll != null) {
                            int i = poll.f29358a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(poll.f29359b);
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
                                    this.f29355c = false;
                                }
                            } else if (poll.f29360c != null && poll.f29360c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : poll.f29360c) {
                                    if (com.bytedance.sdk.openadsdk.k.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(poll.f29362e), poll.f29361d, poll.f29359b, (String[]) arrayList.toArray(new String[arrayList.size()]));
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
                C0328a poll = this.f29357e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.k.f.b bVar = poll.f29363f;
                String str = bVar.f29366a;
                poll.f29359b = str;
                poll.f29360c = new String[]{str};
                poll.f29361d = bVar.f29367b;
                String str2 = bVar.f29368c;
                poll.f29362e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.f29359b = poll.f29363f.f29368c;
                }
                poll.f29363f = null;
                c(poll);
            }
        }

        private void a(C0328a c0328a) {
            a();
            c0328a.f29360c = null;
            c0328a.f29359b = null;
            c0328a.f29358a = -1;
            c0328a.f29363f = null;
            this.f29356d.offer(c0328a);
        }

        public void a(com.bytedance.sdk.openadsdk.k.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.k.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f29368c);
        return f.a().a(false, z, z ? bVar.f29368c : bVar.f29366a, bVar.f29366a);
    }
}
