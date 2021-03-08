package com.bytedance.sdk.openadsdk.i.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.i.a.c;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.i.f;
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
    public static final boolean f4835a = u.c();
    private HashMap<String, Boolean> b;
    private C1036a c;

    private a() {
        this.b = new HashMap<>();
        b();
    }

    public static a a() {
        return b.f4839a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f4839a = new a();
    }

    public boolean b() {
        if (this.c != null) {
            return true;
        }
        c c = c();
        if (c == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            this.c = new C1036a();
            this.c.setName("tt_pangle_thread_video_cache_preloader");
            this.c.start();
            e.a(c, p.a());
            d.c().a(30000L, 30000L, 30000L);
            d.c().a(10485759);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean a(com.bytedance.sdk.openadsdk.i.f.b bVar) {
        if (b()) {
            this.c.a(bVar);
            return true;
        }
        return false;
    }

    public String b(com.bytedance.sdk.openadsdk.i.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.c);
        return f.a().a(false, z, z ? bVar.c : bVar.f4840a, bVar.f4840a);
    }

    private static c c() {
        c cVar;
        if (!com.bytedance.sdk.openadsdk.i.g.a.d()) {
            return null;
        }
        File file = new File(com.bytedance.sdk.openadsdk.i.g.a.a(com.bytedance.sdk.openadsdk.i.g.a.b(), "cache").getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            cVar = new c(file);
            try {
                cVar.a(104857600L);
                return cVar;
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                return cVar;
            }
        } catch (IOException e2) {
            e = e2;
            cVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.i.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1036a extends Thread {
        private final Queue<C1037a> d = new ArrayBlockingQueue(10);
        private Queue<C1037a> b = new LinkedBlockingQueue();
        private boolean c = true;
        private Queue<C1037a> e = new LinkedBlockingQueue();

        public C1036a() {
        }

        private C1037a a(int i, com.bytedance.sdk.openadsdk.i.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.d.size());
            C1037a poll = this.d.poll();
            if (poll == null) {
                poll = new C1037a();
            }
            poll.f4838a = i;
            poll.f = bVar;
            return poll;
        }

        private void a(C1037a c1037a) {
            a();
            c1037a.c = null;
            c1037a.b = null;
            c1037a.f4838a = -1;
            c1037a.f = null;
            this.d.offer(c1037a);
        }

        private synchronized void b(C1037a c1037a) {
            b();
            this.e.add(c1037a);
            notify();
        }

        private void a() {
        }

        private void b() {
        }

        private void c(C1037a c1037a) {
            a();
            if (c1037a != null) {
                this.b.offer(c1037a);
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.c) {
                synchronized (this) {
                    if (!this.e.isEmpty()) {
                        c();
                    }
                    while (!this.b.isEmpty()) {
                        C1037a poll = this.b.poll();
                        if (poll != null) {
                            switch (poll.f4838a) {
                                case 0:
                                    if (poll.c != null && poll.c.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : poll.c) {
                                            if (com.bytedance.sdk.openadsdk.i.g.d.a(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        d.c().a(false, !TextUtils.isEmpty(poll.e), poll.d, poll.b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                        break;
                                    }
                                    break;
                                case 1:
                                    d.c().a(poll.b);
                                    break;
                                case 2:
                                    d.c().d();
                                    break;
                                case 3:
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                        break;
                                    }
                                    break;
                                case 4:
                                    d.c().d();
                                    this.c = false;
                                    break;
                            }
                            a(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C1037a poll = this.e.poll();
                if (poll != null) {
                    poll.b = poll.f.f4840a;
                    poll.c = new String[]{poll.f.f4840a};
                    poll.d = poll.f.b;
                    poll.e = poll.f.c;
                    if (!TextUtils.isEmpty(poll.f.c)) {
                        poll.b = poll.f.c;
                    }
                    poll.f = null;
                    c(poll);
                } else {
                    return;
                }
            }
        }

        public void a(com.bytedance.sdk.openadsdk.i.f.b bVar) {
            b(a(0, bVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.i.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1037a {

            /* renamed from: a  reason: collision with root package name */
            public int f4838a;
            public String b;
            public String[] c;
            public int d;
            public String e;
            public com.bytedance.sdk.openadsdk.i.f.b f;

            public C1037a() {
            }
        }
    }
}
