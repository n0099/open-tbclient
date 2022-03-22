package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.baidu.swan.apps.core.container.NgWebView;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f42133b;

    /* renamed from: c  reason: collision with root package name */
    public b f42134c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f42135d;

    /* renamed from: e  reason: collision with root package name */
    public String f42136e;

    /* renamed from: f  reason: collision with root package name */
    public String f42137f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42138g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f42139h;
    public boolean i;
    public long j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes7.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42140b;

        /* renamed from: c  reason: collision with root package name */
        public final String f42141c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f42142d;

        /* renamed from: e  reason: collision with root package name */
        public b f42143e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f42144f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f42145g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f42146h = false;
        public long i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f42140b = str;
            this.f42141c = str2;
            this.f42142d = context;
            this.n = cls;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(b bVar) {
            this.f42143e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f42145g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f42144f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f42133b = aVar.a;
        this.f42137f = aVar.f42141c;
        this.f42138g = aVar.f42144f;
        this.f42136e = aVar.f42140b;
        this.f42134c = aVar.f42143e;
        this.f42139h = aVar.f42145g;
        this.i = aVar.f42146h;
        this.j = aVar.k;
        int i = aVar.l;
        this.k = i < 2 ? 2 : i;
        this.l = aVar.m;
        if (this.i) {
            this.f42135d = new com.meizu.cloud.pushsdk.c.e.a(aVar.i, aVar.j, aVar.m, aVar.f42142d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f42145g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.i) {
            list.add(this.f42135d.a());
        }
        b bVar = this.f42134c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b(NgWebView.APP_GEO_PATH, this.f42134c.a()));
            }
            if (!this.f42134c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f42134c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f42134c != null) {
            cVar.a(new HashMap(this.f42134c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f42133b.a(cVar, z);
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
        this.f42134c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f42133b;
    }
}
