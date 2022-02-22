package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public abstract class c {
    public static final String n = "c";

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.b.c f58954b;

    /* renamed from: c  reason: collision with root package name */
    public b f58955c;

    /* renamed from: d  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.e.a f58956d;

    /* renamed from: e  reason: collision with root package name */
    public String f58957e;

    /* renamed from: f  reason: collision with root package name */
    public String f58958f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58959g;

    /* renamed from: h  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.c.f.b f58960h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58961i;

    /* renamed from: j  reason: collision with root package name */
    public long f58962j;
    public int k;
    public TimeUnit l;
    public final String a = PushManager.TAG;
    public AtomicBoolean m = new AtomicBoolean(true);

    /* loaded from: classes4.dex */
    public static class a {
        public final com.meizu.cloud.pushsdk.c.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58963b;

        /* renamed from: c  reason: collision with root package name */
        public final String f58964c;

        /* renamed from: d  reason: collision with root package name */
        public final Context f58965d;

        /* renamed from: e  reason: collision with root package name */
        public b f58966e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f58967f = false;

        /* renamed from: g  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.c.f.b f58968g = com.meizu.cloud.pushsdk.c.f.b.OFF;

        /* renamed from: h  reason: collision with root package name */
        public boolean f58969h = false;

        /* renamed from: i  reason: collision with root package name */
        public long f58970i = 600;

        /* renamed from: j  reason: collision with root package name */
        public long f58971j = 300;
        public long k = 15;
        public int l = 10;
        public TimeUnit m = TimeUnit.SECONDS;
        public Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.c.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.f58963b = str;
            this.f58964c = str2;
            this.f58965d = context;
            this.n = cls;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a a(b bVar) {
            this.f58966e = bVar;
            return this;
        }

        public a a(com.meizu.cloud.pushsdk.c.f.b bVar) {
            this.f58968g = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f58967f = bool.booleanValue();
            return this;
        }
    }

    public c(a aVar) {
        this.f58954b = aVar.a;
        this.f58958f = aVar.f58964c;
        this.f58959g = aVar.f58967f;
        this.f58957e = aVar.f58963b;
        this.f58955c = aVar.f58966e;
        this.f58960h = aVar.f58968g;
        this.f58961i = aVar.f58969h;
        this.f58962j = aVar.k;
        int i2 = aVar.l;
        this.k = i2 < 2 ? 2 : i2;
        this.l = aVar.m;
        if (this.f58961i) {
            this.f58956d = new com.meizu.cloud.pushsdk.c.e.a(aVar.f58970i, aVar.f58971j, aVar.m, aVar.f58965d);
        }
        com.meizu.cloud.pushsdk.c.f.c.a(aVar.f58968g);
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.a.b a(List<com.meizu.cloud.pushsdk.c.a.b> list) {
        if (this.f58961i) {
            list.add(this.f58956d.a());
        }
        b bVar = this.f58955c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("geolocation", this.f58955c.a()));
            }
            if (!this.f58955c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.c.a.b("mobileinfo", this.f58955c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.c.a.b bVar2 : list) {
            linkedList.add(bVar2.a());
        }
        return new com.meizu.cloud.pushsdk.c.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.c.a.c cVar, List<com.meizu.cloud.pushsdk.c.a.b> list, boolean z) {
        if (this.f58955c != null) {
            cVar.a(new HashMap(this.f58955c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.c.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.f58954b.a(cVar, z);
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
        this.f58955c = bVar;
    }

    public com.meizu.cloud.pushsdk.c.b.c b() {
        return this.f58954b;
    }
}
