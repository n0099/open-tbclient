package com.bytedance.sdk.openadsdk.j.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.bytedance.sdk.openadsdk.j.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.f;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7272a = u.c();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Boolean> f7273b;
    private C1019a c;

    private a() {
        this.f7273b = new HashMap<>();
        b();
    }

    public static a a() {
        return b.f7278a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f7278a = new a();
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
            this.c = new C1019a();
            this.c.start();
            e.a(c, p.a());
            d.c().a(30000L, 30000L, 30000L);
            d.c().a(10485759);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean a(com.bytedance.sdk.openadsdk.j.f.b bVar) {
        if (b()) {
            this.c.a(bVar);
            return true;
        }
        return false;
    }

    public String b(com.bytedance.sdk.openadsdk.j.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.c);
        return f.a().a(false, z, z ? bVar.c : bVar.f7279a, bVar.f7279a);
    }

    private static c c() {
        c cVar;
        if (!com.bytedance.sdk.openadsdk.j.g.a.d()) {
            return null;
        }
        File file = new File(com.bytedance.sdk.openadsdk.j.g.a.a(com.bytedance.sdk.openadsdk.j.g.a.b(), "cache").getPath());
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
    /* renamed from: com.bytedance.sdk.openadsdk.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1019a extends Thread {
        private final Queue<C1020a> d = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        private Queue<C1020a> f7275b = new LinkedBlockingQueue();
        private boolean c = true;
        private Queue<C1020a> e = new LinkedBlockingQueue();

        public C1019a() {
        }

        private C1020a a(int i, com.bytedance.sdk.openadsdk.j.f.b bVar) {
            b();
            u.b("VideoCachePreloader", "pool: " + this.d.size());
            C1020a poll = this.d.poll();
            if (poll == null) {
                poll = new C1020a();
            }
            poll.f7276a = i;
            poll.f = bVar;
            return poll;
        }

        private void a(C1020a c1020a) {
            a();
            c1020a.c = null;
            c1020a.f7277b = null;
            c1020a.f7276a = -1;
            c1020a.f = null;
            this.d.offer(c1020a);
        }

        private synchronized void b(C1020a c1020a) {
            b();
            this.e.add(c1020a);
            notify();
        }

        private void a() {
        }

        private void b() {
        }

        private void c(C1020a c1020a) {
            a();
            if (c1020a != null) {
                this.f7275b.offer(c1020a);
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
                    while (!this.f7275b.isEmpty()) {
                        C1020a poll = this.f7275b.poll();
                        if (poll != null) {
                            switch (poll.f7276a) {
                                case 0:
                                    if (poll.c != null && poll.c.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : poll.c) {
                                            if (com.bytedance.sdk.openadsdk.j.g.d.a(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        d.c().a(false, !TextUtils.isEmpty(poll.e), poll.d, poll.f7277b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                        break;
                                    }
                                    break;
                                case 1:
                                    d.c().a(poll.f7277b);
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
                C1020a poll = this.e.poll();
                if (poll != null) {
                    poll.f7277b = poll.f.f7279a;
                    poll.c = new String[]{poll.f.f7279a};
                    poll.d = poll.f.f7280b;
                    poll.e = poll.f.c;
                    if (!TextUtils.isEmpty(poll.f.c)) {
                        poll.f7277b = poll.f.c;
                    }
                    poll.f = null;
                    c(poll);
                } else {
                    return;
                }
            }
        }

        public void a(com.bytedance.sdk.openadsdk.j.f.b bVar) {
            b(a(0, bVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1020a {

            /* renamed from: a  reason: collision with root package name */
            public int f7276a;

            /* renamed from: b  reason: collision with root package name */
            public String f7277b;
            public String[] c;
            public int d;
            public String e;
            public com.bytedance.sdk.openadsdk.j.f.b f;

            public C1020a() {
            }
        }
    }
}
