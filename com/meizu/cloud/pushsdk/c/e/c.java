package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.baidu.swan.apps.core.container.NgWebView;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class c {
    public static final String n = "c";
    public com.meizu.cloud.pushsdk.c.b.c b;
    public b c;
    public com.meizu.cloud.pushsdk.c.e.a d;
    public String e;
    public String f;
    public boolean g;
    public com.meizu.cloud.pushsdk.c.f.b h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes8.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;
        public final String b;
        public final String c;
        public final Context d;
        public b e = null;
        public boolean f = false;
        public com.meizu.cloud.pushsdk.c.f.b g = com.meizu.cloud.pushsdk.c.f.b.OFF;
        public boolean h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.b = aVar.a;
        this.f = aVar.c;
        this.g = aVar.f;
        this.e = aVar.b;
        this.c = aVar.e;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        b bVar = this.c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b(NgWebView.APP_GEO_PATH, this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.c != null) {
            cVar.a(new HashMap(this.c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.c.c.b bVar, boolean z) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.b;
    }
}
