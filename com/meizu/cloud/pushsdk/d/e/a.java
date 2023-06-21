package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.baidu.swan.apps.core.container.NgWebView;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public abstract class a {
    public static final String n = "a";
    public com.meizu.cloud.pushsdk.d.b.a b;
    public c c;
    public b d;
    public final String e;
    public final String f;
    public final boolean g;
    public final com.meizu.cloud.pushsdk.d.f.b h;
    public final boolean i;
    public final long j;
    public final int k;
    public final TimeUnit l;
    public final String a = PushManager.TAG;
    public final AtomicBoolean m = new AtomicBoolean(true);

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0706a {
        public final com.meizu.cloud.pushsdk.d.b.a a;
        public final String b;
        public final String c;
        public final Context d;
        public c e = null;
        public boolean f = false;
        public com.meizu.cloud.pushsdk.d.f.b g = com.meizu.cloud.pushsdk.d.f.b.OFF;
        public boolean h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;

        public C0706a(com.meizu.cloud.pushsdk.d.b.a aVar, String str, String str2, Context context, Class<? extends a> cls) {
            this.a = aVar;
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        public C0706a a(int i) {
            this.l = i;
            return this;
        }

        public C0706a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public C0706a a(com.meizu.cloud.pushsdk.d.f.b bVar) {
            this.g = bVar;
            return this;
        }

        public C0706a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public a(C0706a c0706a) {
        this.b = c0706a.a;
        this.f = c0706a.c;
        this.g = c0706a.f;
        this.e = c0706a.b;
        this.c = c0706a.e;
        this.h = c0706a.g;
        this.i = c0706a.h;
        this.j = c0706a.k;
        int i = c0706a.l;
        this.k = i < 2 ? 2 : i;
        this.l = c0706a.m;
        if (this.i) {
            this.d = new b(c0706a.i, c0706a.j, c0706a.m, c0706a.d);
        }
        com.meizu.cloud.pushsdk.d.f.c.a(c0706a.g);
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.d.a.b a(List<com.meizu.cloud.pushsdk.d.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        c cVar = this.c;
        if (cVar != null) {
            if (!cVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b(NgWebView.APP_GEO_PATH, this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("mobileinfo", this.c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.d.a.b bVar : list) {
            linkedList.add(bVar.a());
        }
        return new com.meizu.cloud.pushsdk.d.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.d.a.c cVar, List<com.meizu.cloud.pushsdk.d.a.b> list, boolean z) {
        if (this.c != null) {
            cVar.a(new HashMap(this.c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public com.meizu.cloud.pushsdk.d.b.a b() {
        return this.b;
    }
}
