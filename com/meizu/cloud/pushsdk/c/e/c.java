package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f57304b;

    /* renamed from: c  reason: collision with root package name */
    public b f57305c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f57306d;

    /* renamed from: e  reason: collision with root package name */
    public String f57307e;

    /* renamed from: f  reason: collision with root package name */
    public String f57308f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57309g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f57310h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57311i;

    /* renamed from: j  reason: collision with root package name */
    public long f57312j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes8.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57313b;

        /* renamed from: c  reason: collision with root package name */
        public final String f57314c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f57315d;

        /* renamed from: e  reason: collision with root package name */
        public b f57316e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57317f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f57318g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57319h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f57320i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f57321j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f57313b = str;
            this.f57314c = str2;
            this.f57315d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f57316e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f57318g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f57317f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f57304b = aVar.a;
        this.f57308f = aVar.f57314c;
        this.f57309g = aVar.f57317f;
        this.f57307e = aVar.f57313b;
        this.f57305c = aVar.f57316e;
        this.f57310h = aVar.f57318g;
        this.f57311i = aVar.f57319h;
        this.f57312j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f57311i) {
            this.f57306d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f57320i, aVar.f57321j, aVar.m, aVar.f57315d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f57318g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f57311i) {
            list.add(this.f57306d.a());
        }
        b bVar = this.f57305c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f57305c.a()));
            }
            if (!this.f57305c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f57305c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f57305c != null) {
            cVar.a(new HashMap(this.f57305c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f57304b.a(cVar, z);
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
        this.f57305c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f57304b;
    }
}
