package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f37441b;

    /* renamed from: c  reason: collision with root package name */
    public b f37442c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f37443d;

    /* renamed from: e  reason: collision with root package name */
    public String f37444e;

    /* renamed from: f  reason: collision with root package name */
    public String f37445f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37446g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f37447h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37448i;
    public long j;
    public int k;
    public TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    public final String f37440a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.c.b.c f37449a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37450b;

        /* renamed from: c  reason: collision with root package name */
        public final String f37451c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f37452d;

        /* renamed from: e  reason: collision with root package name */
        public b f37453e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37454f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f37455g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37456h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f37457i = 600;
        public long j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.f37449a = cVar;
            this.f37450b = str;
            this.f37451c = str2;
            this.f37452d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f37453e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f37455g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f37454f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f37441b = aVar.f37449a;
        this.f37445f = aVar.f37451c;
        this.f37446g = aVar.f37454f;
        this.f37444e = aVar.f37450b;
        this.f37442c = aVar.f37453e;
        this.f37447h = aVar.f37455g;
        this.f37448i = aVar.f37456h;
        this.j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f37448i) {
            this.f37443d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f37457i, aVar.j, aVar.m, aVar.f37452d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f37455g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f37448i) {
            list.add(this.f37443d.a());
        }
        b bVar = this.f37442c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f37442c.a()));
            }
            if (!this.f37442c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f37442c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f37442c != null) {
            cVar.a(new HashMap(this.f37442c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f37441b.a(cVar, z);
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
        this.f37442c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f37441b;
    }
}
